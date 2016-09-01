package com.jiuyi.tools.util;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AutoGen {

	public static void main(String[] args) {
		TemplateUtil tu = new TemplateUtil();
		Map<String,String> iMap;
		/*
		tu.processDeleteFilesByClassName("rdp","Accountreq");
		tu.processDeleteFilesByClassName("rdp","Addrbook");
		tu.processDeleteFilesByClassName("rdp","Contact");
		tu.processDeleteFilesByClassName("rdp","Platform");
		tu.processDeleteFilesByClassName("rdp","Area");
		tu.processDeleteFilesByClassName("rdp","Platformgoods");
		tu.processDeleteFilesByClassName("rdp","PriceArea");
		tu.processDeleteFilesByClassName("rdp","Notice");
		tu.processDeleteFilesByClassName("rdp","MarketPriceHD");
		tu.processDeleteFilesByClassName("rdp","MarketPriceDT");
		tu.processDeleteFilesByClassName("rdp","Stockfollow");
		tu.processDeleteFilesByClassName("rdp","MktHoliday");
		tu.processDeleteFilesByClassName("rdp","ContactGroup");
		
		*/
		
		tu.processDeleteFilesByClassName("rdp","Promotion");
		
		iMap = new LinkedHashMap();		
		iMap.put("promotionCode", "String|促销代码|O|input");	
		iMap.put("promotionName", "String|促销名称|O|input");
		iMap.put("isDel", "String|删除标记|O|select");
		tu.process("rdp", "Promotion", "促销管理", iMap, "Y");
		
		/*
		tu.processDeleteFilesByClassName("rdp","Team");
		tu.processDeleteFilesByClassName("rdp","Factory");
		tu.processDeleteFilesByClassName("rdp","WorkPlatform");
		tu.processDeleteFilesByClassName("rdp","Material");
		tu.processDeleteFilesByClassName("rdp","UnitConversion");
		tu.processDeleteFilesByClassName("rdp","ProductGroup");
		tu.processDeleteFilesByClassName("rdp","FactoryUnit");
		
		tu.processDeleteFilesByClassName("rdp","EnteringwareHouse");
		tu.processDeleteFilesByClassName("rdp","Pros");
		tu.processDeleteFilesByClassName("rdp","Process");
		tu.processDeleteFilesByClassName("rdp","Dump");
		tu.processDeleteFilesByClassName("rdp","Locationonside");
		tu.processDeleteFilesByClassName("rdp","Abnormal");
		tu.processDeleteFilesByClassName("rdp","Device");
		tu.processDeleteFilesByClassName("rdp","Craft");
		tu.processDeleteFilesByClassName("rdp","Model");
		tu.processDeleteFilesByClassName("rdp","Quality");
		tu.processDeleteFilesByClassName("rdp","WorkingBill");
		tu.processDeleteFilesByClassName("rdp","Callreason");
		tu.processDeleteFilesByClassName("rdp","Cause");
		tu.processDeleteFilesByClassName("rdp","CardManagement");
		tu.processDeleteFilesByClassName("rdp","FlowingRectify");
		tu.processDeleteFilesByClassName("rdp","Products");
		tu.processDeleteFilesByClassName("rdp","HandOverProcess");
		tu.processDeleteFilesByClassName("rdp","FlowingRectify");				
		tu.processDeleteFilesByClassName("rdp","DailyWork");	
		tu.processDeleteFilesByClassName("rdp","Carton");	
		tu.processDeleteFilesByClassName("rdp","Pick");
		tu.processDeleteFilesByClassName("rdp","PickDetail");
		tu.processDeleteFilesByClassName("rdp","Rework");
		tu.processDeleteFilesByClassName("rdp","UnusualLog");
		tu.processDeleteFilesByClassName("rdp","Repairin");	
		tu.processDeleteFilesByClassName("rdp","CraftLog");
		tu.processDeleteFilesByClassName("rdp","ModelLog");
		tu.processDeleteFilesByClassName("rdp","DeviceLog");
		tu.processDeleteFilesByClassName("rdp","AbnormalLog");
		tu.processDeleteFilesByClassName("rdp","SwiptCard");
		tu.processDeleteFilesByClassName("rdp","Repair");
		tu.processDeleteFilesByClassName("rdp","Pollingtest");
		tu.processDeleteFilesByClassName("rdp","PollingtestRecord");
		tu.processDeleteFilesByClassName("rdp","Sample");
		tu.processDeleteFilesByClassName("rdp","SampleRecord");
		tu.processDeleteFilesByClassName("rdp","ItermediateTest");
		tu.processDeleteFilesByClassName("rdp","ItermediateTestDetail");
		tu.processDeleteFilesByClassName("rdp","IpRecord");
		tu.processDeleteFilesByClassName("rdp","HandOver");
		tu.processDeleteFilesByClassName("rdp","FaultReason");
		tu.processDeleteFilesByClassName("rdp","Equipments");
		tu.processDeleteFilesByClassName("rdp","Scrap");
		tu.processDeleteFilesByClassName("rdp","ScrapBug");
		tu.processDeleteFilesByClassName("rdp","ScrapLater");
		tu.processDeleteFilesByClassName("rdp","ScrapMessage");
		tu.processDeleteFilesByClassName("rdp","HandlemeansResults");
		tu.processDeleteFilesByClassName("rdp","LongtimePreventstep");
		tu.processDeleteFilesByClassName("rdp","CreditAccess");
		tu.processDeleteFilesByClassName("rdp","ReceiptReason");
		tu.processDeleteFilesByClassName("rdp","DumpDetail");
		tu.processDeleteFilesByClassName("rdp","CreditCard");
		tu.processDeleteFilesByClassName("rdp","Kaoqin");
		tu.processDeleteFilesByClassName("rdp","DeviceStep");
		tu.processDeleteFilesByClassName("rdp","DeviceModlue");
		tu.processDeleteFilesByClassName("rdp","ProcessRoute");
		tu.processDeleteFilesByClassName("rdp","Bom");
		tu.processDeleteFilesByClassName("rdp","KaoqinBrushCardRecord");
		tu.processDeleteFilesByClassName("rdp","Orders");
		tu.processDeleteFilesByClassName("rdp","RepairPiece");
		tu.processDeleteFilesByClassName("rdp","RepairinPiece");
		tu.processDeleteFilesByClassName("rdp","ReworkRecord");
		tu.processDeleteFilesByClassName("rdp","CartonSon");
		tu.processDeleteFilesByClassName("rdp","OddHandOver");
		tu.processDeleteFilesByClassName("rdp","PumPackHandOver");
		tu.processDeleteFilesByClassName("rdp","WorkingInout");
		tu.processDeleteFilesByClassName("rdp","EndProduct");
		tu.processDeleteFilesByClassName("rdp","ReturnProduct");
		tu.processDeleteFilesByClassName("rdp","ScrapOut");
		tu.processDeleteFilesByClassName("rdp","UnitdistributeProduct");
		tu.processDeleteFilesByClassName("rdp","UnitdistributeModel");
		
		*/
	}

}
