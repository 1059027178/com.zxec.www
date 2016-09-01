package com.thinkway.cms.persistence.iface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.DeliveryLog;

public interface DeliveryLogDao {

	public void createDeliveryLog(DeliveryLog DeliveryLog) throws SQLException;

	public void updateDeliveryLog(DeliveryLog DeliveryLog) throws SQLException;

	public void deleteDeliveryLogById(int id) throws SQLException;

	public DeliveryLog getDeliveryLogById(int id) throws SQLException;

	public List getAllDeliveryLogByKw(Map param) throws SQLException;

	public int getDeliveryLogCount(Map param) throws SQLException;

}
