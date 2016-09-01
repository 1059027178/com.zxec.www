<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.thinkway.SapUtil"%>
<%@ page import="com.thinkway.cms.business.domains.MaterialDetail"%>
<%
	int pageNo=SapUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String werks=(String)request.getAttribute("werks");
	String budat=(String)request.getAttribute("budat");
	String lgort=(String)request.getAttribute("lgort");
	String materialGettenId = (String) request
	.getAttribute("materialGettenId");
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
<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
	<script src="/js/jquery.js"></script>
<script>
// 点击radio所在行，即可点中该行的radio
 $(document).on('click', '.tr_list_1, .tr_list_2', function() {
 $(this).find("input[type='radio']").prop("checked", true);
  $(this).prev().find("input[type='radio']").prop("checked", true);
 });
//过账
	function posting() {
		document.form.action = "/getMaterialE.do";
		document.form.submit();
	}
	//跳页
	function EnterPress(e) {
		var e = e || window.event;
		if (e.keyCode == 13) {
		var pageNum =
<%=pageNum%>
	;
		var pageNo=document.getElementById("jumpTable").value;
			if ((/(^[1-9]\d*$)/.test(pageNo))&&pageNo>0&&pageNo<pageNum+1) {
				document.getElementById("page").value = pageNo;
		document.form.action = "/getMaterialB.do";
		document.form.submit();
			} 
			document.getElementById("jumpTable").value="";
		}
	}
	
	//下架
	function confirm() {
		var temp = document.getElementsByName("param");

		for ( var i = 0; i < temp.length; i++) {
			if (temp[i].checked) {
				var per = document.getElementById("per" + (i + 1));
				var pick = document.getElementById("pick" + (i + 1));
				document.getElementById("requireTotal").value = (per.innerText - pick.innerText);
				document.form.action = "/getMaterialC.do";
				document.form.submit();
				return;
			}
		}
		alert("请选择一项");
	}

	function lastPage() {
		var pageNo =
<%=pageNo%>
	;
		var pageNum =
<%=pageNum%>
	;
		if (pageNo == 1)
			return;
		document.getElementById("page").value = pageNo - 1;
		document.form.action = "/getMaterialB.do";
		document.form.submit();
	}
	function nextPage() {
		var pageNo =
<%=pageNo%>
	;
		var pageNum =
<%=pageNum%>
	;
		if (pageNo == pageNum)
			return;
		document.getElementById("page").value = pageNo + 1;
		document.form.action = "/getMaterialB.do";
		document.form.submit();
	}
</script>
</HEAD>
<BODY>
	<div class="div">
		<form id="form" name="form" method="post" onsubmit="return false;">
			<input type="hidden" id="page" name="page" value="<%=pageNo%>" /> <input
				type="hidden" name="werks" value="<%=werks%>"> <input
				type="hidden" name="budat" value="<%=budat%>"> <input
				type="hidden" name="lgort" value="<%=lgort%>"><input
				type="hidden" id="requireTotal" name="requireTotal" /> <input
				type="hidden" name="materialGettenId" value="<%=materialGettenId%>" />
			<%
				List<MaterialDetail> list = (List) request.getAttribute("materialDetailList");
				if (list == null) {
			%>
			<table style="width:100%;">
				<tr>
					<td>没有数据！</td>
				</tr>
				<tr>
					<td align="center"><input type="button" class="button"
						style="width:40px;" value="返回" onclick="fanhui()"></input> <input
						type="button" class="button" style="width:40px;"
						onclick="window.location.href='/main.do';" value="首页"></td>
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
					<td align="center"><input type="button" class="button"
						style="width:40px;" value="返回" onclick="fanhui()"></input> <input
						type="button" class="button" style="width:40px;"
						onclick="window.location.href='/main.do';" value="首页"></td>
				</tr>
			</table>
			<%
				return;
				}
			%>
			<table class="table_list"
				style="width:100%;margin-top:40px;margin-left:20px">
				<tr class="tr_list_1" bordercolor="#000000">
					<td class="td_list">序号</td>
					<td class="td_list">物料</td>
					<td class="td_list">单位</td>
					<td class="td_list">批次</td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000">
					<td class="td_list"></td>
					<td class="td_list">数量</td>
					<td class="td_list"></td>
					<td class="td_list">已拣配数量</td>
				</tr>
				<%
					int i = 1;
					for (i = 1; i <= list.size(); i++) {
						MaterialDetail pic = (MaterialDetail) list.get(i - 1);
				%>
				<tr <%if (i % 2 == 1) {%> class="tr_list_2" <%} else {%>
					class="tr_list_1" <%}%>>
					<td class="td_list"><input type="radio" name="param"
						value="<%=pic.getMaterialId()%>@<%=pic.getBatch()%>@<%=pic.getMaterialGettenId()%>@<%=pic.getLineItem()%>" /><%=pic.getNum()%></td>
					<td class="td_list"><%=pic.getMaterialId()%></td>
					<td class="td_list"><%=pic.getUnit()%></td>
					<td class="td_list"><%=pic.getBatch()%></td>
				</tr>
				<tr <%if (i % 2 == 1) {%> class="tr_list_2" <%} else {%>
					class="tr_list_1" <%}%>>
					<td class="td_list"></td>
					<td class="td_list" id="per<%=i%>"><%=pic.getPerAmount()%></td>
					<td class="td_list"></td>
					<td class="td_list" id="pick<%=i%>"><%=pic.getPickingAmount()%></td>
				</tr>

				<%
					}
				%>
			</table>
			<table class="table_list" style="width:100%">
				<tr>
					<td align="center"><input type="button" class="button"
						style="width:40px;" value="过账" onclick="posting()"></input>
						<td align="center"><input type="button" class="button"
							style="width:40px;" value="下架" onclick="confirm()"></input>
							<td align="center"><input type="button" class="button"
								style="width:40px;" value="返回"
								onclick="window.location.href='/delivery.do?functionType=1';"></input>
								<td align="center"><input type="button" class="button"
									style="width:40px;" value="<<" onclick=" lastPage();" /></td>
								<td align="center"><input type="button" class="button"
									style="width:40px;" value=">>" onclick="nextPage();" /></td>
								<td><input type="text" valign="center"
									style="width:30px;height:20px;" id="jumpTable"
									onkeypress="EnterPress(event)" /></td>
				</tr>

			</table>
		</form>
	</div>
</BODY>

</HTML>