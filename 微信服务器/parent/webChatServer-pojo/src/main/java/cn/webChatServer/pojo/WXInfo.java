package cn.webChatServer.pojo;

import java.io.Serializable;

/**
 * 对应后台表：WXINFO
 * 手动编写：
 * 微信企业号基础信息类
 * @author qianyang
 *
 */
public class WXInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 服务器外网访问地址
	 */
	private String address;
	
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
	 * 接口调用凭证有效时间
	 */
	private String accessTokenExpiresIn;
	
	/**
	 * JS接口调用凭证
	 */
	private String JSAPITicket;
	/**
	 * JS接口调用凭证有效时间
	 */
	private String JSAPITicketExpiresIn;
	/**
	 * JS接口调用记录时间戳（单位：秒）(获取方式：当前时间戳+jsapi有效时间-200)
	 */
	private String ticketTimestamp;

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

	public String getAccessTokenExpiresIn() {
		return accessTokenExpiresIn;
	}

	public void setAccessTokenExpiresIn(String accessTokenExpiresIn) {
		this.accessTokenExpiresIn = accessTokenExpiresIn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getJSAPITicketExpiresIn() {
		return JSAPITicketExpiresIn;
	}

	public void setJSAPITicketExpiresIn(String jSAPITicketExpiresIn) {
		JSAPITicketExpiresIn = jSAPITicketExpiresIn;
	}

	public String getTicketTimestamp() {
		return ticketTimestamp;
	}

	public void setTicketTimestamp(String ticketTimestamp) {
		this.ticketTimestamp = ticketTimestamp;
	}
}
