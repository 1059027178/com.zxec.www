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

import com.webChatServer.util.MESConfigInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class WebChatServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAchieveAccessToken() {
		fail("Not yet implemented");
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
