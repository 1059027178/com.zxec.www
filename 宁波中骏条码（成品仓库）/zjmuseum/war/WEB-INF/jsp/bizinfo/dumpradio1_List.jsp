<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.SapUtil" %>
<%@ page import="com.thinkway.cms.business.domains.Dump" %>
<%
	int pageNo=SapUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
			String matnr = SapUtil.null2String((String)request.getAttribute("matnr"));//物料编码
			String charg = SapUtil.null2String((String)request.getAttribute("charg"));//批次号
			String sobkz = SapUtil.null2String((String)request.getAttribute("sobkz"));//特殊库存标识
			String lgort = SapUtil.null2String((String)request.getAttribute("lgort"));//库存地点
			String sonum = SapUtil.null2String((String)request.getAttribute("sonum"));
			String radio = SapUtil.null2String((String)request.getAttribute("radio"));
			String lgnum = SapUtil.null2String((String)request.getAttribute("lgnum"));//仓库号/混合仓库
			String lgpla = SapUtil.null2String((String)request.getAttribute("lgpla"));//仓位
			String maktx = SapUtil.null2String((String)request.getAttribute("maktx"));
			String werks = SapUtil.null2String((String)request.getAttribute("werks"));
			String meins = SapUtil.null2String((String)request.getAttribute("meins"));
		 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
  <script  type="text/javascript">
  	function fanhui(){
  		document.thinkway.action="/delordView.do";
  		document.thinkway.submit();
  	}
  	function validateForm(){
  		 var xuhao=document.getElementById("maxxuhao").value;
  		 var sfyz=false;
  			 var leiji=0;
  		 for(var i=1;i<=xuhao;i++){
  		 	
  		 	//if(i=='1'){
  		 	//	break;
  		 	//}
  		 	var sl1=parseFloat(document.getElementById(i).value);
  		 	var sl2=parseFloat(document.getElementById('verme_'+i).value);
	  		if(document.getElementById(i).value==null || document.getElementById(i).value=='')sl1=0;
	  		if(document.getElementById('verme_'+i).value==null || document.getElementById('verme_'+i).value=='')sl2=0;
	 
  		 	if(sl1>sl2){
  		 		alert("第"+i+"行，下架数量大于仓位数量，请重新选择数值！");
  		 		return false;
  		 	}
  		 	leiji+=sl1;
  		 	if(document.getElementById(i).value!=''){
  		 		sfyz=true;
  		 		//break;
  		 	}
  		 	
  		 }
  
  		 if(!sfyz){
  		 	alert("请填写下架数量");
  		 	return false;
  		 }else{
  		 	return true;
  		 }
  	}
  	function lastPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==1)return;
  		document.getElementById("page").value=pageNo-1;
  		document.thinkway.action="/dumpCheck.do";
  		document.thinkway.submit();
  	}
  	function nextPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==pageNum)return;
  		document.getElementById("page").value=pageNo+1;
  		document.thinkway.action="/dumpCheck.do";
  		document.thinkway.submit();
  	}
  </script>
<link type="text/css" href="/css/jiuhui_list.css" rel="stylesheet" />

