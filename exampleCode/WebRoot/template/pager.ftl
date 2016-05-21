<script type="text/javascript" src="${base}/template/common/js/jquery.pager.js"></script>
<script type="text/javascript">
$().ready( function() {
	
	var $pager = $("#pager");
	
	$pager.pager({
		pagenumber: ${pager.pageNumber},
		pagecount: ${pager.pageCount},
		buttonClickCallback: $.gotoPage
	});

})
</script>
<div class="row">
    <div class="col-sm-5">
        <div class="dataTables_info" id="editable_info" role="status" aria-live="polite"><label>每页显示: </label>
	<select name="pager.pageSize" id="pageSize">
		<option value="10"<#if pager.pageSize == 10> selected</#if>>
			10
		</option>
		<option value="20"<#if pager.pageSize == 20> selected</#if>>
			20
		</option>
		<option value="50"<#if pager.pageSize == 50> selected</#if>>
			50
		</option>
		<option value="100"<#if pager.pageSize == 100> selected</#if>>
			100
		</option>
	</select>
	&nbsp;&nbsp;总记录数: ${pager.totalCount} (共${pager.pageCount}页)</div></div>
    <div class="col-sm-7">
        <div class="dataTables_paginate paging_simple_numbers" id="editable_paginate">

			<span id="pager"></span>
			<input type="hidden" name="pager.pageNumber" id="pageNumber" value="${pager.pageNumber}" />
			<input type="hidden" name="pager.orderBy" id="orderBy" value="${pager.orderBy}" />
			<input type="hidden" name="pager.order" id="order" value="${pager.order}" />
			</div>
 
    </div>
</div>
