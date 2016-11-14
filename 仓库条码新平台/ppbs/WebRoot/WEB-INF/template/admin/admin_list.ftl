<#assign sec=JspTaglibs["/WEB-INF/security.tld"] />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>操作员列表 - Powered By ${systemConfig.systemName}</title>
<meta name="description"
	content="Dynamic tables and grids using jqGrid plugin" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<#include "/WEB-INF/template/common/include.ftl"> 
<script src="${base}/template/admin/assets/js/jqGrid/jquery.jqGrid.min.js"></script>
<script src="${base}/template/admin/assets/js/jqGrid/i18n/grid.locale-cn.js"></script>
<link href="${base}/template/admin/css/list.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript"
	src="${base}/template/admin/js/jqgrid_common.js"></script>
<#include "/WEB-INF/template/common/include_adm_top.ftl">
<script type="text/javascript"
	src="${base}/template/admin/js/manage/admin_list.js"></script>
<style>
body {
	background: #fff;
}
</style>
</head>
<body class="list no-skin">
	<#include "/WEB-INF/template/admin/admin_navbar.ftl">

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<#include "/WEB-INF/template/admin/admin_sidebar.ftl">
		<div class="main-content">
			<#include "/WEB-INF/template/admin/admin_acesettingbox.ftl">
			<div class="breadcrumbs" id="breadcrumbs">
				<script type="text/javascript">
					try {
						ace.settings.check('breadcrumbs', 'fixed')
					} catch (e) {
					}
				</script>
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a
						href="admin!index.action">管理中心</a></li>
					<li class="active">操作员列表&nbsp;<span class="pageInfo">总记录数:
							${pager.totalCount} (共${pager.pageCount}页)</span>
					</li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<!-- add by welson 0728 -->
			<div class="page-content">
				<div class="page-content-area">

					<div class="row">
						<div class="col-xs-12">
							<!-- ./ add by welson 0728 -->
							<form id="searchform" class="pdl10" action="admin!list.action"
								method="post">
								<div class="operateBar">
									<a id="addButton"
										class="btn btn-white btn-sm btn-info btn-round"
										href="admin!add.action"> <i
										class="ace-icon fa fa-pencil-square-o blue"></i> 添加操作员 </a> <select
										name="pager.property" id="selected">
										<option value="username"<#if pager.property ==
											"username">selected="selected" </#if>> 登录名</option>
										<option value="name"<#if pager.property ==
											"name">selected="selected" </#if>> 姓名</option>
									</select> <input type="text" name="pager.keyword" class="input input-sm"
										value="${pager.keyword!}" id="form-field-icon-1"> <a
										id="searchButton2"
										class="btn btn-white btn-default btn-sm btn-round"> <i
										class="ace-icon fa fa-filter blue"></i> 搜 索 </a>
								</div>
							</form>
							<div class="row">
								<div class="col-xs-12">
									<table id="grid-table"></table>
									<div id="grid-pager"></div>
								</div>
							</div>
						</div>

					</div>
					<!-- /.row -->

					<!-- PAGE CONTENT ENDS -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row -->
		</div>
		<!-- /.page-content-area -->
		<#include "/WEB-INF/template/admin/admin_footer.ftl">
	</div>
	<!-- /.page-content -->


	</div>

	</div>

	<#include "/WEB-INF/template/common/include_adm_bottom.ftl">

	<!-- ./ add by welson 0728 -->


</body>
</html>
