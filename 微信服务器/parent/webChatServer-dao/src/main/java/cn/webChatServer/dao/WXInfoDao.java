package cn.webChatServer.dao;

import cn.webChatServer.pojo.WXInfo;

public interface WXInfoDao {
	/**
	 * 在表wxinfo中，通过className进行查询
	 * @param className
	 * @return
	 */
	public abstract WXInfo queryByClassName(String className);
	/**
	 * 更新access_token信息
	 * @param className
	 */
	public abstract void updataWXInfo(WXInfo wXInfo);
	/**
	 * 更新jsapi_ticket信息
	 * @param wXInfo
	 */
	public abstract void updataWXInfoByJsapiTicket(WXInfo wXInfo);
	
}
