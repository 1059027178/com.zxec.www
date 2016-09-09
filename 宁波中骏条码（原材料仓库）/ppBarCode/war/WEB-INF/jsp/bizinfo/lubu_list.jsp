<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.thinkway.SapUtil"%>
<%@ page import="com.thinkway.cms.business.domains.Lubu"%>
<%
	/* int pageNo    =SapUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum   =(Integer)request.getAttribute("pageNum"); */
	String message  =SapUtil.null2String((String)request.getAttribute("message"));
	String wemng  =SapUtil.null2String((String)request.getAttribute("wemng"));//数量
	String meins  =SapUtil.null2String((String)request.getAttribute("meins"));//单位
	List<Lubu> list=(List)request.getAttribute("repList");
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
<script src="/js/jquery.js"></script>
<script src="/jquery.pagination/demo/lib/jquery.min.js"></script>
<script src="/jquery.pagination/jquery.pagination.js"></script>
<link href="/jquery.pagination/pagination.css" rel="stylesheet" />
<!----------------分页----------------->
<script type="text/javascript">
$(function(){
	//总数目
	var length = <%=list.size()%>;
	//设置分页元素参数
	var optInit = getOptionsFromForm();
	$("#Pagination").pagination(length, optInit);
	
	$(function(){
		var opt = getOptionsFromForm();
		// 重新创建分页参数
		$("#Pagination").pagination(length, opt);
	});
	//-----------------------------------
	function getOptionsFromForm(){
		var opt = {callback: pageselectCallback}; //回调函数：默认无执行效果
		opt.items_per_page = 5;		//每页显示的条目数(可选参数，默认是10)
		opt.num_display_entries = 0;//连续分页主体部分显示的分页条目数(可选参数，默认是10)
		opt.num_edge_entries = 0;	//两侧显示的首尾分页的条目数(可选参数，默认是0)
		opt.prev_text = "<<";	//“前一页”分页按钮上显示的文字(字符串参数，可选，默认是"Prev")
		opt.next_text = ">>";	//“下一页”分页按钮上显示的文字(字符串参数，可选，默认是"Next")
		return opt;
	}
	//-------------------------------
	function pageselectCallback(page_index , jq){
	
		var items_per_page = 5;//每页的显示的列表项数目
		
		var max_elem = Math.min((page_index+1) * items_per_page, length);
		
		$(".tbody").hide();
		// 获取加载元素
		for(var i=page_index*items_per_page;i<max_elem;i++){
		
			$(".tbody:eq("+i+")").show();
		}
		//阻止单击事件
		return false;	
	}
});
</script>
<script>
	
function forward(){
  	window.location.href="/main.do?two=4";
  }		
function turnon(){
  	window.location.href="/lubuView.do";
  }		
