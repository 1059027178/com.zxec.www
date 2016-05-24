package com.exampleCode.model;
/**
 * 领料订单信息
 * @author YangYang
 *
 */
public class BillsInfo {
	
	private String billsNO;  /*领料单号*/
	
	private String itemNO;  /*物料编码*/
	
	private String number;  /*领用数量*/

	private String batchNO; /*批次*/
	
	private String useNumber; /*已领用数量*/

	public String getBillsNO() {
		return billsNO;
	}

	public void setBillsNO(String billsNO) {
		this.billsNO = billsNO;
	}

	public String getItemNO() {
		return itemNO;
	}

	public void setItemNO(String itemNO) {
		this.itemNO = itemNO;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBatchNO() {
		return batchNO;
	}

	public void setBatchNO(String batchNO) {
		this.batchNO = batchNO;
	}

	public String getUseNumber() {
		return useNumber;
	}

	public void setUseNumber(String useNumber) {
		this.useNumber = useNumber;
	}
	
}
