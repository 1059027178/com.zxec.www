package com.quanhai.${project}.presentation.web.controller.bizinfo;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.quanhai.${project}.business.domains.User;
import com.quanhai.${project}.business.domains.${Name};
import com.quanhai.${project}.business.service.iface.${Name}Service;
import com.quanhai.${project}.business.service.iface.UserService;
import com.quanhai.${project}.presentation.web.authenticate.AuthenticateController;
import com.quanhai.${project}.presentation.web.authenticate.Authenticator;
import com.quanhai.${project}.presentation.web.controller.fix.IntegerEditor;
import com.quanhai.${project}.presentation.web.core.ResultConstants;
import com.quanhai.${project}.presentation.web.core.SessionManager;
import com.quanhai.${project}.util.Escape;
import com.quanhai.${project}.util.ParamUtils;
import com.quanhai.${project}.presentation.web.core.PaginatedListHelper;
import com.quanhai.${project}.business.query.UserQuery;

public class ${Name}EditController implements Controller , AuthenticateController{
	
	private UserService userService = null;
	private ${Name}Service ${Lname}Service = null;
	private String viewName = null;
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
	
	
	public void set${Name}Service(${Name}Service ${Lname}Service) {
		this.${Lname}Service = ${Lname}Service;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		Map<Object, Object> model = new HashMap<Object, Object>();	
		
String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			User loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		
		/*		
		ShowTypeQuery aQ = new ShowTypeQuery();
		aQ.setSkip(0);
		aQ.setLimit(9999);
		aQ.setSort("showTypeId");
		aQ.setSdir("ASC");
		List<ShowType> exshowTypeList = showTypeService.getAllShowTypes(aQ);
		model.put("exshowTypeList", exshowTypeList);		
		*/
		
		String ${Lname}Id = ParamUtils.getParameter(request, "${Lname}Id");
		${Name} uObj = ${Lname}Service.get${Name}Detail(${Lname}Id);
		model.put("${Lname}Obj", uObj);
		return new ModelAndView(getViewName(),model);
		
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


}
