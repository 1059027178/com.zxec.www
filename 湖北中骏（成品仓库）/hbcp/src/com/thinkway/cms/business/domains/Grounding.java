package com.thinkway.cms.business.domains;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * 上架
 * 
 * @author welson
 * @version 1.0
 */

public class Grounding implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private Integer groundingId = null;			

	public Integer getGroundingId() {
		return groundingId;
	}
	public void setGroundingId(Integer groundingId) {
		this.groundingId = groundingId;
	}
	
	private String matnr;
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	private String werks;
	public String getWerks() {
		return werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	private String lgort;
	public String getLgort() {
		return lgort;
	}
	public void setLgort(String lgort) {
		this.lgort = lgort;
	}
	private String meng;
	public String getMeng() {
		return meng;
	}
	public void setMeng(String meng) {
		this.meng = meng;
	}
	private String charg;
	public String getCharg() {
		return charg;
	}
	public void setCharg(String charg) {
		this.charg = charg;
	}
	private String meins;
	public String getMeins() {
		return meins;
	}
	public void setMeins(String meins) {
		this.meins = meins;
	}
	private String sobkz;
	public String getSobkz() {
		return sobkz;
	}
	public void setSobkz(String sobkz) {
		this.sobkz = sobkz;
	}
	private String sonum;
	public String getSonum() {
		return sonum;
	}
	public void setSonum(String sonum) {
		this.sonum = sonum;
	}
	private String nltyp;
	public String getNltyp() {
		return nltyp;
	}
	public void setNltyp(String nltyp) {
		this.nltyp = nltyp;
	}
	private String nlpla;
	public String getNlpla() {
		return nlpla;
	}
	public void setNlpla(String nlpla) {
		this.nlpla = nlpla;
	}
	private String boxs;

	public String getBoxs() {
		return boxs;
	}
	public void setBoxs(String boxs) {
		this.boxs = boxs;
	}
	private String wemng;

	public String getWemng() {
		return wemng;
	}
	public void setWemng(String wemng) {
		this.wemng = wemng;
	}
}