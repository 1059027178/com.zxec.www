package com.thinkway.cms.business.domains;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * 生产订单收货
 * 
 * @author welson
 * @version 1.0
 */

public class Repertory  implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private String lgnum;
	private String lgtyp;
	private String nlpla;
	public String getLgnum() {
		return lgnum;
	}
	public void setLgnum(String lgnum) {
		this.lgnum = lgnum;
	}
	public String getLgtyp() {
		return lgtyp;
	}
	public void setLgtyp(String lgtyp) {
		this.lgtyp = lgtyp;
	}
	public String getNlpla() {
		return nlpla;
	}
	public void setNlpla(String nlpla) {
		this.nlpla = nlpla;
	}
}