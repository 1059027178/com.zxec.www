package cn.webChatServer.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class WebChatServiceImplTest  extends AbstractJUnit4SpringContextTests{
	@Autowired
	private WebChatService webChatService;
	
	@Test
	public void testAchieveAccessToken() {
		fail("Not yet implemented");
	}

	@Test
	public void testAchieveWebChartUserID() {
//		fail("Not yet implemented");
//		webChatService = new WebChatServiceImpl();
		String id = webChatService.achieveWebChartUserID("IPP93RaTC04fRe5zJ0J9KAZeyFYX2x7smuTiPxfMK40&");
		System.out.println(id);
	}

}
