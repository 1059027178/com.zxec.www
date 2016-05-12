<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>库存转储</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link href="./css/jiuhui_list.css" rel="stylesheet"/>
<script src="./js/jquery.js"></script>

<script>
	
function forward(){
  	window.location.href="MainServlet?flag=zhuanchu";
  }		
function submit1(obj){
  	obj.disabled=false;
	document.form.submit();
  }		
</script>

</HEAD>
<BODY>
<div class="div" style="margin-top:60px;">
  <form action="MainServlet?flag=2.4"  method ="post" name = "form">
  <input name="matnr" type="hidden" value="<%=request.getSession().getAttribute("matnr") == null ? "" : request.getParameter("matnr").trim()%>"/>
  <input name="batchNo" type="hidden" value="<%=request.getSession().getAttribute("batchNo") == null ? "" : request.getParameter("batchNo").trim()%>"/>
	<table class="table_list" style="margin: 0px 0px 0px 60px;line-height:30px;">
  		<tr >
  		<td>
  			返回消息：<br />
  			<%=request.getSession().getAttribute("message") == null ? "" : request.getSession().getAttribute("message") %>
  		</td>
  		</tr>
  		<tr>
  			<td >
  				<input class="button" type="button" style="width:40px;" onclick="submit1(this)" value="下架"/>
  				<input class="button" type="button" style="width:40px;"  onclick="forward();" value="返回" />
  				<input type="button" class="button" style="width:40px;" onclick="window.location.href='MainServlet?flag=return';" value="首页"/>
  			</td>
  		</tr>
  	</table>
   </form>
</div>
</BODY>

