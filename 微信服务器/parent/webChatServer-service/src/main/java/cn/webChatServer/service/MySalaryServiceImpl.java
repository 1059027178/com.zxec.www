package cn.webChatServer.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webChatServer.util.MySalaryUtil;

import cn.webChatServer.dao.MySalaryDao;
import cn.webChatServer.pojo.Salary;

@Service("mySalaryService")
public class MySalaryServiceImpl implements MySalaryService{
	
	@Autowired
	private MySalaryDao mySalaryDao;
	
	private static Salary salary;

	public List<Salary> achieveSalaryInfo(String userID, int showEntry) {
		List<Salary> salaryList = new ArrayList<Salary>();
		System.out.println("【用户_" + userID + "_获取薪资信息开始】>>>>>>");
		//获取当前日期（yyyyMM）
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
		String dateStr = format.format(date);
		for(int i = 1 ; i <= showEntry ; i++ ){
			String checkYearAndMonth = MySalaryUtil.getLastMonth(dateStr, i+1);
			System.out.println("checkYearAndMonth = " + checkYearAndMonth);
			salary = mySalaryDao.queryByUserIdAndMonth(userID, checkYearAndMonth);
			if(salary == null){
				Salary salary1 = new Salary();
				salary1.setNy(checkYearAndMonth);
				salaryList.add(salary1);
			}else{
				salaryList.add(salary);
			}
		}
		
		System.out.println("【用户_" + userID + "_获取薪资信息结束】>>>>>>");
		return salaryList;
	}
}
