<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<script language="javascript" src="./js/jiuhui.js"></script>
<script type="text/javascript">
function lgpQuy(){
	var lgpla=document.getElementById("lgpla").value;
  	if(lgpla.length==0){
  		alert("仓位号为空，无法查询");
  		return;
  	}	 
  	var lgnum=document.getElementById("lgnum").value;
  	if(lgnum.length==0){
  		alert("仓库为空，无法查询");
  		return;
  	}	
	document.jiuhui.submit();
}
function reset(){
	document.getElementById("lgpla").value=""; 
	/* document.getElementById("lgnum").value=""; */ 
}
</script>
  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <title>仓位查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
  </head>
  <body>
    <form name="jiuhui"  id="jiuhui" action="MainServlet?flag=selectCangwei" method="post">
    	<div style=" padding: 90px 0px 20px 0px;">
    	<ul>
    		<li class="li" style="margin-bottom: 20px;">
    			仓位号：<input style="width:60%;height:25px;" type="text" id="lgpla" name="lgpla"  value=""/>
    		</li>
    		<li class="li">
    			仓库号：<input style="width:60%;height:25px;" type="text" id="lgnum" name="lgnum"  value="311"/>
    		</li>
    			<li class="li" style="margin:20px 0px 0px -25px;">
    				<input  class="button"  type="button" style="width:22%"  onclick="lgpQuy()" value="查询">
    				<input  class="button"  type="button" style="width:22%"  onclick="reset();" value="清除">
    				<input  class="button"  type="button" style="width:22%"  onclick="window.location.href='MainServlet?flag=4';" value="返回">
    				<input  class=button type="button" style="width:22%" onclick="window.location.href='MainServlet?flag=return';" value="首页">
    		</li>
    	</ul>
    	</div>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("lgpla").focus();
  </script>
</html>
