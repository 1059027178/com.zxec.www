<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    <title>批量采集</title>
	<META http-equiv=Content-Type content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- <link href="/css/jiuhui.css" rel="stylesheet"> -->
	<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
	<script src="/js/jquery.js"></script>  
	<script type="text/javascript" src="../../../js/alert1.js"></script>
  </head>
  <script type="text/javascript">
  	
  	function js(){
  		var lonstr=$("#str").val();
  		var str=lonstr.split("/");
  		if(str.length>0){
	  		var ZTMID = str[11];
	  		checkout(ZTMID);
  		}else{
  			alert("未扫描到信息！");
  		}
	    $("#str").val("");
		$("#str").focus();
  	}
  	function checkout(ZTMID){
  		if(ZTMID=='' || ZTMID==null) return;
		jQuery.ajax({
			url:'/checkoutJson.do',
	 		async:true,
	 		type:"post",
	 		data:{
		 		"showType":"checkout",
		 		"ZTMID":ZTMID,
		 		"WERKS":$("#werks").val()
	 		},
	 		dataType:'json',
	 		success:function(data){
  				var flag = data.ZYFHGZ;
	 			var msg = "";
	 			//console.log("flag = " + flag);
	 			if(flag == ""){//未过账
	 				var AZTMIDObj = $("input[name=AZTMID]");
	 				var BZTMIDObj = $("input[name=BZTMID]");
	 				var CZTMIDObj = $("input[name=CZTMID]");
	 				var DZTMIDObj = $("input[name=DZTMID]");
	 				var EZTMIDObj = $("input[name=EZTMID]");
	 				var flag1 = ( ZTMID == AZTMIDObj.val() || ZTMID == BZTMIDObj.val() || ZTMID == CZTMIDObj.val() || ZTMID == DZTMIDObj.val());
	 				if(flag1){
	 					msg += "<br />" + ZTMID + "已扫描！";
	 				}
	 				else if(AZTMIDObj.val() == "") AZTMIDObj.val(ZTMID);
	 				else if (BZTMIDObj.val() == "") BZTMIDObj.val(ZTMID);
	 				else if (CZTMIDObj.val() == "") CZTMIDObj.val(ZTMID);
	 				else if (DZTMIDObj.val() == "") DZTMIDObj.val(ZTMID);
	 				else if (EZTMIDObj.val() == "") EZTMIDObj.val(ZTMID);
	 				else{
	 					msg += "<br />数量已达到上限！";
	 				}
	 			}else if (flag == "X"){//已过账
	 				msg += "<br />" + ZTMID + "已入库！";
	 			}
	 			if(msg != ""){
	 				alert(msg);
	 			}
	 		},
	        error:function(){
		       alert("<br />系统异常，请联系管理员");
		    }
		});
	
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
  function forward(){
  	window.location.href="/batchStorage.do";
  }
  function submit1(obj){
  	obj.disabled=false;
  	document.form.submit();
  }
  function reset(){
  	$('.input').val("");
  }
  </script>
  <style>
  	.li {
  		margin-top:7px;
  		font-family:"微软雅黑";
		font-size:10px;
		list-style-type:none;
		height:10px; 
		line-height:5px;
  	}
  	.li1{
  		height:15px;
  		list-style-type:none;
  		padding:0;
  		margin-left: -15px;
  	}
  	.li1 #str{
  		white-space：nowrap;
  		/*width:82.5%;*/
  		width:180px;
  		height:20px;
  	}
  	.li .text{
  		width:113px;
  		height:20px;
  	}
  </style>
  <body>
  <form name=form action="/batchStorageEdit.do" >
  	<input type="hidden" name="werks" id="werks" value="${werks }">
 	<input type="hidden" name="bwlvs" id="bwlvs" value="${bwlvs }">
  	<div>
  		<ul>
  			<li class="li1"><input name="str" type="text"  id="str" onchange="js()"></li>
  			<li class="li">物料卡A：<input name="AZTMID" readonly=readonly type="text" class="text" /></li>
  			<li class="li">物料卡B：<input name="BZTMID" readonly=readonly type="text" class="text" style="margin-left:1px;"/></li>
  			<li class="li">物料卡C：<input name="CZTMID" readonly=readonly type="text" class="text" /></li>
  			<li class="li">物料卡D：<input name="DZTMID" readonly=readonly type="text" class="text" style="margin-left:-1px;"/></li>
  			<li class="li">物料卡E：<input name="EZTMID" readonly=readonly type="text" class="text" /></li>
  			<li class="li"><input type="button" valign="center" id="guozhang" class="button" onclick="submit1(this);" style="margin-left:-30px;width:40px;height:25px;" value="过账"/>
  			<input class="button" type="button" onclick="forward();" style="width:40px;height:25px;" value="返回"/>
  			<input class="button" type="button" onclick="reset();" style="width:40px;height:25px;" value="重置"/>
  			<input class="button" type="button" onclick="window.location.href='/main.do';" style="width:40px;height:25px;" value="首页"></li>
  		</ul>
  	</div>
     
</form>
  </body>
  <script type="text/javascript">
  	document.getElementById("str").focus();
  </script>
</html>
