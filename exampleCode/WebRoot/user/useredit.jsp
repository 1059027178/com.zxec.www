<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改密码</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
		<script src="./js/jquery.js"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="./css/jiuhui.css" rel="stylesheet">
	
<BODY>
		  <form name="jiuhui"  id="jiuhui" >
		  
		  <div class="div" style=" padding-top: 50px;">
		<%HttpSession session2 = request.getSession(); %>
  		<ul>
  			用&nbsp;户&nbsp;名：<%=session2.getAttribute("username") %>
			<li class="li">用户&nbsp; &nbsp;别名：<input name="userName" class="text"  type="text" readonly="readonly" id="userName"  style="width:90px;background-color:white;" value="陈科飞"></li>
  			<li class="li">用户新密码：<input name="inputPassword" type="text"  id="inputPassword"  style="width:90px;background-color:white;"class="text"></li>
  			<li class="li">重复新密码：<input name="inputPasswordAg"class="text"  type="text"  style="width:90px;background-color:white;" id="inputPasswordAg"></li>
  			
  			<li class="li">
  			<input type="button" valign="center" style="width:40px;height:25px;" class="button" onclick="save();" value="确定"/>
  			<input type="button" class="button" style="width:40px;height:25px;" onclick="window.location.href='MainServlet?flag=return';" value="首页"></li>
  			
  			<input type="hidden" id="userId" name="userId" value="${userObj.userId}"/>
			 <input type="hidden" id="userBH" name="userBH" value="${userObj.userBH}"/>
			 <input type="hidden" name="userFunction" id="userFunction" value="${userObj.userFunction}" />	
  		</ul>
  	</div>
		</form>
	 
<script src="/js/md5.js"></script>	
<!--[if lte IE 6]>
  <script type="text/javascript" src="js/bootstrap-ie.js"></script>
<![endif]-->
	 <script  langth="javascript">			
function save(){
		var userId= $('#userId').val();
		var userBH= $('#userBH').val();
		var userName= $('#userName').val();
		var inputPassword= $('#inputPassword').val();
		var inputPasswordAg= $('#inputPasswordAg').val();
		var userFunction= $('#userFunction').val();

		jQuery.ajax({
				type:'get',        
		        url:'/userJson.do?showType=updateUser',
		        data:{"userId":userId,"userBH":userBH,"userName":userName,"inputPassword":inputPassword,"inputPasswordAg":inputPasswordAg,"userFunction":userFunction},
		        dataType:'json',
		        cache:false, 
		        success:function(data){ 			            
			         alert(data.errmsg); 
			         if(data.errmsg=='用户修改成功!'){
			         	  window.location.href="/logout.do";
			         }
		        },
		        error:function(){       
			       alert("发生调用异常!");
			    }
			});
		
}
	function validInfoShow(themsg){
	  $('#formValidInfo').html(themsg);
	  $('#formValidInfo').show(200);
	}
	function successInfoShow(themsg){
	    $.teninedialog({
                title:'系统提示',
                content:themsg,
                showCloseButton:true,
                //otherButtons:["确定","取消"],
                //otherButtonStyles:['btn-primary','btn-primary'],
                bootstrapModalOption:{keyboard: true},
                /*
                dialogShow:function(){
                    alert('即将显示对话框');
                },
                dialogShown:function(){
                    alert('显示对话框');
                },
                dialogHide:function(){
                    alert('即将关闭对话框');
                },
                */
                dialogHidden:function(){
                    //alert('关闭对话框');
                    window.location.href="/hrminfoList.do";
                }      
                /*            
                clickButton:function(sender,modal,index){
                    alert('选中第'+index+'个按钮：'+sender.html());
                    $(this).closeDialog(modal);
                }
                */
         });
	}
</script>

</BODY>
  <script type="text/javascript">
  document.getElementById("inputPassword").focus();
  </script>
</HTML>