package cn.webChatServer.service;

import static org.junit.Assert.*;

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
public class ReportWorkHoursServiceImplTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private ReportWorkHoursService reportWorkHoursService;
	@Test
	public void testJudgeIfOpenMES() {
		List<String> resultList = new ArrayList<String>();
		resultList = reportWorkHoursService.judgeIfOpenMES(MESConfigInfo.HOST_IP, "MES", MESConfigInfo.HOST_IP,"E6753");
		System.out.println("################################");
		for (String string : resultList) {
			System.out.println(string);
		}
		System.out.println("################################");
	}

}
