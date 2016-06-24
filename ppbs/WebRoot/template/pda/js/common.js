/**
 * pda公共JS函数
 */
var basePager = new Object();
basePager.pageNumber = 1;
basePager.pageSize = 4;
basePager.pageCount = 0;
basePager.tableTitle = "table_title";

$(document).ready(function() {
	// 返回上一页
	$("#history_back").click(function() {
		history.back(-1);
	});

	// 解决IE浏览器不支持Enter键触发input 的change事件
	var changeBubble = $.support.changeBubbles;

	$("input[type=text]").on("change", function(e) {
		$.data(this, "value", this.value);
	}).on("keyup", function(e) {
		if (e.which === 13 && this.value != $.data(this, "value") && !changeBubble) {
			e.preventDefault();
			$(this).trigger('blur');
		}
	})
});

$(function(){     

    /*JQuery 限制文本框只能输入数字*/  
    $(".NumText").keyup(function(){    
            $(this).val($(this).val().replace(/[^(\d||/.)]/g,''));  
        }).bind("paste",function(){  //CTR+V事件处理    
            $(this).val($(this).val().replacereplace(/[^(\d||/.)]/g,''));     
        }).css("ime-mode", "disabled"); //CSS设置输入法不可用    
 
});  
// 点击radio所在行，即可点中该行的radio
$(document).on('click', '.to_data_cell, .data_cell, .task_data_cell, .project_data_cell', function() {
	$(this).find("input[type='radio']").prop("checked", true);
});

// 打开遮罩层
function openBox() {
	var boxId;
	if (arguments.length == 0) {
		boxId = ".box"
	} else {
		boxId = arguments[0];
	}
	$("#bg").css({
		display : "block",
		height : $(document).height()
	});
	$(boxId).css({
		display : "block"
	})
}

// 关闭遮罩层
function closeBox() {
	var boxId;
	if (arguments.length == 0) {
		boxId = ".box"
	} else {
		boxId = arguments[0];
	}
	$("#bg").css("display", "none");
	$(boxId).css("display", "none");
}

// 将java.util.date 的json对象转换成字符串
function formatDate(dateObject) {
	return dateString = dateObject.year + 1900 + "/" + (1 + dateObject.month) + "/" + dateObject.date + " "
			+ dateObject.hours + ":" + dateObject.minutes;
}

// 按下标删除数组元素
Array.prototype.remove = function(obj) {
	for (var i = 0; i < this.length; i++) {
		var temp = this[i];
		if (!isNaN(obj)) {
			temp = i;
		}
		if (temp == obj) {
			for (var j = i; j < this.length; j++) {
				this[j] = this[j + 1];
			}
			this.length = this.length - 1;
		}
	}
}

// 向Array中添加不重复的对象
Array.prototype.put = function(obj) {
	if ($.trim(obj) && $.inArray($.trim(obj), this) == -1) { // obj不为空，并且原数组中不包含这个元素
		this.push($.trim(obj));
	}
}

// 按下标序列从Array中移除多个元素
Array.prototype.clear = function(arr) {
	var newArr = new Array();
	$.each(this, function(i, val) {
		if ($.inArray(i, arr) == -1) {
			newArr.push(val);
		}
	})
	return newArr;
}

// 从各种物料标签中分离物料编码，批次号，序列号，返回Array[物料编码,批次号,序列号]
function splicLongMaterialCode(longMaterialCode) {
	var material = new Object();
	material.matnr = longMaterialCode.substr(0, 10); // 前十位为物料号

	if (longMaterialCode.indexOf("-") == -1) { // 不含批次号
		material.batch = "";
	} else if (longMaterialCode.indexOf("-") == 10 && longMaterialCode.indexOf("/") == -1) { // 物料编码-批次号
		material.batch = longMaterialCode.substr(11);
	} else if (longMaterialCode.indexOf("-") == 10 && longMaterialCode.indexOf("/") > 11) { // 物料编码-批次号/序列号
		material.batch = longMaterialCode.substring(longMaterialCode.indexOf("-") + 1, longMaterialCode.indexOf("/"));
	} else {
		material.batch = "";
	}

	if (longMaterialCode.indexOf("/") == -1) { // 不含序列号
		material.serial = "";
	} else if (longMaterialCode.indexOf("/") != -1 && longMaterialCode.indexOf("-") == -1) { // 物料编码/序列号
		material.serial = longMaterialCode.substr(11);
	} else if (longMaterialCode.indexOf("-") == 10 && longMaterialCode.indexOf("/") > 11) { // 物料编码-批次号/序列号
		material.serial = longMaterialCode.substr(longMaterialCode.indexOf("/") + 1);
	} else {
		material.serial = "";
	}
	return material;
}

