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
	String meins=SapUtil.null2String((String)request.getAttribute("meins")); 
	String maktx=SapUtil.null2String((String)request.getAttribute("maktx")); 
	List<Mat> list=(List)request.getAttribute("matList");
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
<script src="./js/jquery.js"></script>  
<script type="text/javascript" src="../../../js/alert.js"></script>
<script>
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
 	$(document).on("keyup", ".selectAmount", function() {
		var keycode = event.keyCode;
		if (keycode == '86') {
			var inputs = $(this);
			var check = $(this).next();
			if (check.val() == 1) {
				return;
			}
      var warehouse = $(this).prev();
			if (($(this).val() != warehouse.val()) && (!check.val())) {
				$(this).val("").focus();
				alert("确认仓位不匹配!");
			} else {
				check.val("1");//标记确认
				$(this).val("").focus();
			}

		}
		else if(keycode=='13'){
		var inputs = $(this);
		var check = $(this).next();
		if (check.val()) {
			if (false) {
				$(this).val(pager.list[index].selectAmount); // 使用原越库数
				$(this).val(pager.list[index].selectAmount);
				alert("上一仓位为空!");
			} else {
				var sum = 0,sum = 0,i;
 		var length = <%=list.size()+1%>;
 		for(i = 1 ; i < length; i++){
 		
 			var count = $("#count_"+i).val();//当前输入的值
 			var max   = $("#max_"+i).val();//可用库存
 			if(count == "") count = "0";
 			if(parseFloat(count) > parseFloat(max)){
 				alert("下架数量过大！");
 				$("#count_"+i).attr("value","");
 				return;
 			}
 			var str = parseFloat(count) + "";
 			if(str == "NaN"){
 				alert("请输入数值");
 				$("#count_"+i).attr("value","");
 				return;
 			}
 			sum += parseFloat(count);
 		}
 		$("#sum").attr("value",sum); 
			}
		} else {
			if (check.val() == 1) {
				return;
			}
			 var warehouse = $(this).prev();
			if (($(this).val() != warehouse.val()) && (!check.val())) {
				$(this).val("").focus();
				alert("确认仓位不匹配!");
			} else {
				check.val("1");//标记确认
				$(this).val("").focus();
			}
		}}
	});
	$(document).on("change", ".selectAmount", function() {
		var inputs = $(this);
		var check = $(this).next();
		if (check.val()) {
			if (false) {
				$(this).val(pager.list[index].selectAmount); // 使用原越库数
				$(this).val(pager.list[index].selectAmount);
				alert("上一仓位为空!");
			} else {
				var sum = 0,sum = 0,i;
 		var length = <%=list.size()+1%>;
 		for(i = 1 ; i < length; i++){
 		
 			var count = $("#count_"+i).val();//当前输入的值
 			var max   = $("#max_"+i).val();//可用库存
 			if(count == "") count = "0";
 			if(parseFloat(count) > parseFloat(max)){
 				alert("下架数量过大！");
 				$("#count_"+i).attr("value","");
 				return;
 			}
 			var str = parseFloat(count) + "";
 			if(str == "NaN"){
 				alert("请输入数值");
 				$("#count_"+i).attr("value","");
 				return;
 			}
 			sum += parseFloat(count);
 		}
 		$("#sum").attr("value",sum); 
			}
		} else {
			if (check.val() == 1) {
				return;
			}
			 var warehouse = $(this).prev();
			if (($(this).val() != warehouse.val()) && (!check.val())) {
				$(this).val("").focus();
				alert("确认仓位不匹配!");
			} else {
				check.val("1");//标记确认
				$(this).val("").focus();
			}
		}
	});
 	function submit1(){
 		var sum = $("#sum").val();
 		if(sum == "" || sum == "0"){
 			alert("请输入下架数量！");return;
 		}
 		document.listForm.action="/deliveryMsg.do";
  		document.listForm.submit();
 	}
