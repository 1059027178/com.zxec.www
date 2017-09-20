$(document).ready(function(){
	/**
	 * button 按钮添加点击事件
	 */
	$("button").on("click.cur", function(){
		var that = $(this); //获取当前对象
		var actionObj = that.attr("data-action");
		switch(actionObj) {
			//返回按钮
			case "backBtn":
				//显示报工类别
				$(".selectType").css("display","block");
				//隐藏完工报工
	            $(".reportFinish").css("display","none");
	            //隐藏质检报工
	            $(".reportCheck").css("display","none");
	            //隐藏用户信息
	            $(".userInfo").css("display","none");
	            //隐藏返回按钮
	            $(".backBtn").css("display","none");
				break;
			//选择完工
			case "reportFinish":
				//隐藏报工类别
				$(".selectType").css("display","none");
	            //隐藏质检报工
	            $(".reportCheck").css("display","none");
				//显示完工报工
	            $(".reportFinish").css("display","block");
	            //显示用户信息
	            $(".userInfo").css("display","block");
	            //显示返回按钮
	            $(".backBtn").css("display","block");
				break;
			//选择质检
			case "reportCheck":
				//隐藏报工类别
				$(".selectType").css("display","none");
				//隐藏完工报工
	            $(".reportFinish").css("display","none");
	            //显示质检报工
	            $(".reportCheck").css("display","block");
	            //显示用户信息
	            $(".userInfo").css("display","block");
	            //显示返回按钮
	            $(".backBtn").css("display","block");
				break;
		}
	});
	jsapiInit();
});
/**
 * js调用初始化后，需要加载相关数据
 */
var jsapiInit = function (){
	var thisURL = location.href.split('#')[0];
	console.log("href = " + thisURL);
	$.ajax({
		type:"post",
		url:"achieveJsapiInfo.do?url="+ thisURL,
		async:true,
	 	success:function(data){
//	 		console.log("data =" + data);
	 		var dataObj = eval('(' + data + ')');
	 		wx.config({
			    debug: 	   true,
				appId: 	   dataObj.appId, // 必填，企业号的唯一标识，此处填写企业号corpid
				timestamp: dataObj.timestamp, // 必填，生成签名的时间戳
				nonceStr:  dataObj.nonceStr,// 必填，生成签名的随机串
				signature: dataObj.signature,// 必填，签名
				jsApiList: [// 所有要调用的 API 都要加到这个列表中
		        	'scanQRCode','chooseImage','previewImage','uploadImage','downloadImage','translateVoice'
		        ]
    		});
    		wx.ready(function () {
		    	// 在这里调用 API
		    	$("span.input-group-addon").on("click.cur","span[data-action]",function(){
		//  		debugger
				var that = $(this); //获取当前对象
				var actionObj = that.attr("data-action");
				switch(actionObj) {
					//流转卡号扫描
					case "finish_cardno":finishCardnoFun();break;
					//物料号扫描
					case "check_matterno":
						break;
					//员工工号扫描
					case "check_userno":
						break;
				}
				});
		    });
	 	},
	    error:function(){
		    alert("初始化页面错误，请关闭页面重新进入！");
		}
	});
};
var finishCardnoFun = function() {
	alert("finish_cardno is click !");
	wx.scanQRCode({
		needResult: 1,
		desc: 'scanQRCode desc',
		success: function(res) {
			//获取扫描结果
			var result = res.resultStr;
			$.ajax({
				type:"post",
				url:"/reportWork/reportFinish.do?result="+ result, //后台代码还未写----到此暂停
				async:true,
			 	success:function(data){
			 		
				},
			
			});
		},
		error: function(res) {
			if(res.errMsg.indexOf('function_not_exist') > 0)  alert('版本过低请升级');
		}
	});
};
