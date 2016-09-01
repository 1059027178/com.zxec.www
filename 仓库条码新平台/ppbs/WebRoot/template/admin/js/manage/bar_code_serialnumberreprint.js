function print_event(id)
{
	var rowData = $("#grid-table").jqGrid('getRowData',id);	
	print(rowData.descrip,rowData.sernr);		
}

function print_event_little(id)
{
	var rowData = $("#grid-table").jqGrid('getRowData',id);	
	printLittle(rowData.descrip,rowData.sernr);		
}

function print(maktx,serialNumber)
{
	printBigLable(serialNumber,maktx);
}

function printLittle(maktx,serialNumber)
{
	printLittleLable(serialNumber,maktx);
}


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
		url : "bar_code!getSerialNumberList.action?factory="+$("#factory").val()+"&matnr="+$("#matnr").val(),		
		datatype : "json",
		height : "300",// weitao 修改此参数可以修改表格的高度
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
		 {
			name : 'orderCode',
			index : 'orderCode',
			label : "采购订单号",
			width : 100,
			sortable : "true",
			sorttype : "text"
		},{
			name : 'factory',
			index : 'factory',
			label : "工厂",
			width : 100,
			sortable : "true",
			sorttype : "text"
		}, {
			name : 'matnr',
			index : 'matnr',
			label : "物料编号",
			width : 80,
			sortable : "true",
			sorttype : "text"
		}, {
			name : 'descrip',
			index : 'descrip',
			label : "物料描述",
			width : 200,
			sortable : "true",
			sorttype : "text"
		}, 
		/*{
			name : 'lifnr',
			index : 'lifnr',
			label : "批次号",
			width : 160,
			editable : false,
			sortable : "true",
			sorttype : "text"			
		},*/ 
		{
			name : 'sernr',
			index : 'sernr',
			label : "序列号",
			width : 120,
			editable : false,
			sortable : "true",
			sorttype : "text"			
		}, 
		{			
			name:'toedit',
			label : "操作",
			width : 100,
			sortable : "false"		
		}
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
		
		gridComplete : function() {
       	 var ids = jQuery(grid_selector).jqGrid('getDataIDs');
       	 for ( var i = 0; i < ids.length; i++) {        		 
       		var cl = ids[i];        		
       		var rowData = $("#grid-table").jqGrid('getRowData',ids[i]);
       		var be = "<a onclick=print_event('"+cl+"') href='javascript:void(0)'>[打印大标签]</a><a onclick=print_event_little('"+cl+"') href='javascript:void(0)'>[打印小标签]</a>";
       		       		
       		jQuery(grid_selector).jqGrid('setRowData', ids[i], { toedit : be });
       	 }
       },
		loadComplete : function() {
			var table = this;
			setTimeout(function() {
				styleCheckbox(table);

				updateActionIcons(table);
				updatePagerIcons(table);
				enableTooltips(table);
			}, 0);
		},
		//editurl : "admin!delete.action",// 用它做标准删除动作
		caption : "序列号列表"

	});
	$(window).triggerHandler('resize.jqGrid');// trigger window resize to make
	// the grid get the correct size

	
	// navButtons
	jQuery(grid_selector).jqGrid('navGrid', pager_selector, { // navbar
		// options
		edit : false,
		 editfunc : function(rowId) {
		    	var ids = $("#grid-table").jqGrid('getGridParam','selarrrow');
		    	if(ids.length>1){
		    		alert("只能选择一条记录！");
		    		return false;
		    	}				
			},
		add : false,
		del : false,
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

	

});



$().ready( function() {
// 搜索按钮
$("#mySearchButton").click(function() {
	/*if($("#matnr").val()=="" || $("#factory").val()=="")
	{
		alert("请填写工厂以及物料编号!");
		return false;
	}*/
	var rules = '"matnr":"' + $("#matnr").val() + '";"factory":"'+$("#factory").val()+'"';	
	ParamJson = '{' + rules + '}';
	var postData = $("#grid-table").jqGrid("getGridParam", "postData");
    $.extend(postData, { Param: ParamJson });
    $("#grid-table").jqGrid("setGridParam", { search: true,datatype:"json" }).trigger("reloadGrid", [{ page: 1}]);  // 重载JQGrid
	return false;
});})