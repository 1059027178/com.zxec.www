package com.quanhai.${project}.presentation.controller.restapi;

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

import com.quanhai.${project}.business.domains.${Name};
import com.quanhai.${project}.business.domains.User;
import com.quanhai.${project}.business.domains.UserLog;
import com.quanhai.${project}.business.query.${Name}Query;
import com.quanhai.${project}.business.query.BaseQuery;
import com.quanhai.${project}.business.service.iface.${Name}Service;
import com.quanhai.${project}.business.service.iface.UserService;
import com.quanhai.${project}.presentation.web.authenticate.AuthenticateController;
import com.quanhai.${project}.presentation.web.authenticate.Authenticator;
import com.quanhai.${project}.presentation.web.core.PaginatedListHelper;
import com.quanhai.${project}.presentation.web.core.ResultConstants;
import com.quanhai.${project}.presentation.web.core.SessionManager;
import com.quanhai.${project}.presentation.web.core.TimeBean;
import com.quanhai.${project}.util.DataMethod;
import com.quanhai.${project}.util.Escape;
import com.quanhai.${project}.util.ExtHelper;
import com.quanhai.${project}.util.MD5Util;
import com.quanhai.${project}.util.ParamUtils;
import com.quanhai.${project}.util.ScaleImage;

/**
 * 
 * @author welson
 * @author 2012-11-18
 * @JSONcontroller-rest API
 *
 */
public class ${Name}JsonController extends MultiActionController implements AuthenticateController{
private ${Name}Service ${Lname}Service = null;	
private UserService userService = null;
private Authenticator authenticator = null;
private long permission = 0L;
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



	public ${Name}JsonController() {
	}
	

