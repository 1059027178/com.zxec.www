<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>流转卡查询</title>
    <!-- 引入bootstrap库，详情访问：http://www.bootcss.com/ -->
    <link href="../././plugs/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src=".././plugs/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <!-- 引入jQuery库 -->
    <script src=".././plugs/jquery/jquery-3.2.1.min.js"></script>
    <!-- 引入fontawesome库，详细介绍：http://fontawesome.dashgame.com/ -->
    <link href="../././plugs/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src=".././plugs/jquery/jquery.blockui.min.js"></script>
    <!-- 引入微信官方调用JS接口所需库 -->
    <script src="http://res.wx.qq.com/open/js/jweixin-1.2.0.js"></script>
    <!-- 引入自定义文件 -->
    <script src=".././custom/js/query_finish_cardno.js"></script>
    <script src=".././custom/js/public.js"></script>
  </head>
<body>
<div class="text-center" style="font-weight:bold;font-size:2em;">流转卡查询产量</div>
<hr>
<!-- 查询页 -->
	<div class="container">
		<div class="form-group">
			<label class="control-label col-xs-3 span3">流转卡号:</label>
			<div class="input-group col-xs-9 span9">
				<input type="text" class="form-control LZKNO" rows="2" placeholder="请输入流转卡号或扫码输入"/>
				<span class="input-group-addon"><span class="fa fa-qrcode LZKNO"></span></span>
			</div>
		</div>
		<button type="button" class="btn btn-primary btn-block btn search" style="margin-top:10px;">查询</button>
	</div>
<!-- 数据显示 -->
	<div class="container" style="display:none">
	<hr>
		<table class="table table-bordered tableHeader">
			<tbody>
				<tr>
					<td>流转卡号</td>
					<td class="flowCardNo"></td>
				</tr>
				<tr>
					<td>派工单号</td>
					<td class="dispatchList"></td>
				</tr>
				<tr>
					<td>产品代码</td>
					<td class="productCode"></td>
				</tr>
				<tr>
					<td>产品名称</td>
					<td class="productName"></td>
				</tr>
			</tbody>
		</table>
		<table class="table table-bordered tableMain">
			<thead>
				<tr>
					<th>工号</th>
					<th>姓名</th>
					<th>工序</th>
					<th>数量</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</body>
</html>
