package com.thinkway.cms.business.domains;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 用户日志
 * 
 * @author welson
 * @version 1.0
 */


public class DelLockUser implements Serializable {
	private static final long serialVersionUID = 3569000815676233872L;
	private Integer id = null;				//日志ID
	private String userid = null;			//物理表名
	private String username = null;		//物理表名描述
	private String vbeln = null;	//物理表主键ID，比如帐套表的单据编号
    private String lockdata = null;	//操作内容
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVbeln() {
		return vbeln;
	}
	public void setVbeln(String vbeln) {
		this.vbeln = vbeln;
	}
	public String getLockdata() {
		return lockdata;
	}
	public void setLockdata(String lockdata) {
		this.lockdata = lockdata;
	}
	
	
}
