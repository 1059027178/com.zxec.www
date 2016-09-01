package com.thinkway.cms.persistence.sqlmapdao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.DelLockUser;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.persistence.iface.DelLockUserDao;


public class DelLockUserSqlMapDao extends SqlMapDao implements DelLockUserDao {

  public void createDelLockUser (DelLockUser delLockUser) throws SQLException {
	  
	  sqlMapper.insert("createDelLockUser", delLockUser);
  }
  
  public void deleteDelLockUserByVbeln (String vbeln) throws SQLException {
	  sqlMapper.delete("deleteDelLockUserByVbeln", vbeln);
  }
  
  public void deleteDelLockUserByUserid (String userid) throws SQLException {
	  sqlMapper.delete("deleteDelLockUserByUserid", userid);
  }
  
  public void updateDelLockUser (DelLockUser userLog) throws SQLException {
	  sqlMapper.update("updateDelLockUser", userLog);
  }

  public DelLockUser getDelLockUser (String vbeln) throws SQLException {
	  return (DelLockUser)sqlMapper.queryForObject("getDelLockUser",vbeln);
  }
  

}
