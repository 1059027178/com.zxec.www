package com.thinkway.cms.presentation.web.controller.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;

/**
 * 
 * @author Matt
 *
 */
public class UserLogoutController implements Controller,AuthenticateController {
	
	UserService userService = null;
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
	
	private String viewName = null;

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Cookie[] cookies=request.getCookies(); 
		try 
		{ 
		     for(int i=0;i<cookies.length;i++)   
		     { 
		    	 Cookie _cookie = new Cookie("companycode", null);
					_cookie.setMaxAge(0); // 设置Cookie的存活时间为15天
					response.addCookie(_cookie); // 写入客户端硬盘
					
					Cookie _idcookie = new Cookie("userLoginId", null);
					_idcookie.setMaxAge(0);
					response.addCookie(_idcookie);// 写入客户端硬盘
					
					Cookie _bhcookie = new Cookie("userLoginBH", null);
					_bhcookie.setMaxAge(0);
					response.addCookie(_bhcookie);// 写入客户端硬盘
					
					Cookie _namecookie = new Cookie("userLoginName", null);
					_namecookie.setMaxAge(0);
					response.addCookie(_namecookie);// 写入客户端硬盘
					
					Cookie _pwdcookie = new Cookie("userLoginPwd", null);
					_pwdcookie.setMaxAge(0);
					response.addCookie(_pwdcookie);// 写入客户端硬盘 
					
					Cookie _funcscookie = new Cookie("loginUserFuncs", null);
					_funcscookie.setMaxAge(0);
					response.addCookie(_funcscookie);// 写入客户端硬盘 
		     } 
		}catch(Exception ex) 
		{ 
		     //out.println("清空Cookies发生异常！"); 
		} 


		
		SessionManager.invalidate(request.getSession());		
		
		return new ModelAndView(getViewName());
	}

	public String getViewName() {
		return viewName;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

}
