package com.ssh.web.acion;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh.service.UserService;

public class UserAcion extends ActionSupport {

	private static final long serialVersionUID = -9065916865782770727L;

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String login() throws Exception {
		
		System.out.println(userService);
		
		return super.execute();
	}

	
	

}
