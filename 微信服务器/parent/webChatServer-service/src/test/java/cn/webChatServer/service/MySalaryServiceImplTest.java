package cn.webChatServer.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.webChatServer.pojo.Salary;
@RunWith(SpringJUnit4ClassRunner.class)  //使用junit4进行测试  
@ContextConfiguration(locations={"classpath:applicationContext.xml"}) //加载配置文件  
public class MySalaryServiceImplTest {
	@Autowired
	private MySalaryService mySalaryService;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAchieveSalaryInfo() {
		List<Salary> salaries = mySalaryService.achieveSalaryInfo("6753",10);
		System.out.println("###############################");
		for (Salary salary : salaries) {
			System.out.println("salary = " + salary.getGh());
			System.out.println("salary = " + salary.getXm());
		}
		System.out.println("###############################");
	}

}
