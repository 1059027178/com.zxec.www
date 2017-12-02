package cn.webChatServer.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.informix.util.stringUtil;

import cn.webChatServer.dao.CheckInfoDao;
import cn.webChatServer.ehr.pojo.HistoryHoliday;
import cn.webChatServer.ehr.pojo.Holiday;
import cn.webChatServer.ehr.pojo.ProjectRanking;
import cn.webChatServer.pojo.CheckInfo;
/**
 * @author qianyang
 *如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例  
 *这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！  
 *@Transactional
 *这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），
 *同时指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！  
 *@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
 */
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件  
public class MyHolidayServiceImplTest {
	
	@Autowired
	private MyHolidayService holidayService;
	@Autowired
	private CheckInfoDao checkInfoDao;
	
	@Test
	public void testQueryByUserNo() {
		Holiday holiday = holidayService.queryByUserNo("6853");
		System.out.println("#####################################################");
		System.out.println("工号：" + holiday.getUserNo());
		System.out.println("姓名：" + holiday.getUserName());
		System.out.println("全部调休：" + holiday.getDueAdjustReset());
		System.out.println("剩余调休：" + holiday.getUsableAdjustReset());
		System.out.println("全部年假：" + holiday.getDueYearHoliday());
		System.out.println("剩余年假：" + holiday.getUsableYearHoliday());
		System.out.println("#####################################################");
	}
	@Test
	public void testQueryByUserIdAndCheckDay(){
		List<CheckInfo> checkInfoList = checkInfoDao.queryByUserIdAndCheckDay("6753", "2017-10-17");
		System.err.println("##################!!!!!" + checkInfoList.get(0).getCheckDate());
		System.err.println("################!!!!!" + checkInfoList.get(1).getCheckDate());
	}
	@Test
	public void testQueryHistoryByUserNo(){
		HistoryHoliday historyHoliday = holidayService.queryHistoryByUserNo("6794");
		System.out.println(historyHoliday);
	}
	@Test
	public void testQueryHistoryMonthByUserNo(){
		List<HistoryHoliday> historyHolidays = holidayService.queryHistoryMonthByUserNo("6753");
	}
	@Test
	public void testQueryHistoryRankingToUserNo(){
		List<ProjectRanking> queryMonthByDept 	 = holidayService.queryHistoryRankingToUserNo("6753","1");
		System.out.println (queryMonthByDept);
		List<ProjectRanking> queryMonthByCompany = holidayService.queryHistoryRankingToUserNo("6753","2");
		System.out.println (queryMonthByCompany);
		List<ProjectRanking> queryYearByDept 	 = holidayService.queryHistoryRankingToUserNo("6753","3");
		System.out.println (queryYearByDept);
		List<ProjectRanking> queryYearByCompany  = holidayService.queryHistoryRankingToUserNo("6753","4");
		System.out.println (queryYearByCompany);
	}
}
