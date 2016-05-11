<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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

</script>
  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <title><%=request.getSession().getAttribute("type")%></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
  </head>
  <body>
  <form name="jiuhui"  id="jiuhui" method="post" action="MainServlet?flag=shengchanC">
  		<input name="aufnr"  type="hidden" value="<%=request.getSession().getAttribute("aufnr") == null ? "" : request.getSession().getAttribute("aufnr")%>" />
    	<div style=" padding-top: 50px;">
    	
    	<ul>
    		<li class="li">
    			<table class="table_list">
    				<tr>
    					<td align="center">序号</td><td align="center">物料</td><td align="center">单位</td><td align="center">批次</td><td align="center">数量</td><td align="center">已拣配数量</td>
    				</tr>
    				<tr >
    					<td align="center">1</td>
    					<td align="center">C.9.291400</td>
    					<td align="center">PC</td>
    					<% String batchNO = request.getSession().getAttribute("batchNO") == null ? "" : request.getSession().getAttribute("batchNO").toString(); %>
    					<%if(batchNO.equals("")){ %>
    					<td align="center">0000000130</td>
    					<%} else{%>
    					<td align="center"><%=batchNO %></td>
    					<%} %>
    					<td align="center">20000</td>
    					<%HttpSession httpSession = request.getSession(); %>
    					<td align="center"><input value="<%=httpSession.getAttribute("num") == null ? "" : httpSession.getAttribute("num")%>" readonly=readonly style="width:35px;heigth:70%;background-color:#D8D8D8;" type="text" id="num1" name="num1" /></td>
    				</tr>
    				<tr>
    					<td align="center">2</td>
    					<td align="center">C.9.291470</td>
    					<td align="center">PC</td>
    					<td align="center"><%=batchNO %></td>
    					<td align="center">10000</td>
    					<td align="center">
    					<input value="<%=httpSession.getAttribute("num") == null ? "" : httpSession.getAttribute("num")%>" readonly=readonly style="width:35px;heigth:70%;background-color:#D8D8D8;" type="text" id="num1" name="num1" />
    					</td>
    				</tr>
    				<tr>
    					<td align="center">3</td>
    					<td align="center">C.9.291470</td>
    					<td align="center">PC</td>
    					<td align="center"><%=batchNO %></td>
    					<td align="center">5000</td>
    					<td align="center">
    					<input value="<%=httpSession.getAttribute("num") == null ? "" : httpSession.getAttribute("num")%>" readonly=readonly style="width:35px;heigth:70%;background-color:#D8D8D8;" type="text" id="num1" name="num1" />
    					</td>
    				</tr>
    			</table>
    		</li>
     		<li class="li">
    				<input  class="button"  type="button"  style="width:25%"  onclick="stoQuy()" value="过账">
    				<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=shengchanA';" value="返回">
    				<input  class="button" 	type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="首页">
    		</li>
    	</ul>
    	</div>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("num1").focus();
  </script>
</html>
