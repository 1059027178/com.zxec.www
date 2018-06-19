package cn.webChartServer.action.simulateData;

import java.util.ArrayList;
import java.util.List;

import com.sun.tools.javac.comp.Flow;

import cn.webChatServer.mes.pojo.FlowCard;
import cn.webChatServer.mes.pojo.FlowCardDetailData;
import cn.webChatServer.mes.pojo.MyOutput;
import cn.webChatServer.mes.pojo.MyOutputDetailData;

/**
 * action 需求数据模拟
 * @author qianyang
 *
 */
public class MesFinishCardNoData {

	public FlowCard getFlowCardPOJO(){
		FlowCardDetailData flowCardDetailData1 = new FlowCardDetailData("6753", "王一狗", "装配", 2000);
		FlowCardDetailData flowCardDetailData2 = new FlowCardDetailData("6754", "王二狗", "喷漆", 1000);
		FlowCardDetailData flowCardDetailData3 = new FlowCardDetailData("6755", "王三狗", "磨边", 4000);
		FlowCardDetailData flowCardDetailData4 = new FlowCardDetailData("6756", "王四狗", "注塑", 6000);
		List<FlowCardDetailData> detailData = new ArrayList<FlowCardDetailData>();
		detailData.add(flowCardDetailData1);
		detailData.add(flowCardDetailData2);
		detailData.add(flowCardDetailData3);
		detailData.add(flowCardDetailData4);
		FlowCard flowCard = new FlowCard(true,"success","No001","paigong01","code001","productName1",detailData);
		return flowCard;
	}
}
