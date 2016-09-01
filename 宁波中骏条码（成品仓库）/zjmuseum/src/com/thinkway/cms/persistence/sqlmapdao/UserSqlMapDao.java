package com.thinkway.cms.persistence.sqlmapdao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.persistence.iface.UserDao;


public class UserSqlMapDao extends SqlMapDao implements UserDao {


  public User getUserById  (int id) throws SQLException {
    return (User) sqlMapper.queryForObject("getUserById", new Integer(id));
  }

  public void createUser (User user) throws SQLException {
     sqlMapper.insert("createUser", user);
  }
  
  public void deleteUserById (int id) throws SQLException {
	    sqlMapper.delete("deleteUserById", new Integer(id));
  }
  
  public void updateUser (User user) throws SQLException {
    sqlMapper.update("updateUser", user);
  }

	public User findUserForLogin(User user) throws SQLException {
		return (User)sqlMapper.queryForObject("findUserForLogin",user);
		
	}
	
	public int getUserCount(Map param) throws SQLException {
		  return ((Integer) sqlMapper.queryForObject("getUsersCount",param)).intValue();
	}
	
	public List getAllUserByKW (Map param) throws SQLException {
		return sqlMapper.queryForList("getAllUsersByKW", param);
	  }
	 
	public void deleteUserByIds (List<String> ids) throws SQLException {
		    sqlMapper.delete("deleteUsersByIds", ids);
	}
}
