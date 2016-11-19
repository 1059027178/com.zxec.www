<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.LiangxinUtil" %>
<%@ page import="com.thinkway.cms.business.domains.Repertory" %>
<%
	int pageNo=LiangxinUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
<script>
	function forward(){
  		window.location.href="/repertoryAdd.do";
  	}
  	function lastPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==1)return;
  		document.getElementById("page").value=pageNo-1;
  		document.listForm.action="/repertoryList.do";
  		document.listForm.submit();
  	}
  	function nextPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==pageNum)return;
  		document.getElementById("page").value=pageNo+1;
  		document.listForm.action="/repertoryList.do";
  		document.listForm.submit();
  	}
</script>
</HEAD>
<BODY>
<div class="div">
	<form  id="listForm" name="listform" method="post">
	<input type="hidden" id="page" name="page" value="<%=pageNo %>"/>
			<%
					List<Repertory> list=(List)request.getAttribute("repList");
					if(list==null){
					
				%>
				<table style="width:100%;">
					<tr>
						<td>没有数据！</td>
					</tr>
					<tr>
					<td align="center">
						<input  type="button" class="button" style="width:40px;" value="返回" onclick="fanhui()"></input>
						<input   type="button" class="button" style="width:40px;" onclick="window.location.href='/main.do';" value="首页">
					</td>
				</tr>
				</table>
			<%	return;} %>
			<%
					if(list.size()==0){
					
				%>
				<table style="width:100%;">
					<tr>
						<td>没有数据！</td>
					</tr>
					<tr>
					<td align="center">
						<input  type="button" class="button" style="width:40px;"  value="返回" onclick="fanhui()"></input>
						<input   type="button" class="button" style="width:40px;" onclick="window.location.href='/main.do';" value="首页">
					</td>
				</tr>
				</table>
			<%	return;} %>
			<table class="table_list" style="width:100%">
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list">仓库号</td>
					<td class="td_list">仓储类型</td>
					<td class="td_list">仓位</td>
				</tr>
			<%
				int i=1;
				for(i=1;i<=list.size();i++){
					Repertory pic=(Repertory)list.get(i-1);
			%>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list">
						<%=LiangxinUtil.null2String(pic.getLgnum()) %>
					</td>
					<td class="td_list">
						<%=LiangxinUtil.null2String(pic.getLgtyp()) %> 
					</td>
					<td class="td_list">
						
						<%=LiangxinUtil.null2String(pic.getNlpla()) %>
					</td>
				</tr>
				
			<%} %>
			<tr>
				<td align="center"><input  type="button" class="button" style="width:50px;" value="上一页" onclick="lastPage();"/></td>
				<td align="center"><input  type="button" class="button" style="width:40px;"  value="返回" onclick="forward()"></input>
				<input   type="button" class="button" style="width:40px;" onclick="window.location.href='/main.do';" value="首页"></td>
				<td align="center"><input  type="button" class="button" style="width:50px;"  value="下一页" onclick="nextPage();"/></td>
			</tr>
	
			</table>
		
		
	</form>
</div>
</BODY>

</HTML>