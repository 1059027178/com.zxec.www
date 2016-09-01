<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>SAP交互系统 - 九慧</TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="展会管理工具">
			<meta name="company" content="九慧">
				<style type="text/css">
.selectAmount {
	width: 60px;
}

.table_page {
	font-size: 10px;
}
</style>
				<script src="/js/jquery.js"></script>
				<script type="text/javascript" src="../../../js/json2.js"></script>
				<script type="text/javascript" src="../../../js/common.js"></script>
				<LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
</HEAD>
<body>
	<!-- 初始界面 -->
	<div id="page1">
		<div style="padding-top:50px;">
			<input type="hidden" id="materialId" />
			<ul>
				<li style="height:15px;list-style-type:none;">生产领料单</li>
				<li class="li">工厂：<input class="text" type="text" id="factory">
				</li>
				<li class="li">库存地点：<input class="text" type="text"
					id="storageLocation">
				</li>
				<li class="li">制单日期：<input class="text" type="text"
					id="produceDate">
				</li>
				<li class="li"><input type="button" valign="center"
					style="width:40px;height:25px;" class="button" id="confirm"
					value="确定" /> <input type="button" valign="center"
					style="width:40px;height:25px;" class="button" id="history_back"
					value="返回" /></li>
			</ul>
		</div>
	</div>
	<!-- 界面A -->
	<div id="pageA" style="display:none">
		<div style="padding-top:50px;">
			<table class="table_page">
				<tr id="table1">
					<td></td>
					<td>序号</td>
					<td>生产领料单</td>
				</tr>
				<tr>
					<td><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="confirm1"
						value="确认" /></td>
					<td><input class="button" type="button" valign="center"
						style="width:40px;height:25px;" id="back1" value="返回" /></td>
					<td><input type="text" valign="center"
						style="width:40px;height:20px;" id="jumpTable" /></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 界面B -->
	<div id="pageB" style="display:none">
		<div style="padding-top:50px;">
			<input type="hidden" id="lineItem" /> <input type="hidden"
				id="materialGettenId" />
			<table class="table_page">
				<tr>
					<td></td>
					<td>序号</td>
					<td>物料</td>
					<td>单位</td>
					<td>批次</td>
				</tr>
				<tr id="table2">
					<td></td>
					<td></td>
					<td>数量</td>
					<td></td>
					<td>已拣配数量</td>
				</tr>
				<tr>
					<td><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="posting"
						value="过账" /></td>
					<td><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="unshelves"
						value="下架" /></td>
					<td><input class="button" type="button" valign="center"
						style="width:40px;height:25px;" id="back2" value="返回" /></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 界面C -->
	<div id="pageC" style="display:none">
		<div style="padding-top:50px;">
			<ul>
				<li class="li">物料编码：<label id="materiIdShow"></label>
				</li>
				<li class="li">物料描述：<label id="descriptionShow"></label>
				</li>
				<li class="li">需求数量：<label id="requireAmount"></label>
				</li>
			</ul>
			<table class="table_page">
				<tr>
					<td>序号</td>
					<td>仓位</td>
					<td>供应商生产日期</td>
				</tr>
				<tr id="table3">
					<td></td>
					<td>数量</td>
					<td>选择数量</td>
				</tr>
				<tr>
					<td><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="save"
						value="保存" /></td>
					<td><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="back3"
						value="返回" /></td>
					<td><input class="button" type="button" valign="center"
						style="width:60px;height:25px;" id="nextItem" value="下一项" /></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 界面D -->
	<div id="pageD" style="display:none">
		<div style="padding-top:50px;">
			<table class="table_page">
				<tr colspan=3>
					<label id="pageDMessage"></label>
				</tr>
				<tr>
					<td><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="continue"
						value="继续" /></td>
					<td><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="back4"
						value="返回" /></td>
					<td><input class="button" type="button" valign="center"
						style="width:80px;height:25px;" id="nextItem"
						onclick="window.location.href='/lubuView.do';" value="记账变更" /></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 界面E -->
	<div id="pageE" style="display:none">
		<div style="padding-top:50px;">
			<table class="table_page">
				<tr colspan=3>
					<label id="pageEMessage"></label>
				</tr>
				<tr>
					<td><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="continue2"
						value="继续" /></td>
					<td><input type="button" valign="center"
						style="width:40px;height:25px;" class="button" id="back5"
						value="返回" /></td>
				</tr>
			</table>
		</div>
	</div>
