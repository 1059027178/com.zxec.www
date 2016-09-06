<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<c:choose>
<c:when test="${not empty referUrl}">
<meta http-equiv="refresh" content="1;url=${referUrl}">
</c:when>
<c:otherwise>
<meta http-equiv="refresh" content="1;url=/main.do">
</c:otherwise>
</c:choose>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">

<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/bootstrap-responsive.css" rel="stylesheet">

 <!--[if lte IE 6]>
  <link rel="stylesheet" type="text/css" href="/css/bootstrap-ie6.css">
  <![endif]-->
  <!--[if lte IE 7]>
  <link rel="stylesheet" type="text/css" href="/css/ie.css">
  <![endif]--> 
  
  
<title>登录成功-<%=sysname%></title></head>
<body>
<br/>
   <h4 style="font-weight:normal;margin-left:10px;">登陆成功，系统正在跳转，请稍候...</h4>
   


</body>
</html>
