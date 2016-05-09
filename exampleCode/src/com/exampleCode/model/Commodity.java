package com.exampleCode.model;
/**
 * @author qianyang
 * 20160504
 * 货物属性
 */
public class Commodity {
	private String PO;
	/** * 行项目*/
	private String lineItem;
	/*** 供应商*/
	private String supplier;
	/** * 物料编码*/
	private String materialCode;
	/** * 每袋数量*/
	private String everyBagNumber;
	/*** 单位 */
	private String unit;
	/*** 库存地点*/
	private String storageLocation;
	/*** 批次号*/
	private String  batchNo;
	/*** 环保标识*/
	private String environmentalFlag;
	/** 检验 */
	private String checkOut;
	/**供应商生产日期*/
	private String produceDate;
	/**供应商批次号*/
	private String produceBatchNo;
	/**库存类别*/
	private String storeClass;
	
	public String getPO() {
		return PO;
	}
	public void setPO(String pO) {
		PO = pO;
	}
	public String getLineItem() {
		return lineItem;
	}
	public void setLineItem(String lineItem) {
		this.lineItem = lineItem;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getMaterialCode() {
		return materialCode;
	}
	public void setMaterialCode(String materialCode) {
		this.materialCode = materialCode;
	}
	public String getEveryBagNumber() {
		return everyBagNumber;
	}
	public void setEveryBagNumber(String everyBagNumber) {
		this.everyBagNumber = everyBagNumber;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getStorageLocation() {
		return storageLocation;
	}
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	public String getBatchNo() {
		return batchNo;
	}
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	public String getEnvironmentalFlag() {
		return environmentalFlag;
	}
	public void setEnvironmentalFlag(String environmentalFlag) {
		this.environmentalFlag = environmentalFlag;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}
	public String getProduceDate() {
		return produceDate;
	}
	public void setProduceDate(String produceDate) {
		this.produceDate = produceDate;
	}
	public String getProduceBatchNo() {
		return produceBatchNo;
	}
	public void setProduceBatchNo(String produceBatchNo) {
		this.produceBatchNo = produceBatchNo;
	}
	public String getStoreClass() {
		return storeClass;
	}
	public void setStoreClass(String storeClass) {
		this.storeClass = storeClass;
	}
	
}
