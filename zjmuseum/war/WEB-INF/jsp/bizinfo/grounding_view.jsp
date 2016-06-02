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
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<meta http-equiv="description" content="This is my page">
	<script src="/js/jquery.js"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="/css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  	
  	function getNlpla(){

  		var nlpla=$("#nlpla").val();
  		var lgort=$("#lgort").val();
  		if(nlpla=='' || nlpla==null){
  			alert("请输入仓位号！");
  			return;
  		}
  		if(lgort=='' || lgort==null){
  			alert("请输入库存地点！");
  			return;
  		}
		jQuery.ajax({
			url:'/receiptJson.do',
	 		async:false,
	 		type:"post",
	 		data:{"showType":"getNlpla","nlpla":nlpla,"lgort":lgort},
	 		dataType:'json',
	 		success:function(data){
	 			$("#lgber").attr("value",data.lgber);
	 			$("#lgtyp").attr("value",data.lgtyp);
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
       		getNlpla();
       }
   }
   document.onkeydown = keyDown;

  function forward(){
  	window.location.href="/groundingAdd.do";
  }
  function submit1(obj){
  	var nlpla=$("#nlpla").val();
	var lgber=$("#lgber").val();
	var lgtyp=$("#lgtyp").val();
	if(nlpla=='' || nlpla==null){
		alert("请输入仓位号！");
		return;
	}
	if(lgber=='' || lgber==null){
		alert("请输入存储区！");
		return;
	}
	if(lgtyp=='' || lgtyp==null){
		alert("请输入存储类型！");
		return;
	}
  	obj.disabled=false;
  	document.form.submit();
  }
  </script>
  <body>
  <div>
  <form name="form" action="/groundingEdit.do">
			<input name="matnr" type="hidden" value="${groundingObj.matnr}"/>
			<input name="meins" type="hidden" value="${groundingObj.meins}"/>
			<input name="wemng" type="hidden" value="${groundingObj.wemng}"/>
			<input name="sobkz" type="hidden" value="${groundingObj.sobkz}"/>
			<input id="lgort" name="lgort" type="hidden" value="${groundingObj.lgort}"/>
			<input name="charg" type="hidden" value="${groundingObj.charg}"/>
			<input name="meng" type="hidden" value="${groundingObj.meng}"/>
			<input name="boxs" type="hidden" value="${groundingObj.boxs}"/>
			<input name="sonum" type="hidden" value="${groundingObj.sonum}"/>
     <ul>
     	<li class="li" style="margin:20px 0px 0px 0px;">上架仓位：<input name="nlpla" class="text" style="background-color:white;" onchange="getNlpla()" type="text"  id="nlpla" value="${lgpla}"></li>
		<li class="li" style="margin:20px 0px 0px 0px;">存 储 区：<input name="lgber" class="text" style="background-color:#D8D8D8;" readonly= readonly type="text"  id="lgber" value="${lgber}"/> </li>
		<li class="li" style="margin:20px 0px 0px 0px;">存储类型：<input name="lgtyp" class="text" style="background-color:#D8D8D8;" readonly= readonly type="text"  id="lgtyp" value="${lgtyp}"/></li>

	
		<li class="li" style="margin:20px 0px 0px 0px;">
		<input class="button" type="button" onclick="submit1(this);" value="确定"/>
		<input class="button" type="button" onclick="forward();" value="返回"/>
		<input type="button" class="button" onclick="window.location.href='/main.do';" value="首页">
		</li>
</tr>
</table>
</form>
</div>
  </body>
</html>
