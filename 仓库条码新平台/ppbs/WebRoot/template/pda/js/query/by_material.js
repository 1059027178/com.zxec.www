var pager = jQuery.extend(true, {}, basePager);
pager.paraArr = [ "show", "CHARG", "VERME", "LGORT" ];
var queryLineItems;// 查询列表
var currentPageNum = 1;// 当前页码
var index;
$(function() {
	$("#material_id_input").focus();
	// 输入仓位
	$("#query").click(function() {
		if ($("#search_number").val()) {
			$.ajax({
				url : "query!getQueryLineItems.action",
				data : {
					searchNumber : $("#search_number").val(),
					functionType : $("#function_type").val()
				},
				dataType : "json",
				success : function(result) {
					if (result["msgType"] == "E") {
						$.MsgBox.Alert("失败", result["msg"]);
					} else {
						pager.list = result["queryLineItems"];
						queryLineItems = result["queryLineItems"];
						generateTableList();
						$("#confirm").removeAttr("disabled");
					}

				}
			});
		} else {
			$.MsgBox.Alert("消息", "请输入正确的物料号");
		}
	});
	// 确认事件
	$("#confirm").click(function() {
		if (pager.list.length > 0) {
			openBox(box1);
			generation(currentPageNum);
		}
	});
	// 退出事件
	$("#box_back").click(function() {
		closeBox(box1);
		$("#confirm").attr("disabled", true);
		$(".data_cell").each(function(i) {
			$(this).remove();
		});
		$("#material_id_input").val("");
		$("#material_id_input").focus();
		currentPageNum = 1;

	});
	function generation(currentPageNum) {
		index = currentPageNum - 1;
		// 序列号
		$("#serialnumber").val("");
//		var serialNumbers = queryLineItems[index].material.serialNumber
//				.split("/");
//		for ( var i = 0; i < serialNumbers.length; i++) {
//			$("#serialnumber").val(
//					($("#serialnumber").val()) + serialNumbers[i] + '\r\n');
//		}
		$("#index").html(currentPageNum + "/" + queryLineItems.length);
		$("#material_id").html(queryLineItems[index].MATNR);
		$("#batch").html(queryLineItems[index].CHARG);
		$("#picking_area").html(queryLineItems[index].LTYPT)
		$("#material_description").html(queryLineItems[index].MATKX);
		$("#storage_type").html(queryLineItems[index].storageType);
		$("#storage_area").html(queryLineItems[index].storageArea);
		$("#storage_location").html(
				queryLineItems[index].LGOBE);
		$("#position").html(queryLineItems[index].LGPLA);
		$("#unit").html(queryLineItems[index].MEINS);
		$("#amount").html(queryLineItems[index].VERME);
	}

	// 按钮事件
	$("#pre_page").click(function() {
		$("#ne_page").attr("disabled", false);
		if (currentPageNum == 2) {
			$("#pre_page").attr("disabled", true);
		}
		generation(--currentPageNum);
	});
	$("#ne_page").click(function() {
		$("#pre_page").attr("disabled", false);
		if (currentPageNum == (queryLineItems.length - 1)) {
			$("#ne_page").attr("disabled", true);
		}
		generation(++currentPageNum);
	});

})
