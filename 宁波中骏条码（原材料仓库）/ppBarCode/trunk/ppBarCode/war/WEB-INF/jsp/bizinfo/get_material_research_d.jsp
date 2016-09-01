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
	String sum = (String) request.getAttribute("sum");
	String batch = (String) request.getAttribute("batch");
	String werks = (String) request.getAttribute("werks");
	String budat = (String) request.getAttribute("budat");
	String lgort = (String) request.getAttribute("lgort");
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
	function continues() {
		document.form.submit();
	}
	function lubuView() {
	document.form.action = "/lubuView.do";
		document.form.submit();
	}
</script>
<BODY>
	<div class="div">
		<form id="form" name="form" action="/getResearchB.do"
			onsubmit="return false;">
			<table class="table_list"
				style="width:80%;margin-top:40px;margin-left:20px">
				<input type="hidden" name="materialGettenId"
					value="<%=materialGettenId%>" />
					<input type="hidden" name="werks" value="<%=werks%>">
				<input type="hidden" name="budat" value="<%=budat%>">
				<input type="hidden" name="lgort" value="<%=lgort%>">
				<input type="hidden" name="matnr" value="<%=materialId%>" />
				<input type="hidden" name="num" value="<%=sum%>" />
				<input type="hidden" name="charg" value="<%=batch%>" />
				<tr>
					<td align="center"><label id="message">"<%=msg%></label>
					</td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>

			<table style="width:80%;margin-top:20px;margin-left:20px">
				<tr>
					<td align="center"><input type="button" class="button"
						style="width:40px;" value="继续" onclick="continues()" />
					</td>
					<td align="center"><input type="button" class="button"
						style="width:40px;" value="返回"
						onclick="window.location.href='/delivery.do?functionType=2';" />
					</td>
					<td align="center"><input type="button" class="button"
						style="width:80px;" value="记账变更" onclick="lubuView()" />
					</td>
				</tr>
			</table>
		</form>
	</div>
</BODY>

</HTML>