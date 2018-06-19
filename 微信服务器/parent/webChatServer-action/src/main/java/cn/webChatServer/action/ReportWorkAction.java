package cn.webChatServer.action;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.webChatServer.util.MySalaryUtil;

import cn.webChartServer.action.simulateData.MesFinishCardNoData;
import cn.webChartServer.action.simulateData.MesMyOutputData;
import cn.webChatServer.mes.pojo.FlowCard;
import cn.webChatServer.mes.pojo.MyOutput;
import cn.webChatServer.mes.pojo.MyOutputIntoParms;
import cn.webChatServer.service.IntegrationMESService;
import cn.webChatServer.service.ReportWorkHoursService;

@Controller
@RequestMapping(value="reportWork")
public class ReportWorkAction {
	@Autowired
	private ReportWorkHoursService reportWorkHoursService;//报工调用
	@Autowired
	private IntegrationMESService integrationMESService;//mes新平台相关Service
	/**
	 * 完工报工
	 * @param result 工号或者流转卡号
	 * @return 当前调用jsapi相关信息
	 */
	//解决注解@ResponseBody 出现乱码问题，在@RequestMapping中添加编码设置即可
	@RequestMapping(value="reportFinish", produces = "text/plain;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody
	public String reportFinish(@RequestParam("result")String result) {
		System.out.println("【###用户进入完工报工验证流转卡、工号 "+ result + "查询开始】");
		JSONObject jsonObject = new JSONObject();
		List<String> resultList = new ArrayList<String>();
		resultList = reportWorkHoursService.judgeIfOpenMES(result);
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
	@RequestMapping(value="reportCheck", produces = "text/plain;charset=UTF-8",method=RequestMethod.GET)
	@ResponseBody	
	public String reportCheck(@RequestParam("result")String result){
		System.out.println("【###用户进入质检报工验证物料码 "+ result + "查询开始】");
		String resultStr = reportWorkHoursService.checkMatterno(result);
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
	/**
	 * 完工报工明细查询
	 * @param userNo 员工工号
	 * @param userName 员工姓名
	 * @param finish_cardno 流转卡号
	 * @return
	 */
	@RequestMapping(value="queryDetailByLZK",method=RequestMethod.GET)
	public String queryMESDataByLZK(@RequestParam("userNo")String userNo,
			@RequestParam("userName")String userName,
			@RequestParam("finish_cardno")String finishCardno){
		System.out.println("【###用户 "+ userNo + "进入完工报工明细查询开始】");
		JSONObject jsonObject = new JSONObject();
		jsonObject = reportWorkHoursService.queryMESDataByLZK(userNo, userName, finishCardno);
		
		System.out.println("【###用户 "+ userNo + "进入完工报工明细查询结束】");
		return "";
	}
	/**
	 * 质检报工明细查询
	 * @param userNo 员工工号
	 * @param userName 员工姓名
	 * @param finish_cardno 流转卡号
	 * @return
	 */
	@RequestMapping(value="queryDetailByMatter",method=RequestMethod.GET)
	public String queryMESDataByMatter(@RequestParam("userNo")String userNo,
			@RequestParam("userName")String userName,
			@RequestParam("finish_cardno")String checkMatterno){
		System.out.println("【###用户 "+ userNo + "进入质检报工明细查询开始】");
		
		
		System.out.println("【###用户 "+ userNo + "进入质检报工明细查询结束】");
		return "";
	}
	//--------------------------------------装配新版MES对接
	/**
	 * 我的产量
	 * @param myOutput
	 * @return
	 */
	@RequestMapping(value="myOutput",produces = "text/plain;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public String myYield(Model model, MyOutputIntoParms intoParms){
		System.out.println(intoParms);
		System.out.println( "【###用 户 " + intoParms.getUserNo() +"进入产量查询开始】");
		//查询我的产量
		MyOutput findMyOutput = integrationMESService.findMyOut(intoParms);
		//模拟返回数据
//		MyOutput findMyOutput = new MesMyOutputData().getMyOutputPOJO();
		//处理返回结果
		JSONObject jsonObject = new JSONObject();
		String strResult = "";
		boolean flag = true;
		if (findMyOutput != null) {
			strResult = JSON.toJSONString(findMyOutput);
		} else {
			flag = false;
		}
		jsonObject.put("flag", flag);
		jsonObject.put("myOutput", strResult);
		System.out.println( "【###用 户 " + intoParms.getUserNo() +"进入产量查询结束】");
		return jsonObject.toString();
	}
	@RequestMapping(value="queryCard")
	public String findCardNo(){
		return "reportWork/queryFinishCardNo";
	}
	/**
	 * 查询流转卡信息
	 * @param cardNo
	 * @return
	 */
	@RequestMapping(value="queryFinishCardNo",produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public String queryFinishCardNo(@RequestParam(value = "cardno",defaultValue="") String cardNo){
		System.out.println( "【### 流转卡" + cardNo + "查询开始】");
		FlowCard flowCard = integrationMESService.findFlowCard(cardNo);
		//模拟返回数据
		//FlowCard flowCard = new MesFinishCardNoData().getFlowCardPOJO();
		JSONObject jsonObject = new JSONObject();
		String strResult = "";
		boolean flag = true;
		if (flowCard != null) {
			strResult = JSON.toJSONString(flowCard);
		} else {
			flag = false;
		}
		jsonObject.put("flag", flag);
		jsonObject.put("flowCard", strResult);
		System.out.println( "【### 流转卡" + cardNo + "查询结束】");
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
