<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<jsp:useBean id="LiangxinUtil" class="com.thinkway.LiangxinUtil" scope="page" />


<html>

  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    <script language="javascript" src="/js/jiuhui.js"></script>
    <title>物料凭证创建</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<link href="/css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  	function forward(){
  		window.location.href="/repertoryAdd.do";
  	}
  </script>
  <body>
  <div class="div" style="margin-top:60px;">
  <form action="/groundingAdd.do">
    	<table class="table_list">
    		<tr>
    			<td>
    				返回消息：${type}
    				<input name="aufnr" type="hidden" value="${receiptObj.aufnr}"/>
					<input name="matnr" type="hidden" value="${receiptObj.matnr}"/>
					<input name="meins" type="hidden" value="${receiptObj.meins}"/>
					<input name="wemng" type="hidden" value="${receiptObj.wemng}"/>
					<input name="sobkz" type="hidden" value="${receiptObj.sobkz}"/>
					<input name="lgort" type="hidden" value="${receiptObj.lgort}"/>
					<input name="charg" type="hidden" value="${receiptObj.charg}"/>
					<input name="meng" type="hidden" value="${receiptObj.meng}"/>
					<input name="boxs" type="hidden" value="${receiptObj.boxs}"/>
    			</td>
    			<td>${message}</td>
    		</tr>
    		<tr>

    			
    			<td><input class="button" type="button" onclick="forward()" value="返回">
    			<input   type="button" class="button" onclick="window.location.href='/main.do';" value="首页"></td>
    		</tr>
    	</table>
      </form>
  </div>
  </body>

</html>
 