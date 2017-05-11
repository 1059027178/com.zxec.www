package com.thinkway.cms.presentation.web.controller.matquy;

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
import com.thinkway.cms.business.domains.Mat;
import com.thinkway.cms.business.domains.Delivery;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.DelOrdPicService;
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

public class MatQuyListController implements Controller , AuthenticateController{
	private UserService userService = null;
	private String viewName = null;
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
		String matnr=ParamUtils.getParameter(request, "matnr","");//物料编码
		String lgort=ParamUtils.getParameter(request, "lgort","");//库存地点
		String charg=ParamUtils.getParameter(request, "charg","");//批次
		String werks=ParamUtils.getParameter(request, "werks","");//工厂
		PaginatedListHelper paginaredList=new PaginatedListHelper();
		String currentPage=ParamUtils.getParameter(request, "page", "1");
		paginaredList.setObjectsPerPage(5);
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		

//	//从SAP获取交货单数量的值
	    List<Mat> iList = new ArrayList<Mat>();
	    List<Mat> matList = new ArrayList<Mat>();
	    
	    Mat mat=new Mat();
	    mat.setMatnr(matnr); //物料号 
	    matList.add(mat);
	    
		 JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPcon();
		    myConnection.connect(); 
			String functionName="ZFM_BC_09_11";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
	    	parameterList.setValue(matnr,"I_MATNR");//物料编码
	    	parameterList.setValue(lgort,"I_LGORT");//库存地点 
	    	parameterList.setValue(charg,"I_CHARG");//仓位 
	    	parameterList.setValue(werks,"I_WERKS");//工厂
	    	parameterList.setValue(user.getUserName(),"I_UID");//用户名字
				myConnection.execute(bapi);
//				
				JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
				JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
				JCO.Table  ET_LQUA=outtab.getTable("ET_LQUA");
				int pageNum=ET_LQUA.getNumRows()/5;
				if(ET_LQUA.getNumRows()%5>0){
					pageNum++;
				}
				paginaredList.setFullListSize(ET_LQUA.getNumRows());
				int j=0;
				 for (int i = (Integer.parseInt(currentPage)-1)*5; i < ET_LQUA.getNumRows(); i++) {
					 	ET_LQUA.setRow(i);
					 	mat=new Mat();
					 	mat.setXuhao(i+1+"");
					 	mat.setCharg(ET_LQUA.getString("CHARG"));//批次
					 	mat.setLgpla(ET_LQUA.getString("LGPLA"));//仓位
					 	mat.setSobkz(ET_LQUA.getString("SOBKZ"));//特殊标识
					 	mat.setLgort(ET_LQUA.getString("LGORT"));//库存地点
					 	mat.setVerme(ET_LQUA.getString("VERME"));//数量
					 	mat.setMeins(ET_LQUA.getString("MEINS"));//单位
					    iList.add(mat);
					    j++;
					    if(j==5){
					    	break;
					    }
		            }
		   
					if(null!=myConnection){
						SapUtil.releaseClient(myConnection);
					}
			paginaredList.setList(iList);
			model.put("matList", iList);	
			model.put("page", currentPage);
			model.put("pageNum", pageNum);
			model.put("mat", matList);	
			model.put("matnr", matnr);
			model.put("lgort", lgort);
			model.put("charg", charg);
			model.put("werks", werks);
		return new ModelAndView(getViewName(),model);
		
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public UserService getUserService() {
		return userService;
	}


}
