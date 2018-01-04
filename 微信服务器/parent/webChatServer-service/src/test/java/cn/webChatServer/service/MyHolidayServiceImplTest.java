package cn.webChatServer.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.informix.util.stringUtil;

import cn.webChatServer.dao.CheckInfoDao;
import cn.webChatServer.ehr.dao.MyInfoDao;
import cn.webChatServer.ehr.pojo.HistoryHoliday;
import cn.webChatServer.ehr.pojo.Holiday;
import cn.webChatServer.ehr.pojo.MyInfo;
import cn.webChatServer.ehr.pojo.ProjectRanking;
import cn.webChatServer.pojo.CheckInfo;
/**
 * @author qianyang
 *如果加入以下代码，所有继承该类的测试类都会遵循该配置，也可以不加，在测试类的方法上///控制事务，参见下一个实例  
 *这个非常关键，如果不加入这个注解配置，事务控制就会完全失效！  
 *@Transactional
 *这里的事务关联到配置文件中的事务控制器（transactionManager = "transactionManager"），
 *同时指定自动回滚（defaultRollback = true）。这样做操作的数据才不会污染数据库！  
 *@TransactionConfiguration(transactionManager = "transactionManager2", defaultRollback = true)
 */
/*@Transactional
@TransactionConfiguration(transactionManager = "transactionManager2", defaultRollback = true)*/
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件  
public class MyHolidayServiceImplTest {
	
	@Autowired
	private MyHolidayService holidayService;
	@Autowired
	private CheckInfoDao checkInfoDao;
	@Autowired
	private MyInfoService myInfoService;
	@Autowired
	private MyInfoDao myInfoDao;
	
	@Test
	public void testUpdateMyInfoByUserNo(){
		MyInfo myInfo = new MyInfo();
		myInfo.setUserno("6753");
		myInfo.setEmail("qianyang@zxec.com");
		myInfo.setUsertel("18181019591");//个人联系电话
		myInfo.setUseraddress("");//个人联系地址
		myInfo.setFatherName("");//父亲姓名
		myInfo.setMotherName("");//母亲姓名
		myInfo.setFatherBirth("");//父亲生日
		myInfo.setMotherBirth("");//母亲生日
		myInfo.setTel("");//父母电话
		myInfo.setAddress("");//父母联系地址
		int s = myInfoDao.updateMyInfoByUserNo(myInfo);
		System.err.println("----------------");
		System.err.println("----------------s = "+ s );
		System.err.println("----------------");
	}
	
	@Test
	public void testQueryMyInfoByUserNo(){
		MyInfo myInfo = myInfoService.queryMyInfoByUserNo("6753");
//		MyInfo myInfo = myInfoDao.queryMyInfoByUserNo("6753");
		System.out.println(myInfo.getAddress());
		System.out.println(myInfo.getComp());
		System.out.println(myInfo.getDept());
	}
	
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
	@Test
	public void testQueryCheckDataByUserIdAndCheckDay(){
		List<Object> objects = new ArrayList<Object>();
		objects = holidayService.queryCheckDataByUserIdAndCheckDay("6753");
		for (int i = 0; i < objects.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) objects.get(i);
			System.out.println("week = " + map.get("week"));
			List<CheckInfo> checkInfos = (List<CheckInfo>) map.get("checkInfos");
			for(int j = 0; j < checkInfos.size(); j++){
				System.out.println("----------------------");
				System.out.println("考勤工号：" + checkInfos.get(j).getUserId());
				System.out.println("考勤日期：" + checkInfos.get(j).getCheckDay());
				System.out.println("考勤时间：" + checkInfos.get(j).getCheckSecond());
			}
		}
	}
}
