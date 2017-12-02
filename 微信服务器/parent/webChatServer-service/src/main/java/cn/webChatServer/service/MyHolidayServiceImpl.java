package cn.webChatServer.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webChatServer.ehr.dao.MyHistoryHolidayDao;
import cn.webChatServer.ehr.dao.MyHolidayDao;
import cn.webChatServer.ehr.pojo.HistoryHoliday;
import cn.webChatServer.ehr.pojo.Holiday;
import cn.webChatServer.ehr.pojo.ProjectRanking;
/**
 * 此类实现MyHolidayService接口
 * @author qianyang
 * @since 2017-11-13
 */
@Service("myHolidayService")
public class MyHolidayServiceImpl implements MyHolidayService{
	@Autowired
	private MyHolidayDao myHolidayDao;
	@Autowired
	private MyHistoryHolidayDao historyHolidayDao;

	public Holiday queryByUserNo(String userNo) {
		Holiday holiday = myHolidayDao.queryByUserNo(userNo);
		return holiday;
	}

	public HistoryHoliday queryHistoryByUserNo(String userNo) {
		HistoryHoliday historyHoliday = historyHolidayDao.queryHistoryByUserNo(userNo);
		return historyHoliday;
	}

	public List<HistoryHoliday> queryHistoryMonthByUserNo(String userNo) {
		List<HistoryHoliday> historyHolidays = historyHolidayDao.queryHistoryMonthByUserNo(userNo);
		return historyHolidays;
	}

	public List<ProjectRanking> queryHistoryRankingToUserNo(String userNo,String flag) {
		System.out.println("【start】(1、2:月度部门、公司排名;3、4:年度部门、公司排名)flag ="+ flag);
		//用于存放处理结果
		List<ProjectRanking> projectRankings = new ArrayList<ProjectRanking>();
		//查询历史月度部门排名
		Date nowDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMM");
		String strNow = dateFormat.format(nowDate);
		String year	  = strNow.substring(0, 4);
		String month  = strNow.substring(4);
		String tempMonth = "";
		ProjectRanking ranking = new ProjectRanking();
//		按月--公司、本部门排名
		boolean temp = ( flag.equals("1") || flag.equals("2") );
		if(temp){
			for(int k = 1; k <= Integer.parseInt(month); k++){
				if( k < 10) 
					tempMonth = year + "0" + k;
				else	 
					tempMonth = year + k;
				System.out.println("flag ="+ flag +"查询月为"+tempMonth);
				ranking = historyHolidayDao.queryRankingByUserNo(userNo, tempMonth, flag);
				if(ranking != null) ranking.setFlag(flag);
				System.err.println(ranking);
				projectRankings.add(ranking);
			}
		}
//		按年--公司、本部门排名
		else{
			ranking = historyHolidayDao.queryRankingByUserNo(userNo, year, flag);
			ranking.setYears(year);//设置年度
			ranking.setFlag(flag);//设置数据标志
			projectRankings.add(ranking);
		}
		System.out.println("【end】"+ flag);
		return projectRankings;
	}

}
