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

public class MatDocu implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private String aufnr = null;		
	private String iquan = null;		
	private String gmein = null;
	public String getAufnr() {
		return aufnr;
	}
	public void setAufnr(String aufnr) {
		this.aufnr = aufnr;
	}
	public String getIquan() {
		return iquan;
	}
	public void setIquan(String iquan) {
		this.iquan = iquan;
	}
	public String getGmein() {
		return gmein;
	}
	public void setGmein(String gmein) {
		this.gmein = gmein;
	}		

	

}