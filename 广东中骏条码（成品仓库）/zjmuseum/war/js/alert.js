// 自定义Alert,Confirm 弹出框及其回调函数
(function() {

	var $focused = null;

	$.MsgBox = {
		Alert : function(title, msg, callback) {
			$focused = $(':focus');
//			$focused.attr("disabled", true);
			GenerateHtml("alert", title, msg);
			btnOk(callback);
			btnNo();
		},
		Confirm : function(title, msg, callback) {
			$focused = $(':focus');
//			$focused.attr("disabled", true);
			GenerateHtml("confirm", title, msg);
			btnOk(callback);
			btnNo();
		}
	}

	// 生成Html
	var GenerateHtml = function(type, title, msg) {

		var _html = "";

		_html += '<div id="mb_box"></div><div id="mb_con"><span id="mb_tit">' + title + '</span>';
		_html += '<a id="mb_ico">x</a><div id="mb_msg">' + msg + '</div><div id="mb_btnbox">';

		if (type == "alert") {
			_html += '<input id="mb_btn_ok" type="button" value="确定" />';
		}
		if (type == "confirm") {
			_html += '<input id="mb_btn_ok" type="button" value="确定" />';
			_html += '<input id="mb_btn_no" type="button" value="取消" />';
		}
		_html += '</div></div>';

		// 必须先将_html添加到body，再设置Css样式
		$("body").append(_html);
		GenerateCss();
	}

	// 生成Css
	var GenerateCss = function() {

		$("#mb_box").css({
			width : '100%',
			height : '100%',
			zIndex : '999',
			position : 'absolute',
			filter : 'Alpha(opacity=60)',
			backgroundColor : 'black',
			top : '0',
			left : '0',
			opacity : '0.6'
		});

		$("#mb_con").css({
			zIndex : '999999',
			width : '200%',
			position : 'absolute',
			backgroundColor : 'White',
			borderRadius : '15px'
		});

		$("#mb_tit").css({
			display : 'block',
			fontSize : '10px',
			color : '#444',
			padding : '10px 15px',
			backgroundColor : '#DDD',
			borderRadius : '15px 15px 0 0',
			borderBottom : '3px solid #009BFE',
			fontWeight : 'bold'
		});

		$("#mb_msg").css({
			padding : '10px',
			lineHeight : '10px',
			borderBottom : '1px dashed #DDD',
			fontSize : '12px'
		});

		$("#mb_ico").css({
			display : 'block',
			position : 'absolute',
			right : '10px',
			top : '9px',
			border : '1px solid Gray',
			width : '18px',
			height : '18px',
			textAlign : 'center',
			lineHeight : '16px',
			cursor : 'pointer',
			borderRadius : '12px',
			fontFamily : '微软雅黑'
		});

		$("#mb_btnbox").css({
			margin : '6px 0 6px 0',
			textAlign : 'center'
		});
		$("#mb_btn_ok,#mb_btn_no").css({
			width : '65px',
			height : '22px',
			color : 'white',
			border : 'none',
			fontSize : '10px'
		});
		$("#mb_btn_ok").css({
			backgroundColor : '#168bbb'
		});
		$("#mb_btn_no").css({
			backgroundColor : 'gray',
			marginLeft : '20px'
		});

		// 右上角关闭按钮hover样式
		$("#mb_ico").hover(function() {
			$(this).css({
				backgroundColor : 'Red',
				color : 'White'
			});
		}, function() {
			$(this).css({
				backgroundColor : '#DDD',
				color : 'black'
			});
		});

		var _widht = document.documentElement.clientWidth; // 屏幕宽
		var _height = document.documentElement.clientHeight; // 屏幕高

		var boxWidth = $("#mb_con").width();
		var boxHeight = $("#mb_con").height();

		// 让提示框居中
		$("#mb_con").css({
			top : "50px",
			left : "11%"
		});
	};

	// 确定按钮事件
	var btnOk = function(callback) {
		$("#mb_btn_ok").click(function() {
			$("#mb_box,#mb_con").remove();
			if (typeof (callback) == 'function') {
				callback();
			}
			$focused.attr("disabled", false);
			$focused.focus();
		});
	};

	// 取消按钮事件
	var btnNo = function() {
		$("#mb_btn_no,#mb_ico").click(function() {
			$("#mb_box,#mb_con").remove();
			if (typeof (callback) == 'function') {
				callback();
			}
			$focused.attr("disabled", false);
			$focused.focus();
		});
	};
	var showAlert = function(msg) {
		$.MsgBox.Alert("消息", msg);
	};
	window.alert = showAlert;
})();

