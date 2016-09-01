package com.thinkway.cms.business.domains;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户日志
 * 
 * @author welson
 * @version 1.0
 */


public class DeliveryLog implements Serializable {
	private static final long serialVersionUID = 3569000815676233872L;
	private Integer id = null;				//日志ID
	private String dataObj = null;			//物理表名
	private String dataObjText = null;		//物理表名描述
	private String objPrimaryKey = null;	//物理表主键ID，比如帐套表的单据编号
    private String operationContent = null;	//操作内容
    private String userName = null;			//操作人
    private String operationDate = null;	//操作时间
	
	public String getDataObj() {
		return dataObj;
	}
	public void setDataObj(String dataObj) {
		this.dataObj = dataObj;
	}
	public String getDataObjText() {
		return dataObjText;
	}
	public void setDataObjText(String dataObjText) {
		this.dataObjText = dataObjText;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getObjPrimaryKey() {
		return objPrimaryKey;
	}
	public void setObjPrimaryKey(String objPrimaryKey) {
		this.objPrimaryKey = objPrimaryKey;
	}
	public String getOperationContent() {
		return operationContent;
	}
	public void setOperationContent(String operationContent) {
		this.operationContent = operationContent;
	}
	
	public String getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		if(userName==null)
			userName = "zllc";
		this.userName = userName;
	}
	
}
