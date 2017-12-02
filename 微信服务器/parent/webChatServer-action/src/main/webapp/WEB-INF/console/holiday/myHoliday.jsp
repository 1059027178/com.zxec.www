<%@page import="cn.webChatServer.ehr.pojo.HistoryHoliday"%>
<%@page import="cn.webChatServer.ehr.pojo.Holiday"%>
<%@page import="cn.webChatServer.pojo.Salary"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	Holiday holiday = (Holiday) request.getAttribute("holiday");
	HistoryHoliday historyHoliday = (HistoryHoliday) request.getAttribute("historyHoliday");
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>考勤年度报表</title>
<link href="../././plugs/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src=".././plugs/jquery/jquery-3.2.1.min.js"></script>
<script src=".././plugs/bootstrap-3.3.7/js/bootstrap.min.js"></script>
<!-- <script src=".././plugs/echarts/echarts.js"></script> -->
<script src=".././plugs/echarts/echarts.min.js"></script>
<!-- <script src=".././plugs/echarts/echarts.simple.min.js"></script> -->
<!-- echarts主题包 -->
<script src=".././plugs/echarts/walden.js"></script>
</head>
<body>
	<!-- BEGIN 【饼状图】剩余年假调休信息汇总 -->
	<%
		if (holiday == null || historyHoliday == null) {
	%>
	<p style="color: red;font-size:20px;font-weight: bold;margin-top: 50px;">未查询到相关假期信息！</p>
	<%
		} else {
	%>
	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
	<div id="main" style="width: 100%;height:260px;"></div>
	<!-- BAGIN 【横向柱状图】按月分组统计考勤实际天数 -->
	<div id="main_day_month" style="width: 100%;height:350px;"></div>
	<!-- END   【横向柱状图】按月分组统计考勤实际天数 -->
	
	<!-- BAGIN 【折线图】按月分组统计部门排名 -->
	<div id="main_dept_month" style="width: 100%;height:300px;"></div>
	<!-- END   【折线图】按月分组统计部门排名 -->
	<!-- BAGIN 【折线图】按月分组统计公司排名 -->
	<div id="main_company_month" style="width: 100%;height:300px;"></div>
	<!-- END   【折线图】按月分组统计公司排名 -->
	
	<!-- BAGIN 【横向柱状图】按年分组统计部门、公司排名 -->
	<div id="main_year" style="width: 100%;height:300px;"></div>
	<!-- END   【横向柱状图】按年分组统计部门排名 -->
	
	<script type="text/javascript">
		//已用年假
		var usedYearHoliday = <%=historyHoliday.getUsedYearHoliday() == null ? 0: historyHoliday.getUsedYearHoliday()%>;
		//可用年假
		var ableYearHoliday = <%=holiday.getUsableYearHoliday() == null ? 0 : holiday.getUsableYearHoliday()%>;
		//已用调休
		var usedAdjustReset = <%=historyHoliday.getUsedAdjustReset() == null ? 0: historyHoliday.getUsedAdjustReset()%>;
		//可用调休
		var ableAdjustReset = <%=holiday.getUsableAdjustReset() == null ? 0 : holiday.getUsableAdjustReset()%>;
		//工号
		var userNo 			= <%=holiday.getUserNo() == null ? 0 : holiday.getUserNo()%>;
		//姓名
		var userName		= "<%=holiday.getUserName() == null ? "" : holiday.getUserName()%>";
		//年度
		var strYear			= <%=historyHoliday.getYear() == null ? 0 : historyHoliday.getYear()%>;
		var str1 = "已用年假",str2 = "剩余年假",str3 = "已用调休",str4 = "剩余调休";
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'), 'walden');
		/**指定图表的配置项和数据--饼状图*/
		var option = {
			baseOption: {
				title: {
					text: "工号"+ userNo +"（"+ userName +"）考勤数据 ",
					subtext:  strYear+"年度 ",
						x : 'center'
					},
					series : [ {
						name : '此项数据',
						type : 'pie',
						radius : '55%',
						center : [ '50%', '40%' ],
						label: {
			                normal: {
			                    formatter: '{b|{b}}\n{c|{c}天}{per|{d}%} ',
			                    backgroundColor: '#eee',
			                    borderColor: '#aaa',
			                    borderWidth: 0.5,
			                    borderRadius: 4,
			                    rich: {
			                        b: {
			                            fontSize: 10,
			                            lineHeight: 15,
			                            align: 'center'
			                        },
			                        c:{
			                            fontSize: 10, 
			                            color: '#999',
			                            lineHeight: 20,
			                            align: 'left'
			                        },
			                        per: {
			                        	fontSize: 10, 
			                            color: '#999',
			                            padding: [2, 4],
			                            borderRadius: 2,
			                            align: 'left'
			                        }
			                    }
			                }
			            },
						data : [ {
							value : usedYearHoliday,
							name : str1
						}, {
							value : ableYearHoliday,
							name : str2
						}, {
							value : usedAdjustReset,
							name : str3
						}, {
							value : ableAdjustReset,
							name : str4
						} ],
						itemStyle : {
							emphasis : {
								shadowBlur : 10,
								shadowOffsetX : 0,
								shadowColor : 'rgba(0, 0, 0, 0.5)'
							}
						}
					}]
				},
				media : [ // 这里定义了media query的逐条规则。
				{
					query : {
						maxWidth : 500
					},
					option : {
						legend : {
							left : 10,
							top : '15%',
							orient : 'vertical'
						},
						series : [ {
							radius : '30%',
							center : [ '50%', '60%' ]
						} ]
					}
				}, {
					query : {
						minAspectRatio : 1
					},
					option : {
						legend : {
							right : 'center',
							bottom : '20%',
							orient : 'horizontal'
						},
						series : [ {
							radius : '50%',
							center : [ '50%', '60%' ]
						} ]
					}
				}, { // 这条里没有写规则，表示『默认』，
					option : { // 即所有规则都不满足时，采纳这个option。
						legend : {
							left : 10,
							top : '15%',
							orient : 'vertical'
						},
						series : [ {
							radius : '30%',
							center : [ '50%', '60%' ]
						} ]
					}
	
				} ]
		};
		myChart.setOption(option);// 使用刚指定的配置项和数据显示图表。
	</script>
	<!-- END   【饼状图】剩余年假调休信息汇总 -->
	
	<!-- 加载其他数据 -->
	<script src=".././custom/js/query_ranking_by_userno.js"></script>
	<%
		}
	%>

</body>
</html>
