<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%> --%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.LiangxinUtil" %>
<%-- <%@ page import="com.thinkway.cms.business.domains.StorageM" %> --%>
<%
	int pageNo=LiangxinUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String lgnum=LiangxinUtil.null2String((String)request.getAttribute("lgnum"));
	String lgpla=LiangxinUtil.null2String((String)request.getAttribute("lgpla"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>仓位转移</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%-- <meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>"> --%>
<link href="/css/jiuhui_list.css" rel="stylesheet">
<script>
function lastPage(){
	var pageNo=<%=pageNo%>;
	var pageNum=<%=pageNum%>;
	if(pageNo==1)return;
	document.getElementById("page").value=pageNo-1;
	document.listForm.action="/storageMList.do";
	document.listForm.submit();
}
function nextPage(){
	var pageNo=<%=pageNo%>;
	var pageNum=<%=pageNum%>;
	if(pageNo==pageNum)return;
	document.getElementById("page").value=pageNo+1;
	document.listForm.action="/storageMList.do";
	document.listForm.submit();
}
</script>
</HEAD>
<BODY>
<div class="div">
	<form action="/storageMAdd.do" id="listForm" name="listform" method="post">
	<input type="hidden" name="page" id="page" value="<%=pageNo %>"/>
	<input type="hidden" name="lgpla" id="lgpla" value="<%=lgpla %>"/>
	<input type="hidden" name="lgnum" id="lgnum" value="<%=lgnum %>"/>
		<%
		List<StorageM> list=(List)request.getAttribute("repList");
		if(list==null){
					
		%>
			<table style="width:100%;">
				<tr>
					<td>没有数据！</td>
				</tr>
				<tr>
				<td align="center">
					<input   type="button" style="width:40px;" value="返回" onclick="window.location.href='MainServlet?flag=3.1';"/>
					<input   type="button" style="width:40px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
				</td>
			</tr>
			</table>
		<%return;} %>
		<%
		if(list.size()==0){
					
		%>
			<table style="width:100%;">
				<tr>
					<td>没有数据！</td>
				</tr>
				<tr>
				<td align="center">
					<input   type="button" style="width:40px;" value="返回" onclick="window.location.href='MainServlet?flag=3.1';"/>
					<input   type="button" style="width:40px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
				</td>
			</tr>
			</table>
		<%	return;} %>
		<table class="table_list" style="width:100%">
		<tr class="tr_list_1" bordercolor="#000000" >
			<td class="td_list">序号</td>
			<td class="td_list">物料编码</td>
			<td class="td_list">特殊库存</td>
		</tr>
		<tr class="tr_list_1" bordercolor="#000000" >
			<td class="td_list">选择</td>
			<td class="td_list" colspan=2>物料描述</td>
		</tr>
		<tr class="tr_list_1" bordercolor="#000000" >
			<td class="td_list">批次</td>
			<td class="td_list">数量</td>
			<td class="td_list">单位</td>
		</tr>
		<%
		int i=1;
		for(i=1;i<=list.size();i++){
			StorageM pic=(StorageM)list.get(i-1);
		%>
		<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %> bordercolor="#000000" >
			<td class="td_list"><%=pic.getXuhao() %></td>
			<td class="td_list"><%=LiangxinUtil.null2String(pic.getMatnr()) %></td>
			<td class="td_list"><%=LiangxinUtil.null2String(pic.getSonum()) %></td>
			
			
		</tr>
		<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %> bordercolor="#000000" >
			<td class="td_list">
			<input name="check" checked=checked type="radio" value="<%=LiangxinUtil.null2String(pic.getMatnr()) %>,<%=LiangxinUtil.null2String(pic.getSobkz()) %>,<%=LiangxinUtil.null2String(pic.getCharg()) %>,<%=LiangxinUtil.null2String(pic.getGesme()) %>,<%=LiangxinUtil.null2String(pic.getLetyp()) %>,<%=lgpla%>,<%=lgnum%>,<%=LiangxinUtil.null2String(pic.getLgort()) %>,<%=LiangxinUtil.null2String(pic.getWerks()) %>,<%=LiangxinUtil.null2String(pic.getSonum()) %>,<%=LiangxinUtil.null2String(pic.getMeins()) %>" /></td>
			<td class="td_list" colspan=2><%=LiangxinUtil.null2String(pic.getMaktx()) %></td>
			
		</tr>
		<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %> bordercolor="#000000" >
			<td class="td_list"><%=LiangxinUtil.null2String(pic.getCharg()) %></td>
			<td class="td_list"><%=LiangxinUtil.null2String(pic.getGesme()) %></td>
			<td class="td_list"><%=LiangxinUtil.null2String(pic.getMeins()) %></td>
		</tr>
		
		<%} %>
		     <tr>
			<td align="center"><input  type="button" class="button" style="width:45px;" value="上一页" onclick="lastPage();"/></td>
			<td align="center">
			<input value="确定" class="button" style="width:30px;" type="submit"/>
			<input   type="button" class="button" style="width:30px;" value="返回" onclick="window.location.href='MainServlet?flag=3.1';"/>
			<input   type="button" class="button" style="width:30px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
			</td>
			<td align="center"><input  type="button" class="button" style="width:45px;"  value="下一页" onclick="nextPage();"/></td>
		</tr>

		</table>
	</form>
</div>
</BODY>

</HTML>