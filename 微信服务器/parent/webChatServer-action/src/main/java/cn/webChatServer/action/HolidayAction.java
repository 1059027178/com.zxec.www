package cn.webChatServer.action;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.webChatServer.ehr.pojo.HistoryHoliday;
import cn.webChatServer.ehr.pojo.ProjectRanking;
import cn.webChatServer.service.MyHolidayService;
@Controller
@RequestMapping(value="holiday")
public class HolidayAction {
	@Autowired
	private MyHolidayService myHolidayService;//假期查询接口调用

	private JSONArray jsonArray = null;
	private JSONObject jsonObject = null;
	/**
	 * @param url (当前url完整路径)
	 * @param param (部门、公司数据抽取标记：1、2为按月排名；3、4为按年度统计)
	 * @return 当前调用jsapi相关信息
	 */
	@RequestMapping(value="achieveJsonHoliday",produces = "text/json;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String achieveJsonHoliday(@RequestParam(value = "userNo")String userNo,
			@RequestParam(value = "param"/*,defaultValue="5"*/)String param){
		System.out.println("userNo = " + userNo);
		String strJson = "";
		//按月分组,取得各项（病假、事假、调休、公出）天数
		if(param.equals("5")){
			List<HistoryHoliday> queryHistoryMonthByUserNoList = myHolidayService.queryHistoryMonthByUserNo(userNo);
			jsonArray  = new JSONArray(queryHistoryMonthByUserNoList);
			jsonObject = new JSONObject();
			jsonObject.put("queryDayByMonthArray", jsonArray);
			strJson = jsonObject.toString();
		}
		//排名信息获取
		else{
			List<ProjectRanking> projectRankings = myHolidayService.queryHistoryRankingToUserNo(userNo,param);
			jsonArray  = new JSONArray(projectRankings);
			jsonObject = new JSONObject();
			jsonObject.put("queryHistoryMonthByDeptArray", jsonArray);
			strJson = jsonObject.toString();
		}
		System.out.println(strJson);
		
		return strJson;
	}
}
