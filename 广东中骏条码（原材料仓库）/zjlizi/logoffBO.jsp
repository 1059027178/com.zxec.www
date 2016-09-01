<%@ page language="java" contentType="text/html;charset=utf-8"%>

<%@ page import="com.crystaldecisions.sdk.framework.CrystalEnterprise"%>
<%@ page import="com.crystaldecisions.sdk.framework.ISessionMgr"%>
<%@ page import="com.crystaldecisions.sdk.framework.IEnterpriseSession"%>

<html>
  <head>
    <title>logoff BO</title>
  </head>
  <body>
<%  
IEnterpriseSession enterpriseSession = (IEnterpriseSession)session.getAttribute("enterpriseSession");

if (enterpriseSession != null) {
	session.removeAttribute("enterpriseSession");
	enterpriseSession.logoff();
	out.println("logoff session<br>");
}

out.println("logoffed");
%>
  </body>
</html>

