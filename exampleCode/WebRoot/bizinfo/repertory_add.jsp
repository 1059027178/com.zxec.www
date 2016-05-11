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
    
    <title>仓位冻结/解冻</title>
    
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
	<script type="text/javascript">
 function submit1(obj){
  	var lgnum = document.getElementById("lgnum").value;
  	var nlpla = document.getElementById("nlpla").value;
  	if(lgnum == ""){
  		alert("请输入仓库号！");return;
  	}
  	if(nlpla == ""){
  		alert("请输入仓位号！");return;
  	}
  	//alert(document.getElementById("radioValue").value);return;
  	obj.disabled=false;
  	document.form.submit();
  }
  function forward(){
  	window.location.href="MainServlet?flag=3";
  }
  function getValue(obj){
  	$("#radioValue").attr("value",obj);
  }
	</script>
  </head>
  
  <body>
  <form name="form" action="MainServlet?flag=cangwei" method="post">
  	<input name="radioValue" type="hidden" id="radioValue" value="1"/>
  <div>
    
	<ul>
		<li class="li" >仓库号：<input name="lgnum" style="background-color:white;"  class="text" type="text"  id="lgnum" value="3107">
		</li>
     	<li class="li">仓位号：<input name="nlpla" class="text" style="background-color:white;" type="text"  id="nlpla"  value="A1-3"/>
		</li>
     	<li class="li"><input name="radio" style="width:20px;" checked=checked type="radio" id="radio1" value="1" onclick="getValue(this.value)"/>出入库冻结</li>
     	<li class="li"><input name="radio" style="width:20px;" type="radio" id="radio2" value="2" onclick="getValue(this.value)"/>出入库解冻</li>
     	<li class="li"><input name="radio" style="width:20px;" type="radio" id="radio3" value="3" onclick="getValue(this.value)"/>查看所有冻结仓位</li>
		<li class="li" >
		<input class="button" type="button" onclick="submit1(this)" value="确定">
		<input class="button" type="button" onclick="forward()" value="返回">
		<input class="button" type="button" onclick="window.location.href='MainServlet?flag=return';" value="首页">
		</li>
	</ul>
</div>
</form>
  </body>
   <script type="text/javascript">
  document.getElementById("lgnum").focus();
  </script>
</html>
