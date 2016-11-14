<#assign sec=JspTaglibs["/WEB-INF/security.tld"] />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>系统设置 - Powered By ${systemConfig.systemName}</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<#include "/WEB-INF/template/common/include.ftl">
<link href="${base}/template/admin/css/input.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
$().ready(function() {

	var $isLoginFailureLockInput = $("input[name='systemConfig.isLoginFailureLock']");
	var $loginFailureLockCountTr = $("#loginFailureLockCountTr");
	var $loginFailureLockTimeTr = $("#loginFailureLockTimeTr");

	var $smtpFromMail = $("input[name='systemConfig.smtpFromMail']");
	var $smtpHost = $("input[name='systemConfig.smtpHost']");
	var $smtpPort = $("input[name='systemConfig.smtpPort']");
	var $smtpUsername = $("input[name='systemConfig.smtpUsername']");
	var $smtpPassword = $("input[name='systemConfig.smtpPassword']");
	var $showSmtpTestWindow = $("#showSmtpTestWindow");
	
	var $sapHost = $("input[name='systemConfig.sapHost']");
	var $sapClient = $("input[name='systemConfig.sapClient']");
	var $sapSysnr = $("input[name='systemConfig.sapSysnr']");
	var $sapUser = $("input[name='systemConfig.sapUser']");
	var $sapPasswd = $("input[name='systemConfig.sapPasswd']");
	var $sapLang = $("input[name='systemConfig.sapLang']");
	var $sapCodePage = $("input[name='systemConfig.sapCodePage']");
	var $showSapTestWindow = $("#showSapTestWindow");
	
	var $pointType = $("input[name='systemConfig.pointType']");
	var $pointScaleTr = $(".pointScaleTr");
	var $pointScale = $("input[name='systemConfig.pointScale']");
	
	$isLoginFailureLockInput.click( function() {
		$this = $(this);
		if($this.val() == "true") {
			$loginFailureLockCountTr.show();
			$loginFailureLockTimeTr.show();
		} else {
			$loginFailureLockCountTr.hide();
			$loginFailureLockTimeTr.hide();
		}
	});
	
	// SMTP测试窗口
	$showSmtpTestWindow.click( function() {
		var windowHtml = '<form id="smtpTestForm" action="mail!ajaxSendSmtpTest.action"><input type="hidden" name="smtpFromMail" class="{required: true, email: true, messages: {required: \'请填写发件人邮箱!\', email: \'发件人邮箱格式错误!\'}}" value="' + $smtpFromMail.val() + '" /><input type="hidden" name="smtpHost" value="' + $smtpHost.val() + '" class="{required: true, messages: {required: \'请填写SMTP服务器地址!\'}}" /><input type="hidden" name="smtpPort" value="' + $smtpPort.val() + '" class="{required: true, digits: true, messages: {required: \'请填写SMTP服务器端口!\', digits: \'SMTP服务器端口必须为零或正整数!\'}}" /><input type="hidden" name="smtpUsername" value="' + $smtpUsername.val() + '" class="{required: true, messages: {required: \'请填写SMTP会员编号!\'}}" /><input type="hidden" name="smtpPassword" value="' + $smtpPassword.val() + '" class="{required: true, messages: {required: \'请填写SMTP密码!\'}}" />收件人邮箱：<input type="text" name="smtpToMail" class="formText {required: true, email: true, messages: {required: \'请填写收件人邮箱!\', email: \'收件人邮箱格式错误!\'}}" /><div class="blank1"></div><p id="smtpTestStatus"></p><div class="blank1"></div><input type="submit" class="formButton" value="测试发送" /></form>';
		$.window("邮箱配置测试", windowHtml);
	});
	
	// 提交测试窗口
	$("#smtpTestForm").livequery("submit", function() {
		
		// 表单验证
		$("#smtpTestForm").validate({
			invalidHandler: function(form, validator) {
				$.each(validator.invalid, function(key, value){
					$.tip(value);
					return false;
				});
			},
			errorPlacement:function(error, element) {},
			submitHandler: function(form) {
				$("#submitButton").attr("disabled", true);
				$("#smtpTestForm").ajaxSubmit({
					dataType: "json",
					beforeSubmit: function(data) {
						$("#smtpTestStatus").html('<span class="loadingIcon">&nbsp;</span>正在发送测试邮件，请稍后...');
					},
					success: function(data) {
						$("#smtpTestStatus").empty();
						$("#submitButton").attr("disabled", false);
						$.closeWindow();
						$.message(data.status, data.message);
					}
				});
			}
		});
	});
	
	// 根据积分获取方式显示/隐藏“积分换算比率”
	$pointType.click( function() {
		$this = $(this);
		if($this.val() == "orderAmount") {
			$pointScale.removeClass("ignoreValidate");
			$pointScaleTr.show();
		} else {
			$pointScale.val("0");
			$pointScale.addClass("ignoreValidate");
			$pointScaleTr.hide();
		}
	});
	
})
</script>
<#if !id??>
	<#assign isAdd = true />
<#else>
	<#assign isEdit = true />
