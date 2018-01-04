<%@page import="cn.webChatServer.ehr.pojo.MyInfo" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
MyInfo myInfo = (MyInfo)request.getAttribute("myInfo");
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的信息</title>
    <!-- bootstrap及jQuery控件 -->
    <link href="../././plugs/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src=".././plugs/jquery/jquery-3.2.1.min.js"></script>
    <script src=".././plugs/jquery/jquery.blockui.min.js"></script>
    <script src=".././plugs/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <!-- 日期控件 -->
    <link href="../././plugs/datepicker/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <script src=".././plugs/datepicker/js/bootstrap-datetimepicker.js"></script>
    <script src=".././plugs/datepicker/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <!-- 自定义 -->
    <link href="../././custom/css/MyInfo.css" rel="stylesheet">
	<script src=".././custom/js/public.js"></script>
    <style type="text/css">
		.showimg {
			background: url("../custom/img/PersonInfo.png") center repeat;
			height: 12em;
			margin-bottom: 20px;
		}
    </style>
  </head>
  <%-- <body>
<br />出现按钮代表bootstrap引入成功！
<button type="button" class="btn btn-warning">警告按钮</button><br/>
  </body> --%>
<body>
<%if(myInfo == null || myInfo.getUserno() == null || myInfo.getUserno().equals("")){ %>
	<p style="color: red;font-size:20px;font-weight: bold;margin-top: 50px;">未查询到您的信息！</p>
<%}else{ %>
	<div class="showimg"></div>
	<div class="list-group">
	    <a href="#" class="list-group-item active">个人基本信息</a>
	    <div class="list-group-item">
	        <span class="margin_left">姓名</span>
	        <span class="margin_right float-right">${myInfo.getUsername()}</span>
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">工号</span>
	        <span class="margin_right float-right" id="userno">${myInfo.getUserno()}</span>
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">公司单位</span>
	        <span class="margin_right float-right">${myInfo.getComp()}</span>
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">部门</span>
	        <span class="margin_right float-right">${myInfo.getDept()}</span>
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">岗位名称</span>
	        <span class="margin_right float-right">${myInfo.getStation()}</span>
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">职等</span>
	        <span class="margin_right float-right">${myInfo.getPost()}</span>
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">入职时间</span>
	        <span class="margin_right float-right">${myInfo.getEntry()} </span>
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">集团工龄</span>
	        <span class="margin_right float-right">${myInfo.getGongling()}&nbsp;年</span>
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">联系电话</span>
	        <img src="../custom/img/iconfont-more.svg" class="small float-right page_show">
	        <span class="margin_right float-right page_show">${myInfo.getUsertel()}</span>
	        <input type="text" name="usertel" value="${myInfo.getUsertel()}" id="usertel" class="page_edit float-right">
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">E-Mail</span>
	        <img src="../custom/img/iconfont-more.svg" class="small float-right page_show">
	        <span class="margin_right float-right page_show">${myInfo.getEmail()}</span>
	        <input type="text" name="email" value="${myInfo.getEmail()}" id="email" class="page_edit float-right">
	    </div>
	    <div class="list-group-item">
	        <span class="margin_left">家庭地址</span>
	        <img src="../custom/img/iconfont-more.svg" class="small float-right page_show">
	        <span class="margin_right float-right page_show">${myInfo.getUseraddress()}</span>
	        <input type="text" name="useraddress" value="${myInfo.getUseraddress()}" id="useraddress" class="page_edit float-right">
	    </div>
	</div>
    <div class="list-group">
		<a href="#" class="list-group-item active">父母信息</a>
        <div class="list-group-item">
            <span class="margin_left">父亲姓名</span>
            <img src="../custom/img/iconfont-more.svg" class="small float-right page_show">
            <span class="margin_right float-right page_show">${myInfo.getFatherName()}</span>
            <input type="text" name="fatherName" value="${myInfo.getFatherName()}" id="fatherName" class="page_edit float-right">
        </div>
        <div class="list-group-item">
            <span class="margin_left">父亲生日</span>
            <img src="../custom/img/iconfont-more.svg" class="small float-right page_show">
            <span class="margin_right float-right page_show">${myInfo.getFatherBirth()}</span>
            <input type="text" name="fatherBirth" value="${myInfo.getFatherBirth()}" id="fatherBirth"  class="page_edit float-right">
        </div>
        <div class="list-group-item">
            <span class="margin_left">母亲姓名</span>
            <img src="../custom/img/iconfont-more.svg" class="small float-right page_show">
            <span class="margin_right float-right page_show">${myInfo.getMotherName()}</span>
            <input type="text" name="motherName" value="${myInfo.getMotherName()}" id="motherName" class="page_edit float-right">
        </div>
        <div class="list-group-item">
            <span class="margin_left">母亲生日</span>
            <img src="../custom/img/iconfont-more.svg" class="small float-right page_show">
            <span class="margin_right float-right page_show">${myInfo.getMotherBirth()}</span>
            <input type="text" name="motherBirth" value="${myInfo.getMotherBirth()}" id="motherBirth" class="page_edit float-right">
        </div>
        <div class="list-group-item">
            <span class="margin_left">父母电话</span>
            <img src="../custom/img/iconfont-more.svg" class="small float-right page_show">
            <span class="margin_right float-right page_show">${myInfo.getTel()}</span>
            <input type="text" name="tel" value="${myInfo.getTel()}" id="tel" class="page_edit float-right">
        </div>
        <div class="list-group-item">
            <span class="margin_left">父母地址</span>
            <img src="../custom/img/iconfont-more.svg" class="small float-right page_show">
            <span class="margin_right float-right page_show">${myInfo.getAddress()}</span>
            <input type="text" name="address" value="${myInfo.getAddress()}" id="address" class="page_edit float-right">
        </div>
	</div>
       <div class="edit margin-bottom30">
            <button type="button" class="btn btn-primary btn-block">修改</button>
       </div>
	<!-- <div class="editbutton" style="display:none; margin-bottom:  75px"> -->
	<div class="editbutton">
		<div class="col-md-6 col-xs-6 col-sm-6">
			<button type="button" class="btn btn-default btn-block back">返回</button>
		</div>
		<div class="col-md-6 col-xs-6 col-sm-6">
			<button type="button" class="btn btn-primary btn-block submit">确定</button>
		</div>
	</div>
<%} %>
</body>
<!-- 确保dom树加载完成后执行，避免日期控件不能使用 -->
<script src=".././custom/js/query_my_info.js"></script>
</html>
