<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Date date = new Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
String strDate = dateFormat.format(date);
%>
<html>
<script src="./js/jquery.js"></script>  
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>   
<script language="javascript" src="./js/jiuhui.js"></script>
<script type="text/javascript">
	function stoQuy(){
		document.jiuhui.submit();
	}
	function query(obj){
		if(obj == 1){
			$("#batchNO").attr("value","0000000130");
		}else if(obj == 2){
			$("#batchNO").attr("value","0000000131");
		}
		document.jiuhui.submit();
	}
</script>
  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <title><%=request.getSession().getAttribute("type")%></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
  </head>
  <body>
  <form name="jiuhui"  id="jiuhui" method="post" action="MainServlet?flag=shengchanB">
  	<input name="batchNO"  type="hidden" id="batchNO"/>
    <div style=" padding-top: 50px;">
	    <ul>
	   	 	<li class="li" style="margin:20px 0px 0px 0px;">
	   	 		<table class="table_list">
	   	 			<tr>
	   	 				<td align="center">序号</td>
	   	 				<td align="center"><%=request.getSession().getAttribute("type") == null ? "" : request.getSession().getAttribute("type")%></td>
	   	 			</tr>
	   	 			<tr onclick="query(1);">
	   	 				<td align="center">1</td>
	   	 				<td align="center">0000000130</td>
	   	 			</tr>
	   	 			<tr onclick="query(2);">																
	   	 				<td align="center">2</td>
	   	 				<td align="center">0000000131</td>
	   	 			</tr>
	   	 		</table>
			</li>
			<li class="li">
	    		<input  class="button"  type="button"  style="width:25%"  onclick="stoQuy()" value="确定" />
	    		<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=2.1';" value="返回" />
	    		<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="首页" />
	    	</li>
	    </ul>
    </div>
    </form>
  </body>
</html>
