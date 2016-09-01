<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.thinkway.SapUtil"%>
<%
	String msg = (String) request.getAttribute("msg");
	
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
<BODY>
	<div class="div">
		<form id="form" name="form" action="/getResearchA.do">
			<table class="table_list" style="width:100%;margin-top:40px;margin-left:10px;margin-right:10px">
				<tr>
					<td align="center"><label id="message"><%=msg%></label></td>
				</tr>
				<tr>
					<td></td>
				</tr>
			</table>

			<table style="width:100%;margin-left:10px;margin-top:40px;margin-right:10px">
				<tr>
					<td align="center"><input type="button" class="button"
						style="width:40px;" value="返回"
						onclick="window.location.href='/delivery.do?functionType=3';"></input>
					</td>
				</tr>
			</table>
		</form>
	</div>
</BODY>
<script>
	function continues() {
		document.form.submit();
	}
</script>
</HTML>