</#if>
<#include "/WEB-INF/template/common/include_adm_top.ftl">
<style>
body{background:#fff;}
</style>
</head>
<body class="no-skin input">
	
<!-- add by welson 0728 -->	
<#include "/WEB-INF/template/admin/admin_navbar.ftl">
<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>
	<#include "/WEB-INF/template/admin/admin_sidebar.ftl">
	<div class="main-content">
	<#include "/WEB-INF/template/admin/admin_acesettingbox.ftl">
	
	<!-- ./ add by welson 0728 -->
	<div class="breadcrumbs" id="breadcrumbs">
		<script type="text/javascript">
			try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
		</script>

		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-home home-icon"></i>
				<a href="admin!index.action">管理中心</a>
			</li>
			<li class="active">系统设置</li>
		</ul><!-- /.breadcrumb -->
	</div>
	 
	<!-- add by welson 0728 -->
	<div class="page-content">
					<div class="page-content-area">					

						<div class="row">
							<div class="col-xs-12">
								<!-- ./ add by welson 0728 -->


	 
		<form id="inputForm" class="validate" class="form" action="system_config!update.action" enctype="multipart/form-data" method="post">
			<div class="blank1"></div>
			<div id="inputtabs">
			<ul>			
				<li>
					<a href="#tabs-3">安全设置</a>
				</li>
				<li>
					<a href="#tabs-5">SAP设置</a>
				</li>
				
			</ul>
			<table id="tabs-3" class="inputTable tabContent">
				<tr>
					<th>
						是否自动锁定账号:
					</th>
					<td>
					
					<label class="pull-left inline">
					    <small class="muted smaller-90">是:</small>
						<input type="radio" name="systemConfig.isLoginFailureLock" class="ace" value="true"<#if (systemConfig.isLoginFailureLock == true)!> checked</#if> />
						<span class="lbl middle"></span>
					</label>
							
					<label class="pull-left inline">

					    <small class="muted smaller-90">否:</small>
						<input type="radio" name="systemConfig.isLoginFailureLock" class="ace" value="false"<#if (systemConfig.isLoginFailureLock == false)!> checked</#if> />
						<span class="lbl middle"></span>
					</label> 
					</td>
				</tr>
				<tr id="loginFailureLockCountTr"<#if systemConfig.isLoginFailureLock == false> class="hidden"</#if>>
					<th>
						连续登录失败最大次数:
					</th>
					<td>
						<input type="text" name="systemConfig.loginFailureLockCount" class="formText {required: true, positiveInteger: true}" value="${(systemConfig.loginFailureLockCount)!}" title="只允许输入正整数,当连续登录失败次数超过设定值时,系统将自动锁定该账号" />
						<label class="requireField">*</label>
					</td>
				</tr>
				<tr id="loginFailureLockTimeTr"<#if systemConfig.isLoginFailureLock == false> class="hidden"</#if>>
					<th>
						自动解锁时间:
					</th>
					<td>
						<input type="text" name="systemConfig.loginFailureLockTime" class="formText {required: true, digits: true}" value="${(systemConfig.loginFailureLockTime)!}" title="只允许输入零或正整数,账号锁定后,自动解除锁定的时间,单位:分钟,0表示永久锁定" />
						<label class="requireField">*</label>
					</td>
				</tr>
			</table>
				
			<table id="tabs-5" class="inputTable tabContent">
				<tr>
					<th>
						SAP服务器:
					</th>
					<td>
						<input type="text" name="systemConfig.sapHost" class="formText " value="${(systemConfig.sapHost)!}" />
					</td>
				</tr>
				<tr>
					<th>
						SAP Client编号:
					</th>
					<td>
						<input type="text" name="systemConfig.sapClient" class="formText" value="${(systemConfig.sapClient)!}" />
					</td>
				</tr>
				<tr>
					<th>
						SAP实例编号:
					</th>
					<td>
						<input type="text" name="systemConfig.sapSysnr" class="formText" value="${(systemConfig.sapSysnr)!}" title="默认端口为01" />
					</td>
				</tr>
				<tr>
					<th>
						SAP登陆用户:
					</th>
					<td>
						<input type="text" name="systemConfig.sapUser" class="formText" value="${(systemConfig.sapUser)!}" />
					</td>
				</tr>
				<tr>
					<th>
						SAP密码:
					</th>
					<td>
						<input type="password" name="systemConfig.sapPasswd" class="formText" title="留空则不进行密码修改" />
					</td>
				</tr>
				<tr>
					<th>
						SAP登陆语言:
					</th>
					<td>
						<input type="text" name="systemConfig.sapLang" class="formText" value="${(systemConfig.sapLang)!}" />
					</td>
				</tr>
				<tr>
					<th>
						SAP页面编码:
					</th>
					<td>
						<input type="text" name="systemConfig.sapCodePage" class="formText" value="${(systemConfig.sapCodePage)!}" />
					</td>
				</tr>
			 	<tr>
					<th>
						SAP配置测试:
					</th>
					<td>
						<input type="button" id="showSapTestWindow" class="formButtonL" value="SAP配置测试" />
					</td>
				</tr> 
			</table>
			</div>
			<div class="buttonArea">
				<input type="submit" class="formButton" value="确  定" hidefocus="true" />&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="button" class="formButton" onclick="window.history.back(); return false;" value="返  回" hidefocus="true" />
			</div>
		</form>
	
<!-- add by welson 0728 -->	
				</div><!-- /.col -->
				</div><!-- /.row -->

				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content-area -->
	<#include "/WEB-INF/template/admin/admin_footer.ftl">
</div><!-- /.page-content -->
				</div><!-- /.main-content -->
	</div><!-- /.main-container -->
	<#include "/WEB-INF/template/common/include_adm_bottom.ftl">	
	<!-- ./ add by welson 0728 -->


</body>
</html>