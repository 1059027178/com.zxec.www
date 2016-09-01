package com.thinkway.cms.persistence.iface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.hrminfo;


public interface hrminfoDao {
	public void createhrminfo(hrminfo hrminfo) throws SQLException; 
	
	public void deletehrminfoById(String id) throws SQLException;
	
	public void deletehrminfoByIds (List<String> ids) throws SQLException;
	
	public void updatehrminfo(hrminfo hrminfo) throws SQLException;

	public hrminfo gethrminfoById(String id) throws SQLException;
	
	public int gethrminfoCountsByObjno(String objno) throws SQLException;

	public List getAllhrminfos(Map param) throws SQLException ;
	
	public int getAllhrminfosCount(Map param) throws SQLException;	
}
