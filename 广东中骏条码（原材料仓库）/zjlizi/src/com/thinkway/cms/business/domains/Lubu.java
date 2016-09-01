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

public class Lubu  implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private int xuhao;
	private String matnr;
	private String sobkz;
	private String maktx;
	private String charg;
	private String gesme;
	private String letyp;
	private String werks;
	private String lgort;
	private String sonum;
	private String meins;
	private String tdatu;  
	private String ubnum;
	/**
	 * 20160622:
	 * qianyang新增
	 */
	private String lgtyp;
	private String lgpla;
	private String verme;
	private String lqnum;
	public String getlgtyp() {
		return lgtyp;
	}
	public void setLgtyp(String lgtyp) {
		this.lgtyp = lgtyp;
	}
	public String getLgpla() {
		return lgpla;
	}
	public void setLgpla(String lgpla) {
		this.lgpla = lgpla;
	}
	public String getVerme() {
		return verme;
	}
	public void setVerme(String verme) {
		this.verme = verme;
	}
	public String getLqnum() {
		return lqnum;
	}
	public void setLqnum(String lqnum) {
		this.lqnum = lqnum;
	}
	public int getXuhao() {
		return xuhao;
	}
	public void setXuhao(int xuhao) {
		this.xuhao = xuhao;
	}
	public String getMatnr() {
		return matnr;
	}
	public void setMatnr(String matnr) {
		this.matnr = matnr;
	}
	public String getSobkz() {
		return sobkz;
	}
	public void setSobkz(String sobkz) {
		this.sobkz = sobkz;
	}
	public String getMaktx() {
		return maktx;
	}
	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}
	public String getCharg() {
		return charg;
	}
	public void setCharg(String charg) {
		this.charg = charg;
	}
	public String getGesme() {
		return gesme;
	}
	public void setGesme(String gesme) {
		this.gesme = gesme;
	}
	public String getLetyp() {
		return letyp;
	}
	public void setLetyp(String letyp) {
		this.letyp = letyp;
	}
	public String getWerks() {
		return werks;
	}
	public void setWerks(String werks) {
		this.werks = werks;
	}
	public String getLgort() {
		return lgort;
	}
	public void setLgort(String lgort) {
		this.lgort = lgort;
	}
	public String getSonum() {
		return sonum;
	}
	public void setSonum(String sonum) {
		this.sonum = sonum;
	}
	public String getMeins() {
		return meins;
	}
	public void setMeins(String meins) {
		this.meins = meins;
	}
	public String getTdatu() {
		return tdatu;
	}
	public void setTdatu(String tdatu) {
		this.tdatu = tdatu;
	}
	public String getUbnum() {
		return ubnum;
	}
	public void setUbnum(String ubnum) {
		this.ubnum = ubnum;
	}
}