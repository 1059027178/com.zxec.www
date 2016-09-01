package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.ParamUtils;

public class DeliveryController implements Controller, AuthenticateController {

	private UserService userService = null;
	private String viewName = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;
	private String view1 = null;
	private String view2 = null;
	private String view3 = null;
	private String view4 = null;

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
		// TODO Auto-generated method stub
		Map<Object, Object> model = new HashMap<Object, Object>();
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID) == null ? null : request
				.getSession().getAttribute(SessionManager.USER_ID).toString();
		User user = null;
		if (loginUserId == null || loginUserId.equals("")) {
			//insert code here
		} else {
			User loginUser = userService.getUser(loginUserId);
			model.put("loginUser", loginUser);
		}
		int functionType = ParamUtils.getIntParameter(request, "functionType", 0);
		switch (functionType) {
		case 1: {
			return new ModelAndView(getView1(), model);
		}
		case 2: {
			return new ModelAndView(getView2(), model);
		}
		case 3: {
			return new ModelAndView(getView3(), model);
		}
		case 4: {
			return new ModelAndView(getView4(), model);
		}
		default: {

		}
		}
		return null;

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

	public String getView1() {
		return view1;
	}

	public void setView1(String view1) {
		this.view1 = view1;
	}

	public String getView2() {
		return view2;
	}

	public void setView2(String view2) {
		this.view2 = view2;
	}

	public String getView3() {
		return view3;
	}

	public void setView3(String view3) {
		this.view3 = view3;
	}

	public String getView4() {
		return view4;
	}

	public void setView4(String view4) {
		this.view4 = view4;
	}

}
