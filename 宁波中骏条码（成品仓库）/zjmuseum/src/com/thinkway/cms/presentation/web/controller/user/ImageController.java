package com.thinkway.cms.presentation.web.controller.user;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.util.Image;
import com.thinkway.cms.util.MemCachedUtil;

public class ImageController implements Controller{
	
	private String viewName = null;
	
	public ImageController() {
	}

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		response.setHeader("Pragma","No-cache");
		response.setHeader("Cache-Control","no-cache");
		response.setDateHeader("Expires", 0);
		Image image = new Image();
		ImageIO.write(image.creatImage(), "JPEG", response.getOutputStream());		
		/*
		MemCachedUtil cache = MemCachedUtil.getInstance();
		cache.add("randcode",image.sRand);
		*/
		request.getSession().setAttribute("rand",image.sRand);
		////System.out.println("image.sRand: "+image.getSRand());
		return null;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getViewName() {
		return viewName;
	}

}
