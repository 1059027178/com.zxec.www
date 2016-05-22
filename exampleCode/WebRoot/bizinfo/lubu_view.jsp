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
	<script src="./js/jquery.js"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="./css/jiuhui.css" rel="stylesheet">
	<script type="text/javascript">
		function forward(){
		  	window.location.href="MainServlet?flag=3";
		  }
	function submit1(obj){
		var matnr  = document.getElementById("matnr").value;
		var matnr1  = document.getElementById("matnr1").value;
		var num  = document.getElementById("num").value;
		if(matnr == ""){
			alert("请填写待变更的物料代码！");
			return;
		}
		if(matnr1 == ""){
			alert("请填写目标物料代码！");
			return;
		}
		if(num == ""){
			alert("请填写变更数量！");
			return;
		}
	  	obj.disabled=false;
	  	document.form.submit();
	  }
	  function reset(){
	  	$('.input').val("");
	  }
 function js(obj){
 	var lonstr = "";
 	if(obj == 1){
 		lonstr=$("#matnr").val();
 	}
 	if(obj == 2){
 		lonstr=$("#matnr1").val();
 	}
  	var str=lonstr.split("/");
  	
  	if(str.length>0){
  	
	  	var matnr=str[3];//物料编码
	  	var batchNo=str[7];//批次号
	  	
	  	if(obj == 1){
	  	
	  		$("#matnr").attr("value",matnr);
	  	}
	  	if(obj == 2){
	  	
	  		$("#matnr1").attr("value",matnr);
	  	}
	  	$("#batchNo").attr("value",batchNo);
  	}
  }
	</script>
  </head>
  
  <body>
  <form name="form" action="MainServlet?flag=jzbgMsg" method="post">
  	<input type="hidden" name="batchNo" id="batchNo" />
  	<div>
     <ul>
     <li class="li"></li>
		<li class="li">物料代码：从<input onchange="js(1)" name="matnr" class="text" style="width:90px;background-color:white;" type="text" id="matnr" value="<%=request.getParameter("matnr")   == null ? "": request.getParameter("matnr")%>">	
 		</li>
		<li class="li" style="margin-left: 70px;">到<input onchange="js(2)" name="matnr1" class="text" style="width:90px;background-color:white;" type="text" id="matnr1" value="">	
 		</li>
 		<li class="li" >数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：<input name="num" class="text" style="width:90px;background-color:white;margin-left:14px;" type="text" id="num" value="<%=request.getParameter("num")   == null ? "": request.getParameter("num")%>"></li>
		<li class="li" style="line-height:20px;">库存地点：<input name="kucundidian" id= "kucundidian" style="width:90px;background-color:white;margin-left:14px;" value="3107"/></li>
		<li class="li" style="line-height:20px;">移动类型：<input name="yidongleixing" id= "yidongleixing" style="width:90px;background-color:white;margin-left:14px;" value="309"/></li>
		<li class="li" style="margin: 20px 0px 0px 0px;">
		<input type="button" class="button" style="width:40px;height:25px;" type="button" onclick="submit1(this)" value="确定">
		<input type="button" class="button" style="width:40px;height:25px;" type="button" onclick="forward()"value="返回">
		<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
		</li>
</ul>
</div>
</form>
  </body>
  <script type="text/javascript">
  	document.getElementById("matnr").focus();
  </script>
</html>
