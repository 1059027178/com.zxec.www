<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="true"%> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%-- <jsp:useBean id="LiangxinUtil" class="com.thinkway.LiangxinUtil" scope="page" /> --%>


<html>

  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <script language="javascript" src="./js/jiuhui.js"></script>
    <title>物料凭证创建</title>
    
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
  		window.location.href="MainServlet?flag=2";
  	}
  	function submit1(obj){
  		obj.disabled=false;
  		document.form.submit();
  	}
  </script>
  <body>
  <div style="margin-top:70px;">
  <%HttpSession session2 = request.getSession(); %>
  <form action="MainServlet?flag=3.4" method="post" name="form">
  	<%-- <input name="matnr"  type="hidden" value="<%=request.getSession().getAttribute("matnr") == null ? "" : request.getSession().getAttribute("matnr")%>" />
 	
 	<input name="num1"  type="hidden" value="<%=session2.getAttribute("num1") == null ? "" : session2.getAttribute("num1")%>" />
 	<input name="num2"  type="hidden" value="<%=session2.getAttribute("num2") == null ? "" : session2.getAttribute("num2")%>" />
 	<input name="num3"  type="hidden" value="<%=session2.getAttribute("num3") == null ? "" : session2.getAttribute("num3")%>" /> --%>
 	<ul style="margin-top:20px;">
 		<li class="li" style="line-height: 25px;">
 				返回消息：
 		</li>
 		<li class="li" style="line-height: 25px;">
 			<%=request.getSession().getAttribute("message") == null ? "" : request.getSession().getAttribute("message").toString().trim()%>
			<%-- <%session2.invalidate(); %> --%>
		</li>
 		<li class="li" style="line-height: 25px;margin-left: -25px;">
 			<input type="button" onclick="submit1(this);"  style="width:60px;height:25px;margin-top:20px;" class="button" value="记账变更" />
 			<input type="button" onclick="window.location.href='MainServlet?flag=shengchanB';"  style="height:25px;" class="button" value="继续" />
 			<input type="button" onclick="forward();"  style="width:40px;height:25px;" class="button" value="返回" />
 			<input type="button"  style="width:40px;height:25px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
 		</li>
 	</ul>
    </form>
   </div>
 </body>

</html>
 