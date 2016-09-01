package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.sql.Timestamp;
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
import org.springframework.web.servlet.view.RedirectView;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.Receipt;
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

public class LubuEditController implements Controller , AuthenticateController{
	
	private UserService userService = null;
	private String viewName = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;
	private Receipt receipt=new Receipt();
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

	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		System.out.println("start:"+SapUtil.getCurrentDateTime());
		Map<Object, Object> model = new HashMap<Object, Object>();	
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		User loginUser=null;
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String message="";	
		try{
		JCO.Client myConnection =null;
		myConnection =SapUtil.getSAPcon();
	    myConnection.connect(); 
		String functionName="ZFM_BC_13_23";//函数的名字
	    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
	    //從這個函數範本獲得該SAP函數的物件
	    JCO.Function bapi = ft.getFunction();
    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
		JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理

		String lgnum = SapUtil.null2String(request.getParameter("lgnum"));//仓库号
		String mblnr = SapUtil.null2String(request.getParameter("mblnr"));//物料凭证号
		String ubnum = SapUtil.null2String(request.getParameter("ubnum"));//记账变更号
		String wemng = SapUtil.null2String(request.getParameter("wemng"));//选择数量
		model.put("mblnr", mblnr);
		model.put("ubnum", ubnum);
		String row   = SapUtil.null2String(request.getParameter("row"));//选择记账变更行号
		System.out.println("++++++++ZFM_BC_13_23：记账变更下架行号："+row);
		String lqnum = SapUtil.null2String(request.getParameter("lqnum"+row));
		//传入字段
		parameterList.setValue(loginUser.getUserId(),"I_UID");					
		parameterList.setValue(ubnum,"I_UBNUM");
		parameterList.setValue(lgnum,"I_LGNUM");
		//传入表字段
		//JCO.Table  IT_ITEM=inputtable.getTable("IT_ITEM");
		//if(!aufnr.isEmpty()&&!iquan.isEmpty()&&!gmein.isEmpty()){
		//IT_ITEM.appendRow();
		JCO.Table IT_LUBQU = inputtable.getTable("IT_LUBQU");
		IT_LUBQU.appendRow();
		IT_LUBQU.setValue(lqnum,"LQNUM");//行项目号=（数量）
		IT_LUBQU.setValue(wemng,"MENGE");//记账变更数量
		
		myConnection.execute(bapi);
		
		JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
		JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
		
		JCO.Structure stu01 = outs.getStructure("ES_RETURN");
		String type=stu01.getString("MSGTY");
		message=stu01.getString("MESSAGE");
		String tanum=(outs.getValue("E_TANUM")+"");
		model.put("type", type);	
		if(null!=myConnection){
			SapUtil.releaseClient(myConnection);
		}
		System.out.println("type:"+type+"----message:"+message+"----mblnr:"+tanum);
		//}else{
			//message="必要信息不完整";
		//}
		}catch(Exception e){
			message=e.getMessage();
			e.printStackTrace();
		}
		
		model.put("message", message);
		System.out.println("end:"+SapUtil.getCurrentDateTime());
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

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}


}
