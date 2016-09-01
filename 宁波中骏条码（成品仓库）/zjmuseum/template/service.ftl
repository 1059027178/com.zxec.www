package com.quanhai.${project}.business.service.iface;

import java.util.List;

import com.quanhai.${project}.business.domains.${Name};
import com.quanhai.${project}.business.query.BaseQuery;

public interface ${Name}Service {
	
	
	
	/***************************************************
	 * ${NameDes}管理
	 ****************************************************/
	//创建${NameDes}
	public ${Name} create${Name}(${Name} ${Lname});	
	//更新${NameDes}
	public boolean update${Name}(${Name} ${Lname});	
	//获取${NameDes}信息
	public ${Name} get${Name}Detail(String ${Lname}Id);
	//删除${NameDes}
	public boolean delete${Name}ById(String id);
	public boolean delete${Name}ByIds(String[] ids);
	//获取${NameDes}列表
	public List getAll${Name}s(BaseQuery queryObj);
	//获取所有${NameDes}记录数
	public int getAll${Name}sCount(BaseQuery queryObj) ;
	
	
}