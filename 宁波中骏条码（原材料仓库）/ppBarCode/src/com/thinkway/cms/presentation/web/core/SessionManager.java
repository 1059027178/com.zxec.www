package com.thinkway.cms.presentation.web.core;

import javax.servlet.http.HttpSession;

/**
 * 
 * @author Matt
 *
 */
public class SessionManager {
	
	//session names
	public static final String USER_ID = "soapos.http.session.user_id";
	public static final String USER_NAME = "soapos.http.session.user_name";
	public static final String USER_BH = "soapos.http.session.user_bh";
	public static final String USER_PWD = "soapos.http.session.user_pwd";
	public static final String COMPANY_ID = "soapos.http.session.company_id";
	/**
	 * 使Session无效, 用户登出时使用
	 * @param session
	 */
	public static void invalidate(HttpSession session){
		session.invalidate();
	}
}
