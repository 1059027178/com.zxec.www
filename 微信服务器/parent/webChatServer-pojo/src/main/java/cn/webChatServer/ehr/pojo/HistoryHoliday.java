package cn.webChatServer.ehr.pojo;

import java.io.Serializable;

import com.webChatServer.util.MySalaryUtil;
/**
 * 历史假期信息（单位：天）
 * @author qianyang
 *
 */
public class HistoryHoliday implements Serializable{
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 4168589489221130511L;
	
	private String userNo;			/*工号*/
	private String name;			/*姓名*/
	private String grade;			/*职等*/
	private String usedYearHoliday;	/*已用年假*/
	private String usedAdjustReset;	/*已用调休*/
	private String usedSickLeave;	/*已用病假*/
	private String thingHoliday;	/*事假*/
	private String stay;			/*公出*/
	private String cardReissue;		/*补卡*/
	private String overtime;		/*加班*/
	private String years;			/*年份*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getUsedYearHoliday() {
		return usedYearHoliday;
	}
	public void setUsedYearHoliday(String usedYearHoliday) {
		this.usedYearHoliday = usedYearHoliday;
	}
	public String getUsedAdjustReset() {
		return usedAdjustReset;
	}
	public void setUsedAdjustReset(String usedAdjustReset) {
		this.usedAdjustReset = usedAdjustReset;
	}
	public String getUsedSickLeave() {
		return usedSickLeave;
	}
	public void setUsedSickLeave(String usedSickLeave) {
		this.usedSickLeave = usedSickLeave;
	}
	public String getThingHoliday() {
		return thingHoliday;
	}
	public void setThingHoliday(String thingHoliday) {
		this.thingHoliday = thingHoliday;
	}
	public String getStay() {
		return stay;
	}
	public void setStay(String stay) {
		this.stay = stay;
	}
	public String getCardReissue() {
		return cardReissue;
	}
	public void setCardReissue(String cardReissue) {
		this.cardReissue = cardReissue;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}
	public String getYear() {
		return years;
	}
	public void setYear(String years) {
		this.years = years;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
}
