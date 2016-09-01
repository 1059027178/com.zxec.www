package com.thinkway.cms.business.service.iface;

import java.util.List;

import com.thinkway.cms.business.domains.DelOrdPic;
import com.thinkway.cms.business.domains.DelOrdPicLog;
import com.thinkway.cms.business.query.BaseQuery;

public interface DelOrdPicService {
	/***************************************************
	 *交货单拣配管理
	 ****************************************************/
	//创建交货单拣配
	public String createDelOrdPic(DelOrdPic  DelOrdPic);	
	//读取交货单拣配
	public String readDelOrdPic(DelOrdPic  DelOrdPic);	
	
	//创建一条新的拣货单日志
	 public DelOrdPicLog createNewDelOrdPicLog(DelOrdPicLog delordpicLog);
	//根据组合关键字对象获取用户日志列表	 
	 public List getAllDelOrdPicLogByKw(BaseQuery queryObj) ;
	//日志记录
	public void SystemLog(String dataObj,String dataObjText,String objPk,String operator,String opeartContent);
	
}