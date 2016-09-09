package com.thinkway.cms.business.domains;

import java.io.Serializable;

public class Message  implements Serializable{
	private static final long serialVersionUID = 3569000815676233872L;
	private String type="";
	private String message="";
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
