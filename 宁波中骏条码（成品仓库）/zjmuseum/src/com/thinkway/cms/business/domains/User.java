package com.thinkway.cms.business.domains;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 * 用户:使用本软件的登录用户
 * 
 * @author welson
 * @version 1.0
 */

public class User implements Serializable {
	private static final long serialVersionUID = 3569000815676233872L;
    private Integer userId = null;					//用户ID
    private String userBH = null;					//用户编号
    private String userName = null;					//用户名
    private String userPassword = null;				//用户密码
    
    private String userFunction = null;				//用户权限
	
	private String createUser = null;				//创建人员
	private String createDate = null;			//创建日期
	private String updateUser = null;				//更新人员
	private String updateDate = null;			//更新日期
	private String ckCode = null;					//登录验证码
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getCkCode() {
		return ckCode;
	}
	public void setCkCode(String ckCode) {
		this.ckCode = ckCode;
	}
	public String getUserFunction() {
		return userFunction;
	}
	public void setUserFunction(String userFunction) {
		this.userFunction = userFunction;
	}
	public String getUserBH() {
		return userBH;
	}
	public void setUserBH(String userBH) {
		this.userBH = userBH;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
}
