<%@page import="cn.webChatServer.ehr.pojo.Holiday"%>
<%@page import="cn.webChatServer.pojo.Salary"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Holiday holiday  = (Holiday) request.getAttribute("holiday");
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的假期</title>
    <link href="../././plugs/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src=".././plugs/jquery/jquery-3.2.1.min.js"></script>
    <script src=".././plugs/bootstrap-3.3.7/js/bootstrap.min.js"></script>
  </head>
  <body>
	<br />出现按钮代表bootstrap引入成功！
	<button type="button" class="btn btn-warning">警告按钮</button><br/>
		<input TYPE="text" value="<%=holiday.getUserName()%>"/><br/>
		<input TYPE="text" value="<%=holiday.getUserNo()%>"/><br/>
		<input TYPE="text" value="<%=holiday.getDueAdjustReset()%>"/><br/>
		<input TYPE="text" value="<%=holiday.getDueYearHoliday()%>"/><br/>
		<input TYPE="text" value="<%=holiday.getUsableAdjustReset()%>"/><br/>
		<input TYPE="text" value="<%=holiday.getUsableYearHoliday()%>"/>
	  </body>
</html>
