<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我要报工</title>
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
    <script src=".././custom/js/reportWorkIndex.js"></script>
    <link href=".././custom/css/reportWorkIndex.css" rel="stylesheet">
	
  </head>
  <body>
	<div class="container">
		<!--报工选择界面-->
		<div style="margin-top: 50px;"></div>
		<div class="selectType">
			<p><button type="button" class="btn btn-primary btn-lg btn-block" data-action= "reportFinish">完工报工</button></p>
			<hr />
			<p><button type="button" class="btn btn-primary btn-lg btn-block" data-action= "reportCheck">质检报工</button></p>
		</div>
		<!--完工报工-->
		<div class="form-group reportFinish" >
			<lable class="col-lg-4 col-md-6 col-sm-3 col-xs-4 span3 control-label"> 流转卡号: </lable>
			<div   class="col-lg-8 col-md-6 col-sm-9 col-xs-8 span9 input-group">
				<input type="text" class="form-control" rows="2" id="finish_cardno" placeholder="请输入流转卡号或扫码输入"> 
				<span class="input-group-addon">
					<span class="fa fa-qrcode" data-action="finish_cardno"> </span>
				</span>
			</div>
		</div>
		<!--质检报工-->
		<div class="form-group reportCheck" >
			<lable class="col-lg-4 col-md-6 col-sm-3 col-xs-4 span3 control"> 物料号: </lable>
			<div   class="col-lg-8 col-md-6 col-sm-9 col-xs-8 span9 input-group">
				<input type="text" class="form-control" rows="2" id="check_matterno" placeholder="输入物料号或扫码输入"> 
				<span class="input-group-addon">
					<span class="fa fa-qrcode" data-action="check_matterno"> </span>
				</span>
			</div>
		</div>
		<!-- 员工信息 -->
		<div class="form-group userInfo">
			<lable class="col-lg-4 col-md-6 col-sm-3 col-xs-4 span3 control-label"> 员工工号: </lable>
			<div   class="col-lg-8 col-md-6 col-sm-9 col-xs-8 span9 input-group">
				<input type="text" class="form-control" rows="2" id="userNo" value="${userNo}" placeholder="请输入员工工号" /> 
				<span class="input-group-addon"> 
					<span class="fa fa-qrcode" data-action="check_userno"> </span>
				</span>
			</div>
		</div>
		<div class="form-group userInfo" >
			<lable class="col-lg-4 col-md-6 col-sm-3 col-xs-4 span3 control-label"> 员工姓名: </lable>
			<div   class="col-lg-8 col-md-6 col-sm-9 col-xs-8 span9 input-group">
				<input type="text" class="form-control" rows="2" id="userName" value="${userName}" readonly="readonly"/>
			</div>
		</div>
		<button id="finishSao" type="button" 
			class="btn btn-primary btn-block btn-lg reportFinish FinishSearch"> 
			确定查询(完工报工)</button>
		<button id="CheckSao" type="button" 
			class="btn btn-primary btn-block btn-lg reportCheck CheckSearch">
			确定查询(质检报工)</button>
		<button type="button"
			class="btn btn-primary btn-block btn-lg backBtn" data-action="backBtn">返回</button>
	</div>
</body>
  
</html>

