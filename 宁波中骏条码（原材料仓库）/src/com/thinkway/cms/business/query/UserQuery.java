package com.thinkway.cms.business.query;
/**
 * 
 * 用户查询
 * 
 * @author welson
 * @version 1.0
 * 
 */
public class UserQuery extends BaseQuery {
	private Integer userId = null;

	private String userName = null;
	private String userBH = null;
	private String companyId = null;
	private String companyType = null;
	private Integer isAuthed = null;			//实名认证状态

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

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

	public String getUserBH() {
		return userBH;
	}

	public void setUserBH(String userBH) {
		this.userBH = userBH;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public Integer getIsAuthed() {
		return isAuthed;
	}

	public void setIsAuthed(Integer isAuthed) {
		this.isAuthed = isAuthed;
	}

}
