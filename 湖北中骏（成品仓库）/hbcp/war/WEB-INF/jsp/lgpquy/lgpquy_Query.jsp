<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<script language="javascript" src="/js/jiuhui.js"></script>
<script type="text/javascript">
function lgpQuy(){
	var lgpla=document.getElementById("lgpla").value;
  	if(lgpla.length==0){
  		alert("��λ��Ϊ�գ��޷���ѯ");
  		return;
  	}	 
  	var lgnum=document.getElementById("lgnum").value;
  	if(lgnum.length==0){
  		alert("�ֿ�Ϊ�գ��޷���ѯ");
  		return;
  	}	
	document.jiuhui.submit();
}
function reset(){
	document.getElementById("lgpla").value=""; 
	document.getElementById("lgnum").value=""; 
}
</script>

  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    
    <title>��λ��ѯ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form name="jiuhui"  id="jiuhui" action="/lgpquyList.do">
    	<div style=" padding-top: 70px;">
    	<ul>
    	<li class="li"></li>
    		<li class="li">
    			��λ�ţ�<input style="width:60%" type="text" id="lgpla" name="lgpla"  value=""/>
    		</li>
    		<li class="li">
    			�ֿ�ţ�<input style="width:60%" type="text" id="lgnum" name="lgnum"  value="320"/>
    		</li>
    		<li class="li"></li>
    			<li class="li" align="left">
    				<input  class="button"  type="button" style="width:20%;margin-left: -30px;"  onclick="lgpQuy()" value="��ѯ">
    				<input  class="button"  type="button" style="width:20%"  onclick="reset();" value="���">
    				<input  class="button"  type="button" style="width:20%"  onclick="window.location.href='/main.do?two=5';" value="����">
    				<input  class=button type="button" style="width:20%" onclick="window.location.href='/main.do';" value="��ҳ">
    		</li>
    	</ul>
    </form>
    
  </body>
 <script type="text/javascript">
  document.getElementById("lgpla").focus();
  </script>
</html>
