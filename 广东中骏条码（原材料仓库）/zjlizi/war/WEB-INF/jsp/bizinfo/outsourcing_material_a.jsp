<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="<%=desp%>">
			<meta name="company" content="<%=company%>">
				<script src="/js/jquery.js"></script>
				<script type="text/javascript" src="../../../js/json2.js"></script>
				<script type="text/javascript" src="../../../js/common.js"></script>
				<LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
</HEAD>
<body>
	<form id="form" name="form" action="/outsourcingB.do" method="post"
		onsubmit="return false;">
		<div style="padding-top:35px;">
			<input type="hidden" id="purchaseOrder" name="purchaseOrder">
				<input type="hidden" id="lineItem" name="lineItem">
					<ul>
						<li style="height:15px;list-style-type:none;">委外发料:<input
							class="text3" type="text" style="white-space：nowrap;width:120px;"
							id="barcodes">
						</li>
						<li class="li"></li>
						<li class="li">物料编码:<input class="text" readonly=readonly
							type="text" id="materialId" name="materialId"
							style="width:120px;">
						</li>
						<li class="li">批次号:&emsp;<input class="text"
							readonly=readonly type="text" id="batch" name="batch"
							style="width:120px;">
						</li>
						<li class="li">供应商生产日期:<input class="text" readonly=readonly
							type="text" id="produceDate" style="width:90px;">
						</li>
						<li class="li">仓库号:&emsp;<input type="text" id="warehouse"
							name="warehouse" value="311"
							style="white-space：nowrap;width:40px;">
						</li>
						<li class="li"><input type="button" valign="center"
							style="width:40px;height:25px;" class="button" id="confirm"
							value="确定" /> <input class="button" type="button"
							valign="center" style="width:40px;height:25px;" onclick="window.location.href='/main.do?two=3';"
							value="返回" />
						</li>
					</ul>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(function() {
		$("#barcodes").focus();
		$("#barcodes").keyup(function() {
			var keycode = event.keyCode;
			if (keycode == '86') {
				if ($("#barcodes").val()) {
					var barcodes = $("#barcodes").val().split("/");
					if ($("#barcodes").val()) {
						var barcodes = $("#barcodes").val().split("/");
						$("#purchaseOrder").val(barcodes[0]);
						$("#lineItem").val(barcodes[1]);
						$("#materialId").val(barcodes[3]);
						$("#batch").val(barcodes[7]);
						$("#produceDate").val(barcodes[10]);
					}
				}
			}
		});
		$("#barcodes").change(function() {
			if ($("#barcodes").val()) {
				var barcodes = $("#barcodes").val().split("/");
				$("#purchaseOrder").val(barcodes[0]);
				$("#lineItem").val(barcodes[1]);
				$("#materialId").val(barcodes[3]);
				$("#batch").val(barcodes[7]);
				$("#produceDate").val(barcodes[10]);
			}
		});
		$("#confirm").click(function() {
			if ($("#barcodes").val()) {
				document.form.submit();
			}
		});
	});
</script>
</HTML>