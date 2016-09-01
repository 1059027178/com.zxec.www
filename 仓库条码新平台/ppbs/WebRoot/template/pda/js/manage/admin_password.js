var init={
	"index":function(){
		window.location.href="menu!first.action";
	},
	"update":function(){
		var timestamp = (new Date()).valueOf();
		if($("#inputPassword").val()==""){
			alert("密码不允许为空!");
			return false;
		}
		if($("#inputPassword").val()!=$("#inputPasswordAg").val()){
			alert("两次输入密码不一致!");
			return false;
		}
		var param=$("#inputForm").serialize()+"&timestamp="+timestamp;
		$.ajax({	
			url: "admin!updateUserPasswd.action",
			data:param,
			dataType: "json",
			async: false,
			success: function(data) {
				if(data.status="success"){
					alert(data.message);
					window.location="/admin/logout";
				//	layer.alert(data.message,{area:['200px','150px']},function(){window.location="/admin/logout";});
				//	layer.alert(data.message,{area:['100px','150px']});
				}else{
					alert(data.message);
				}
					//layer.alert(data.message,1,false);
			},error:function(data){
				alert(data.message);
				//layer.alert("密码更新错误",1,false);
			}
		});
	}
		
}

$(function(){
	init.saveButton = $("#saveButton");
	init.indexButton=$("#indexButton");
	
	/**
	 * 首页
	 */
	init.indexButton.click(function(){
		init.index();
	});
	
	/**
	 * 更新
	 */
	init.saveButton.click(function(){
		init.update();
	});
	
})