<%@ page language="java" contentType="text/html; charset=GBK" %> 
<jsp:useBean id="SapUtil" class="com.thinkway.SapUtil" scope="page" />


<html>
<script type="text/javascript">
function jixu(){
	location='/deliveryAdd.do'
}
</script>
  <head>
  
    <script language="javascript" src="/js/jiuhui.js"></script>
    <title>下架</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
	<script type="text/javascript">
  	function goon(){
  		document.form.action="/deliveryAdd.do";
  		document.form.submit();
  	}
  	</script>
  </head>
  
  <body>
  <div class="div" style="margin-top:60px;">
    	<table class="table_list">
    		<tr>
    			<td style="padding-left:20px;">
    				返回消息：${message}
    			</td>
    		</tr>
    		<tr  style="width:100%;heigth=20%">
    			<td align="center">
    				<input type="button" style="width:40px;" onclick="window.location.href='/main.do?two=3';" value="返回">
    				<input type="button" style="width:40px;" onclick="jixu()" value="继续">
    				<input  type="button" style="width:40px;"  onclick="window.location.href='/main.do';" value="首页">
    			</td>
    		</tr>
    	</table>
    </div>
  </body>
</html>
 