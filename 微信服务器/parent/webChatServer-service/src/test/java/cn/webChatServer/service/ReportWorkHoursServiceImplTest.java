package cn.webChatServer.service;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ReportWorkHoursServiceImplTest extends AbstractJUnit4SpringContextTests{
	
	@Test
	public void testJudgeIfOpenMES() {
		fail("Not yet implemented");
	}

}
