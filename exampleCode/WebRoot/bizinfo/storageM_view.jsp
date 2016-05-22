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
	  		//$("#lgort").attr("value",storageLocation);
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
  	window.location.href="MainServlet?flag=3";
  }
  function submit1(obj){
  	var str = document.getElementById("str").value;
  	if(str != ""){
  		obj.disabled=false;
  		document.form.submit();
  	}else{
  		alert("请扫描物料卡！");
  	}
  }
  function reset(){
  	$('.input').val("");
  }
  </script>
  <body>
  <form name=form action="MainServlet?flag=zhuanchu" method="post" style="margin-top:50px;">
  	<div>
  		<ul>
  			<li style="height:15px;list-style-type:none;">
  				<input name="str" type="text" style="width:80%;height:20px;"  id="str" onchange="js()">
  			</li>
  			<li class="li">
  				物料编码：<input name="matnr" class="text"  readonly=readonly type="text" id="matnr" >
  			</li>
  			<li class="li">
  				物料描述：<input name="maktx" class="text"  readonly=readonly type="text" id="maktx" >
  			</li>
  			<li class="li">
  				批次<span style="width:27px;"></span>：<input name="batchNo" class="text" readonly=readonly style="background-color:#D8D8D8;margin-left: 2px;"  type="text"  id="batchNo">
  			</li>
  			<li class="li">
  				仓库号<span style="width:15px;"></span>：<input name="lgort" type="text" class="text3" id="lgort"  value="311">
  			</li>
  			<li class="li" style="margin:10px 0px 0px -15px；">
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
