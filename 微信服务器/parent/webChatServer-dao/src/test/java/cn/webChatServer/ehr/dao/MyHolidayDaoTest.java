package cn.webChatServer.ehr.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:MyHolidayDao.xml"}) //加载配置文件  
public class MyHolidayDaoTest {
	@Autowired
	private MyHolidayDao holidayDao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQueryByUserNo() {
		fail("Not yet implemented");
	}

}
