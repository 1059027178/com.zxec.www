package cn.webChatServer.mes.pojo;

import java.io.Serializable;
/**
 * 产量查询-传入信息
 * @author qianyang
 *
 */
public class MyOutputIntoParms implements Serializable{
	private static final long serialVersionUID = 4203609862100810988L;
	 //员工工号
    private String userNo;
    //员工姓名
    private String userName;
    //查询开始日期，格式："yyyy-MM-dd"
    private String startDate;
    //查询结束日期，格式："yyyy-MM-dd"
    private String endDate;
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
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "MyOutputIntoParms [userNo=" + userNo + ", userName=" + userName
				+ ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
}
