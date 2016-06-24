function print_event(id,type)
{
	var rowData = $("#grid-table").jqGrid('getRowData',id);
	var urls=["","materialprint","batchidprint","serialnumberprint","batchidserialnumberprint"];
	var url="bar_code!"+urls[type]+".action";
	url+="?order="+rowData.EBELN+"&factory="+rowData.WERKS+"&matnr="+rowData.MATNR+"&descrip="+rowData.MAKTX;
	url=encodeURI(url);
	openDialog(url,1);
}
function reprint_event(id,type)
{
	var rowData = $("#grid-table").jqGrid('getRowData',id);
	var urls=["","","batchidreprint","serialnumberreprint","batchidserialnumberreprint"];
	var url="bar_code!"+urls[type]+".action";
	url+="?order="+rowData.EBELN+"&factory="+rowData.WERKS+"&matnr="+rowData.MATNR+"&descrip="+rowData.MAKTX;
	url=encodeURI(url);
	openDialog(url,2);
}

function openDialog(url,type)
{
	var w='80%';
	var h='80%';
	if(type==1)
	{
		w='1000px';
		h='430px';
	}
	var myDialog=layer.open(
	{
		skin : 'layui-layer-lan',
		area : [ w,h ],
		btn : [ '关闭'],
		title : "",
		type : 2,
		shadeClose : true, // 点击遮罩关闭
		content : url,
		yes : function() 
		{		
			layer.close(myDialog);
			
		}
	});
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
		url : "bar_code!getPurchaseLineItemList.action",
		datatype : "json",
		height : "350",// weitao 修改此参数可以修改表格的高度
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
			name : 'EBELN',
			index : 'EBELN',
			label : "采购订单",
			width : 100,
			sortable : "true",
			sorttype : "text"
		},
		 {
			name : 'NAME1',
			index : 'NAME1',
			label : "供应商名称",
			width : 160,
			sortable : "true",
			sorttype : "text"
		}, {
			name : 'WERKS',
			index : 'WERKS',
			label : "工厂",
			width : 100,
			sortable : "true",
			sorttype : "text"
		},{
			name : 'MATNR',
			index : 'MATNR',
			label : "物料编码",
			width : 100,
			sortable : "true",
			sorttype : "text"
		}, {
			name : 'MAKTX',
			index : 'MAKTX',
			label : "物料描述",
			width : 250,
			sortable : "true",
			sorttype : "text"
		},  
		{
			name : 'LBPRT',
			index : 'LBPRT',
			label : "LBPRT",
			width : 200,
			hidden:true			
		},  
		{			
			name:'lbprt',
			label : "打印类型",
			width : 80,
			sortable : "false"		
		},  
		{			
			name:'toedit',
			label : "操作",
			width : 100,
			sortable : "false"		
		}
		 ],

	
		altRows : true,
		// toppager: true,

		multiselect : true,
		// multikey: "ctrlKey",
		multiboxonly : true,
		
		gridComplete : function() {
       	 var ids = jQuery(grid_selector).jqGrid('getDataIDs');
       	 for ( var i = 0; i < ids.length; i++) {        		 
       		var cl = ids[i];        		
       		var rowData = $("#grid-table").jqGrid('getRowData',cl); 
       		var strs=["","物料","物料批次","物料序列号","物料批次序列号"];
       		var lbprt=strs[rowData.LBPRT];
       		var be="<a onclick=print_event('"+cl+"','"+rowData.LBPRT+"') href='javascript:void(0)'>[打印]</a>";
       		if(rowData.LBPRT>1)
       		{
       			be += "<a onclick=reprint_event('"+cl+"','"+rowData.LBPRT+"') href='javascript:void(0)'>[补打]</a>";
       		}      		
       		jQuery(grid_selector).jqGrid('setRowData', cl, { lbprt : lbprt });
       		jQuery(grid_selector).jqGrid('setRowData', cl, { toedit : be });
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
		caption : "订单详情"

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
	
	
	$(document).keyup(function (evnet) {
		if (evnet.keyCode == '13') {
			$("#mySearchButton").click();
		}
	});
	
	
	
// 搜索按钮
$("#mySearchButton").click(function() {
	/*if($("#matnr").val()=="" || $("#factory").val()=="")
	{
		alert("请填写工厂以及物料编号!");
		return false;
	}*/
	var rules = '"ebeln":"' + $("#ebeln").val() + '"';	
	ParamJson = '{' + rules + '}';
	var postData = $("#grid-table").jqGrid("getGridParam", "postData");
    $.extend(postData, { Param: ParamJson });
    $("#grid-table").jqGrid("setGridParam", { search: true,datatype:"json" }).trigger("reloadGrid", [{ page: 1}]);  // 重载JQGrid
	return false;
});})