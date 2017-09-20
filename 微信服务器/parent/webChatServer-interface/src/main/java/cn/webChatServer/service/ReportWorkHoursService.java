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
	/**
	 * 查询流转卡信息
	 * @param strIP 服务器IP （192.168.0.39）
	 * @param strModule 模块名称（MES） 
	 * @param strUser 服务器IP （192.168.0.39）
	 * @param cardno 流转卡卡号
	 * @return
	 */
	public String[] checkFinishCardno(String strIP, String strModule, String strUser,String cardno);
}
