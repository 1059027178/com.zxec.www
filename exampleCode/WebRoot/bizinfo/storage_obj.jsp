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
	var num=$("#moveNum").val();
	var toLiteraNO=$("#toLiteraNO").val();
	if(num == ""||num == "0"){
		alert("请填写数量");return;
	}
	if(toLiteraNO == ""){
		alert("请填写目标仓位！");return;
	}
	document.jiuhui.submit();
}
function stoQuy1(){
	var num=$("#moveNum").val();
	var toLiteraNO=$("#toLiteraNO").val();
	if(toLiteraNO == ""){
		alert("请填写目标仓位！");return;
	}
	$("#moveNum").attr("value",num);
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
  <form name="jiuhui"  id="jiuhui" method="post" action="MainServlet?flag=storageMsg">
    	<div style=" padding-top: 50px;">
    	<ul>
    		<li class="li">
    			源 仓 位 <input name="literaNO" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="literaNO" value = "<%=request.getSession().getAttribute("literaNO") == null ? "": request.getSession().getAttribute("literaNO")%>" />
    		</li>
    		<li class="li">
    			物料编码 <input name="matnr" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="matnr" value = "C.9.291400" />
    		</li>
    		<li class="li">
    			批 次 号 <input name="batchNO" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="batchNO" value = "20160507" />
    		</li>
    		<li class="li">
    			特殊库存 <input name="tskucun" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="num" value = "" />
    		</li>
    		<li class="li">
    			仓位数量 <input name="num" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="num" value = "10000" />
    		</li>
    		<li class="li">
    			移位数量 <input name="moveNum" style="width:60%;heigth:70%;" class="text3" type="text" id="moveNum" value="<%=request.getSession().getAttribute("num") == null ? "": request.getSession().getAttribute("num")%>" />
    		</li>
    		<li class="li">
    			目标仓位 <input name="toLiteraNO" style="width:60%;heigth:70%;" class="text3"   type="text" id="toLiteraNO" value="A2-4" />
    		</li>
     		<li class="li" style="margin:10px 0px 0px -20px;">
    			<input  class="button"  type="button"  style="width:20%"  onclick="stoQuy()" value="保存">
    			<input  class="button"  type="button"  style="width:25%"  onclick="stoQuy1()" value="全下架">
    			<input  class="button"  type="button"  style="width:20%"  onclick="window.location.href='MainServlet?flag=storageInfo';" value="返回">
    			<input  class="button" 	type="button"  style="width:20%"  onclick="window.location.href='MainServlet?flag=return';" value="首页">
    		</li>
    	</ul>
    	</div>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("num1").focus();
  </script>
</html>
