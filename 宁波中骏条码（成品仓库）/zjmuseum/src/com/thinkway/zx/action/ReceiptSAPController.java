package com.thinkway.zx.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;

public class ReceiptSAPController implements Controller{
	private String viewName;
	private String tokenNeed = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private UserService userService = null;
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<Object, Object> model = new HashMap<Object, Object>();	
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			User loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String aufnr = SapUtil.null2String(request.getParameter("aufnr"));//生产订单号
		String matnr = SapUtil.null2String(request.getParameter("iquan"));//物料编码
		String wemng = SapUtil.null2String(request.getParameter("wemng"));//总数量
		String meng = SapUtil.null2String(request.getParameter("meng"));//尾箱箱数
		String charg = SapUtil.null2String(request.getParameter("charg"));//批次号
		String sobkz = SapUtil.null2String(request.getParameter("sobkz"));//特殊库存标识
		String lgort = SapUtil.null2String(request.getParameter("lgort"));//库存地点
		String meins = SapUtil.null2String(request.getParameter("meins"));
		//String aufnr = SapUtil.null2String(request.getParameter("aufnr"));
		String message="";	
		try{
		//out.println(aufnr+"/"+iquan+"/"+gmein);
		JCO.Client myConnection =null;
		myConnection =SapUtil.getSAPcon();
	    myConnection.connect(); 
	    //out.println("连接SAP成功");
		String functionName="ZFM_BC_01_11";//函数的名字
	    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
	    //從這個函數範本獲得該SAP函數的物件
	    JCO.Function bapi = ft.getFunction();
    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
		JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
		
		//JCO.Table  IT_ITEM=inputtable.getTable("IT_ITEM");
		//if(!aufnr.isEmpty()&&!iquan.isEmpty()&&!gmein.isEmpty()){
		//IT_ITEM.appendRow();		
		parameterList.setValue("EE","I_UID");			
		//parameterList.setValue(aufnr,"I_AUFNR");					
		parameterList.setValue(aufnr,"I_AUFNR");
		parameterList.setValue(wemng,"I_WEMNG");
		parameterList.setValue(charg,"I_CHARG");
		parameterList.setValue(sobkz,"I_SOBKZ");
		parameterList.setValue(lgort,"I_LGORT");
		parameterList.setValue(meins,"I_MEINS");
		
		myConnection.execute(bapi);
		
		JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
		JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
		
		
		JCO.Structure stu01 = outs.getStructure("ES_RETURN");
		String type=stu01.getString("MSGTY");
		message=stu01.getString("MESSAGE");
		String mblnr=(outs.getValue("E_MBLNR")+"");
			
		System.out.println("type:"+type+"----message:"+message+"----mblnr:"+mblnr);
		//}else{
			//message="必要信息不完整";
		//}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return new ModelAndView(getViewName(),model);
	}
	public String getViewName() {
		return viewName;
	}
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public String getTokenNeed() {
		return tokenNeed;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public void setTokenNeed(String tokenNeed) {
		this.tokenNeed = tokenNeed;
	}
	public Authenticator getAuthenticator() {
		return authenticator;
	}
	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	public long getPermission() {
		return permission;
	}
	public void setPermission(long permission) {
		this.permission = permission;
	}

}
