package cn.webChatServer.dao;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import cn.webChatServer.pojo.CheckInfo;

@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration(locations = {"classpath:applicationContext.xml","classpath:CheckInfoDao.xml"}) //加载配置文件  
public class CheckInfoDaoTest {
	@Autowired
	private CheckInfoDao checkInfoDao;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testQueryByUserIdAndCheckDay() {
//		fail("Not yet implemented");
		List<CheckInfo> checkinfoList =  checkInfoDao.queryByUserIdAndCheckDay("6753", "2017-10-19");
		System.out.println(checkinfoList.get(0));
		System.out.println(checkinfoList.get(1));
	}

}
