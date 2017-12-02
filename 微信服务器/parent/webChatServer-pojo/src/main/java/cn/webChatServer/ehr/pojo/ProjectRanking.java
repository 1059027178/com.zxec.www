package cn.webChatServer.ehr.pojo;

import java.io.Serializable;

public class ProjectRanking implements Serializable{
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 3425132972713186873L;
	private String userNo;	   //工号
	private String name;	   //姓名
	private String years;//排名时间(年、年月)
	private String thingNo;	   	//事假排名
	private String sickLeaveNo;	//病假排名
	private String adjustResetNo;	//调休排名
	private String stayNo;	   		//公出排名
	private String overtimeNo;	    //加班排名
	private String flag;	    //数据标志(1、2:月度部门、公司排名;3、4:年度部门、公司排名)
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getThingNo() {
		return thingNo;
	}
	public void setThingNo(String thingNo) {
		this.thingNo = thingNo;
	}
	public String getSickLeaveNo() {
		return sickLeaveNo;
	}
	public void setSickLeaveNo(String sickLeaveNo) {
		this.sickLeaveNo = sickLeaveNo;
	}
	public String getAdjustResetNo() {
		return adjustResetNo;
	}
	public void setAdjustResetNo(String adjustResetNo) {
		this.adjustResetNo = adjustResetNo;
	}
	public String getStayNo() {
		return stayNo;
	}
	public void setStayNo(String stayNo) {
		this.stayNo = stayNo;
	}
	public String getOvertimeNo() {
		return overtimeNo;
	}
	public void setOvertimeNo(String overtimeNo) {
		this.overtimeNo = overtimeNo;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}
