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
<%if(msg.equals("0")){ %>
	<div class="container">
		<div class="form-group">
			<lable class="col-xs-3 span3 control-label">流转卡号:</lable>
			<div class="input-group col-xs-9 span9">
				<input type="text" class="form-control" rows="2" id="LZKNO" placeholder="请输入流转卡号或扫码输入"/>
				<span class="input-group-addon"><span class="fa fa-qrcode LZKNO"></span>
				</span>
			</div>
		</div>
		<button id="Search" type="button" class="btn btn-primary btn-block btn" style="margin-top:55px;" >查询</button>
	</div>
<!-- 数据显示 -->
<%}else if (msg.equals("1")){ %>
	

<%}else{%><!-- 无数据 -->
	<div>
		<p style="color: red;font-weight: bold;margin-top: 50px;">
		无法查询到流转卡信息，请确认您输入的流转卡信息！
		</p>
    </div>
<%} %>
</body>
</html>
