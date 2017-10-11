package cn.webChatServer.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.informix.util.stringUtil;
import com.webChatServer.util.MESConfigInfo;
import com.webChatServer.util.MySalaryUtil;

import cn.webChatServer.service.ReportWorkHoursService;

@Controller
@RequestMapping(value="reportWork")
public class ReportWorkAction {
	@Autowired
	private ReportWorkHoursService reportWorkHoursService;//报工调用
	/**
	 * 完工报工
	 * @param result 工号或者流转卡号
	 * @return 当前调用jsapi相关信息
	 */
	//解决注解@ResponseBody 出现乱码问题，在@RequestMapping中添加编码设置即可
	@RequestMapping(value="reportFinish", produces = "text/plain;charset=UTF-8")
	@ResponseBody	
	public String reportFinish(@RequestParam("result")String result) {
		System.out.println("【###用户进入完工报工验证流转卡、工号 "+ result + "查询开始】");
		JSONObject jsonObject = new JSONObject();
		List<String> resultList = new ArrayList<String>();
		resultList = reportWorkHoursService.judgeIfOpenMES(MESConfigInfo.HOST_IP, "MES", MESConfigInfo.HOST_IP, result);
		jsonObject.put("flag", resultList.get(0).trim());
		jsonObject.put("type", resultList.get(1).trim());
		jsonObject.put("str1", resultList.get(2).trim());
		jsonObject.put("str2", resultList.get(3).trim());
		System.out.println("输出：" + jsonObject);
		System.out.println("【###用户进入完工报工验证流转卡、工号 "+ result + "查询结束】");
		return jsonObject.toString();
	}
	/**
	 * 质检报工
	 * @param result 物料号
	 * @return 当前调用jsapi相关信息
	 */
	@RequestMapping(value="reportCheck", produces = "text/plain;charset=UTF-8")
	@ResponseBody	
	public String reportCheck(@RequestParam("result")String result){
		System.out.println("【###用户进入质检报工验证物料码 "+ result + "查询开始】");
		
		String resultStr = reportWorkHoursService.checkMatterno(MESConfigInfo.HOST_IP, "MES", MESConfigInfo.HOST_IP, result);
		
		JSONObject jsonObject = new JSONObject();
		int flag = resultStr.indexOf("IT_MATNR");
		String msg = "";
		if( flag < 0 ){//查询失败
			msg = "失败";
		}else{
			msg = "成功";
			jsonObject = new JSONObject(resultStr);
		}
		jsonObject.put("msg", msg);
		
		System.out.println("物料查询信息返回：" + jsonObject.toString());
		System.out.println("【###用户进入质检报工验证物料码 "+ result + "查询结束】");
		
		return jsonObject.toString();
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
