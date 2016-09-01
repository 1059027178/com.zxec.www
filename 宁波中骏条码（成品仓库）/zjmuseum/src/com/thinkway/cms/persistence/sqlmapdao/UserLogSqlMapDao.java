package com.thinkway.cms.persistence.sqlmapdao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.UserLog;
import com.thinkway.cms.persistence.iface.UserLogDao;


public class UserLogSqlMapDao extends SqlMapDao implements UserLogDao {

  public UserLog getUserLogById  (int id) throws SQLException {
	  
	  return (UserLog) sqlMapper.queryForObject("getUserLogById", new Integer(id));
  }

  public void createUserLog (UserLog userLog) throws SQLException {
	  
	  sqlMapper.insert("createUserLog", userLog);
  }
  
  public void deleteUserLogById (int id) throws SQLException {
	  sqlMapper.delete("deleteUserLogById", new Integer(id));
  }
  
  public void updateUserLog (UserLog userLog) throws SQLException {
	  sqlMapper.update("updateUserLog", userLog);
  }

  public List getAllUserLogByKw (Map param) throws SQLException {
	  return sqlMapper.queryForList("getAllUserLogByKw",param);
  }
  
  public int getUserLogCount(Map param) throws SQLException {
	  	 return ((Integer) sqlMapper.queryForObject("getUserLogCount",param)).intValue();
	  }
}
