package cn.webChatServer.ehr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.webChatServer.ehr.pojo.HistoryHoliday;
import cn.webChatServer.ehr.pojo.ProjectRanking;

/**
 * @author qianyang
 * @createDate 2017年09月18日
 * <p>
 * 功能：（非操作工）用于查询工号下对应的历史已用假期信息
 */
public interface MyHistoryHolidayDao {
	/**
	 * 查询本年度剩余假期信息
	 * @param userNo
	 * @return
	 */
	public HistoryHoliday queryHistoryByUserNo(@Param("userNo")String userNo);
	/**
	 * 查询本年度历史休假信息
	 * @param userNo
	 * @return
	 */
	public List<HistoryHoliday> queryHistoryMonthByUserNo(@Param("userNo")String userNo);
	/**
	 * 查询排名
	 * @param userNo
	 * @param time (year：2017 or month:201708)
	 * @param project
	 * @param flag (1：deptMonth、2：companyMonth:3：deptYear、4：companyYear)
	 * @return
	 */
	public ProjectRanking queryRankingByUserNo(@Param("userNo")String userNo,@Param("time")String time,@Param("flag")String flag);
}
