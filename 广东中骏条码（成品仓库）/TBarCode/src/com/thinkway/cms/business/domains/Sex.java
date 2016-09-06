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

public class Sex implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private String sexId = null;			
	private String sexName = null;
	public String getSexId() {
		return sexId;
	}
	public void setSexId(String sexId) {
		this.sexId = sexId;
	}
	public String getSexName() {
		return sexName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
	

}