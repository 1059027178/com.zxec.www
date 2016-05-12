<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>


  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    
    <title>发货过账</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<script language="javascript" src="/js/jiuhui.js"></script>
<script type="text/javascript">
function deliList(){
	return true;
}
</script>

  </head>
  
  <body>
    <form name="jiuhui"  id="jiuhui" action="/deliveryView.do">
    	<div style="margin-top:60px;">
    		<ul>
    			<li class="li">交货单号：<input type="text" class="text3" id="vbeln" name="vbeln"  value=""/></li>
    		<li class="li"></li>
    		<li class="li">
    				<input class="button" type="submit" class=button onclick="return deliList();" value="确定">
    				<input class="button" type="button" onclick="window.location.href='/main.do?two=3';" value="返回">
    				<input  type="button" onclick="window.location.href='/main.do';" value="首页">
    		</li>
    	
		</ul>
	</div>
    </form>
  </body>
   <script type="text/javascript">
  document.getElementById("vbeln").focus();
  </script>
</html>
