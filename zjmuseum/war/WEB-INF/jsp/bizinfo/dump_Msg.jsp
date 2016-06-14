<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<%@ include file="../include/const.jsp"%>
<jsp:useBean id="SapUtil" class="com.thinkway.SapUtil" scope="page" />
<%			
	String radio = SapUtil.null2String((String)request.getAttribute("radio"));//物料编码 
	System.out.println(radio);
%>

<html>


  <head>
 
    <script language="javascript" src="/js/jiuhui.js"></script>
    <title>转储</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	 <LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>

  </head>
  <script type="text/javascript">
  	function zhuangcu(){
  		document.form.action="/dumpCheck.do";
  		document.form.submit();
  	}
  	function shangjia(){
  		document.form.action="/groundingAdd.do";
  		document.form.submit();
  	}
	function jixu(){
		location='/delordList.do'
	}
</script>
  <body style="background-color:#CDCED2;">
  		<div style="margin-top:60px;">
  		<form name="form">
  		<input type="hidden" name="posnr" value="${posnr}"/>
  		<input type="hidden" name="maktx" value="${maktx}"/>
  		<input type="hidden" name="matnr" value="${matnr}"/>
  		<input type="hidden" name="posnr" value="${posnr}"/>
  		<input type="hidden" name="lfimg" value="${shuliang}"/>
  		<input type="hidden" name="vbeln" value="${vbeln}"/>
  		<input type="hidden" name="meins" value="${meins}"/>
  		<input type="hidden" name="charg" value="${charg}"/>
  		<input type="hidden" name="xzsl" value="${xzsl}"/>
  		<input type="hidden" name="wadat" style="width:70%"  id="wadat" value="${wadat }"/>
		<input type="hidden" name="lgort" style="width:70%"  id="lgort" value="${lgort }"/>
		<input type="hidden" name="werks" style="width:70%"  id="werks" value="${werks }"/>
		<input type="hidden" name="radio" style="width:70%"  id="radio" value="2"/>
    	<table class="table_list">
    		<tr style="width:100%;heigth:50%">
    			<td align="middle">
    				返回消息：${type} ${message}
    			</td>
    		</tr>
    		<tr style="width:100%;heigth:20%">
    			<td align="center"><%-- <%if(radio.equals("1")){ %> --%>
    				<%-- <input type="button" style="width:40px;" onclick="zhuangcu();" value="转储"><%}else{ %> --%>
    				<input type="button" style="width:40px;" onclick="" value="下架"><%-- <%} %> --%>
    				<input type="button" style="width:40px;" onclick="window.location.href='/dumpView.do';"  value="返回">
    				<input type="button" style="width:40px;height:25px;" onclick="window.location.href='/main.do';" value="首页">
    			</td>
    		</tr>
    	</table>
    	</form>
    	</div>
  </body>
</html>
 