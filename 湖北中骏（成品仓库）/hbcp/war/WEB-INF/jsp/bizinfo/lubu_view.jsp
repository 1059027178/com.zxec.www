<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style type="text/css">
    body {
      padding-top: 50px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
  <head>
    <base href="<%=basePath%>">
    
    <title>记账变更</title>
    
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
		function forward(){
		  	window.location.href="/main.do?two=4";
		  }
	function submit1(obj){
	  	obj.disabled=false;
	  	document.form.submit();
	  }
	  function reset(){
	  	$('.input').val("");
	  }
	</script>
  </head>
  
  <body>
  <form name="form" action="/lubuList.do">
  <div>
     <ul>
     <li class="li"></li>
		<li class="li">仓<span style="width:7px;"></span>库<span style="width:7px;"></span>号：<input name="lgnum" class="text" style="width:90px;background-color:white;" type="text" id="lgnum" value="330">	
 		</li>
		<li class="li">移动类型：<input name="bwlvs" class="text" style="width:90px;background-color:white;" type="text" id="bwlvs">	
 		</li>
 		<li class="li"></li>
		<li class="li">
		<input type="button" class="button" style="width:40px;height:25px;margin-left: -30px;" type="button" onclick="submit1(this)" value="确定">
		<input type="button" class="button" style="width:40px;height:25px;" type="button" onclick="forward()"value="返回">
		<input type="button" class="button" style="width:40px;height:25px;" type="button" onclick="reset();" value="重置"/>
		<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
		</li>
</ul>
</div>
</form>
  </body>
    <script type="text/javascript">
  document.getElementById("lgnum").focus();
  </script>
</html>
