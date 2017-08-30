<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我要报工</title>
    
    <link href="../././plugs/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src=".././plugs/jquery/jquery-3.2.1.min.js"></script>
    <script src=".././plugs/bootstrap-3.3.7/js/bootstrap.min.js"></script>
	
  </head>
  
  <body>
    工号：<input class="userNo" name="userNo" value="${userNo }"/><br />
   姓名： <input class="userName" name="userName" value="${userName }"/>
    登录成功！！！<br />
<button type="button" class="btn btn-warning">警告按钮</button>
  </body>
  
</html>

