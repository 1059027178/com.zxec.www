<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="true"%> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%-- <jsp:useBean id="LiangxinUtil" class="com.thinkway.LiangxinUtil" scope="page" /> --%>


<html>

  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <script language="javascript" src="./js/jiuhui.js"></script>
    <title>PO收货冲销</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<link href="./css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  	function forward(){
  		window.location.href="MainServlet?flag=1.3";
  	}
  	function submit1(obj){
  		obj.disabled=false;
  		document.form.submit();
  	}
  </script>
  <body>
  <div>
  <form action="MainServlet?flag=2.4" method="post" name="form">
	<input name="aufnr"          type="hidden" value="<%=request.getSession().getAttribute("aufnr") == null ? "" : request.getSession().getAttribute("aufnr")%>" />
	<input name="lineItem" 	     type="hidden" value="<%=request.getSession().getAttribute("lineItem") == null ? "" : request.getSession().getAttribute("lineItem")%>" />
	<input name="boxs" 	         type="hidden" value="<%=request.getSession().getAttribute("boxs")	== null ? "" : request.getSession().getAttribute("boxs")%>" />
	<input name="wemng"          type="hidden" value="<%=request.getSession().getAttribute("wemng")	== null ? "" : request.getSession().getAttribute("wemng")%>"	/>
	<input name="str" 	   	     type="hidden" value="<%=request.getSession().getAttribute("str") 	== null ? "" : request.getSession().getAttribute("str")%>" />
	<input name="matnr" 	     type="hidden" value="<%=request.getSession().getAttribute("matnr")== null ? "" : request.getSession().getAttribute("matnr") 	%>" />
	<input name="maktx" 	   	 type="hidden" value="<%=request.getSession().getAttribute("maktx")== null ? "" : request.getSession().getAttribute("maktx") 	%>" />
	<input name="everyBagNumber" type="hidden" value="<%=request.getSession().getAttribute("everyBagNumber")== null ? "" : request.getSession().getAttribute("everyBagNumber") 	%>" />
	<input name="batchNo" 	   	 type="hidden" value="<%=request.getSession().getAttribute("batchNo")== null ? "" : request.getSession().getAttribute("batchNo") %>" />
	<input name="lgort" 	     type="hidden" value="<%=request.getSession().getAttribute("lgort")== null ? "" : request.getSession().getAttribute("lgort") 	%>" />
	<input name="unit" 	   		 type="hidden" value="<%=request.getSession().getAttribute("unit")== null ? "" : request.getSession().getAttribute("unit") 	%>" />
  
 	<ul>
 		<li class="li" style="margin: 20px 0px 0px 30px;line-height:30px;">
 				返回消息：
 		</li>
 		<li class="li" style="margin: 0px 0px 0px 30px;line-height:30px;">
 			<%=request.getSession().getAttribute("message") == null ? "" : request.getSession().getAttribute("message").toString().trim()%>
 			<br>
 			<%=request.getSession().getAttribute("type") == null ? "" : request.getSession().getAttribute("type").toString().trim()%>
		</li>
 		<li class="li" style="margin: 20px 0px 0px 0px;">
 			<input type="button" onclick="submit1(this);"  style="width:40px;height:25px;" class="button" value="下架" />
 			<input type="button" onclick="forward();"  style="width:40px;height:25px;" class="button" value="返回" />
 			<input type="button"  style="width:40px;height:25px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
 		</li>
 	</ul>
    </form>
   </div>
 </body>

</html>
 