package com.thinkway.cms.business.service.iface;

import java.util.List;

import com.thinkway.cms.business.domains.Delivery;
import com.thinkway.cms.business.domains.DeliveryLog;
import com.thinkway.cms.business.query.BaseQuery;

public interface DeliveryService {
	/***************************************************
	 *交货单拣配管理
	 ****************************************************/
	//创建交货单拣配
	public String createDelivery(Delivery  Delivery);	
	//读取交货单拣配
	public String readDelivery(Delivery  Delivery);	
	
	//创建一条新的拣货单日志
	 public DeliveryLog createNewDeliveryLog(DeliveryLog DeliveryLog);
	//根据组合关键字对象获取用户日志列表	 
	 public List getAllDeliveryLogByKw(BaseQuery queryObj) ;
	//日志记录
	public void SystemLog(String dataObj,String dataObjText,String objPk,String operator,String opeartContent);
	
}