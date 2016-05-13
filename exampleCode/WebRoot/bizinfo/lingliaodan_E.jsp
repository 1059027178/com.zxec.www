<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="true"%> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%-- <jsp:useBean id="LiangxinUtil" class="com.thinkway.LiangxinUtil" scope="page" /> --%>


<html>

  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <script language="javascript" src="./js/jiuhui.js"></script>
    <title>领料单过账</title>
    
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
  <div>
  <%HttpSession session2 = request.getSession(); %>
  <form name="form" id="form" action="MainServlet?flag=shengchanA" method="post" >
  	<%String type = request.getSession().getAttribute("type") == null ? "" : request.getSession().getAttribute("type").toString();%>
  	<input  id="type1" type="hidden" name="type1" value="<%=type%>"/>
 	<ul>
 		<li class="li" style="margin: 20px 0px 0px 30px;line-height:20px;">
 				返回消息：
 		</li>
 		<li class="li" style="margin: 0px 0px 0px 30px;line-height:30px;">
 			<br>
 			<%=request.getSession().getAttribute("message") == null ? "" : request.getSession().getAttribute("message").toString().trim()%>
			<%session2.invalidate(); request.getSession().invalidate();%>
		</li>
 		<li class="li" style="margin: 20px 0px 0px 0px;">
 			<input type="button"  onclick="submit1(this)" style="width:40px;height:25px;" class="button" value="继续" />
 			<input type="button" onclick="forward();"  style="width:40px;height:25px;" class="button" value="返回" />
 			<input type="button"  style="width:40px;height:25px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
 		</li>
 	</ul>
    </form>
   </div>
 </body>

</html>
 