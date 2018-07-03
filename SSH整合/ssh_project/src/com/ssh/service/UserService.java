package com.ssh.service;

import com.ssh.pojo.User;

public interface UserService {
	
	public abstract User getUserByCodePassword(User u);
}
