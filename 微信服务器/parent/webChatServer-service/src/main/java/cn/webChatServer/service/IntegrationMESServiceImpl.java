package cn.webChatServer.service;


import org.json.JSONObject;
import org.junit.Test;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.webChatServer.util.MESConfigInfo;
import com.webChatServer.util.NetWorkUtil;

import cn.webChatServer.mes.pojo.FlowCard;
import cn.webChatServer.mes.pojo.MyOutput;
import cn.webChatServer.mes.pojo.MyOutputIntoParms;
/**
 * @author qianyang
 * @since 2018-06-06
 */
@Service("integrationMESService")
public class IntegrationMESServiceImpl implements IntegrationMESService {
	
	public MyOutput findMyOut(MyOutputIntoParms intoParms) {
		//1.获取webapi接口url地址
		String url = MESConfigInfo.MES_WEBAPI_URL;
		//2.将传入的pojo实体类转为json
		String jsonStr = JSON.toJSONString(intoParms);
//		System.out.println("传入MES数据包为：" + jsonStr);
		//3.发起httppost请求
		String returnData = NetWorkUtil.httpRequestMES(url, "POST", jsonStr);
//		System.out.println("returnData = " + returnData);
		//4.处理返回信息，转为javaBean并返回
		MyOutput myOutput = null;
		if (returnData != null && !"".equals(returnData)) {
			myOutput = JSON.parseObject(returnData, MyOutput.class);
		}
		return myOutput;
	}

	public FlowCard findFlowCard(String flowCardNo) {
		//1.获取webapi接口url地址
		String url = MESConfigInfo.MES_CARDNO_WEBAPI_URL;
		//2.封装参数
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("flowCardNo", flowCardNo);
		//3.传入参数发起http post请求
		String returnData = NetWorkUtil.httpRequest(url, "POST", jsonObject.toString());
		//4.处理返回信息，转为javaBean并返回
		FlowCard flowCard = null;
		if	(returnData != null && !"".equals(returnData.trim())) {
			flowCard = JSON.parseObject(returnData,FlowCard.class);
		}
		return flowCard;
	}
}
