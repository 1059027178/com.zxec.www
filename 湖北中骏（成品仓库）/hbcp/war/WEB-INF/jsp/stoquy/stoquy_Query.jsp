<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<script src="/js/jquery.js"></script>  
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>   
<script language="javascript" src="/js/jiuhui.js"></script>
<script type="text/javascript">
	function reset(){
		$('input').val("");
	}
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
  		alert("����Ϊ�գ��޷���ѯ");
  		return;
  	}	 
  	var lgort=document.getElementById("lgort").value;
  	if(lgort==0){
  		alert("���ص�Ϊ�գ��޷���ѯ");
  		return;
  	}
  	if(jQuery("#pici").attr("checked")=="checked"){
  		document.getElementById("pici").value='pici';
	}
	document.jiuhui.submit();
}
  	function keyUp() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("������: " + keycode + " �ַ�: " + realkey);
       if(keycode=='86'){
       		js();
       }
   }
   document.onkeyup = keyUp;
</script>

  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    
    <title>����ѯ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form name="jiuhui"  id="jiuhui" method="post" action="/stoquyList.do">
    	<div style=" padding-top: 50px;">
    	<ul>
    		<li class="li">
    			�� &nbsp;&nbsp; ��: <input style="width:50%;heigth:70%" type="text" id="werks" name="werks"  value="3300"/>
    		</li>
    		<li class="li">
    			���ص㣺<input style="width:50%;heigth:70%" type="text" id="lgort" name="lgort"  value="330"/>
    		</li>
    		<li class="li">
    			<input style="width:82%;heigth:70%" type="text" id="saomiao" name="saomiao"  value="" onchange="js()"/>
    		</li>
    		<li class="li">
    			���ϱ��룺<input style="width:50%;heigth:70%" type="text" id="matnr" name="matnr"  value=""/>
    		</li>
    		<li class="li">
    			��  &nbsp;&nbsp; �Σ�<input style="width:50%;heigth:70%" type="text" id="charg" name="charg"  value=""/>
    		</li>
    		<li class="li">
    			<input type="checkbox" value="" id="pici" name="pici"/>������ѯ
     		</li>
     		<li class="li">
    				<input  class="button"  type="button"  style="width:20%;margin:20px 0px 0px -30px;"  onclick="stoQuy()" value="��ѯ">
    				<input  class="button"  type="button"  style="width:20%"  onclick="window.location.href='/main.do?two=5';" value="����">
    				<input  class="button"  type="button"  style="width:20%"  onclick="reset();" value="���">
    				<input  class=button type="button" style="width:20%" onclick="window.location.href='/main.do';" value="��ҳ">
    		</li>
    	</ul>
    	</div>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("saomiao").focus();
  </script>
</html>