	public void set${Name}Service(${Name}Service ${Lname}Service) {
		this.${Lname}Service = ${Lname}Service;
	}

  
	
	
	//********获取${Lname}清单*****************************	
	public ModelAndView get${Name}List(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//最新动态
		String kw = ParamUtils.getParameter(request, "kw", "");
		int skip = ParamUtils.getIntParameter(request, "skip", 0);
		int cate = ParamUtils.getIntParameter(request, "cate", 0);
		${Name}Query cQ1 = new ${Name}Query();
		//if(cate>0)cQ1.set${Name}Class(cate);
		cQ1.setSkip(skip);
		cQ1.setLimit(20);
		cQ1.setSdir("desc");
		cQ1.setSort("sortstr");
		List<${Name}> zxList = ${Lname}Service.getAll${Name}s(cQ1);
		String json=ExtHelper.getJsonFromList2(zxList);
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(json);	
		return null;
		
	}
	
	
	//********新建${NameDes}*****************************	
	public ModelAndView create${Name}(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		//该功能为管理员功能-需要鉴定管理员权限
		if(user.getUserFunction().indexOf("1001")<0){
			response.getWriter().write("{\"errmsg\": \"用户权限不够!\"}");
			return null;
		}
		//end - 用户鉴权
		
		
		/*
		String sortstr=ParamUtils.getParameter(request, "sortstr","");
		String linkAddr=ParamUtils.getParameter(request, "linkAddr","");
		String postContent=ParamUtils.getParameter(request, "postContent","");
		String isRel=ParamUtils.getParameter(request, "isRel","N");
		*/
		
		
		${Name} acObj = new ${Name}();
//{autoCode1}
		/*
		acObj.set${Name}Class(${Lname}Class);
		acObj.setPostDate(new Timestamp(System.currentTimeMillis()));
		acObj.setPostTitle(postTitle);
		acObj.setPostContent(postContent);
		acObj.setLinkAddr(linkAddr);
		acObj.setSortstr(sortstr);
		acObj.setIsRel(isRel);
		*/
		${Name} retObj = ${Lname}Service.create${Name}(acObj);
		if(retObj==null){
			response.getWriter().write("{\"errmsg\": \"${NameDes}创建失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("${Lname}","${NameDes}表",""+retObj.get${Name}Id(),""+user.getUserBH(),
				"${NameDes}["+retObj.get${Name}Id()+"]创建成功!");
		
	
		//response.getWriter().write("ok");
		String json=ExtHelper.getJsonFromBean(acObj);
		response.getWriter().write(json);
		
		return null;
   }
	
	
	//********修改${NameDes}*****************************	
	public ModelAndView update${Name}(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		//该功能为管理员功能-需要鉴定管理员权限
		if(user.getUserFunction().indexOf("1001")<0){
			response.getWriter().write("{\"errmsg\": \"用户权限不够!\"}");
			return null;
		}
		//end - 用户鉴权
		
		int ${Lname}Id=ParamUtils.getIntParameter(request, "${Lname}Id",0);
		if(${Lname}Id==0){
			response.getWriter().write("{\"errmsg\": \"${NameDes}ID不能为空!\"}");
			return null;
		}
		
		
		/*
		String sortstr=ParamUtils.getParameter(request, "sortstr","");
		String linkAddr=ParamUtils.getParameter(request, "linkAddr","");
		String postContent=ParamUtils.getParameter(request, "postContent","");
		String isRel=ParamUtils.getParameter(request, "isRel","N");
		*/
		
		${Name} acObj = ${Lname}Service.get${Name}Detail(""+${Lname}Id);
		//acObj.set${Name}Class(new Integer(${Lname}Class));
//{autoCode2}
		/*
		acObj.setPostDate(new Timestamp(System.currentTimeMillis()));
		acObj.setPostTitle(postTitle);
		acObj.setPostContent(postContent);
		acObj.setLinkAddr(linkAddr);
		acObj.setSortstr(sortstr);
		acObj.setIsRel(isRel);
		*/
		
		if(!${Lname}Service.update${Name}(acObj)){
			response.getWriter().write("{\"errmsg\": \"${NameDes}修改失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("${Lname}","${NameDes}表",""+acObj.get${Name}Id(),""+user.getUserBH(),
				"${NameDes}["+acObj.get${Name}Id()+"]修改成功!");
		
		response.getWriter().write("{\"errmsg\": \"ok\"}");		
		return null;
   }
	
	
	//********删除${NameDes}*****************************	
	public ModelAndView delete${Name}(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		//该功能为管理员功能-需要鉴定管理员权限
		if(user.getUserFunction().indexOf("1001")<0){
			response.getWriter().write("{\"errmsg\": \"用户权限不够!\"}");
			return null;
		}
		//end - 用户鉴权
		
		int ${Lname}Id=ParamUtils.getIntParameter(request, "${Lname}Id",0);
		if(${Lname}Id==0){
			response.getWriter().write("{\"errmsg\": \"${NameDes}ID不能为空!\"}");
			return null;
		}
		
		
		
		if(!${Lname}Service.delete${Name}ById(""+${Lname}Id)){
			response.getWriter().write("{\"errmsg\": \"${NameDes}删除失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("${Lname}","${NameDes}表",""+${Lname}Id,""+user.getUserBH(),
				"${NameDes}["+${Lname}Id+"]删除成功!");
		
	
		response.getWriter().write("{\"errmsg\": \"ok\"}");		
		return null;
   }
   
   
   //********删除${NameDes}-多个*****************************	
	public ModelAndView delete${Name}s(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		//该功能为管理员功能-需要鉴定管理员权限
		if(user.getUserFunction().indexOf("1001")<0){
			response.getWriter().write("{\"errmsg\": \"用户权限不够!\"}");
			return null;
		}
		//end - 用户鉴权
		
		String items = request.getParameter("delitems");  
        String[] item = items.split(","); 
        
        if(!${Lname}Service.delete${Name}ByIds(item)){
			response.getWriter().write("{\"errmsg\": \"${NameDes}删除失败!\"}");
			return null;
		}
        

		//记录日志
		userService.SystemLog("${Lname}Table","${NameDes}表","",""+user.getUserBH(),
				"${NameDes}["+items+"]删除成功!");
        
		
		
		response.getWriter().write("{\"errmsg\": \"ok\"}");		
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
