<%@page import="com.exampleCode.model.PositionsInfo"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%List list = (List)request.getSession().getAttribute("resultList");%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>仓位转移</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="./css/jiuhui_list.css" rel="stylesheet" />
<script src="./js/jquery.js"></script>  
<script>
function stoQuy(){

	/* var num =$("#num").val();
	
	if(num == ""|| num == "0"){
	
		alert("请填写数量");
  		document.getElementById("num").focus();
		return;
		
	} */
	document.listform.action="MainServlet?flag=storageMsg";
	document.listform.submit();
}
function submit(obj,line){
	var itemNO = obj.innerHTML;//获取当前a标签中的值
	//alert(itemNO);return;
	//物料编码
	$("#matnr").attr("value",itemNO);
	//alert(matnr);return;
	var number = document.getElementById(line).value;
	//alert(number);return;
	$("#number").attr("value",number);
	var batchNO = document.getElementById(line+"batchNO").value;
	$("#batchNO").attr("value",batchNO);
	/* 
	var zhuanyi = document.getElementById(line+"zhuanyi").value;
	$("#zhuanyi").attr("value",zhuanyi);
	var zhuanyicangwei = document.getElementById(line+"zhuanyicangwei").value;
	$("#zhuanyicangwei").attr("value",zhuanyicangwei); */
	//alert(batchNO);return;
	document.listform.action="MainServlet?flag=storageTo"
	document.listform.submit();
}
</script>
<style type="text/css">
    body {
      padding-top:10px;
      padding-bottom: 0px;
      padding-left:20px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
</HEAD>
<BODY>
<div class="div" >
	<form  id="listform" name="listform" method="post" >
		<input name="matnr" type="hidden" id="matnr" />
		<input name="number" type="hidden" id="number" />
		<input name="batchNO" type="hidden" id="batchNO" />
		<input name="zhuanyi" type="hidden" id="zhuanyi" />
		<input name="zhuanyicangwei" type="hidden" id="zhuanyicangwei" />
		<%if(list == null || list.size() < 1) {%>
			<div style="margin:70px 0px 0px 30px;">
			未查询到数据！<br />
			<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=3.2';" value="返回" />
    		<input  class="button" 	type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="首页" />
    		</div>
		<%}else{ %>
			<table class="table_list" style="line-height: 15px;" id="box">
				<colgroup>
						<col width="35%"/>
						<col width="30%"/>
						<col width="25%"/>
						<col width="10%"/>
					</colgroup>
				<tr>
					<td colspan="3" style="line-height: 20px;">
						仓 位：<input name="literaNO" style="width:50%;heigth:20px;background-color:#D8D8D8;" class="text"  readonly=readonly type="text" id="literaNO" value = "<%=request.getSession().getAttribute("literaNO") == null ? "": request.getSession().getAttribute("literaNO")%>" />
					</td>
				</tr>
				<tr style="height: 10px;"></tr>
				<tr bordercolor="#000000" class="tr_list_1" >
    				<td class="td_list">序号</td>
					<td class="td_list"  align="center">物料编码</td>
    				<td class="td_list"  align="center">数量</td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list">描述</td>
					<td class="td_list"  align="center">批次</td>
					<td class="td_list"  align="center">下架</td>
				</tr>
				<% 	for(int i = 0 ;i < list.size() ; i ++){
					PositionsInfo info = (PositionsInfo)list.get(i);
					
				%>
				<tr class="tr_list_2" >
					<td class="td_list"><%=i+1 %></td>
					<td class="td_list"  align="center"><a href="#" onclick="submit(this,<%=i+1%>);"><%=info.getItemNO()%></a></td>
					<td class="td_list"  align="center" ><%=info.getNumber() %>
					<input type="hidden" id = "<%=i+1%>" value="<%=info.getNumber() %>"/>
					</td>
				</tr>
				<tr class="tr_list_2" >
					<td class="td_list" ><%=info.getItemDescription() %></td>
					<td class="td_list"  align="center"><%=info.getBatchNO() %>
					<input type="hidden" id = "<%=i+1+"batchNO"%>" value="<%=info.getBatchNO() %>"/></td>
					<td class="td_list" ></td>
					<%-- <td class="td_list"  align="center"><%=info.getZhuanyishuliang() %>
					<input type="hidden" id = "<%=i+1+"zhuanyi"%>" value="<%=info.getZhuanyishuliang() %>"/>
					<input type="hidden" id = "<%=i+1+"zhuanyicangwei"%>" value="<%=info.getZhuanyishuliang() %>"/></td> --%>
					<!-- <td class="td_list" ><input style="width:35px;height: 15px;" type="text" id="num" name="num" /></td> -->
				</tr>
				<%} %>
				<!-- <tr class="tr_list_2" align="center">
					<td class="td_list">1</td>
					<td class="td_list">C.9.291400</td>
					<td class="td_list">10000</td>
				</tr>
				<tr class="tr_list_2" align="center">
					<td class="td_list" >C2沙剂-规格(25kg/桶)</td>
					<td class="td_list" >20160507</td>
					<td class="td_list" ><input style="width:35px;height: 15px;" type="text" id="num" name="num" /></td>
				</tr> -->
			<tr >
				<td colspan="3" >
					<input  class="button"  type="button"  style="width:25%;margin:6px 0px 0px -4px;"  onclick="stoQuy()" value="确定" />
    				<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=3.2';" value="返回" />
    				<input  class="button" 	type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="首页" />
    			</td>
			</tr>
			</table>
		<%} %>
	</form>
</div>
 <script type="text/javascript">
document.getElementById("num").focus();
 </script>
</BODY>
</HTML>