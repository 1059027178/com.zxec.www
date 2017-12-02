
$(document).ready(function(){
	// 在这里调用 API
	jsapiInit();
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
	$("span.input-group-addon").on("click.cur", "span[data-action]", function() {
		var that = $(this); //获取当前对象
		var actionObj = that.attr("data-action");
		switch(actionObj) {
			//流转卡号扫描
			case "finish_cardno":
				scanFinishCardAndUserNoFun();
				break;
				//工号
			case "check_userno":
				scanFinishCardAndUserNoFun();
				break;
				//物料号扫描
			case "check_matterno":
				scanMatterCardFun();
				break;
		}
	});
	//完工报工确定
	$("#finishSao").click(function(){
		var userNo			= $("#userNo").val().trim();//工号
		var userName		= $("#userName").val().trim();//用户姓名
		var finish_cardno	= $("#finish_cardno").val().trim();//流转卡
		//alert("工号：【" + userNo + "】\n姓名：【" + userName + "】\n流转卡：【" + finish_cardno+"】");
		var msg = isnull("流转卡号",finish_cardno);
		msg += isnull("员工工号",userNo);
		if(msg == ""){
			var params = "userNo="   + encodeURIComponent(userNo);
			params 	  += "&userName=" + encodeURIComponent(userName);
			params    += "&finish_cardno=" + encodeURIComponent(finish_cardno);
			var url = "../reportWork/queryDetailByLZK.do?" + params;
//			console.log("url=" + url);
			window.location.href = url;
		}else{
			alert(msg);
		}
	});
	//质检报工确定
	$("#CheckSao").click(function(){
		var userNo			= $("#userNo").val().trim();//工号
		var userName		= $("#userName").val().trim();//用户姓名
		var check_matterno	= $("#check_matterno").val().trim();//物料号
		//alert("工号：【" + userNo + "】\n姓名：【" + userName + "】\n物料卡：【" + check_matterno+"】");
		var msg = isnull("物料代码",check_matterno)
		msg += isnull("员工工号",userNo);
		if(msg == ""){
			var params = "userNo="   + encodeURIComponent(userNo);
			params 	  += "&userName=" + encodeURIComponent(userName);
			params    += "&check_matterno=" + encodeURIComponent(check_matterno);
			var url = "../reportWork/queryDetailByMatter.do?" + params;
//			console.log("url=" + url);
			window.location.href = url;
		}else{
			alert(msg);
		}
	});
});

/**
 * 判断input 是否为空
 * @param {Object} returnMsg 显示值
 * @param {Object} idValue 值
 */
var isnull = function(returnMsg,idValue){
	if(idValue.trim() == "") {
		return returnMsg + "不能为空！\n";
	}else{
		return "";
	}
}
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
				type:"GET",
				url:"/webChatServer-action/reportWork/reportFinish.do?result="+ result,
				async:true,
			 	success:function(data){
			 		var dataObj = eval('(' + data + ')');
			 		var flag = dataObj.flag;
			 		if( flag == "成功" ){
			 			
			 			var type = dataObj.type;
			 			//流转卡验证
			 			if(type == "LZK"){
			 				$("#finish_cardno").val(dataObj.str1.trim());
			 			}
			 			//工号验证
			 			else if(type == "Emp"){
			 				$("#userNo").val("E"+dataObj.str1.trim());
                            $("#userName").val(dataObj.str2.trim());
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
 * 扫描物料卡校验
 */
var scanMatterCardFun = function(){
	
	//本地测试机时注释-----------1(测试通过)
	wx.scanQRCode({
		needResult: 1,
		desc: 'scanQRCode desc',
		success: function(res) {
			//获取扫描结果
			var result = (res.resultStr).trim();
	//本地测试机时注释-----------1
	
//			var result = "07.1.630820-";
			$.ajax({
				type:"GET",
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
