<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<link href="/css/jiuhui_list.css" rel="stylesheet">
<script src="/js/jquery.js"></script>

<script>
	
function forward(){
  	window.location.href="/main.do?two=4";
  }		
function turnon(){
  	window.location.href="/lubuView.do";
  }		
</script>

</HEAD>
<BODY>
<div class="div" style="padding-top: 60px;">
  		<form name="form">
  	
    	<table class="table_list">
    		<tr style="width:100%;heigth=50%">
    			<td align="middle">
    				返回消息：${type} ${message}
    			</td>
    		</tr>
    		<tr style="width:100%;heigth=20%">
    			<td align="center">
    				<input type="button" class="button" onclick="turnon()" value="继续"/>
  					<input type="button" onclick="forward();"  class="button" value="返回" />
  					<input type="button" class="button" onclick="window.location.href='/main.do';" value="首页">
    			</td>
    		</tr>
    	</table>
    	</form>
    </div>

</BODY>

</HTML>