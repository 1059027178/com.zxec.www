package com.thinkway.cms.presentation.web.controller.delordpic;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletResponse;
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
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.DelLockUserService;
import com.thinkway.cms.business.service.iface.DelOrdPicService;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.controller.fix.IntegerEditor;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.presentation.web.form.UserForm;
import com.thinkway.cms.presentation.web.interceptors.BaseFormController;
import com.thinkway.cms.util.Escape;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.business.query.UserQuery;

public class MatLgpViewController implements Controller , AuthenticateController{
	private DelLockUserService dellockuserService = null;
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
		request.setCharacterEncoding("UTF-8");

		Map<Object, Object> model = new HashMap<Object, Object>();	
	String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		User user=null;
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			user = userService.getUser(loginUserId);			
			model.put("loginUser",user);			
		}	
		String vbeln=ParamUtils.getParameter(request, "vbeln","");//获取发货单号
		String matnr=ParamUtils.getParameter(request, "matnr","");//获取物料号 
		String maktx=ParamUtils.getParameter(request, "maktx","");//获取物料描述
		String posnr=ParamUtils.getParameter(request, "posnr","");//获取行项目号
		String lfimg=ParamUtils.getParameter(request, "lfimg","");//获取交货数量 
		String wadat=ParamUtils.getParameter(request, "wadat","");
		String lgort=ParamUtils.getParameter(request, "lgort","");
		String werks=ParamUtils.getParameter(request, "werks","");
		model.put("werks",werks);
		model.put("lgort",lgort);
		model.put("wadat",wadat);
		model.put("vbeln",vbeln);
		PaginatedListHelper paginaredList=new PaginatedListHelper();
		String currentPage=ParamUtils.getParameter(request, "page", "1");
		paginaredList.setObjectsPerPage(5);
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		

//	//从SAP获取交货单数量的值
	    List<DelOrdPic> iList = new ArrayList<DelOrdPic>();
	    List<DelOrdPic> matList = new ArrayList<DelOrdPic>();
	    
		DelOrdPic delord=new DelOrdPic();
		 delord.setPosnr(posnr); //行项目号 
	    delord.setVbeln(vbeln);//发货单号
	    delord.setMatnr(matnr); //物料号 
	    delord.setMaktx(maktx); //物料号 
	    delord.setLfimg(lfimg);//需求数量
	    model.put("delord", delord);
	    
	    JCO.Client myConnection =null;
		myConnection =SapUtil.getSAPcon();
	    myConnection.connect(); 
		String functionName="ZFM_BC_04_31";//函数的名字
	    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//	    //從這個函數範本獲得該SAP函數的物件
	    JCO.Function bapi = ft.getFunction();
    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//		JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
    	parameterList.setValue(matnr,"I_MATNR");//物料描述
    	parameterList.setValue(vbeln,"I_VBELN");//发货单号
    	parameterList.setValue(posnr,"I_POSNR");//行号
    	parameterList.setValue(user.getUserName(),"I_UID");//用户名字
    	
			myConnection.execute(bapi);
//			
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			JCO.Table  ET_LQUA=outtab.getTable("ET_LQUA");

			paginaredList.setFullListSize(ET_LQUA.getNumRows());
			int j=0;
			int pageNum=ET_LQUA.getNumRows()/3;
			if(ET_LQUA.getNumRows()%3>0){
				pageNum++;
			}
			 for (int i = (Integer.parseInt(currentPage)-1)*3; i < ET_LQUA.getNumRows(); i++) {
				 ET_LQUA.setRow(i);
				 	delord=new DelOrdPic();
				    delord.setXuhao(i+1+"");
				    delord.setLgpla(ET_LQUA.getString("LGPLA"));//仓位
				    delord.setCharg(ET_LQUA.getString("CHARG"));//批次
				    delord.setVerme(SapUtil.getDoubleValue(ET_LQUA.getString("VERME")));//数量
				    delord.setPlpos(ET_LQUA.getString("PLPOS"));//仓位位置
				    delord.setMeins(ET_LQUA.getString("MEINS"));//基本计量单位
				    delord.setLgnum(ET_LQUA.getString("SONUM"));
				    iList.add(delord);
				    j++;
				    if(j==3){
				    	break;
				    }
	            }
		double lfimg1=SapUtil.getDoubleValue(outs.getString("E_LEFT_QTY"));
		System.out.println("page:"+currentPage+"------------E_LEFT_QTY:"+outs.getString("E_LEFT_QTY"));
		if(null!=myConnection){
			SapUtil.releaseClient(myConnection);
		}
		paginaredList.setList(iList);
		model.put("delordList", iList);	
		model.put("code", j);
		model.put("verme", lfimg1);
		model.put("page", currentPage);
		model.put("pageNum", pageNum);
		if(null!=myConnection){
			SapUtil.releaseClient(myConnection);
		}
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

	public DelLockUserService getDellockuserService() {
		return dellockuserService;
	}

	public void setDellockuserService(DelLockUserService dellockuserService) {
		this.dellockuserService = dellockuserService;
	}


}
