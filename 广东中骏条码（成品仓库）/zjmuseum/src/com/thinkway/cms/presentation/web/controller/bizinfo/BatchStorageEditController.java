package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

public class BatchStorageEditController implements Controller, AuthenticateController{
	private UserService userService = null;
	private String ViewName = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;
	
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<Object, Object> model = new HashMap<Object, Object>();
		String message = "";
		String loginUserId = request.getSession().getAttribute(
				SessionManager.USER_ID) == null ? null : 
				request.getSession().getAttribute(SessionManager.USER_ID).toString();
		String userName = "";
		if (loginUserId == null || loginUserId.equals("")) {
		} else {
			User loginUser = userService.getUser(loginUserId);
			model.put("loginUser", loginUser);
			userName = loginUser.getUserName();
		}
		//工厂
		String werks = SapUtil.null2String(request.getParameter("werks"));
		String bwlvs = SapUtil.null2String(request.getParameter("bwlvs"));
		//读取流水码
		String AZTMID = SapUtil.null2String(request.getParameter("AZTMID"));
		String BZTMID = SapUtil.null2String(request.getParameter("BZTMID"));
		String CZTMID = SapUtil.null2String(request.getParameter("CZTMID"));
		String DZTMID = SapUtil.null2String(request.getParameter("DZTMID"));
		String EZTMID = SapUtil.null2String(request.getParameter("EZTMID"));
		
		try{
			JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPcon();
		    myConnection.connect(); 
		    //out.println("连接SAP成功");
			String functionName="ZFM_BC_06_21";//批量过账
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList = bapi.getImportParameterList();//获得输入表的参数
			JCO.ParameterList   inputtable = bapi.getTableParameterList();//输入表的处理
			
			JCO.Table IT_ZTMID = inputtable.getTable("IT_ZTMID");
			
			parameterList.setValue(userName,"I_UID");//操作人
			parameterList.setValue(werks,"I_WERKS");//工厂
			
			//传入流水码
			IT_ZTMID.appendRow();
			IT_ZTMID.setValue(AZTMID, "ZTMID");
			if(!"".equals(BZTMID)){
				IT_ZTMID.appendRow();
				IT_ZTMID.setValue(BZTMID, "ZTMID");
			}
			if(!"".equals(CZTMID)){
				IT_ZTMID.appendRow();
				IT_ZTMID.setValue(CZTMID, "ZTMID");
			}
			if(!"".equals(DZTMID)){
				IT_ZTMID.appendRow();
				IT_ZTMID.setValue(DZTMID, "ZTMID");
			}
			if(!"".equals(EZTMID)){
				IT_ZTMID.appendRow();
				IT_ZTMID.setValue(EZTMID, "ZTMID");
			}
			
			myConnection.execute(bapi);
			
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			JCO.Table ET_ZTMID = outtab.getTable("ET_ZTMID");
			
			System.out.println("row = " + ET_ZTMID.getNumRows());
			List<Map> resultList = new ArrayList<Map>();
			for(int i = 0 ; i < ET_ZTMID.getNumRows() ; i ++){
				ET_ZTMID.setRow(i);
				String ZTMID = SapUtil.null2String(ET_ZTMID.getString("ZTMID"));//流水码
				String MATNR = SapUtil.null2String(ET_ZTMID.getString("MATNR"));//物料代码
				String ZSHSL = SapUtil.null2String(ET_ZTMID.getString("ZSHSL"));//收货数量
				String ZWLPZ = SapUtil.null2String(ET_ZTMID.getString("ZWLPZ"));//物料凭证号
				
				Map<String, String> map = new HashMap<String, String>();
				map.put("ZTMID", ZTMID);
				map.put("MATNR", MATNR);
				map.put("ZSHSL", ZSHSL);
				map.put("ZWLPZ", ZWLPZ);
				
				resultList.add(map);
			}
			model.put("resultList", resultList);
		}catch(Exception e){
			e.printStackTrace();
		}
		model.put("werks", werks);
		model.put("bwlvs", bwlvs);
		model.put("message", message);
		return new ModelAndView(getViewName(), model);
	}
	public String getTokenNeed() {
		// TODO Auto-generated method stub
		return tokenNeed;
	}
	public long getPermission() {
		// TODO Auto-generated method stub
		return permission;
	}
	public void setPermission(long permission) {
		// TODO Auto-generated method stub
		this.permission = permission;
	}
	public void setAuthenticator(Authenticator authenticator) {
		// TODO Auto-generated method stub
		this.authenticator = authenticator;
	}
	public Authenticator getAuthenticator() {
		// TODO Auto-generated method stub
		return authenticator;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getViewName() {
		return ViewName;
	}
	public void setViewName(String viewName) {
		ViewName = viewName;
	}
	public void setTokenNeed(String tokenNeed) {
		this.tokenNeed = tokenNeed;
	}
}
