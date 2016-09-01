<%@ page language="java" contentType="text/html;charset=utf-8"%>

<%@ page import="com.crystaldecisions.sdk.framework.CrystalEnterprise"%>
<%@ page import="com.crystaldecisions.sdk.framework.ISessionMgr"%>
<%@ page import="com.crystaldecisions.sdk.framework.IEnterpriseSession"%>
<%@ page import="com.crystaldecisions.sdk.occa.security.ILogonTokenMgr"%>
<%@ page import="com.crystaldecisions.sdk.exception.SDKException" %>
<%@ page import="com.crystaldecisions.sdk.exception.SDKException.Serialization" %>

<html>
  <head>
    <title>logon BO</title>
  </head>
  <body>
<%  
String CMS = "sapbodev.jianxin.com"; //request.getParameter("server");
IEnterpriseSession enterpriseSession = (IEnterpriseSession)session.getAttribute("enterpriseSession");

if (enterpriseSession == null) {
	String userName = request.getParameter("uid").toUpperCase();
	String password = request.getParameter("pwd");
	String port = ":6400";
	String auth = "secSAPR3";
	
	try {
		ISessionMgr sessionMgr = CrystalEnterprise.getSessionMgr();
		enterpriseSession = sessionMgr.logon(userName, password, CMS+port, auth);
		
		session.setAttribute("enterpriseSession", enterpriseSession);
	} catch (SDKException e) {
		Serialization ser = new Serialization(e);
		String errorMessage = ser.getMessage();
		out.println(errorMessage);
		return;
	}
	out.println("new session");
} else {
	out.println("old session");
}

String token = enterpriseSession.getLogonTokenMgr().createWCAToken("",1,1);
String logonUrl = "http://"+CMS+":8080/BOE/BI/logon/start.do?ivsLogonToken="+token;
out.println("<br>"+logonUrl);

response.sendRedirect(logonUrl);
%>
  </body>
</html>

