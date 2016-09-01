package com.thinkway.cms.presentation.web.controller.user;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
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

/**
 * 
 * @author Matt
 *
 */
public class IndexLoginController implements Controller , AuthenticateController{
	
	UserService userService = null;
	private Authenticator authenticator = null;
	private long permission = 0L;

	private String successView = null;

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
	
	private String viewName = null;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		
		Map<Object, Object> model = new HashMap<Object, Object>();	
		//检查cookie是否过期
		Cookie[] cs = request.getCookies(); // 将适用目录下所有Cookie读入并存入cookies数组中
		if (cs != null) {
			for (int i = 0; i < cs.length; i++) {	
				if (cs[i].getName().equals("userLoginId")) {
					request.getSession().setAttribute(SessionManager.USER_ID, cs[i].getValue());
				}
				if (cs[i].getName().equals("userLoginBH")) {
					request.getSession().setAttribute(SessionManager.USER_BH, cs[i].getValue());
				}
				if (cs[i].getName().equals("userLoginName")) {
					request.getSession().setAttribute(SessionManager.USER_NAME, URLDecoder.decode(cs[i].getValue(),"UTF-8"));
				}
				
				if (cs[i].getName().equals("userLoginPwd")) {
					request.getSession().setAttribute(SessionManager.USER_PWD, cs[i].getValue());
				}
				
				if (cs[i].getName().equals("loginUserFuncs")) {
					request.getSession().setAttribute("loginUserFuncs", cs[i].getValue());
				}
			}
		}

		String referUrl=ParamUtils.getParameter(request, "referUrl", "");
		model.put("referUrl", referUrl);
		
		if(null!=request.getSession().getAttribute(SessionManager.USER_PWD)
		  &&null!=request.getSession().getAttribute(SessionManager.USER_BH)
		  &&null!=request.getSession().getAttribute(SessionManager.USER_NAME)
		  &&null!=request.getSession().getAttribute(SessionManager.USER_ID)
		){
			User chkUsr=new User();
			String usrId=request.getSession().getAttribute(SessionManager.USER_ID)+"";
			String usrBH=(String)request.getSession().getAttribute(SessionManager.USER_BH);
			String usrPwd=(String)request.getSession().getAttribute(SessionManager.USER_PWD);
			String usrName=(String)request.getSession().getAttribute(SessionManager.USER_NAME);
			chkUsr.setUserId(new Integer(usrId));
			chkUsr.setUserName(usrName);
			chkUsr.setUserPassword(usrPwd);
			chkUsr.setUserBH(usrBH);
			if(null!=userService.findUserForLogin(chkUsr)){
				return new ModelAndView(getSuccessView(),model);
			}
			
		}	
		
		return new ModelAndView(getViewName(),model);
		
	}

	public String getViewName() {
		return viewName;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}

}
