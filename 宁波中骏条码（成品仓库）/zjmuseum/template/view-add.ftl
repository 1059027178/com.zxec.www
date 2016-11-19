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

 <!--[if lte IE 6]>
  <link rel="stylesheet" type="text/css" href="/css/bootstrap-ie6.css">
  <![endif]-->
  <!--[if lte IE 7]>
  <link rel="stylesheet" type="text/css" href="/css/ie.css">
  <![endif]--> 
  


<link href="/css/displaytag-fix.css" rel="stylesheet">

  
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

<!--begin file input-->
<link href="/js/jquery-ui-bootstrap/third-party/jQuery-UI-FileInput/css/enhanced.css" rel="Stylesheet">
<script src="/js/jquery-ui-bootstrap/third-party/jQuery-UI-FileInput/js/enhance.min.js" type="text/javascript"></script>
<script src="/js/jquery-ui-bootstrap/third-party/jQuery-UI-FileInput/js/fileinput.jquery.js" type="text/javascript"></script>
<!--End file input-->



<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>

<script>
	$(document).ready(function(){	  
		$.formValidator.initConfig({theme:"Default",formID:"${Lname}Form",debug:false,submitOnce:false,wideword:true,
			onerror:function(msg,obj,errorlist){
				validInfoShow(msg);
			},
			ajaxForm:{
				type:'post',        
		        url:'/${Lname}Json.do?showType=create${Name}',
		        data:null,
		        dataType:'json',
		        cache:false, 
		        success:function(data){            
			        if(data.${Lname}Id){      
			            successInfoShow("<i class=\"icon-ok\"></i> 恭喜您，创建成功！");	
			        }else{    
			            validInfoShow(data.errmsg); 
			        }       
			        
		        },
		        error:function(){       
			       validInfoShow("发生调用异常!");
			    }
			},
		});
		//$("#${Lname}BH").formValidator({onShow:"请输入${NameDes}登录名",onFocus:"${NameDes}登录名至少1个字符,最多10个字符"}).inputValidator({min:1,max:20,onError:"您输入的${NameDes}名不合法,请确认"}).defaultPassed();
		//$("#${Lname}Name").formValidator({onShow:"请输入真实姓名",onFocus:"真实姓名至少1个字符,最多10个字符"}).inputValidator({min:1,max:10,onError:"您输入的真实姓名不合法,请确认"}).defaultPassed();
		//$("#inputPassword").formValidator({onShow:"请输入密码",onFocus:"至少1个长度",onCorrect:"密码合法"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"密码两边不能有空符号"},onError:"密码不能为空,请确认"});
		//$("#inputPasswordAg").formValidator({onShow:"输再次输入密码",onFocus:"至少1个长度",onCorrect:"密码一致"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:"重复密码两边不能有空符号"},onError:"重复密码不能为空,请确认"}).compareValidator({desID:"inputPassword",operateor:"=",onError:"2次密码不一致,请确认"});
		//$("#${Lname}Function").formValidator({onShow:"请输入权限字符串",onFocus:"1000-表示普通${NameDes},1001-表示管理员,中间用半角逗号隔开"}).inputValidator({min:4,max:120,onError:"您输入的权限字符串不合法"}).defaultPassed();
	});
	
	function validInfoShow(themsg){
	  $('#formValidInfo').html(themsg);
	  $('#formValidInfo').show(200);
	}
	
	function validInfoHide(){
	  $('#formValidInfo').hide(200);
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
                    window.location.href="/${Lname}List.do";
                }      
                /*            
                clickButton:function(sender,modal,index){
                    alert('选中第'+index+'个按钮：'+sender.html());
                    $(this).closeDialog(modal);
                }
                */
         });
	}
	
	
	function checkForm(){ 
	  for ( instance in CKEDITOR.instances ) 
	    CKEDITOR.instances[instance].updateElement(); 
	 
	  return true; 
	} 
	
			
</script>

</HEAD>
<BODY>

<%@ include file="../include/header.jsp"%>


 <div class="container-fluid">
      <div class="row-fluid">
        <div class="span2">	      
		<%@ include file="../include/lefter.jsp"%>
        </div><!--/span2-->
		
		
        <div class="span10">
		
		
		  
		
		  <!--.当前位置导航-->
		  
		  <div class="row-fluid">
		     <ul class="breadcrumb">
			  <li>
				当前位置：<span><i class="icon-home"></i> <a href="/main.do?showType=main">首页</a></span> <span class="divider">/</span>
			  </li>
			  <li><a href="/${Lname}List.do">${NameDes}管理</a>  <span class="divider">/</span> </li>
			  <li>新建${NameDes} </li>
			</ul>
		  </div>	
		  
		  <!--/.当前位置导航-->
		  
		    <!--.warninfo-->
		    
		  <div class="alert alert-block" style="padding:5px;">
		
		 <a rel="popover" id="helpchatter" class="badge badge-warning"  data-content="请保管好您的密码，使用完毕后请退出系统。" rel="popover" href="#">i</a>
		<span style="padding-left:10px;"> <%=warnmsg1%></span>
         
         </div>	
		  <!--/.warninfo -->
		  
		  <!--.form-${Lname}Profile -->
		  <div id="formValidInfo" class="alert alert-error" style="display:none;">
		  </div>

		  <form class="form-horizontal" id="${Lname}Form" onSubmit="return checkForm();">
		  
//{autoCode}
			  
			  
			  <div class="control-group">
			  <label class="control-label" for=""></label>
			    <div class="controls">
			      <button type="submit" id="submitBtn" class="btn btn-primary">提交保存</button>			       
			    </div>
			   
			  </div>
			</form>
			

		   <!--/.form-${Lname}Profile -->
		 
		  
		  
		  
		   </div><!--/.span10-global-->
	   </div><!--/.fluid-row-global-->
    </div><!--/.fluid-container-global-->
	
	
	 <hr>
	 
<script type="text/javascript" src="/js/jquery.bootstrap.teninedialog.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<!--[if lte IE 6]>
  <script type="text/javascript" src="js/bootstrap-ie.js"></script>
<![endif]-->

	
<%@ include file="../include/footer.jsp"%>
	 

</BODY>

</HTML>