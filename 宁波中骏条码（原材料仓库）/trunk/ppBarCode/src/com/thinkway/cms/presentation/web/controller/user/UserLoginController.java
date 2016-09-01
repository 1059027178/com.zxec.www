package com.thinkway.cms.presentation.web.controller.user;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.UserLog;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.util.StringEncDec;

/**
 * 用户登陆控制器
 * 
 * @author matt.shen
 * 
 */
public class UserLoginController implements Controller,AuthenticateController {

	UserService userService = null;
	 private String successView = null;
	 private String failureView = null;
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
		public String getFailureView() {
			return failureView;
		}

		public void setFailureView(String failureView) {
			this.failureView = failureView;
		}
		
	

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
    public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {		
		Map<String,String> result = new HashMap<String, String>();
		
		String remUser=ParamUtils.getParameter(request, "remUser", "");
		String userBH=ParamUtils.getParameter(request, "userBH", "");
		String password=ParamUtils.getParameter(request, "password", "");
		String ckCode=ParamUtils.getParameter(request, "ckCode", "");
		
		String referUrl=ParamUtils.getParameter(request, "referUrl", "");
		
		User loginUser = new User();
		if(userBH.equals("")){
			String errorMsg = "员工代号不能为空！";
			result.put(ResultConstants.PAGE_TITLE, "用户登录");
			result.put(ResultConstants.PAGE_MSG, "用户登录失败!"+errorMsg);
			result.put(ResultConstants.PAGE_FROM_URL, "/");
			result.put(ResultConstants.PAGE_GO_URL, "/");
			return new ModelAndView(getFailureView(),result);
		}
		loginUser.setUserBH(userBH);
		if(password.equals("")){
			String errorMsg = "密码不能为空！";
			result.put(ResultConstants.PAGE_TITLE, "用户登录");
			result.put(ResultConstants.PAGE_MSG, "用户登录失败!"+errorMsg);
			result.put(ResultConstants.PAGE_FROM_URL, "/");
			result.put(ResultConstants.PAGE_GO_URL, "/");
			return new ModelAndView(getFailureView(),result);
		}
		loginUser.setUserPassword(password);
		/*
		String rcode = (String)request.getSession().getAttribute("rand");
		if(!ckCode.equals("")){
			if(!ckCode.equals(rcode)){
				String errorMsg = "验证码错误！";
				result.put(ResultConstants.PAGE_TITLE, "用户登录");
				result.put(ResultConstants.PAGE_MSG, "用户登录失败!"+errorMsg);
				result.put(ResultConstants.PAGE_FROM_URL, "/");
				result.put(ResultConstants.PAGE_GO_URL, "/");
				return new ModelAndView(getFailureView(),result);
			}
		}else{
			String errorMsg = "验证码必须填写！";
			result.put(ResultConstants.PAGE_TITLE, "用户登录");
			result.put(ResultConstants.PAGE_MSG, "用户登录失败!"+errorMsg);
			result.put(ResultConstants.PAGE_FROM_URL, "/");
			result.put(ResultConstants.PAGE_GO_URL, "/");
			return new ModelAndView(getFailureView(),result);
		}
		*/
		User user = userService.findUserForLogin(loginUser);
		
		
		if (user != null) { // 登陆成功
			SessionManager.invalidate(request.getSession());	
			request.getSession().setAttribute(SessionManager.USER_ID, user.getUserId());
			request.getSession().setAttribute(SessionManager.USER_BH, user.getUserBH());
			request.getSession().setAttribute(SessionManager.USER_NAME, user.getUserName());
			request.getSession().setAttribute(SessionManager.USER_PWD, user.getUserPassword());
			
			request.getSession().setAttribute("loginUserFuncs", user.getUserFunction());
			
			//公司权限定制
			if(remUser.equals("yes")){
				
				Cookie _idcookie = new Cookie("userLoginId", ""+user.getUserId());
				_idcookie.setMaxAge(15 * 24 * 60 * 60);
				response.addCookie(_idcookie);// 写入客户端硬盘
				
				Cookie _bhcookie = new Cookie("userLoginBH", ""+user.getUserBH());
				_bhcookie.setMaxAge(15 * 24 * 60 * 60);
				response.addCookie(_bhcookie);// 写入客户端硬盘
				
				Cookie _namecookie = new Cookie("userLoginName", URLEncoder.encode(user.getUserName(), "UTF-8"));
				_namecookie.setMaxAge(15 * 24 * 60 * 60);
				response.addCookie(_namecookie);// 写入客户端硬盘
				
				Cookie _pwdcookie = new Cookie("userLoginPwd", user.getUserPassword());
				_pwdcookie.setMaxAge(15 * 24 * 60 * 60);
				response.addCookie(_pwdcookie);// 写入客户端硬盘
				
				Cookie _funcscookie = new Cookie("loginUserFuncs", user.getUserFunction());
				_funcscookie.setMaxAge(15 * 24 * 60 * 60);
				response.addCookie(_funcscookie);// 写入客户端硬盘
				
			}
			
			
			
			String ip = request.getHeader("x-forwarded-for");
			if(ip == null || ip.length() == 0) {
				 ip = request.getRemoteAddr();
			}
			//记录日志
			userService.SystemLog("userTable","用户表",""+user.getUserId(),""+user.getUserBH(),"用户("+user.getUserName()+"|IP:"+ip+")登录成功!");
			

			//重定向到先前页面
			if(!referUrl.equals("")){
				result.put("referUrl", StringEncDec.decrypt(referUrl));
			}
			System.out.println(new ModelAndView(getSuccessView(),result));
			return new ModelAndView(getSuccessView(),result);
		} else {
			String errorMsg = "用户名或密码错误！";
			result.put(ResultConstants.PAGE_TITLE, "用户登录");
			result.put(ResultConstants.PAGE_MSG, "用户登录失败!"+errorMsg);
			result.put(ResultConstants.PAGE_FROM_URL, "/");
			result.put(ResultConstants.PAGE_GO_URL, "/");
			return new ModelAndView(getFailureView(),result);
		}
	}

	public String getSuccessView() {
		return successView;
	}

	public void setSuccessView(String successView) {
		this.successView = successView;
	}
	


}
