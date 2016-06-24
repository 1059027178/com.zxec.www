

$().ready( function() {

	
	// 刷新验证码图片
	function registerWindowCaptchaImageRefresh() {
		$("#registerWindowCaptchaImage").attr("src", "/captcha.jpg?timestamp" + (new Date()).valueOf());
	}
	
	// 点击刷新验证码图片
	$("#registerWindowCaptchaImage").click( function() {
		registerWindowCaptchaImageRefresh();
	});

});