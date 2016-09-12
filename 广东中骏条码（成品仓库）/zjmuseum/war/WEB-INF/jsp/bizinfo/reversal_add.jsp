<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>生产订单冲销</title>
    
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
  </head>
  <script type="text/javascript">
  	function choose1(){
  		var bs=$("#bs").attr("checked");
  		//alert(bs);
  		if(bs=="checked"){
  			$("#wemng").css("background-color", "white"); 
  			$("#wemng").removeAttr("readonly"); //
  			//alert($("input[id='bs']").val());
  			$("#boxs").css("background-color", "#D8D8D8"); 
  			$("#boxs").attr("readonly", "readonly"); //removeAttr
  			$("#boxs").attr("value",'');
  			$("#wemng").attr("value",'');
  		}else{
  		
  			$("#boxs").css("background-color", "white"); 
  			$("#boxs").removeAttr("readonly"); //
  			$("#wemng").attr("value",'');
  			$("#wemng").css("background-color", "#D8D8D8"); 
  			$("#wemng").attr("readonly", "readonly"); //removeAttr
  		}
  		
  	}
  	function acount(){
  		var meng=$("#meng").val();
  		var boxs=$("#boxs").val();
  		if(meng=="")meng=0;
  		//alert(parseFloat(meng)*parseFloat(boxs));
  		if(boxs=='' || boxs==null)return;
  		if(meng=='' || meng==null)return;
  		$("#wemng").attr("value",parseFloat(meng)*parseFloat(boxs));
  	}
  	function js(){
  		var lonstr=$("#str").val();
  		var str=lonstr.split("/");
  		//alert(str.length);
  		if(str.length>0){
	  		var aufnr=str[0];
	  		var matnr=str[1];
	  		var bs=str[2];
	  		var meng=str[3];
	  		var charg=str[4];
	  		var sobkz=str[5];
	  		var sonum=str[6];
	  		var lgort=str[7];
	  		var meins=str[8];
	  		$("#aufnr").attr("value",aufnr);
	  		$("#matnr").attr("value",matnr);
	  		$("#sonum").attr("value",sonum);
	  		$("#meng").attr("value",meng);
	  		//$("#wemng").attr("value",wemng);
	  		$("#charg").attr("value",charg);
	  		$("#meins").attr("value",meins);
	  		$("#sobkz").attr("value",sobkz);
	  		$("#lgort").attr("value",lgort);
	  		
	  		if(bs=='X'){
	  			$("#bs").attr("checked","checked");
	  			
	  		}else{
	  			$("#bs").removeAttr("checked");//
	  		}
	  		choose1();
	  		getMaktx(matnr);
	  		$("#boxs").focus();
  		}
  	}
  	function getMaktx(matnr){
  		if(matnr=='' || matnr==null)return;
		jQuery.ajax({
			url:'/receiptJson.do',
	 		async:false,
	 		type:"post",
	 		data:{"showType":"getMaktx","matnr":matnr},
	 		dataType:'json',
	 		success:function(data){
	 			$("#maktx").attr("value",data.maktx);
	 		},
	        error:function(){       
		       alert("系统异常，请联系管理员");
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
  	window.location.href="/main.do?two=1";
  }
  function submit1(obj){
  	obj.disabled=false;
  	document.form.submit();
  }
  function reset(){
  	$('.input').val("");
  }
  </script>
  
  <body>
  <form name=form action="/reversalCrt.do">
  <input type="hidden" name="sonum" id="sonum" >
  	<div style="margin-left:-15px;">
  		<ul>
  			<li style="height:15px;list-style-type:none;padding:0; margin:0;"><input name="str"  type="text" style="white-space：nowrap;width:82.5%;"  id="str" onchange="js()"></li>
  			<li class="li">生产订单：<input name="aufnr" size="5" readonly=readonly class="text"  type="text"  id="aufnr" > </input></li>
  			<li class="li">物料编码：<input name="matnr" class="text"  readonly=readonly type="text" id="matnr"></li>
  			<li class="li">物料描述：<input name="maktx" class="text"  readonly=readonly type="text" id="maktx"></li></br>
  			<li class="li">尾箱标识：<input type="checkbox" onclick="choose1();" id="bs" style="width:20px;height:20px;" name="bs"></li>
  			<li class="li">箱数量/箱数：<input name="meng" style="width:40px;background-color:#D8D8D8;height:20px;" readonly=readonly type="text" id="meng"/>/<input name="boxs" style="width:39px;height:20px;" type="text"  id="boxs" onchange="acount();"/></li>
  			<li class="li">批&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;次：<input name="charg" readonly=readonly  type="text" class="text" id="charg"></li>
  			<li class="li">总<span style="margin-left:7px;"></span>数<span style="margin-left:7px;"></span>量：<input name="wemng" type="text" class="text1" id="wemng" /><input name="meins" style="width:37px;" class="text2" readonly=readonly type="text"  id="meins"/></li>
  			<li class="li">库存地点：<input name="lgort" class="text3" type="text" id="lgort"></li>
  			<li class="li">特殊库存：<input name="sobkz" readonly=readonly type="text" class="text"  id="sobkz"></li>
  			<li class="li"><input type="button" valign="center" class="button" onclick="submit1(this);" style="margin-left:-30px;width:40px;height:25px;" value="确定"/>
  			<input  class="button"  type="button" onclick="forward();" style="width:40px;height:25px;" value="返回"/>
  			<input  class="button" type="button" onclick="reset();" style="width:40px;height:25px;" value="重置"/>
  			<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页"></li>
  		</ul>
  	</div>
     
</form>
  </body>
  <script type="text/javascript">
  document.getElementById("str").focus();
  </script>
</html>
