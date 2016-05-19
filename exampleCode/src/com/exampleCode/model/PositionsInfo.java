package com.exampleCode.model;
/**
 * @value 仓位信息
 * @author qianyang
 *
 */
public class PositionsInfo {
	
	private String storageLocation;	   /*库存地点*/ 
	 
	private String factoryNO				;	    /*工厂*/ 

	private String warehouseNO			;	   /*仓库号*/ 
	 
	private String literaNO				;	    /*仓位号*/ 

	private String batchNO					;	   /*批次*/

	private String number					;	    /*数量*/ 

	private String unit						;	    /*单位*/   
	 
	private String itemNO					;	    /*物料编号*/

	private String itemDescription;	    /*物料描述*/ 

	private String supplierBatch		;	    /*供应商批次*/

	private String supplierProductDate ;  /*供应商生产日期*/

	public String getStorageLocation() {
		return storageLocation;
	}

	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}

	public String getFactoryNO() {
		return factoryNO;
	}

	public void setFactoryNO(String factoryNO) {
		this.factoryNO = factoryNO;
	}

	public String getWarehouseNO() {
		return warehouseNO;
	}

	public void setWarehouseNO(String warehouseNO) {
		this.warehouseNO = warehouseNO;
	}

	public String getLiteraNO() {
		return literaNO;
	}

	public void setLiteraNO(String literaNO) {
		this.literaNO = literaNO;
	}

	public String getBatchNO() {
		return batchNO;
	}

	public void setBatchNO(String batchNO) {
		this.batchNO = batchNO;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getItemNO() {
		return itemNO;
	}

	public void setItemNO(String itemNO) {
		this.itemNO = itemNO;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getSupplierBatch() {
		return supplierBatch;
	}

	public void setSupplierBatch(String supplierBatch) {
		this.supplierBatch = supplierBatch;
	}

	public String getSupplierProductDate() {
		return supplierProductDate;
	}

	public void setSupplierProductDate(String supplierProductDate) {
		this.supplierProductDate = supplierProductDate;
	}
	
}
