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

<script src="/js/jquery.js"></script>
<script src="/js/formValidation/formValidator-4.1.1.js" type="text/javascript" charset="UTF-8"></script>
<script src="/js/formValidation/formValidatorRegex.js" type="text/javascript" charset="UTF-8"></script>
<script>
	$(document).ready(function(){	  
		$.formValidator.initConfig({theme:"Default",formID:"profileForm",debug:false,submitOnce:false,wideword:true,
			onerror:function(msg,obj,errorlist){
				validInfoShow(msg);
			},
			ajaxForm:{
				type:'get',        
		        url:'/userJson.do?showType=updateProfile',
		        data:null,
		        dataType:'json',
		        cache:false, 
		        success:function(data){ 			            
			        if(data.errmsg=="ok"){      
			            validInfoShow("修改成功！");	
			            $('#formValidInfo').removeClass('alert-error');
			            $('#formValidInfo').addClass('alert-success');
			            $("#profileForm").reset();
			        }else{    
			            validInfoShow(data.errmsg); 
			        }       
			        
		        },
		        error:function(){       
			       validInfoShow("发生调用异常!");
			    }
			},
		});
		//$("#userName").formValidator({onShow:"请输入用户别名",onFocus:"用户名至少1个字符,最多10个字符"}).inputValidator({min:1,max:10,onError:"您输入的用户名不合法,请确认"}).defaultPassed();
		$("#userPassword").formValidator({onShow:"请输入密码",onFocus:"至少1个长度",onCorrect:"密码合法"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码不能为空,请确认"});
		$("#inputPassword").formValidator({onShow:"请输入密码",onFocus:"至少1个长度",onCorrect:"密码合法"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码不能为空,请确认"});
		$("#inputPasswordAg").formValidator({onShow:"输再次输入密码",onFocus:"至少1个长度",onCorrect:"密码一致"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"重复密码两边不能有空符号"},onError:"重复密码不能为空,请确认"}).compareValidator({desID:"inputPassword",operateor:"=",onError:"2次密码不一致,请确认"});
		
	});
	
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
			  <li>个人设置 </li>
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
			      <h3>${loginUser.userBH}</h3>
			      <input type="hidden" name="userId" value="${loginUser.userId}"/>
			      <input type="hidden" name="userBH" value="${loginUser.userBH}"/>
			    </div>
			  </div>
			  
			  <div class="control-group">
			    <label class="control-label" for="userName">用户别名</label>
			    <div class="controls">
				    <div class="row">
					  <div class="span3"><input type="text" name="userName" readonly id="userName" value="${loginUser.userName}" placeholder="用户别名">	</div>
					  <div id="userNameTip" class="span4"></div>
					</div>
			    </div>
			  </div>
			  
			  <div class="control-group">
			    <label class="control-label" for="userPassword">用户密码</label>
			    <div class="controls">
			        <div class="row">
					   <div class="span3"> <input type="password" id="userPassword" name="userPassword" placeholder="用户密码"></div>
					   <div id="userPasswordTip" class="span4"></div>
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
			  <label class="control-label" for=""></label>
			    <div class="controls">
			      <button type="submit" id="submitBtn" class="btn btn-primary">提交修改</button>			       
			    </div>
			   
			  </div>
			</form>
			

		   <!--/.form-userProfile -->
		 
		  
		  
		  
		   </div><!--/.span10-global-->
	   </div><!--/.fluid-row-global-->
    </div><!--/.fluid-container-global-->
	
	
	 <hr>
	 
<script src="/js/md5.js"></script>	
<script src="/js/bootstrap.min.js"></script>
<!--[if lte IE 6]>
  <script type="text/javascript" src="js/bootstrap-ie.js"></script>
<![endif]-->

	
<%@ include file="../include/footer.jsp"%>
	 

</BODY>

</HTML>