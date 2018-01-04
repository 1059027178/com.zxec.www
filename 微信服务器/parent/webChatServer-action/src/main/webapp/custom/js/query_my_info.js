/**
 * create by qianyang 2017-12-28
 */
$(document).ready(function(){
	//修改按钮事件
	$(".edit").click(function(){
	    $(".editbutton").css("display","block");
	    $(".edit").css("display","none");
	    $(".page_show").css("display","none");
	    $(".page_edit").css("display","block");
	});
	//返回按钮事件
	$(".back").click(function(){
	    $(".editbutton").css("display","none");
	    $(".edit").css("display","block");
	    $(".page_show").css("display","block");
	    $(".page_edit").css("display","none");
	});
	//修改后提交
	$(".submit").click(function(){
        var userno       = $("#userno").html().trim();
        var usertel      = $("#usertel").val().trim();
        var email        = $("#email").val().trim();
        var useraddress  = $("#useraddress").val().trim();
        var fatherName   = $("#fatherName").val().trim();
        var fatherBirth  = $("#fatherBirth").val().trim();
        var motherName   = $("#motherName").val().trim();
        var motherBirth  = $("#motherBirth").val().trim();
        var tel          = $("#tel").val().trim();
        var address      = $("#address").val().trim();
        //检查以上是否不为空
        var isNull = (
        	usertel 	== "" && 
        	email 		== "" && 
        	useraddress == "" && 
        	fatherName 	== "" && 
        	fatherBirth == "" && 
        	motherName 	== "" && 
        	motherBirth == "" && 
        	tel 		== "" && 
        	address 	== ""
        );
        if(isNull){
        	alert("请填写相关信息！");
        }
        else {
        	//显示遮罩层，函数定义在public.js中
            blockUI({target:"",message:"亲，正在提交哦^_^..."});
            var _json = {
            	'userno':userno,
            	'usertel':usertel,
            	'email':email,
            	'useraddress':useraddress,
            	'fatherName':fatherName,
            	'fatherBirth':fatherBirth,
            	'motherName':motherName,
            	'motherBirth':motherBirth,
            	'tel':tel,
            	'address':address
            };
            //提交数据
            $.ajax({
        		type:"POST",
        		url:"../center/updateMyInfo.do",
        		async:true,
        		data:_json,
        	 	success:function(data){
        	 		var object = eval('(' + data + ')');
        	 		var result = object.msg;//true更新成功；否则失败
//        	 		console.log(result);
        	 		if(result == true){
        	 			alert("修改成功！");
        	 			window.location.reload();//刷新当前页面.
        	 		}else{
        	 			alert("修改失败！");
        	 		}
        	 		//去除遮罩层
	            	unblockUI();
        	 		//模拟服务器处理时间
        	 		/*setTimeout(function () {
    	            	//去除遮罩层
    	            	unblockUI();
        	 		}, 6000);*/
        	 	},
    		    error:function(){
    			    alert("请求错误，请稍后重试！");
    			    //去除遮罩层
    			    unblockUI();
    			}
            });
        }
	});
});
/*日期控件*/
$("#fatherBirth").datetimepicker({
    minView:"month",
    format:'yyyy/mm/dd',
    language: 'zh-CN',
    weekStart: 1,
    todayBtn: 1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showMeridian: 1
});
$("#motherBirth").datetimepicker({
    minView:"month",
    format:'yyyy/mm/dd',
    language: 'zh-CN',
    weekStart: 1,
    todayBtn: 1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showMeridian: 1
});