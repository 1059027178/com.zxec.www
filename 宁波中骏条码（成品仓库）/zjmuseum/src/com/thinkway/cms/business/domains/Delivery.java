package com.thinkway.cms.business.domains;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * 展厅
 * 
 * @author welson
 * @version 1.0
 */

public class Delivery implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private String matnr = null;//物料号
	private String lfimg = null;	//实际已交货量（按销售单位）
	private String vrmke = null;	//销售单位 
	private String maktx = null;	//物料描述
	private String vbeln=null;//发货单号
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public String getLfimg() {
		return lfimg;
	}
	public void setLfimg(String lfimg) {
		this.lfimg = lfimg;
	}
	public String getVrmke() {
		return vrmke;
	}
	public void setVrmke(String vrmke) {
		this.vrmke = vrmke;
	}
	public String getMaktx() {
		return maktx;
	}
	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}
	public String getVbeln() {
		return vbeln;
	}
	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}
	
}