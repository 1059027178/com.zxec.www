<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<script src="/js/jquery.js"></script>  
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>   
<script language="javascript" src="/js/jiuhui.js"></script>
<script type="text/javascript">
	function js() {
		var lonstr = $("#saomiao").val();
		var str = lonstr.split("/");
		//alert(str.length);
		if (str.length > 0) {
			var matnr = str[3];//物料编码
			var charg = str[7];//批次号
			$("#matnr").attr("value", matnr);
			$("#charg").attr("value", charg);
		}
		if (($("#charg").val()).length > 0) {
			jQuery("#pici").attr("checked", true);
		}
	}
	function stoQuy() {
		var werks = document.getElementById("werks").value;
		if (werks == 0) {
			alert("工厂为空，无法查询");
			return;
		}
		var lgort = document.getElementById("lgort").value;
		if (lgort == 0) {
			alert("库存地点为空，无法查询");
			return;
		}
		if (jQuery("#pici").attr("checked") == "checked") {
			document.getElementById("pici").value = 'pici';
		}
		document.jiuhui.submit();
	}
	function reset(){
		$("#matnr").val("");
		$("#charg").val("");
		$("#saomiao").focus();
	}
	function keyDown() {
		var keycode = event.keyCode;
		var realkey = String.fromCharCode(event.keyCode);
		// alert("按键码: " + keycode + " 字符: " + realkey);
		if (keycode == '13') {
			js();
		}
	}
	document.onkeydown = keyDown;
	
	function keyUp(){
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
       //alert("按键码: " + keycode + " 字符: " + realkey);
		 if(keycode=='86'){
       		js();
       }
	}
   document.onkeyup = keyUp;
</script>

<head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    
    <title>库存查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form name="jiuhui"  id="jiuhui" method="post" action="/stoquyList.do">
    	<div style=" padding-top: 50px;">
    	<ul>
    		<li class="li">
    			工 &nbsp;&nbsp; 厂: <input style="width:50%;heigth:70%" type="text" id="werks" name="werks"  value="3200"/>
    		</li>
    		<li class="li">
    			库存地点：<input style="width:50%;heigth:70%" type="text" id="lgort" name="lgort"  value="3201"/>
    		</li>
    		<li class="li">
    			<input style="width:81.5%;heigth:70%" type="text" id="saomiao" name="saomiao"  value="" onchange="js()"/>
    		</li>
    		<li class="li">
    			物料编码：<input style="width:50%;heigth:70%" type="text" id="matnr" name="matnr"  value=""/>
    		</li>
    		<li class="li">
    			批  &nbsp;&nbsp; 次：<input style="width:50%;heigth:70%" type="text" id="charg" name="charg"  value="" />
    		</li>
    		<li class="li">
    			<input type="checkbox" value="" id="pici" name="pici"/>按批查询
     		</li>
     		<li class="li" style="margin:20px 0px 0px -15px；">
    				<input  class="button"  type="button"  valign="center" style="width:40px;height:25px;"  onclick="stoQuy()" value="查询">
    				<input  class="button" type="button" onclick="reset();" style="width:40px;height:25px;" id="reset" value="重置"/>
    				<input  class="button"  type="button"  valign="center" style="width:40px;height:25px;"  onclick="window.location.href='/main.do?two=5';" value="返回">
    				<input  class="button" type="button" valign="center" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
    		</li>
    	</ul>
    	</div>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("saomiao").focus();
  </script>
</html>
