package com.thinkway.cms.business.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sap.mw.jco.JCO;
import com.thinkway.cms.util.SAPModel;

/**
 * 生产领料单行项目
 * 
 * @author
 * 
 */
public class GetCost {

	private int num;
	private String costId;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCostId() {
		return costId;
	}

	public void setCostId(String costId) {
		this.costId = costId;
	}

	public static List<GetCost> jcoModelToBean(SAPModel model) {
//		JCO.Table jTable = model.getOuttab().getTable("ET_AUFNR");
		JCO.Table jTable = model.getOuttab().getTable("ET_AUFNR1");
		List<GetCost> items = new ArrayList<GetCost>();
		if (jTable.getNumRows() > 0) {
			for (int i = 0; i < jTable.getNumRows(); i++) {
				jTable.setRow(i);
				GetCost item = new GetCost();
				item.setNum(i + 1);
//				item.setCostId(jTable.getString("MRFNR"));
				item.setCostId(jTable.getString("MBLNR"));
				items.add(item);
			}
		}
		return items;
	}
}
