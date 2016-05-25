<%@page import="com.exampleCode.model.BillsInfo"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%List list = (List)request.getAttribute("resultList");  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=request.getSession().getAttribute("type")%></TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link href="./css/jiuhui_list.css" rel="stylesheet"/>
<script src="./js/jquery.js"></script>
<script src="./jquery.pagination_2/demo/lib/jquery.min.js"></script>
<script src="./jquery.pagination_2/jquery.pagination.js"></script>
<!-- <script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"/> -->  
<link href="./jquery.pagination_2/pagination.css" rel="stylesheet"/>
<script>
function stoQuy(){
	document.getElementById("listform").action="MainServlet?flag=shengchanE";
	document.listform.submit();
}
function ToMore(obj,line){
	//alert("111");return;
	var itemNO = obj.innerHTML;//获取当前a标签中的值
	//alert(itemNO);return;
	//物料编码
	$("#matnr").attr("value",itemNO);
	//alert(itemNO);return;
	//已捡配数量
	var valueTd =document.getElementById ("box").rows [line].cells[2];
	var useNumber = valueTd.innerHTML;
	if(useNumber == "KG"){
		valueTd =document.getElementById ("box").rows [line+1].cells[2];
		useNumber = valueTd.innerHTML;
	}else if (useNumber == "NaN"){
		useNumber = "";
	}
	//$("#useNumber").attr("value",useNumber);
	document.getElementById("useNumber").value = useNumber;
	//最大数量
	var valueTd2 =document.getElementById ("box").rows [line].cells[1];
	var maxNumber = valueTd2.innerHTML;
	
	//$("#maxNumber").attr("value",maxNumber);
	document.getElementById("maxNumber").value = maxNumber;
	//alert(maxnum);return;
	
	document.getElementById("listform").action="MainServlet?flag=shengchanC";
	document.getElementById("argsubmit").click();
	//document.listform.submit();
}
function submit1(obj){
  	obj.disabled=false;
  	document.listform.submit();
}	
/* $(function(){
	$('tr').click(function(){
	submit(obj);
	//这里写单击tr执行的操作
	});
}); */
</script>
<style type="text/css">
    body {
      padding-top: 40px;
      padding-bottom: 0px;
      padding-left: 20px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
</HEAD>
<BODY>

<div class="div" >
	<form name="listform" id="listform" method="post"  >
		<div style="display: none;">
		<input name="matnr" type="hidden" id="matnr" />
		<!-- <input name="useNumber" type="hidden" id="useNumber" /> -->
		<input name="useNumber"  id="useNumber" type="hidden" />
		<input name="maxNumber"  id="maxNumber"  type="hidden"/>
		</div>
		<%-- <input name="num1" type="hidden"  id="num1" value="<%=httpSession.getAttribute("num1") == null ? "" : httpSession.getAttribute("num1")%>" />
		<input name="num2" type="hidden"  id="num2" value="<%=httpSession.getAttribute("num2") == null ? "" : httpSession.getAttribute("num2")%>" />
		<input name="num3" type="hidden"  id="num3" value="<%=httpSession.getAttribute("num3") == null ? "" : httpSession.getAttribute("num3")%>" />
		<input name="type" type="hidden" id="type"  value="<%=request.getSession().getAttribute("type") == null ? "" : request.getSession().getAttribute("type")%>"/>
		 --%>
		<table class="table_list" style="line-height: 15px;" align="center" width="100%" id = "box">
			<colgroup>
				<col width="10%" />
				<col width="25%" />
				<col width="10%" />
				<col width="25%" />
				<col width="15%" />
				<col width="20%" />
			</colgroup>
			<tr bordercolor="#000000" class="tr_list_1"">
				<td class="td_list">序号</td>
				<td class="td_list">物料</td>
				<td class="td_list">单位</td>
			</tr>
			<tr bordercolor="#000000" class="tr_list_1" >
				<td class="td_list">批次</td>
				<td class="td_list">数量</td>
				<td class="td_list">已拣配</td>
			</tr>
			<%	
				for(int i = 0 ; i < list.size() ; i ++){ 
				BillsInfo info = (BillsInfo)list.get(i);
			%>
			<tr class="tr_list_2" >
				<td class="td_list"><%=i+1%></td>
				<td class="td_list">
					<%-- <input  class="button" type="button"  onclick="ToMore(this,<%=i+3%>)" value="<%=info.getItemNO()%>" /> --%>
					<%-- <span onclick="ToMore(this,<%=i+3%>);" style="background-color: #D8D8D8;"><%=info.getItemNO()%></span> --%>
				<span onclick="javascript:ToMore(this,<%=i+3 %>)"  style="background-color:#D8D8D8;"><%=info.getItemNO()%></span>
				</td>
				<td class="td_list">KG</td>
			</tr>
			<tr class="tr_list_2">
				<td class="td_list"><%=info.getBatchNO()%></td>
				<td class="td_list"><%=info.getNumber()%></td>
				<td class="td_list"><%=info.getUseNumber()%></td>
				
			</tr>
				
			<%} %>
			<tr>
				<td colspan="6" style="line-height: 40px;">
				<input  class="button" type="button" name="argsubmit" id="argsubmit" onclick="submit1(this);" style="display:none" />
				<input style="text-align: center;margin-top:15px;" class="button" type="button" style="width:25%" onclick="stoQuy()" value="过账" /> 
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