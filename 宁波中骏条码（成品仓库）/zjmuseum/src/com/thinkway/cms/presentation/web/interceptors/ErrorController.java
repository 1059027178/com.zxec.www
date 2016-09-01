package com.thinkway.cms.presentation.web.interceptors;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.thinkway.cms.presentation.web.core.ErrorConstants;


/**
 * 
 * @author welson.dou
 * @author 2007-9-20
 * @公用错误页面controller
 *
 */
public class ErrorController implements Controller {
	
	private String viewName = null;
	
	public ErrorController() {
	}
	


	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String sErrCode = (String)request.getParameter("errcode");
		////System.out.println(sErrCode);
		Map<String,String> result = new HashMap<String, String>();
		result.put(ErrorConstants.PAGE_TITLE, "错误页面");
		if(sErrCode.equals("E001")){
			result.put(ErrorConstants.PAGE_MSG, "由于长时间没有操作，您已经退出系统，点击此处重新登录!");
			result.put(ErrorConstants.PAGE_GO_URL, "loginForm.do");
			result.put(ErrorConstants.PAGE_GO_TARGET, "_parent");
		}
		else if(sErrCode.equals("E002")){
			result.put(ErrorConstants.PAGE_MSG, "您没有权限访问该页面，点击此处切换用户!");
			result.put(ErrorConstants.PAGE_GO_URL, "logout.do");
			result.put(ErrorConstants.PAGE_GO_TARGET, "_parent");
		}
		else if(sErrCode.equals("E003")){
			result.put(ErrorConstants.PAGE_MSG, "请不要重复提交该页面!");
			result.put(ErrorConstants.PAGE_GO_URL, "logout.do");
			result.put(ErrorConstants.PAGE_GO_TARGET, "_parent");
		}
		else{
			result.put(ErrorConstants.PAGE_MSG, "未知系统错误");
			result.put(ErrorConstants.PAGE_GO_URL, "#");
		}
		return new ModelAndView(getViewName(),result);
	}


	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

}
