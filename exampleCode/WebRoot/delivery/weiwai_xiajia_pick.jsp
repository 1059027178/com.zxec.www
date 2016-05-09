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
	function js(){
  		var lonstr=$("#saomiao").val();
  		var str=lonstr.split("/");
  		//alert(str.length);
  		if(str.length>0){
	  		var matnr=str[1];
	  		$("#matnr").attr("value",matnr);
  		}
  	}
function stoQuy(){
  var werks=document.getElementById("werks").value;
  	if(werks==0){
  		alert("工厂为空，无法查询");
  		return;
  	}	 
  	var lgort=document.getElementById("lgort").value;
  	if(lgort==0){
  		alert("库存地点为空，无法查询");
  		return;
  	}
  	var lgort=document.getElementById("lgort").value;
  	if(jQuery("#pici").attr("checked")=="checked"){
  		document.getElementById("pici").value='pici';
	}
	document.jiuhui.submit();
}
  	function keyDown() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("按键码: " + keycode + " 字符: " + realkey);
       if(keycode=='13'){
       		js();
       }
   }
   document.onkeydown = keyDown;
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
  <form name="jiuhui"  id="jiuhui" method="post" action="/stoquyList.do">
    	<div style=" padding-top: 50px;">
    	<ul>
    		<li class="li">
    			<input style="width:82%;heigth:70%;" type="text" id="saomiao" name="saomiao"  value="" onchange="js()"/>
    		</li>
    		<li class="li">物料编码：<input name="matnr" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="matnr"/></li>
    		<li class="li">批&nbsp;次&nbsp;号&nbsp;：<input name="charg" readonly=readonly style="width:60%;heigth:70%;background-color:#D8D8D8;"  type="text"  id="charg"></li>
    		<li class="li">
    			供应商生产日期：<input style="width:45%;heigth:70%;background-color:#D8D8D8;" type="text" id="date" name="date"  value=""/>
    		</li>
    		<li class="li">
    			仓&nbsp;位&nbsp;号&nbsp;：<input style="width:30%;heigth:70%;background-color:#D8D8D8;" type="text" id="no" name="no"  value="311"/>
    		</li>
     		<li class="li">
    				<input  class="button"  type="button"  style="width:25%"  onclick="stoQuy()" value="查询">
    				<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=2';" value="返回">
    				<input  class=button type="button" style="width:25%" onclick="window.location.href='MainServlet?flag=return';" value="首页">
    		</li>
    	</ul>
    	</div>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("werks").focus();
  </script>
</html>
