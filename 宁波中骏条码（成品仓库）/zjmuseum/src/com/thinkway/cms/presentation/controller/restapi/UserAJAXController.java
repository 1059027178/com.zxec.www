package com.thinkway.cms.presentation.controller.restapi;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController; 


import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.DataMethod;
import com.thinkway.cms.util.Escape;
import com.thinkway.cms.util.ExtHelper;
import com.thinkway.cms.util.ParamUtils;

/**
 * 
 * @author welson
 * @author 2007-11-18
 * @自动完成TEXT BOX 取数据controller
 *
 */
public class UserAJAXController extends MultiActionController implements AuthenticateController{

private Authenticator authenticator = null;
private long permission = 0L;

private UserService userService = null;
private String uploadDir;// 上传文件路径
private Long maxUploadSize;
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
	
		
//********删除服务器图片*****************************	
public ModelAndView deleteFileByFileName(HttpServletRequest request, HttpServletResponse response) throws Exception {
	response.setContentType("text/plain;charset=UTF-8");
	StringBuffer buffer = new StringBuffer();
	PrintWriter out = response.getWriter();
	String userId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
	

	String fileName=ParamUtils.getParameter(request, "fileName", "");
	
	
	if(!fileName.equals("")){
		String fileName_medium = DataMethod.getScalePic(fileName, "medium");
		String fileName_small =  DataMethod.getScalePic(fileName, "small");
		//删除原图
		java.io.File file   = new java.io.File(getUploadDir()+userId+"/"+fileName);
		if(file.exists()){
			file.delete();
		}
		//删中图
		java.io.File file_medium   = new java.io.File(getUploadDir()+userId+"/"+fileName_medium);
		if(file_medium.exists()){
			file_medium.delete();
		}
		//删小图
		java.io.File file_small   = new java.io.File(getUploadDir()+userId+"/"+fileName_small);
		if(file_small.exists()){
			file_small.delete();
		}
	}
	
	buffer.append("{\"errmsg\": \"ok\"}");
	out.println(buffer.toString());	
	return null;
}

public String getUploadDir() {
	return getServletContext().getRealPath("/")+uploadDir;
}

public void setUploadDir(String uploadDir) {
	this.uploadDir = uploadDir;
}

public Long getMaxUploadSize() {
	return maxUploadSize;
}

public void setMaxUploadSize(Long maxUploadSize) {
	this.maxUploadSize = maxUploadSize;
}

public UserService getUserService() {
	return userService;
}

public void setUserService(UserService userService) {
	this.userService = userService;
}

}
