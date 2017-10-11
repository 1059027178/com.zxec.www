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
	 *  验证工号或流转卡号是否有效
	 * @param strIP 服务器IP
	 * @param strModule 模块名称（MES）
	 * @param strUser 服务器IP
	 * @param strValue 用户工号、流转卡号
	 * @return 
	 */
	public List<String> judgeIfOpenMES(String strIP, String strModule, String strUser, String strValue);
	/**
	 *  验证物料号是否有效
	 * @param strIP 服务器IP
	 * @param strModule 模块名称（MES）
	 * @param strUser 服务器IP
	 * @param strValue 物料代码
	 * @return 
	 */
	public String checkMatterno(String strIP, String strModule, String strUser, String matterno);
	
}
