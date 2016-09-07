package com.thinkway.cms.persistence.sqlmapdao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.DeliveryLog;
import com.thinkway.cms.persistence.iface.DeliveryLogDao;


public class DeliveryLogSqlMapDao extends SqlMapDao implements DeliveryLogDao {

  public DeliveryLog getDeliveryLogById  (int id) throws SQLException {
	  
	  return (DeliveryLog) sqlMapper.queryForObject("getDeliveryLogById", new Integer(id));
  }

  public void createDeliveryLog (DeliveryLog DeliveryLog) throws SQLException {
	  
	  sqlMapper.insert("createDeliveryLog", DeliveryLog);
  }
  
  public void deleteDeliveryLogById (int id) throws SQLException {
	  sqlMapper.delete("deleteDeliveryLogById", new Integer(id));
  }
  
  public void updateDeliveryLog (DeliveryLog DeliveryLog) throws SQLException {
	  sqlMapper.update("updateDeliveryLog", DeliveryLog);
  }

  public List getAllDeliveryLogByKw (Map param) throws SQLException {
	  return sqlMapper.queryForList("getAllDeliveryLogByKw",param);
  }
  
  public int getDeliveryLogCount(Map param) throws SQLException {
	  	 return ((Integer) sqlMapper.queryForObject("getDeliveryLogCount",param)).intValue();
	  }
}
