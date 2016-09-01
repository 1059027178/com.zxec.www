<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>

<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="1;url=/">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<!-- Le styles -->
<style type="text/css">
    body {
      padding-top: 60px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
</HEAD>
<BODY>
   <!--.当前位置导航-->
		  
		  <div class="row-fluid">
		     <ul class="breadcrumb">
			  <li>
				当前位置：<span><i class="icon-home"></i> <a href="/main.do?showType=main">首页</a></span> 
			  </li>
			</ul>
		  </div>	
<from>
<table>
  	<tr>
  	<td>
    	<button class=button  onclick="window.location.href='/receiptAdd.do';">生产订单收货</button>
    </td>
    </tr>
    </table>
</from>
 
	
<%@ include file="include/footer.jsp"%>
	 

</BODY>

</HTML>