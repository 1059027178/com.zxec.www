<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<script language="javascript" src="/js/jiuhui.js"></script>
<script type="text/javascript">
function crtmadoc(){
	document.jiuhui.submit();
}
</script>
  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    
    <title>物料凭证创建</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form name="jiuhui"  id="jiuhui" action="/matdocuOpera.do">
    	<table >
    		<tr class="tr_css">
    			<td>订单号：</td>
    			<td><input type="text" id="aufnr" name="aufnr"  value=""/></td>
    		</tr>
    		<tr class="tr_css">
    			<td>入库数量：</td>
    			<td><input type="text" id="iquan" name="iquan"  value=""/></td>
    		</tr>
    		<tr class="tr_css">
    			<td>基本计量单位：</td>
    			<td><input type="text" id="gmein" name="gmein"  value=""/></td>
    		</tr>
    	</table>
    </form>
    <table>
    		<tr>
    			<td>
    				<button class=button onclick="crtmadoc();">确认</button>
    			</td>
    			<td>
    				<button class=button onclick="goback();">返回</button>
    			</td>
    		</tr>
    </table>
  </body>
</html>
