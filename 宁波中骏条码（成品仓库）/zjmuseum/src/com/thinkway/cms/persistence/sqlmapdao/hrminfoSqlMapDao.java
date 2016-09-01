package com.thinkway.cms.persistence.sqlmapdao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.thinkway.cms.business.domains.hrminfo;
import com.thinkway.cms.persistence.iface.hrminfoDao;

public class hrminfoSqlMapDao extends SqlMapDao implements hrminfoDao {

	public void createhrminfo(hrminfo hrminfo) throws SQLException {
		sqlMapper.insert("createhrminfo", hrminfo);
	}

	public void deletehrminfoById(String id) throws SQLException {
		sqlMapper.delete("deletehrminfo", id);
	}
	
	public void deletehrminfoByIds (List<String> ids) throws SQLException {
	    sqlMapper.delete("deletehrminfoByIds", ids);
}

	public void updatehrminfo(hrminfo hrminfo) throws SQLException {
		sqlMapper.update("updatehrminfo", hrminfo);
	}

	public hrminfo gethrminfoById(String id) throws SQLException {
		return (hrminfo) sqlMapper.queryForObject("gethrminfoById", id);
	}
	public int gethrminfoCountsByObjno(String objno) throws SQLException {
		return ((Integer) sqlMapper.queryForObject("gethrminfoByObjno", objno)).intValue();
	}
	public List getAllhrminfos(Map param) throws SQLException {
		return sqlMapper.queryForList("getAllhrminfos", param);
	}

	public int getAllhrminfosCount(Map param) throws SQLException {
		return ((Integer) sqlMapper.queryForObject("getAllhrminfosCount", param)).intValue();
	}

}
