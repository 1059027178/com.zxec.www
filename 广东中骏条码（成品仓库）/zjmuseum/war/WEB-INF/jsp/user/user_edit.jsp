<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/const.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<HEAD>
<TITLE><%=sysname%> - <%=company%></TITLE>
<META http-equiv=Content-Type content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="<%=desp%>">
<meta name="company" content="<%=company%>">
<!-- Le styles -->
<style type="text/css">
    body {
      padding-top: 60px;
      padding-bottom: 40px;
    }
    .sidebar-nav {
      padding: 0;
    }
  </style>
  
  
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/bootstrap-responsive.css" rel="stylesheet">

 <!--[if lte IE 6]>
  <link rel="stylesheet" type="text/css" href="/css/bootstrap-ie6.css">
  <![endif]-->
  <!--[if lte IE 7]>
  <link rel="stylesheet" type="text/css" href="/css/ie.css">
  <![endif]--> 
  

  
<script src="/js/jquery.js"></script>
<script src="/js/formValidation/formValidator-4.1.1.js" type="text/javascript" charset="UTF-8"></script>
<script src="/js/formValidation/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
<link type="text/css" href="/js/jquery-ui-bootstrap/css/custom-theme/jquery-ui-1.10.0.custom.css" rel="stylesheet" />
<link type="text/css" href="/js/jquery-ui-bootstrap/assets/css/font-awesome.min.css" rel="stylesheet" />
<!--[if IE 7]>
<link rel="stylesheet" href="/js/jquery-ui-bootstrapassets/css/font-awesome-ie7.min.css">
<![endif]-->
<!--[if lt IE 9]>
<link rel="stylesheet" type="text/css" href="/js/jquery-ui-bootstrap/css/custom-theme/jquery.ui.1.10.0.ie.css"/>
<![endif]--> 
<link href="/css/displaytag-fix.css" rel="stylesheet">

<script>
	$(document).ready(function(){	  
		$.formValidator.initConfig({theme:"Default",formID:"profileForm",debug:false,submitOnce:false,wideword:true,
			onerror:function(msg,obj,errorlist){
				validInfoShow(msg);
			},
			ajaxForm:{
				type:'get',        
		        url:'/userJson.do?showType=updateUser',
		        data:null,
		        dataType:'json',
		        cache:false, 
		        success:function(data){ 			            
			        if(data.errmsg=="ok"){      
			            successInfoShow("<i class=\"icon-ok\"></i> 恭喜您，修改成功！");	
			        }else{    
			            validInfoShow(data.errmsg); 
			        }       
			        
		        },
		        error:function(){       
			       validInfoShow("发生调用异常!");
			    }
			},
		});
		$("#userName").formValidator({onShow:"请输入用户别名",onFocus:"用户名至少1个字符,最多10个字符"}).inputValidator({min:1,max:10,onError:"您输入的用户名不合法,请确认"}).defaultPassed();
		//$("#inputPassword").formValidator({onShow:"",onFocus:"",onCorrect:"密码一致"}).compareValidator({desID:"inputPasswordAg",operateor:"=",onError:"2次密码不一致,请确认"});
		//$("#inputPasswordAg").formValidator({onShow:"",onFocus:"",onCorrect:"密码一致"}).compareValidator({desID:"inputPassword",operateor:"=",onError:"2次密码不一致,请确认"});
		$("#userFunction").formValidator({onShow:"请输入权限字符串",onFocus:"1000-表示普通用户,1001-表示管理员,1002-表示半成品用户,中间用半角逗号隔开"}).inputValidator({min:4,max:120,onError:"您输入的权限字符串不合法"}).defaultPassed();
	});
	
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
                   window.location.reload();
               }      
               /*            
               clickButton:function(sender,modal,index){
                   alert('选中第'+index+'个按钮：'+sender.html());
                   $(this).closeDialog(modal);
               }
               */
	   });
	}

	function validInfoShow(themsg){
	  $('#formValidInfo').html(themsg);
	  $('#formValidInfo').show(200);
	}
	
	function validInfoHide(){
	  $('#formValidInfo').hide(200);
	}
	
			
</script>

