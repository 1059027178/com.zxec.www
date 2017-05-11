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
	<form id="form" name="form" action="/deliveryAdd.do" method="post"
		onsubmit="return false;">
		<div id="page1">
			<input type="hidden" id="poNumber"><input type="hidden"
				id="supplier"><input type="hidden" id="supplierBatch"><input
						type="hidden" id="produceDate">
							<div style="padding-top:35px;">
								<ul>
									<li style="height:15px;list-style-type:none;">PO收货冲销:<input
										class="text3" type="text"
										style="white-space：nowrap;width:110px;" id="barcodes">
									</li>
									<li class="li">采购订单：<input class="text" readonly=readonly
										type="text" id="purchaseOrder" style="width:85px;"><input
											class="text" readonly=readonly type="text"
											style="width:30px;" id="lineItem">
									</li>
									<li class="li">物料编码：<input class="text" readonly=readonly
										type="text" id="materialId" style="width:120px;" name="matnr">
									</li>
									<li class="li">物料描述：<input class="text" readonly=readonly
										type="text" id="description" style="width:120px;" name="maktx">
									</li>
									<li class="li">每袋数量/袋数：<input class="text"
										readonly=readonly type="text" id="perAmount"
										style="width:40px;" name="meng">/<input class="text3"
											type="text" style="white-space：nowrap;width:38px;"
											id="pockets" name="boxs">
									</li>
									<li class="li">批次号：&emsp;<input class="text"
										readonly=readonly type="text" id="batch" style="width:120px;"
										name="charg">
									</li>
									<li class="li">总数量：&emsp;<input type="text" class="text"
										id="totalAmount" style="width:60px;" name="wemng"> <input
											class="text" readonly=readonly type="text" id="unit" name="unit"
											style="width:52px;">
									</li>
									<li class="li">库存地点：<input class="text3" type="text"
										style="white-space：nowrap;width:120px;" id="storageLocation"
										name="lgort">
									</li>
									<li class="li"><input type="button" valign="center"
										style="width:40px;height:25px;" class="button" id="confirm"
										value="确定" /> <input class="button" type="button"
										valign="center" style="width:40px;height:25px;"
										id="history_back" value="返回" /> <input class="button" type="button"
										valign="center" style="width:40px;height:25px;"
										id="reset" value="重置" /></li>
								</ul>
							</div>
		</div>
		<div id="page2" style="display:none">
			<div style="padding-top:50px;">
				<ul>
					<li style="height:15px;list-style-type:none;"><label
						id="message"></label>
					</li>
					<li class="li"><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="unShelves"
						value="下架" /> <input type="button" id="back2"
						style="width:30px;height:25px;" value="返回" />
					</li>
				</ul>
			</div>
		</div>
	</form>
</body>
<script type="text/javascript">
	$(function() {
		$("#reset").click(function(){
			$(".text").val("");
			$(".text3").val("");
			$("#str").focus();
		});
		$("#unShelves").click(function() {
			document.form.submit();
		});
		$("#barcodes").focus();
		$("#barcodes").keyup(function() {
			// 		alert(1);
			var keycode = event.keyCode;
			// 					var realkey = String.fromCharCode(event.keyCode);
			// 					alert("按键码: " + keycode + " 字符: " + realkey);
			if (keycode == '86') {
				if ($("#barcodes").val()) {
					var barcodes = $("#barcodes").val().split("/");
					$("#purchaseOrder").val(barcodes[0]);
					$("#lineItem").val(barcodes[1]);
					$("#supplier").val(barcodes[2]);
					$("#materialId").val(barcodes[3]);
					$("#perAmount").val(barcodes[4]);
					$("#unit").val(barcodes[5]);
					$("#storageLocation").val(barcodes[6]);
					$("#batch").val(barcodes[7]);
					$("#produceDate").val(barcodes[10]);
					$("#supplierBatch").val(barcodes[11]);
					getMaktx(barcodes[3]);
					$("#pockets").focus();
				}
			}
		});
		$("#barcodes").change(function() {
			if ($("#barcodes").val()) {
				var barcodes = $("#barcodes").val().split("/");
				$("#purchaseOrder").val(barcodes[0]);
				$("#lineItem").val(barcodes[1]);
				$("#supplier").val(barcodes[2]);
				$("#materialId").val(barcodes[3]);
				$("#perAmount").val(barcodes[4]);
				$("#unit").val(barcodes[5]);
				$("#storageLocation").val(barcodes[6]);
				$("#batch").val(barcodes[7]);
				$("#produceDate").val(barcodes[10]);
				$("#supplierBatch").val(barcodes[11]);
				getMaktx(barcodes[3]);
				$("#pockets").focus();
			}
		});

		function getMaktx(matnr) {
			if (matnr == '' || matnr == null)
				return;
			jQuery.ajax({
				url : '/poReceive.do',
				async : false,
				type : "post",
				data : {
					"showType" : "getMaktx",
					"matnr" : matnr
				},
				dataType : 'json',
				success : function(data) {
					$("#description").attr("value", data.maktx);
				},
				error : function() {
					alert("系统异常，请联系管理员");
				}
			});

		}
		$("#pockets").change(function() {
			if ($("#pockets").val()) {
				$("#totalAmount").val(parseFloat($("#pockets").val()) * parseFloat($("#perAmount").val()));
				$("#storageLocation").focus();
			}
		});
		$("#back2").click(function() {
			history.go(0);
		});
		$("#confirm").click(function() {
			if (!$("#pockets").val()) {
				alert("请输入袋数!");
			} else if (!$("#storageLocation").val()) {
				alert("请输入库存地点!");
			} else {
				$.ajax({
					url : '/poReceive.do',
					async : false,
					type : "post",
					data : {
						"purchaseOrder" : $("#purchaseOrder").val(),
						"lineItem" : $("#lineItem").val(),
						"supplier" : $("#supplier").val(),
						"materialId" : $("#materialId").val(),
						"perAmount" : $("#perAmount").val(),
						"unit" : $("#unit").val(),
						"storageLocation" : $("#storageLocation").val(),
						"batch" : $("#batch").val(),
						"produceDate" : $("#produceDate").val(),
						"supplierBatch" : $("#supplierBatch").val(),
						"totalAmount" : $("#totalAmount").val(),
						"storageLocation" : $("#storageLocation").val(),
						"interface" : "ZFM_BC_14_12",
						"showType" : "poReceive"
					},
					dataType : 'json',
					success : function(data) {
						$("#page1").css('display', 'none');
						$("#page2").css('display', 'block');
						$("#message").html(data.msg);
						if (data.msgType == 'E') {
							$("#unShelves").attr("disabled", true);
						}
					},
					error : function() {
						alert("系统异常，请联系管理员");
					}
				});
			}
		});
	});
</script>
</HTML>