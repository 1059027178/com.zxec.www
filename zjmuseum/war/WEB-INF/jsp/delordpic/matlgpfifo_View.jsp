<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.LiangxinUtil" %>
<%@ page import="com.thinkway.cms.business.domains.DelOrdPic" %>
<%
	int pageNo=LiangxinUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String vbeln=LiangxinUtil.null2String((String)request.getAttribute("vbeln"));
	String werks=LiangxinUtil.null2String((String)request.getAttribute("werks"));
	String lgort=LiangxinUtil.null2String((String)request.getAttribute("lgort"));
	String wadat=LiangxinUtil.null2String((String)request.getAttribute("wadat"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">

<script src="/js/jquery.js"></script>  
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>  
<!-- Le styles -->
<link href="/css/jiuhui_list.css" rel="stylesheet">

  <script  type="text/javascript">
  	
  	function fanhui(){
  		document.thinkway.action="/delordView.do";
  		document.getElementById("page").value="1";
  		document.thinkway.submit();
  	}
  	function lastPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==1)return;
  		document.getElementById("page").value=pageNo-1;
  		document.thinkway.action="/matlgpfifoView.do";
  		document.thinkway.submit();
  	}
  	function nextPage(){
  		var pageNo=<%=pageNo%>;
  		var pageNum=<%=pageNum%>;
  		if(pageNo==pageNum)return;
  		document.getElementById("page").value=pageNo+1;
  		document.thinkway.action="/matlgpfifoView.do";
  		document.thinkway.submit();
  	}
  	function validateForm(){
  		 var lonstr=$("#str").val();
  		 var str=lonstr.split("/");
  		 if(str.length<=0){
  		 	alert("请扫描物料卡");
  		 	return;
  		 }
  		 var matnr=str[1];
	  		
	  	 var sonum=str[6];
	  	 
	  	 var mat=document.getElementById("matnr").value
	  	 
	  	 if(matnr!=mat){
	  	 	alert("物料不匹配！");
	  	 	return;
	  	 }
	  	 if(sonum==null || sonum=='')sonum='-1';
  		 var xuhao=document.getElementById("maxxuhao").value;
  		 var sfyz=false;
  		 var shuliang=parseFloat(document.getElementById("shuliang").value);
  		 var leiji=0;
  		 for(var i=1;i<xuhao;i++){
  		 	
  		 	//if(i=='1'){
  		 	//	break;
  		 	//}
  		 	var sl1=parseFloat(document.getElementById(i).value);
  		 	var sl2=parseFloat(document.getElementById('verme_'+i).value);
  		 	var lgnum=document.getElementById('lgnum'+i).value;
  		 	var active=document.getElementById('active'+i).value;
	  		if(document.getElementById(i).value==null || document.getElementById(i).value=='')sl1=0;
	  		if(document.getElementById('verme_'+i).value==null || document.getElementById('verme_'+i).value=='')sl2=0;
	 			if(active!='X'&&sl1!=0){
	 			alert("请选择最小批次库存");
  		 		return;
	 		}
  		 	if(sl1>sl2){
  		 		alert("第"+i+"行，选择数量大于仓位数量，请重新选择数值！");
  		 		return;
  		 	}
  		 	leiji+=sl1;
  		 	if(document.getElementById(i).value!=''){
  		 		sfyz=true;
  		 		//break;
  		 	}
  		 	if(lgnum==null||lgnum=='')lgnum='-1';
  		 	if(sonum!=lgnum){
  		 		alert("第"+i+"行特殊库存不一致，请检查！");
  		 		return;
  		 	}
  		 	
  		 }
  		 
  		 if(leiji>shuliang){
  		 	alert("以选择数量大于需求数量，请重新选择");
  		 	return;
  		 }
  		 
  		 if(!sfyz){
  		 	alert("选择数量一个都没有填写");
  		 	return false;
  		 }else{
  		 	document.thinkway.action="/delordpicAdd.do";
  		 	document.thinkway.submit();
  		 }
  	}
  </script>


