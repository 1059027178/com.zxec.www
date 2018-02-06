<%@page import="com.webChatServer.util.MySalaryUtil"%>
<%@page import="cn.webChatServer.pojo.Salary"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//薪资数据
List<Salary> salaryList = (List<Salary>) request.getAttribute("salaryList");
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>我的薪资</title>
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
					薪资信息
				</legend>
				<div class="panel-group" id="accordion">
					<%for(int i = 0 ; i < salaryList.size() ; i++){
						Salary salary = salaryList.get(i);
					%>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#<%=salary.getNy()%>" >
									<%=salary.getNy().substring(0, 4) +"年"+salary.getNy().substring(4)+"月" %>薪资信息
								</a>
							</h4>
						</div>
						<div id="<%=salary.getNy()%>" class="panel-collapse collapse">
							<div class="panel-body">
								<%if(salary.getGh() == null){ %>
									<b>数据暂缺！</b>
								<%}else{%>
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>项目明细</th>
											<th>项目金额</th>
										</tr>
									</thead>
									<tbody>
										<tr class="active">
											<td>姓名</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getXm()) %></td>
										</tr>
										<tr class="success">
											<td>工号</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getGh()) %></td>
										</tr>
										<tr class="active">
											<td>职等</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getZd()) %></td>
										</tr>
										<tr class="warning">
											<td>岗位名称</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getGwmc()) %></td>
										</tr>
										<tr class="success">
											<td>工资发放归属</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getGzffgs())%></td>
										</tr>
										<tr class="warning">
											<td>课级</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getKj()) %></td>
										</tr>
										<tr class="active">
											<td>基本工资</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getJbgz()) %></td>
										</tr>
										<tr class="danger">
											<td>岗位津贴</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getGwjt()) %></td>
										</tr>

										<tr class="active">
											<td>技能津贴</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getJnjt()) %></td>
										</tr>
										<tr class="success">
											<td>绩效奖金</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getXjjj()) %></td>
										</tr>
										<tr class="warning">
											<td>结构工资总额</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getJggzze()) %></td>
										</tr>
										<tr class="danger">
											<td>绩效考核</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getXjkh()) %></td>
										</tr>
										<tr class="success">
											<td>假日加班费</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getJrjbf()) %></td>
										</tr>
										<tr class="active">
											<td>加班费合计</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getJbfhj()) %></td>
										</tr>
										<tr class="success">
											<td>补助结计</td>
											<%String bzjj = salary.getBzjj();
											  String qqj  = salary.getQqj();
											  if(bzjj == null || bzjj.trim().equals("null") || bzjj.trim().equals("NULL") || bzjj.trim().equals("")) bzjj = "0";
											  if(qqj  == null || qqj .trim().equals("null") || qqj.trim().equals("NULL")  || qqj.trim().equals(""))  qqj  = "0";
											  double b = Double.parseDouble(bzjj) + Double.parseDouble(qqj);%>
											<td><%=MySalaryUtil.ObjToBlank(b)%></td>
										</tr>
										<tr class="warning">
											<td>福利一餐补</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getFlcb()) %></td>
										</tr>
										<tr class="danger">
											<td>考勤调整</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getKqtz()) %></td>
										</tr>
										<tr class="active">
											<td>应付工资</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getYfgz()) %></td>
										</tr>
										<tr class="success">
											<td>个人养老</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getGryanglao()) %></td>
										</tr>
										<tr class="warning">
											<td>平时加班费</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getPsjbf()) %></td>
										</tr>
										<tr class="warning">
											<td>周末加班费</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getZmjbf()) %></td>
										</tr>
										<tr class="warning">
											<td>个人医疗</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getGryiliao()) %></td>
										</tr>
										<tr class="warning">
											<td>其他补助/调整</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getQtbz()) %></td>
										</tr>
										<tr class="danger">
											<td>个人公积金</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getGrgjj()) %></td>
										</tr>
										<tr class="active">
											<td>税前工资</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getSqgz()) %></td>
										</tr>
										<tr class="success">
											<td>所得税</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getSds()) %></td>
										</tr>
										<tr class="danger">
											<td>住宿/水电费</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getZsf()) %></td>
										</tr>
										<tr class="active">
											<td>爱心基及调整项</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getAxjj()) %></td>
										</tr>
										<tr class="success">
											<td>实发工资</td>
											<td><%=MySalaryUtil.ObjToBlank(salary.getSfgz()) %></td>
										</tr>
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
