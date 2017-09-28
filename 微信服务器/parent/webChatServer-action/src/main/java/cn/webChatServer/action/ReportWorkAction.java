package cn.webChatServer.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webChatServer.util.MySalaryUtil;

import cn.webChatServer.service.ReportWorkHoursService;

@Controller
@RequestMapping(value="reportWork")
public class ReportWorkAction {
	@Autowired
	private ReportWorkHoursService reportWorkHoursService;//报工调用
	/**
	 * @param url (当前url完整路径)
	 * @return 当前调用jsapi相关信息
	 */
	@RequestMapping(value="reportFinish")
	@ResponseBody
	public String reportFinish(@RequestParam("result")String result){
		System.out.println("【###用 户 进入完工报工流转卡 "+ result + "查询开始】");
		String str = "";
		System.out.println("【###用 户 进入完工报工流转卡 "+ result + "查询结束】");
		return str;
	}
	/*测试页面*/
	@RequestMapping(value="reportWorkTest")
	public String reportWorkTest(){
		System.out.println("报工页面测试！！！");
		String strEnc = MySalaryUtil.dealStringToUrlParm(true, "6753");
	 	System.out.println("加密结果："+ strEnc);
	 	String strDes = MySalaryUtil.dealStringToUrlParm(false, strEnc);
	 	System.out.println("解密结果："+ strDes);
	 	
		return "reportWork/reportWorkIndex";
	}
}
