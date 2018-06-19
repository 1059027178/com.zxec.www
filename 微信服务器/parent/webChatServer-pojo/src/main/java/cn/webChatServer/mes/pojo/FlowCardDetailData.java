package cn.webChatServer.mes.pojo;

import java.io.Serializable;

/**
 * 流转卡信息明细
 * @author qianyang	
 * @since 2018-06-05
 */
public class FlowCardDetailData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1376476061007077509L;
	//员工工号
    private String userNo;
    //员工姓名
    private String userName;
    //工序名称
    private String processName;
    //报工数量
    private int count;
    
    public FlowCardDetailData(String userNo, String userName,
			String processName, int count) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.processName = processName;
		this.count = count;
	}
	public FlowCardDetailData() {
		super();
		// TODO Auto-generated constructor stub
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

    public void setProcessName(String processName) {
         this.processName = processName;
     }
     public String getProcessName() {
         return processName;
     }
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}