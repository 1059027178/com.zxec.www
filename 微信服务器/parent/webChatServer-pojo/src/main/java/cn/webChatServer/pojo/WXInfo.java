package cn.webChatServer.pojo;

import java.io.Serializable;

/**
 * 手动编写：
 * 微信企业号基础信息类
 * @author qianyang
 *
 */
public class WXInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	/**
	 * 数据类别
	 */
	private String className;

	/**
	 * 企业id
	 */
	private String corpID;
	
	/**
	 * 管理组凭证id
	 */
	private String secretID;
	
	/**
	 * 接口调用凭证
	 */
	private String accessToken;
	
	/**
	 * JS接口调用凭证
	 */
	private String JSAPITicket;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getCorpID() {
		return corpID;
	}

	public void setCorpID(String corpID) {
		this.corpID = corpID;
	}

	public String getSecretID() {
		return secretID;
	}

	public void setSecretID(String secretID) {
		this.secretID = secretID;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getJSAPITicket() {
		return JSAPITicket;
	}

	public void setJSAPITicket(String jSAPITicket) {
		JSAPITicket = jSAPITicket;
	}
}
