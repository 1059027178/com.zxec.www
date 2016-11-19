<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.LiangxinUtil" %>
<%@ page import="com.thinkway.cms.business.domains.Sto" %>
<%
	int pageNo=LiangxinUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String werks=LiangxinUtil.null2String((String)request.getAttribute("werks")); 
	String lgort=LiangxinUtil.null2String((String)request.getAttribute("lgort"));
	String matnr=LiangxinUtil.null2String((String)request.getAttribute("matnr"));
	String charg=LiangxinUtil.null2String((String)request.getAttribute("charg")); 
	String pici=LiangxinUtil.null2String((String)request.getAttribute("pici")); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<!-- Le styles -->

<script>
	function lastPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==1)return;
  		document.getElementById("page").value=pageNo-1;
  		document.listForm.action="/stoquyList.do";
  		document.listForm.submit();
  	}
  	function nextPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==pageNum)return;
  		document.getElementById("page").value=pageNo+1;
  		document.listForm.action="/stoquyList.do";
  		document.listForm.submit();
  	}
</script>
<link href="/css/jiuhui_list.css" rel="stylesheet">
</HEAD>
<BODY>
<div class="div">
	<form  id="listForm" name="listform" method="post" action="/delordpicAdd.do">
			<input type="hidden" id="matnr" name="matnr" value="<%=matnr %>"/>
		<input type="hidden" id="lgort" name="lgort" value="<%=lgort %>"/>
		<input type="hidden" id="charg" name="charg" value="<%=charg %>"/>
		<input type="hidden" id="werks" name="werks" value="<%=werks %>"/>
		<input type="hidden" id="page" name="page" value="<%=pageNo %>"/>
		<input type="hidden" id="pici" name="pici" value="<%=pici %>"/>
			
				
				<%
					List<Sto> list=(List)request.getAttribute("stoList");
					if(list==null){
			%>

				<table style="width:100%;">
				<tr >
					<td class="td_list">物料编码:</td>
					<td  class="td_list">
						<input type="text" style="background-color:#D8D8D8;" name="matnr" style="width:70%"  id="matnr" readonly="true" value="${matnr}"/>
					</td>
				</tr>
				<tr>
					<td class="td_list">物料描述:</td>
					<td  class="td_list">
						<input type="text" style="background-color:#D8D8D8;" name="maktx" style="width:70%"  id="maktx" readonly="true" value="${maktx}"/>
					</td>
				</tr>
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
							<td align="center" >
							<input type="button" value="返回" onclick="window.location.href='/stoquyQuery.do';"></input>
							<input  class=button type="button" onclick="window.location.href='/main.do';" value="首页">
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
					<tr class="tr_list_1">
					<td class="td_list">物料编码:</td>
					<td  class="td_list">
						<input type="text" style="background-color:#D8D8D8;" name="matnr" style="width:70%"  id="matnr" readonly="true" value="${matnr}"/>
					</td>
				</tr>
				<tr class="tr_list_2">
					<td class="td_list">物料描述:</td>
					<td  class="td_list">
						<input type="text" style="background-color:#D8D8D8;" name="maktx" style="width:70%"  id="maktx" readonly="true" value="${maktx}"/>
					</td>
				</tr>
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
						<td align="center" >
							<input type="button" value="返回" onclick="window.location.href='/stoquyQuery.do';"></input>
							<input  class=button type="button" onclick="window.location.href='/main.do';" value="首页">
						</td>
					</tr>
				</table>
			<%	return;} %>
			<table class="table_list" style="width:100%">
					<colgroup>
						<col width="30%"/>
						<col width="40%"/>
						<col width="30%"/>
					</colgroup>
				<tr class="tr_list_1">
					<td class="td_list">物料编码:</td>
					<td  class="td_list" colspan="2">
						${matnr}
					</td>
				</tr>
				<tr class="tr_list_2">
					<td class="td_list">物料描述:</td>
					<td  class="td_list" colspan="2">
						${maktx}
					</td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">特殊标识</td>
					<td class="td_list">特殊库存</td>
					<td class="td_list">可用库存</td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">单位</td>
					<td class="td_list" colspan="2">批次</td>
					</tr>
				<tr bordercolor="#000000" >
				</tr>
			<%
				int i=1;
				for(i=1;i<=list.size();i++){
					Sto sto=(Sto)list.get(i-1);
			%>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list"><%=sto.getSobkz() %></td>
					<td class="td_list"><%=sto.getSonum() %></td>
					<td class="td_list"><%=sto.getLabst() %><%=sto.getVerme() %></td>
				</tr>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list"><%=sto.getMeins() %></td>
					<td class="td_list" colspan="2"><%=sto.getCharg() %></td>
					</tr>
				
			<%} %>
			<tr >
				<td align="center" colspan="3"><input class="button" type="button" style="width:50px;" value="上一页" onclick="lastPage();"/>
						<input class="button"  type="button" style="width:40px;" value="返回" onclick="window.location.href='/stoquyQuery.do';"></input>
						<input  class=button type="button" style="width:40px;" onclick="window.location.href='/main.do';" value="首页">
						<input class="button"  type="button" style="width:50px;" value="下一页" onclick="nextPage();"/></td>
					</tr>
			</table>
			</form>
</div>
</BODY>

</HTML>