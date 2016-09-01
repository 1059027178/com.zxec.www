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

import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.UserLog;
import com.thinkway.cms.business.query.UserQuery;
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
public class UserJsonController extends MultiActionController implements AuthenticateController{
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



	public UserJsonController() {
	}
	

  
	
	
	//********获取user清单*****************************	
	public ModelAndView getUserList(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		
		//获取用户清单
		String kw = ParamUtils.getParameter(request, "kw", "");
		int skip = ParamUtils.getIntParameter(request, "skip", 0);
		int cate = ParamUtils.getIntParameter(request, "cate", 0);
		UserQuery cQ1 = new UserQuery();
		cQ1.setSkip(skip);
		cQ1.setLimit(20);
		cQ1.setSdir("desc");
		cQ1.setSort("sortstr");
		List<User> zxList = userService.getMyUserByKW(cQ1);
		String json=ExtHelper.getJsonFromList2(zxList);
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(json);	
		return null;
		
	}
	
	
	//判断用户名是否存在
	public ModelAndView checkUserBH(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html;charset=UTF-8");
		String userBH=ParamUtils.getParameter(request, "userBH","");
		UserQuery uQ = new UserQuery();
		uQ.setSkip(0);
		uQ.setLimit(10);
		uQ.setSort("userId");
		uQ.setSdir("desc");
		uQ.setUserBH(userBH);
		if(userService.getMyUserCountByKW(uQ)==0){
			response.getWriter().write("no");	
		}else{
			response.getWriter().write("yes");
		}
			
		return null;
	}
	
	//********新建用户*****************************	
	public ModelAndView createUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		
		String uBH=ParamUtils.getParameter(request, "userBH","");
		if(uBH.equals("")){
			response.getWriter().write("{\"errmsg\": \"用户登录账号不能为空!\"}");
			return null;
		}
		
		UserQuery uQ = new UserQuery();
		uQ.setSkip(0);
		uQ.setLimit(10);
		uQ.setSort("userId");
		uQ.setSdir("desc");
		uQ.setUserBH(uBH);
		if(userService.getMyUserCountByKW(uQ)>0){
			response.getWriter().write("{\"errmsg\": \"用户登录账号已存在,请更换登录账号!\"}");
			return null;
		}
		
		String userName=ParamUtils.getParameter(request, "userName","");
		if(userName.equals("")){
			response.getWriter().write("{\"errmsg\": \"用户别名不能为空!\"}");
			return null;
		}
		
		uQ.setUserBH(null);
		uQ.setUserName(userName);
		if(userService.getMyUserCountByKW(uQ)>0){
			response.getWriter().write("{\"errmsg\": \"用户别名已存在,请更换别名!\"}");
			return null;
		}
		
		String userFunction=ParamUtils.getParameter(request, "userFunction","");
		String iPassword=ParamUtils.getParameter(request, "inputPassword","");
		if(iPassword.equals("")){
			response.getWriter().write("{\"errmsg\": \"密码不能为空!\"}");
			return null;
		}
		
