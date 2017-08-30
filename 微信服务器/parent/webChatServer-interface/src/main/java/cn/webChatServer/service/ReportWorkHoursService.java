package cn.webChatServer.service;

import java.util.List;

/**
 * 我的报工接口调用类
 * @author qianyang
 * @Time 2017-08-18
 * @version V1.0
 */
public interface ReportWorkHoursService {
	
	/**
	 *  判断用户是否已开通MES权限
	 * @param strIP 服务器IP
	 * @param strModule 模块名称（MES）
	 * @param strUser 服务器IP
	 * @param strValue 用户工号
	 * @return 
	 */
	public List<String> judgeIfOpenMES(String strIP, String strModule, String strUser, String strValue);
}
