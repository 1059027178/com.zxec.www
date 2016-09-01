<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.SapUtil" %>
<%@ page import="com.thinkway.cms.business.domains.Lubu" %>
<%
	int pageNo    =SapUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum   =(Integer)request.getAttribute("pageNum");
	String lgnum  =SapUtil.null2String((String)request.getAttribute("lgnum"));
	String message  =SapUtil.null2String((String)request.getAttribute("message"));
	
	String mblnr  =SapUtil.null2String((String)request.getAttribute("mblnr"));//物料凭证号
	String ubnum  =SapUtil.null2String((String)request.getAttribute("ubnum"));//过账更改编号（记账变更号）
	
	String matnr_B=SapUtil.null2String((String)request.getAttribute("matnr_B"));//起始编号
	String matnr_F=SapUtil.null2String((String)request.getAttribute("matnr_F"));//目标编号
	String wemng  =SapUtil.null2String((String)request.getAttribute("wemng"));//数量
	String meins  =SapUtil.null2String((String)request.getAttribute("meins"));//单位
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<link href="/css/jiuhui_list.css" rel="stylesheet">

<script>
	
function forward(){
  	window.location.href="/main.do?two=4";
  }		
function turnon(){
  	window.location.href="/lubuView.do";
  }		
function lastPage(){
	var pageNo=<%=pageNo%>;
	var pageNum=<%=pageNum%>;
	if(pageNo==1)return;
	document.getElementById("page").value=pageNo-1;
	document.listForm.action="/lubuList.do";
	document.listForm.submit();
}
function nextPage(){
	var pageNo=<%=pageNo%>;
	var pageNum=<%=pageNum%>;
	if(pageNo==pageNum)return;
	document.getElementById("page").value=pageNo+1;
	document.listForm.action="/lubuList.do";
	document.listForm.submit();
}
function getRow(obj){
	$("#row").attr("value",obj);
}
</script>
</HEAD>
<BODY>
<div class="div">
	<form action="/lubuEdit.do" id="listForm" name="listform" method="get">
	<input type="hidden" id="mblnr" name="mblnr" value="<%=mblnr %>"/>
	<input type="hidden" id="lgnum" name="lgnum" value="<%=lgnum %>"/>
	<input type="hidden" id="ubnum" name="ubnum" value="<%=ubnum %>"/>
	<input type="hidden" id="wemng" name="wemng" value="<%=wemng %>"/>
	<input type="hidden" id="page"  name="page"  value="<%=pageNo%>"/>
	<input type="hidden" id="row"   name="row" 	 value="1"/>
	<%
					List<Lubu> list=(List)request.getAttribute("repList");
					if(list==null){
				%>
				<table style="width:100%;">
					<tr>
						<td>返回消息：${type} ${message}</td>
					</tr>
					<tr>
					<td align="center">
						<input type="button" class="button" style="width:40px;height:25px;"  type="button" value="返回" onclick="forward()"/>
						<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
					</td>
				</tr>
				</table>
			<%	return;} %>
			<%
					if(list.size()==0){
				%>
				<table style="width:100%;">
					<tr>
						<td>返回消息：${type} ${message}</td>
					</tr>
					<tr>
					<td align="center">
						<input type="button" class="button" style="width:40px;height:25px;"  type="button" value="返回" onclick="forward()"/>
						<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
					</td>
				</tr>
				</table>
			<%	return;} %>
			<table class="table_list" style="width:100%;">
				<colgroup>
					<col width="30%"/>
					<col width="70%"/>
				</colgroup>
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list" style="padding-left: 10px;">记账变更号：</td>
					<td class="td_list" ><%=ubnum %></td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list" style="padding-left: 10px;">未清数量：</td>
					<td class="td_list" ><%=wemng + " "+ meins%></td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list" style="padding-left: 10px;">物料代码：</td>
					<td class="td_list" >从<input type="text" style="width:78px;background-color:#D8D8D8;" readonly="readonly" value="<%=matnr_B%>"/></td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list" ></td>
					<td class="td_list" >到<input type="text" style="width:78px;background-color:#D8D8D8;" readonly="readonly" value="<%=matnr_F%>"/></td>
				</tr>
			</table>
			<table class="table_list" style="width:100%">
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list" style="padding-left: 10px;">选择</td>
					<td class="td_list">存储类型</td>
					<td class="td_list">仓位</td>
					<td class="td_list">可用库存</td>
				</tr>
			<%
				int i=1;
				for(i=1;i<=list.size();i++){
					Lubu pic=(Lubu)list.get(i-1);
			%>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %> bordercolor="#000000" >
					<% if(i==1){ %>
					<td class="td_list" style="padding-left: 10px;">
						<input name="radio" onclick="getRow(<%=i %>);" style="width:20px;" checked=checked type="radio" id="radio1" value="<%=i %>"/>
					</td>
					<%}else{ %>
					<td class="td_list" style="padding-left: 10px;">
						<input name="radio" onclick="getRow(<%=i %>);" style="width:20px;" type="radio" id="radio<%=i %>" value="<%=i %>"/>
					</td>
					<%} %>
					<td class="td_list">
						<input type="hidden" name="<%="lqnum"+i %>" value="<%=SapUtil.null2String(pic.getLqnum()) %>"/>
						<input type="hidden" name="<%="lgtyp"+i %>" value="<%=SapUtil.null2String(pic.getlgtyp()) %>"/>
						<%=SapUtil.null2String(pic.getlgtyp()) %>
					</td>
					<td class="td_list">
						<input type="hidden" name="<%="lgpla"+i %>" value="<%=SapUtil.null2String(pic.getLgpla()) %>"/>
						<%=SapUtil.null2String(pic.getLgpla()) %>
					</td>
					<td class="td_list">
						<input type="hidden" name="<%="verme"+i %>" value="<%=SapUtil.null2String(pic.getVerme())%>"/>
						<%=SapUtil.null2String(pic.getVerme())+" "+meins %>
					</td>
				</tr>
			<%} %>
			<tr>
				<td align="center"  colspan=4>
				<input class="button" style="width:35px;" value="确定"  type="submit"/>
				<input  class="button" style="width:35px;"  type="button" value="返回" onclick="forward()"/>
				<input type="button" class="button" style="width:35px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
				<input  type="button" class="button" style="width:45px;" value="上一页" onclick="lastPage();"/>
				<input  type="button" class="button" style="width:45px;"  value="下一页" onclick="nextPage();"/></td>
			</tr>
			</table>
			</form>
</div>
</BODY>

</HTML>