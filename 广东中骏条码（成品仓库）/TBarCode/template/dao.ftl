package com.quanhai.${project}.persistence.iface;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.quanhai.${project}.business.domains.${Name};


public interface ${Name}Dao {
	public void create${Name}(${Name} ${Lname}) throws SQLException; 
	
	public void delete${Name}ById(String id) throws SQLException;
	
	public void delete${Name}ByIds (List<String> ids) throws SQLException;
	
	public void update${Name}(${Name} ${Lname}) throws SQLException;

	public ${Name} get${Name}ById(String id) throws SQLException;

	public List getAll${Name}s(Map param) throws SQLException ;
	
	public int getAll${Name}sCount(Map param) throws SQLException;	
}
