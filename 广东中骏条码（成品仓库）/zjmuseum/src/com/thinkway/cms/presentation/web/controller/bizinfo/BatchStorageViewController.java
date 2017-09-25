package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;

public class BatchStorageViewController implements Controller, AuthenticateController {
	private UserService userService = null;
	private String ViewName = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;

	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<Object, Object> model = new HashMap<Object, Object>();
		String message = "";
		String loginUserId = request.getSession().getAttribute(
				SessionManager.USER_ID) == null ? null : 
				request.getSession().getAttribute(SessionManager.USER_ID).toString();
		if (loginUserId == null || loginUserId.equals("")) {
			// insert code here
		} else {
			User loginUser = userService.getUser(loginUserId);
			model.put("loginUser", loginUser);
		}
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
