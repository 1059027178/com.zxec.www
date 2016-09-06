<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="true"%> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<jsp:useBean id="LiangxinUtil" class="com.thinkway.LiangxinUtil" scope="page" />


<html>

  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    <script language="javascript" src="/js/jiuhui.js"></script>
    <title>物料凭证创建</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<link href="/css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  	function forward(){
  	window.location.href="/reversalAdd.do";
  }
  </script>
  <body>
  <div>
  <form action="/groundingAdd.do">
   <input name="matnr" type="hidden" value="<c:out value='${receiptObj.matnr}'/>"/>
	<input name="meins" type="hidden" value="<c:out value='${receiptObj.meins}'/>"/>
	<input name="wemng" type="hidden" value="<c:out value='${receiptObj.wemng}'/>"/>
	<input name="sobkz" type="hidden" value="<c:out value='${receiptObj.sobkz}'/>"/>
	<input name="lgort" type="hidden" value="<c:out value='${receiptObj.lgort}'/>"/>
	<input name="charg" type="hidden" value="<c:out value='${receiptObj.charg}'/>"/>
	<input name="meng" type="hidden" value="<c:out value='${receiptObj.meng}'/>"/>
	<input name="boxs" type="hidden" value="<c:out value='${receiptObj.boxs}'/>"/>
	<input name="maktx" type="hidden" value="<c:out value='${receiptObj.maktx}'/>"/>
	<input name="sonum" type="hidden" value="<c:out value='${receiptObj.sonum}'/>"/>
	<input name="aufnr" type="hidden" value="<c:out value='${receiptObj.aufnr}'/>"/>
  		<ul>
  			<li class="li" style="line-height:30px;">
  				返回消息：<c:out value="${type}"/>
  				
			
  			</li>
  			<li class="li" style="margin: 20px 0px 0px 0px;line-height:30px;"><c:out value="${message}"/></li>
  		
  			<li class="li" style="margin: 20px 0px 0px 0px;">
  			<input type="button" onclick="forward();"  style="width:40px;height:25px;" class="button" value="返回" />
  			<input type="button"  style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页"></li>
  		</ul>
      </form>
      </div>
  </body>

</html>
 