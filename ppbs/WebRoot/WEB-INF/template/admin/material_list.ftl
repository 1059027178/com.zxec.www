<#assign sec=JspTaglibs["/WEB-INF/security.tld"] />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title>物料列表 - Powered By ${systemConfig.systemName}</title>
<link rel="icon" href="favicon.ico" type="image/x-icon" />
<#include "/WEB-INF/template/common/include.ftl">
<link href="${base}/template/admin/css/list.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${base}/template/admin/js/list.js"></script>
<script type="text/javascript" src="${base }/template/admin/js/LodopFuncs.js"></script>
<script src='http://localhost:8000/CLodopfuncs.js'></script>
<#include "/WEB-INF/template/common/include_adm_top.ftl">
<style>
body{background:#fff;}
</style>
<script type="text/javascript">
	
	$(function(){
		$(".barcode").click(function(){
			//物料大标签
 		/* 	LODOP.PRINT_INIT("条码打印");
			LODOP.SET_PRINT_PAGESIZE(1,"80mm","40mm","物料标签");//宽度 40mm 高度 80mm 
			LODOP.ADD_PRINT_BARCODE("2mm","2mm","20mm","20mm","QRCode","22");		
			var path="${rootPath}";
			var img="<html><img src='"+path+"/template/admin/images/nn.png'></img><html>";
			LODOP.ADD_PRINT_HTM("2mm","32mm","59mm","15mm",img);
			LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//(可变形)扩展缩放模式
			LODOP.ADD_PRINT_TEXT("10mm","26mm","53mm","20mm","总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速");
			LODOP.SET_PRINT_STYLEA(0,"FontSize",9);
			LODOP.ADD_PRINT_BARCODE("25mm","5mm","75mm","10mm","128Auto","1222121212/1122345676123234");
			LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
			LODOP.ADD_PRINT_TEXT("37mm","20mm","40mm","4mm","1222121212/1122345676123234");
			LODOP.SET_PRINT_STYLEA(0,"FontSize",7);   
			LODOP.SET_PRINT_STYLEA(5,"Horient",2); 
			
			LODOP.PRINT(); */
			//物料小标签
		 	LODOP.PRINT_INIT("条码打印");
			LODOP.SET_PRINT_PAGESIZE(1,"60mm","20mm","物料标签");//宽度 40mm 高度 80mm 
			LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
			LODOP.ADD_PRINT_BARCODE("1mm","1mm","15mm","15mm","QRCode","343545");		
			
			var path="${rootPath}";
			var img="<html><img src='"+path+"/template/admin/images/little_nnLogo.png'></img><html>";
			LODOP.ADD_PRINT_HTM("1mm","15mm","42mm","10mm",img);
			LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//(可变形)扩展缩放模式
		
			var htm="<p style=\"word-break:break-all;width:170px;height:20px;line-height:10px;font-size:6pt\">总速总速总速总速总速总速总速总速总</p>";
			LODOP.ADD_PRINT_HTM("6mm","13mm","48mm","8mm",htm);
		//	LODOP.ADD_PRINT_TEXT("7mm","13mm","48mm","8mm","总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速总速");
		//	LODOP.SET_PRINT_STYLEA(0,"FontSize",6);
			LODOP.ADD_PRINT_BARCODE("13mm","3mm","58mm","5mm","128Auto","1222121212/1122345676123234");
			LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);
			LODOP.ADD_PRINT_TEXT("18mm","15mm","35mm","2mm","1222121212/1122345676123234");
			LODOP.SET_PRINT_STYLEA(0,"FontSize",5);   
			
			//库存位置标签
			/* LODOP.PRINT_INIT("条码打印");
			LODOP.SET_PRINT_PAGESIZE(1,"80mm","40mm","物料标签");//宽度 40mm 高度 80mm 
			var path="${rootPath}";
			var img="<html><img src='"+path+"/template/admin/images/nn.png'></img><html>";
			LODOP.ADD_PRINT_HTM("2mm","32mm","59mm","15mm",img);
			LODOP.SET_PRINT_STYLEA(0,"Stretch",1);//(可变形)扩展缩放模式
			LODOP.ADD_PRINT_TEXT("10mm","15mm","50mm","10mm","A1-B2-C3-4");
			LODOP.SET_PRINT_STYLEA(0,"FontSize",24);
			LODOP.SET_PRINT_STYLEA(0,"Horient",2);
			 LODOP.SET_PRINT_STYLEA(0, "Bold", 1);
			LODOP.ADD_PRINT_BARCODE("20mm","3mm","79mm","18mm","128Auto","1234343454/2434544567");
			LODOP.SET_PRINT_STYLEA(0,"ShowBarText",0);	 */
			LODOP.PREVIEW();
		//	LODOP.PRINT();
		});
	})
	
</script>
</head>
<body class="list no-skin">
<#include "/WEB-INF/template/admin/admin_navbar.ftl">

