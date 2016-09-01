<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<!-- Le styles -->
<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
<script src="/js/jquery.js"></script>
  <script  type="text/javascript">
  	function fanhui(){
  		document.thinkway.action="/delordView.do";
  		document.thinkway.submit();
  	}
  	function validateForm(){
  		var menge=document.getElementById("menge").value;
  		var lgort_from=document.getElementById("lgort_from").value;
  		var lgort_to=document.getElementById('lgort_to').value;
  		var bwart=document.getElementById('bwart').value;
  		
  		if(menge.length==0){
	  		alert("数量为空，请填写");
	  		return false;
	  	}
	  	if(menge.length==0){
	  		alert("数量为空，请填写");
	  		return false;
	  	}
	  	if(lgort_from.length==0){
	  		alert("库存地点从为空，请填写");
	  		return false;
	  	}
	  	if(lgort_to.length==0){
	  		alert("库存地点到为空，请填写");
	  		return false;
	  	}
	  	if(bwart.length==0){
	  		alert("移动类型为空，请填写");
	  		return false;
	  	}
  		document.thinkway.submit();
  	}
  	function acount(){
  		var meng=$("#meng").val();
  		var boxs=$("#boxs").val();
  		if(meng=="")meng=0;
  		if(boxs=="" || boxs==null)return;
  		if(meng=="" || meng==null)return;
  		//alert(parseFloat(meng)*parseFloat(boxs));
  		$("#menge").attr("value",parseFloat(meng)*parseFloat(boxs));
  		$("#lgort_to").focus();
  	}
  	function keyDown() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("按键码: " + keycode + " 字符: " + realkey);
       if(keycode=='13'){
       		acount();
       }
   }
   document.onkeydown = keyDown;
  </script>
</HEAD>
<BODY>
<div class="div" style="padding-top:40px;">
	<form  id="thinkway" name="thinkway" method="post" action="/dumpAdd.do">
		<input type="hidden" name="matnr" id="matnr" value="${matnr}">
		<input type="hidden" name="charg" id="charg" value="${charg}">
		<input type="hidden" name="maktx" id="maktx" value="${maktx}">
		<input type="hidden" name="sobkz" id="sobkz" value="${sobkz}">
		<input type="hidden" name="sonum" id="sonum" value="${sonum}">
		<input type="hidden" name="meins" id="meins" value="${meins}">
		<input type="hidden" name="radio" id="radio" value="2">
			
		<table class="table_list" >
		<tr>
			<td >物料编码：<span style="margin-left: 20px;"></span>${matnr}</td>
		</tr>
		<tr>
			<td >物料描述：<span style="margin-left: 20px;"></span>${maktx}</td>
		</tr>
		<tr>
			<td >批<span style="margin-left:28px;"></span>次：<span style="margin-left: 20px;"></span>${charg}</td>
		</tr>
		<tr>
			<td >
				袋数量/袋数：<input name="meng" readonly=readonly style="width:30px;background-color:#D8D8D8;"  type="text"  id="meng" value="${meng}"/>
				/<input name="boxs" style="width:47px;" type="text" value="" id="boxs" onblur="acount();"/>
  			</td>
		</tr>
		<tr>
			<td >
				总<span style="margin-left:7px;"></span>数<span style="margin-left:7px;"></span>量：<span style="margin-left: 15px;"></span>
				<input style="width:52px;background-color:#D8D8D8;" name="menge" value="${xzsl}" readonly=readonly type="text" id="menge" >
				<input name="meins" value="${meins}"  style="width:30px;background-color:#D8D8D8;"  readonly=readonly type="text"  id="meins" />
			</td>
		</tr>
		<tr >
			<td >库存地点：<span style="margin-left: 15px;"></span>
			<input name="lgort_from" type="text" style="width: 15%;"  id="lgort_from" value="3201">到<input name="lgort_to" type="text" style="width:15%"  id="lgort_to" value=""/>
			</td>
		</tr>
		<%-- <tr>
			<td >特殊库存:</td>
			<td  >${sobkz}${sonum}</td>
		</tr> --%>
		<tr>
			<td >移动类型：<span style="margin-left: 15px;"></span>
			<input name="bwart" size="3" style="width:15%" type="text"  id="bwart" value="311"/>
			</td>
		</tr>
		<tr style="height:10px;"></tr>
		<tr>
			<td  colspan="2" >
				<input type="button" style="width:40px;height:25px;margin-left:15px;" onclick="return validateForm()" value="过账"/>
				<input type="button" style="width:40px;height:25px;" value="返回" onclick="window.location.href='/dumpView.do';"/>
				<input type="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页"/>
			</td>
		</tr>
		</table>
	</form>
</div>
</BODY>
 <script type="text/javascript">
  document.getElementById("boxs").focus();
  </script>
</HTML>