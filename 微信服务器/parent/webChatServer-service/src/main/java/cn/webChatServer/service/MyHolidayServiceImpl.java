package cn.webChatServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webChatServer.ehr.dao.MyHolidayDao;
import cn.webChatServer.ehr.pojo.Holiday;

@Service("myHolidayService")
public class MyHolidayServiceImpl implements MyHolidayService{
	
	@Autowired
	private MyHolidayDao myHolidayDao;

	public Holiday queryByUserNo(String userNo) {
		Holiday holiday = myHolidayDao.queryByUserNo(userNo);
		return holiday;
	}

}
