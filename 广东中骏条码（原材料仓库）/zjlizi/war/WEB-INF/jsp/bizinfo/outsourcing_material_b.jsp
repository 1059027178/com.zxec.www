<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ include file="../include/const.jsp"%>
<%@ page import="java.util.List"%>
<%@ page import="com.thinkway.SapUtil"%>
<%@ page import="com.thinkway.cms.business.domains.MaterialWarehouse"%>
<%
	String materialWarehouseList = (String) request
			.getAttribute("materialWarehouseList");
	String materialId = (String) request.getAttribute("materialId");
	String materialDescription = (String) request
			.getAttribute("materialDescription");
	String materialGettenId = (String) request
			.getAttribute("materialGettenId");
	String lineItem = (String) request.getAttribute("lineItem");
	String supplier = (String) request.getAttribute("supplier");
	String batch = (String) request.getAttribute("batch");
	String storageLocation = (String) request.getAttribute("storageLocation");
	String purchaseOrder = (String) request.getAttribute("purchaseOrder");
	String factory = (String) request.getAttribute("factory");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<style type="text/css">
.selectAmount {
	width: 60px;
}
</style>
<LINK href="/css/jiuhui_list.css" type=text/css rel=STYLESHEET>
<script src="/js/jquery.js"></script>
<script type="text/javascript" src="../../../js/json2.js"></script>
<script type="text/javascript" src="../../../js/common.js"></script>
<script type="text/javascript" src="../../../js/alert.js"></script>
</HEAD>
<BODY>
	<div class="div">
		<form id="form" name="form" action="/outsourcingC.do" method="post"
			onsubmit="return false;">
			<table class="table_list"
				style="width:100%;margin-top:40px;margin-left:20px">
				<input type="hidden" name="postingJsonString" id="postingJsonString" />
				<input type="hidden" name="sum" id="sum" />
				<input type="hidden" name="materialId" value="<%=materialId%>" />
				<input type="hidden" name="supplier" value="<%=supplier%>" />
				<input type="hidden" name="batch" value="<%=batch%>" />
				<input type="hidden" name="storageLocation" value="<%=storageLocation%>" />
				<input type="hidden" name="factory" value="<%=factory%>" />
				<input type="hidden" name="materialDescription"
				value="<%=materialDescription%>" />
				<input type="hidden" name="materialGettenId"
					value="<%=materialGettenId%>" />
				<input type="hidden" name="lineItem" value="<%=lineItem%>" />
				<input type=hidden name="purchaseOrder" value="<%=purchaseOrder%>" />
				<tr>
					<td>物料编码：<label><%=materialId%></label>
					</td>

				</tr>
				<tr>
					<td>物料描述：<label><%=materialDescription%></label></td>
				</tr>
				<tr>
					<td>数量合计：<label id="totalAmount"></label>
					</td>
				</tr>
				<table class="table_list" style="width:100%;margin-left:20px">
					<tr class="tr_list_1" bordercolor="#000000">
						<td class="td_list">序号</td>
						<td class="td_list">仓位</td>
						<td class="td_list">供应商生产日期</td>
					</tr>
					<tr class="tr_list_1" bordercolor="#000000" id="tableList">
						<td class="td_list"></td>
						<td class="td_list">数量</td>
						<td class="td_list">选择数量</td>
					</tr>
					<table style="width:80%;margin-left:20px;margin-right:20px">
						<tr>
							<td align="center"><input type="button" class="button"
								style="width:40px;" value="保存" onclick="confirm()"></input>
								<td align="center"><input type="button" class="button"
									style="width:40px;" value="返回"
									onclick="window.location.href='/delivery.do?functionType=3';"></input>
									<td align="center"><input type="button" class="button"
										style="width:40px;" value="<<" onclick=" previousPage();" />
								</td>
									<td align="center"><input type="button" class="button"
										style="width:40px;" value=">>" onclick="nextPage();" />
								</td></td>
						</tr>
					</table>
					</form>
					</div>
</BODY>
<script>
	var pager = jQuery.extend(true, {}, basePager);
	pager.pageSize = 2;//界面C列表显示每页条目
	pager.paraArr = new Array("num", "wareHouse", "produceDate", "_turn", "_hidden[class=checkWarehouse]",
			"enabledAmount", "_text[class=selectAmount]");
	pager.tableTitle = "tableList";
	var a =
<%=materialWarehouseList%>
	;
	pager.list = a.materialWarehouseList;
	generateTableList();
	function confirm() {
		var sum = 0;
		$.each(pager.list, function(i, item) {
		if (item.selectAmount) {
			sum += item.selectAmount;}
		});
		if (parseFloat(sum) == 0) {
			alert("选择总量为0");
		} else {
			$("#postingJsonString").val(JSON.stringify(pager.list));
			document.form.submit();
		}
	}
	$(document).on("keyup", ".selectAmount", function() {
		var keycode = event.keyCode;
		if (keycode == '86') {
			var inputs = $(this);
			var index = $(this).attr('name');
			var check = $(this).parent().prev().prev().children();
			if (check.val() == 1) {
				return;
			}

			if (($(this).val() != pager.list[index].wareHouse) && (!check.val())) {
				$(this).val("").focus();
				alert("确认仓位不匹配!");
			} else {
				check.val("1");//标记确认
				$(this).val("").focus();
			}

		}
	})
	//监听输入数量
	$(document).on("change", ".selectAmount", function() {
		var inputs = $(this);
		var index = $(this).attr('name');
		var check = $(this).parent().prev().prev().children();
		if (check.val()) {
			if (false) {
				$(this).val(pager.list[index].selectAmount); // 使用原越库数
				$(this).val(pager.list[index].selectAmount);
				alert("上一仓位为空!");
			} else {
				var num = parseFloat($(this).val());
				if (!isNaN(num) && num >= 0) {
					if (parseFloat(num) > parseFloat(pager.list[index].enabledAmount)) {
						$(this).val(pager.list[index].selectAmount); // 使用原越库数
						alert("选择数量不能大于仓位数量！");
					} else {
						pager.list[index].selectAmount = num;
						//检查数量
						var sum = 0;
						$.each(pager.list, function(i, item) {
							if (item.selectAmount) {
								sum += parseFloat(item.selectAmount);
							}
						});
						$("#totalAmount").html(sum);
						$("#sum").val(sum);
					}
				} else {
					$(this).val(pager.list[index].selectAmount); // 使用原越库数
				}
			}
		} else {
			if (check.val() == 1) {
				return;
			}
			if (($(this).val() != pager.list[index].wareHouse) && (!check.val())) {
				$(this).val("").focus();
				alert("确认仓位不匹配!");
			} else {
				check.val("1");//标记确认
				$(this).val("").focus();
			}
		}
	});
</script>
</HTML>