/**
 * 向textArea中追加序列号
 * 
 * @param serial
 * @param textAreaSelector
 */
function addSerialToArea(serial, textAreaSelector) {
	var selector;
	if (!textAreaSelector) {
		selector = "#inputSerialsArea";
	} else {
		selector = textAreaSelector;
	}
	if (serial) {
		if (!$.trim($(selector).val())) {
			$(selector).val(serial);
		} else {
			$(selector).val($(selector).val() + "," + serial);
		}
	}
}

/**
 * 从序列号文本框中分离出序列号列表
 * 
 * @param textAreaSelector
 * @returns {Array}
 */
function splitSerialFromArea(textAreaSelector) {
	var selector;
	if (!textAreaSelector) {
		selector = "#inputSerialsArea";
	} else {
		selector = textAreaSelector;
	}
	var serialsArr = new Array();
	if ($.trim($(selector).val())) {
		serialsArr = $(selector).val().replace(/\s+/g, "").split(",");
	}
	return serialsArr;
}

// 计算两个数相除的百分比
function calcPercent(dividend, divisor, digit) {
	return ((dividend / divisor) * 100).toFixed(digit) + "%";
}

function changeToPercent(value, digit) {
	return (value * 100).toFixed(digit) + "%"
}

// 自定义Alert,Confirm 弹出框及其回调函数
(function() {

	var $focused = null;

	$.MsgBox = {
		Alert : function(title, msg, callback) {
			$focused = $(':focus');
			$focused.attr("disabled", true);
			GenerateHtml("alert", title, msg);
			btnOk(callback);
			btnNo();
		},
		Confirm : function(title, msg, callback) {
			$focused = $(':focus');
			$focused.attr("disabled", true);
			GenerateHtml("confirm", title, msg);
			btnOk(callback);
			btnNo();
		}
	}

	// 生成Html
	var GenerateHtml = function(type, title, msg) {

		var _html = "";

		_html += '<div id="mb_box"></div><div id="mb_con"><span id="mb_tit">' + title + '</span>';
		_html += '<a id="mb_ico">x</a><div id="mb_msg">' + msg + '</div><div id="mb_btnbox">';

		if (type == "alert") {
			_html += '<input id="mb_btn_ok" type="button" value="确定" />';
		}
		if (type == "confirm") {
			_html += '<input id="mb_btn_ok" type="button" value="确定" />';
			_html += '<input id="mb_btn_no" type="button" value="取消" />';
		}
		_html += '</div></div>';

		// 必须先将_html添加到body，再设置Css样式
		$("body").append(_html);
		GenerateCss();
	}

	// 生成Css
	var GenerateCss = function() {

		$("#mb_box").css({
			width : '320px',
			height : '320px',
			zIndex : '999',
			position : 'absolute',
			filter : 'Alpha(opacity=60)',
			backgroundColor : 'black',
			top : '0',
			left : '0',
			opacity : '0.6'
		});

		$("#mb_con").css({
			zIndex : '999999',
			width : '80%',
			position : 'absolute',
			backgroundColor : 'White',
			borderRadius : '15px'
		});

		$("#mb_tit").css({
			display : 'block',
			fontSize : '14px',
			color : '#444',
			padding : '10px 15px',
			backgroundColor : '#DDD',
			borderRadius : '15px 15px 0 0',
			borderBottom : '3px solid #009BFE',
			fontWeight : 'bold'
		});

		$("#mb_msg").css({
			padding : '20px',
			lineHeight : '20px',
			borderBottom : '1px dashed #DDD',
			fontSize : '13px'
		});

		$("#mb_ico").css({
			display : 'block',
			position : 'absolute',
			right : '10px',
			top : '9px',
			border : '1px solid Gray',
			width : '18px',
			height : '18px',
			textAlign : 'center',
			lineHeight : '16px',
			cursor : 'pointer',
			borderRadius : '12px',
			fontFamily : '微软雅黑'
		});

		$("#mb_btnbox").css({
			margin : '15px 0 10px 0',
			textAlign : 'center'
		});
		$("#mb_btn_ok,#mb_btn_no").css({
			width : '85px',
			height : '30px',
			color : 'white',
			border : 'none'
		});
		$("#mb_btn_ok").css({
			backgroundColor : '#168bbb'
		});
		$("#mb_btn_no").css({
			backgroundColor : 'gray',
			marginLeft : '20px'
		});

		// 右上角关闭按钮hover样式
		$("#mb_ico").hover(function() {
			$(this).css({
				backgroundColor : 'Red',
				color : 'White'
			});
		}, function() {
			$(this).css({
				backgroundColor : '#DDD',
				color : 'black'
			});
		});

		var _widht = document.documentElement.clientWidth; // 屏幕宽
		var _height = document.documentElement.clientHeight; // 屏幕高

		var boxWidth = $("#mb_con").width();
		var boxHeight = $("#mb_con").height();

		// 让提示框居中
		$("#mb_con").css({
			top : "50px",
			left : "11%"
		});
	}

	// 确定按钮事件
	var btnOk = function(callback) {
		$("#mb_btn_ok").click(function() {
			$("#mb_box,#mb_con").remove();
			if (typeof (callback) == 'function') {
				callback();
			}
			$focused.attr("disabled", false);
			$focused.focus();
		});
	}

	// 取消按钮事件
	var btnNo = function() {
		$("#mb_btn_no,#mb_ico").click(function() {
			$("#mb_box,#mb_con").remove();
			if (typeof (callback) == 'function') {
				callback();
			}
			$focused.attr("disabled", false);
			$focused.focus();
		});
	}
})();

