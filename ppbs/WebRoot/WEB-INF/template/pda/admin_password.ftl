<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    

    <title>修改密码</title>
    <meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<script src='/template/pda/js/jquery-1.9.1.min.js'></script>
	<script src='/template/pda/js/manage/admin_password.js'></script>
	<link href="/template/pda/css/jiuhui.css" rel="stylesheet" />
	</head>
	<body>
	<form name="inputForm" id="inputForm">
  <table class="table_border">
		<tr>
			<td align="center">	用&nbsp;户&nbsp;名：${admin.username}
			<input type="hidden" name="admin.username" value="${admin.username}"></td>
		</tr>
		<tr>
			<td  align="center">用户新密码：<input name="admin.password" type="text"  id="inputPassword"  style="width:90px;background-color:white;"class="text"></td>
		</tr>
		<tr>
			<td  align="center">重复新密码：<input name="inputPasswordAg"class="text"  type="text"  style="width:90px;background-color:white;" id="inputPasswordAg"></td>
		</tr>
		  	<tr align="center">
		  	<td >
		    	<input type="button" id="saveButton" valign="center" style="width:40px;height:25px;" class="button"  value="确定"/>
  			<input type="button"  id="indexButton" class="button" style="width:40px;height:25px;" onclick="window.location.href='/pda/menu!first.action';" value="首页"></li>
		    </td>
		    </tr>
		    </table>
		</form>
</body>
</html>