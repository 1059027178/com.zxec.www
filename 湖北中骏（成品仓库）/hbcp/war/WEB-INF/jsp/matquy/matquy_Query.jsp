<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<script language="javascript" src="/js/jiuhui.js"></script>
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
<script src="/js/jquery.js"></script>  

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
		 	document.getElementById("matnr").value=str[1];
		 	document.getElementById("lgort").value=str[7];
		 	document.getElementById("charg").value=str[4];
		 	//document.getElementById("werks").value="3300";
		 	
		 	jQuery.ajax({
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
			});
		 	//document.getElementById("saomiao").value="";
		}
   }
   function reset(){
  		document.getElementById("matnr").value="";
  		document.getElementById("lgort").value="";
  		document.getElementById("charg").value="";
  		document.getElementById("werks").value="";
 		document.getElementById("saomiao").focus();
  }
  	function keyUp() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("按键码: " + keycode + " 字符: " + realkey);
       if(keycode=='86'){
       		js();
       }
   }
   document.onkeyup = keyUp;


  </script>
  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    
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
    <form name="jiuhui"  id="jiuhui" action="/matquyList.do">
        <div class="div" style=" padding-top: 50px;">
    	<ul>
    		<li class="li">
    			<input style="width:75%;" type="text" id="saomiao" onchange="js()" name="saomiao"  value=""/>
    		</li>
    		<li class="li">
    			物料编码：<input  type="text" class="text" style="width:90px;background-color:white;" id="matnr" name="matnr"  value=""/>
    		</li>
    		<li class="li">
    			库存地点：<input  type="text" class="text" style="width:90px;background-color:white;" id="lgort" name="lgort"  value=""/>
    		</li>
    		<li class="li">
    			批  &nbsp;&nbsp; 次：<input  type="text" class="text" style="width:90px;background-color:white;" id="charg" name="charg"  value=""/>
    		</li>
    		<li class="li">
    		工  &nbsp;&nbsp; 厂：<input  type="text" class="text" id="werks" style="width:90px;background-color:white;" name="werks"  value="3300"/></td>
    		</li>
    <li class="li"></li>
     <li class="li">
    				<input  class="button"  type="button"  style="width:40px;height:25px;margin-left: -30px;" onclick="matQuy()" value="查询">
    				<input  class="button"  type="button" style="width:40px;height:25px;"  onclick="reset();" value="重置">
    				<input  class="button"  type="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do?two=5';" value="返回"></td>
    				 <input  class=button type="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
 		</li>
    	</ul>
    	</div>
    </form>
  </body>
      <script type="text/javascript">
  document.getElementById("saomiao").focus();
  </script>
</html>
