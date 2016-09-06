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
  		return true;
  	}
  </script>
</HEAD>
<BODY>
<div class="div">
	<form  id="thinkway" name="thinkway" method="post" action="/dumpAdd.do">
		 <input type="hidden" name="matnr" id="matnr" value="${matnr}">
		<input type="hidden" name="charg" id="charg" value="${charg}">
		<input type="hidden" name="charg" id="charg" value="${maktx}">
		<input type="hidden" name="sobkz" id="sobkz" value="${sobkz}">
		<input type="hidden" name="sonum" id="sonum" value="${sonum}">
		<input type="hidden" name="meins" id="meins" value="${meins}">
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
					<td  >${charg}</td>
				</tr>
				<tr>
					<td  >数量:</td>
					<td  ><input style="width:80%" name="menge" type="text"  id="menge" value="${xzsl}"></td>
				</tr>
				<tr>
					<td >库存地点:</td>
					<td  ><input name="lgort_from" type="text" style="width:25%"  id="lgort_from" value="">到<input name="lgort_to" type="text" style="width:25%"  id="lgort_to" value=""></td>	</tr>
				<tr>
					<td >特殊库存:</td>
					<td  >${sobkz}${sonum}</td>
				</tr>
				<tr>
					<td >移动类型:</td>
					<td  ><input name="bwart" size="3" style="width:35%" type="text"  id="bwart"></td>
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

</HTML>