package cn.webChatServer.action;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webChatServer.util.MySalaryUtil;

import cn.webChatServer.ehr.pojo.HistoryHoliday;
import cn.webChatServer.ehr.pojo.Holiday;
import cn.webChatServer.ehr.pojo.MyInfo;
import cn.webChatServer.pojo.Salary;
import cn.webChatServer.pojo.TestTb;
import cn.webChatServer.service.MyHolidayService;
import cn.webChatServer.service.MyInfoService;
import cn.webChatServer.service.MySalaryService;
import cn.webChatServer.service.ReportWorkHoursService;
import cn.webChatServer.service.TestTbService;
import cn.webChatServer.service.WebChatService;

@Controller
@RequestMapping(value="center")
public class CenterAction {
	@Autowired
	private TestTbService testTbService;//测试
	@Autowired
	private WebChatService webChatService;//微信接口调用
	@Autowired
	private ReportWorkHoursService reportWorkHoursService;//报工调用
	@Autowired
	private MySalaryService mySalaryService;//薪资查询调用
	@Autowired
	private MyHolidayService myHolidayService;//假期查询接口调用
	@Autowired
	private MyInfoService myInfoService; //个人信息查询接口调用
	/**
	 * 测试action，不用管
	 * @param model
	 * @return
	 */
	@RequestMapping(value="index")
	public String index(Model model)
	{
		TestTb tb = new TestTb();
		tb.setId(9);
		tb.setName("曹操1");
		System.out.println("haha");
		testTbService.add(tb);
		return "index";
	}
	/***********************************微信登录一级目录（通过测试）**********************************************/
	/**
	 * 【微信用户登录统一入口，URL中使用viewName参数区分跳转目标Controller】
	 * @param code
	 * @param viewName 对应模块名称
	 * @return
	 */
	@RequestMapping(value="login")
	public String login(@RequestParam("code")String code,@RequestParam("viewName") String viewName,HttpServletRequest request) {
		//如果code 为null，则先进行处理
		code = ( code == null ? "" : code );
		System.out.println( "【1.用户登录code = " + code +"】");
		
		//重定向地址
		String to_url = "";
		
		//获取用户ID
		String userID = webChatService.achieveWebChartUserID(code);
		boolean flag1 = ( userID.equals("") );
		//如果未取到-则跳转重新进入
		if(flag1){
			System.out.println("【获取工号失败，更新token并重新获取！】");
			//更新token
			webChatService.achieveAccessToken();
			String serverName = request.getServerName();//取得服务器名
			//重定向--调用achieveAuth2CoreURL()，取得重定向地址
			to_url = webChatService.achieveAuth2CoreURL(viewName,serverName);
		}
		//成功后跳转到对应的模块
		else{
			to_url = "/center/" + viewName + ".do?userID=" + MySalaryUtil.dealStringToUrlParm(true, userID);//加密
//			to_url = viewName + ".do?userID=" + MySalaryUtil.dealStringToUrlParm(true, userID);//加密  ---使用此方式需要使用内部转发（return "forward:url"）
			System.out.println( "【3.用户" + userID + "登录成功，跳转到 " + to_url +"】");
		}
		//跳转到对应的页面（1、失败后重定向至login；2、成功后根据viewName跳转到对应的Controller）
		return "redirect:" + to_url;
	}
	/***********************************我的产量、流转卡查询（MES数据查询）**********************************************/
	@RequestMapping(value="queryMyOutput")
	public String findmesOutput(Model model,@RequestParam("userID")String userID){
		//解密
		userID = MySalaryUtil.dealStringToUrlParm(false, userID);
		//获取ehr中员工姓名
		MyInfo myInfo = myInfoService.queryMyInfoByUserNo(userID);
		String userName = myInfo.getUsername();
		model.addAttribute("userNo", userID);
		model.addAttribute("userName", userName);
		return "reportWork/myOutputQuery";
	}
	
	
	
