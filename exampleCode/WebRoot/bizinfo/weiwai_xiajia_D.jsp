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
  <div style="margin-left:-30px;">
  <form action="MainServlet?flag=2.3" method="post" name="form">
 	<ul>
 		<li class="li" style="margin: 20px 0px 0px 30px;line-height:30px;">
 				返回消息：
 		</li>
 		<li class="li" style="margin: 0px 0px 0px 30px;line-height:30px;">
 			<%=request.getSession().getAttribute("message") == null ? "" : request.getSession().getAttribute("message").toString().trim()%>
		</li>
 		<li class="li" style="margin: 20px 0px 0px 0px;">
 			<input type="button" onclick="submit1(this);"  style="width:40px;height:25px;" class="button" value="继续" />
 			<input type="button" onclick="forward();"  style="width:40px;height:25px;" class="button" value="返回" />
 			<input type="button"  style="width:40px;height:25px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
 		</li>
 	</ul>
    </form>
   </div>
 </body>

</html>
 