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

public class DelOrdPic implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private String xuhao = null;		//序号
	private String vbeln = null;		//订单号
	
	private String posnr = null;//行项目号
	private String matnr = null; //物料号 
	private String maktx = null; //物料号 
	private String lfimg = null;	//实际已交货量（按销售单位）
	private String vrmke = null;	//销售单位 
	private String charg = null;	//批号
	
	private String meins=null;//单位
	private String plpos= null;//仓位位置
	private String lgpla = null;	//仓位
	private double verme = 0;	//库存数量
	private double rfmng=0;
	private String lgnum=null;
	private String active=null;
	public String getXuhao() {
		return xuhao;
	}
	public void setXuhao(String xuhao) {
		this.xuhao = xuhao;
	}
	
	public String getVbeln() {
		return vbeln;
	}
	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}
	public String getPosnr() {
		return posnr;
	}
	public void setPosnr(String posnr) {
		this.posnr = posnr;
	}
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
	public String getCharg() {
		return charg;
	}
	public void setCharg(String charg) {
		this.charg = charg;
	}
	public String getLgpla() {
		return lgpla;
	}
	public void setLgpla(String lgpla) {
		this.lgpla = lgpla;
	}
	public double getVerme() {
		return verme;
	}
	public void setVerme(double verme) {
		this.verme = verme;
	}
	public String getPlpos() {
		return plpos;
	}
	public void setPlpos(String plpos) {
		this.plpos = plpos;
	}
	public String getMeins() {
		return meins;
	}
	public void setMeins(String meins) {
		this.meins = meins;
	}
	public String getMaktx() {
		return maktx;
	}
	public void setMaktx(String maktx) {
		this.maktx = maktx;
	}
	public double getRfmng() {
		return rfmng;
	}
	public void setRfmng(double rfmng) {
		this.rfmng = rfmng;
	}
	public String getLgnum() {
		return lgnum;
	}
	public void setLgnum(String lgnum) {
		this.lgnum = lgnum;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	

}