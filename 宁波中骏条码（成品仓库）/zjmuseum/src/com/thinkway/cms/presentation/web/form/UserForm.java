package com.thinkway.cms.presentation.web.form;

import java.io.Serializable;
import java.util.List;


import com.thinkway.cms.business.domains.User;

public class UserForm implements Serializable {

	private static final long serialVersionUID = -4885036728491994931L;

	private User user = null;
	
	private String sessionOK;

	private boolean newUser = false;
	
	private String operType = null;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSessionOK() {
		return sessionOK;
	}

	public void setSessionOK(String sessionOK) {
		this.sessionOK = sessionOK;
	}

	public boolean isNewUser() {
		return newUser;
	}

	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}

	public String getOperType() {
		return operType;
	}

	public void setOperType(String operType) {
		this.operType = operType;
	}
	
	


}
