package com.ssh.service;

import com.ssh.pojo.User;

public interface UserService {
	//查询用户-用户登录
	public abstract User getUserByCodePassword(User u);
//	保存用户
	public abstract void saveUser(User u);
}
