<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>查询</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Le styles -->
<style type="text/css">
    body {
      padding-top: 40px;
      padding-bottom: 0px;
    }
    .sidebar-nav {
      padding: 0;
    }
     .table_border td{
	    border-top:1px #DDD solid;
	    border-right:1px #DDD solid;
    }
	.table_border{
		border-bottom:1px #DDD solid;
		border-left:1px #DDD solid;
		background-color:#CCCCFF;
	}
  </style>
  <LINK href="./css/jiuhui.css" type="text/css" rel="STYLESHEET"/>
  <script langth="javascript">
  function keyDown() {
       var keyCode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
       //alert("按键码: " + keycode + " 字符: " + realkey);
       return realkey;
   }
   
   document.onkeydown = keyDown;
   
  	function choose(){
  		var choose=document.getElementById("choose").value;
  		if(choose.length==0){
	  		alert("选择为空,请选择");
	  		return;
  		}	 
  		document.thinkway.submit();
  	}
  </script>
</HEAD>
<BODY>	
<form name="thinkway" id="thinkway" action="MainServlet" method="post">
<table style="width:100%" class="table_border">
  	<tr>
  	<td>
    	<input  class=button type="button" style="width:200px" onclick="window.location.href='MainServlet?flag=4.1';" value="4.1 物料查询" />
     </td>
    </tr>
    <tr>
    <td>
    	<input  class=button type="button" style="width:200px" onclick="window.location.href='MainServlet?flag=4.2';" value="4.2 仓位查询" />
     </td>
    </tr>
   <!--  <tr>
    <td>
    	<input  class=button type="button" style="width:200px" onclick="window.location.href='MainServlet?flag=4.3';" value="4.3 库存查询" />
     </td>
    </tr>
    <tr>
    <td>
    	<input  class=button type="button" style="width:200px" onclick="window.location.href='MainServlet?flag=4.4';" value="4.4 转储单查询" />
    </td>
    </tr> -->
    <tr>
    <td>
    	<input  class=button type="button" style="width:95px;heigth:20px" onclick="window.location.href='MainServlet?flag=exit';" value="退出" />
    	<input  class=button type="button" style="width:95px;heigth:20px" onclick="window.location.href='MainServlet?flag=return';" value="返回" />
    </td>
    </tr>
    </table>
</form>
 
	 

</BODY>

</HTML>