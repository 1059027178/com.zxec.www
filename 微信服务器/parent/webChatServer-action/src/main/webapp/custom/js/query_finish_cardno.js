$(document).ready(function(){
	//加载微信相关插件
	//测试暂时关闭微信jsapi调用逻辑
	jsapiInit();
	//扫一扫
	$("div.container span.LZKNO").on("click",function(){
		console.log("调用微信扫一扫接口");
		wx.scanQRCode({
			desc: "scanQRCode desc",
			needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
			scanType: ["qrCode","barCode"], // 可以指定扫二维码还是一维码，默认二者都有
			success: function (res) {
				alert(res.resultStr);
				$("input.LZKNO").val(res.resultStr);
			},
			error: function(res){
				console.log("ERROR");
				if(res.errMsg.indexOf('function_not_exist') > 0){
					alert('版本过低请升级');
				}
			}
		});
	});
	//查询按钮
	$("button.search").on("click",function(){
		var cardno = $("input.LZKNO").val().trim();
		if(cardno == ""){
			alert("请输入或扫描流转卡！");
			return;
		}
		//console.log("---" + cardno);
		// 显示遮罩层，函数定义在public.js中
		blockUI({target : "",message : "查询中^_^..."});
		var _json = {
			"cardno" : cardno
		};
		// 提交数据至MES数据查询action
		$.ajax({
			type : "POST",
			url : "../reportWork/queryFinishCardNo.do",
			async : true,
			data : _json,
			success : function(data) {
				var object = eval('(' + data + ')');
				var flag = object.flag;//请求成功、失败标志
				console.log("请求结果：" + flag);
				if (flag) {
					var flowCard = eval('(' + object.flowCard + ')');
					//1.如果执行失败，则返回提示
					if(flowCard.status == false){
						var msg = flowCard.message;
						alert("获取数据失败，错误信息为：" + msg);
						return;
					}
					//console.log("----------");
					//console.log(flowCard);
					//console.log("----------");
					var detailData = flowCard.detailData;
					//2.返回成功，但无明细数据，添加提示
					if(detailData.length == 0){
						alert("未查询到数据！");
						return;
					}
					$("div.container").css("display","");
					//3.有数据时则遍历获取数据并添加到列表
					var theader = $(".tableHeader tbody");
					var flowCardNo = theader.find("tr td.flowCardNo");
					var dispatchList = theader.find("tr td.dispatchList");
					var productCode = theader.find("tr td.productCode");
					var productName = theader.find("tr td.productName");
					flowCardNo.html(flowCard.flowCardNo);
					dispatchList.html(flowCard.dispatchList);
					productCode.html(flowCard.productCode);
					productName.html(flowCard.productName);
					//console.log(detailData);
					var tbody = $(".tableMain tbody");
					tbody.html("");
					for(var index in detailData){
						var obj = detailData[index];
						//console.log(obj);
						tbody.append("<tr>");
						tbody.append("<td>"+obj.userNo+"</td>");
						tbody.append("<td>"+obj.userName+"</td>");
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
				alert("请求错误，请稍后重试！");
				// 去除遮罩层
				unblockUI();
			}
		});
	});
});