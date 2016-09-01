package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.thinkway.SapUtil;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class OutsourcingDController implements Controller, AuthenticateController {

	private UserService userService = null;
	private String viewName = null;
	private String msg = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

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

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//查询明细
		Map<Object, Object> models = new HashMap<Object, Object>();
			SAPRequest sapRequest = new SAPRequest("ZFM_BC_17_21");
			sapRequest.addParameter("I_UID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
			sapRequest.addParameter("I_PID", "" + request.getSession().getAttribute(SessionManager.USER_NAME));
			sapRequest.addParameter("I_WERKS", SapUtil.null2String(request.getParameter("factory")));
			sapRequest.addParameter("I_MATNR", SapUtil.null2String(request.getParameter("matnr")));
			sapRequest.addParameter("I_WEMNG", SapUtil.null2String(request.getParameter("sum")));
			sapRequest.addParameter("I_LGORT", SapUtil.null2String(request.getParameter("storageLocation")));
			sapRequest.addParameter("I_CHARG", SapUtil.null2String(request.getParameter("batch")));
			SAPModel model = SapUtil.OperSAP(sapRequest);
			models.put("msg", model.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
			if ("E".equals(model.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
				return new ModelAndView(getMsg(), models);
			} else {
				return new ModelAndView(getViewName(), models);
			}
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