</HEAD>
<BODY>
<div class="div">
	<form  id="thinkway" name="thinkway" method="post"  action="/delordpicAdd.do">
	<input type="hidden" name="page" id="page" value="<%=pageNo %>"/>
	<input type="hidden" name="vbeln" id="vbeln" value="<%=vbeln %>"/>
	<input type="hidden" name="werks" id="werks" value="<%=werks %>"/>
	<input type="hidden" name="lgort" id="lgort" value="<%=lgort %>"/>
	<input type="hidden" name="wadat" id="wadat" value="<%=wadat %>"/>
				<%
					List<DelOrdPic> list=(List)request.getAttribute("delordList");
					if(list==null){
					
				%>

				<table style="width:100%;">
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
						<td align="center" >
							<input type="button" style="width:50px;height=20%" value="返回" onclick="fanhui();"></input>
							<input  class=button type="button" style="width:50px;heigth=20%"  onclick="window.location.href='/main.do';" value="首页">
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
						<col width="30%"/>
						<col width="30%"/>
						<col width="30%"/>
					</colgroup>
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
						<td align="center" colspan=2>	
							<input type="button" style="width:50px;heigth=20%" value="返回" onclick="fanhui();"></input>
							<input  class=button type="button" style="width:50px;heigth=20%"  onclick="window.location.href='/main.do';" value="首页">
						</td>
					</tr>
				</table>
			<%	return;} %>
			<table class="table_list" style="width:100%">
				<tr  class="tr_list_1">
					<td class="td_list" align="center" colspan=3><input name="str" style="height:15px;" type="text" style="white-space：nowrap;width:70%;"  id="str"></td>
				</tr>
				<tr class="tr_list_1">
					<td class="td_list">物料编码:</td>
					<td class="td_list" colspan=2>${delord.matnr}</td>
				</tr>
				<tr class="tr_list_1">
					<td class="td_list">物料描述:</td>
					<td class="td_list" colspan=2>${delord.maktx}</td>
				</tr>
				<tr class="tr_list_1">
					<td class="td_list">需求数量:</td>
					<td class="td_list" colspan=2>${verme}
					<input type="hidden" name="matnr" id="matnr" value="${delord.matnr}" />
					<input type="hidden" name="shuliang" id="shuliang"   value="${verme}" />
					<input type="hidden" name="vbeln" style="width:70%"  id="vbeln" value="${delord.vbeln}"/>
					<input type="hidden" name="posnr" style="width:70%"  id="posnr" value="${delord.posnr }"/>
					<input type="hidden" name="maktx" style="width:70%"  id="maktx" value="${delord.maktx }"/>
					<input type="hidden" name="matnr" style="width:70%"  id="matnr" value="${delord.matnr }"/>
					<input type="hidden" name="wadat" style="width:70%"  id="wadat" value="${wadat }"/>
					<input type="hidden" name="lgort" style="width:70%"  id="lgort" value="${lgort }"/>
					<input type="hidden" name="werks" style="width:70%"  id="werks" value="${werks }"/></td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000" >
					<td class="td_list" style="width:30%;">拣配标记</td>
					<td class="td_list">仓位</td>
					<td class="td_list">批次</td>
				</tr>
				<tr class="tr_list_1">
					<td class="td_list">数量</td>
					<td class="td_list">选择数量</td>
					<td class="td_list">特殊库存</td>
				</tr>
			<%
				int i=1;
				for(i=1;i<=list.size();i++){
					DelOrdPic pic=(DelOrdPic)list.get(i-1);
			%>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list" style="height:15px;">
						<%=pic.getActive() %>
					</td>
					<td class="td_list">
						<%=pic.getLgpla() %>
						 <input type="hidden" name="lgpla<%=i %>" style="width:70%"  id="lgpla<%=i %>" value="<%=pic.getLgpla() %>" />
					    <input type="hidden" name="plpos<%=i %>" style="width:70%"  id="plpos<%=i %>" value="<%=pic.getPlpos() %>" />
					    <input type="hidden" name="meins<%=i %>" style="width:70%"  id="meins<%=i %>" value="<%=pic.getMeins() %>" />
					    <input type="hidden" name="active<%=i %>" style="width:70%"  id="active<%=i %>" value="<%=pic.getActive() %>" />
					</td>
					<td class="td_list">
						<%=pic.getCharg()%>
						<input type="hidden" name="charg<%=i %>" style="width:70%"  id="charg<%=i %>" value="<%=pic.getCharg() %>" />
					</td>
				</tr>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list" style="height:15px;">
						<%=pic.getVerme() %>
						<input type="hidden" name="verme_<%=i %>" id="verme_<%=i %>" value="<%=pic.getVerme() %>">
					</td>
					<td class="td_list">
						<input name="<%=i %>" type="text" style="width:70%;height:14px;" class="input1"  id="<%=i %>" value="" />
					</td>
					<td class="td_list">
						<%=pic.getLgnum() %>
						<input type="hidden" name="lgnum<%=i %>"   id="lgnum<%=i %>"  value="<%=pic.getLgnum() %>" />
					</td>
				</tr>
			<%} %>
			
			<tr>
				<td align="center"  colspan="3"><input type="button" style="width:40px;" onclick="lastPage()" value="上一页">	<input type="hidden" name="maxxuhao" id="maxxuhao" value="<%=i %>"/>
					<input type="button" style="width:30px;" onclick="validateForm()" value="保存"></input>
					<input type="button" style="width:30px;" value="返回" onclick="fanhui();"></input>
					<input  class=button type="button" style="width:30px;"  onclick="window.location.href='/main.do';" value="首页">
					<input type="button" style="width:40px;" onclick="nextPage()" value="下一页"></td>
			</tr>
		
			</table>

			</form>
</div>

</BODY>

</HTML>