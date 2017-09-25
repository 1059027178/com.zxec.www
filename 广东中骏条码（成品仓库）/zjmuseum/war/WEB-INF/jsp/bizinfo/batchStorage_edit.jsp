<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

List resultList = (List) request.getAttribute("resultList");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>批量过账</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<script src="/js/jquery.js"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="/css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  function submit1(obj){
  	obj.disabled=false;
  	document.form.submit();
  }
  </script>
  <style type="text/css">
	table.gridtable {
		font-family: verdana,arial,sans-serif;
		font-size:11px;
		color:#333333;
		border-width: 1px;
		border-color: #666666;
		border-collapse: collapse;
	}
	table.gridtable th {
		border-width: 1px;
		padding: 2px;
		border-style: solid;
		border-color: #666666;
		background-color: #dedede;
	}
	table.gridtable td {
		border-width: 1px;
		padding: 2px 4px;
		border-style: solid;
		border-color: #666666;
		/*background-color: #ffffff;*/
	}
</style>
  <body>
  <form name=form action="/batchStorageList.do">
  	<input type="hidden" name="werks" id="werks" value="${werks }">
 	<input type="hidden" name="bwlvs" id="bwlvs" value="${bwlvs }">
  	<div >
  		<%if(resultList == null || resultList.size() == 0) {%>
  				<p align="left">无过账信息！</p>
  		<%}else{%>
  		<table class="gridtable">
  			<tr><td rowspan="2">序号</td><td colspan="2">物料代码</td></tr>
  			<tr><td>流水码</td><td>过账数量</td></tr>
  			<!-- <tr><td rowspan="2" align="center">1</td><td colspan="2">50.3.100908-P</td></tr>
  			<tr><td>1000000040</td><td >10000</td></tr>
  			<tr><td rowspan="2" align="center">2</td><td colspan="2">50.3.100908-P</td></tr>
  			<tr><td>1000000040</td><td >10000</td></tr>
  			<tr><td rowspan="2" align="center">3</td><td colspan="2">50.3.100908-P</td></tr>
  			<tr><td>1000000040</td><td >10000</td></tr>
  			<tr><td rowspan="2" align="center">4</td><td colspan="2">50.3.100908-P</td></tr>
  			<tr><td>1000000040</td><td >10000</td></tr>
  			<tr><td rowspan="2" align="center">5</td><td colspan="2">50.3.100908-P</td></tr>
  			<tr><td>1000000040</td><td >10000</td></tr> -->
  			<% for( int i = 0 ; i < resultList.size() ; i ++ ){
  			   	Map<String,String> map = (Map) resultList.get(i);
  			   	String ZTMID = map.get("ZTMID");//流水码
				String MATNR = map.get("MATNR");//物料代码
				String ZSHSL = map.get("ZSHSL");//收货数量
				String ZWLPZ = map.get("ZWLPZ");//物料凭证号
			%>
  			<tr><td rowspan="2" align="center"><%=i+1%></td><td colspan="2"><%=MATNR%></td></tr>
  			<tr><td><%=ZTMID%></td><td><%=ZSHSL%></td></tr>
  			<%	}%>
  		</table>
  		<%} %>
  		<input class="button" type="button" onclick="submit1(this);" style="width:40px;height:25px;margin-top:5px;" value="返回"/>
		<input class="button" type="button" onclick="window.location.href='/main.do';" style="width:40px;height:25px;margin-left:10px;" value="首页"></li>
  	</div>
</form>
  </body>
</html>
