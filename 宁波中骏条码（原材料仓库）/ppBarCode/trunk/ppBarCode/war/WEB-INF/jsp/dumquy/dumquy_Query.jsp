<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<script language="javascript" src="/js/jiuhui.js"></script>
<script type="text/javascript">
function dumQuy(){
	var tanum=document.getElementById("tanum").value;
  	if(tanum.length==0){
  		alert("转储单号为空，无法查询");
  		return;
  	}	 
	document.jiuhui.submit();
}
</script>
  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    
    <title>转储单查询</title>
    
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
    <form name="jiuhui"  id="jiuhui" action="/dumquyView.do">
    	<div style=" padding-top: 50px;">
    	<ul>
    	<li class="li"></li>
    		<li class="li">
    			仓 库 号：<input type="text" id="lgnum"  style="width:50%;heigth:70%" name="lgnum"  value="311"/>
    		</li>
    		<li class="li">
    			转储单号：<input type="text" id="tanum"  style="width:50%;heigth:70%" name="tanum"  value=""/>
    		</li>
    		<li class="li"></li>
    		<li class="li" style="margin:10px 0px 0px -15px；">
    			<input type="button" class=button valign="center" onclick="dumQuy()" value="查询">
    			<input type="button" class=button valign="center" onclick="window.location.href='/main.do?two=5';" value="返回">
    			<input  class=button type="button" valign="center" onclick="window.location.href='/main.do';" value="首页">
    		</li>
    	</ul>
    	</div>
    </form>
  </body>
  <script type="text/javascript">
  document.getElementById("tanum").focus();
  </script>
</html>
