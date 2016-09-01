<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:useBean id="SapUtil" class="com.thinkway.SapUtil" scope="page" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    <script language="javascript" src="/js/jiuhui.js"></script>
    <title>仓位转移</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function forward(){
		  	window.location.href="/storageMView.do";
		  }
	</script>
	<style>
		table{height:100px;font-size:12px;background-color:#CCCCFF;}
	</style>
	<link href="/css/jiuhui_list.css" rel="stylesheet">
  </head>
  
  <body>
  <div class="div" style="margin-top:60px;">
  <form action="/groundingAdd.do">
    	<table  class="table_list">
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
    			<td colspan=2 align="center">
    				<input type="button" class="button" style="width:40px;" onclick="forward()" value="返回">
    				<input   type="button" class="button" style="width:40px;" onclick="window.location.href='/main.do';" value="首页">
    			</td>
    		</tr>
    	</table>
    	
      </form>
      </div>
  </body>

</html>
 