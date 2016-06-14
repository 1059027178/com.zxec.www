<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ page import="com.thinkway.cms.business.domains.User"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="com.thinkway.SapUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.cms.business.domains.DelOrdPic" %>
<%
	int pageNo=SapUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String werks=SapUtil.null2String((String)request.getAttribute("werks"));
	String lgort=SapUtil.null2String((String)request.getAttribute("lgort"));
	String wadat=SapUtil.null2String((String)request.getAttribute("wadat"));
	String vbeln=SapUtil.null2String((String)request.getAttribute("vbeln"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />

<link href="/css/jiuhui_list.css" rel="stylesheet">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<style>

	
</style>
<!-- Le styles -->

  <script  type="text/javascript">
  	function fanhui(){
  		document.getElementById("page").value="1";
  		document.listform.submit();
  	}
  	function lastPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==1)return;
  		document.getElementById("page").value=pageNo-1;
  		document.listform.action="/delordView.do";
  		document.listform.submit();
  	}
  	function nextPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==pageNum)return;
  		document.getElementById("page").value=pageNo+1;
  		document.listform.action="/delordView.do";
  		document.listform.submit();
  	}

  </script>


</HEAD>
<BODY>
<div class="div" style="padding-top:30px;">
	<form  id="listForm" action="delordList.do" name="listform" method="get">
	<input type="hidden" id="wadat" name="wadat" value="${wadat}"/>
	<input type="hidden" id="lgort" name="lgort" value="${lgort}"/>
	<input type="hidden" id="werks" name="werks" value="${werks}"/>
	<input type="hidden" id="vbeln" name="vbeln" value="${vbeln}"/>
	<input type="hidden" id="page" name="page" value="<%=pageNo %>"/>
		<%
					List<DelOrdPic> list=(List)request.getAttribute("delordList");
					if(list==null){
					
				%>
				<table style="width:100%;">
					<tr>
						<td>没有数据！</td>
					</tr>
					<tr>
					<td align="center">
							<input  type="button" style="width:40px;" value="返回" onclick="fanhui()"></input>
							<input  type="button" style="width:40px;"  onclick="window.location.href='/main.do';" value="首页">
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
							<input  type="button" style="width:40px;" value="返回" onclick="fanhui()"></input>
							<input  type="button" style="width:40px;"  onclick="window.location.href='/main.do';" value="首页">
					</td>
				</tr>
				</table>
			<%	return;} %>
			<table class=".table_list" style="width:100%">
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list" rowspan=2>序号</td>
					<td class="td_list" height="10px">物料号</td>
					<td class="td_list">批次</td>
				</tr>
				<tr class="tr_list_1">
					<td class="td_list">数量</td>
					<td class="td_list">已拣配数量</td>
				</tr>
			<%
				int i=1;
				for(i=1;i<=list.size();i++){
					DelOrdPic pic=(DelOrdPic)list.get(i-1);
			%>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list" rowspan=2>
						<%=SapUtil.null2String(pic.getXuhao()) %>
					</td>
					<td class="td_list">
					<%
						if(SapUtil.getDoubleValue(pic.getLfimg())>pic.getRfmng()){
					%>
					<a href="/matlgpfifoView.do?vbeln=<%=vbeln %>&wadat=<%=wadat %>&lgort=<%=lgort %>&werks=<%=werks %>&matnr=<%=SapUtil.null2String(pic.getMatnr()) %>&posnr=<%=SapUtil.null2String(pic.getPosnr()) %>&lfimg=<%=pic.getLfimg() %>&maktx=<%=SapUtil.null2String(pic.getMaktx()) %>" >
						<%=SapUtil.null2String(pic.getMatnr()) %>
					<%}else{ %>
						<%=SapUtil.null2String(pic.getMatnr()) %>
					<%} %>
						 
					</td>
					<td class="td_list">
						
						<%=SapUtil.null2String(pic.getCharg()) %>
					</td>
				</tr>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list">
						
						<%=SapUtil.null2String(pic.getLfimg()) %>
					</td>
					<td class="td_list">
						<%=pic.getRfmng() %>
					</td>
					
				</tr>
			<%} %>
			<tr>
				<td align="center" colspan="3">
				<input  type="button" style="width:50px;" value="上一页" onclick="lastPage();"/>
				<input  type="button" style="width:40px;" value="返回" onclick="fanhui()"></input>
				<input  type="button" style="width:40px;"  onclick="window.location.href='/main.do';" value="首页">
				<input  type="button" style="width:50px;" value="下一页" onclick="nextPage();"/></td>
			</tr>
	
			</table>
			
			</form>
</div>
</BODY>

</HTML>