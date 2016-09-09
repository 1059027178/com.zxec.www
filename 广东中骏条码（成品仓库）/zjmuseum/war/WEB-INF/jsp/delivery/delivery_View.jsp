<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.SapUtil" %>
<%@ page import="com.thinkway.cms.business.domains.Delivery" %>
<%
	int pageNo=SapUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String vbeln=SapUtil.null2String((String)request.getAttribute("vbeln"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
  <script  type="text/javascript">
  	function guoz(){ 
  		document.listform.submit();
  	}
  	function lastPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==1)return;
  		document.getElementById("page").value=pageNo-1;
  		document.listForm.action="/deliveryView.do";
  		document.listForm.submit();
  	}
  	function nextPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==pageNum)return;
  		document.getElementById("page").value=pageNo+1;
  		document.listForm.action="/deliveryView.do";
  		document.listForm.submit();
  	}
  </script>

</HEAD>
<BODY>
	<form  id="listForm" name="listform" method="post" action="/deliveryCrt.do">
	<input type="hidden" id="vbeln" name="vbeln" value="${vbeln}"/>
	<input type="hidden" id="page" name="page" value="<%=pageNo %>"/>
	<div class="div">
		<%
					List<Delivery> list=(List)request.getAttribute("deliveryList");
					if(list==null){
					
				%>

				<table style="width:100%;">
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
						<td align="center" colspan=2>
							<input type="button" style="width:40px;"  align="center" value="返回" onclick="window.location.href='/deliveryAdd.do';"></input>
							<input  type="button" style="width:40px;"  onclick="window.location.href='/main.do';" value="首页">
						</td>
					</tr>
				</table>
			<%	return;} %>
			<%
					//List<DelOrdPic> list=(List)request.getAttribute("delordList");
					if(list.size()==0){
					
				%>
				<table style="width:100%;">
					<colgroup>
						<col width="50%"/>
						<col width="50%"/>
					</colgroup>
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
						<td align="center" colspan=2>
								<input type="button" style="width:40px;heigth=20%"  align="center" value="返回" onclick="window.location.href='/deliveryAdd.do';"></input>
								<input  type="button" style="width:40px;"  onclick="window.location.href='/main.do';" value="首页">
						</td>
					</tr>
				</table>
			<%	return;} %>
			<table class="table_list" style="width:100%">
			
			
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list">物料</td>
					<td class="td_list">数量</td>
					<td class="td_list">单位</td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list" colspan=3>物料描述</td>
				</tr>
			
			<%
				int i=1;
				for(i=1;i<=list.size();i++){
					Delivery pic=(Delivery)list.get(i-1);
			%>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %> bordercolor="#000000" >
					<td class="td_list"><%=pic.getMatnr() %></td>
					<td class="td_list"><%=pic.getLfimg() %></td>
					<td class="td_list"><%=pic.getVrmke() %></td>
				</tr>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %> bordercolor="#000000" >
					<td class="td_list" colspan=3><%=pic.getMaktx() %></td>
				</tr>
				
	
			<%} %>
			<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
				<td colspan=3>
					<input  type="button" style="width:50px;" value="上一页" onclick="lastPage();"/>
					<input type="button" style="width:30px;" class="button" align="center" value="过账" onclick="guoz();"></input>
					<input type="button" style="width:30px;"  align="center" class="button" value="返回" onclick="window.location.href='/deliveryAdd.do';"></input>
					<input  type="button" style="width:30px;"  onclick="window.location.href='/main.do';" value="首页">
					<input  type="button" style="width:50px;"  value="下一页" onclick="nextPage();"/></td>
			</tr>
			
			</table>
		
			</div>
			
			</form>

</BODY>

</HTML>