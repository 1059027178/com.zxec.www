<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    <title>下架</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<script language="javascript" src="/js/jiuhui.js"></script>
<script src="/js/jquery.js"></script>  
<script type="text/javascript">
	function result(){
		$("#str").val("");
		$("#matnr").val("");
		$("#charg").val("");
		$("#str").focus();
	}	
	function submit1(obj) {
		obj.disabled = false;
		document.jiuhui.submit();
	}

	//PO/行项目/供应商/物料编码/每袋数量/单位/库存地点/批次号/环保标识/检验/供应商生产日期/供应商批次号/库存类别
	function js() {
		var lonstr = $("#str").val();
		var str = lonstr.split("/");
		//alert(str.length);
		if (str.length > 0) {
			//var aufnr=str[0];//采购订单
			//var hang=str[1];//行项目
			var matnr = str[3];//物料编码
			//var meng = str[4];//每袋数量
			var meins = str[5];//单位
			var lgort = str[6];//库存地点
			var charg = str[7];//批次号
			//var sobkz = str[12];//库存类别

			$("#matnr").attr("value", matnr);
			//$("#meng").attr("value", meng);
			$("#charg").attr("value", charg);
			$("#meins").attr("value", meins);
			$("#lgort").attr("value", lgort);
			//$("#sobkz").attr("value", sobkz);
		}
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
  </head>
  <body>
    <form name="jiuhui"  id="jiuhui" action="/deliveryView.do">
    	<input type="hidden" id="lgort" name = "lgort" value=""/><!-- 库存地点 -->
    	<input type="hidden" id="meins" name = "meins" value=""/><!-- 单位 -->
    	<input type="hidden" id="werks" name = "werks" value="3201"/><!-- 工厂 -->
    	<div style="margin-top:60px;">
    		<ul>
	    		<!-- <li class="li">交货单号：<input type="text" class="text3" id="vbeln" name="vbeln"  value=""/></li> -->
	    		<li style="height:15px;list-style-type:none;">
	    			<input name="str" type="text" style="width:82%;height:20px;"  id="str" onchange="js()" onke/>
	    		</li>
	  			<li class="li">
	    			物料编号：<input type="text" class="text3" id="matnr" name="matnr" readonly=readonly  style="background-color:#D8D8D8;" value="${matnr }"/>
	    		</li>
	    		<li class="li">
	    			批<span style="margin-left:28px;"></span>次：<input type="text" readonly=readonly class="text3" style="background-color:#D8D8D8;" id="charg" name="charg" value="${charg }"/>
	    		</li>
	    		<li class="li">
	    			仓<span style="margin-left:14px;"></span>库号：<input name="lgortNO" type="text" class="text1" id="lgortNO"  value="311" />
	    		</li>
	  			<li class= "li" style="margin-top:10px;"></li>
		  		<li class="li">
		  		<span style="margin-left:-30px;"></span>
	    			<input class="button" type="button" onclick="submit1(this);" value="确定">
	    			<input class="button" type="button" onclick="result();" value="清空">
	    			<input class="button" type="button" onclick="window.location.href='/main.do?two=3';" value="返回">
	    			<input  type="button" onclick="window.location.href='/main.do';" value="首页">
	    		</li>
			</ul>
		</div>
    </form>
  </body>
   <script type="text/javascript">
  		document.getElementById("str").focus();
  </script>
</html>
