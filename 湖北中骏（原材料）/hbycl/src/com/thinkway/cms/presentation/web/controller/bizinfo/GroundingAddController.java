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

import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.Receipt;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.controller.fix.IntegerEditor;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.Escape;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.business.query.UserQuery;

public class GroundingAddController implements Controller , AuthenticateController{
	
	private UserService userService = null;
	private String viewName = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;
	private Receipt receipt=new Receipt();
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
		String matnr = SapUtil.null2String(request.getParameter("matnr"));//物料编码
		String maktx = SapUtil.null2String(request.getParameter("maktx"));//物料描述
		String meng  = SapUtil.null2String(request.getParameter("meng"));//每袋袋数
		String boxs  = SapUtil.null2String(request.getParameter("boxs"));//袋数
		String charg = SapUtil.null2String(request.getParameter("charg"));//批次号
		String wemng = SapUtil.null2String(request.getParameter("wemng"));//总数量
		String lgort = SapUtil.null2String(request.getParameter("lgort"));//库存地点
		String meins = SapUtil.null2String(request.getParameter("unit"));//单位
		System.out.println("meins="+meins);
		receipt.setMatnr(matnr);
		receipt.setWemng(wemng);
		receipt.setLgort(lgort);
		receipt.setCharg(charg);
		receipt.setMeng(meng);
		receipt.setBoxs(boxs);
		receipt.setMaktx(maktx);
		receipt.setMeins(meins);
		model.put("receiptObj", receipt);
		
		/*
		ShowTypeQuery aQ = new ShowTypeQuery();
		aQ.setSkip(0);
		aQ.setLimit(9999);
		aQ.setSort("showTypeId");
		aQ.setSdir("ASC");
		List<ShowType> exshowTypeList = showTypeService.getAllShowTypes(aQ);
		model.put("exshowTypeList", exshowTypeList);
		
		*/
		
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

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}


}
