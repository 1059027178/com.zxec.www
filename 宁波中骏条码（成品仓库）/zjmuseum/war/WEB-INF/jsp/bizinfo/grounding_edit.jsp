<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/const.jsp"%>
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

<script>
	
function forward(){
  	window.location.href="/main.do?two=1";
  }		
function turnon(){
  	window.location.href="/groundingAdd.do";
  }		
</script>

</HEAD>
<BODY>
<div class="div" style="margin-top:60px;">
  <form action="/groundingAdd.do">
    	<table class="table_list">
    		<tr>
    			<td>
    				返回消息：${type}-${message}</td>
    		</tr>
    		<tr>
    			
    			<td align="center"><input class="button" type="button" style="width:40px;" onclick="turnon()" value="继续">
    			<input class="button" type="button" style="width:40px;"  onclick="forward();" value="返回">
    			<input type="button" class="button" style="width:40px;" onclick="window.location.href='/main.do';" value="首页"></td>
    		</tr>
    	</table>
    	
      </form>
      </div>
</BODY>

</HTML>