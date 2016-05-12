package com.thinkway.cms.presentation.web.interceptors;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.Token;

/**
 * 在用户访问受保护资源时进行拦截, 并作出处理
 * 
 * @author Matt
 *
 */
public class SecureInterceptor extends HandlerInterceptorAdapter {
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	throws Exception {
		boolean retVal = true;
		//判断是否有足够的权限去访问对应的功能页	
		if (handler instanceof AuthenticateController) {
			AuthenticateController pCrtl = (AuthenticateController) handler;
			
			
			
			//tokenNeed的值为Y,则说明该controller需要进行TOKEN验证
			if(pCrtl.getTokenNeed().equals("Y")){
				if(!Token.isTokenStringValid(request.getParameter(Token.TOKEN_STRING_NAME), request.getSession())){//TOKEN验证不通过
					retVal = false;
					response.sendRedirect("/errorHandle.do?errcode=E003");
					return retVal;
				}
			}
			
			String extPm=""+pCrtl.getPermission();
			//901--是不需要登录也可以访问的页面
			if(extPm.equals("901")){
				return retVal;	
			}
			
			//如果没有登录那么自动跳转到登录页面
			if(request.getSession().getAttribute(SessionManager.USER_ID)==null){
				response.sendRedirect("/index.do");
				return false;
			}
			
			//从数据库中找出用户真实的权限
			String actPm=pCrtl.getAuthenticator().loadPermissions(""+request.getSession().getAttribute(SessionManager.USER_ID));
			
			if(!pCrtl.getAuthenticator().hasPermission(extPm, actPm)){  
				retVal = false;
				response.sendRedirect("/errorHandle.do?errcode=E002");
				return retVal;
			}	
		}
		return retVal;
	}
	
	public void postHandle(   
            HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)   
            throws Exception {   
    }   

	
}
