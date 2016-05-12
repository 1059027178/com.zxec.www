<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
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

	var num =$("#num").val();
	
	if(num == ""|| num == "0"){
	
		alert("请填写数量");
  		document.getElementById("num").focus();
		return;
		
	}
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
<div class="div" >
	<form  id="listform" name="listform" method="post" action="MainServlet?flag=storageTo">
			<table class="table_list" style="width:100%">
				<colgroup>
						<col width="40%"/>
						<col width="25%"/>
						<col width="25%"/>
						<col width="10%"/>
					</colgroup>
				<tr>
					<td colspan="3" style="line-height: 40px;">
						仓 位：<input name="literaNO" style="width:50%;heigth:20px;background-color:#D8D8D8;" class="text"  readonly=readonly type="text" id="literaNO" value = "<%=request.getSession().getAttribute("literaNO") == null ? "": request.getSession().getAttribute("literaNO")%>" />
					</td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_1">
    				<td class="td_list">序号</td>
					<td class="td_list">物料编码</td>
    				<td class="td_list">数量</td>
				</tr>
				<tr bordercolor="#000000" class="tr_list_1">
					<td class="td_list" >描述</td>
					<td class="td_list">批次</td>
					<td class="td_list">下架</td>
				</tr>
				<tr class="tr_list_2" >
					<td class="td_list">1</td>
					<td class="td_list">C.9.291400</td>
					<td class="td_list">10000</td>
				</tr>
				<tr class="tr_list_2" >
					<td class="td_list" >C2沙剂-规格(25kg/桶)</td>
					<td class="td_list">20160507</td>
					<td class="td_list"><input style="width:35px;height: 13px;" type="text" id="num" name="num" /></td>
				</tr>
				
			<tr >
				<td colspan="3" style="line-height: 40px;">
					<input  class="button"  type="button"  style="width:25%"  onclick="stoQuy()" value="确定" />
    				<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=3.2';" value="返回" />
    				<input  class="button" 	type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="首页" />
    			</td>
			</tr>
			</table>
			</form>
</div>
 <script type="text/javascript">
document.getElementById("num").focus();
 </script>
</BODY>
</HTML>