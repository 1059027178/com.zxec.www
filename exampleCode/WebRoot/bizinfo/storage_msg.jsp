<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>仓位转移</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link href="./css/jiuhui_list.css" rel="stylesheet"/>
<script src="./js/jquery.js"></script>

<script>
	
function forward(){
  	window.location.href="MainServlet?flag=3";
  }		
function turnon(){
  	window.location.href="MainServlet?flag=3.2";
  }		
</script>

</HEAD>
<BODY>
<div class="div" style="margin-top:90px;">
  <form action="MainServlet?flag=3.4"  method ="post">
	<table class="table_list" style="margin: 0px 0px 0px 30px;line-height:30p;width:100%;">
  		<tr >
  		<td>
  			返回消息：</br>
  			<%=request.getSession().getAttribute("message") == null ? "" : request.getSession().getAttribute("message") %>
  		</td>
  		</tr>
  		<tr>
  			<td >
  				<input class="button" type="button" style="width:40px;margin:20px 0px 0px 0px;" onclick="turnon()" value="继续"/>
  				<input class="button" type="button" style="width:40px;"  onclick="forward();" value="返回" />
  				<input type="button" class="button" style="width:40px;" onclick="window.location.href='MainServlet?flag=return';" value="首页"/>
  			</td>
  		</tr>
  	</table>
   </form>
</div>
</BODY>