<%-- function lastPage(){
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
} --%>
function getRow(obj){
	$("#row").attr("value",obj);
}
function submit1(){
	var row = $("#row").val();
	if(row == "") {
		alert("请选择对应仓位");return;
	}
	document.listForm.submit();
}
</script>
</HEAD>
<BODY>
	<div class="div">
		<form action="/lubuEdit.do" id="listForm" name="listform" method="get">
			<input type="hidden" id="matnr" name="matnr" value="${ matnr }" /> 
			<input type="hidden" id="matnr1" name="matnr1" value="${ matnr1 }" /> 
			<input type="hidden" id="lgort" name="lgort" value="${ lgort }" /> 
			<input type="hidden" id="charg" name="charg" value="${ charg }" /> 
			<input type="hidden" id="targetBatch" name="targetBatch" value="${ targetBatch }" /> 
			<input type="hidden" id="werks" name="werks" value="${ werks }" /> 
			<input type="hidden" id="mblnr" name="mblnr" value="${ mblnr }" /> 
			<input type="hidden" id="lgnum" name="lgnum" value="${lgnum }" /> 
			<input type="hidden" id="ubnum" name="ubnum" value="${ ubnum}" /> <!-- 过账更改编号（记账变更号） -->
			<%-- <input type="hidden" id="page" name="page" value="<%=pageNo%>" />  --%>
			<input type="hidden" id="wemng" name="wemng" value="<%=wemng%>" /> 
			<input type="hidden" id="meins" name="meins" value="<%=meins%>" /> 
			<input type="hidden" id="row" name="row" value="" />
			<%
				if (list == null) {
			%>
			<table style="width:100%">
				<tr>
					<td>返回消息：${type} ${message}</td>
				</tr>
				<tr>
					<td align="center">
						<input type="button" class="button" style="width:40px;height:25px;" type="button" value="返回" onclick="forward();" /> 
						<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页"/>
					</td>
				</tr>
			</table>
			<%
				return;
				}
			%>
			<%
				if (list.size() == 0) {
			%>
			<table style="width:100%;">
				<tr>
					<td>返回消息：${type} ${message}</td>
				</tr>
				<tr>
					<td align="center">
						<input type="button" class="button" style="width:40px;height:25px;" type="button" value="返回" onclick="forward()" /> 
						<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
					</td>
				</tr>
			</table>
			<%
				return;
				}
			%>
			<table class="table_list" style="width:100%;">
				<colgroup>
					<col width="30%" />
					<col width="70%" />
				</colgroup>
				<tr class="tr_list_1" bordercolor="#000000">
					<td class="td_list" style="padding-left: 10px;">记账变更号：</td>
					<td class="td_list">${ ubnum }</td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000">
					<td class="td_list" style="padding-left: 10px;">未清数量：</td>
					<td class="td_list"><%=wemng + " " + meins%></td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000">
					<td class="td_list" style="padding-left: 10px;">物料代码：</td>
					<td class="td_list">从<input type="text" style="width:78px;background-color:#D8D8D8;" readonly="readonly" value="${matnr }" /></td>
				</tr>
				<tr class="tr_list_1" bordercolor="#000000">
					<td class="td_list"></td>
					<td class="td_list">到<input type="text" style="width:78px;background-color:#D8D8D8;" readonly="readonly" value="${matnr1 }" /></td>
				</tr>
			</table>
			<table class="table_list" style="width:100%">
				<tr class="tr_list_1" bordercolor="#000000">
					<td class="td_list" style="padding-left: 10px;">选择</td>
					<td class="td_list">存储类型</td>
					<td class="td_list">仓位</td>
					<td class="td_list">可用库存</td>
				</tr>
				<%
					int i = 1;
					for (i = 1; i <= list.size(); i++) {
						Lubu pic = (Lubu) list.get(i - 1);
				%>
					<tbody class="tbody" style="display: none;" align="left">
					<tr <%if (i % 2 == 1) {%> class="tr_list_2" <%} else {%> class="tr_list_1" <%}%> bordercolor="#000000">
						<%
							if (i == 1) {
						%>
						<td class="td_list" style="padding-left: 10px;">
							<input name="radio" onclick="getRow(<%=i%>);" style="width:20px;" type="radio" id="radio1" value="<%=i%>" />
						</td>
						<%
							} else {
						%>
						<td class="td_list" style="padding-left: 10px;">
							<input name="radio" onclick="getRow(<%=i%>);" style="width:20px;" type="radio" id="radio<%=i%>" value="<%=i%>" />
						</td>
						<%
							}
						%>
						<td class="td_list">
							<input type="hidden" name="<%="lqnum" + i%>" value="<%=SapUtil.null2String(pic.getLqnum())%>" /> 
							<input type="hidden" name="<%="lgtyp" + i%>" value="<%=SapUtil.null2String(pic.getlgtyp())%>" /> <%=SapUtil.null2String(pic.getlgtyp())%>
						</td>
						<td class="td_list">
							<input type="hidden" name="<%="lgpla" + i%>" value="<%=SapUtil.null2String(pic.getLgpla())%>" /> <%=SapUtil.null2String(pic.getLgpla())%>
						</td>
						<td class="td_list">
							<input type="hidden" name="<%="verme" + i%>" value="<%=SapUtil.null2String(pic.getVerme())%>" /> <%=SapUtil.null2String(pic.getVerme()) + " " + meins%>
						</td>
					</tr>
					</tbody>
				<%
					}
				%>
				<tr>
					<td align="center" colspan=5>
						<div id="Pagination" class="pagination" style="line-height: 10px;font-size:12px;margin-left:9px;margin-top:10px;"><!-- 这里显示分页 --></div>
						<input class="button" style="width:35px;margin-left:-30px;" value="确定" type="button" onclick="submit1()" />
						<input class="button" style="width:35px;" type="button" value="返回" onclick="forward()" /> 
						<input type="button" class="button" style="width:35px;" onclick="window.location.href='/main.do';" value="首页"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
</BODY>
</HTML>