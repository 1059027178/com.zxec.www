package com.thinkway.cms.presentation.controller.restapi;

import java.io.BufferedInputStream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController; 

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.Lgp;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.UserLog;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.presentation.web.core.TimeBean;
import com.thinkway.cms.util.DataMethod;
import com.thinkway.cms.util.Escape;
import com.thinkway.cms.util.ExtHelper;
import com.thinkway.cms.util.MD5Util;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.util.ScaleImage;

/**
 * 
 * @author welson
 * @author 2012-11-18
 * @JSONcontroller-rest API
 *
 */
public class LgpQuyJsonController extends MultiActionController implements AuthenticateController{
//private LgpQuyService lgpquyService = null;	
private UserService userService = null;
private Authenticator authenticator = null;
private Long maxUploadSize;
private String uploadDir;// 上传文件路径
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



	public LgpQuyJsonController() {
	}
	

//	public void setLgpQuyService(LgpQuyService lgpquyService) {
//		this.lgpquyService = lgpquyService;
//	}

  
	
	
	//********新建展厅*****************************	
	public ModelAndView createLgpQuy(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/plain;charset=UTF-8");
		//用户鉴权--begin
		String userId = ""+request.getSession().getAttribute(SessionManager.USER_ID);
		User user = null;
		if(userId.equals("")){
			//根据传过来的用户名和密码进行匹配		
			String userBH = ParamUtils.getParameter(request, "userBH", "");
			String pwd = ParamUtils.getParameter(request, "pwd", "000");		
			if(userBH.equals("")){
				response.getWriter().write("{\"errmsg\": \"用户登录账号不能为空！\"}");
				return null;			
			}
			User loginUser = new User();
			loginUser.setUserBH(userBH);
			loginUser.setUserPassword(pwd);
			user = userService.findUserForLogin(loginUser);		
		}else{
			user = userService.getUser(userId);
		}
		
		if(user==null){
			response.getWriter().write("{\"errmsg\": \"用户未授权!\"}");
			return null;
		}
	
		
		return null;
   }
	
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public void setMaxUploadSize(Long maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	
	

}