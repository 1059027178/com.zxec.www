<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HEAD>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<link href="${base}/template/pda/css/jiuhui.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="${base}/template/common/js/jquery-1.9.1.min.js"></script>
<script>
	function handleForm() {
		if ($('#userBH').val() == "") {
			//alert("用户账号必须输入！");
			$('#userBH').focus();
			return false;
		}
		if ($('#password').val() == "") {
			//alert("密码必须输入！");
			$('#password').focus();
			return false;
		}
		return true;
	}
</script>

</HEAD>
<BODY style="text-align: center">
	<div class="logo_img"  style=" MARGIN-RIGHT: auto;MARGIN-LEFT: auto;"></div>
	<form action="${base}/admin/loginVerify" method="post"
		onSubMit="return handleForm();" class="login_form">
		<label>账号</label><input name="j_username" type="text" id="userBH"><br>
		<label>密码</label><input name="j_password" type="password"
			id="password"><br> <input type="submit" value="登录"
			class="button">
	</form>
</BODY>
<script type="text/javascript">
	document.getElementById("userBH").focus();
	<#if (actionErrors?size > 0)>
		alert("<#list errorMessages as list>${list}\n</#list>");
	</#if>

</script>
</HTML>