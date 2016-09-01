package com.thinkway.cms.business.domains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sap.mw.jco.JCO;
import com.thinkway.cms.util.SAPModel;

/**
 * 物料仓位信息
 * 
 * @author
 * 
 */
public class MaterialWarehouse {

	private int num;
	private String materialId;
	private String factory;
	private String batch;
	private String storageLocation;
	private String storageType;
	private String wareHouse;
	private String unit;
	private String enabledAmount;
	private String produceDate;
	private String supplier;
	private String supplierBatch;
	private String selectAmount;
	private String orderDate;

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getSelectAmount() {
		return selectAmount;
	}

	public void setSelectAmount(String selectAmount) {
		this.selectAmount = selectAmount;
	}

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

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public String getStorageType() {
		return storageType;
	}

	public void setStorageType(String storageType) {
		this.storageType = storageType;
	}

	public String getWareHouse() {
		return wareHouse;
	}

	public void setWareHouse(String wareHouse) {
		this.wareHouse = wareHouse;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getEnabledAmount() {
		return enabledAmount;
	}

	public void setEnabledAmount(String enabledAmount) {
		this.enabledAmount = enabledAmount;
	}

	public String getProduceDate() {
		return produceDate;
	}

	public void setProduceDate(String produceDate) {
		this.produceDate = produceDate;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getSupplierBatch() {
		return supplierBatch;
	}

	public void setSupplierBatch(String supplierBatch) {
		this.supplierBatch = supplierBatch;
	}

	public static List<MaterialWarehouse> jcoModelToBean(SAPModel model) {
		JCO.Table jTable = model.getOuttab().getTable("ET_LQUA");
		List<MaterialWarehouse> items = new ArrayList<MaterialWarehouse>();
		if (jTable.getNumRows() > 0) {
			for (int i = 0; i < jTable.getNumRows(); i++) {
				jTable.setRow(i);
				MaterialWarehouse item = new MaterialWarehouse();
				//				item.setNum(i + 1);
				item.setMaterialId(jTable.getString("MATNR"));
				item.setFactory(jTable.getString("WERKS"));
				item.setBatch(jTable.getString("CHARG"));
				item.setStorageLocation(jTable.getString("LGORT"));
				item.setStorageType(jTable.getString("LGTYP"));
				item.setWareHouse(jTable.getString("LGPLA"));
				item.setUnit(jTable.getString("MEINS"));
				item.setEnabledAmount(String.valueOf(jTable.getDouble("VERME")));
				item.setProduceDate(jTable.getString("HSDAT"));
				item.setSupplier(jTable.getString("LIFNR"));
				item.setSupplierBatch(jTable.getString("LICHA"));
				item.setSupplier(jTable.getString("LIFNR"));
				item.setOrderDate(parseDate(jTable.getString("HSDAT")));
				items.add(item);
			}
			Collections.sort(items, new Comparator<MaterialWarehouse>() {

				public int compare(MaterialWarehouse arg0, MaterialWarehouse arg1) {
					return arg0.getOrderDate().compareTo(arg1.getOrderDate());
				}
			});
			for (int i = 0; i < items.size(); i++) {
				items.get(i).setNum(i + 1);
			}
		}
		return items;
	}

	public static String parseDate(String produceDate) {
		String d = "0";
		try {
			d = produceDate.split("-")[0] + produceDate.split("-")[1] + produceDate.split("-")[2];
		} catch (Exception e) {
			return "0";
		}
		return d;
	}

}
