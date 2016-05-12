<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=request.getSession().getAttribute("type")%></TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="./css/jiuhui_list.css" rel="stylesheet" />
<script src="./js/jquery.js"></script>  
<script>
function stoQuy(){
	window.location.href="MainServlet?flag=shengchanD";
}
function submit(obj){
	if(obj == 1){
		$("#matnr").attr("value","C.9.291400");
	}
	else if(obj == 2){
		$("#matnr").attr("value","C.9.291470");
		
	}
	else if(obj == 3){
		$("#matnr").attr("value","C.6.040601");
		
	}
	var matnr = $("#matnr").val();
	//alert(matnr);
	document.listform.submit();
}
</script>
<style type="text/css">
    body {
      padding-top: 40px;
      padding-bottom: 0px;
      padding-left: 30px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
</HEAD>
<BODY>
<% String batchNO = request.getSession().getAttribute("batchNO") == null ? "" : request.getSession().getAttribute("batchNO").toString(); %>
<div class="div" >
	<form name="listform" id="listform" method="post" action="MainServlet?flag=shengchanC">
		<input name="batchNO" type="hidden" value="<%=batchNO%>" />
		<input name="matnr" type="hidden" id="matnr" />
		<table class="table_list" style="width:100%">
			<colgroup>
				<col width="10%" />
				<col width="25%" />
				<col width="10%" />
				<col width="25%" />
				<col width="15%" />
				<col width="20%" />
			</colgroup>
			<tr bordercolor="#000000" class="tr_list_1" style="line-height: 30px;">
				<td class="td_list">序号</td>
				<td class="td_list">物料</td>
				<td class="td_list">单位</td>
				<td class="td_list">批次</td>
				<td class="td_list">数量</td>
				<td class="td_list">已拣配</td>
			</tr>
			<tr class="tr_list_2" style="line-height: 20px;" onclick="submit(1)">
				<td class="td_list">1</td>
				<td class="td_list">C.9.291400</td>
				<td class="td_list">PC</td>
				<td class="td_list"><%=batchNO %></td>
				<td class="td_list">20000</td>
				<%HttpSession httpSession = request.getSession(); %>
				<td class="td_list"><%=httpSession.getAttribute("num") == null ? "" : httpSession.getAttribute("num")%></td>
			</tr>
			<tr class="tr_list_2" style="line-height: 20px;" onclick="submit(2)">
				<td class="td_list">2</td>
				<td class="td_list">C.9.291470</td>
				<td class="td_list">PC</td>
				<td class="td_list"><%=batchNO %></td>
				<td class="td_list">10000</td>
				<td class="td_list"><%=httpSession.getAttribute("num") == null ? "" : httpSession.getAttribute("num")%>
				</td>
			</tr>
			<tr class="tr_list_2" style="line-height: 20px;" onclick="submit(3)">
				<td class="td_list">3</td>
				<td class="td_list">C.6.040601</td>
				<td class="td_list">PC</td>
				<td class="td_list"><%=batchNO %></td>
				<td class="td_list">5000</td>
				<td class="td_list"><%=httpSession.getAttribute("num") == null ? "" : httpSession.getAttribute("num")%>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="line-height: 40px;">
				<input style="text-align: center;" class="button" type="button" style="width:25%" onclick="stoQuy()" value="过账" /> 
				<input style="text-align: center;" class="button" type="button" style="width:25%" onclick="window.location.href='MainServlet?flag=shengchanA';" value="返回" /> 
				<input style="text-align: center;" class="button" type="button" style="width:25%" onclick="window.location.href='MainServlet?flag=return';" value="首页" />
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
<script type="text/javascript">
document.getElementById("num1").focus();
</script>
</html>