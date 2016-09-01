<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>库存转储</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script src="/js/jquery.js"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="/css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
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
	  		
	  		//$("#aufnr").attr("value",aufnr);
	  		//$("#wemng").attr("value",wemng);
	  		$("#meng").attr("value",meng);
	  		$("#matnr").attr("value",matnr);
	  		$("#meins").attr("value",meins);
	  		$("#lgort").attr("value",lgort);
	  		$("#charg").attr("value",charg);
	  		$("#sobkz").attr("value",sobkz);
	  		//choose1();
	  		getPlnum(matnr);
  		}
  	}
  	function getPlnum(matnr){
  		if(matnr=='' || matnr==null)return;
		jQuery.ajax({
			url:'/receiptJson.do',
	 		async:false,
	 		type:"post",
	 		data:{"showType":"getPlnum","matnr":matnr},
	 		dataType:'json',
	 		success:function(data){
	 			//$("#lgnum").attr("value",data.lgnum);
	 			$("#lgnum").attr("value","311");
	 			$("#maktx").attr("value",data.maktx);
	 			$("#werks").attr("value",data.werks);
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
  	window.location.href="/main.do?two=4";
  }
  function submit1(obj){
  	obj.disabled=false;
  	var chk;
  	var chkObjs = document.getElementsByName("radio");
    for(var i=0;i<chkObjs.length;i++){
          if(chkObjs[i].checked){
                 chk = i;
                 break;
           }
   }
   var lonstr=$("#str").val();
   if(lonstr==null || lonstr==''){
   		alert("请扫描物料卡！");
   		return;
   }
   var charg=$("#charg").val();
   if(charg==null || charg==''){
   		alert("请输入批次！");
   		return;
   }
   var matnr=$("#matnr").val();
   if(matnr==null || matnr==''){
   		alert("请输入物料编码！");
   		return;
   }
  /*  if(chk=='2'){
   		var lgpla=document.getElementById("lgpla").value;
   		if(lgpla.length==0){
   			alert("仓位未填写，请填写");
   			return;
   		}
   } */
  	document.form.submit();
  }
  function reset(){
  	$('.input').val("");
  }
 function chooseRadio3(){
 	var radio3=$('input[name="radio"]:checked').val();
 	if(radio3==3){
 		$('input[id="lgpla"]').attr('value',"Z-00");
 	}else{
 		$('input[id="lgpla"]').attr('value',"");
 	}
  }
  </script>
  
  <body>
  <form name=form action="/dumpCheck.do">
  <input type="hidden" name="lgort" id="lgort" >
  <input type="hidden" name="maktx" id="maktx" >
  <input type="hidden" name="werks" id="werks" >
  <input type="hidden" name="meins" id="meins" >
  <input type="hidden" name="meng"  id="meng" >
  	<div style="padding-top:50px;">
  		<ul>
  			<li style="height:15px;list-style-type:none;">
  				<input name="str" class="text3" type="text" style="white-space：nowrap;width:70%;height:20px;"  id="str" onchange="js()">
  			</li>
  			<li class="li">
  				物料编码：<input name="matnr" class="text"  readonly=readonly type="text" id="matnr">
  			</li>
			<li class="li">
				批<span style="margin-left:28px;"></span>次：<input name="charg" readonly=readonly class="text"  type="text"  id="charg">
			</li>
  			<!-- <li class="li">特殊库存：<input name="sobkz" style="width:20px;" type="text" style="width:17%" id="sobkz" class="text"><input name="sonum" readonly=readonly style="width:42%;" type="text" class="text"  id="sonum"></li> -->
  			<li class="li">
  				仓<span style="margin-left:7px;"></span>库<span style="margin-left:7px;"></span>号：<input name="lgnum"  class="text3"  type="text"  id="lgnum">
  			</li>
  			<!-- <li class="li">仓&nbsp;&nbsp;位号：<input name="lgpla" class="text3"  type="text"  id="lgpla"></li>
  			<li class="li"><input name="radio" style="width:20px;" onclick="chooseRadio3();" checked=checked type="radio" id="radio1" value="1">下架转储出库</input></li>
     		<li class="li"><input name="radio" style="width:20px;" type="radio" onclick="chooseRadio3();" checked=checked id="radio2" value="2" >直接转储出入库</input></li>
     		<li class="li"><input name="radio" style="width:20px;" type="radio" onclick="chooseRadio3();" id="radio3" value="3" >质检过账</input></li> -->
  			<li class= "li" style="margin-top:10px;"></li>
  			<li class="li">
  				<span style="margin-left:-30px;"></span>
	  			<input type="button" valign="center" style="width:40px;height:25px;" class="button" onclick="submit1(this);" value="确定"/>
	  			<input  class="button"  type="button" style="width:40px;height:25px;" onclick="forward();" value="返回"/>
	  			<input  class="button" type="button" style="width:40px;height:25px;" onclick="reset();" value="重置"/>
	  			<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
  			</li>
  			
  		</ul>
  	</div>
     
</form>
  </body>
   <script type="text/javascript">
  document.getElementById("str").focus();
  </script>
</html>
