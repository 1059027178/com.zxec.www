<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><c:out value="${PAGE_TITLE}" /></title> 
<meta http-equiv="refresh"
	content="1;url=<c:out value="${PAGE_GO_URL}" />">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<!-- Le styles -->
<style type="text/css">
    body {
      padding-top: 20px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 0;
    }
</style>
  
  
<link href="/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="row-fluid">
<div class="container">
<div class="span8">
<h1><%=sysname%><strong style="font-size:12px;font-family:Arial;">TM</strong></h1>
</div>
<div class="span3">
<i class="icon-user"></i><a style="color:#888;margin-left:5px;margin-right:20px" href="javascript:;">技术支持</a>
<i class="icon-envelope"></i><a style="color:#888;margin-left:5px;" href="javascript:;">联系我们</a>
</div>
</div>
</div>
<hr>
<table width="60%" border="0" align="center" cellpadding="3"
	cellspacing="1">
	<tr>
	   <td width=30% height=255 align=center><img src="/img/error.png" width=155px height=155px border=0 /></td>
		<td  width=60% height="255" valign="middle" align="center"
			style="line-height:25px;">
		<div style="color:#777;font-size:14px;text-align:left;line-height:35px;">	
			<span style="font-weight:bold;color:#ff0000;">出错了！</span><a style="color:#777;" href="<c:out value="${PAGE_GO_URL}"/>">
			<span style="color:#ff0000;"><c:out value="${PAGE_MSG}" /></span>
		<br>
		系统将在3秒钟后自动返回<br>
		如果系统没有自动返回，请单击此处自行返回</a> <br>
		<a style="color:#666;text-decoration:underline;font-weight:normal;" href="<c:out value="${PAGE_FROM_URL}"/>"><--如果你想继续<c:out
			value="${PAGE_TITLE}" />请单击此处</a>
		</div>	</td>
	</tr>
</table>

<%@ include file="../include/footer.jsp"%>
	 
</body>
</html>