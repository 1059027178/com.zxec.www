<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<LINK href="./css/jiuhui.css" type="text/css" rel="STYLESHEET"/>

<!-- Le styles -->
<style type="text/css">
    body {
      padding-top: 60px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
  

<script src="./js/md5.js"></script>
<script src="./js/jquery.js"></script>  
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script> 

<script>

function handleForm(){
   if($('#userBH').val()==""){
  	alert("用户账号必须输入！");
  	$('#userBH').focus();
  	return false;
  }
   if($('#password').val()==""){
  	alert("密码必须输入！");
  	$('#password').focus();
  	return false;
  }
  //MD5客户端加密
  $('#password').val(calcMD5($('#password').val()));  
  return true;
}
</script>
   
</HEAD>
<BODY style="width:240px;">

<form   class="form-vertical" action="MainServlet?flag=login" method="post" onSubMit="return handleForm();">   
<!-- <form   class="form-vertical" action="MainServlet?flag=login" method="post" >   -->
  <table style="width:240px;border:1px;">

     <tr>
     <td>账号<font color='red'>*</font>：</td>
     	<td >
				<input name="userBH" type="text" style="width:130px;"  id="userBH"> </input>
		</td>
	</tr>
		<tr>
		<td>密码<font color='red'>*</font>：</td>
     	<td><input name="password" type="password" style="width:130px;" id="password"/></td>
 </tr>
 <!--  
<div class="control-group">
 <div class="controls">
 <input type="checkbox" name="yes" value="remUser">&nbsp;两周内不再登录
<input type="hidden" name="referUrl" value="${referUrl}"/>
 </div>             
</div>-->
<tr>
<td>
<input class="button" type="submit" value="登 录"/>
</td>
</tr>
<!--  
  <a href="#" class="btn btn-warning" id="fgtpwd">忘记密码</a> -->
</table>
</form>

</BODY>
    <script type="text/javascript">
  document.getElementById("userBH").focus();
  </script>
</HTML>