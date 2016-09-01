

$().ready( function() {

	
	
	// 刷新验证码图片
	function loginWindowCaptchaImageRefresh() {
		$("#loginWindowCaptchaImage").attr("src",  "/captcha.jpg?timestamp" + (new Date()).valueOf());
	}
	
	// 点击刷新验证码图片
	$("#loginWindowCaptchaImage").click( function() {
		loginWindowCaptchaImageRefresh();
	});
	
	// 刷新验证码图片
	function loginCaptchaImageRefresh() {
		$("#loginCaptchaImage").attr("src",  "/captcha.jpg?timestamp" + (new Date()).valueOf());
	}
	
	// 点击刷新验证码图片
	$("#loginCaptchaImage").click( function() {
		loginCaptchaImageRefresh();
	});
	
	// 表单验证
	$("#loginForm").submit(function() {
		if ($("#loginUsername").val() == "") {
			$.message("请输入您的用户名!");
			return false;
		}
		if ($("#loginPassword").val() == "") {
			$.message("请输入您的密码!");
			return false;
		}
		if ($("#loginCaptcha").val() == "") {
			$.message("请输入您的验证码!");
			return false;
		}
	})

});