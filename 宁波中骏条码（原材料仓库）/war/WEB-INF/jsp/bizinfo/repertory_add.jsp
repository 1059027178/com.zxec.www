<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<style type="text/css">
    body {
      padding-top: 50px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 0;
    }

  </style>
  <head>
    <base href="<%=basePath%>">
    
    <title>仓位冻结</title>
    
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
	/* function keyDown() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("按键码: " + keycode + " 字符: " + realkey);
       if(keycode=='13'){
       		getNlpla();
       }
   }
   document.onkeydown = keyDown; */
 function submit1(obj){
  	
  	obj.disabled=false;
  	document.form.submit();
  }
  function forward(){
  	window.location.href="/main.do?two=4";
  }
	</script>
  </head>
  
  <body>
  <form name="form" action="/repertoryView.do">
  <div>
    
	<ul>
     	<li class="li">仓位号:<input name="nlpla" class="text" style="background-color:white;" type="text"  id="nlpla" />
		</li>
		<li class="li" >仓库号:<input name="lgnum" style="background-color:white;" class="text" type="text"  id="lgnum" value="311" />
		</li>
     	<li class="li"><input name="radio" style="width:20px;" checked=checked type="radio" id="radio1" value="1">出入库冻结</input>
     	</li>
     	<li class="li"><input name="radio" style="width:20px;" type="radio" id="radio2" value="2" >出入库解冻</input>
     	</li>
     	<li class="li"><input name="radio" style="width:20px;" type="radio" id="radio3" value="3" >查看所有冻结仓位</input>
     	</li>
     	<li class="li" style="height:10px;"></li>
		<li class="li">
		<input class="button" type="button" onclick="submit1(this)" value="确定" style="margin-left:-10px;">
		<input  class="button" type="button" onclick="forward()" value="返回">
		<input   type="button" class="button" onclick="window.location.href='/main.do';" value="首页">
		</li>
</tr>

</table>
</div>
</form>
  </body>
   <script type="text/javascript">
  document.getElementById("nlpla").focus();
  </script>
</html>
