package com.thinkway.cms.presentation.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class BaseFormController extends SimpleFormController {

	/** 
	 *   防止多次提交 
	 *   
	 *   @param   request 
	 *   @param   response 
	 *   @return 
	 *   @throws   Exception 
	 */
	protected ModelAndView disallowDuplicateFormSubmission(
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		BindException errors = new BindException(formBackingObject(request),getCommandName());
		errors.reject(null, "对不起，你不能重复提交同一表单内容！");
		return showForm(request, response, errors);
	}

	/* 
	 *   (non-Javadoc) 
	 *   
	 *   @see   org.springframework.web.servlet.mvc.AbstractFormController#handleInvalidSubmit(javax.servlet.http.HttpServletRequest, 
	 *             javax.servlet.http.HttpServletResponse) 
	 */
	protected ModelAndView handleInvalidSubmit(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return disallowDuplicateFormSubmission(request, response);
	}
}
