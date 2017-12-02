
$(document).ready(function(){
	//用户工号
//	alert("userNo = " + userNo);
	//第0项：当前用户按月统计相关天数
	var myChart_main_day_month 	   = echarts.init(document.getElementById('main_day_month'), 'walden');
	//第1项：为按月部门排名
	var myChart_main_dept_month    = echarts.init(document.getElementById('main_dept_month'), 'walden');
	//第2项：为按月公司排名
	var myChart_main_company_month = echarts.init(document.getElementById('main_company_month'), 'walden');
	//第3项：为按年部门排名
	var myChart_main_year 	   	   = echarts.init(document.getElementById('main_year'), 'walden');
	//第4项：为按年公司排名
//	var myChart_main_company_year  = echarts.init(document.getElementById('main_company_year'), 'walden');
	var itemArr = ['病假', '事假', '调休', '公出','加班'];//统计事项
	/*设置第0项图表样式及数据
	 * 1.显示等待动画
	 * 2.请求数据
	 * 3.数据处理
	 * 4.数据绑定、去除动画
	 * */
	//设置第0项图表样式
	myChart_main_day_month.showLoading();
	$.ajax({
		type:"POST",
		url:"../holiday/achieveJsonHoliday.do",
    	data: {"userNo": userNo,"param":"5"},
		async:true,
	 	success:function(data){
	 		//数据提取分析
	 		var queryArray = data.queryDayByMonthArray;
	 		var yAxisData  		   = new Array();
	 		var usedSickLeave 	   = new Array();
	 		var thingHoliday 	   = new Array();
	 		var usedAdjustReset    = new Array();
	 		var stay 			   = new Array();
	 		var overtime 		   = new Array();
	 		for(var i = 0 ; i < queryArray.length ; i++){
	 			yAxisData[i] = i + 1 + "月";
	 			var objQuery = queryArray[i];
	 			usedSickLeave[i]   = (objQuery.usedSickLeave   == undefined ? "0" : objQuery.usedSickLeave);
	 			thingHoliday[i]    = (objQuery.thingHoliday    == undefined ? "0" : objQuery.thingHoliday);
	 			usedAdjustReset[i] = (objQuery.usedAdjustReset == undefined ? "0" : objQuery.usedAdjustReset);
	 			stay[i]		  	   = (objQuery.stay 		   == undefined ? "0" : objQuery.stay);
	 			overtime[i]	  	   = (objQuery.overtime 	   == undefined ? "0" : objQuery.overtime);
	 		}
	 		//定义图表样式
			var option_day_month = {
				title: {
					subtext: '每月考勤情况统计(月份/天数)',x:'center'
					},
				tooltip: {
			        trigger: 'axis',
			        axisPointer: {type: 'shadow'}
			    },
			    legend:{left:'center', top: 30,data: itemArr},
			    grid:  {left: '3%',right: '4%',bottom: '3%', containLabel: true},
			    xAxis: {type: 'value',boundaryGap: [0, 0.01]},
			    yAxis: {type: 'category', barWidth: '60%',data: yAxisData},
			    series:[
			        {name: itemArr[0],type: 'bar',data: usedSickLeave},
			        {name: itemArr[1],type: 'bar',data: thingHoliday},
			        {name: itemArr[2],type: 'bar',data: usedAdjustReset},
			        {name: itemArr[3],type: 'bar',data: stay},
			        {name: itemArr[4],type: 'bar',data: overtime}
			    ]
			};
			myChart_main_day_month.hideLoading();//去除等待动画
			myChart_main_day_month.setOption(option_day_month);
	 	},
	    error:function(){
		    alert("月度考勤明细数据-获取失败！");
		}
	});
	
	//设置第1项图表样式--折线图【部门月度排名】
	myChart_main_dept_month.showLoading();
	$.ajax({
		type:"POST",
		url:"../holiday/achieveJsonHoliday.do",
    	data: {"userNo": userNo,"param":"1"},
		async:true,
	 	success:function(data){
			//提取数据
	 		//[yAxisData,usedSickLeave,usedSickLeave,thingHoliday,usedAdjustReset,stay,overtime]
	 		var data_arr = new Array();
	 		data_arr = getMonthData(data);
	 		//设置图表显示格式
			var option_dept_month = {
				title: {subtext: '部门月度排名(月份/名次)',x:'center'},
				tooltip: {trigger: 'axis'},
			    legend: {left:'center', top: 30,data:itemArr},
			    grid: {left: '3%',right: '4%',bottom: '3%',containLabel: true},
			    xAxis: {type: 'category',boundaryGap: false,data: data_arr[0]},
			    yAxis: {type: 'value'},
			    series: [
			        {name:itemArr[0],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[0],data:data_arr[1]},
			        {name:itemArr[1],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[1],data:data_arr[2]},
			        {name:itemArr[2],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[2],data:data_arr[3]},
			        {name:itemArr[3],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[3],data:data_arr[4]},
			        {name:itemArr[4],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[4],data:data_arr[5]}
			    ]
			};//图表样式
			myChart_main_dept_month.hideLoading();//去除等待动画
			myChart_main_dept_month.setOption(option_dept_month);
	 	},
	    error:function(){
		    alert("部门月度排名数据-获取失败！");
		}
	});
	
	//设置第2项图表样式--折线图【公司月度排名】
	myChart_main_company_month.showLoading();
	$.ajax({
		type:"POST",
		url:"../holiday/achieveJsonHoliday.do",
    	data: {"userNo": userNo,"param":"2"},
		async:true,
	 	success:function(data){
	 		//提取数据
	 		//[yAxisData,usedSickLeave,usedSickLeave,thingHoliday,usedAdjustReset,stay,overtime]
	 		var data_arr = new Array();
	 		data_arr = getMonthData(data);
	 		//设置图表显示格式
			var option_company_month = {
				title: {subtext: '公司月度排名(月份/名次)',x:'center'},
				tooltip:{trigger: 'axis'},
			    legend:{left:'center', top: 30,data:itemArr},
			    grid:  {left: '3%',right: '4%',bottom: '3%',containLabel: true},
			    xAxis: {type: 'category',boundaryGap: false,data: data_arr[0]},
			    yAxis: {type: 'value'},
			    series: [
			        {name:itemArr[0],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[0],data:data_arr[1]},
			        {name:itemArr[1],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[1],data:data_arr[2]},
			        {name:itemArr[2],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[2],data:data_arr[3]},
			        {name:itemArr[3],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[3],data:data_arr[4]},
			        {name:itemArr[4],type:'line',smooth:0.2,symbolSize:5,lineStyle:{normal:{width:2}},stack: itemArr[4],data:data_arr[5]}
			    ]
			};
			myChart_main_company_month.hideLoading();//去除等待动画
			myChart_main_company_month.setOption(option_company_month);
	 	},
	    error:function(){
		    alert("公司月度排名数据-获取失败！");
		}
	});
	//设置第3项图表样式--横向柱状图【部门内部年度排名】
	myChart_main_year.showLoading();
	$.ajax({
		type:"POST",
		url:"../holiday/achieveJsonHoliday.do",
    	data: {"userNo": userNo,"param":"3"},
		async:true,
	 	success:function(data){
	 		//部门排名
	 		var data_arr_dept = new Array();
	 		data_arr_dept = getYearData(data);
	 		//公司排名
	 		$.ajax({
				type:"POST",
				url:"../holiday/achieveJsonHoliday.do",
		    	data: {"userNo": userNo,"param":"4"},
				async:true,
			 	success:function(data){
			 		//图例
			 		var legend_arr = ['部门排名','公司排名']
			 		var data_arr_company = new Array();
			 		data_arr_company = getYearData(data);
			 		var option_year = {
			 			title: {subtext: '年度考勤排名(项目/名次)',x:'center'},
						tooltip: {
					        trigger: 'axis',
					        axisPointer: {type: 'shadow'}
					    },
					    legend:{left:'center', top: 30,data: legend_arr},
					    grid:  {left: '3%',right: '4%',bottom: '3%', containLabel: true},
					    xAxis: {type: 'value',boundaryGap: [0, 0.01]},
					    yAxis: {type: 'category', barWidth: '60%',data: itemArr},
					    series:[
					        {name: legend_arr[0],type: 'bar',data: data_arr_dept},
					        {name: legend_arr[1],type: 'bar',data: data_arr_company},
					    ]
			 		};//图表样式
					myChart_main_year.hideLoading();//去除等待动画
					myChart_main_year.setOption(option_year);
			 	},
			    error:function(){
				    alert("公司年度排名数据-获取失败！");
				}
			});
	 	},
	    error:function(){
		    alert("部门年度排名数据-获取失败！");
		}
	});
	/*
	//设置第4项图表样式--横向柱状图【公司内部年度排名】
	myChart_main_company_year.showLoading();
	$.ajax({
		type:"POST",
		url:"../holiday/achieveJsonHoliday.do",
    	data: {"userNo": userNo,"param":"4"},
		async:true,
	 	success:function(data){
	 		var data_arr = new Array();
	 		data_arr = getYearData(data);
	 		//图表样式
	 		var option_company_year = {
	 			title: {
					subtext: '公司年度排名(项目/名次)',x:'center'
				},
	 			tooltip: {
			        trigger: 'axis',
			        axisPointer: {
			            type: 'shadow'
			        }
			   },
			    grid: {left: '3%',right: '4%',bottom: '3%', containLabel: true},
			    xAxis: {type: 'value',boundaryGap: [0, 0.01]},
			    yAxis: {type: 'category',barWidth: '30%',data: itemArr},
			    series: [{name: '排名',type: 'bar',data: data_arr}]
	 		};//图表样式
			myChart_main_company_year.hideLoading();//去除等待动画
			myChart_main_company_year.setOption(option_company_year);
	 	},
	    error:function(){
		    alert("初始化页面错误，请关闭页面重新进入！");
		}
	});*/
	
});
/**
 * 2017-11-28
 * create by qianyan
 * 解析年度统计排名数据
 */
