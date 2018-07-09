package com.ssh.service.impl;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.UserDao;
import com.ssh.pojo.User;
import com.ssh.service.UserService;

@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,readOnly=true)
public class UserServiceImpl2 implements UserService {
	
	private UserDao userDao;

	public User getUserByCodePassword(User u) {
		System.out.println("getUserByCodePassword");
		return null;
	}

	@Transactional(isolation=Isolation.READ_COMMITTED,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveUser(User u) {
		userDao.saveUser(u);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
