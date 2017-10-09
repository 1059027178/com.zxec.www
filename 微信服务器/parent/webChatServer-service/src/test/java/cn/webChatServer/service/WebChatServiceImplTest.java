package cn.webChatServer.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;




import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.webChatServer.util.MESConfigInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
/*
这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），
这里指定的是dataSource对应的数据源的事务
同时指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！  
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class WebChatServiceImplTest {
	
	@Autowired
	private WebChatService webChatService;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAchieveAccessToken() {
		System.out.println("###########");
		webChatService.achieveAccessToken();
		System.out.println("###########");
	}

	@Test
	public void testAchieveWebChartUserID() {
		fail("Not yet implemented");
	}

	@Test
	public void testAchieveAuth2CoreURL() {
		fail("Not yet implemented");
	}

	@Test
	public void testAchieveJsapiTicket() {
		fail("Not yet implemented");
	}

	@Test
	public void testAchieveJsapiInfo() {
		fail("Not yet implemented");
	}

}
