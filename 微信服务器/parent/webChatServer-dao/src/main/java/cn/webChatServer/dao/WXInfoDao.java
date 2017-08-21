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
	 * 更新信息
	 * @param className
	 */
	public abstract void updateWXInfo(WXInfo wXInfo);
	
}
