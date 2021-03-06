package com.thinkway.cms.presentation.web.interceptors;


import org.springframework.web.servlet.mvc.ParameterizableViewController; 

import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;


/**
 * 
 * @author welson
 * @author 2007-9-18
 *
 */
public class BaseParameterizableViewController extends ParameterizableViewController implements AuthenticateController{

	private long permission = 0L;

	private Authenticator authenticator = null;
	

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
	public BaseParameterizableViewController() {
	}

}