<div class="main-container" id="main-container">
	<script type="text/javascript">
		try{ace.settings.check('main-container' , 'fixed')}catch(e){}
	</script>
	
	<#include "/WEB-INF/template/admin/admin_sidebar.ftl">
	
	<div class="main-content">
	
	<#include "/WEB-INF/template/admin/admin_acesettingbox.ftl">


	
	<div class="breadcrumbs" id="breadcrumbs">
		<script type="text/javascript">
			try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
		</script>

		<ul class="breadcrumb">
			<li>
				<i class="ace-icon fa fa-home home-icon"></i>
				<a href="admin!index.action">管理中心</a>
			</li>
			<li class="active">物料列表&nbsp;<span class="pageInfo"></span></li>
		</ul><!-- /.breadcrumb -->
	</div>
	
	
	<!-- add by welson 0728 -->
	<div class="page-content">
					<div class="page-content-area">					

						<div class="row">
							<div class="col-xs-12">
								<!-- ./ add by welson 0728 -->
							<div class="panel panel-default" style="margin-bottom: 0px;">
    <div class="panel-heading">
      <span style="font-size:15px;">条件搜索</span>
    </div>
    <div class="panel-body">
      <form class="form-horizontal" id="listForm" action="material!list.action" method="post">
								   <div class="operateBar">
								   <div class="form-group">
										<label class="col-sm-1 col-md-offset-1" style="text-align:right">物料编码:</label>
										<div class="col-sm-4">
											<input type="text" name="promotionCode" class="input input-sm form-control" value="" id="form-field-icon-1">
										</div>
										
										
										<label class="col-sm-1" style="text-align:right">批次:</label>
										<div class="col-sm-4">
											<input type="text" name="promotionName" class="input input-sm form-control" value="" id="form-field-icon-1">
										</div>
									</div>
								   
								   
								   
								   	<div class="form-group">
										<label class="col-sm-1 col-md-offset-1" style="text-align:right">序列号:</label>
										<div class="col-sm-4">
											<input type="text" name="promotionCode" class="input input-sm form-control" value="" id="form-field-icon-1">
										</div>
									</div>	
										<div class="form-group" style="text-align:center">
											<button id="searchButton" class="btn btn-white btn-default btn-sm btn-round">
												<i class="ace-icon fa fa-filter blue"></i>
												搜索
											</button>
										</div>
										
									</div>
								</form>
    </div>
    <!--
    <div class="panel-heading" style="border-top: 1px #dddddd solid; border-radius: 0px;">
      <div>
        <a href="javascript:void(0);" id="_add">新增</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="javascript:void(0);" id="_delete">删除</a>
      </div>
    </div>
    -->
  </div>
  <br>
		<div align="right">
<label class="label label-xlg label-white" style="background-color:#fff!important;color:#777;">每页显示:</label>
				<select name="pager.pageSize" id="pageSize">
					<option value="10" <#if pager.pageSize == 10>selected="selected" </#if>>
						10
					</option>
					<option value="20" <#if pager.pageSize == 20>selected="selected" </#if>>
						20
					</option>
					<option value="50" <#if pager.pageSize == 50>selected="selected" </#if>>
						50
					</option>
					<option value="100" <#if pager.pageSize == 100>selected="selected" </#if>>
						100
					</option>
				</select>
				</div>
			<table class="table table-striped table-bordered table-hover">
				<tr>
					<th class="check">
						<input type="checkbox" class="allCheck" />
					</th>
					<th>
						<span class="sort" name="username">物料编号</span>
					</th>
					<th>
						<span class="sort" name="email">物料描述</span>
					</th>
					<th>
						操作
					</th>
				</tr>
				<#list pager.list as list>
					<tr>
						<td>
							<input type="checkbox" name="ids" value="${list.id}" />
						</td>
							<td>
							${list.code }
						</td>
						<td>
							${list.description }
						</td>
						
						<td>
							<a href="javascript:void(0);" class="barcode">[打印]</a>
						</td>
					</tr>
				</#list>
			</table>
			<#if (pager.list?size > 0)>
				<div class="pagerBar">
					<input type="button" class="deleteButton btn btn-white btn-default btn-sm btn-round " url="admin!delete.action" value="删 除" disabled hidefocus="true" />
					<#include "/WEB-INF/template/admin/pager.ftl" />
				</div>
			<#else>
				<div class="noRecord">
					没有找到任何记录!
				</div>
			</#if>
		</form>
		


				<!-- PAGE CONTENT ENDS -->
			</div><!-- /.col -->
		</div><!-- /.row -->
	</div><!-- /.page-content-area -->
	<#include "/WEB-INF/template/admin/admin_footer.ftl">
</div><!-- /.page-content -->
				
		
				</div>
		
	</div>

	<#include "/WEB-INF/template/common/include_adm_bottom.ftl">
	
	<!-- ./ add by welson 0728 -->

	
</body>
</html>
