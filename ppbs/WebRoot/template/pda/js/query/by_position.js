var pager = jQuery.extend(true, {}, basePager);
pager.paraArr = [ "material.id", "material.batch", "material.count", "material.storageLocation" ];
var inventoryDetails;// 盘点物料列表
var currentPageNum = 1;// 当前页码
var index;
$(function() {
	$("#position_input").focus();
	// 输入仓位
	$("#query").click(function() {
		if ($("#position_input").val()) {
			$.ajax({
				url : "query!getInventoryDetailsByPosition.action",
				data : {
					position : $("#position_input").val()
				},
				dataType : "json",
				success : function(result) {
					pager.list = result["inventoryDetails"];
					inventoryDetails = result["inventoryDetails"];
					generateTableList();
					$("#confirm").removeAttr("disabled");
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
		$("#position_input").val("");
		$("#position_input").focus();
		currentPageNum = 1;

	});
	function generation(currentPageNum) {
		index = currentPageNum - 1;
		// 序列号
		$("#serialnumber").val("");
		var serialNumbers = inventoryDetails[index].material.serialNumber.split("/");
		for ( var i = 0; i < serialNumbers.length; i++) {
			$("#serialnumber").val(($("#serialnumber").val()) + serialNumbers[i] + '\r\n');
		}
		$("#index").html(currentPageNum + "/" + inventoryDetails.length);
		$("#material_id").html(inventoryDetails[index].material.id);
		$("#batch").html(inventoryDetails[index].material.batch);
		$("#beOperated").html(inventoryDetails[index].beOperated)
		$("#material_description").html(inventoryDetails[index].material.description);
		$("#storage_type").html(inventoryDetails[index].storageType);
		$("#storage_area").html(inventoryDetails[index].storageArea);
		$("#storage_location").html(inventoryDetails[index].material.storageLocation);
		$("#position").html(inventoryDetails[index].material.position);
		$("#unit").html(inventoryDetails[index].material.unit);
		$("#amount").html(inventoryDetails[index].material.count);
		$("#inventory_amount").focus();
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
		if (currentPageNum == (inventoryDetails.length - 1)) {
			$("#ne_page").attr("disabled", true);
		}
		generation(++currentPageNum);
	});

})
