package com.thinkway.cms.persistence.iface;

import com.thinkway.cms.business.domains.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface UserDao {

	public void createUser(User user) throws SQLException;

	public void updateUser(User user) throws SQLException;

	public void deleteUserById(int id) throws SQLException;

	public void deleteUserByIds(List<String> ids) throws SQLException;

	public User getUserById(int id) throws SQLException;
	
	public User findUserForLogin(User user) throws SQLException;

	public List getAllUserByKW(Map param) throws SQLException;

	public int getUserCount(Map param) throws SQLException;

}
