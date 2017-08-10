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
	 * 通用查询：
	 * 在表wxinfo中，自定义条件查询
	 * @param condition（如 and id = 12 and name = 'qy'）
	 * @return
	 */
	public abstract WXInfo queryByCondition(String condition);
	/**
	 * 更新信息
	 * @param className
	 */
	public abstract void updateWXInfo(WXInfo wXInfo);
	
}
