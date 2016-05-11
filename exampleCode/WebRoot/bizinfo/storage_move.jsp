<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>仓位转移</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
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
  var no = document.getElementById("literaNO").value;
  if( no == ""){
  	alert("请填写仓位号");return;
  }
  	obj.disabled=false;
  	document.form.submit();
  }
  function reset(){
  	$("#literaNO").attr("value","");
  }
  </script>
  <body>
  <form name="form" action="MainServlet?flag=storageInfo" method="post" style="margin-top:50px;">
  	<div>
  		<ul>
  			<li style="height:15px;list-style-type:none;">
  				仓&nbsp;位&nbsp;号：<input name="literaNO" type="text" style="width:50%;height:20px;"  id="literaNO" >
  			</li>
  			<li class="li" style="margin-top: 20px;">
  				<input type ="button" valign="center" class="button" onclick="submit1(this);" style="width:40px;height:25px;" value="确定"/>
  				<input class="button"  type="button"  onclick="forward();" style="width:30px;height:25px;" value="返回"/>
  				<input class="button"  type="button"  onclick="reset();"   style="width:30px;height:25px;" value="清除"/>
  				<input type ="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
  			</li>
  			
  		</ul>
  	</div>
     
</form>
  </body>
    <script type="text/javascript">
  document.getElementById("str").focus();
  </script>
</html>