	/***********************************我的报工一级目录（待测试）**********************************************/
	/**
	 * viewName = reportWorkHour;
	 * 我要报工
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="reportWork")
	public String reportWork(Model model,@RequestParam("userID")String userID){
		//解密
		userID = MySalaryUtil.dealStringToUrlParm(false, userID);
		System.out.println( "【###用户 " + userID +"进入MES权限验证开始】");
		
		String userNo = "E" + userID;
		//验证用户是否开通MES权限
		List<String> result = reportWorkHoursService.judgeIfOpenMES(userNo);
		boolean flag = ( "成功".equals( result.get(0).trim() ) );
		String to_url = "";
		if(flag){
			
			String userName = result.get(3).trim();
			System.out.println("###用户"+ userName +"验证通过！");
			
			//放入model，自动传入到前端页面
			model.addAttribute("userNo", userNo);
			model.addAttribute("userName", userName);
			
			//显示相关报工页面
			to_url = "reportWork/reportWorkIndex";
			
		}else{
			
			//放入model，自动传入到前端页面
			model.addAttribute("reason", result.get(1).trim());
			System.out.println("###用户"+ userID + "验证失败,原因为 "+ result.get(1).trim());
			//跳转到报错页面
			to_url = "reportWork/reportWorkNoOpen";
		}
		System.out.println( "【###用户 " + userID +"进入MES权限验证结束】");
		return to_url;
	}
	/***********************************我的薪资一级目录（测试完成）**********************************************/
	/**
	 * viewName = mySalary
	 * 我的薪资
	 * @param model 
	 * @param userID 用户工号
 	 * @return
	 */
	@RequestMapping(value="mySalary")
	public String mySalary(Model model,@RequestParam("userID")String userID){
		//解密
		userID = MySalaryUtil.dealStringToUrlParm(false, userID);
		System.out.println( "【###用户 " + userID +"进入薪资查询开始】");
		//默认显示5个月
		List<Salary> salaryList = mySalaryService.achieveSalaryInfo(userID, MySalaryUtil.SHOW_EHTRY);
		model.addAttribute("salaryList", salaryList);
		System.out.println( "【###用户 " + userID +"进入薪资查询结束】");
		return "salary/mySalary";
	}
	/***********************************我的假期--（测试完成）**********************************************/
	@RequestMapping(value="myHoliday")
	public String myHoliday(Model model,@RequestParam("userID")String userID){
		//解密
		userID = MySalaryUtil.dealStringToUrlParm(false, userID);
		System.out.println( "【###用户 " + userID +"进入假期查询开始】");
		Holiday holiday = myHolidayService.queryByUserNo(userID);
		HistoryHoliday historyHoliday = myHolidayService.queryHistoryByUserNo(userID);
		model.addAttribute("holiday", holiday);
		model.addAttribute("historyHoliday", historyHoliday);
		System.out.println( "【###用户 " + userID +"进入假期查询结束】");
		return "holiday/myHoliday";
	}
	//--未休假期查询
	@RequestMapping(value="myHolidayOne")
	public String myHolidayOne(Model model,@RequestParam("userID")String userID){
		//解密
		userID = MySalaryUtil.dealStringToUrlParm(false, userID);
		System.out.println( "【###用户 " + userID +"进入剩余假期查询开始】");
		Holiday holiday = myHolidayService.queryByUserNo(userID);
		Calendar date = Calendar.getInstance();
	    String year = String.valueOf(date.get(Calendar.YEAR));
		model.addAttribute("holiday", holiday);
	    model.addAttribute("year",year);
		System.out.println( "【###用户 " + userID +"进入剩余假期查询结束】");
		return "holiday/myHolidayOne";
	}
	
	
	/***********************************我的考勤--（已测试）**********************************************/
	@RequestMapping(value="myCheck")
	public String myCheck(Model model,@RequestParam("userID")String userID){
		//解密
		userID = MySalaryUtil.dealStringToUrlParm(false, userID);
		List<Object> checkData = myHolidayService.queryCheckDataByUserIdAndCheckDay(userID);
		model.addAttribute("checkData",checkData);
		return "check/myCheck";
	}
	/***********************************我的信息--（已测试）**********************************************/
	@RequestMapping(value="myInfo")
	public String myInfo(Model model,@RequestParam("userID")String userID){
		//解密
		userID = MySalaryUtil.dealStringToUrlParm(false, userID);
		MyInfo myInfo = myInfoService.queryMyInfoByUserNo(userID);
		model.addAttribute("myInfo",myInfo);
		return "personInfo/myInfo";
	}
	//已测试
	/**
	 * @param myInfo 为提交时的数据（这里spring做了自动的封装，转为了对象）
	 * @return 当前调用jsapi相关信息
	 */
	@RequestMapping(value="updateMyInfo",method=RequestMethod.POST)
	@ResponseBody
	public String updateMyInfo(MyInfo myInfo){
//		System.out.println("----------异步请求成功");
		boolean flag = false;
		flag = myInfoService.updateMyInfo(myInfo);
		System.out.println("修改"+myInfo.getUserno()+"个人信息是否成功 =" + flag);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("msg", flag);
		return jsonObject.toString();
	}
	/***********************************公共功能（测试完成）**********************************************/
	/**
	 * @param url (当前url完整路径)
	 * @return 当前调用jsapi相关信息
	 */
	@RequestMapping(value="achieveJsapiInfo",method=RequestMethod.GET)
	@ResponseBody
	public String achieveJsapiInfo(@RequestParam("url")String url){
//		System.out.println("获取到URL= " + url);
		String str = webChatService.achieveJsapiInfo(url);
		return str;
	}
}


