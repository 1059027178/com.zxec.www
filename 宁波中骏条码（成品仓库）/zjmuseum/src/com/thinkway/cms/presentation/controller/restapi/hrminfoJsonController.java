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

import com.thinkway.cms.business.domains.hrminfo;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.UserLog;
import com.thinkway.cms.business.query.hrminfoQuery;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.service.iface.hrminfoService;
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
public class hrminfoJsonController extends MultiActionController implements AuthenticateController{
private hrminfoService hrminfoService = null;	
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



	public hrminfoJsonController() {
	}
	

	public void sethrminfoService(hrminfoService hrminfoService) {
		this.hrminfoService = hrminfoService;
	}

  
	
	
	//********获取hrminfo清单*****************************	
	public ModelAndView gethrminfoList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//最新动态
		String kw = ParamUtils.getParameter(request, "kw", "");
		int skip = ParamUtils.getIntParameter(request, "skip", 0);
		int cate = ParamUtils.getIntParameter(request, "cate", 0);
		hrminfoQuery cQ1 = new hrminfoQuery();
		//if(cate>0)cQ1.sethrminfoClass(cate);
		cQ1.setSkip(skip);
		cQ1.setLimit(20);
		cQ1.setSdir("desc");
		cQ1.setSort("sortstr");
		List<hrminfo> zxList = hrminfoService.getAllhrminfos(cQ1);
		String json=ExtHelper.getJsonFromList2(zxList);
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().write(json);	
		return null;
		
	}
	
	
	//********新建人员信息*****************************	
	public ModelAndView createhrminfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/plain;charset=UTF-8");
		System.out.println("进来了");
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
		
		
		hrminfo acObj = new hrminfo();
		String objno=ParamUtils.getParameter(request, "objno","");
		if(objno.equals("")){
			response.getWriter().write("{\"errmsg\": \"工号不能为空!\"}");
			return null;
		}
		acObj.setObjno(objno);
		String name=ParamUtils.getParameter(request, "name","");
		if(name.equals("")){
			response.getWriter().write("{\"errmsg\": \"姓名不能为空!\"}");
			return null;
		}
		acObj.setName(name);
		String department=ParamUtils.getParameter(request, "department","");
		if(department.equals("")){
			response.getWriter().write("{\"errmsg\": \"部门不能为空!\"}");
			return null;
		}
		acObj.setDepartment(department);
		String sex=ParamUtils.getParameter(request, "sex","");
		if(sex.equals("")){
			response.getWriter().write("{\"errmsg\": \"性别不能为空!\"}");
			return null;
		}
		acObj.setSex(sex);
		System.out.println(objno+"/"+name+"/"+department+"/"+sex);
		System.out.println(acObj);
		/*
		acObj.sethrminfoClass(hrminfoClass);
		acObj.setPostDate(new Timestamp(System.currentTimeMillis()));
		acObj.setPostTitle(postTitle);
		acObj.setPostContent(postContent);
		acObj.setLinkAddr(linkAddr);
		acObj.setSortstr(sortstr);
		acObj.setIsRel(isRel);
		*/
		hrminfo retObj = hrminfoService.createhrminfo(acObj);
		if(retObj==null){
			response.getWriter().write("{\"errmsg\": \"人员信息创建失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("hrminfo","人员信息表",""+retObj.gethrminfoId(),""+user.getUserBH(),
				"人员信息["+retObj.gethrminfoId()+"]创建成功!");
		
	
		//response.getWriter().write("ok");
		response.getWriter().write("{\"errmsg\": \" 恭喜您，创建成功\"}");
		
		return null;
   }
	
	
	//********修改人员信息*****************************	
	public ModelAndView updatehrminfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		
		int hrminfoId=ParamUtils.getIntParameter(request, "hrminfoId",0);
		if(hrminfoId==0){
			response.getWriter().write("{\"errmsg\": \"人员信息ID不能为空!\"}");
			return null;
		}
		
		
		/*
		String sortstr=ParamUtils.getParameter(request, "sortstr","");
		String linkAddr=ParamUtils.getParameter(request, "linkAddr","");
		String postContent=ParamUtils.getParameter(request, "postContent","");
		String isRel=ParamUtils.getParameter(request, "isRel","N");
		*/
		
		hrminfo acObj = hrminfoService.gethrminfoDetail(""+hrminfoId);
		//acObj.sethrminfoClass(new Integer(hrminfoClass));
		String objno=ParamUtils.getParameter(request, "objno","");
		if(objno.equals("")){
			response.getWriter().write("{\"errmsg\": \"工号不能为空!\"}");
			return null;
		}
		acObj.setObjno(objno);
		String name=ParamUtils.getParameter(request, "name","");
		if(name.equals("")){
			response.getWriter().write("{\"errmsg\": \"姓名不能为空!\"}");
			return null;
		}
		acObj.setName(name);
		String department=ParamUtils.getParameter(request, "department","");
		if(department.equals("")){
			response.getWriter().write("{\"errmsg\": \"部门不能为空!\"}");
			return null;
		}
		acObj.setDepartment(department);
		String sex=ParamUtils.getParameter(request, "sex","");
		if(sex.equals("")){
			response.getWriter().write("{\"errmsg\": \"性别不能为空!\"}");
			return null;
		}
		acObj.setSex(sex);

		/*
		acObj.setPostDate(new Timestamp(System.currentTimeMillis()));
		acObj.setPostTitle(postTitle);
		acObj.setPostContent(postContent);
		acObj.setLinkAddr(linkAddr);
		acObj.setSortstr(sortstr);
		acObj.setIsRel(isRel);
		*/
		
		if(!hrminfoService.updatehrminfo(acObj)){
			response.getWriter().write("{\"errmsg\": \"人员信息修改失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("hrminfo","人员信息表",""+acObj.gethrminfoId(),""+user.getUserBH(),
				"人员信息["+acObj.gethrminfoId()+"]修改成功!");
		
		response.getWriter().write("{\"errmsg\": \"人员信息修改成功!\"}");		
		return null;
   }
	
	
	//********删除人员信息*****************************	
	public ModelAndView deletehrminfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
		
		int hrminfoId=ParamUtils.getIntParameter(request, "hrminfoId",0);
		if(hrminfoId==0){
			response.getWriter().write("{\"errmsg\": \"人员信息ID不能为空!\"}");
			return null;
		}
		
		
		
		if(!hrminfoService.deletehrminfoById(""+hrminfoId)){
			response.getWriter().write("{\"errmsg\": \"人员信息删除失败!\"}");
			return null;
		}
		
		//记录日志
		userService.SystemLog("hrminfo","人员信息表",""+hrminfoId,""+user.getUserBH(),
				"人员信息["+hrminfoId+"]删除成功!");
		
	
		response.getWriter().write("{\"errmsg\": \"ok\"}");		
		return null;
   }
   
   
   //********删除人员信息-多个*****************************	
	public ModelAndView deletehrminfos(HttpServletRequest request, HttpServletResponse response) throws Exception {

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
        
        if(!hrminfoService.deletehrminfoByIds(item)){
			response.getWriter().write("{\"errmsg\": \"人员信息删除失败!\"}");
			return null;
		}
        

		//记录日志
		userService.SystemLog("hrminfoTable","人员信息表","",""+user.getUserBH(),
				"人员信息["+items+"]删除成功!");
        
		
		
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