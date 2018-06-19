/**
 * create by qianyang 2018-06-05
 */
$(document).ready(function() {
	// 设置日历控件相关默认参数
	$("input[name=startDate],input[name=endDate]").datetimepicker({
		minView : "month",
		format : 'yyyy-mm-dd',
		language : 'zh-CN',
		weekStart : 1,
		todayBtn : 1,
		autoclose : 1,
		todayHighlight : 1,
		startView : 2,
		forceParse : 0,
		showMeridian : 1,
	});
	// 设置初始值为当月第一天、最后一天
	$("input[name=startDate]").val(startDate());
	$("input[name=endDate]").val(endDate());
	// 绑定查询按钮事件
	$("button[name=search]").on("click", function() {
		var msg = "";
		var userName = $("input[name=userName]").val();
		var userNo = $("input[name=userNo]").val();
		var startDate = $("input[name=startDate]").val();
		var endDate = $("input[name=endDate]").val();
		msg += isNotNull(userName, "用户名");
		msg += isNotNull(userNo, "工号");
		msg += isNotNull(startDate, "开始日期");
		msg += isNotNull(endDate, "结束日期");
		// 如果对应的值不为空则提交查询
		if (msg == "") {
			// 显示遮罩层，函数定义在public.js中
			blockUI({target : "",message : "查询中^_^..."});
			var _json = {
				"userNo" : userNo,
				"userName" : userName,
				"startDate" : startDate,
				"endDate" : endDate
			};
			// 提交数据至MES数据查询action
			$.ajax({
				type : "POST",
				url : "../reportWork/myOutput.do",
				async : true,
				data : _json,
				success : function(data) {
					var tbody = $(".tableMain tbody");
					tbody.html("");
					var object = eval('(' + data + ')');
					var flag = object.flag;//请求成功、失败标志
					//console.log("请求结果：" + flag);
					if (flag) {
						var myOutput = eval('(' + object.myOutput + ')');
						//1.如果执行失败，则返回提示
						if(myOutput.status == false){
							var msg = myOutput.message;
							alert("获取数据失败，错误信息为：" + msg);
							// 去除遮罩层
							unblockUI();
							return;
						}
						var detailData = myOutput.detailData;
						//2.返回成功，但无明细数据，添加提示
						if(detailData.length == 0){
							alert("未查询到数据！");
							// 去除遮罩层
							unblockUI();
							return;
						}
						//3.有数据时则遍历获取数据并添加到列表
						$(".tableMain").css("display","block");
						//console.log(detailData);
						for(var index in detailData){
							var obj = detailData[index];
							//console.log(obj);
							tbody.append("<tr>");
							tbody.append("<td>"+obj.productCode+"</td>");
							tbody.append("<td>"+obj.productName+"</td>");
							tbody.append("<td>"+obj.processName+"</td>");
							tbody.append("<td>"+obj.count+"</td>");
							tbody.append("</tr>");
						}
						
					} else {
						alert("访问MES系统获取信息失败，请联系系统管理员！");
					}
					// 去除遮罩层
					unblockUI();
					// 模拟服务器处理时间
					/*setTimeout(function() {
						// 去除遮罩层
						unblockUI();
					}, 6000);*/
				},
				error : function() {
					alert("访问MES系统获取信息失败，请联系系统管理员！");
					// 去除遮罩层
					unblockUI();
				}
			});

		} else
			alert(msg);
	});
});
// 不为空校验
var isNotNull = function(value, name) {
	var msg = "";
	if (value == "") {
		msg = name + "不能为空，请填写! \n";
	}
	return msg;
}

// 获取当月第一天yyyy-MM-dd
var startDate = function() {
	var today = new Date();

	var nowdate = (today.getFullYear()) + "-" + (today.getMonth() + 1) + "-01";

	// 对日期格式进行处理
	var date = new Date(nowdate);
	var mon = date.getMonth() + 1;
	var day = date.getDate();
	var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-"
			+ (day < 10 ? "0" + day : day);
	return mydate;
}
// 获取当月最后一天yyyy-MM-dd
var endDate = function() {
	var today = new Date();

	var lastDate = new Date(today.getFullYear(), today.getMonth() + 1, 0);
	var nowdate = (today.getFullYear()) + "-" + (today.getMonth() + 1) + "-"
			+ lastDate.getDate();

	// 对日期格式进行处理
	var date = new Date(nowdate);
	var mon = date.getMonth() + 1;
	var day = date.getDate();
	var mydate = date.getFullYear() + "-" + (mon < 10 ? "0" + mon : mon) + "-"
			+ (day < 10 ? "0" + day : day);
	return mydate;
}