</body>
<script type="text/javascript">
	//生产发料接口
	var interfaceA = "ZFM_BC_15_11";
	var interfaceB = "ZFM_BC_15_12";
	var interfaceC = "ZFM_BC_15_21";
	var interfaceD = "ZFM_BC_15_22";
	//研发领料接口
	// 	var interfaceA = "ZFM_BC_16_11";
	// 	var interfaceB = "ZFM_BC_16_12";
	// 	var interfaceC = "ZFM_BC_16_21";
	// 	var interfaceD = "ZFM_BC_16_22";
	var pagerArray = [];
	var pager1 = jQuery.extend(true, {}, basePager);
	pager1.pageSize = 5;//界面A列表显示每页条目
	pager1.paraArr = new Array("_radio", "num", "materialId");
	pager1.tableTitle = "table1";
	pagerArray[0] = pager1;
	var pager2 = jQuery.extend(true, {}, basePager);
	pager2.pageSize = 3;//界面B列表显示每页条目
	pager2.paraArr = new Array("_radio", "num", "materialId", "unit", "batch", "_turn", "_null", "_null", "perAmount",
			"_null", "pickingAmount");
	pager2.tableTitle = "table2";
	pagerArray[1] = pager2;
	var pager3 = jQuery.extend(true, {}, basePager);
	pager3.pageSize = 2;//界面C列表显示每页条目
	pager3.paraArr = new Array("num", "wareHouse", "produceDate", "_turn", "_hidden[class=checkWarehouse]",
			"enabledAmount", "_text[class=selectAmount]");
	pager3.tableTitle = "table3";
	pagerArray[2] = pager3;
	var pageAIndex;//界面A选择序号
	var pageBIndex;//界面B选择序号
	var produceDate;//制单日期
	$(function() {
		var date = new Date();
		$("#produceDate").val(date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate());
		$("#factory").val("3100");
		$("#storageLocation").val("3107");
		$("#back1").click(function() {
			history.go(0);
		});
		//初始界面确认
		$("#confirm").click(function() {
			$("#confirm").attr("disabled", true);
			if (!$("#factory").val()) {
				alert("请输入工厂!");
			} else if (!$("#storageLocation").val()) {
				alert("请输入库存地点!");
			} else if (!$("#produceDate").val()) {
				alert("请输入生产日期!");
			} else {
				try {
					var dt = $("#produceDate").val().split("/");
					produceDate = dt[0] + "" + ("0" + dt[1]).substr(-2) + "" + ("0" + dt[2]).substr(-2);
				} catch (e) {
					$("#produceDate").val(date.getFullYear() + "/" + (date.getMonth() + 1) + "/" + date.getDate());
					alert("错误的日期格式!");
					$("#confirm").attr("disabled", false);
					return;
				}
				showPageA();
			}
			$("#confirm").attr("disabled", false);
		});

		//界面A确认
		$("#confirm1").click(function() {
			$("#confirm1").attr("disabled", true);
			pageAIndex = $("input[name='radio_0']:checked").val();
			if (!$("input[name='radio_0']:checked").val()) {
				alert("请至少选择一项");
			} else {
				showPageB();
			}
			$("#confirm1").attr("disabled", false);
		});
		//界面A跳页
		$("#jumpTable").change(function() {
			var index = $("#jumpTable").val();
			if (!isNaN(index) && index > 0) {
				generateTableList(0, index);
			} else {
				$("#jumpTable").val("");
			}
		});
		//界面B下架
		$("#unshelves").click(function() {
			$("#unshelves").attr("disabled", true);
			pageBIndex = $("input[name='radio_1']:checked").val();
			if (!$("input[name='radio_1']:checked").val()) {
				alert("请至少选择一项");
			} else {
				showPageC();
			}
			$("#unshelves").attr("disabled", false);
		});
		//界面B过账
		$("#posting").click(function() {
			$("#posting").attr("disabled", true);
			$.ajax({
				url : '/getMaterial.do',
				async : false,
				type : "post",
				data : {
					"factory" : $("#factory").val(),
					"postingJsonString" : JSON.stringify(pager2.list),
					"interface" : interfaceC,
					"showType" : "posting"
				},
				dataType : 'json',
				success : function(data) {
					if (data.msgType == 'E') {
						alert(data.msg);
					} else {
						$("#pageB").css('display', 'none');
						$("#pageE").css('display', 'block');
						$("#pageEMessage").html(data.msg);
					}
				},
				error : function() {
					alert("系统异常，请联系管理员");
				}
			});
			$("#posting").attr("disabled", false);
		});
		//界面B返回
		$("#back2").click(function() {
			$("#back2").attr("disabled", true);
			$("#pageB").css('display', 'none');
			showPageA();
			$("#back2").attr("disabled", false);
		});

		//界面C,监听输入数量
		$(document).on("keypress", ".selectAmount", function() {
			if (event.keyCode == 13) {
				var index = $(this).attr('name');
				var check = $(this).parent().prev().prev().children();
				if (($(this).val() != pager3.list[index].wareHouse) && (!check.val())) {
					alert("确认仓位不匹配!");
					$(this).val("").focus();
				} else {
					if (check.val()) {
						if (index > 0 && !(pager3.list[index - 1].selectAmount)) {
							alert("上一仓位为空!");
							$(this).val(pager3.list[index].selectAmount);
						} else {
							var num = parseFloat($(this).val());
							if (!isNaN(num) && num >= 0) {
								if (num > pager3.list[index].enabledAmount) {
									alert("选择数量不能大于仓位数量")
									$(this).val(pager3.list[index].selectAmount); // 使用原越库数
								} else {
									pager3.list[index].selectAmount = num;
									//检查数量
									var sum = 0;
									$.each(pager3.list, function(i, item) {
										sum += item.selectAmount;
									});
									if (sum > $("#requireAmount").html()) {
										alert("总数超过需求数量!");
										pager3.list[index].selectAmount = "0";
										$(this).val("").focus();
									}
								}
							} else {
								$(this).val(pager3.list[index].selectAmount); // 使用原越库数
							}
						}
					} else {
						check.val("1");//标记确认
						$(this).val("").focus();
					}

				}
			}
		});
		//界面C保存
		$("#save").click(function() {
			$("#save").attr("disabled", true);
			$.ajax({
				url : '/getMaterial.do',
				async : false,
				type : "post",
				data : {
					"saveJsonString" : JSON.stringify(pager3.list),
					"lineItem" : $("#lineItem").val(),
					"materialGettenId" : $("#materialGettenId").val(),
					"interface" : "ZFM_BC_03_22",
					"interface2" : interfaceD,
					"showType" : "unshelvesAndPicking"
				},
				dataType : 'json',
				success : function(data) {
					if (data.msgType == 'E') {
						alert(data.msg);
					} else {
						$("#pageC").css('display', 'none');
						$("#pageD").css('display', 'block');
						$("#pageDMessage").html(data.msg);
					}
				},
				error : function() {
					alert("系统异常，请联系管理员");
				}
			});
			$("#save").attr("disabled", false);
		});
		//界面C返回
		$("#back3").click(function() {
			$("#back3").attr("disabled", true);
			$("#pageC").css('display', 'none');
			showPageB();
			$("#back3").attr("disabled", false);
		});
		//界面C下一项
		$("#nextItem").click(function() {
			$("#nextItem").attr("disabled", true);
			if (pageBIndex == pager2.list.length - 1) {
				alert("已经是最后一项");
			} else {
				pageBIndex++;
				$("#pageC").css('display', 'none');
				showPageC();
			}
			$("#nextItem").attr("disabled", false);
		});
		//界面D继续
		$("#continue").click(function() {
			$("#continue").attr("disabled", true);
			$("#pageD").css('display', 'none');
			showPageB();
			$("#continue").attr("disabled", false);
		});
		//界面D返回
		$("#back4").click(function() {
			$("#back4").attr("disabled", true);
			$("#pageD").css('display', 'none');
			showPageC();
			$("#back4").attr("disabled", false);
		});
		//界面e继续
		$("#continue2").click(function() {
			$("#continue2").attr("disabled", true);
			$("#pageE").css('display', 'none');
			showPageA();
			$("#continue2").attr("disabled", false);
		});
		//界面e返回
		$("#back5").click(function() {
			history.go(0);
		});
		//显示界面A
		function showPageA() {
			$.ajax({
				url : '/getMaterial.do',
				async : false,
				type : "post",
				data : {
					"factory" : $("#factory").val(),
					"storageLocation" : $("#storageLocation").val(),
					"produceDate" : produceDate,
					"interface" : interfaceA,
					"showType" : "getProduceList"
				},
				dataType : 'json',
				success : function(data) {
					if (data.msgType == 'E') {
						alert(data.msg);
						history.go(0);
					} else {
						pager1.list = data.getMaterial;
						$("#page1").css('display', 'none');
						$("#pageA").css('display', 'block');
						generateTableList(0, 1);
					}
				},
				error : function() {
					$("#page1").css('display', 'block');
					alert("系统异常，请联系管理员");
				}
			});
		}
		//显示界面B
		function showPageB() {
			if (!$("input[name='radio_0']:checked").val()) {
				history.go(0);
			} else {
				$("#materialId").val(pager1.list[pageAIndex].materialId);
				$.ajax({
					url : '/getMaterial.do',
					async : false,
					type : "post",
					data : {
						"materialId" : pager1.list[pageAIndex].materialId,
						"interface" : interfaceB,
						"showType" : "getProduceDetailList"
					},
					dataType : 'json',
					success : function(data) {
						if (data.msgType == 'E') {
							alert(data.msg);
						} else {
							pager2.list = data.materialDetail;
							$("#pageA").css('display', 'none');
							$("#pageB").css('display', 'block');
							generateTableList(1, 1);
							var a = 1;
						}
					},
					error : function() {
						$("#pageA").css('display', 'block');
						alert("系统异常，请联系管理员");
					}
				});
			}
		}
		//显示界面C
		function showPageC() {
			if (!$("input[name='radio_1']:checked").val()) {
				history.go(0);
			} else {
				$("#lineItem").val(pager2.list[pageBIndex].lineItem);
				$("#materialGettenId").val(pager2.list[pageBIndex].materialGettenId);
				$.ajax({
					url : '/getMaterial.do',
					async : false,
					type : "post",
					data : {
						"materialId" : pager2.list[pageBIndex].materialId,
						"batch" : pager2.list[pageBIndex].batch,
						"interface" : "ZFM_BC_03_13",
						"showType" : "getWarehouseDetailList"
					},
					dataType : 'json',
					success : function(data) {
						if (data.msgType == 'E') {
							alert(data.msg);
						} else {
							pager3.list = data.materialWarehouse;
							$("#pageB").css('display', 'none');
							$("#pageC").css('display', 'block');
							$("#materiIdShow").html(data.materialId);
							$("#descriptionShow").html(data.materialdescription);
							$("#requireAmount").html(
									pager2.list[pageBIndex].perAmount - pager2.list[pageBIndex].pickingAmount);
							generateTableList(2, 1);
							$("body").find(".selectAmount").eq(0).focus();
						}
					},
					error : function() {
						$("#pageB").css('display', 'block');
						alert("系统异常，请联系管理员");
					}
				});
			}
		}
	});
</script>
</HTML>