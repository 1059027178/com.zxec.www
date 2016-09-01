package com.thinkway.cms.business.domains;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sap.mw.jco.JCO;
import com.thinkway.cms.util.SAPModel;

/**
 * 成本中心领料单明细行项目
 * 
 * @author
 * 
 */
public class CostDetail {

	private int num;
	private String costGettenId;
	private String lineItem;
	private String factory;
	private String warehouse;
	private String materialId;
	private String materialDescription;
	private String perAmount;
	private String sendLocation;
	private String unit;
	private String batch;
	private String pickingAmount;
	private String innerId;
	private String costCenterId;
	private String lineText;

	public static List<CostDetail> jcoModelToBean(SAPModel model, String interfaceName) {
		JCO.Table jTable = model.getOuttab().getTable("ET_DETAIL");
		List<CostDetail> items = new ArrayList<CostDetail>();
		if (jTable.getNumRows() > 0) {
			for (int i = 0; i < jTable.getNumRows(); i++) {
				jTable.setRow(i);
				CostDetail item = new CostDetail();
				item.setNum(i + 1);
				item.setCostGettenId(jTable.getString("MBLNR"));
				item.setLineItem(jTable.getString("ZEILE"));
				item.setFactory(jTable.getString("WERKS"));
//				if ("ZFM_BC_15_12".equals(interfaceName)) {
				if ("ZFM_BC_18_12".equals(interfaceName)) {
					item.setWarehouse(jTable.getString("KOSTL"));
				} else {
					item.setInnerId(jTable.getString("AUFNR"));
					item.setCostCenterId(jTable.getString("KOSTL"));
					item.setLineText(jTable.getString("SGTXT"));
				}
				item.setMaterialId(jTable.getString("MATNR"));
				item.setMaterialDescription(jTable.getString("MAKTX"));
				item.setPerAmount(jTable.getString("MENGE"));
				item.setSendLocation(jTable.getString("LGORT"));
				item.setUnit(jTable.getString("MEINS"));
				item.setBatch(jTable.getString("CHARG"));
				item.setPickingAmount(jTable.getString("ZJPSL"));
				items.add(item);
			}
		}
		return items;
	}

	public String getCostGettenId() {
		return costGettenId;
	}

	public void setCostGettenId(String costGettenId) {
		this.costGettenId = costGettenId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getLineItem() {
		return lineItem;
	}

	public void setLineItem(String lineItem) {
		this.lineItem = lineItem;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public String getMaterialId() {
		return materialId;
	}

	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}

	public String getMaterialDescription() {
		return materialDescription;
	}

	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	public String getPerAmount() {
		return perAmount;
	}

	public void setPerAmount(String perAmount) {
		this.perAmount = perAmount;
	}

	public String getSendLocation() {
		return sendLocation;
	}

	public void setSendLocation(String sendLocation) {
		this.sendLocation = sendLocation;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getPickingAmount() {
		return pickingAmount;
	}

	public void setPickingAmount(String pickingAmount) {
		this.pickingAmount = pickingAmount;
	}

	public String getInnerId() {
		return innerId;
	}

	public void setInnerId(String innerId) {
		this.innerId = innerId;
	}

	public String getCostCenterId() {
		return costCenterId;
	}

	public void setCostCenterId(String costCenterId) {
		this.costCenterId = costCenterId;
	}

	public String getLineText() {
		return lineText;
	}

	public void setLineText(String lineText) {
		this.lineText = lineText;
	}

}
