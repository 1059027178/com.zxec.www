<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<!-- Le styles -->
<style type="text/css">
    body {
      padding-top: 70px;
      padding-bottom: 0px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
  <script langth="javascript">
  function keyDown() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      if(keycode=='114'){
      	window.location.href='/logout.do';
      }
   }
   document.onkeydown = keyDown;
   
  	function choose(){
  		var choose=document.getElementById("choose").value;
  		if(choose.length==0){
	  		alert("未选择,请选择");
	  		return;
  		}	 
  		document.thinkway.submit();
  	}
  </script>
</HEAD>
<BODY>	
<from name="thinkway" id="thinkway" action="/main.do">
<table   class="table_border">
  	<tr>
  	<td>
    	<input  class=button type="button" style="width:200px" onclick="window.location.href='/receiptAdd.do';" value="1.生产订单收货">
    </td>
    </tr>
    <tr>
    <td>
    	<input  class=button type="button" style="width:200px" onclick="window.location.href='/groundingAdd.do';" value="2.上架">
    </td>
    </tr>
    <tr>
  	<td>
    	<input  class=button type="button" style="width:200px" onclick="window.location.href='/reversalAdd.do';" value="3.生产订单冲销">
    </td>
    </tr>
    <tr>
    <td>
    	<input  class=button type="button" style="width:95px;heigth:20px" onclick="window.location.href='/logout.do';" value="退出">
    	<input  class=button type="button" style="width:95px;heigth:20px" onclick="window.location.href='/main.do';" value="返回">
    </td>
    </tr>
    </table>
</from>
 

</BODY>

</HTML>