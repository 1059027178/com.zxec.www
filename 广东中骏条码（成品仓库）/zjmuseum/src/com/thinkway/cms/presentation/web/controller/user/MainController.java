package com.thinkway.cms.presentation.web.controller.user;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.query.UserQuery;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.presentation.web.core.TimeBean;

/**
 * 
 * @author Matt
 *
 */
public class MainController implements Controller,AuthenticateController{
	
	UserService userService = null;
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

	private String viewName = null;
	private String viewName2 = null;
	private String view1 = null;
	private String view2 = null;
	private String view3 = null;
	private String view4 = null;
	private String view5 = null;
	private String viewAdmin= null;
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		System.out.println("进来了");
		Map<Object, Object> model = new HashMap<Object, Object>();			
		String userId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		System.out.println("userId:"+userId);
		User user = null;
		if(userId==null||userId.equals("")){
			//insert code here
			//根据传过来的用户名和密码进行匹配		
		}else{
			user = userService.getUser(userId);			
			model.put("loginUser",user);			
		}	
		model.put("currentTime", TimeBean.getTime());
		int two=ParamUtils.getIntParameter (request, "two",0);//二级菜单
		int choose=ParamUtils.getIntParameter(request, "choose",0);//二级菜单
		switch(two){
			case 1:{
				return new ModelAndView(getView1(),model);
			}
			case 2:{
				return new ModelAndView(getView2(),model);
			}
			case 3:{
				return new ModelAndView(getView3(),model);
			}
			case 4:{
				return new ModelAndView(getView4(),model);
			}
			case 5:{
				return new ModelAndView(getView5(),model);
			}
			default:{
				
			}
		}
		switch(choose){
		case 1:{
			return new ModelAndView(getView1(),model);
		}
		case 2:{
			return new ModelAndView(getView2(),model);
		}
		case 3:{
			return new ModelAndView(getView3(),model);
		}
		case 4:{
			return new ModelAndView(getView4(),model);
		}
		case 5:{
			return new ModelAndView(getView5(),model);
		}
		default:{
			
		}
		}
		if(!(user.getUserFunction().indexOf("1001")<0)){
			String currentPage=ParamUtils.getParameter(request, "page", "1");
			String sType=ParamUtils.getParameter(request, "stype", "");
			String kw=ParamUtils.getParameter(request, "keywords", "");
			
			
			PaginatedListHelper paginaredList=new PaginatedListHelper();
			paginaredList.setPageNumber(Integer.parseInt(currentPage));
			UserQuery iQ = new UserQuery();
			if(!sType.equals("")){  //sType---搜索类型，1是ID，2是NAME，可以扩展
				if(Integer.parseInt(sType)==2){
					iQ.setUserName(kw.trim());
				}
			}	
			
			paginaredList.setObjectsPerPage(5);


			String strSort=ParamUtils.getParameter(request, "sort", "userId");
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
			
			paginaredList.setFullListSize(userService.getMyUserCountByKW(iQ));
			List<?> iList = null;
			iList = userService.getMyUserByKW(iQ);
			
			model.put("iQuery", iQ);
			paginaredList.setList(iList);
			model.put("userList", iList);	
			model.put("keywords", kw);
			return new ModelAndView(getViewAdmin(),model);
		}
		//新增半成品
		else if(!(user.getUserFunction().indexOf("1002")<0)){
			
			System.out.println(getViewName2());
			return new ModelAndView(getViewName2(),model);
		}
		System.out.println(getViewName());
		return new ModelAndView(getViewName(),model);
	}

	public String getViewName() {
		return viewName;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	public String getViewName2() {
		return viewName2;
	}

	public void setViewName2(String viewName2) {
		this.viewName2 = viewName2;
	}
	public String getView1() {
		return view1;
	}

	public void setView1(String view1) {
		this.view1 = view1;
	}

	public String getView2() {
		return view2;
	}

	public void setView2(String view2) {
		this.view2 = view2;
	}

	public String getView3() {
		return view3;
	}

	public void setView3(String view3) {
		this.view3 = view3;
	}

	public String getView4() {
		return view4;
	}

	public void setView4(String view4) {
		this.view4 = view4;
	}

	public String getView5() {
		return view5;
	}

	public void setView5(String view5) {
		this.view5 = view5;
	}

	public String getViewAdmin() {
		return viewAdmin;
	}

	public void setViewAdmin(String viewAdmin) {
		this.viewAdmin = viewAdmin;
	}
}
