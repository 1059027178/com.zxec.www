<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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

<title>生产成本中心领料</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<script src="/js/jquery.js"></script>
<script
	src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js"
	type="text/javascript"></script>
<script
	src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js"
	type="text/javascript"></script>
<link href="/css/jiuhui.css" rel="stylesheet">
<script type="text/javascript">
	/* function keyDown() {
	   var keycode = event.keyCode;
	   var realkey = String.fromCharCode(event.keyCode);
	  // alert("按键码: " + keycode + " 字符: " + realkey);
	   if(keycode=='13'){
	   		getNlpla();
	   }
	}
	document.onkeydown = keyDown; */
	function submit1(obj) {
		try {
			var dt = $("#produceDate").val().split("/");
			//produceDate = dt[0] + "" + ("0" + dt[1]).substr(-2) + "" + ("0" + dt[2]).substr(-2);
			produceDate = dt[0] + getStr(dt[1]) + getStr(dt[2]);
			$("#budat").val(produceDate);
		} catch (e) {
			$("#produceDate").val(date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate());
			alert("错误的日期格式!");
			return;
		}
		obj.disabled = false;
		document.form.submit();
	}
	function getStr(str){
		str += "";
		if(str.length == 1){
			str = "0" + str
		}
		return str;
	}
</script>
</head>

<body>
	<form name="form" action="/getCostA.do">
		<div>
			 <input
				type="hidden" name="budat" id="budat"/>
			<ul>
				<li class="li">工&emsp;&emsp;厂:<input name="werks" class="text"
					style="background-color:white;" type="text" id="werks" value="3100" />
				</li>
				<li class="li">库存地点:<input name="lgort"
					style="background-color:white;" class="text" type="text" id="lgort"
					value="3101" /></li>
				<li class="li">制单日期:<input style="background-color:white;"
					class="text" type="text" id="produceDate" />
				</li>
				<li class="li"><input class="button" type="button"
					onclick="submit1(this)" value="确定"> <input class="button"
					type="button" onclick="window.location.href='/main.do?two=3';" value="返回"></li>
		</div>
	</form>
</body>
<script type="text/javascript">
	var date = new Date();
	$(function() {
		$("#produceDate").val(date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate());
	});
</script>
</html>
