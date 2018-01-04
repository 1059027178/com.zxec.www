<%@page import="com.webChatServer.util.MySalaryUtil"%>
<%@page import="cn.webChatServer.pojo.CheckInfo" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//薪资数据
List<Object> checkData = (List<Object>) request.getAttribute("checkData");
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的考勤</title>
    <link href="../././plugs/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src=".././plugs/jquery/jquery-3.2.1.min.js"></script>
    <script src=".././plugs/bootstrap-3.3.7/js/bootstrap.min.js"></script>
  </head>
  <%-- <body>
<br />出现按钮代表bootstrap引入成功！
<button type="button" class="btn btn-warning">警告按钮</button><br/>
  </body> --%>
	<body>
	<div class="container">
		<form action="" class="form-horizontal" role="form">
			<fieldset>
				<legend class="text-center" style="font-weight:bold;font-size:2em;">
					考勤记录
				</legend>
				<div class="panel-group" id="accordion">
					<%for(int i = 0 ; i < checkData.size() ; i++){
						Map<String, Object> map = (Map<String, Object>) checkData.get(i);
						String today = map.get("today") + "（" + map.get("week").toString() + "）";//日期
					%>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#<%=today%>" >
									<%=today%>考勤记录信息
								</a>
							</h4>
						</div>
						<div id="<%=today%>" class="panel-collapse collapse">
							<div class="panel-body">
								<%List<CheckInfo> checkInfos = new ArrayList<CheckInfo>();
								  checkInfos = (List<CheckInfo>) map.get("checkInfos");
								if(checkInfos == null || checkInfos.size() == 0){ %>
									<b>无考勤记录信息！</b>
								<%}else{%>
								<table class="table table-bordered">
									<thead>
										<tr class="warning">
											<th>姓名</th>
											<th><%=MySalaryUtil.ObjToBlank(checkInfos.get(0).getName())%></th>
										</tr>
									</thead>
									<tbody>
										<%
										for(int j = 0; j < checkInfos.size(); j++){
											CheckInfo checkInfo = checkInfos.get(j);
											String checkDay = MySalaryUtil.ObjToBlank(checkInfo.getCheckDay());
											String checkSecond = MySalaryUtil.ObjToBlank(checkInfo.getCheckSecond());
										%>
										<tr class="success">
											<td>考勤记录</td>
											<td><%=checkDay+" "+ checkSecond%></td>
										</tr>
										<%}%>
									</tbody>
								</table>
								<%}%>
							</div>
						</div>
					</div>
					<%}%>
				</div>
			</fieldset>
		</form>
	</div>
	</body>
</html>
