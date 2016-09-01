package com.thinkway.cms.presentation.web.controller.stoquy;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.DelOrdPic;
import com.thinkway.cms.business.domains.Sto;
import com.thinkway.cms.business.domains.Delivery;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.DeliveryService;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.controller.fix.IntegerEditor;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.Escape;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.business.query.UserQuery;

public class StoQuyListController implements Controller , AuthenticateController{
	private UserService userService = null;
	private String viewName = null;
	private String matnrviewName = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;
	public String getTokenNeed() {
		return tokenNeed;
	}

	public void setTokenNeed(String tokenNeed) {
		this.tokenNeed = tokenNeed;
	}
	public long getPermission() {
		return permission;
	}

	public void setPermission(long permission) {
		this.permission = permission;
	}

	public Authenticator getAuthenticator() {
		return authenticator;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	

	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<Object, Object> model = new HashMap<Object, Object>();	
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		User user = null;
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			user = userService.getUser(loginUserId);			
			model.put("loginUser",user);			
		}	
		String werks=ParamUtils.getParameter(request, "werks","");//工厂
		String lgort=ParamUtils.getParameter(request, "lgort","");//库存地点
		String matnr=ParamUtils.getParameter(request, "matnr","");//物料编码
		String charg=ParamUtils.getParameter(request, "charg","");//批次
		String pici=ParamUtils.getParameter(request, "pici","");//是否按批查询
		String maktx="";//物料描述
		PaginatedListHelper paginaredList=new PaginatedListHelper();
		String currentPage=ParamUtils.getParameter(request, "page", "1");
		paginaredList.setObjectsPerPage(5);
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		//System.out.println("matnr:"+matnr);

//	//从SAP获取交货单数量的值
	    List<Sto> iList = new ArrayList<Sto>();
	    List<Sto> stoList = new ArrayList<Sto>();
	 	Sto sto1=new Sto();
		int pageNum=0;
			if(pici.equals("")){
				//不按批次查询
				 JCO.Client myConnection =null;
					myConnection =SapUtil.getSAPcon();
				    myConnection.connect();
					String functionName="ZFM_BC_11_11";//函数的名字
				    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
				    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//				    //從這個函數範本獲得該SAP函數的物件
				    JCO.Function bapi = ft.getFunction();
			    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//					JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
			    	parameterList.setValue(matnr,"I_MATNR");//物料编码
			    	parameterList.setValue(lgort,"I_LGORT");//库存地点
			    	parameterList.setValue(werks,"I_WERKS");//工厂
			    	parameterList.setValue(user.getUserName(),"I_UID");//用户名字
			    	
						myConnection.execute(bapi);
//						
						JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
						JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
						JCO.Table  ET_MARD=outtab.getTable("ET_MARD");

						paginaredList.setFullListSize(ET_MARD.getNumRows());
						pageNum=ET_MARD.getNumRows()/2;
						if(ET_MARD.getNumRows()%2>0){
							pageNum++;
						}
						int j=0;
							 for (int i = (Integer.parseInt(currentPage)-1)*2; i < ET_MARD.getNumRows(); i++) {
							 	ET_MARD.setRow(i);
							 	maktx=ET_MARD.getString("MAKTX");//物料描述
							 	Sto sto=new Sto();
								sto.setMatnr(ET_MARD.getString("MATNR"));//物料号
								sto.setMaktx(ET_MARD.getString("MAKTX"));//物料描述
							 	sto.setLabst(ET_MARD.getString("LABST"));//库存数量
							 	sto.setMeins(ET_MARD.getString("MEINS"));//单位
							 	sto.setSobkz(ET_MARD.getString("SOBKZ"));//特殊库存标识
							 	sto.setSonum(ET_MARD.getString("SONUM"));//特殊库存
							 	sto.setVerme("");//数量
							 	sto.setCharg("");//批次
							    iList.add(sto);
							    j++;
							    if(j==2){
							    	break;
							    }
				            }
					
					paginaredList.setList(iList);
					if(null!=myConnection){
						SapUtil.releaseClient(myConnection);
					}
			}else{
				//按批次查询
				
				 JCO.Client myConnection =null;
					myConnection =SapUtil.getSAPcon();
				    myConnection.connect(); 
					String functionName="ZFM_BC_11_12";//函数的名字
				    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
				    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//				    //從這個函數範本獲得該SAP函數的物件
				    JCO.Function bapi = ft.getFunction();
			    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//					JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
			    	parameterList.setValue(matnr,"I_MATNR");//物料编码
			    	parameterList.setValue(lgort,"I_LGORT");//库存地点
			    	parameterList.setValue(werks,"I_WERKS");//工厂
			    	parameterList.setValue(charg,"I_CHARG");//批次
			    	parameterList.setValue(user.getUserName(),"I_UID");//用户名字
						myConnection.execute(bapi);
//						
						JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
						JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
						JCO.Table  ET_LQUA=outtab.getTable("ET_LQUA");

					    
						paginaredList.setFullListSize(ET_LQUA.getNumRows());
						pageNum=ET_LQUA.getNumRows()/2;
						if(ET_LQUA.getNumRows()%2>0){
							pageNum++;
						}
						int j=0;
						 for (int i = (Integer.parseInt(currentPage)-1)*2; i < ET_LQUA.getNumRows(); i++) {
							 	ET_LQUA.setRow(i);
							 	Sto sto=new Sto();
							 	sto.setMatnr(ET_LQUA.getString("MATNR"));//物料号
								sto.setMaktx(ET_LQUA.getString("MAKTX"));//物料描述
								maktx=ET_LQUA.getString("MAKTX");
							 	sto.setLgpla(ET_LQUA.getString("LGPLA"));//仓位
							 	sto.setCharg(ET_LQUA.getString("CHARG"));//批次
							 	sto.setVerme(ET_LQUA.getString("VERME"));//数量
							 	sto.setSobkz(ET_LQUA.getString("SOBKZ"));//特殊库存标识
							 	sto.setSonum(ET_LQUA.getString("SONUM"));//特殊库存
							 	sto.setMeins(ET_LQUA.getString("MEINS"));//单位
							 	sto.setLabst("");//库存数量
							    iList.add(sto);
							    j++;
							    if(j==2){
							    	break;
							    }
				            }
					paginaredList.setList(iList);
					if(null!=myConnection){
						SapUtil.releaseClient(myConnection);
					}
					
			}
			model.put("stoList", iList);
			model.put("page", currentPage);
			model.put("pageNum", pageNum);
			model.put("werks", werks);
			model.put("lgort", lgort);
			model.put("matnr", matnr);
			model.put("charg", charg);
			model.put("pici", pici);
			if(matnr.equals("")){	
				return new ModelAndView(getViewName(),model);
			}else{
				model.put("maktx", maktx); //物料描述
				return new ModelAndView(getMatnrviewName(),model);
			}
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}



	public String getMatnrviewName() {
		return matnrviewName;
	}

	public void setMatnrviewName(String matnrviewName) {
		this.matnrviewName = matnrviewName;
	}

	public UserService getUserService() {
		return userService;
	}


}