var getYearData = function (data){
	var queryHistoryMonthByDeptArray = data.queryHistoryMonthByDeptArray;
	var stayNo 		  = queryHistoryMonthByDeptArray[0].stayNo; //公出
	var thingNo		  = queryHistoryMonthByDeptArray[0].thingNo;//事假
	var sickLeaveNo   = queryHistoryMonthByDeptArray[0].sickLeaveNo;//病假
	var adjustResetNo = queryHistoryMonthByDeptArray[0].adjustResetNo;//调休
	var overtimeNo 	  = queryHistoryMonthByDeptArray[0].overtimeNo;//加班
	var dataArr = new Array();
	dataArr = [sickLeaveNo,thingNo,adjustResetNo,stayNo,overtimeNo];
	return dataArr;
};
/**
 * @author qianyang create by 2017-11-28
 * @param {Object} data
 * 解析月度统计排名数据
 */
var getMonthData = function(data) {
	var queryArray = data.queryHistoryMonthByDeptArray;
	var result_arr = new Array();
	var yAxisData = new Array();
	var usedSickLeave = new Array();
	var thingHoliday = new Array();
	var usedAdjustReset = new Array();
	var stay = new Array();
	var overtime = new Array();
	for(var i = 0; i < queryArray.length; i++) {
		yAxisData[i] = i + 1 + "月";
		var objQuery = queryArray[i];
		if(objQuery == null) {
			usedSickLeave[i]	= "0";
			thingHoliday[i] 	= "0";
			usedAdjustReset[i] 	= "0";
			stay[i] 			= "0";
			overtime[i] 		= "0";
		}else{
			usedSickLeave[i] 	= (objQuery.sickLeaveNo   == null ? "0" : objQuery.sickLeaveNo);
			thingHoliday[i] 	= (objQuery.thingNo 	  == null ? "0" : objQuery.thingNo);
			usedAdjustReset[i] 	= (objQuery.adjustResetNo == null ? "0" : objQuery.adjustResetNo);
			stay[i] 			= (objQuery.stayNo 		  == null ? "0" : objQuery.stayNo);
			overtime[i] 		= (objQuery.overtimeNo    == null ? "0" : objQuery.overtimeNo);
		}
	}
	//['病假', '事假', '调休', '公出','加班'];//统计事项
	result_arr = [yAxisData,usedSickLeave,thingHoliday,usedAdjustReset,stay,overtime];
	return result_arr;
}
