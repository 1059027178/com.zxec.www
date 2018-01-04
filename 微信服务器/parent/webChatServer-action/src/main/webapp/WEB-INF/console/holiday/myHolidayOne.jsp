<%@page import="cn.webChatServer.ehr.pojo.Holiday"%>
<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
Holiday holiday = (Holiday) request.getAttribute("holiday");
String year = request.getAttribute("year").toString();
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
<style type="text/css">
	body{background-color: ghostwhite;}
	table{background-color: white;font-weight:bold;font-size:1.3em;}
	table td{border:1px solid #E6E6E6;}
	legend{background-color: white;}
	.showimg{background: url("../custom/img/Holiday01.png") center repeat;height:10em; margin-bottom:20px;}
</style>
</head>
<body>
<%if(holiday == null ){ %>
	<p style="color: red;font-size:20px;font-weight: bold;margin-top: 50px;">未查询到信息！</p>
<%}else{ %>
	<fieldset>
		<div class="showimg"></div>
		<table class="table table-hover">
			<tbody>
				<tr>
					<td><Strong>姓名</strong></td>
					<td>
						<%=holiday.getUserName() == null ? "": holiday.getUserName()%>
					</td>
				</tr>
				<tr>
					<td><Strong>工号</strong></td>
					<td>
						<%=holiday.getUserNo() == null ? "": holiday.getUserNo()%>
					</td>
				</tr>
				<tr>
					<td><Strong>假期年度</strong></td>
					<td>
						<%=year%> 年
					</td>
				</tr>
				<tr>
					<td><Strong>可用调休</strong></td>
					<td>
						<%=holiday.getUsableAdjustReset() == null ? "0": holiday.getUsableAdjustReset()%> 天
					</td>
				</tr>
				<tr>
					<td><Strong>可用年假</strong></td>
					<td>
						<%=holiday.getUsableYearHoliday() == null ? "0": holiday.getUsableYearHoliday()%> 天
					</td>
				</tr>
			</tbody>
		</table>
	</fieldset>
<%} %>
</body>
</html>
