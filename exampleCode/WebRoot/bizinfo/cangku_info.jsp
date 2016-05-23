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
  	window.location.href="MainServlet?flag=3.1";
  }
  function submit1(obj){
  	obj.disabled=false;
  	document.form.submit();
  }
  </script>
  <body>
  <div class="div" style="margin-top:90px;margin-left: -20px;">
  <form name="form" action="MainServlet?flag=cangkucaozuo" method="post">
	<input name="radioValue" type="hidden" value="<%=request.getSession().getAttribute("radioValue") == null ? "" : request.getParameter("radioValue").trim()%>"/>
    <ul>
     	<li class="li" >
		<table class="table_list">
			<tr>
				<td align="center">序号</td><td align="center">存储类型</td><td align="center">仓位号</td>
			</tr>
			<tr>
				<td align="center">1</td><td align="center">Z01</td><td align="center"><%=request.getSession().getAttribute("nlpla") == null ? "" : request.getParameter("nlpla").trim()%></td>
			</tr>
		</table>
		<li class="li"	style="margin:20px 0px 0px -10px;">
			<input class="button" type="button" onclick="submit1(this);" value="确定"/>
			<input class="button" type="button" onclick="forward();" value="返回"/>
			<input type="button" class="button" onclick="window.location.href='MainServlet?flag=return';" value="首页">
		</li>
	</ul>
  </form>
</div>
  </body>
</html>
