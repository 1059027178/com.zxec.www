package cn.webChatServer.service;

import java.util.List;

import org.json.JSONObject;

import cn.webChatServer.pojo.ReportDetail;

/**
 * 我的报工接口调用类
 * @author qianyang
 * @Time 2017-08-18
 * @version V1.0
 */
public interface ReportWorkHoursService {
	
	/**
	 *  验证工号或流转卡号是否有效
	 * @param strValue 用户工号、流转卡号
	 * @return 
	 */
	public List<String> judgeIfOpenMES(String strValue);
	/**
	 *  验证物料号是否有效
	 * @param strValue 物料代码
	 * @return 
	 */
	public String checkMatterno(String matterno);
	/**
	 * 根据流转卡号查询工艺路线明细
	 * @param userNo 员工工号
	 * @param userName 员工姓名
	 * @param finishCardno 流转卡号
	 * @return JSONObject
	 */
	public JSONObject queryMESDataByLZK(String userNo, String userName, String finishCardno);
	/**
	 * 根据物料代码查询报工明细
	 * @param userNo 员工工号
	 * @param userName 员工姓名
	 * @param checkMatterno 物料代码
	 * @return JSONObject
	 */
	public JSONObject queryMESDataByMatter(String userNo, String userName, String checkMatterno);
	/**
	 * 根据流转卡查询报工明细数据
	 * @param finishCardno
	 * @return List<Object>
	 */
	public List<ReportDetail> queryReportDataByLZK(String finishCardno);
	
}
