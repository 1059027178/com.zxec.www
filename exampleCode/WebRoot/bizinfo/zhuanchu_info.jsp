<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>库存转储</title>
    
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
  	function js(){
  		var lonstr=$("#str").val();
  		var str=lonstr.split("/");
  		//alert(str.length);
  		if(str.length>0){
	  		var matnr=str[3];//物料编码
	  		var storageLocation=str[6];//库存地点
	  		var batchNo=str[7];//批次号
	  		//var environmentalFlag=str[8];//环保标识
	  		//var checkOut=str[9];//检验
	  		//var produceDate=str[10];//供应商生产日期
	  		//var produceBatchNo=str[11];//供应商批次号
	  		$("#matnr").attr("value",matnr);
	  		$("#lgort").attr("value",storageLocation);
	  		$("#batchNo").attr("value",batchNo);
	  		
	  		if(matnr == "C.9.291400"){
	  			$("#maktx").attr("value","C2沙剂-规格(25kg/桶)");
	  		}
	  		else if(matnr == "C.6.040501"){
	  			$("#maktx").attr("value","ABS 规格(730 颜色:本色 玻纤:无 其他:/)");
	  		}
	  		else if(matnr == "C.6.040601"){
	  			$("#maktx").attr("value","ABS-GP-22 颜色:本色 玻纤:/ 其他:/");
	  		}
	  		else if(matnr == "C.6.040701"){
	  			$("#maktx").attr("value","ABS规格(710 颜色:白色 玻纤:/ 其他:锦湖日丽710)");
	  		}
	  		else if(matnr == "C.6.040802"){
	  			$("#maktx").attr("value","ABS规格(4330C 颜色:本色 玻纤:/ 其他:/)");
	  		}
  		}
  	}
  	function keyDown() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("按键码: " + keycode + " 字符: " + realkey);
       if(keycode=='13'){
       		js();
       }
   }
   document.onkeydown = keyDown;

  function forward(){
  	window.location.href="MainServlet?flag=3.3";
  }
  function submit1(obj){
  	var num 	= $("#num").val();
  	var lgort1 = $("#lgort1").val();
	if(num == ""){
	  	alert("请填写数量！");return;
	}
	if(lgort1 == ""){
	  	alert("请填写库存地点！");return;
	}
	obj.disabled=false;
	document.form.submit();
	}
  function reset(){
  	$('.input').val("");
  }
  </script>
  <body>
  <form name=form action="MainServlet?flag=zhuanchuMsg" method="post" style="margin-top:50px;">
  	<div>
  		<ul>
  			<li class="li">
  				物料编码：<input name="matnr" class="text"  readonly=readonly type="text" id="matnr" value="<%=request.getSession().getAttribute("matnr") == null ? "" : request.getSession().getAttribute("matnr")%>">
  			</li>
  			<li class="li">
  				物料描述：<input name="maktx" class="text"  readonly=readonly type="text" id="maktx" value="<%=request.getSession().getAttribute("maktx") == null ? "" : request.getSession().getAttribute("maktx")%>">
  			</li>
  			<li class="li">
  				批次<span style="width:27px;"></span>：<input style="margin-left: 2px;" name="batchNo" class="text"  readonly=readonly type="text" id="batchNo" value="<%=request.getSession().getAttribute("batchNo") == null ? "" : request.getSession().getAttribute("batchNo")%>">
  			</li>
  			<li class="li">
  				转储数量：<input class="text" type="text" name ="num" id="num" style="background: white;"/>
  			</li>
  			<li class="li">
  				库存地点：<input name="lgort" type="text" class="text" id="lgort" style="width: 41px; " value="3107">
  				到<input name="lgort1" type="text" class="text" id="lgort1" style="margin-left: 2px;width: 41px;;background:white;">
  			</li>
  			<li class="li">
  				移动类型：<input name="moveClass" type="text" class="text"  id="moveClass" style="background: white;" value="311">
  			</li>
  			<li class="li" style="margin: 20px 0px 0px -15px;">
  				<input type ="button" valign="center" class="button" onclick="submit1(this);" style="width:40px;height:25px;" value="确定"/>
  				<input class="button"  type="button"  onclick="forward();" style="width:40px;height:25px;" value="返回"/>
  				<input class="button"  type="button"  onclick="reset();"   style="width:40px;height:25px;" value="重置"/>
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
