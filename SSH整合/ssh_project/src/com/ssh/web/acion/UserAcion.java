package com.ssh.web.acion;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.pojo.User;
import com.ssh.service.UserService;

public class UserAcion extends ActionSupport implements ModelDriven<User>{
	private static final long serialVersionUID = -9065916865782770727L;
	
	private User user = new User();

	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String login() throws Exception {
		//1.调用service的登陆功能
		User u = userService.getUserByCodePassword(user);
		//2.将返回的user放入session域中
		ActionContext.getContext().getSession().put("user", u);
		//3.重定向到项目的首页
		return "toHome";
	}

	public User getModel() {
		return user;
	}

	
	

}
