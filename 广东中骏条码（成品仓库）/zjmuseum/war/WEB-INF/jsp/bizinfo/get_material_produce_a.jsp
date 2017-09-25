<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.thinkway.SapUtil"%>
<%@ page import="com.thinkway.cms.business.domains.GetMaterial"%>
<%
	int pageNo=SapUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String werks=(String)request.getAttribute("werks");
	String budat=(String)request.getAttribute("budat");
	String lgort=(String)request.getAttribute("lgort");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" /> -->
<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
<script src="/js/jquery.js"></script>
<style>
.tr_list_1 {
	background-color: #CDCED2;
	font-family: "微软雅黑";
	font-size: 10px;
	border: none;
	height: 30px;
}

.tr_list_2 {
	background-color: #E7E8EA;
	font-family: "微软雅黑";
	font-size: 10px;
	border: none;
	height: 30px;
}
</style>
<script>
	function forward() {
		window.location.href = "/getMaterialA.do";
	}
	function confirm() {
		var temp = document.getElementsByName("materialGettenId");
		for ( var i = 0; i < temp.length; i++) {
			if (temp[i].checked) {
			$("#page").val(1);
				document.form.submit();
				return;
			}
		}
		alert("请选择一项");

	}

	function lastPage() {
		var pageNo =<%=pageNo%>;
		var pageNum =<%=pageNum%>;
		if (pageNo == 1)
			return;
		document.getElementById("page").value = pageNo - 1;
		document.form.action = "/getMaterialA.do";
		document.form.submit();
	}
	function nextPage() {
		var pageNo =<%=pageNo%>;
		var pageNum =<%=pageNum%>;
		if (pageNo == pageNum)
			return;
		document.getElementById("page").value = pageNo + 1;
		document.form.action = "/getMaterialA.do";
		document.form.submit();
	}
</script>
</HEAD>
<BODY>
	<div class="div">
		<form name="form" action="/getMaterialB.do">
			<input type="hidden" id="page" name="page" value="<%=pageNo%>" /> <input
				type="hidden" name="werks" value="<%=werks%>"> <input
				type="hidden" name="budat" value="<%=budat%>"> <input
				type="hidden" name="lgort" value="<%=lgort%>">
			<%
				List<GetMaterial> list = (List) request.getAttribute("getMaterialList");
					if (list == null) {
			%>
			<table style="width:100%;">
				<tr>
					<td>没有数据！</td>
				</tr>
				<tr>
					<td align="center"><input type="button" class="button"
						style="width:40px;" value="返回" onclick="window.location.href='/delivery.do';"></input> <input
						type="button" class="button" style="width:40px;"
						onclick="window.location.href='/main.do';" value="首页">
					</td>
				</tr>
			</table>
			<%
				return;
					}
			%>
			<%
				if (list.size() == 0) {
			%>
			<table style="width:100%;">
				<tr>
					<td>没有数据！</td>
				</tr>
				<tr>
					<td align="center">
						<input type="button" class="button" style="width:40px;" value="返回" onclick="window.location.href='/delivery.do';"/> 
						<input type="button" class="button" style="width:40px;" onclick="window.location.href='/main.do';" value="首页" />
					</td>
				</tr>
			</table>
			<%
				return;
					}
			%>
			<table class="table_list"
				style="width:100%;margin-top:40px;margin-left:20px">
				<tr class="tr_list_1" bordercolor="#000000">
					<td class="td_list"></td>
					<td class="td_list">序号</td>
					<td class="td_list">生产领料单</td>
				</tr>
				<%
					int i = 1;
					for (i = 1; i <= list.size(); i++) {
						GetMaterial pic = (GetMaterial) list.get(i - 1);
				%>
				<tr <%if (i % 2 == 1) {%> class="tr_list_2" <%} else {%> class="tr_list_1" <%}%>>
					<td class="td_list">
						<input type="radio" name="materialGettenId" value=<%=SapUtil.null2String(pic.getMaterialId())%> />
					</td>
					<td class="td_list"><%=pic.getNum()%></td>
					<td class="td_list"><%=SapUtil.null2String(pic.getMaterialId())%>
					</td>
				</tr>

				<%
					}
				%>
			</table>
			<table style="width:100%;">
				<tr>
					<td align="center">
						<input type="button" class="button" style="width:40px;" value="确认" onclick="confirm()"/>
					</td>
					<td align="center">
						<input type="button" class="button" style="width:40px;" value="返回" onclick="window.location.href='/delivery.do';"/>
					</td>
					<td align="center">
						<input type="button" class="button" style="width:40px;" value="<<" onclick=" lastPage();" />
					</td>
					<td align="center">
						<input type="button" class="button" style="width:40px;" value=">>" onclick="nextPage();" />
					</td>
				</tr>

			</table>
		</form>
	</div>
</BODY>
<script>
	$(document).on('click', '.tr_list_1, .tr_list_2', function() {
		$(this).find("input[type='radio']").prop("checked", true);
	});
</script>
</HTML>