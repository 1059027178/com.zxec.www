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