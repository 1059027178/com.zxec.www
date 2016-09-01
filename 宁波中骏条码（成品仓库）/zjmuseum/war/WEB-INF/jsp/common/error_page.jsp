<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><c:out value="${PAGE_TITLE}" /></title>
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
<div class="span2">
<i class="icon-user"></i><a style="color:#888;margin-left:5px;margin-right:20px" href="javascript:;">技术支持</a>
<i class="icon-envelope"></i><a style="color:#888;margin-left:5px;" href="javascript:;">联系我们</a>
</div>
</div>
</div>
<hr>
<table width="60%" border="0" align="center" cellpadding="3"
	cellspacing="1">
	<tr>
		<td height="213" valign="middle" align="center"
			style="line-height:25px;font-size:15px;text-align:left;">
			<a 
			href="/<c:out value="${PAGE_GO_URL}"/>"
			target="<c:out value="${PAGE_GO_TARGET}"/>"><c:out
			value="${PAGE_MSG}" /></a></td>
	</tr>
</table>

<%@ include file="../include/footer.jsp"%>
	 
</body>
</html>