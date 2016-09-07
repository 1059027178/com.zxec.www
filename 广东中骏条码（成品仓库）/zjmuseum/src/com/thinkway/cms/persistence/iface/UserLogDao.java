package com.thinkway.cms.persistence.iface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.UserLog;

public interface UserLogDao {

	public void createUserLog(UserLog userLog) throws SQLException;

	public void updateUserLog(UserLog userLog) throws SQLException;

	public void deleteUserLogById(int id) throws SQLException;

	public UserLog getUserLogById(int id) throws SQLException;

	public List getAllUserLogByKw(Map param) throws SQLException;

	public int getUserLogCount(Map param) throws SQLException;

}
