package com.ssh.service.impl;

import com.ssh.dao.UserDao;
import com.ssh.pojo.User;
import com.ssh.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public User getUserByCodePassword(User u) {
		//1.根据用户名称查询用户
		User exitUser = userDao.getByUserCode(u.getUser_code());
		//2.判断用户是否存在，不存在抛出异常，提示用户名不存在
		if(exitUser == null){
			throw new RuntimeException("用户名不存在！");
		}
		//3.判断用户密码是否正确，不正确，抛出异常，提示密码错误
		if(! exitUser.getUser_password().equals(u.getUser_password()) ){
			throw new RuntimeException("用户密码错误!");
		}
		//4.返回查询的用户对象
		return exitUser;
	}

	public void saveUser(User u) {
		userDao.saveUser(u);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
