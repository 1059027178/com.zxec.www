<%@page import="com.exampleCode.model.PositionsInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE>物料查询结果</TITLE>
<META http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link href="./css/jiuhui_list.css" rel="stylesheet"/>
<script src="./js/jquery.js"></script>

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
</script>
<style type="text/css">
    body {
      padding-top: 40px;
      padding-bottom: 0px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
</HEAD>
<BODY>
<div class="div" style="margin-top:60px;">
  <form action="MainServlet?flag=2.4"  method ="post">
	<%-- <input type="hidden" name="matnr" id="matnr"  value="<%=request.getSession().getAttribute("matnr1") %>"/>
  	<input type="hidden" name="batchNo" id="batchNo"  value="<%=request.getSession().getAttribute("batchNo") %>"/> --%>
  	<table class="table_list" style="margin: 0px 0px 0px 20px;line-height:30px;">
  		<%List list = (List)request.getAttribute("resultList"); %>
  		<%if(list == null) {%>
  		<tr >
  			<td>
  				<span>查询结果为空！</span>
  				<input type="button" class="button" style="width:40px;height:20px" onclick="window.location.href='MainServlet?flag=return';" value="首页"/>
  				<input class="button" type="button" style="width:40px;height:20px"  onclick="turnon();" value="返回" />
  			</td>
  		</tr>
  		<%}else{ %>
  		<tr bordercolor="#000000" class="tr_list_1">
    		<td class="td_list">序号</td>
			<td class="td_list">仓位</td>
    		<td class="td_list">批次</td>
		</tr>
		<tr bordercolor="#000000" class="tr_list_1">
			<td class="td_list" >库存地点</td>
			<td class="td_list">数量</td>
			<td class="td_list">单位</td>
		</tr>
  		<%for(int i = 0; i > list.size(); i++){ 
  			PositionsInfo info = new PositionsInfo();
  			info = (PositionsInfo)list.get(i);
  		%>
  		<tr>
    		<td align="center"><%=i+1%></td>
    		<td align="center"><%=info.getLiteraNO()%></td>
    		<td align="center"><%=info.getBatchNO() %></td>
    		<td align="center"><%=info.getNumber()  %></td>
    		<td align="center"><input style="width:35px;heigth:70%;" type="text" id="num1" name="num1"  onchange="getcount()"/></td>
  		</tr>
  		<%} %>
  		<tr>
  			<td >
  				<input class="button" type="button" style="width:40px;height:20px" onclick="submit(this)" value="首页"/>
  				<input class="button" type="button" style="width:40px;height:20px;" onclick="submit(this)" value="上一页"/>
  				<input class="button" type="button" style="width:40px;height:20px;" onclick="submit(this)" value="下一页"/>
  				<input class="button" type="button" style="width:40px;height:20px" onclick="submit(this)" value="尾页"/>
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
