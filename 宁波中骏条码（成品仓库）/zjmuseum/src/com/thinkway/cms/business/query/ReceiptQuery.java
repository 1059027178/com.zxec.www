package com.thinkway.cms.business.query;

import java.sql.Timestamp;

/**
 *
 * 生产订单收货
 * 
 * @author welson
 * @version 1.0
 */

public class ReceiptQuery  extends BaseQuery{
	private static final long serialVersionUID = 3569000815676233872L;
	private Integer receiptId = null;				
	public Integer getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(Integer receiptId) {
		this.receiptId = receiptId;
	}
 
	private String aufnr;
	public String getAufnr() {
		return aufnr;
	}
	public void setAufnr(String aufnr) {
		this.aufnr = aufnr;
	}
	private String matnr;
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	private String maktx;
	public String getMaktx() {
		return maktx;
	}
	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}
	private String bs;
	public String getBs() {
		return bs;
	}
	public void setBs(String bs) {
		this.bs = bs;
	}
	private String meng;
	public String getMeng() {
		return meng;
	}
	public void setMeng(String meng) {
		this.meng = meng;
	}
	private String boxes;
	public String getBoxes() {
		return boxes;
	}
	public void setBoxes(String boxes) {
		this.boxes = boxes;
	}
	private String charg;
	public String getCharg() {
		return charg;
	}
	public void setCharg(String charg) {
		this.charg = charg;
	}
	private String wemng;
	public String getWemng() {
		return wemng;
	}
	public void setWemng(String wemng) {
		this.wemng = wemng;
	}
	private String meins;
	public String getMeins() {
		return meins;
	}
	public void setMeins(String meins) {
		this.meins = meins;
	}
	private String lgort;
	public String getLgort() {
		return lgort;
	}
	public void setLgort(String lgort) {
		this.lgort = lgort;
	}
	private String sobkz;
	public String getSobkz() {
		return sobkz;
	}
	public void setSobkz(String sobkz) {
		this.sobkz = sobkz;
	}

}