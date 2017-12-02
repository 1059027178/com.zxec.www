package cn.webChatServer.ehr.pojo;

import java.io.Serializable;

import com.webChatServer.util.MySalaryUtil;

public class Holiday implements Serializable{
	
	private static final long serialVersionUID = 536238760434732006L;
	/**
	 * 工号
	 */
	private String userNo;
	/**
	 * 姓名
	 */
	private String userName;
	/**
	 * 可用调休
	 */
	private String usableAdjustReset;
	/**
	 * 应有调休
	 */
	private String dueAdjustReset;
	/**
	 * 应有年假
	 */
	private String dueYearHoliday;
	/**
	 * 可用年假
	 */
	private String usableYearHoliday;
	
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUsableAdjustReset() {
		return usableAdjustReset;
	}
	public void setUsableAdjustReset(String usableAdjustReset) {
		this.usableAdjustReset = usableAdjustReset;
	}
	public String getDueAdjustReset() {
		return dueAdjustReset;
	}
	public void setDueAdjustReset(String dueAdjustReset) {
		this.dueAdjustReset = dueAdjustReset;
	}
	public String getDueYearHoliday() {
		return dueYearHoliday;
	}
	public void setDueYearHoliday(String dueYearHoliday) {
		this.dueYearHoliday = dueYearHoliday;
	}
	public String getUsableYearHoliday() {
		return usableYearHoliday;
	}
	public void setUsableYearHoliday(String usableYearHoliday) {
		this.usableYearHoliday = usableYearHoliday;
	}
}
