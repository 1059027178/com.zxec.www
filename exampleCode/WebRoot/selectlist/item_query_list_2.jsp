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
<TITLE>仓位查询</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link href="./css/jiuhui_list.css" rel="stylesheet"/>
<script src="./js/jquery.js"></script>
<script src="./jquery.pagination_2/demo/lib/jquery.min.js"></script>
<script src="./jquery.pagination_2/jquery.pagination.js"></script>
<!-- <script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"/> -->  
<link href="./jquery.pagination_2/pagination.css" rel="stylesheet"/>
<style type="text/css">
	BODY{
		padding-top:10px;
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
  	window.location.href="MainServlet?flag=4.2";
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
</script>
<!----------------分页----------------->
<script type="text/javascript">
$(function(){
	//总数目
	var length = <%=list.size()%>;
	//设置分页元素参数
	var optInit = getOptionsFromForm();
	$("#Pagination").pagination(length, optInit);
	
	$(function(){
		var opt = getOptionsFromForm();
		// 重新创建分页参数
		$("#Pagination").pagination(length, opt);
	});
	//-----------------------------------
	function getOptionsFromForm(){
		var opt = {callback: pageselectCallback}; //回调函数：默认无执行效果
		opt.items_per_page = 2;		//每页显示的条目数(可选参数，默认是10)
		opt.num_display_entries = 0;//连续分页主体部分显示的分页条目数(可选参数，默认是10)
		opt.num_edge_entries = 0;	//两侧显示的首尾分页的条目数(可选参数，默认是0)
		opt.prev_text = "上一页";	//“前一页”分页按钮上显示的文字(字符串参数，可选，默认是"Prev")
		opt.next_text = "下一页";	//“下一页”分页按钮上显示的文字(字符串参数，可选，默认是"Next")
		return opt;
	}
	//-------------------------------
	function pageselectCallback(page_index , jq){
	
		var items_per_page = 2;//每页的显示的列表项数目
		
		var max_elem = Math.min((page_index+1) * items_per_page, length);
		
		$(".tbody").hide();
		// 获取加载元素
		for(var i=page_index*items_per_page;i<max_elem;i++){
		
			$(".tbody:eq("+i+")").show();
		}
		//阻止单击事件
		return false;	
	}
});
</script>
<script type="text/javascript">
function ToMore(obj){
	var itemNO = obj.innerHTML;//获取当前a标签中的值
	
	document.getElementById("matnr").value = itemNO;
	
	 //document.getElementById("argform").submit();
	 document.getElementById("argsubmit").click();
}
</script>
</HEAD>
<BODY>
<div class="div">
  <form name="form" action="MainServlet?flag=selectWuLiao1"  method ="post" >
	<input type="hidden" name="matnr" id="matnr"/>
  	<input type="hidden" name="lgpla" id="lgpla"  value="<%=request.getAttribute("lgpla") %>"/>
  	<table class="table_list" style="line-height:15px;" >
		<thead>
  		<%if(list == null || list.size() == 0 ) {%>
  		<tr style="height:80px;"></tr>
  		<tr>
  			<td align="left" >
  				<span style="margin-left:40px;">查询结果为空！</span>
  				<br />
  				<input type="button" class="button" style="width:40px;height:20px;margin-top:50px;margin-left:40px;" onclick="window.location.href='MainServlet?flag=return';" value="首页"/>
  				<input class="button" type="button" style="width:40px;height:20px"  onclick="turnon();" value="返回" />
  			</td>
  		</tr>
  		<%}else{ %>
		<tr bordercolor="#000000" class="tr_list_1">
			<td class="td_list" style="padding-left:15px;">物料编码</td>
		</tr>
  		<tr bordercolor="#000000" class="tr_list_1" >
			<td class="td_list" style="padding-left:15px;">物料描述</td>
		</tr>
  		<tr bordercolor="#000000" class="tr_list_1" >
			<td class="td_list" style="padding-left:15px;">数量</td>
		</tr>
		</thead>
		<%
			for(int i = 0 ; i < list.size() ; i++){
			PositionsInfo info = (PositionsInfo)list.get(i);
		%>
		<tbody class="tbody" style="display: none;" align="left">
		<tr class="tr_list_2">
			<td class="td_list" style="padding-left:15px;">
				<a href="#" onclick="ToMore(this);"><%=info.getItemNO() %></a>
			</td>
		</tr>
		<tr class="tr_list_2"  >
			<td class="td_list" style="padding-left:15px;"><%=info.getItemDescription() %></td>
		</tr>
		<tr class="tr_list_2" >
			<td class="td_list" style="padding-left:15px;"><%=info.getNumber() %></td>
		</tr>
		</tbody>
		<%}%>
  		<tr>
  			<td colspan="2">
  				<div id="Pagination" class="pagination" style="line-height: 10px;font-size:12px;margin-left:15px;"><!-- 这里显示分页 --></div>
  				<input  class="button" type="button" name="argsubmit" id="argsubmit" onclick="submit1(this);" style="display:none" />
  				<input class="button" type="button" style="width:50px;height:24px"  onclick="turnon();" value="返回" />
  				<!-- <input type="button" class="button" style="width:40px;height:20px" onclick="window.location.href='MainServlet?flag=return';" value="首页"/> -->
  			</td>
  		</tr>
  		<%} %>
  	</table>
   </form>
</div>
</BODY>
</html>
