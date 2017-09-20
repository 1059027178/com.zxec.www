package cn.webChatServer.ehr.dao;

import cn.webChatServer.ehr.pojo.Holiday;
/**
 * @author qianyang
 * @createDate 2017年09月18日
 * <p>
 * 功能：用于查询工号下对应的假期信息
 */
public interface MyHolidayDao {
	/**
	 * 查询工号对应下的年假、调休
	 * <p>
	 * （应有天数及剩余天数）
	 * @param userNo 用户工号
	 * @return Holiday
	 */
	public Holiday queryByUserNo(String userNo);
}
