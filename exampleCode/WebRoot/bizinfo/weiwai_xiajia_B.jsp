<%@page import="com.exampleCode.model.PositionsInfo"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List list = (List)request.getAttribute("resultList"); 
%>
<html>
<!-- <script src="./js/jquery.js"></script>  --> 
<!-- <script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>   --><!-- 
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    -->
<script language="javascript" src="./js/jiuhui.js"></script>
<script src="./jquery.pagination_2/demo/lib/jquery.min.js"></script>
<script src="./jquery.pagination_2/jquery.pagination.js"></script>
<link href="./jquery.pagination_2/pagination.css" rel="stylesheet"/>
<script type="text/javascript">
function stoQuy(){
	var num=$("#num").val();
	if(num == ""||num == "0"){
		alert("请填写下架数量");return;
	}
	document.jiuhui.submit();
}
function control(obj,line){//obj.value:输入的值，line为行号
	//alert(obj.value);
	//alert(line);
	var valueTd =document.getElementById ("box").rows [line].cells[3];
	//仓位最大数量
	var maxnum = parseFloat(valueTd.innerHTML);
	//输入的数量
	var inputnum =	parseFloat(obj.value);
	//输入数量控制
  	if(inputnum > maxnum){
  		obj.value = "";
  		alert("超过了库存值");return;
  	}
  	//供应商生产日期控制
  	if(line > 1){//存放仓位数量大于1
  		//上一行的输入值
		var UPinputnum = parseFloat((document.getElementById ("box").rows [line-1].cells[4]).getElementsByTagName("INPUT")[0].value);
		//console.log(line);
		//console.log("上一行的输入值="+UPinputnum);
		//上一行的最大值
		var UPmaxnum = parseFloat((document.getElementById ("box").rows [line-1].cells[3]).innerHTML);
		//console.log("上一行的最大值="+UPmaxnum);
  		if(UPmaxnum != UPinputnum && inputnum != 0){
			obj.value = "";
			alert("上一仓位未领完！");
			return;
		}else{
			document.getElementById("num").value = parseFloat(document.getElementById("num").value) + inputnum + "";
		}
  	}else{
		if(inputnum+"" == "NaN"){
  			$("#num").attr("value","");
  		}else{
			$("#num").attr("value",inputnum);
  		}
	}
}
</script>
</script>
<!----------------分页----------------->
<script type="text/javascript">
$(function(){
	//总数目
	var length = <%=list.size()%>;
	//设置分页元素参数
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
	
		var items_per_page = 4;//每页的显示的列表项数目
		
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
  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <title><%=request.getSession().getAttribute("type")%></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
  </head>
  <body>
  <form name="jiuhui"  id="jiuhui" method="post" action="MainServlet?flag=weiwaiC">
  	<%if(list.size() < 1){ %>
  		<div>仓库中无数据！</div>
    				<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=2';" value="返回">
  	<%}else{ %>
    	<div style="margin-left: -20px;">
    	<%	PositionsInfo info1 = (PositionsInfo)list.get(0);
    		String matnr = info1.getItemNO();//物料编码
    		String maktx = info1.getItemDescription();//物料描述
    	%>
    	<ul>
    		<li class="li">
    			物料编码：<input name="matnr" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="matnr" value = "<%=matnr%>" />
    		</li>
    		<li class="li">
    			物料描述：<input name="maktx" readonly=readonly style="width:60%;heigth:70%;background-color:#D8D8D8;"  type="text"  id="maktx" value = "<%=maktx%>"/>
    		</li>
    		<li class="li">
    			数量合计：<input style="width:45%;heigth:70%;background-color:#D8D8D8;" type="text" id="num" name="num" />
    		</li>
    		<li class="li">
    			<table class="table_list" id="box">
    				<tr>
    					<td align="center">序号</td>
    					<td align="center">仓位</td>
    					<td align="center">批次</td>
    					<td align="center">仓位数量</td>
    					<td align="center">选择数量</td>
    				</tr>
    				<%for(int i = 0 ; i < list.size() ; i++){ 
    					PositionsInfo info = (PositionsInfo) list.get(i);
    				%>
    				<tbody class="tbody" style="display:none;">
    				<tr>
    					<td align="center" ><%=i+1 %></td>
    					<td align="center" ><%=info.getLiteraNO() %></td>
    					<td align="center" ><%=info.getBatchNO()%></td>
    					<td align="center" ><%=info.getNumber() %></td>
    					<td align="center" ><input style="width:35px;heigth:70%;" id="num1" type="text" onchange="control(this,<%=i+1%>);" /></td>
    				</tr>
    				</tbody>
    				<%}%>
    			</table>
    		</li>
     		<li class="li">
     			<%if(list.size() <= 4){ %>
     				<div id="Pagination"  class="pagination" style="line-height: 9px;font-size:12px;margin-left:5px;margin-bottom: -7px;display: none;"><!-- 这里显示分页 --></div>
    				<%}else{ %>
    				<div id="Pagination"  class="pagination" style="line-height: 9px;font-size:12px;margin-left:5px;margin-bottom: -7px;"><!-- 这里显示分页 --></div>
    			<%} %>
    				<input  class="button"  type="button"  style="width:25%;margin:0px 0px 0px -25px;"  onclick="stoQuy()" value="确定">
    				<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=2.3';" value="返回">
    				<input  class="button" 	type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="首页">
    		</li>
    	</ul>
    	</div>
    <%} %>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("num1").focus();
  </script>
</html>
