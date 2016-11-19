<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.LiangxinUtil" %>
<%@ page import="com.thinkway.cms.business.domains.Lgp" %>
<%
	int pageNo=LiangxinUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String lgpla=LiangxinUtil.null2String((String)request.getAttribute("lgpla"));
	String lgnum=LiangxinUtil.null2String((String)request.getAttribute("lgnum"));
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<!-- Le styles -->

<link type="text/css" href="/css/jiuhui_list.css" rel="stylesheet" />
<script>
	function lastPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==1)return;
  		document.getElementById("page").value=pageNo-1;
  		document.listForm.action="/lgpquyList.do";
  		document.listForm.submit();
  	}
  	function nextPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==pageNum)return;
  		document.getElementById("page").value=pageNo+1;
  		document.listForm.action="/lgpquyList.do";
  		document.listForm.submit();
  	}
</script>
</HEAD>
<BODY>
	<form  id="listForm" name="listform" method="post">
	<input type="hidden" id="lgpla" name="lgpla" value="<%=lgpla %>"/>
	<input type="hidden" id="lgnum" name="lgnum" value="<%=lgnum %>"/>
	<input type="hidden" id="page" name="page" value="<%=pageNo %>"/>
		<div class="div">
			<%
					List<Lgp> list=(List)request.getAttribute("lgpList");
					if(list==null){
			%>

				<table style="width:100%;">
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
							<td align="center" >
								<input type="button" style="width:50px;heigth=20%" value="返回" onclick="window.location.href='/lgpquyQuery.do';"></input>
								<input  class=button type="button" style="width:50px;heigth=20%"  onclick="window.location.href='/main.do';" value="首页">
						</td>
					</tr>
				</table>
			<%	return;} %>
			<%if(list.size()==0){%>
				<table style="width:100%;">
					<colgroup>
						<col width="50%"/>
						<col width="50%"/>
					</colgroup>
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
						<td align="center" >
							<input type="button" style="width:50px;heigth=20%" value="返回" onclick="window.location.href='/lgpquyQuery.do';"></input>
							<input  class=button type="button" style="width:40px;heigth=20%"  onclick="window.location.href='/main.do';" value="首页">
						</td>
					</tr>
				</table>
			<%	return;} %>
			<table class="table_list" style="width:100%">
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">物料编码</td>
					<td class="td_list" colspan="2">描述</td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">批次</td>
					<td class="td_list">特殊标识</td>
					<td class="td_list">特殊库存编码</td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">可用库存</td>
					<td class="td_list">单位</td>
					<td class="td_list">仓位</td>
				</tr>
			<%
				int i=1;
				for(i=1;i<=list.size();i++){
					Lgp lgp=(Lgp)list.get(i-1);
			%>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list"><%=lgp.getMatnr() %></td>
					<td class="td_list" colspan="2"><%=lgp.getMaktx() %></td>
				</tr>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list"><%=lgp.getCharg() %></td>
					<td class="td_list"><%=lgp.getSobkz() %></td>
					<td class="td_list"><%=lgp.getSonum() %></td>
				</tr>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list"><%=lgp.getVerme() %></td>
					<td class="td_list"><%=lgp.getMeins() %></td>
					<td class="td_list"><%=lgp.getLgpla() %></td>
				</tr>
			<%} %>
			<tr >
				<td colspan="3" align="center">		
						<input  type="button" style="width:50px;" value="上一页" onclick="lastPage();"/>
						<input  type="button" style="width:40px;" value="返回" onclick="window.location.href='/lgpquyQuery.do';"></input>
						<input  class=button type="button" style="width:40px;"  onclick="window.location.href='/main.do';" value="首页">
						<input  type="button" style="width:50px;" value="下一页" onclick="nextPage();"/>
				</td>
			</tr>
			</table>
		</div>
			
			</form>

</BODY>

</HTML>