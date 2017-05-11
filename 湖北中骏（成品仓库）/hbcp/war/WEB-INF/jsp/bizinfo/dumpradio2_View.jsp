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
<script src="/js/jquery.js"></script>
<!-- Le styles -->
<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
  <script  type="text/javascript">
  	function fanhui(){
  		document.thinkway.action="/delordView.do";
  		document.thinkway.submit();
  	}
  	function validateForm(){
  		var menge=document.getElementById("menge").value;
  		var boxs=$("#boxs").val();
  		var lgort_from=document.getElementById("lgort_from").value;
  		var lgort_to=document.getElementById("lgort_to").value;
  		var bwart=document.getElementById("bwart").value;
  		
  		if(menge.length==0){
	  		alert("数量为空，请填写");
	  		return false;
	  	}
	  	if(boxs.length==0){
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
  		return true;
  	}
  	function acount(){
  		var meng=$("#meng").val();
  		var boxs=$("#boxs").val();
  		if(meng=="")meng=0;
  		//alert(parseFloat(meng)*parseFloat(boxs));
  		if(boxs=='' || boxs==null)return;
  		if(meng=='' || meng==null)return;
  		$("#menge").attr("value",parseFloat(meng)*parseFloat(boxs));
  	}
  </script>
</HEAD>
<BODY>
<div class="div">
	<form  id="thinkway" name="thinkway" method="post" action="/dumpAdd.do">
		 <input type="hidden" name="matnr" id="matnr" value="${matnr}">
		<input type="hidden" name="maktx" id="maktx" value="${maktx}">
		<input type="hidden" name="sobkz" id="sobkz" value="${sobkz}">
		<input type="hidden" name="sonum" id="sonum" value="${sonum}">
		<%-- <input type="hidden" name="meins" id="meins" value="${meins}"> --%>
		<input type="hidden" name="radio" id="radio" value="2">
			
			<table  class="table_list">
	
				<tr>
					<td  width="30%">物料编码:</td>
					<td align="left" >${matnr}</td>
				</tr>
				<tr>
					<td >物料描述:</td>
					<td  >${maktx}</td>
				</tr>
				<tr>
					<td >批次:</td>
					<td  ><input name="charg" type="text" style="width:35%"  id="charg" value="${charg_to}"> 到 <input name="charg_to" type="text" style="width:35%"  id="charg_to" value="${charg }"></td>
				</tr>
				<tr>
					<td>箱数量/箱数：</td>
					<td>
						<input name="meng" style="width:35%;background-color:#D8D8D8;" readonly=readonly type="text" id="meng" value="${meng }"/>&nbsp;&nbsp;/&nbsp;&nbsp;<input id="boxs" name="boxs" style="width:35%;" type="text"  id="boxs" onchange="acount();"/>
					</td>
				</tr>
				<tr>
					<td  >总数量:</td>
					<td  >
						<input style="width:58%;background-color:#D8D8D8;" name="menge" type="text" class="text1"  id="menge" value="${xzsl}" readonly="readonly" />&nbsp;<input name="meins" style="width:33px;background-color:#D8D8D8;" class="text2" readonly=readonly type="text"  id="meins" value="${meins }"/>
					</td>
				</tr>
				<tr>
					<td >库存地点:</td>
					<td  ><input name="lgort_from" type="text" style="width:35%"  id="lgort_from" value="${ lgort_to}"> 到 <input name="lgort_to" type="text" style="width:35%"  id="lgort_to" value="${lgort }"></td>	</tr>
				<tr>
					<td >特殊库存:</td>
					<td  >${sobkz}${sonum}</td>
				</tr>
				<tr>
					<td >移动类型:</td>
					<td  ><input name="bwart" size="3" style="width:35%" type="text"  id="bwart" value="311"></td>
				</tr>
					<tr>
					<td align="center" colspan="2">
							<input type="submit" style="width:40px;" onclick="return validateForm()" value="过账"></input>
							<input type="button" style="width:40px;" value="返回" onclick="window.location.href='/dumpView.do';"></input>
							<input type="button" style="width:40px;" onclick="window.location.href='/main.do';" value="首页">
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