/**
 * 插入表格
 * 
 * @param indexOf
 *            分页组合类在pagerArray数组中的位置，null代表无列表，直接取pager对象。
 * @param pn
 *            强制指定显示第几页
 */
function generateTableList(indexOf, pn) {

	// 默认pagination对象名为pager
	var iPager;
	// 当页面存在多个pager对象时，就将pagers放在pagerArray数组中，参数iPager仅指定所在数组的下标
	if (indexOf === undefined || indexOf == null) {
		iPager = pager;
	} else {
		iPager = pagerArray[indexOf];
	}

	if (typeof (iPager.preCheck) == 'function') {
		if (!iPager.preCheck()) {
			return;
		}
	}

	iPager.pageCount = Math.ceil(iPager.list.length / iPager.pageSize); // 重新计算总页数
	// 上一页、下一页有指定特定页
	if (pn) {
		iPager.pageNumber = pn;
	}
	// 删除最有一页所有数据，会出现当前页大于总页数的情况
	if (iPager.pageNumber > iPager.pageCount) {
		iPager.pageNumber = iPager.pageCount;
	}

	var paraLength = iPager.paraArr.length; // 显示列个数
	var appendString = "";
	// 清空原有列表
	$("#" + iPager.tableTitle).nextAll(".data_cell").remove();
	// 遍历一页数据
	for (var i = (iPager.pageNumber - 1) * iPager.pageSize; i < iPager.pageNumber * iPager.pageSize; i++) {
		var obj = iPager.list[i];
		if (obj != null) {
			appendString += "<tr class = 'data_cell'>";
			// 依次添加需要渲染的属性
			for (var x = 0; x < paraLength; x++) {
				var p = iPager.paraArr[x];
				// "_radio","_checkbox","_text"为保留属性，生成控件
				// radio,checkbox对应的value值为数组下标; text对应的name值为数组下标
				if (p == "_radio") {
					if (indexOf === undefined || indexOf == null) {
						appendString += "<td><input type='radio' name='radio_' value='" + i + "'></td>";
					} else { // 页面有多个pager，为radio的name属性赋值："radio_" + 下标
						appendString += "<td><input type='radio' value='" + i + "' name='" + "radio_" + indexOf
								+ "'></td>";
					}
				} else if (p == "_checkbox") {
					appendString += "<td><input type='checkbox' value='" + i + "'></td>";
				} else if (p.indexOf("_text") == 0) {
					if (p.indexOf("[class=") == 5) {
						var className = p.substring(p.indexOf("[class=") + 7, p.indexOf("]"));
						appendString += "<td><input type='text' " + "class = '" + className + "'" + " name = '" + i
								+ "'></td>";
					} else {
						appendString += "<td><input type='text' name = '" + i + "'></td>";
					}
				} else {

					var objx = obj;

					if (p.indexOf("/") != -1) {
						objx = "";
						var sp = p.split("/");
						$.each(sp, function(n, value) {
							if (n > 0) {
								objx += "/";
							}
							objx += obj[value];
						});
					} else {
						var px = p.split(".")
						for (var y = 0; y < px.length; y++) {
							objx = objx[px[y]];
						}
					}

					appendString += "<td>" + objx + "</td>";
				}
			}
			appendString += "</tr>";
		} else { // 保证每页行高
			appendString += "<tr class = 'data_cell'><td></td></tr>";
		}
	}

	// 上一页-下一页 按钮
	if (iPager.pageCount > 1) {
		var previousNextPageAppendString = "<tr class = 'data_cell'>";
		for (var j = 0; j < paraLength; j++) {
			previousNextPageAppendString += "<td>";
			// 当前页大于1，显示“上一页”按钮
			if ((j == Math.floor(paraLength / 2) - 1) && iPager.pageNumber > 1) {
				previousNextPageAppendString += "<input type='button' value='上翻' onclick=previousPage(" + indexOf
						+ ")>";
			} else if ((j == Math.floor(paraLength / 2)) && iPager.pageNumber < iPager.pageCount) {
				previousNextPageAppendString += "<input type='button' value='下翻' onclick=nextPage(" + indexOf + ")>";
			} else {
				previousNextPageAppendString += "</td>";
			}
		}
		previousNextPageAppendString += "</tr>";
		appendString += previousNextPageAppendString;
	}
	$("#" + iPager.tableTitle).after(appendString);

	// 回调函数
	if (typeof (iPager.callback) == 'function') {
		iPager.callback();
	}
}

