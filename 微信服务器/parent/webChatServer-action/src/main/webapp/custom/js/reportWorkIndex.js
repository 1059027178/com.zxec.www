
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
//	console.log("href = " + thisURL);
	$.ajax({
		type:"post",
		url:"achieveJsapiInfo.do?url="+ thisURL,
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
    		wx.ready(function () {
		    	// 在这里调用 API
		    	$("span.input-group-addon").on("click.cur","span[data-action]",function(){
		    		
				var that = $(this); //获取当前对象
				var actionObj = that.attr("data-action");
				switch(actionObj) {
					//流转卡号扫描
					case "finish_cardno":
						scanFinishCardAndUserNoFun();break;
					case "check_userno":
						scanFinishCardAndUserNoFun();break;
					//物料号扫描
					case "check_matterno":
						scanMatterCardFun();break;
				}
				});
		    });
	 	},
	    error:function(){
		    alert("初始化页面错误，请关闭页面重新进入！");
		}
	});
};
/**
 * 扫描工号或者流转卡执行校验
 */
var scanFinishCardAndUserNoFun = function() {
	//本地测试机时注释-----------1(已测试通过)
	wx.scanQRCode({
		needResult: 1,
		desc: 'scanQRCode desc',
		success: function(res) {
			//获取扫描结果
			var result = res.resultStr;
	//本地测试机时注释-----------1
	
//			var result = "E6753";
//			var result = "17060014";
			$.ajax({
				type:"post",
				url:"/webChatServer-action/reportWork/reportFinish.do?result="+ result,
				async:true,
			 	success:function(data){
			 		var dataObj = eval('(' + data + ')');
			 		var flag = dataObj.flag;
			 		if( flag == "成功" ){
			 			
			 			var type = dataObj.type;
			 			//流转卡验证
			 			if(type == "LZK"){
			 				$("#finish_cardno").val(dataObj.str1);
			 			}
			 			//工号验证
			 			else if(type == "Emp"){
			 				$("#userNo").val("E"+dataObj.str1);
                            $("#userName").val(dataObj.str2);
			 			}
			 			
			 		}else{
			 			alert("该条码" + result + "系统中不存在，请确认输入的信息是否有误！");
			 		}
				},
				//连接错误处理
				
			});
			
	//本地测试机时注释-----------2(已测试通过)
		},
		error: function(res) {
			if(res.errMsg.indexOf('function_not_exist') > 0)  alert('版本过低请升级');
		}
	});
	//本地测试机时注释-----------2
};
/**
 * 扫描物料卡校验-------待开发，目前开发至此------------------------------------------------
 */
var scanMatterCardFun = function(){
	
	//本地测试机时注释-----------1(测试通过)
	wx.scanQRCode({
		needResult: 1,
		desc: 'scanQRCode desc',
		success: function(res) {
			//获取扫描结果
			var result = res.resultStr;
	//本地测试机时注释-----------1
	
//			var result = "07.1.630820-";
			$.ajax({
				type:"post",
				url:"/webChatServer-action/reportWork/reportCheck.do?result="+ result,
				async:true,
			 	success:function(data){
			 		var dataObj = eval('(' + data + ')');
			 		console.log(dataObj);
			 		if(dataObj.msg == "成功"){
//			 		var IT_MATNR = dataObj.IT_MATNR;
			 			$("#check_matterno").val(result);
			 		}else{
			 			alert("该物料“"+ result + "”无效！");
			 		}
			 	},
				//连接错误处理
			});
			
	//本地测试机时注释-----------2(测试通过)
		},
		error: function(res) {
			if(res.errMsg.indexOf('function_not_exist') > 0)  alert('版本过低请升级');
		}
	});
	//本地测试机时注释-----------2
};
