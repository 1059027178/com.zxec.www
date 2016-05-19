<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>主页</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<!-- Le styles -->
<style type="text/css">
    body {
      padding-top: 40px;
      padding-bottom: 0px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
  <LINK href="./css/jiuhui.css" type="text/css" rel="STYLESHEET"/>
  <!-- <script langth="javascript">
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
  </script> -->
</HEAD>
<BODY>	
<form name="thinkway" id="thinkway" action="MainServlet" method="post">
<table class="table_border">
  	<tr>
  	<td >
    	<input  class="button"  style="width:200px" type="button"  onclick="window.location.href='MainServlet?flag=1';" value="1.收货"/>
    </td>
    </tr>
    <tr>
    <td >
    	<input  class="button"  style="width:200px" type="button"  onclick="window.location.href='MainServlet?flag=2';" value="2.发货"/>
    </td>
    </tr>
    <tr>
    <td >
    	<input  class="button" style="width:200px" type="button"  onclick="window.location.href='MainServlet?flag=3';" value="3.仓库作业"/>
     </td>
    </tr>
    <tr>
    <td >
    	<input  class="button" style="width:200px" type="button"  onclick="window.location.href='MainServlet?flag=4';" value="4.查询"/>
     </td>
    </tr>
    <tr>
    <td >
    	<input  class="button" style="width:70px" type="button" onclick="window.location.href='MainServlet?flag=exit';" value="退出" />
    	<input  class="button" style="width:100px" type="button" onclick="window.location.href='MainServlet?flag=useredit';" value="修改密码" />
     </td>
    </tr>
    </table>
</form>
	 

</BODY>

</html>