<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>">
    
    <title>上架</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<meta http-equiv="description" content="This is my page">
	<script src="/js/jquery.js"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="/css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  	function choose1(){
  		var bs=$("#bs").attr("checked");
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
  		if(boxs=='' || boxs==null)return;
  		if(meng=='' || meng==null)return;
  		//alert(parseFloat(meng)*parseFloat(boxs));
  		$("#wemng").attr("value",parseFloat(meng)*parseFloat(boxs));
  	}
  	//PO/行项目/供应商/物料编码/每袋数量/单位/库存地点/批次号/环保标识/检验/供应商生产日期/供应商批次号/库存类别
  	function js(){
  		var lonstr=$("#str").val();
  		var str=lonstr.split("/");
  		//alert(str.length);
  		if(str.length>0){
	  		//var aufnr=str[0];//采购订单
	  		//var hang=str[1];//行项目
	  		var matnr=str[3];//物料编码
	  		var meng=str[4];//每袋数量
	  		var meins=str[5];//单位
	  		var lgort=str[6];//库存地点
	  		var charg=str[7];//批次号
	  		var sobkz=str[12];//库存类别
	  		
	  		$("#matnr").attr("value",matnr);
	  		$("#meng").attr("value",meng);
	  		$("#charg").attr("value",charg);
	  		$("#meins").attr("value",meins);
	  		$("#lgort").attr("value",lgort);
	  		$("#sobkz").attr("value",sobkz);
	  		
	  		//choose1();
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
  	function keyDown() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("按键码: " + keycode + " 字符: " + realkey);
       if(keycode=='13'){
       		js();
       }
   }
   document.onkeydown = keyDown;
   
	function keyUp(){
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
       //alert("按键码: " + keycode + " 字符: " + realkey);
		 if(keycode=='86'){
       		js();
       }
	}
   document.onkeyup = keyUp;
  function forward(){
  	window.location.href="/main.do?two=1";
  }
  function submit1(obj){
  	if($("#matnr").val() == ""){
  		alert("请扫描物料卡！");return;
  	}
  	if($("#wemng").val() == ""){
  		alert("请填写上架袋数！");return;
  	}
  	obj.disabled=false;
  	document.form.submit();
  }
  function reset(){
  	$('.input').val("");
  	document.getElementById("str").focus();
  }
  $(function (){
	  $("#boxs").focus(function (){
	  	acount();
	  });
  });
  </script>
  <body>
  <form name=form action="/groundingView.do">
  <%-- <input type="hidden" name="sonum" id="sonum"  value="${receiptObj.sonum}"> --%>
  	<div style="padding-top: 40px;">
  		<ul>
  			<li style="height:15px;list-style-type:none;"><input name="str" type="text" style="width:70%;height:20px;"  id="str" onchange="js()"/></li>
  			<li class="li">物料编码：<input name="matnr" class="text"  readonly=readonly type="text" id="matnr" value="${receiptObj.matnr}"/></li>
  			<li class="li">物料描述：<input name="maktx" class="text"  readonly=readonly type="text" id="maktx" value="${receiptObj.maktx}"/></li>
  			<li class="li">袋数量/袋数：<input name="meng" readonly=readonly style="width:40px;background-color:#D8D8D8;height:20px;" type="text" id="meng" value="${receiptObj.meng}"/>/<input name="boxs" style="width:35px;height:20px;" type="text" value="${receiptObj.boxs}" id="boxs" onchange="acount();"/></li>
  			<li class="li">批<span style="margin-left:28px;"></span>次：<input name="charg" class="text" readonly=readonly value="${receiptObj.charg}" style="background-color:#D8D8D8;"  type="text"  id="charg"/></li>
  			<li class="li">总<span style="margin-left:14px;"></span>数量：<input name="wemng" value="${receiptObj.wemng}" type="text" class="text1" id="wemng" /><input name="meins" value="KG" style="width:33px;" class="text2" readonly=readonly type="text"  id="meins"/></li>
  			<li class="li">库存地点：<input name="lgort" type="text"  value="${receiptObj.lgort}" class="text3" id="lgort"/></li>
  			<%-- <li class="li">库存类别：<input name="sobkz"  value="${receiptObj.sobkz}" readonly=readonly type="text" class="text"  id="sobkz"></li> --%>
  			<li class="li"><input type="button" valign="center" class="button" onclick="submit1(this);" style="width:40px;height:25px;margin:10px 0px 0px -28px;" value="确定"/>
  			<input  class="button"  type="button" onclick="forward();" style="width:40px;height:25px;" value="返回"/>
  			<input  class="button" type="button" onclick="reset();" style="width:40px;height:25px;" id="reset" value="重置"/>
  			<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页"/></li>
  			
  		</ul>
  	</div>
     
</form>
 
  </body>
    <script type="text/javascript">
  document.getElementById("str").focus();
  </script>
</html>
