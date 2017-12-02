package cn.webChatServer.pojo;

import java.io.Serializable;
import java.util.Date;
/**
 * 考勤信息查询
 * @author qianyang
 * @since 2017-10-30
 */
public class CheckInfo implements Serializable{
	/**
	 * 生成唯一序列
	 */
	private static final long serialVersionUID = 1166549515927957915L;
	private String  id;				/*id*/
	private String 	name;			/*姓名*/
	private String 	userId;			/*工号*/
	private Date 	checkDate;		/*考勤日期*/
	private String 	checkDay;		/*考勤日期（yyyy-mm-dd）*/
	private String	checkSecond; 	/*考勤日期（hh:mm:ss）*/
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}
	public String getCheckDay() {
		return checkDay;
	}
	public void setCheckDay(String checkDay) {
		this.checkDay = checkDay;
	}
	public String getCheckSecond() {
		return checkSecond;
	}
	public void setCheckSecond(String checkSecond) {
		this.checkSecond = checkSecond;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
