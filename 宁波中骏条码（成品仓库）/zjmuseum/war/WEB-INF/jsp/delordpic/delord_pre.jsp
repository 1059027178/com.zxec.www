<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>交货单捡配</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<script src="/js/jquery.js"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>
	<script type="text/javascript" src="/javascript/calendar/WdatePicker.js"></script>    
	<link href="/css/jiuhui.css" rel="stylesheet">
	<script type="text/javascript">
	
 function submit1(obj){
  	var lgort=document.getElementById("lgort").value;
  	var werks=document.getElementById("werks").value;
  	if(lgort.length!=4){
  		alert("库存地点不存在");
		return false;
  	}
  	if(werks.length!=4){
  		alert("工厂不存在");
		return false;
  	}
  	obj.disabled=false;
	return true;
  }
  function forward(){
  	window.location.href="/main.do?two=2";
  }
	</script>
  </head>
  
  <body>
  <form name="form" action="/delordList.do">
  <div class="div" style="padding-top:50px;">
    
	<ul>
     	<li class="li">工&nbsp;&nbsp;&nbsp;&nbsp;厂:<input name="werks" class="text" style="background-color:white;" type="text"  id="werks" > </input>
		</li>
		<li class="li" >库存地点:<input name="lgort" style="background-color:white;" class="text" type="text"  id="lgort">
		</li>
     	<li class="li">交货日期:<input name="wadat" style="background-color:white;" class="text" type="text" value="${currentdate}" id="wadat" onFocus="WdatePicker({startDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd',alwaysUseStartDate:true})"/></li>
		<li class="li"></li>
		<li class="li">
		<input class="button" type="submit" style="width:40px;" onclick="return submit1(this)" value="确定">
		<input  class="button" type="button" style="width:40px;" onclick="forward()" value="返回">
		<input  class=button type="button" style="width:40px;"  onclick="window.location.href='/main.do';" value="首页">
		</li>
</ul>

</table>
</div>
</form>
  </body>
  <script type="text/javascript">
  document.getElementById("werks").focus();
  </script>
</html>
