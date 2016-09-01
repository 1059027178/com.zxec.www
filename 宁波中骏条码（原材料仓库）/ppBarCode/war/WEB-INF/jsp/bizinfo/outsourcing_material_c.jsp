<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.thinkway.SapUtil"%>
<%
	String materialGettenId = (String) request
			.getAttribute("materialGettenId");
	String msg = (String) request.getAttribute("msg");
	String materialId = (String) request.getAttribute("materialId");
	String materialDescription = (String) request
			.getAttribute("materialDescription");
	String sum = (String) request.getAttribute("sum");
	String batch = (String) request.getAttribute("batch");
	String supplier = (String) request.getAttribute("supplier");
	String storageLocation = (String) request.getAttribute("storageLocation");
	String lineItem = (String) request.getAttribute("lineItem");
	String purchaseOrder = (String) request.getAttribute("purchaseOrder");
	String factory = (String) request.getAttribute("factory");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<style type="text/css">
.selectAmount {
	width: 60px;
}
</style>

<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
</HEAD>
<script>
	function posting() {
		document.form.submit();
	}
</script>
<BODY>
	<div class="div">
		<form id="form" name="form" action="/outsourcingD.do"
			onsubmit="return false;">
			<input type="hidden" name="materialGettenId"
				value="<%=materialGettenId%>" /> <input type="hidden" name="matnr"
				value="<%=materialId%>" />  <input type="hidden" name="batch"
				value="<%=batch%>" />
				<input type="hidden" name="factory"
				value="<%=factory%>" />
			<table class="table_list"
				style="width:80%;margin-top:40px;margin-left:20px">
				<tr>
					<td align="center"><label id="message">"<%=msg%></label></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>
			<table class="table_list"
				style="width:80%;margin-left:20px">
				<tr>
					<td>物料编码：<label><%=materialId%></label></td>

				</tr>
				<tr>
					<td>物料描述：<label><%=materialDescription%></label>
					</td>
				</tr>
				<tr>
					<td>数量：&emsp;&emsp;<input type="text"
						id="sum" style="width:90px;" value="<%=sum%>" name="sum">
					</td>
				</tr>
				<tr>
					<td>供应商：&emsp;<input   type="text"
						id="supplier" style="width:90px;" name="supplier" value="<%=supplier%>" >
					</td>
				</tr>
				<tr>
					<td>po号：&emsp;&emsp;<input class="text" readonly=readonly type="text"
						id="purchaseOrder" name="purchaseOrder" style="width:80px;" value="<%=purchaseOrder%>"><input
							class="text" readonly=readonly type="text" id="lineItem"
							name="lineItem" style="width:20px;" value="<%=lineItem%>" >
					</td>
				</tr>
				<tr>
					<td>库存地点：<input  type="text"
						id="storageLocation" style="width:90px;" value="<%=storageLocation%>" name="storageLocation">
					</td>
				</tr>
				<tr>
					<td>移动类型：<input  type="text"
						id="moveType" style="width:90px;" name="moveType" value="541">
					</td>
				</tr>
			</table>
			<table style="width:80%;margin-left:20px;margin-right:20px">
				<tr>
					<td align="center"><input type="button" class="button"
						style="width:80px;" value="发货过账" onclick="posting()" /></td>
					<td align="center"><input type="button" class="button"
						style="width:40px;" value="返回"
						onclick="window.location.href='/delivery.do?functionType=3';" />
					</td>

				</tr>
			</table>
		</form>
	</div>
</BODY>

</HTML>