</HEAD>
<BODY>

<%@ include file="../include/header.jsp"%>


 <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">	      
		<%@ include file="../include/lefter.jsp"%>
        </div>
		
		
        <div class="span10">
		
		
		  
		
		  <!--.当前位置导航-->
		  
		  <div class="row-fluid">
		     <ul class="breadcrumb">
			  <li>
				当前位置：<span><i class="icon-home"></i> <a href="/main.do?showType=main">首页</a></span> <span class="divider">/</span>
			  </li>
			  <li><a href="/userList.do">用户管理</a>  <span class="divider">/</span> </li>
			  <li>修改用户 </li>
			</ul>
		  </div>	
		  
		  <!--/.当前位置导航-->
		  
		    <!--.warninfo-->
		    
		  <div class="alert alert-block" style="padding:5px;">
		
		 <a rel="popover" id="helpchatter" class="badge badge-warning"  data-content="请保管好您的密码，使用完毕后请退出系统。" rel="popover" href="#">i</a>
		<span style="padding-left:10px;"> <%=warnmsg1%></span>
         
         </div>	
		  <!--/.warninfo -->
		  
		  <!--.form-userProfile -->
		  <div id="formValidInfo" class="alert alert-error" style="display:none;">
		  </div>

		  <form class="form-horizontal" id="profileForm">
		  
		
		    
		      <div class="control-group">
			    <label class="control-label" for="userBH">用户名</label>
			    <div class="controls">
			      <h3>${userObj.userBH}</h3>
			      <input type="hidden" id="userId" name="userId" value="${userObj.userId}"/>
			      <input type="hidden" id="userBH" name="userBH" value="${userObj.userBH}"/>
			    </div>
			  </div>
			  
			  <div class="control-group">
			    <label class="control-label" for="userName">用户别名</label>
			    <div class="controls">
				    <div class="row">
					  <div class="span3"><input type="text" name="userName" id="userName" value="${userObj.userName}" placeholder="用户别名">	</div>
					  <div id="userNameTip" class="span4"></div>
					</div>
			    </div>
			  </div>
			  
			  <div class="control-group">
			    <label class="control-label" for="inputPassword">用户新密码</label>
			    <div class="controls">
			    
			        <div class="row">
					   <div class="span3"> <input type="password"  id="inputPassword" name="inputPassword" placeholder="用户新密码"></div>
					   <div id="inputPasswordTip" class="span4"></div>
					</div>
			    </div>
			  </div>
			  <div class="control-group">
			    <label class="control-label" for="inputPasswordAg">重复新密码</label>
			    <div class="controls">
			    
			    
			        <div class="row">
					   <div class="span3"> <input type="password" id="inputPasswordAg" name="inputPasswordAg" placeholder="重复新密码">	 </div>
					   <div id="inputPasswordAgTip" class="span4"></div>
					</div>
			       
			    </div>
			   
			  </div>
			  
			  
			    <div class="control-group">
			    <label class="control-label" for="userFunction">用户权限</label>
			    <div class="controls">
				    <div class="row">
					  <div class="span3"><input type="text" name="userFunction" id="userFunction" value="${userObj.userFunction}" placeholder="权限字符串">	</div>
					  <div id="userFunctionTip" class="span4"></div>
					</div>
			    </div>
			  </div>
			  
			  
			  <div class="control-group">
			  <label class="control-label" for=""></label>
			    <div class="controls">
			      <button type="button" id="submitBtn" class="btn btn-primary"  onclick="save();">提交修改</button>			       
			    </div>
			   
			  </div>
			</form>
			

		   <!--/.form-userProfile -->
		 
		  
		  
		  
		   </div><!--/.span10-global-->
	   </div><!--/.fluid-row-global-->
    </div><!--/.fluid-container-global-->
	
	
	 <hr>
	 
<script src="/js/md5.js"></script>	
<script type="text/javascript" src="/js/jquery.bootstrap.teninedialog.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<!--[if lte IE 6]>
  <script type="text/javascript" src="js/bootstrap-ie.js"></script>
<![endif]-->

	
<%@ include file="../include/footer.jsp"%>
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

</HTML>