function nextPage(indexOf) {
	if (indexOf === undefined || indexOf == null) {
		generateTableList(null, ++basePager.pageNumber);
	} else {
		generateTableList(indexOf, ++pagerArray[indexOf].pageNumber);
	}
}

function previousPage(indexOf) {
	if (indexOf === undefined || indexOf == null) {
		generateTableList(null, --basePager.pageNumber);
	} else {
		generateTableList(indexOf, --pagerArray[indexOf].pageNumber);
	}
}

// 判断字符串是否为合法小数
function isFloat(str) {
	var reg = /^(([0-9]+.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*.[0-9]+)|([0-9]*[1-9][0-9]*))$/;
	return reg.test(str);
}

/**
 * outbound tr创建to
 * 
 * @param LGNUM
 *            仓库号
 * @param TBNUM
 *            TR号码
 */
function obTrCreateTo() {
	var i = $("input[type='radio']:checked").val();
	if (i != null) {
		// AJAX提交
		$.ajax({
			url : "create_to_outbound!trCreateTo.action",
			data : {
				TBNUM : pager.list[i].TBNUM,
				LGNUM : ""
			},
			dataType : "json",
			async : false,
			success : function(result) {
				if (result["msgType"] == "S") {
					$.MsgBox.Alert("消息", "成功创建TO: " + result["toNumber"]);
					// 删除
					pager.list.remove(i);
					generateTableList();
				} else {
					$.MsgBox.Alert("失败", result["msg"]);
				}
			}
		});
	} else {
		$.MsgBox.Alert("消息", "请选择一条数据！");
	}
}
