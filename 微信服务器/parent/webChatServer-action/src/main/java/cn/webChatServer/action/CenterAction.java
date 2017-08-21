package cn.webChatServer.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.webChatServer.pojo.TestTb;
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
	/**
	 * 测试action，不要鸟他
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
	
	/**
	 * 【微信用户登录统一入口，URL中使用viewName参数区分跳转目标Controller】
	 * @param code
	 * @param viewName 对应模块名称
	 * @return
	 */
	@RequestMapping(value="login")
	public String login(@RequestParam("code")String code,@RequestParam("viewName") String viewName){
		//如果code 为null，则先进行处理
		code = ( code == null ? "" : code );
		System.out.println( "【用户登录code = " + code +"】");
		
		//重定向地址
		String to_url = "";
		
		//获取用户ID
		String userID = webChatService.achieveWebChartUserID(code);
		boolean flag1 = ( userID.equals("") );

		//如果未取到-则跳转重新进入
		if(flag1){
			//更新token
			webChatService.achieveAccessToken();
			
			//重定向--调用achieveAuth2CoreURL()，取得重定向地址
			to_url = webChatService.achieveAuth2CoreURL(viewName);
		}
		//成功后跳转到对应的模块
		else{
			to_url = "/" + viewName + "?userID=" + userID;
			System.out.println( "【用户" + userID + "登录成功，跳转到 " + to_url +"】");
		}
		//跳转到对应的页面（1、失败后重定向至login；2、成功后根据viewName跳转到对应的Controller）
		return "redirect:" + to_url;
	}
	/**
	 * viewName = reportWorkHour;
	 * 我要报工
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="reportWork")
	public String reportWork(@RequestParam("userID")String userID){
		System.out.println( "【###用 户 " + userID +"进入报工开始】");
		
		//验证用户是否开通MES权限
		List<String> result = reportWorkHoursService.judgeIfOpenMES(userID);
		boolean flag = ( "成功".equals( result.get(0) ) );
		String to_url = "";
		if(flag){
			
			String userNo = "E" + userID;
			String userName = result.get(2);
			//显示相关报工页面
			to_url = "reportWork/reportWorkIndex";
			
		}else{
			
			//屏蔽相关报工页面
			to_url = "reportWork/reportWorkNoOpen";
			
		}
		
		System.out.println( "【###用 户 " + userID +"进入报工结束】");
		return to_url;
	}
	/**
	 * viewName = myYield;
	 * 我的产量
	 * @param userID
	 * @return
	 */
	@RequestMapping(value="myYield")
	public String myYield(@RequestParam("userID")String userID){
		System.out.println( "【###用 户 " + userID +"进入报工开始】");
		
		
		
		System.out.println( "【###用 户 " + userID +"进入报工结束】");
		return "myYield";
		
	}
	
}