</HEAD>
<BODY>
<div class="div">
	<form  id="thinkway" name="thinkway" method="post"  action="/dumpAdd.do">
				 <input type="hidden" name="pageNo" style="width:70%"  id="pageNo" value="<%=pageNo%>"/>
				<input type="hidden" name="pageNum" style="width:70%"  id="pageNum" value="<%=pageNum%>"/>
				<input type="hidden" name="matnr" style="width:70%"  id="matnr" value="<%=matnr%>"/>
				 <input type="hidden" name="maktx" style="width:70%"  id="maktx" value="<%=maktx%>"/>
				<input type="hidden" name="matnr" style="width:70%"  id="matnr" value="<%=matnr%>"/>
				<input type="hidden" name="charg" style="width:70%"  id="charg" value="<%=charg%>"/>
				<input type="hidden" name="sonum" style="width:70%"  id="sonum" value="<%=sonum%>"/>
				<input type="hidden" name="sobkz" style="width:70%"  id="sobkz" value="<%=sobkz%>"/>
				<input type="hidden" name="lgort" style="width:70%"  id="lgort" value="<%=lgort%>"/>
				<input type="hidden" name="sonum" style="width:70%"  id="sonum" value="<%=sonum%>"/>
				<input type="hidden" name="werks" style="width:70%"  id="werks" value="<%=werks%>"/>
				<input type="hidden" name="meins" style="width:70%"  id="meins" value="<%=meins%>"/>
				<input type="hidden" name="lgnum" style="width:70%"  id="lgnum" value="<%=lgnum%>"/>
				<input type="hidden" name="lgpla" style="width:70%"  id="lgpla" value="<%=lgpla%>"/>
				<input type="hidden" name="page" style="width:70%"  id="page" value="<%=pageNum%>"/>
				<input type="hidden" name="radio" id="radio" value="1">
		
				
						<%
					List<Dump> list=(List)request.getAttribute("repList");
					if(list==null){
			%>

				<table style="width:100%;">
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
							<td align="center" >
							<input type="button" style="width:40px;heigth=25px" value="返回" onclick="window.location.href='/dumpView.do';"></input>
							<input type="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
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
							<input type="button" style="width:40px;heigth:25px;" value="返回" onclick="window.location.href='/dumpView.do';"></input>
							<input type="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
						</td>
					</tr>
				</table>
			<%	return;} %>
			<table class="table_list" style="width:100%">
			<colgroup>
						<col width="25%"/>
						<col />
						<col width="25%"/>
					</colgroup>
				<tr class="tr_list_2" bordercolor="#000000" >
						<td class="td_list" >物料编码</td>
						<td  class="td_list" colspan="2"><%=matnr%></td>
					</tr>
					<tr class="tr_list_2" bordercolor="#000000" >
						<td class="td_list" >物料描述</td>
						<td  class="td_list" colspan="2"><%=maktx%></td>
					</tr>
					<tr class="tr_list_2" bordercolor="#000000" >
						<td  class="td_list" >特殊库存</td>
						<td  class="td_list" colspan="2"><%=sonum%>
							</td>
					</tr>
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list">序号</td>
					<td class="td_list" >仓位</td>
					<td class="td_list">批次</td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list">仓位数量</td>
					<td class="td_list" >下架数量</td>
					<td class="td_list">单位</td>
				</tr>
			
			<%
				int i=1;
				for(i=1;i<=list.size();i++){
					Dump lgp=(Dump)list.get(i-1);
			%>
				<input type="hidden" name="vltyp<%=i %>" id="vltyp<%=i %>" value="<%=lgp.getLgtyp() %>">
				
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list"><%=lgp.getXuhao() %></td>
					<td class="td_list" ><%=lgp.getLgpla() %>
						<input type="hidden" name="vlpla<%=i %>" id="vlpla<%=i %>" value="<%=lgp.getLgpla() %>">
					</td>
					<td class="td_list"><%=lgp.getCharg() %></td>
				</tr>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list"><%=lgp.getVerme() %>
						<input type="hidden" name="verme_<%=i %>" id="verme_<%=i %>" value="<%=lgp.getVerme() %>">
				</td>
					<td class="td_list" >
						<input name="<%=i %>" style="width:70%"  id="<%=i %>" value="" />
					</td>
					<td class="td_list"><%=lgp.getMeins() %>
							 <input type="hidden" name="meins<%=i %>" style="width:70%"  id="meins<%=i %>" value="<%=lgp.getMeins() %>" />
			</td>
				</tr>
	
			<%} %>
			<tr ><input type ="hidden" name="maxxuhao" id="maxxuhao" value="<%=i-1 %>"/>
				
				<td colspan="3">
					<input  type="button" class="button" style="width:45px;" value="上一页" onclick="lastPage();"/>
					<input type="submit" style="width:30px;" onclick="return validateForm()" value="保存"></input>
					<input type="button" style="width:30px;" value="返回" onclick="window.location.href='/dumpView.do';"></input>
					<input type="button" class="button" style="width:30px;" onclick="window.location.href='/main.do';" value="首页">
					<input  type="button" class="button" style="width:45px;"  value="下一页" onclick="nextPage();"/>
				</td>
			</tr>
			</table>
			</form>
	</div>
</BODY>

</HTML>