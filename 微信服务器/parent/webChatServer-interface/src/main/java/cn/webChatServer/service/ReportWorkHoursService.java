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
	 * 判断用户是否已开通MES权限
	 * @param userID 用户工号
	 * @return 是否开通
	 */
	public List<String> judgeIfOpenMES(String userID);
}
