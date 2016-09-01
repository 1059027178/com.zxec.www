package com.thinkway.cms.business.service.iface;

import java.sql.SQLException;
import java.util.List;

import com.thinkway.cms.business.domains.hrminfo;
import com.thinkway.cms.business.query.BaseQuery;

public interface hrminfoService {
	
	
	
	/***************************************************
	 * 人员信息管理
	 ****************************************************/
	//创建人员信息
	public hrminfo createhrminfo(hrminfo hrminfo);	
	//更新人员信息
	public boolean updatehrminfo(hrminfo hrminfo);	
	//获取人员信息信息
	public hrminfo gethrminfoDetail(String hrminfoId);
	//删除人员信息
	public boolean deletehrminfoById(String id);
	public boolean deletehrminfoByIds(String[] ids);
	public int gethrminfoCountsByObjno(String objno) ;
	//获取人员信息列表
	public List getAllhrminfos(BaseQuery queryObj);
	//获取所有人员信息记录数
	public int getAllhrminfosCount(BaseQuery queryObj) ;
	
	
}