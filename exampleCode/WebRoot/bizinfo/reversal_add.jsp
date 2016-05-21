<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>PO收货冲销</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<script src="./js/jquery.js"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="./css/jiuhui.css" rel="stylesheet">
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
  		var meng=$("#everyBagNumber").val();
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
	  		var aufnr=str[0];//采购订单
	  		var lineItem = str[1];//行项目
	  		//var producer = str[2];//供应商
	  		var matnr=str[3];//物料编码
	  		var everyBagNumber = str[4];//每袋数量
	  		var unit=str[5];//单位
	  		var storageLocation=str[6];//库存地点
	  		var batchNo=str[7];//批次号
	  		//var environmentalFlag=str[8];//环保标识
	  		//var checkOut=str[9];//检验
	  		//var produceDate=str[10];//供应商生产日期
	  		//var produceBatchNo=str[11];//供应商批次号
	  		$("#aufnr").attr("value",aufnr);
	  		$("#lineItem").attr("value",lineItem);
	  		$("#matnr").attr("value",matnr);
	  		$("#everyBagNumber").attr("value",everyBagNumber);
	  		$("#lgort").attr("value",storageLocation);
	  		$("#batchNo").attr("value",batchNo);
	  		$("#unit").attr("value",unit);
	  		$("#sobkz").attr("value","Z-00");
	  		
	  		if(matnr == "C.9.291400"){
	  			$("#maktx").attr("value","C2沙剂-规格(25kg/桶)");
	  		}
	  		else if(matnr == "C.6.040501"){
	  			$("#maktx").attr("value","ABS 规格(730 颜色:本色 玻纤:无 其他:/)");
	  		}
	  		else if(matnr == "C.6.040601"){
	  			$("#maktx").attr("value","ABS-GP-22 颜色:本色 玻纤:/ 其他:/");
	  		}
	  		else if(matnr == "C.6.040701"){
	  			$("#maktx").attr("value","ABS规格(710 颜色:白色 玻纤:/ 其他:锦湖日丽710)");
	  		}
	  		else if(matnr == "C.6.040802"){
	  			$("#maktx").attr("value","ABS规格(4330C 颜色:本色 玻纤:/ 其他:/)");
	  		}
	  		
	  		if(bs=='X'){
	  			$("#bs").attr("checked","checked");
	  			
	  		}else{
	  			$("#bs").removeAttr("checked");//
	  		}
	  		choose1();
	  		getMaktx(matnr);
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

  function forward(){
  	window.location.href="MainServlet?flag=1";
  }
  function submit1(obj){
  var boxs = document.all.boxs.value;
  if(boxs == ""){
  	alert("请填写PO收货冲销箱数！");return;
  }
  	obj.disabled=false;
  	document.form.submit();
  }
  function reset(){
  	$('.input').val("");
  }
  </script>
  
  <body>
  <form name=form action="MainServlet?flag=reversalCrt"  method="post">
  <input type="hidden" name="sonum" id="sonum" >
  	<div>
  		<ul>
  			<li style="height:15px;list-style-type:none;padding:0; margin:0;}">
  				<input name="str" style="height:20px;" type="text" style="white-space:nowrap;width:80%;"  id="str" onchange="js()">
  			</li>
  			<li class="li">
  				采购订单：<input name="aufnr" style="width:80px;height:20px;" size="5" readonly=readonly class="text"  type="text"  id="aufnr" />
  				<input name="lineItem" id="lineItem" style="height:20px;width:20px" readonly=readonly class="text"/>
  			</li>
  			<li class="li">
  				物料编码：<input name="matnr" class="text"  readonly=readonly type="text" id="matnr" value="">
  			</li>
  			<li class="li">
  				物料描述：<input name="maktx" class="text"  readonly=readonly type="text" id="maktx" value="">
  			</li>
  			<!-- <li class="li">尾箱标识：<input type="checkbox" onclick="choose1();" id="bs" style="width:20px;height:20px;" name="bs"></li> -->
  			<li class="li">
  				箱数量/箱数：<input name="everyBagNumber" readonly=readonly style="width:50px;background-color:#D8D8D8;height:20px;"  type="text"  id="everyBagNumber" value="">
  				/<input name="boxs" style="width:25px;height:20px;" type="text" value="" id="boxs" onblur="acount();">
  			</li>
  			<li class="li">
  				批&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;次：
  				<input name="batchNo" readonly=readonly  style="margin-left:-1px;height:20px;background-color:#D8D8D8;"  type="text" class="text" id="batchNo">
  			</li>
  			<li class="li">
  				总&nbsp;数&nbsp; 量：<input name="wemng" value="" type="text" class="text1" id="wemng" >
  				<input name="unit" style="width:34px;height:20px;" value="" class="text2" readonly=readonly type="text"  id="unit"/>
			</li>
  			<li class="li">
  				库存地点：<input name="lgort" class="text3" type="text" id="lgort">
  			</li>
  			<li class="li">
  				特殊库存：<input name="sobkz1" style="height:20px;" readonly=readonly type="text" class="text"  id="sobkz1">
  			</li>
  			<li class="li">
  				<input type="button" valign="center" class="button" onclick="submit1(this);" style="width:40px;height:25px;" value="确定"/>
  				<input  class="button"  type="button" onclick="forward();" style="width:30px;height:25px;" value="返回"/>
  				<input  class="button" type="button" onclick="reset();" style="width:30px;height:25px;" value="重置"/>
  				<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
  			</li>
  		</ul>
  	</div>

</form>
  </body>
  <script type="text/javascript">
  document.getElementById("str").focus();
  </script>
</html>
