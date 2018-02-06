package cn.webChatServer.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应后台表：SIDIGONGZI
 * @author qianyang 电子工资条
 */

public class Salary implements Serializable {

	private static final long serialVersionUID = -1746939669793452520L;

	private int idNo; // id（主键）
	private String patbm; // 工资套编号
	private String area; // 地区
	private String ny; // 年月
	private String gzffgs; // 工资发放归属
	private String bj; // 部级
	private String kj; // 课级
	private String gh; // 工号
	private String xm; // 姓名
	private String gwmc; // 岗位名称
	private String gwlb; // 岗位类别
	private String zwlb; // 职务类别
	private String zd; // 职等
	private String jbgz; // 基本工资
	private String gwjt; // 岗位津贴
	private String jnjt; // 技能津贴
	private String xjjj; // 绩效奖金
	private String jggzze; // 结构工资总额
	private String xjkh; // 绩效考核
	private String psjbxs; // 平时加班小时
	private String psjbf; // 平时加班费
	private String zmjbxs; // 周末加班小时
	private String zmjbf; // 周末加班费
	private String jrjbxs; // 假日加班小时
	private String jrjbf; // 假日加班费
	private String jbfhj; // 加班费合计
	private String ybbz; // 夜班补助
	private String gwbz; // 高温补助
	private String qqj; // 全勤奖 +
	private String qtbz; // 其他补助/调 整
	private String bzjj; // 补助结计
	private String qtjl; // 其他奖励
	private String flcb; // 福利—餐补
	private String kqtz; // 考勤调整
	private String yfgz; // 应付工资
	private String gryanglao; // 个人养老
	private String gryiliao; // 个人医疗
	private String grgjj; // 个人公积金
	private String sqgz; // 税前工资
	private String sds; // 所得税
	private String zsf; // 住宿\水电费
	private String axjj; // 爱心基及调整项
	private String sfgz; // 实发工资
	private String gryhzh; // 个人银行帐号
	private String sfzhm; // 身份证号码
	private String gxqydw; // 高新企业单位
	private String gxqybm; // 高新企业部门
	private String ssxm; // 所属项目
	private String gssbf; // 公司社保费
	private String gsgjj; // 公司公积金
	private String xzcb; // 薪资成本
	private String ycqts; // 应出勤天数
	private String sjcqts; // 实际出勤天数
	private Date lzsj; // 离职时间
	private Date rcsj; // 入职时间
	private String grsb; // 个人社保
	public int getIdNo() {
		return idNo;
	}
	public void setIdNo(int idNo) {
		this.idNo = idNo;
	}
	public String getPatbm() {
		return patbm;
	}
	public void setPatbm(String patbm) {
		this.patbm = patbm;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getNy() {
		return ny;
	}
	public void setNy(String ny) {
		this.ny = ny;
	}
	public String getGzffgs() {
		return gzffgs;
	}
	public void setGzffgs(String gzffgs) {
		this.gzffgs = gzffgs;
	}
	public String getBj() {
		return bj;
	}
	public void setBj(String bj) {
		this.bj = bj;
	}
	public String getKj() {
		return kj;
	}
	public void setKj(String kj) {
		this.kj = kj;
	}
	public String getGh() {
		return gh;
	}
	public void setGh(String gh) {
		this.gh = gh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getGwmc() {
		return gwmc;
	}
	public void setGwmc(String gwmc) {
		this.gwmc = gwmc;
	}
	public String getGwlb() {
		return gwlb;
	}
	public void setGwlb(String gwlb) {
		this.gwlb = gwlb;
	}
	public String getZwlb() {
		return zwlb;
	}
	public void setZwlb(String zwlb) {
		this.zwlb = zwlb;
	}
	public String getZd() {
		return zd;
	}
	public void setZd(String zd) {
		this.zd = zd;
	}
	public String getJbgz() {
		return jbgz;
	}
	public void setJbgz(String jbgz) {
		this.jbgz = jbgz;
	}
	public String getGwjt() {
		return gwjt;
	}
	public void setGwjt(String gwjt) {
		this.gwjt = gwjt;
	}
	public String getJnjt() {
		return jnjt;
	}
	public void setJnjt(String jnjt) {
		this.jnjt = jnjt;
	}
	public String getXjjj() {
		return xjjj;
	}
	public void setXjjj(String xjjj) {
		this.xjjj = xjjj;
	}
	public String getJggzze() {
		return jggzze;
	}
	public void setJggzze(String jggzze) {
		this.jggzze = jggzze;
	}
	public String getXjkh() {
		return xjkh;
	}
	public void setXjkh(String xjkh) {
		this.xjkh = xjkh;
	}
	public String getPsjbxs() {
		return psjbxs;
	}
	public void setPsjbxs(String psjbxs) {
		this.psjbxs = psjbxs;
	}
	public String getPsjbf() {
		return psjbf;
	}
	public void setPsjbf(String psjbf) {
		this.psjbf = psjbf;
	}
	public String getZmjbxs() {
		return zmjbxs;
	}
	public void setZmjbxs(String zmjbxs) {
		this.zmjbxs = zmjbxs;
	}
	public String getZmjbf() {
		return zmjbf;
	}
	public void setZmjbf(String zmjbf) {
		this.zmjbf = zmjbf;
	}
	public String getJrjbxs() {
		return jrjbxs;
	}
	public void setJrjbxs(String jrjbxs) {
		this.jrjbxs = jrjbxs;
	}
	public String getJrjbf() {
		return jrjbf;
	}
	public void setJrjbf(String jrjbf) {
		this.jrjbf = jrjbf;
	}
	public String getJbfhj() {
		return jbfhj;
	}
	public void setJbfhj(String jbfhj) {
		this.jbfhj = jbfhj;
	}
	public String getYbbz() {
		return ybbz;
	}
	public void setYbbz(String ybbz) {
		this.ybbz = ybbz;
	}
	public String getGwbz() {
		return gwbz;
	}
	public void setGwbz(String gwbz) {
		this.gwbz = gwbz;
	}
	public String getQqj() {
		return qqj;
	}
	public void setQqj(String qqj) {
		this.qqj = qqj;
	}
	public String getQtbz() {
		return qtbz;
	}
	public void setQtbz(String qtbz) {
		this.qtbz = qtbz;
	}
	public String getBzjj() {
		return bzjj;
	}
	public void setBzjj(String bzjj) {
		this.bzjj = bzjj;
	}
	public String getQtjl() {
		return qtjl;
	}
	public void setQtjl(String qtjl) {
		this.qtjl = qtjl;
	}
	public String getFlcb() {
		return flcb;
	}
	public void setFlcb(String flcb) {
		this.flcb = flcb;
	}
	public String getKqtz() {
		return kqtz;
	}
	public void setKqtz(String kqtz) {
		this.kqtz = kqtz;
	}
	public String getYfgz() {
		return yfgz;
	}
	public void setYfgz(String yfgz) {
		this.yfgz = yfgz;
	}
	public String getGryanglao() {
		return gryanglao;
	}
	public void setGryanglao(String gryanglao) {
		this.gryanglao = gryanglao;
	}
	public String getGryiliao() {
		return gryiliao;
	}
	public void setGryiliao(String gryiliao) {
		this.gryiliao = gryiliao;
	}
	public String getGrgjj() {
		return grgjj;
	}
	public void setGrgjj(String grgjj) {
		this.grgjj = grgjj;
	}
	public String getSqgz() {
		return sqgz;
	}
	public void setSqgz(String sqgz) {
		this.sqgz = sqgz;
	}
	public String getSds() {
		return sds;
	}
	public void setSds(String sds) {
		this.sds = sds;
	}
	public String getZsf() {
		return zsf;
	}
	public void setZsf(String zsf) {
		this.zsf = zsf;
	}
	public String getAxjj() {
		return axjj;
	}
	public void setAxjj(String axjj) {
		this.axjj = axjj;
	}
	public String getSfgz() {
		return sfgz;
	}
	public void setSfgz(String sfgz) {
		this.sfgz = sfgz;
	}
	public String getGryhzh() {
		return gryhzh;
	}
	public void setGryhzh(String gryhzh) {
		this.gryhzh = gryhzh;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	public String getGxqydw() {
		return gxqydw;
	}
	public void setGxqydw(String gxqydw) {
		this.gxqydw = gxqydw;
	}
	public String getGxqybm() {
		return gxqybm;
	}
	public void setGxqybm(String gxqybm) {
		this.gxqybm = gxqybm;
	}
	public String getSsxm() {
		return ssxm;
	}
	public void setSsxm(String ssxm) {
		this.ssxm = ssxm;
	}
	public String getGssbf() {
		return gssbf;
	}
	public void setGssbf(String gssbf) {
		this.gssbf = gssbf;
	}
	public String getGsgjj() {
		return gsgjj;
	}
	public void setGsgjj(String gsgjj) {
		this.gsgjj = gsgjj;
	}
	public String getXzcb() {
		return xzcb;
	}
	public void setXzcb(String xzcb) {
		this.xzcb = xzcb;
	}
	public String getYcqts() {
		return ycqts;
	}
	public void setYcqts(String ycqts) {
		this.ycqts = ycqts;
	}
	public String getSjcqts() {
		return sjcqts;
	}
	public void setSjcqts(String sjcqts) {
		this.sjcqts = sjcqts;
	}
	public Date getLzsj() {
		return lzsj;
	}
	public void setLzsj(Date lzsj) {
		this.lzsj = lzsj;
	}
	public Date getRcsj() {
		return rcsj;
	}
	public void setRcsj(Date rcsj) {
		this.rcsj = rcsj;
	}
	public String getGrsb() {
		return grsb;
	}
	public void setGrsb(String grsb) {
		this.grsb = grsb;
	}
	
}
