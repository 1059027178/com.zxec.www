package cn.webChartServer.action.simulateData;

import java.util.ArrayList;

import cn.webChatServer.mes.pojo.MyOutput;
import cn.webChatServer.mes.pojo.MyOutputDetailData;

/**
 * action 需求数据模拟
 * @author qianyang
 *
 */
public class MesMyOutputData {

	public MyOutput getMyOutputPOJO(){
		MyOutput output1 = new MyOutput();
		output1.setStartDate("2018-05-04");
		output1.setEndDate("2018-08-05");
		output1.setStatus(true);
		output1.setMessage("success");
		output1.setUserNo("6753");
		output1.setUserName("张三");
		
		ArrayList<MyOutputDetailData> myOutputDetailDatas = new ArrayList<MyOutputDetailData>();
		MyOutputDetailData data1 = new MyOutputDetailData();
		MyOutputDetailData data2 = new MyOutputDetailData();
		MyOutputDetailData data3 = new MyOutputDetailData();
		
		data1.setCount(2000);
		data1.setProcessName("工序1");
		data1.setProductCode("产品代码1");
		data1.setProductName("产品名称1");
		data2.setCount(2000);
		data2.setProcessName("工序2");
		data2.setProductCode("产品代码2");
		data2.setProductName("产品名称2");
		data3.setCount(2000);
		data3.setProcessName("工序3");
		data3.setProductCode("产品代码3");
		data3.setProductName("产品名称3");
		myOutputDetailDatas.add(data1);
		myOutputDetailDatas.add(data2);
		myOutputDetailDatas.add(data3);
		
		output1.setDetailData(myOutputDetailDatas);
		return output1;
	}
}
