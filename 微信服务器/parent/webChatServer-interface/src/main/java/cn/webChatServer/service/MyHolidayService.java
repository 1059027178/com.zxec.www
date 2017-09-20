package cn.webChatServer.service;

import cn.webChatServer.ehr.pojo.Holiday;

public interface MyHolidayService {
	/**
	 * 通过工号查询对应的假期信息
	 * @param userNo
	 * @return
	 */
	public Holiday queryByUserNo(String userNo);
}
