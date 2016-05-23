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
		alert("请填写委外发货数量");return;
	}
	document.jiuhui.submit();
}
function getcount(){
	var num1=$("#num1").val();
	var num2=$("#num2").val();
	var num3=$("#num3").val();
  	if(num1=="") num1=0;
  	if(num2=="") num2=0;
  	if(num3=="") num3=0;
  	if(parseFloat(num1) > 10000){
		$("#num1").attr("value","");
		alert("领料数量大于库存");return;
	}
	if(parseFloat(num2) > 10000){
		$("#num2").attr("value","");
		alert("领料数量大于库存");return;
	}
	if(parseFloat(num3) > 5000){
		$("#num3").attr("value","");
		alert("领料数量大于库存");return;
	}
  	//供应商生产日期控制
	if(num1 != 10000 && parseFloat(num2) != 0){
		$("#num2").attr("value","");
		alert("上一仓位未领完！");
		return;
	}
	if(num2 != 10000 && parseFloat(num3) != 0){
		$("#num3").attr("value","");
		alert("上一仓位未领完！");
		return;
	}
  	$("#num").attr("value",parseFloat(num1)+parseFloat(num2)+parseFloat(num3));
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
  <form name="jiuhui"  id="jiuhui" method="post" action="MainServlet?flag=weiwaiC">
  		<input name="aufnr"  type="hidden" value="<%=request.getSession().getAttribute("aufnr") == null ? "" : request.getSession().getAttribute("aufnr")%>" />
    	<div style="margin-left: -15px;">
    	
    	<ul>
    		<li class="li">
    			物料编码：<input name="matnr" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="matnr" value = "<%=request.getSession().getAttribute("matnr") == null ? "": request.getSession().getAttribute("matnr")%>" />
    		</li>
    		<li class="li">
    			物料描述：<input name="maktx" readonly=readonly style="width:60%;heigth:70%;background-color:#D8D8D8;"  type="text"  id="maktx" value = "<%=request.getSession().getAttribute("maktx") == null ? "": request.getSession().getAttribute("maktx")%>"/>
    		</li>
    		<li class="li">
    			数量合计：<input style="width:45%;heigth:70%;background-color:#D8D8D8;" type="text" id="num" name="num" />
    		</li>
    		<li class="li">
    			<table class="table_list">
    				<tr>
    					<td align="center">序号</td><td align="center">仓位</td><td align="center">批次</td><td align="center">仓位数量</td><td align="center">选择数量</td>
    				</tr>
    				<tr>
    					<td align="center">1</td>
    					<td align="center">A1-1</td>
    					<td align="center">20160507</td>
    					<td align="center">10000</td>
    					<td align="center"><input style="width:35px;heigth:70%;" type="text" id="num1" name="num1"  onchange="getcount()"/></td>
    				</tr>
    				<tr>
    					<td align="center">2</td>
    					<td align="center">A1-2</td>
    					<td align="center">20160507</td>
    					<td align="center">10000</td>
    					<td align="center"><input style="width:35px;heigth:70%;" type="text" id="num2" name="num2" onchange="getcount()" /></td>
    				</tr>
    				<tr>
    					<td align="center">3</td>
    					<td align="center">A1-3</td>
    					<td align="center">20160507</td>
    					<td align="center">5000</td>
    					<td align="center"><input style="width:35px;heigth:70%;" type="text" id="num3" name="num3" onchange="getcount()" /></td>
    				</tr>
    			</table>
    		</li>
     		<li class="li">
    				<input  class="button"  type="button"  style="width:25%;margin-left:-25px;"  onclick="stoQuy()" value="确定">
    				<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=2.3';" value="返回">
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
