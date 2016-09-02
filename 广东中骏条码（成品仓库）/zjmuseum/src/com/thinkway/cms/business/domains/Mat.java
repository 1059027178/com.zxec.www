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

public class Mat implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private String xuhao=null;//序号
	private String matnr=null;//物料编码
	private String charg=null;//批次 
	private String lgpla=null;//仓位
	private String sobkz=null;//特殊标识
	private String lgort=null;//库存地点
	private String verme=null;//数量
	private String meins=null;//单位
	
	public String getXuhao() {
		return xuhao;
	}
	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public String getLgpla() {
		return lgpla;
	}
	public void setLgpla(String lgpla) {
		this.lgpla = lgpla;
	}
	public String getSobkz() {
		return sobkz;
	}
	public void setSobkz(String sobkz) {
		this.sobkz = sobkz;
	}
	public String getCharg() {
		return charg;
	}
	public void setCharg(String charg) {
		this.charg = charg;
	}
	public String getLgort() {
		return lgort;
	}
	public void setLgort(String lgort) {
		this.lgort = lgort;
	}
	public String getVerme() {
		return verme;
	}
	public void setVerme(String verme) {
		this.verme = verme;
	}
	public String getMeins() {
		return meins;
	}
	public void setMeins(String meins) {
		this.meins = meins;
	}
	
	
}