</script>
</HEAD>
<BODY>
<div class="div">
	<form  id="listForm" name="listForm" method="post" onsubmit="return false;">
	<div style="display: none;">
		物料编码：<input type="hidden" id="matnr" name="matnr" value="<%=matnr %>"/>
		仓库号：<input type="hidden" id="lgort" name="lgort" value="<%=lgort %>"/>
		批次号：<input type="hidden" id="charg" name="charg" value="<%=charg %>"/>
		工厂：<input type="hidden" id="werks" name="werks" value="<%=werks %>"/>
		单位：<input type="hidden" id="meins" name="meins" value="<%=meins %>"/>
		页码：<input type="hidden" id="page"  name="page"  value="<%=pageNo %>"/>
	</div>
				<%
					if(list==null){
				%>
				<table style="width:100%;">
					<tr>
						<td class="td_list">物料编码:</td>
						<td  class="td_list">
							<input type="text" style="background-color:#D8D8D8;" name="matnr" style="width:150%"  id="matnr" readonly="true" value="<%=matnr %>"/>
						</td>
					</tr>
					<tr class="tr_list_1">
						<td class="td_list" colspan="1">物料描述:</td>
						<td class="td_list" colspan="2">
							<%=maktx %>
						</td>
					</tr>
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
						<td align="center" >
							<input type="button" value="返回" style="width:50px;heigth=20%" onclick="window.location.href='/deliveryAdd.do';"/>
							<input  class=button type="button" style="width:50px;heigth=20%"  onclick="window.location.href='/main.do';" value="首页" />
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
					<tr class="tr_list_1">
						<td class="td_list" colspan="1">物料描述:</td>
						<td  class="td_list" colspan="2">
							<%=maktx %>
						</td>
					</tr>
					<tr>
						<td colspan="2">没有数据！</td>
					</tr>
					<tr>
						<td align="center" >
							<input type="button" value="返回" style="width:50px;heigth:20%"  onclick="window.location.href='/deliveryAdd.do';"></input>
							<input  class=button type="button" style="width:50px;heigth:20%"  onclick="window.location.href='/main.do';" value="首页">
 						</td>
					</tr>
				</table>
			<%	return;} %>
			<table class="table_list" style="width:100%;margin-top:2px;margin-left:2px" >
				<colgroup>
					<col width="30%"/>
					<col width="30%"/>
					<col width="40%"/>
				</colgroup>
				<tr class="tr_list_1">
					<td class="td_list" >物料编码：<%=matnr %>
					</td>
				</tr>
				<tr class="tr_list_1">
					<td class="td_list" >物料描述：
					<%=maktx %></td>
					<input type="hidden" value="<%=list.size()%>" name="size"/>
				</tr>
				<tr class="tr_list_1">
					<td class="td_list" >
						合<span style="width:28px;"></span>计：<input type="text" readonly="readonly" style="width:45px;background-color:#D8D8D8;" id="sum"/>
					</td>
				</tr>
				<%-- <tr class="tr_list_1">
					<td class="td_list" colspan="3" >
						总计：<input type="text" id="num" style="width:40px;background-color:#D8D8D8;" readonly="readonly"/>
						<%=meins%>
					</td>
				</tr> --%>
				</table>
				<table class="table_list" style="width:100%;" >
				<tr bordercolor="#000000"  class="tr_list_1">
					<td class="td_list" >序号</td>
					<td class="td_list">仓位</td>
					<td class="td_list">批次</td>
				</tr>
				<tr bordercolor="#000000"  class="tr_list_1">
					<td class="td_list" >生产日期</td>
					<td class="td_list">仓位数量</td>
					<td class="td_list">下架数量</td>
				</tr>
				<%
					int i=1;
					for(i=1;i<=list.size();i++){
						Mat mat=(Mat)list.get(i-1);
						String xuhao = mat.getXuhao();
						String lgpla = mat.getLgpla();
						String charg1 = mat.getCharg();
						String produceDate = mat.getProduceDate();
						String verme = mat.getVerme();
				%>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%} %>>
					<td class="td_list"><%=xuhao %></td>
					<td class="td_list">
						<input type="hidden" name="lgpla_<%=xuhao%>" value="<%=lgpla %>"/><%=lgpla %>
					</td>
					<td class="td_list">
						<input type="hidden" name="charg_<%=xuhao%>" value="<%=charg1%>"/><%=charg1%>
					</td>
				</tr>
				<tr <% if(i%2==1){ %>class="tr_list_2"<%}else{ %>class="tr_list_1"<%}%>>
					<td class="td_list">
						<input type="hidden" name="produceDate_<%=xuhao%>" value="<%=produceDate%>"/><%=produceDate%>
					</td>
					<td class="td_list">
						<input type="hidden" name="max_<%=xuhao%>" id="max_<%=xuhao%>" value="<%=verme%>" /><%=verme + meins%>
					</td>
					<td class="td_list">
					<input type="hidden"  value="<%=lgpla %>"/>
						<input type="text" name="count_<%=xuhao%>" id="count_<%=xuhao%>" style="width:30px;" class="selectAmount"/> <%=meins%>
						<input type="hidden" class="check"/>
					</td>
				</tr>
				
				<%}%>
			<tr >
				<td colspan="3" align="center" >
					<input  type="button" style="width:47px;margin-left: -30px;text-align:center;" value="上一页" onclick="lastPage();"/>
					<input  type="button" style="width:40px;" value="返回" onclick="window.location.href='/deliveryAdd.do';"/>
					<input  type="button" style="width:40px;" onclick="submit1();" value="下架"/>
					<input  type="button" style="width:47px;text-align:center;" value="下一页" onclick="nextPage();"/>
				</td>
			</tr>
		</table>
	</form>
	</div>
</BODY>
<script>
	<%if (list != null){
		if(list.size() > 0){%>
			$("#count_1").focus();
		<%}
	}%>
</script>
</HTML>