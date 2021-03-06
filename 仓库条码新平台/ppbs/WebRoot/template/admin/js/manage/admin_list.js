jQuery(function($) {
	var grid_selector = "#grid-table";
	var pager_selector = "#grid-pager";
	// resize to fit page size
	$(window).on('resize.jqGrid', function() {
		$(grid_selector).jqGrid('setGridWidth', $(".page-content").width());
	})
	// resize on sidebar collapse/expand
	var parent_column = $(grid_selector).closest('[class*="col-"]');
	$(document).on('settings.ace.jqGrid', function(ev, event_name, collapsed) {
		if (event_name === 'sidebar_collapsed' || event_name === 'main_container_fixed') {
			// setTimeout is for webkit only to give time for DOM changes and
			// then redraw!!!
			setTimeout(function() {
				$(grid_selector).jqGrid('setGridWidth', parent_column.width());
			}, 0);
		}
	})

	$("#grid-table").jqGrid({
		url : "admin!adminList.action",
		datatype : "json",
		height : "100%",// weitao 修改此参数可以修改表格的高度
		jsonReader : {
			repeatitems : false,
			root : "list",
			total : "pageCount",
			records : "totalCount"
		},
		prmNames : {
			rows : "pager.pageSize",
			page : "pager.pageNumber",
			search : "pager._search",
			sort : "pager.orderBy",
			order : "pager.orderType"

		},
		colModel : [ 
		    {name : 'username',index : 'username',label : "登录名",width : 80,sortable : "true",sorttype : "text"}, 
			{name : 'email',index : 'email',label : "E-mail",width : 200,sortable : "true",sorttype : "text"}, 
			{name : 'name',index : 'name',label : "姓名",width : 160,editable : true,sortable : "true",sorttype : "text"}, 
			{name : 'department',index : 'department',label : "所属部门",width : 140,editable : true,sortable : "true",sorttype : "text"}, 
			{name : 'factory',label : "所属工厂",width : 140,index : 'factory',editable : true,sortable : "true",sorttype : "text"}, 
			{name : 'loginDate',label : "最后登陆时间",width : 160,index : 'loginDate',editable : true,sortable : "true",sorttype : "date",unformat : pickDate,formatter : datefmt}, 
			{name : 'createDate',label : "创建时间",width : 160,index : 'createDate',editable : true,sortable : "true",sorttype : "date",unformat : pickDate,formatter : datefmt},
			{name : 'loginIp',index : 'loginIp',label : "最后登陆IP",width : 140,sortable : "true",sorttype : "text"}, 
			{name : 'isAccountEnabledx',index : 'isAccountEnabled',width : 60,label : "状态",cellattr : addstyle,sortable : "true",sorttype : "text",editable : true,search : true,stype : "select",
			searchoptions : {dataUrl : "dict!getDict1.action?dict.dictname=isAccountEnabled"}}, 
		],
		viewrecords : true,
		rowNum : 10,
		rowList : [ 10, 20, 30 ],
		pager : pager_selector,
		altRows : true,
		// toppager: true,

		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,

		loadComplete : function() {
			var table = this;
			setTimeout(function() {
				styleCheckbox(table);

				updateActionIcons(table);
				updatePagerIcons(table);
				enableTooltips(table);
			}, 0);
		},
		editurl : "admin!delete.action",// 用它做标准删除动作
		caption : "操作员列表"

	});
	$(window).triggerHandler('resize.jqGrid');// trigger window resize to make
	// the grid get the correct size

	// 给状态加样式
	function addstyle(rowId, val, rawObject, cm, rdata) {
		// 已启用
		if (rawObject.isAccountEnabledx == "已启用") {
			return "style='color:green;font-weight:bold;'";
		}
		// 未启用
		if (rawObject.isAccountEnabledx == "未启用") {
			return "style='color:red;font-weight:bold;'";
		}
		
	}
	// navButtons
	jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar
		// options
		edit : true,
		 editfunc : function(rowId) {
		    	var ids = $("#grid-table").jqGrid('getGridParam','selarrrow');
		    	if(ids.length>1){
		    		alert("只能选择一条记录！");
		    		return false;
		    	}
				window.location.href = "admin!edit.action?id=" + rowId;
			},
		add : false,
		del : true,
		search : false,
		searchicon : 'ace-icon fa fa-search orange',
		refresh : true,
		refreshicon : 'ace-icon fa fa-refresh green',
		view : true,
		viewicon : 'ace-icon fa fa-search-plus grey',
	}, {
		// edit record form
		// closeAfterEdit: true,
		// width: 700,
		recreateForm : true,
		beforeShowForm : function(e) {
			var form = $(e[0]);
			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
			style_edit_form(form);
		}
	}, {
		// new record form
		// width: 700,
		closeAfterAdd : true,
		recreateForm : true,
		viewPagerButtons : false,
		beforeShowForm : function(e) {
			var form = $(e[0]);
			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
			style_edit_form(form);
		}
	}, {
		// delete record form
		recreateForm : true,
		beforeShowForm : function(e) {
			var form = $(e[0]);
			if (form.data('styled'))
				return false;

			form.closest('.ui-jqdialog').find('.ui-jqdialog-titlebar').wrapInner('<div class="widget-header" />')
			style_delete_form(form);

			form.data('styled', true);
		},
		onClick : function(e) {
			alert(1);
		}
	}, {
		// search form
		recreateForm : true,
		afterShowSearch : function(e) {
			var form = $(e[0]);
			form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
			style_search_form(form);
		},
		afterRedraw : function() {
			style_search_filters($(this));
		},
		multipleSearch : true,

		multipleGroup : false,
		showQuery : true

	}, {
		// view record form
		recreateForm : true,
		beforeShowForm : function(e) {
			var form = $(e[0]);
			form.closest('.ui-jqdialog').find('.ui-jqdialog-title').wrap('<div class="widget-header" />')
		}
	})

	// 查看
	$("#btn_show").click(function() {
		if (getId2()) {
			location.href = "pick_detail!historyView.action?id=" + id;
		}
	});

});

// 获取jqGrid表中选择的条数--即数据的ids
function getId() {
	id = $("#grid-table").jqGrid('getGridParam', 'selarrrow');
	if (id == null || id == "") {
		layer.msg("请选择一条记录!", {
			icon : 5
		});
		return false;
	}
	return true;
}

// 得到1条id
function getId2() {
	id = $("#grid-table").jqGrid('getGridParam', 'selarrrow');
	if (id.length == 1) {
		return true;
	} else {
		layer.msg("请选择一条记录!", {
			icon : 5
		});
		return false;
	}	
}
$().ready( function() {
// 搜索按钮
$("#searchButton2").click(function() {	
	var rules = "";
			rules = '"' + $("#selected").val() + '":"' + $("#form-field-icon-1").val() + '"';	
	ParamJson = '{' + rules + '}';
	var postData = $("#grid-table").jqGrid("getGridParam", "postData");
    $.extend(postData, { Param: ParamJson });
    $("#grid-table").jqGrid("setGridParam", { search: true,datatype:"json" }).trigger("reloadGrid", [{ page: 1}]);  // 重载JQGrid
	return false;
});})