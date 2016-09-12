<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>生产订单收货</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<script src="/js/jquery.js"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="/css/jiuhui.css" rel="stylesheet">
	<script type="text/javascript">
function submit1(obj){
	var objno=$("#objno").val();
	if(objno=='' || objno==null){
		alert("请输入工号!");
		return;
	}
	var flag=$("#flag").val();
	if(flag!='true'){
		alert("工号不存在");
		return;
	}
	
  	obj.disabled=true;
  	
  	
  	document.form.submit();
  }
  function checkObjno(){
  		var objno=$("#objno").val();
  		if(objno=='' || objno==null)return;
		jQuery.ajax({
			url:'/receiptJson.do',
	 		async:false,
	 		type:"post",
	 		data:{"showType":"checkObjno","objno":objno},
	 		dataType:'json',
	 		success:function(data){
	 			var count=data.count;
	 			if(count<=0){
	 				$("#flag").attr("value","false");
	 				$("#objno").attr("value","");
	 			}else{
	 				$("#flag").attr("value","true");
	 			}
	 		},
	        error:function(){ 
	           $("#objno").attr("value","");      
		       $("#flag").attr("value","false");
		    }
		});
	
	}
	function keyDown() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("按键码: " + keycode + " 字符: " + realkey);
       if(keycode=='13'){
       		window.event.returnValue = false;
       }
   }
   document.onkeydown = keyDown;
  function forward(){
  	window.location.href="/receiptAdd.do";
  }
  function reset(){
  	$('.input').val("");
  }
	</script>
  </head>
  
  <body>
  <div style="padding-top: 40px;">
  <form name="form" action="/receiptEdit.do">
     <input id="flag" name="flag" type="hidden" />
	<input name="aufnr" type="hidden" value="${receiptObj.aufnr}"/>
	<input name="matnr" type="hidden" value="${receiptObj.matnr}"/>
	<input name="meins" type="hidden" value="${receiptObj.meins}"/>
	<input name="wemng" type="hidden" value="${receiptObj.wemng}"/>
	<input name="sobkz" type="hidden" value="${receiptObj.sobkz}"/>
	<input name="lgort" type="hidden" value="${receiptObj.lgort}"/>
	<input name="charg" type="hidden" value="${receiptObj.charg}"/>
	<input name="meng" type="hidden" value="${receiptObj.meng}"/>
	<input name="boxs" type="hidden" value="${receiptObj.boxs}"/>
	<input name="maktx" type="hidden" value="${receiptObj.maktx}"/>
	<input name="sonum" type="hidden" value="${receiptObj.sonum}"/>
	
     <ul>
     	<li class="li" ></li>
     	<li class="li" style="margin: 20px 0px 0px 0px;">工牌号：<input name="objno" onchange="checkObjno()" class="text3" type="text"  id="objno" > </input></li>


	
		<li class="li" style="margin: 20px 0px 0px 0px;">
		<input type="button" valign="center" style="width:40px;height:25px;margin-left: -30px;" class="button" onclick="submit1(this);" value="确定"/>
		<input  class="button" type="button" style="width:40px;height:25px;" onclick="reset();" value="重置"/>
		<input  class="button"  type="button" style="width:40px;height:25px;" onclick="forward();" value="返回"/>
		<input   type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
		</li>
		</li>
		</ul>

</form>
</div>
  </body>
  <script type="text/javascript">
	document.getElementById("objno").focus();
  </script>
</html>
