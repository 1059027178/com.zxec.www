<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<style type="text/css">
    body {
      padding-top: 40px;
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
		var str = $("#matnr").val();
		str += $("#matnr1").val();
		str += $("#num").val();
		if(str == "" || str == null){
			alert("请填写记账变更信息！");
		}
	  	obj.disabled=false;
	  	document.form.submit();
	  }
	  function reset(){
	  	$('.input').val("");
	  	$("#matnr").focus();
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
		  	
		  	if(obj == 1){
			  	//$("#meins").attr("value",str[5]);//单位
			  	//$("#lgort").attr("value",str[6]);//库存地点
			  	$("#meng").attr("value",str[4]);//每袋数量
			  	
		  		$("#matnr").attr("value",matnr);
		  		$("#charg").attr("value",str[7]);//初始批次号
		  		document.getElementById("matnr1").focus();
		  	}
		  	if(obj == 2){
		  		$("#matnr1").attr("value",matnr);
			  	$("#meng").attr("value",str[4]);//每袋数量
		  		$("#targetBatch").attr("value",str[7]);
		  		document.getElementById("boxs").focus();
		  	}
		  	
  		}
  	}
  	function acount(){
  		var meng=$("#meng").val();
  		var boxs=$("#boxs").val();
  		if(meng=="")meng=0;
  		if(boxs=="" || boxs==null)return;
  		if(meng=="" || meng==null)return;
  		//alert(parseFloat(meng)*parseFloat(boxs));
  		$("#num").attr("value",parseFloat(meng)*parseFloat(boxs));
  	}
  	function keyDown() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("按键码: " + keycode + " 字符: " + realkey);
      var lonstr = "";
       if(keycode=='13'){
       		lonstr = $("#matnr").val();
       		if(lonstr.length > 0 ){
				js(1);
       		}
       		longstr = $("#matnr1").val();
       		if(longstr.length > 0){
       			js(2);
       		}
       		
       }
   }
   document.onkeydown = keyDown;
   
  function keyUp(){
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
       //alert("按键码: " + keycode + " 字符: " + realkey);
       var lonstr = "";
		 if(keycode=='86'){
       		lonstr = $("#matnr").val();
       		if(lonstr.length > 0 ) js(1);
       		longstr = $("#matnr1").val();
	       	if(longstr.length > 0) js(2);
       }
	}
   document.onkeyup = keyUp;
	</script>
  </head>
  
  <body>
  <form name="form" action="/lubuList.do">
  <!-- <form name="form" action="/lubuEdit.do"> -->
  	<input type="hidden" name="charg" id = "charg" value="${charg }" />
  	<input type="hidden" name="werks" id = "werks" value="3200"/>
  <div>
     <ul>
     <li class="li"></li>
     	<li class="li">物料代码：从<input onchange="js(1)" name="matnr" class="text" style="width:90px;background-color:white;" type="text" id="matnr" value="${matnr }"></li>
		<li class="li" style="margin-left: 70px;">到<input onchange="js(2)" name="matnr1" class="text" style="width:90px;background-color:white;" type="text" id="matnr1" value=""></li>
 		<li class="li" >
 			袋数量/袋数：<input name="meng" readonly=readonly style="width:31px;background-color:#D8D8D8;margin-left: -5px;"  type="text"  id="meng" value=""/>
				/<input name="boxs" style="width:46px;" type="text" value="" id="boxs" onblur="acount();"/>
 		</li>
 		<li class="li" >
 			总<span style="margin-left:7px;"></span>数<span style="margin-left:7px;"></span>量：
			<input style="width:56px;background-color:#D8D8D8;margin-left:10px;" name="num" value="${num}" readonly=readonly type="text" id="num" />
			<input name="meins" value="KG"  style="width:26px;background-color:#D8D8D8;"  readonly=readonly type="text"  id="meins" />
 		</li>
 		<li class="li" style="line-height:20px;">目标批次：<input name="targetBatch" id= "targetBatch" style="width:90px;background-color:white;margin-left:14px;"/></li>
		<li class="li" style="line-height:20px;">库存地点：<input name="lgort" id= "lgort" style="width:90px;background-color:white;margin-left:14px;" value="3201"/></li>
		<li class="li" style="line-height:20px;">移动类型：<input name="yidongleixing" id= "yidongleixing" style="width:90px;background-color:white;margin-left:14px;" value="309"/></li>
		
		<!-- <li class="li">仓 库 号：<input name="lgnum" class="text" style="width:90px;background-color:white;" type="text" id="lgnum">	
 		</li>
		<li class="li">移动类型：<input name="bwlvs" class="text" style="width:90px;background-color:white;" type="text" id="bwlvs">	
 		</li> -->
 		<li class= "li" style="margin-top:10px;"></li>
  		<li class="li">
  		<span style="margin-left:-30px;"></span>
		<input type="button" class="button" style="width:40px;height:25px;" type="button" onclick="submit1(this)" value="确定">
		<input type="button" class="button" style="width:40px;height:25px;" type="button" onclick="forward()"value="返回">
		<input type="button" class="button" style="width:40px;height:25px;" type="button" onclick="reset();" value="重置"/>
		<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
		</li>
</ul>
</div>
</form>
  </body>
    <script type="text/javascript">
  document.getElementById("matnr").focus();
  </script>
</html>
