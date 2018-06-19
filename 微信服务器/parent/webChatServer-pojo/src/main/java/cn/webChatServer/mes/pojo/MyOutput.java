/**
  * Copyright 2018 bejson.com 
  */
package cn.webChatServer.mes.pojo;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *个人产量信息
 *【注意：此处使用了反射获取字段名，所以不允许修改成员变量的顺序，若需添加字段请在最后一个成员变量后添加】
 * @author qianyang
 * @since 2018-06-05
 */
public class MyOutput implements Serializable{
	private static final long serialVersionUID = 6140507111371511019L;
	//调用标识，成功为true，失败必须返回message信息
    private boolean status;
    //成功或失败信息，失败时该信息直接显示给用户
    private String message;
    //员工工号
    private String userNo;
    //员工姓名
    private String userName;
    //查询开始日期，格式："yyyy-MM-dd"
    private String startDate;
    //查询结束日期，格式："yyyy-MM-dd"
    private String endDate;
    //输出数据对象：产量明细
    private List<MyOutputDetailData> detailData;
    public void setStatus(boolean status) {
         this.status = status;
     }
     public boolean getStatus() {
         return status;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setUserNo(String userNo) {
         this.userNo = userNo;
     }
     public String getUserNo() {
         return userNo;
     }

    public void setUserName(String userName) {
         this.userName = userName;
     }
     public String getUserName() {
         return userName;
     }
    public void setStartDate(String startDate) {
         this.startDate = startDate;
     }
     public String getStartDate() {
         return startDate;
     }

    public void setEndDate(String endDate) {
         this.endDate = endDate;
     }
     public String getEndDate() {
         return endDate;
     }
	public List<MyOutputDetailData> getDetailData() {
		return detailData;
	}
	public void setDetailData(List<MyOutputDetailData> detailData) {
		this.detailData = detailData;
	}
	@Override
	public String toString() {
		return "MyOutput [status=" + status + ", message=" + message
				+ ", userNo=" + userNo + ", userName=" + userName
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", detailData=" + detailData + "]";
	}
}