		String iPasswordAg=ParamUtils.getParameter(request, "inputPasswordAg","");		
		if(!iPassword.equals(iPasswordAg)){
			response.getWriter().write("{\"errmsg\": \"两次输入的密码不一致，请重新输入!\"}");
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		User acObj = new User();
		acObj.setUserBH(uBH);
		acObj.setUserName(userName);
		acObj.setUserPassword(MD5Util.MD5(iPassword));
		acObj.setUserFunction(userFunction);
		acObj.setCreateUser(user.getUserBH());
		acObj.setCreateDate(df.format(new Timestamp(System.currentTimeMillis())).toString());
		User retObj = userService.createNewUser(acObj);
		if(retObj==null){
			response.getWriter().write("{\"errmsg\": \"用户创建失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("userTable","用户表",""+retObj.getUserId(),""+user.getUserBH(),
				"用户["+retObj.getUserBH()+"]创建成功!");
		
	
		String json=ExtHelper.getJsonFromBean(retObj);
		response.getWriter().write("{\"errmsg\": \"用户创建成功!\"}");
		
		
		return null;
   }
	
	
	//********修改用户*****************************	
	public ModelAndView updateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
	
		
		//end - 用户鉴权
		
		int uId=ParamUtils.getIntParameter(request, "userId",0);
		if(uId==0){
			response.getWriter().write("{\"errmsg\": \"用户ID不能为空!\"}");
			return null;
		}
		
		String uBH=ParamUtils.getParameter(request, "userBH","");
		if(uBH.equals("")){
			response.getWriter().write("{\"errmsg\": \"用户登录账号不能为空!\"}");
			return null;
		}
		
		String uName=ParamUtils.getParameter(request, "userName","");
		if(uName.equals("")){
			response.getWriter().write("{\"errmsg\": \"用户别名不能为空!\"}");
			return null;
		}
		String iPassword=ParamUtils.getParameter(request, "inputPassword","");
		if(iPassword.equals("")){
			response.getWriter().write("{\"errmsg\": \"密码不能为空!\"}");
			return null;
		}
		UserQuery uQ = new UserQuery();
		uQ.setSkip(0);
		uQ.setLimit(10);
		uQ.setSort("userId");
		uQ.setSdir("desc");
		uQ.setUserName(uName);
		if(userService.getMyUserCountByKW(uQ)>1){
			response.getWriter().write("{\"errmsg\": \"用户别名已存在,请更换别名!\"}");
			return null;
		}

		
		iPassword=ParamUtils.getParameter(request, "inputPassword","");
		String iPasswordAg=ParamUtils.getParameter(request, "inputPasswordAg","");
		if(!iPassword.equals(iPasswordAg)){
			response.getWriter().write("{\"errmsg\": \"两次输入的用户密码不一致!\"}");
			return null;
		}
		
		
		
		String uFunction=ParamUtils.getParameter(request, "userFunction","");
		if(uFunction.equals("")){
			response.getWriter().write("{\"errmsg\": \"用户权限字符串不能为空!\"}");
			return null;
		}


		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		User acObj = userService.getUser(""+uId);
		acObj.setUserBH(uBH);
		acObj.setUserName(uName);
		if(!iPassword.equals("")){
			acObj.setUserPassword(MD5Util.MD5(iPassword));
		}		
		acObj.setUserFunction(uFunction);
		acObj.setUpdateUser(user.getUserBH());
		acObj.setUpdateDate(df.format(new Timestamp(System.currentTimeMillis())));
		
		if(!userService.updateUser(acObj)){
			response.getWriter().write("{\"errmsg\": \"用户修改失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("userTable","用户表",""+acObj.getUserId(),""+user.getUserBH(),
				"用户["+acObj.getUserBH()+"]修改成功!");
		
		response.getWriter().write("{\"errmsg\": \"用户修改成功!\"}");		
		return null;
   }
	
	
	
	//********修改个人资料*****************************	
	public ModelAndView updateProfile(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		
		
		//end - 用户鉴权
		
		int uId=ParamUtils.getIntParameter(request, "userId",0);
		if(uId==0){
			response.getWriter().write("{\"errmsg\": \"用户ID不能为空!\"}");
			return null;
		}
		
		//鉴权-防止修改他人密码
		if(user.getUserId()!=uId){
			response.getWriter().write("{\"errmsg\": \"用户权限不够!\"}");
			return null;
		}
		
		
		String uName=ParamUtils.getParameter(request, "userName","");
		if(uName.equals("")){
			response.getWriter().write("{\"errmsg\": \"用户别名不能为空!\"}");
			return null;
		}
		
		String uPassword=ParamUtils.getParameter(request, "userPassword","");
		if(uPassword.equals("")){
			response.getWriter().write("{\"errmsg\": \"用户原密码不能为空!\"}");
			return null;
		}
		

		//System.out.println(uName);
		uPassword=MD5Util.MD5(uPassword);
		
		if(!uPassword.equals(user.getUserPassword())){
			response.getWriter().write("{\"errmsg\": \"原始密码输入错误!\"}");
			return null;
		}
		
		String iPassword=ParamUtils.getParameter(request, "inputPassword","");
		iPassword=MD5Util.MD5(iPassword);
		if(iPassword.equals("")){
			response.getWriter().write("{\"errmsg\": \"用户新密码不能为空!\"}");
			return null;
		}
		
		String iPasswordAg=ParamUtils.getParameter(request, "inputPasswordAg","");
		iPasswordAg=MD5Util.MD5(iPasswordAg);
		if(!iPasswordAg.equals(iPassword)){
			response.getWriter().write("{\"errmsg\": \"两次输入的新密码不一致!\"}");
			return null;
		}
		

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		User acObj = userService.getUser(""+uId);
		acObj.setUserName(uName);
		acObj.setUserPassword(iPassword);
		acObj.setUpdateUser(user.getUserBH());
		acObj.setUpdateDate(df.format(new Timestamp(System.currentTimeMillis())));
		
		if(!userService.updateUser(acObj)){
			response.getWriter().write("{\"errmsg\": \"资料修改失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("userTable","用户表",""+acObj.getUserId(),""+user.getUserBH(),
				"用户["+acObj.getUserBH()+"]资料修改成功!");
		
		response.getWriter().write("{\"errmsg\": \"ok\"}");		
		return null;
   }
	
	
	//********删除用户*****************************	
	public ModelAndView deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		
		int uId=ParamUtils.getIntParameter(request, "userId",0);
		if(uId==0){
			response.getWriter().write("{\"errmsg\": \"用户ID不能为空!\"}");
			return null;
		}
		
		
		if(!userService.deleteUser(""+uId)){
			response.getWriter().write("{\"errmsg\": \"用户删除失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("userTable","用户表",""+uId,""+user.getUserBH(),
				"用户["+uId+"]删除成功!");
	
		response.getWriter().write("{\"errmsg\": \"ok\"}");		
		return null;
   }
	
	//********删除用户-多个*****************************	
	public ModelAndView deleteUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
        
        if(!userService.deleteUserByIds(item)){
			response.getWriter().write("{\"errmsg\": \"用户删除失败!\"}");
			return null;
		}
        

		//记录日志
		userService.SystemLog("userTable","用户表","",""+user.getUserBH(),
				"用户["+items+"]删除成功!");
        
		
		
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
