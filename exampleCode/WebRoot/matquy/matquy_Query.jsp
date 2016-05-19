<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<script language="javascript" src="./js/jiuhui.js"></script>
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
<script src="./js/jquery.js"></script>  

<script type="text/javascript">
function matQuy(){
	var matnr=document.getElementById("matnr").value;
  	if(matnr.length==0){
  		alert("物料编码为空，无法查询");
  		return;
  	}	 
  	var werks=document.getElementById("werks").value;
  	if(werks.length==0){
  		alert("工厂为空，无法查询");
  		return;
  	}
	document.jiuhui.submit();
}
</script>
   <script type="text/javascript">
   function js(){
   		var saomiao=document.getElementById("saomiao").value;
   		var str=saomiao.split("/");
		if(saomiao.length!=0){
		 	document.getElementById("matnr").value=str[3];
		 	document.getElementById("lgort").value=str[6];
		 	document.getElementById("charg").value=str[7];
		 	document.getElementById("werks").value="3100";
		 	/* jQuery.ajax({
				url:'/matquyJson.do',
		 		async:false,
		 		type:"post",
		 		data:{"showType":"getWerks","lgort":str[7]},
		 		dataType:'json',
		 		success:function(data){
		 			$("#werks").attr("value",data.werks);
		 		},
		        error:function(){       
			       alert("系统异常，请联系管理员");
			    }
			}); */
		 	//document.getElementById("saomiao").value="";
		}
   }
   function reset(){
  		document.getElementById("matnr").value="";
  		document.getElementById("lgort").value="";
  		document.getElementById("charg").value="";
  		document.getElementById("werks").value="";
  		document.getElementById("saomiao").value="";
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
    
    <title>物料查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form name="jiuhui"  id="jiuhui" action="MainServlet?flag=selectWuLiao" method = "post">
        <div class="div" style=" padding-top: 50px;">
    	<ul>
    		<li class="li">
    			<input style="width:70%;heigth=20%" type="text" id="saomiao" onchange="js()" name="saomiao"  value=""/>
    		</li>
    		<li class="li">
    			物料编码：<input  type="text" class="text" style="width:103px;background-color:white;" id="matnr" name="matnr"  value=""/>
    		</li>
    		<li class="li">
    			库存地点：<input  type="text" class="text" style="width:103px;background-color:white;" id="lgort" name="lgort"  value=""/>
    		</li>
    		<li class="li">
    			批<span style="width: 20px;"></span>次：<input  type="text" class="text" style="width:103px;background-color:white;" id="charg" name="charg"  value=""/>
    		</li>
    		<li class="li">
    		工<span style="width: 20px;"></span>厂：<input  type="text" class="text" id="werks" style="width:103px;background-color:white;" name="werks"  value=""/>
    		</li>
    <li class="li"></li>
     <li class="li">
    				<input  class="button"  type="button"  style="width:20%" onclick="matQuy()" value="查询">
    				<input  class="button"  type="button" style="width:20%"  onclick="reset();" value="重置">
    				<input  class="button"  type="button" style="width:20%" onclick="window.location.href='MainServlet?flag=4';" value="返回">
    				<input  class=button type="button" style="width:20%" onclick="window.location.href='MainServlet?flag=return';" value="首页">
 		</li>
    	</ul>
    	</div>
    </form>
  </body>
      <script type="text/javascript">
  document.getElementById("saomiao").focus();
  </script>
</html>
