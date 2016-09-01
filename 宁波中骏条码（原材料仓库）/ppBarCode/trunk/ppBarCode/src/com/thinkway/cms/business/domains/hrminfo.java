package com.thinkway.cms.business.domains;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * 人员信息
 * 
 * @author welson
 * @version 1.0
 */

public class hrminfo implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private Integer hrminfoId = null;			

	public Integer gethrminfoId() {
		return hrminfoId;
	}
	public void sethrminfoId(Integer hrminfoId) {
		this.hrminfoId = hrminfoId;
	}
	
	private String objno;
	public String getObjno() {
		return objno;
	}
	public void setObjno(String objno) {
		this.objno = objno;
	}
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String department;
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	private String sex;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

}