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
	var num=$("#num").val();
	if(num == ""||num == "0"){
		alert("请填写数量");return;
	}
	document.jiuhui.submit();
}
</script>
  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <title>仓位转移</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
  </head>
  <body>
  <form name="jiuhui"  id="jiuhui" method="post" action="MainServlet?flag=storageTo">
    	<div style=" padding-top: 50px;">
    	<ul>
    		<li class="li">
    			仓 位：<input name="literaNO" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="literaNO" value = "<%=request.getSession().getAttribute("literaNO") == null ? "": request.getSession().getAttribute("literaNO")%>" />
    		</li>
    		<li class="li">
    			<table class="table_list" >
    				<tr>
    					<td >序号</td>
    					<td>1</td>
    				</tr>
    				<tr>
    					<td >物料编码</td>
    					<td>C.9.291400</td>
    				</tr>
    				<tr>
    					<td >数量</td>
    					<td >10000</td>
    				</tr>
    				<tr>
    					<td >物料描述</td>
    					<td >C2沙剂-规格(25kg/桶)</td>
    				</tr>
    				<tr>
    					<td>批次</td>
    					<td >20160507</td>
    				</tr>
    				<tr >
    					<td>下架</td>
    					<td ><input style="width:35px;" type="text" id="num" name="num" /></td>
    				</tr>
    			</table>
    		</li>
     		<li class="li">
    			<input  class="button"  type="button"  style="width:25%"  onclick="stoQuy()" value="确定">
    			<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=3.2';" value="返回">
    			<input  class="button" 	type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="首页">
    		</li>
    	</ul>
    	</div>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("num").focus();
  </script>
</html>
