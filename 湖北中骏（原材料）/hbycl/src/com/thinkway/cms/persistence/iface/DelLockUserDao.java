package com.thinkway.cms.persistence.iface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.DelLockUser;

public interface DelLockUserDao {

	public void createDelLockUser(DelLockUser delLockUser) throws SQLException;

	public void updateDelLockUser(DelLockUser delLockUser) throws SQLException;
	
	 public DelLockUser getDelLockUser (String vbeln) throws SQLException;
	 
	 public void deleteDelLockUserByUserid (String userid) throws SQLException;
	 
	 public void deleteDelLockUserByVbeln (String vbeln) throws SQLException;
}
