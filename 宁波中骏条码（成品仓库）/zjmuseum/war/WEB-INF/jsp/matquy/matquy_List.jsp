<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.SapUtil" %>
<%@ page import="com.thinkway.cms.business.domains.Mat" %>
<%
	int pageNo=SapUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String matnr=SapUtil.null2String((String)request.getAttribute("matnr"));
	String lgort=SapUtil.null2String((String)request.getAttribute("lgort"));
	String charg=SapUtil.null2String((String)request.getAttribute("charg")); 
	String werks=SapUtil.null2String((String)request.getAttribute("werks")); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">

<link href="/css/jiuhui_list.css" rel="stylesheet">
<script>
	function lastPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==1)return;
  		document.getElementById("page").value=pageNo-1;
  		document.listForm.action="/matquyList.do";
  		document.listForm.submit();
  	}
  	function nextPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==pageNum)return;
  		document.getElementById("page").value=pageNo+1;
  		document.listForm.action="/matquyList.do";
  		document.listForm.submit();
  	}
</script>
</HEAD>
<BODY>
<div class="div">
	<form  id="listForm" name="listform" method="post">
		<input type="hidden" id="matnr" name="matnr" value="<%=matnr %>"/>
		<input type="hidden" id="lgort" name="lgort" value="<%=lgort %>"/>
		<input type="hidden" id="charg" name="charg" value="<%=charg %>"/>
		<input type="hidden" id="werks" name="werks" value="<%=werks %>"/>
		<input type="hidden" id="page" name="page" value="<%=pageNo %>"/>
				<%
					List<Mat> list=(List)request.getAttribute("matList");
					if(list==null){
			%>

				<table style="width:100%;">
					<tr>
						<td class="td_list">物料编码:</td>
						<td  class="td_list">
							<input type="text" style="background-color:#D8D8D8;" name="matnr" style="width:150%"  id="matnr" readonly="true" value="<%=matnr %>"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
							<td align="center" >
							  <input type="button" value="返回" style="width:50px;heigth=20%" onclick="window.location.href='/matquyQuery.do';"></input>
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
						<td class="td_list">物料编码:</td>
						<td  class="td_list">
							<input type="text" style="background-color:#D8D8D8;" name="matnr" style="width:150%"  id="matnr" readonly="true" value="<%=matnr %>"/>
						</td>
					</tr>
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
						<td align="center" >
							<input type="button" value="返回" style="width:50px;heigth=20%"  onclick="window.location.href='/matquyQuery.do';"></input>
							<input  class=button type="button" style="width:50px;heigth=20%"  onclick="window.location.href='/main.do';" value="首页">
 			</td>
					</tr>
				</table>
			<%	return;} %>
			<table class="table_list" style="width:100%">
					<tr class="tr_list_1">
						<td class="td_list" colspan="2">物料编码:</td>
						<td  class="td_list" colspan="2">
							<%=matnr %>
						</td>
					</tr>
				<tr bordercolor="#000000"  class="tr_list_1">
					<td class="td_list">序号</td>
					<td class="td_list">批次</td>
					<td class="td_list">仓位</td>
					<td class="td_list">特殊标识</td>
				</tr>
				<tr bordercolor="#000000"  class="tr_list_1">
					<td class="td_list" colspan="2">库存地点</td>
					<td class="td_list">数量</td>
					<td class="td_list">单位</td>
				</tr>
				<tr bordercolor="#000000" >
				</tr>
			<%
				int i=1;
				for(i=1;i<=list.size();i++){
					Mat mat=(Mat)list.get(i-1);
			%>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list"><%=mat.getXuhao() %></td>
					<td class="td_list"><%=mat.getCharg() %></td>
					<td class="td_list"><%=mat.getLgpla() %></td>
					<td class="td_list"><%=mat.getSobkz() %></td>
				</tr>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list" colspan="2"><%=mat.getLgort() %></td>
					<td class="td_list"><%=mat.getVerme() %></td>
					<td class="td_list"><%=mat.getMeins() %></td>
				</tr>
				
			<%} %>
			<tr >
				<td colspan="4" align="center">
						<input  type="button" style="width:50px;" value="上一页" onclick="lastPage();"/>
						<input  type="button" style="width:40px;" value="返回" onclick="window.location.href='/matquyQuery.do';"></input>
						<input  class=button type="button"style="width:40px;" onclick="window.location.href='/main.do';" value="首页">
						<input  type="button" style="width:50px;" value="下一页" onclick="nextPage();"/>
				</td>
				</tr>
			</table>
			
			</form>
</div>
</BODY>

</HTML>