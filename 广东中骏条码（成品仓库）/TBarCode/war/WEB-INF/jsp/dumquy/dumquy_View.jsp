<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.LiangxinUtil" %>
<%@ page import="com.thinkway.cms.business.domains.Dum" %>
<%
	int pageNo=LiangxinUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String tanum=LiangxinUtil.null2String((String)request.getAttribute("tanum"));
	String lgnum=LiangxinUtil.null2String((String)request.getAttribute("lgnum"));
	
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
	function lastPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==1)return;
  		document.getElementById("page").value=pageNo-1;
  		document.listForm.action="/dumquyView.do";
  		document.listForm.submit();
  	}
  	function nextPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==pageNum)return;
  		document.getElementById("page").value=pageNo+1;
  		document.listForm.action="/dumquyView.do";
  		document.listForm.submit();
  	}
</script>
</HEAD>
<BODY>
  <div class="div">
	<form  id="listForm" name="listform" method="post">
	<input type="hidden" id="tanum" name="tanum" value="<%=tanum %>"/>
	<input type="hidden" id="lgnum" name="lgnum" value="<%=lgnum %>"/>
	<input type="hidden" id="page" name="page" value="<%=pageNo %>"/>
	<%
					List<Dum> list=(List)request.getAttribute("dumList");
					if(list==null){
			%>

				<table style="width:100%;">
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
							<td align="center" >
							<input type="button" style="width:50px;heigth=20%" value="返回" onclick="window.location.href='/dumquyQuery.do';"></input>
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
							<input type="button" style="width:50px;heigth=20%" value="返回" onclick="window.location.href='/dumquyQuery.do';"></input>
							<input  class=button type="button" style="width:50px;heigth=20%"  onclick="window.location.href='/main.do';" value="首页">
						</td>
					</tr>
				</table>
			<%	return;} 
			Dum dum=(Dum)list.get(0);%>
			<div style=" padding-top: 20px;">
			<table class="table_list" style="width:100%">
				<tr bordercolor="#000000" class="tr_list_2">
					<td class="td_list">转储单</td>
					<td class="td_list"><%=dum.getTanum() %></td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">行项目</td>
					<td class="td_list"><%=dum.getPosnr() %></td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_2">
					<td class="td_list">物料</td>
					<td class="td_list"><%=dum.getMatnr() %></td>
						</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">批次</td>
					<td class="td_list"><%=dum.getCharg() %></td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_2">
					<td class="td_list">数量</td>
					<td class="td_list"><%=dum.getVsolm() %></td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">创建者</td>
					<td class="td_list" ><%=dum.getBname() %></td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_2">
					<td class="td_list">证书号</td>
					<td class="td_list"><%=dum.getZeugn() %></td>
			</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">源仓位</td>
					<td class="td_list"><%=dum.getVdifm() %></td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_2">
					<td class="td_list">目标仓位</td>
					<td class="td_list"><%=dum.getNplei() %></td>
				</tr>
				<tr>
					<td align="center" colspan="4">
							<input  type="button"class=button value="上一页" onclick="lastPage();"/>
							<input type="button"  class=button value="返回" onclick="window.location.href='/dumquyQuery.do';"/>
							<input  class=button type="button" onclick="window.location.href='/main.do';" value="首页">
							<input  type="button" class=button value="下一页" onclick="nextPage();"/>
					</td>
				</tr>
			</table>
			</div>
			</form>
</div>
</BODY>

</HTML>