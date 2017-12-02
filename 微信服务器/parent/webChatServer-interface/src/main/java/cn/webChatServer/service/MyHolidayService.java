package cn.webChatServer.service;

import java.util.List;

import org.json.JSONArray;

import cn.webChatServer.ehr.pojo.HistoryHoliday;
import cn.webChatServer.ehr.pojo.Holiday;
import cn.webChatServer.ehr.pojo.ProjectRanking;

public interface MyHolidayService {
	/**
	 * 通过工号查询对应的假期信息
	 * @param userNo
	 * @return
	 */
	public Holiday queryByUserNo(String userNo);
	/**
	 * 查询假期历史信息
	 * @param userNo
	 * @return
	 */
	public HistoryHoliday queryHistoryByUserNo(String userNo);
	/**
	 * 按月份显示考勤记录
	 * @author qianyang
	 * @since 2017-11-10
	 * @param userNo
	 * @return
	 */
	public List<HistoryHoliday> queryHistoryMonthByUserNo(String userNo);
	/**
	 * 显示月度部门排名
	 * @author qianyang
	 * @since 2017-11-14
	 * @param userNo
	 * @param flag (1：deptMonth、2：companyMonth:3：deptYear、4：companyYear)
	 * @return
	 */
	public List<ProjectRanking> queryHistoryRankingToUserNo(String userNo,String flag);
}
