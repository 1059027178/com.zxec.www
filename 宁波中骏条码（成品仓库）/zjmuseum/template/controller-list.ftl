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
import com.quanhai.${project}.presentation.web.form.UserForm;
import com.quanhai.${project}.presentation.web.interceptors.BaseFormController;
import com.quanhai.${project}.util.Escape;
import com.quanhai.${project}.util.ParamUtils;
import com.quanhai.${project}.presentation.web.core.PaginatedListHelper;
import com.quanhai.${project}.business.query.UserQuery;
import com.quanhai.${project}.business.query.${Name}Query;

public class ${Name}ListController implements Controller , AuthenticateController{
	
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
	
	public void set${Name}Service(${Name}Service ${Lname}Service) {
		this.${Lname}Service = ${Lname}Service;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
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
		
		String currentPage=ParamUtils.getParameter(request, "page", "1");
		String sType=ParamUtils.getParameter(request, "stype", "");
		String kw=ParamUtils.getParameter(request, "keywords", "");
		
		
		PaginatedListHelper paginaredList=new PaginatedListHelper();
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		${Name}Query iQ = new ${Name}Query();
		if(!sType.equals("")){  //sType---搜索类型，1是ID，2是NAME，可以扩展
			if(Integer.parseInt(sType)==2){
				//iQ.set${Name}Id(kw.trim());
			}
		}	
		
		paginaredList.setObjectsPerPage(10);


		String strSort=ParamUtils.getParameter(request, "sort", "${Lname}Id");
		String strDir=ParamUtils.getParameter(request, "dir", "desc");
		
		//设置sortCriterion
	    paginaredList.setSortCriterion(strSort);
	    
		//设置sortDirection
	    if (StringUtils.equalsIgnoreCase(strDir, "asc"))
	    	paginaredList.setSortDirection(SortOrderEnum.ASCENDING);
	    else
	    	paginaredList.setSortDirection(SortOrderEnum.DESCENDING);
		 
	    iQ.setSkip((paginaredList.getPageNumber()-1)*paginaredList.getObjectsPerPage());
		iQ.setLimit(paginaredList.getObjectsPerPage());
		iQ.setSdir(strDir);		
		iQ.setSort(strSort);
		
		paginaredList.setFullListSize(${Lname}Service.getAll${Name}sCount(iQ));
		List<?> iList = null;
		iList = ${Lname}Service.getAll${Name}s(iQ);
		
		model.put("iQuery", iQ);
		paginaredList.setList(iList);
		model.put("${Lname}List", paginaredList);	
		model.put("keywords", kw);
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
