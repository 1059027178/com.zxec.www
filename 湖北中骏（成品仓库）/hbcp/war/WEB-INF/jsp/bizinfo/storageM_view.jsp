<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
    body {
      padding-top: 90px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
  <head>
    <base href="<%=basePath%>">
    
    <title>仓位转移</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<script src="/js/jquery.js"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="/css/jiuhui.css" rel="stylesheet">
	<script type="text/javascript">
		function submit1(obj){
		  	obj.disabled=false;
		  	document.form.submit();
		  }
	   function forward(){
		  	window.location.href="/main.do?two=4";
		}
		function reset(){
	  	$('.input').val("");
	  }
	</script>
  </head>
  
  <body style="margin：0;padding：0;">
  <form name="form" action="/storageMList.do">
  <div style="margin:0px;padding:0;">
     <ul>
     <li class="li">仓库号：<input name="lgnum" class="text" style="background-color:white;" type="text" id="lgnum" value="320">	
 		</li>
 	<li class="li">仓位号：<input name="lgpla" class="text" style="background-color:white;" type="text" id="lgpla">	
 		</li>
 	<li class="li"></li>
<li class="li">
<input class="button" type="button" style="width:20%;margin-left:-30px;"  onclick="submit1(this)" value="确定">
<input class="button" type="button" style="width:20%"  onclick="forward()" value="返回">
<input class="button"  type="button" style="width:20%"  onclick="window.location.href='/main.do';" value="首页">
<input class="button" type="button" style="width:20%"  onclick="reset()" value="重置">
</li>
</ul>
</div>
</form>
  </body>
   <script type="text/javascript">
  document.getElementById("lgnum").focus();
  </script>
</html>
