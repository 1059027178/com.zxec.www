package com.thinkway.cms.persistence.sqlmapdao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.DelOrdPicLog;
import com.thinkway.cms.persistence.iface.DelOrdPicLogDao;


public class DelOrdPicLogSqlMapDao extends SqlMapDao implements DelOrdPicLogDao {

  public DelOrdPicLog getDelOrdPicLogById  (int id) throws SQLException {
	  
	  return (DelOrdPicLog) sqlMapper.queryForObject("getDelOrdPicLogById", new Integer(id));
  }

  public void createDelOrdPicLog (DelOrdPicLog delordpicLog) throws SQLException {
	  
	  sqlMapper.insert("createDelOrdPicLog", delordpicLog);
  }
  
  public void deleteDelOrdPicLogById (int id) throws SQLException {
	  sqlMapper.delete("deleteDelOrdPicLogById", new Integer(id));
  }
  
  public void updateDelOrdPicLog (DelOrdPicLog delordpicLog) throws SQLException {
	  sqlMapper.update("updateDelOrdPicLog", delordpicLog);
  }

  public List getAllDelOrdPicLogByKw (Map param) throws SQLException {
	  return sqlMapper.queryForList("getAllDelOrdPicLogByKw",param);
  }
  
  public int getDelOrdPicLogCount(Map param) throws SQLException {
	  	 return ((Integer) sqlMapper.queryForObject("getDelOrdPicLogCount",param)).intValue();
	  }
}
