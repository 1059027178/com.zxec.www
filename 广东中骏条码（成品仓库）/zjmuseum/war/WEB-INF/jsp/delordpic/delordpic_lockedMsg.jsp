<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<%@ include file="../include/const.jsp"%>
<jsp:useBean id="SapUtil" class="com.thinkway.SapUtil" scope="page" />


<html>
<script type="text/javascript">
function jixu(){
	location='/delordList.do'
}
</script>

  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
 
    <title>交货单拣配</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   <script language="javascript" src="/js/jiuhui_list.css"></script>
  </head>
  <script type="text/javascript">
  	function goon(){
  		document.form.action="/delordList.do";
  		document.form.submit();
  	}
  	function backon(){
  		<c:if test="${shuliang>0}">
  		document.form.action="/matlgpfifoView.do";
  		</c:if>
  		<c:if test="${shuliang==0}">
  		document.form.action="/delordView.do";
  		</c:if>
  		<c:if test="${shuliang<0}">
  		document.form.action="/delordList.do";
  		</c:if>
  		document.form.submit();
  	}
  </script>
  <body>
  		<div class="div" style="padding-top: 60px;">
  		<form name="form">
  		<input type="hidden" name="posnr" value="${posnr}"/>
  		<input type="hidden" name="maktx" value="${maktx}"/>
  		<input type="hidden" name="matnr" value="${matnr}"/>
  		<input type="hidden" name="posnr" value="${posnr}"/>
  		<input type="hidden" name="lfimg" value="${shuliang}"/>
  		<input type="hidden" name="vbeln" value="${vbeln}"/>
  		<input type="hidden" name="wadat" style="width:70%"  id="wadat" value="${wadat }"/>
		<input type="hidden" name="lgort" style="width:70%"  id="lgort" value="${lgort }"/>
		<input type="hidden" name="werks" style="width:70%"  id="werks" value="${werks }"/>
    	<table class="table_list">
    		<tr>
    			<td style="height：60px;">&nbsp;</td>
    		</tr>
    		<tr style="width:100%;heigth=50%">
    			<td align="middle">
    			${lockeduser}
    				返回消息：${type} ${message}${lockeduser.userName}${message1}
    			</td>
    		</tr>
    		<tr style="width:100%;heigth=20%">
    			<td align="center">
    				<input type="button" style="width:40px;" onclick="goon()" value="返回">
    				<input type="button" style="width:40px;" onclick="backon()" value="继续">
    				<input  type="button" style="width:40px;"  onclick="window.location.href='/main.do';" value="首页">
    			</td>
    		</tr>
    	</table>
    	</form>
    </div>
  </body>
</html>
 