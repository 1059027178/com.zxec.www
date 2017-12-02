package cn.webChatServer.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.webChatServer.pojo.ReportDetail;

import com.webChatServer.util.MESConfigInfo;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ReportWorkHoursServiceImplTest extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private ReportWorkHoursService reportWorkHoursService;
	@Test
	public void testJudgeIfOpenMES() {
		List<String> resultList = new ArrayList<String>();
		resultList = reportWorkHoursService.judgeIfOpenMES("E6753");
		System.out.println("################################");
		for (String string : resultList) {
			System.out.println(string);
		}
		System.out.println("################################");
	}
	@Test
	public void testCheckMatterno(){
		String str = reportWorkHoursService.checkMatterno("01.0.014AC-0-P");
		System.out.println(str);
	}
	@Test
	public void testQueryReportDataByLZK(){
		List<ReportDetail> str = reportWorkHoursService.queryReportDataByLZK("17060015");
		System.out.println(str);
		
	}
	/**
	 * 待测试
	 */
	@Test
	public void testQueryMESDataByLZK(){
		JSONObject json = reportWorkHoursService.queryMESDataByLZK("E6753", "钱杨", "17060014");
		
	}
	/**
	 * 待测试
	 */
	@Test
	public void testQueryMESDataByMatter(){
		JSONObject json = reportWorkHoursService.queryMESDataByMatter("E6753", "钱杨", "01.0.05A16");
		
	}
}
