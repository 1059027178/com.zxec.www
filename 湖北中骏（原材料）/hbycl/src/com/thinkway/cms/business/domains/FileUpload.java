package com.thinkway.cms.business.domains;

import java.io.Serializable;

public class FileUpload  implements Serializable{
	
	private static final long serialVersionUID = 3569000815676233872L;
	private Integer FJBH = null;
	private String DABH = null;
	private String WJM = null;

	private String BDLJ = null;
	private String BCLJ = null;
	private String ZSWJM = null;
	private String TJSJ = null;
	private String TJR = null;
	private String TJRXM = null;
	private Integer ZT = null;
	private String BHLX = null;



	public String getWJM() {
			return WJM;
	}

	public void setWJM(String wjm) {
		WJM = wjm;
	}

	public String getBDLJ() {
		return BDLJ;
	}

	public void setBDLJ(String bdlj) {
		BDLJ = bdlj;
	}

	public String getBCLJ() {
		return BCLJ;
	}

	public void setBCLJ(String bclj) {
		BCLJ = bclj;
	}

	public String getZSWJM() {
		return ZSWJM;
	}

	public void setZSWJM(String zswjm) {
		ZSWJM = zswjm;
	}

	public String getTJR() {
		return TJR;
	}

	public void setTJR(String tjr) {
		TJR = tjr;
	}

	public Integer getZT() {
		return ZT;
	}

	public void setZT(Integer zt) {
		ZT = zt;
	}

	public String getTJRXM() {
		return TJRXM;
	}

	public void setTJRXM(String tjrxm) {
		TJRXM = tjrxm;
	}

	public String getTJSJ() {
		return TJSJ;
	}

	public void setTJSJ(String tjsj) {
		TJSJ = tjsj;
	}

	public Integer getFJBH() {
		return FJBH;
	}

	public void setFJBH(Integer fjbh) {
		FJBH = fjbh;
	}

	public String getDABH() {
		return DABH;
	}

	public void setDABH(String dabh) {
		DABH = dabh;
	}

	public String getBHLX() {
		return BHLX;
	}

	public void setBHLX(String bhlx) {
		BHLX = bhlx;
	}

	
}
