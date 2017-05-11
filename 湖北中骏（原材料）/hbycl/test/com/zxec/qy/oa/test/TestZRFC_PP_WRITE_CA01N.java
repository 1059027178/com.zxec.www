package com.zxec.qy.oa.test;
import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class TestZRFC_PP_WRITE_CA01N {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SAPRequest sapRequest = new SAPRequest("ZRFC_PP_WRITE_CA01N");//工艺路线
		
		sapRequest.addParameter("IP_HISTORY", "");
		sapRequest.addParameter("IP_WERKS", "3100");
		sapRequest.addParameter("IP_MATNR", "C.6.040802");
		sapRequest.addParameter("IP_FLAG", "X");
		
		sapRequest.addInputTable("IT_TAB", 
				new String[]{"MATNR","WERKS","GROUPCOUNTER","ACTIVITY","CONTROL_KEY","WERKS_OP",
				"WORK_CNTR","STANDARD_TEXT_KEY","DESCRIPTION","BASE_QUANTITY",
				"STD_VALUE_01","STD_VALUE_02","STD_VALUE_03","STD_VALUE_04","STD_VALUE_05","STD_VALUE_06"}, 
				
				new String[]{"C.6.040802","3100","","001","","3100",
				"ZJ002","ZJ1101","操作","1000.0",
				"240.24","1540.0","240.24","0","0","1540.0"});
		SAPModel model = SapUtil.OperSAP(sapRequest);
		JCO.Table jTable = model.getOuttab().getTable("ET_LOG");
		String msg1 = model.getOuts().getString("EP_SUBRC");
		String msg2 = model.getOuts().getString("EP_GROUP");
		String msg3 = model.getOuts().getString("EP_GROUPCOUNTER");
		for (int i = 0; i < jTable.getNumRows(); i++) {
			jTable.setRow(i);
			System.out.println("第"+i+"行"+jTable.getString("TYPE")+","+jTable.getString("MESSAGE"));
		}
		System.out.println("msg1 = "+msg1);
		System.out.println("msg2 = "+msg2);
		System.out.println("msg3 = "+msg3);
		
	}

}
