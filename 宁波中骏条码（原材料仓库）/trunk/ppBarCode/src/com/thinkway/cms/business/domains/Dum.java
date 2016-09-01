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

public class Dum implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private String tanum = null;		//转储单
	private String posnr = null;//行项目号
	private String matnr = null; //物料号 
	private String charg = null;	//批次
	private String vsolm = null;//源发地目标数量,按库存单位计(数量)
	private String bname = null;//创建者
	private String zeugn=null; //证书号
	private String vdifm = null;//源仓位
	//源托盘
	private String nplei = null;//目标仓位
	//目标托盘

	public String getTanum() {
		return tanum;
	}
	public void setTanum(String tanum) {
		this.tanum = tanum;
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
	public String getCharg() {
		return charg;
	}
	public void setCharg(String charg) {
		this.charg = charg;
	}
	public String getVsolm() {
		return vsolm;
	}
	public void setVsolm(String vsolm) {
		this.vsolm = vsolm;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getZeugn() {
		return zeugn;
	}
	public void setZeugn(String zeugn) {
		this.zeugn = zeugn;
	}
	public String getVdifm() {
		return vdifm;
	}
	public void setVdifm(String vdifm) {
		this.vdifm = vdifm;
	}
	public String getNplei() {
		return nplei;
	}
	public void setNplei(String nplei) {
		this.nplei = nplei;
	}
}