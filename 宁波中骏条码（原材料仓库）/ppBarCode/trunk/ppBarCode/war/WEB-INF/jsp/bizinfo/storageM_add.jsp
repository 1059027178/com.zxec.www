<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<style type="text/css">
    body {
      padding-top: 40px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
  <head>
    <base href="<%=basePath%>">
    
    <title>仓位转移</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<script src="/js/jquery.js"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="/css/jiuhui.css" rel="stylesheet">
	<script type="text/javascript">
		 function submit1(obj){
  	
		  	obj.disabled=false;
		  	document.form.submit();
		  }
		  function forward(){
		  	window.location.href="/storageMView.do";//history.go(-1);
		  }
	</script>
  </head>
  
  <body>
  <form name="form" action="/storageMEdit.do">
  	<input name="sonum" type="hidden" value="${repObj.sonum}"/>
	<input name="lgort" type="hidden" value="${repObj.lgort}"/>
	<input name="werks" type="hidden" value="${repObj.werks}"/>
	<input name="sobkz" type="hidden" value="${repObj.sobkz}"/>
	<input name="meins" type="hidden" value="${repObj.meins}"/>
	<input name="lgnum" type="hidden" value="${lgnum}"/>
	<input name="lgtyp" type="hidden" value="${repObj.letyp}"/>
  <div>
     
     <ul>
     	<li class="li" >源<span style="margin-left:14px;"></span>仓位：<input name="lgpla" class="text" readonly= readonly type="text"  id="lgpla" value="${lgpla }"> </input>
			

		</li>
		<li class="li">物料编号：<input name="matnr" class="text" readonly= readonly type="text"  id="mtnr" value="${repObj.matnr }"> </input>
		</li>
		<li class="li" >批<span style="margin-left:28px;"></span>次：<input name="charg" class="text" readonly= readonly type="text"  id="charg" value="${repObj.charg }"> 
		</li>
     	<li class="li" >参考数量：<input name="gesme" class="text1" readonly= readonly type="text"  id="gesme" value="${repObj.gesme }"/>
			<input name="meinh" value="${repObj.meins}" class="text2" style="width:29px;background-color:#D8D8D8;" type="text"  id="meinh"> 
		</li>
     	<li class="li" >转移数量：<input name="verme" type="text" class="text1"  id="verme" style="background-color:white;" value="${repObj.gesme }">
			<input name="meins" value="${repObj.meins}" style="width:29px;background-color:#D8D8D8;" class="text2" type="text"  id="meins"> 
		</li>
     	<li class="li">目的仓位：<input name="nlpla" type="text" class="text" style="background-color:white;" id="nlpla" value="${nlpla }"/>
		</li>
	
		<li class= "li" style="margin-top:10px;"></li>
  		<li class="li">
  		<span style="margin-left:-30px;"></span>
		<input class="button" type="button" onclick="submit1(this)" value="确定">
		
		<input class="button" type="button" onclick="forward()" value="返回">
		<input   type="button" class="button" onclick="window.location.href='/main.do';" value="首页">
		</li>
	</ul>

</div>
</form>
  </body>
</html>
