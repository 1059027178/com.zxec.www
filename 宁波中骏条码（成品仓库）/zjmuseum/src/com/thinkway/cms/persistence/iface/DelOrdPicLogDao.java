package com.thinkway.cms.persistence.iface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.DelOrdPicLog;

public interface DelOrdPicLogDao {

	public void createDelOrdPicLog(DelOrdPicLog delordpicLog) throws SQLException;

	public void updateDelOrdPicLog(DelOrdPicLog delordpicLog) throws SQLException;

	public void deleteDelOrdPicLogById(int id) throws SQLException;

	public DelOrdPicLog getDelOrdPicLogById(int id) throws SQLException;

	public List getAllDelOrdPicLogByKw(Map param) throws SQLException;

	public int getDelOrdPicLogCount(Map param) throws SQLException;

}
