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
public class GetMaterial {

	private int num;
	private String materialId;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public static List<GetMaterial> jcoModelToBean(SAPModel model) {
		JCO.Table jTable = model.getOuttab().getTable("ET_AUFNR");
		List<GetMaterial> items = new ArrayList<GetMaterial>();
		if (jTable.getNumRows() > 0) {
			for (int i = 0; i < jTable.getNumRows(); i++) {
				jTable.setRow(i);
				GetMaterial item = new GetMaterial();
				item.setNum(i + 1);
				item.setMaterialId(jTable.getString("MRFNR"));
				items.add(item);
			}
		}
		return items;
	}
}
