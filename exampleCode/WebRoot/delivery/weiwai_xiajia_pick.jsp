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
	  		var matnr=str[3];//物料编码
	  		var batchNo=str[7];//批次号
	  		$("#matnr").attr("value",matnr);
	  		$("#batchNo").attr("value",batchNo);
  		}
  	}
function stoQuy(){
  var batchNo=document.getElementById("batchNo").value;
  	if(batchNo== ""){
  		alert("请填写批次号");
  		return;
  	}	 
  	var matnr=document.getElementById("matnr").value;
  	if(matnr== ""){
  		alert("请填写物料编码");
  		return;
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
  <form name="jiuhui"  id="jiuhui" method="post" action="MainServlet?flag=xiajia">
    	<div style=" padding-top: 50px;">
    	<ul>
    		<li class="li">
    			<input style="width:82%;heigth:70%;" type="text" id="saomiao" name="saomiao"  value="" onchange="js()"/>
    		</li>
    		<li class="li">
    			物料编码：<input name="matnr" style="width:50%;heigth:70%;" class="text"  readonly=readonly type="text" id="matnr" value = "<%=request.getSession().getAttribute("matnr") == null ? "": request.getSession().getAttribute("matnr")%>"/>
    		</li>
    		<li class="li">
    			批&nbsp;次&nbsp;号：<input name="batchNo" readonly=readonly style="width:50%;heigth:70%;background-color:#D8D8D8;"  type="text"  id="batchNo" value = "<%=request.getSession().getAttribute("batchNo") == null ? "": request.getSession().getAttribute("batchNo")%>"/>
    		</li>
    		<!-- <li class="li">
    			供应商生产日期：<input style="width:45%;heigth:70%;background-color:#D8D8D8;" type="text" id="date" name="date"  value=""/>
    		</li> -->
    		<li class="li">
    			仓&nbsp;库&nbsp;号：<input style="width:30%;heigth:70%;background-color:#D8D8D8;" type="text" id="no" name="no"  value="311"/>
    		</li>
     		<li class="li" style="margin: 20px 0px 0px -15px;">
    				<input  class="button"  type="button"  style="width:25%"  onclick="stoQuy()" value="确定">
    				<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=2';" value="返回">
    				<input  class="button" 	type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="首页">
    		</li>
    	</ul>
    	</div>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("saomiao").focus();
  </script>
</html>
