<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String userName = (String)request.getAttribute("userName") == null ? "" : (String)request.getAttribute("userName");
String userNo	= (String)request.getAttribute("userNo") == null ? "" : (String)request.getAttribute("userNo");
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的产量</title>
     <!-- bootstrap(详情访问：http://www.bootcss.com)及jQuery控件 -->
    <link href="../././plugs/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src=".././plugs/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src=".././plugs/jquery/jquery-3.2.1.min.js"></script>
    <script src=".././plugs/jquery/jquery.blockui.min.js"></script>
    <!-- 引入datepicker日期插件 -->
    <link href=".././plugs/datepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <script src=".././plugs/datepicker/js/bootstrap-datetimepicker.js"></script>
    <script src=".././plugs/datepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <!-- 引入fontawesome库，详细介绍：http://fontawesome.dashgame.com/ -->
    <link href="../././plugs/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- 引入微信官方调用JS接口所需库 -->
    <!-- <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script> -->
    
    <!-- 引入自定义文件 -->
    <link href="../././custom/css/query_my_output.css" rel="stylesheet">
    <script src=".././custom/js/query_my_output.js"></script>
    <script src=".././custom/js/public.js"></script>
    
  </head>
<body>
<div class="text-center" style="font-weight:bold;font-size:2em;">我的产量</div>
<hr>
<!-- 查询页 -->
<%if(userName.equals("") && userNo.equals("")){ %>
	<div>
		<p style="color: red;font-weight: bold;margin-top: 50px;">
		无法查询到你的信息，请联系系统管理员开通相关权限！
		</p>
    </div>
<%}else{ %>
	<div style="display:none">
		<input type="text" name="userName" value="${userName }">
		<input type="text" name="userNo" value="${userNo }">
	</div>
	<div class="container">
    	<div class="list-group">
			<div class="list-group-item">
				<span class="margin_left">姓名</span><span class="margin_right float-right">${userName }</span>
           	</div>
			<div class="list-group-item">
				<span class="margin_left">工号</span><span class="margin_right float-right">${userNo }</span>
           	</div>
            <div class="list-group-item">
            	<span class="margin_left">开始日期</span>
            	<input type="text" name="startDate" class="float-right" readonly="readonly">
            </div>
            <div class="list-group-item">
            	<span class="margin_left">结束日期</span>
            	<input type="text" name="endDate"  class="float-right" readonly="readonly">
            </div>
            <div>
            	<button name="search" type="button" class="btn btn-primary btn btn-block" style="margin-top: 10px;" >查询</button>
            </div>
		</div>
		<!-- <hr> -->
		<table class="table table-bordered tableMain" style="display:none;">
			<thead>
				<tr>
					<th>产品</th>
					<th>产品名称</th>
					<th>工序名称</th>
					<th>数量</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
		<%}%>
	</div>
</body>
</html>
