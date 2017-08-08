package cn.webChatServer.test;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.webChatServer.TestTbService;
import cn.webChatServer.dao.TestTbDao;
import cn.webChatServer.pojo.TestTb;

/**
 * Junit + Spring
 * 
 * @author Administrator
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestTbTest {
	
	@Autowired
	private TestTbDao testTbDAO;
	
	@Test
	public void testAdd(){
		TestTb testTb = new TestTb();
		testTb.setId(3);
		testTb.setName("尼古拉");
		testTbDAO.add(testTb);
	}
	@Autowired
	private TestTbService testTbService;
	
	@Test
	public void testAdd2(){
		TestTb testTb = new TestTb();
		testTb.setId(5);
		testTb.setName("芈月1");
		testTbService.add(testTb);
	}
}

