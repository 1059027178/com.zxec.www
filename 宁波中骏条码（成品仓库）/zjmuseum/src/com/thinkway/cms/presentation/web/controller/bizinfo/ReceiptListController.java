package com.thinkway.cms.presentation.web.controller.bizinfo;

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

import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.Receipt;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.controller.fix.IntegerEditor;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.presentation.web.form.UserForm;
import com.thinkway.cms.presentation.web.interceptors.BaseFormController;
import com.thinkway.cms.util.Escape;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.business.query.UserQuery;
import com.thinkway.cms.business.query.ReceiptQuery;

public class ReceiptListController implements Controller , AuthenticateController{
	
	private UserService userService = null;
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
		ReceiptQuery iQ = new ReceiptQuery();
		if(!sType.equals("")){  //sType---搜索类型，1是ID，2是NAME，可以扩展
			if(Integer.parseInt(sType)==2){
				//iQ.setReceiptId(kw.trim());
			}
		}	
		
		paginaredList.setObjectsPerPage(10);


		String strSort=ParamUtils.getParameter(request, "sort", "receiptId");
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
		
		//paginaredList.setFullListSize(receiptService.getAllReceiptsCount(iQ));
		List<?> iList = null;
		//iList = receiptService.getAllReceipts(iQ);
		
		model.put("iQuery", iQ);
		paginaredList.setList(iList);
		model.put("receiptList", paginaredList);	
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
