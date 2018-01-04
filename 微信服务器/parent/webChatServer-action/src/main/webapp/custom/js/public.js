/**
 * js调用初始化后，需要加载相关数据
 */
var jsapiInit = function (){
	var thisURL = location.href.split('#')[0];
//	console.log("href = " + thisURL);
	$.ajax({
		type:"GET",
		url:"../center/achieveJsapiInfo.do?url="+ thisURL,
		async:true,
	 	success:function(data){
//	 		console.log("data =" + data);
	 		var dataObj = eval('(' + data + ')');
	 		wx.config({
			    debug: 	   false,
				appId: 	   dataObj.appId, // 必填，企业号的唯一标识，此处填写企业号corpid
				timestamp: dataObj.timestamp, // 必填，生成签名的时间戳
				nonceStr:  dataObj.nonceStr,// 必填，生成签名的随机串
				signature: dataObj.signature,// 必填，签名
				jsApiList: [// 所有要调用的 API 都要加到这个列表中
		        	'scanQRCode','chooseImage','previewImage','uploadImage','downloadImage','translateVoice'
		        ]
    		});
    		//页面初始化如果需要调用js，则必须卸载ready中，否则对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
    		wx.ready(function () {});
	 	},
	    error:function(){
		    alert("初始化页面错误，请关闭页面重新进入！");
		}
	});
};
/**
 * 显示遮罩层
 * a的值为：{target:"",message:""}
 * target为对应遮罩层的元素，message为提示文本
 */
var blockUI = function (a) {
    var a = $.extend(!0, {}, a), b = "";
    if (b = a.iconOnly ? '<div class="loading-message ' + (a.boxed ? "loading-message-boxed" : "") + '"><img style="" src="../custom/img/loading-spinner-grey.gif" align=""></div>' : a.textOnly ? '<div class="loading-message ' + (a.boxed ? "loading-message-boxed" : "") + '"><span>&nbsp;&nbsp;' + (a.message ? a.message : "LOADING...") + "</span></div>" : '<div class="loading-message ' + (a.boxed ? "loading-message-boxed" : "") + '"><img style="" src="../custom/img/loading-spinner-grey.gif" align=""><span>&nbsp;&nbsp;' + (a.message ? a.message : "LOADING...") + "</span></div>",
            a.target) {
        var c = $(a.target);
        c.height() <= $window.height() && (a.cenrerY = !0), c.block({
            message: b,
            baseZ: a.zIndex ? a.zIndex : 1e3,
            centerY: void 0 != a.cenrerY ? a.cenrerY : !1,
            css: {
                top: "10%",
                border: "0",
                padding: "0",
                backgroundColor: "none"
            },
            overlayCSS: {
                backgroundColor: a.overlayColor ? a.overlayColor : "#999",
                opacity: a.boxed ? .05 : .1,
                cursor: "wait"
            }
        })
    } else $.blockUI({
        message: b,
        baseZ: a.zIndex ? a.zIndex : 1e3,
        css: {border: "0", padding: "0", backgroundColor: "none"},
        overlayCSS: {
            backgroundColor: a.overlayColor ? a.overlayColor : "#000",
            opacity: a.boxed ? .05 : .1,
            cursor: "wait"
        }
    })
}
//去除遮罩层
var unblockUI = function (a) {
    if (a) {
        var b = $(a);
        b.unblock({
            onUnblock: function () {
                $(a).css("position", ""), $(a).css("zoom", "")
            }
        })
    } else $.unblockUI()
}