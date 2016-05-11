<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>仓位冻结/解冻</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<meta http-equiv="description" content="This is my page">
	<script src="./js/jquery.js"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="./css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  	
  function forward(){
  	window.location.href="MainServlet?flag=3";
  }
  function submit1(obj){
  	obj.disabled=false;
  	document.form.submit();
  }
  </script>
  <body>
  <div class="div" style="margin-top:60px;">
  <form name="form" action="MainServlet?flag=3.1" method="post">
    <ul>
     	<li class="li" style="margin:20px 0px 0px 30px;line-height:30px;">
			返回信息：<br>
			<%=request.getSession().getAttribute("message") == null ? "" : request.getSession().getAttribute("message").toString().trim() %>
		<li class="li" style="margin:20px 0px 0px 0px;">
			<input class="button" type="button" onclick="submit1(this);" value="继续"/>
			<input class="button" type="button" onclick="forward();" value="返回"/>
			<input type="button" class="button" onclick="window.location.href='MainServlet?flag=return';" value="首页">
		</li>
	</ul>
  </form>
</div>
  </body>
</html>
