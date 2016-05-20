<%@page import="com.exampleCode.model.PositionsInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List list = (List) request.getAttribute("resultList");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>物料查询结果</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link href="./css/jiuhui_list.css" rel="stylesheet"/>
<script src="./js/jquery.js"></script>
<script src="./jquery.pagination_2/demo/lib/jquery.min.js"></script>
<script src="./jquery.pagination_2/jquery.pagination.js"></script>
<link href="./jquery.pagination_2/pagination.css" rel="stylesheet"/>
<style type="text/css">
    body {
      padding-top: 40px;
      padding-bottom: 0px;
    }
    .sidebar-nav {
      padding: 0;
    }
</style>
<script>
function submit1(obj){
  	obj.disabled=false;
  	document.form.submit();
}		
function turnon(){
  	window.location.href="MainServlet?flag=4.1";
}
  
function keyDown() {
       var keycode = event.keyCode;
       var realkey = String.fromCharCode(event.keyCode);
      // alert("按键码: " + keycode + " 字符: " + realkey);
       if(keycode=='13'){
       		js();
       }
}
document.onkeydown = keyDown;	
//-------------------------------分页
$(function(){
	//总数目
	var length = <%=list.size()%>;
	//从表单获取分页元素参数
	var optInit = getOptionsFromForm();
	$("#Pagination").pagination(length, optInit);
	
	//-----------------------------------
	function getOptionsFromForm(){
		var opt = {callback: pageselectCallback}; //回调函数：默认无执行效果
		opt.items_per_page = 4;		//每页显示的条目数(可选参数，默认是10)
		opt.num_display_entries = 0;//连续分页主体部分显示的分页条目数(可选参数，默认是10)
		opt.num_edge_entries = 0;	//两侧显示的首尾分页的条目数(可选参数，默认是0)
		opt.prev_text = "上一页";	//“前一页”分页按钮上显示的文字(字符串参数，可选，默认是"Prev")
		opt.next_text = "下一页";	//“下一页”分页按钮上显示的文字(字符串参数，可选，默认是"Next")
		return opt;
	}
	//-------------------------------
	function pageselectCallback(page_index , jq){
		//每页的显示的列表项数目
		var items_per_page = 4;
		var max_elem = Math.min((page_index+1) * items_per_page, length);
		$("#tr_list_1").html("");//必须要有
		// 获取加载元素
		for(var i = page_index * items_per_page ; i < max_elem ; i++){
			<%int index = 0;%>
			<%=index%> = i;
			<% PositionsInfo info = (PositionsInfo)list.get(index);%>
			var html = "<tr class='tr_list_2' >"+
							"<td class='td_list'><%=index + 1 %></td>"+
							"<td class='td_list'><%=info.getLiteraNO() %></td>"+
							"<td class='td_list'><%=info.getBatchNO() %></td>"+
						"</tr>"+
						"<tr class='tr_list_2' >"+
							"<td class='td_list' ><%=info.getStorageLocation() %></td>"+
							"<td class='td_list"><%=info.getNumber() %></td>"+
							"<td class='td_list'><%=info.getUnit() %></td>"+
						"</tr>";
			$("#tr_list_1").append(html);
		}
		//阻止单击事件
		return false;	
	}
});
</script>
</HEAD>
<BODY>
<!-- 分页测试 -->
<div id="Pagination" class="pagination" style="left: 50px;line-height: 20px;font-size: 12px;position:static;"><!-- 这里显示分页 --></div>

<div id="Searchresult">分页初始化完成后这里的内容会被替换。</div>
<div id="hiddenresult" style="display:none;">
	<!-- 列表元素 -->
    <script type="text/javascript">
		var html = "";
		for(var i=1; i<101; i+=1){
			html += 
			'<dl class="show">'+
				'<dt><strong>这是标题'+i+'</strong></dt>'+
				'<dd>这是标题'+i+'下的内容1</dd>'+
				'<dd>这是标题'+i+'下的内容2</dd>'+
			'</dl>';	
		}
		document.getElementById("hiddenresult").innerHTML = html;
	</script>
</div>
<!-- 分页测试 -->
<div class="div" style="margin-top:60px;">
  <form action="MainServlet?flag=2.4"  method ="post">
	<%-- <input type="hidden" name="matnr" id="matnr"  value="<%=request.getSession().getAttribute("matnr1") %>"/>
  	<input type="hidden" name="batchNo" id="batchNo"  value="<%=request.getSession().getAttribute("batchNo") %>"/> --%>
  	<table class="table_list" style="margin: 0px 0px 0px 20px;line-height:20px;">
  		<colgroup>
			<col width="15%"/>
			<col width="20%"/>
			<col width="15%"/>
			<col width="15%"/>
			<col width="20%"/>
			<col width="15%"/>
		</colgroup>
  		<%if(list == null || list.size() == 0 ) {%>
  		<tr>
  			<td>
  				<span>查询结果为空！</span>
  				<input type="button" class="button" style="width:40px;height:20px" onclick="window.location.href='MainServlet?flag=return';" value="首页"/>
  				<input class="button" type="button" style="width:40px;height:20px"  onclick="turnon();" value="返回" />
  			</td>
  		</tr>
  		<%}else{ %>
  		<tr bordercolor="#000000" class="tr_list_1" >
    		<td class="td_list">序号</td>
			<td class="td_list">仓位</td>
    		<td class="td_list">批次</td>
		</tr>
		<tr bordercolor="#000000" class="tr_list_1" >
			<td class="td_list" >库存地点</td>
			<td class="td_list">数量</td>
			<td class="td_list">单位</td>
		</tr>
		<tbody id="tr_list_1"></tbody>
		<%-- <%for(int i = 0 ; i < list.size() ; i++){%>
		<tr class="tr_list_2" >
			
		</tr>
		<%}%> --%>
  		<tr>
  			<td  colspan="6">
  				<input name="fanye" class="button" type="button" style="width:40px;height:20px;" onclick="lastPage()" value="上一页"/>
  				<input name="fanye" class="button" type="button" style="width:40px;height:20px;" onclick="nextPage()" value="下一页"/>
  				<input class="button" type="button" style="width:40px;height:20px"  onclick="turnon();" value="返回" />
  				<!-- <input type="button" class="button" style="width:40px;height:20px" onclick="window.location.href='MainServlet?flag=return';" value="首页"/> -->
  			</td>
  		</tr>
  		<%} %>
  	</table>
   </form>
</div>
</BODY>
</html>
