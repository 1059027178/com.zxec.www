package com.ssh.dao;

import com.ssh.pojo.User;

public interface UserDao {
	 //根据用户登录名称查询user对象
	public abstract User getByUserCode(String usercode);

	//保存用户
	public abstract void saveUser(User u);
}
