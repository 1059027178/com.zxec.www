package com.quanhai.${project}.persistence.sqlmapdao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.quanhai.${project}.business.domains.${Name};
import com.quanhai.${project}.persistence.iface.${Name}Dao;

public class ${Name}SqlMapDao extends SqlMapDao implements ${Name}Dao {

	public void create${Name}(${Name} ${Lname}) throws SQLException {
		sqlMapper.insert("create${Name}", ${Lname});
	}

	public void delete${Name}ById(String id) throws SQLException {
		sqlMapper.delete("delete${Name}", id);
	}
	
	public void delete${Name}ByIds (List<String> ids) throws SQLException {
	    sqlMapper.delete("delete${Name}ByIds", ids);
}

	public void update${Name}(${Name} ${Lname}) throws SQLException {
		sqlMapper.update("update${Name}", ${Lname});
	}

	public ${Name} get${Name}ById(String id) throws SQLException {
		return (${Name}) sqlMapper.queryForObject("get${Name}ById", id);
	}

	public List getAll${Name}s(Map param) throws SQLException {
		return sqlMapper.queryForList("getAll${Name}s", param);
	}

	public int getAll${Name}sCount(Map param) throws SQLException {
		return ((Integer) sqlMapper.queryForObject("getAll${Name}sCount", param)).intValue();
	}

}
