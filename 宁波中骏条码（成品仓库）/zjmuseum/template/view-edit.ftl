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
		        url:'/${Lname}Json.do?showType=update${Name}',
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
		//$("#${Lname}Name").formValidator({onShow:"请输入真实姓名",onFocus:"${NameDes}名至少1个字符,最多10个字符"}).inputValidator({min:1,max:10,onError:"您输入的${NameDes}名不合法,请确认"}).defaultPassed();
		//$("#inputPassword").formValidator({onShow:"",onFocus:"",onCorrect:"密码一致"}).compareValidator({desID:"inputPasswordAg",operateor:"=",onError:"2次密码不一致,请确认"});
		//$("#inputPasswordAg").formValidator({onShow:"",onFocus:"",onCorrect:"密码一致"}).compareValidator({desID:"inputPassword",operateor:"=",onError:"2次密码不一致,请确认"});
		//$("#${Lname}Function").formValidator({onShow:"请输入权限字符串",onFocus:"1000-表示普通${NameDes},1001-表示管理员,中间用半角逗号隔开"}).inputValidator({min:4,max:120,onError:"您输入的权限字符串不合法"}).defaultPassed();
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
	
	function checkForm(){ 
	  for ( instance in CKEDITOR.instances ) 
	    CKEDITOR.instances[instance].updateElement(); 
	 
	  return true; 
	} 
	
	
function deleteSFile(fileName,xObj,xValueObj){      
  $.ajax({   
	          url:'/userAJAX.do?rand=parseInt(Math.random()*1000)&showType=deleteFileByFileName',   
	          data:{fileName:fileName},   
	          cache:false,
	          dataType:'json', //很重要!!!.      预期服务器返回的数据类型   
	          error:function(){   
	              alert("操作失败!!"); 
	          },   
	          success:function(data){	
	              if(data.errmsg=="ok"){
	                 //xObj.style.display = "none";
	                 $(xObj).hide();
		  			 xValueObj.value = xValueObj.value.replace(fileName,""); 
		  			 //alert(xValueObj.value);  
	              }
	              else{
	                 alert("操作失败!!");       	                 
	              }                      
	        	                       
	          }  
	  });   
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
			  <li>修改${NameDes} </li>
			</ul>
		  </div>	
		  
		  <!--/.当前位置导航-->
		  
		    <!--.warninfo-->
		    
		  <div class="alert alert-block" style="padding:5px;">
		
		 <a rel="popover" id="helpchatter" class="badge badge-warning"  data-content="请保管好您的密码，使用完毕后请退出系统。" rel="popover" href="#">i</a>
		<span style="padding-left:10px;"> <%=warnmsg1%></span>
         
         </div>	
		  <!--/.warninfo -->
		  
		  <!--.form-${Lname}Edit -->
		  <div id="formValidInfo" class="alert alert-error" style="display:none;">
		  </div>

		  <form class="form-horizontal" id="${Lname}Form" onSubmit="return checkForm();">
		
//{autoCode}
			  
			
			  
			  <div class="control-group">
			  <label class="control-label" for=""></label>
			    <div class="controls">
			      <button type="submit" id="submitBtn" class="btn btn-primary">提交修改</button>			       
			    </div>
			   
			  </div>
			</form>
			

		   <!--/.form-${Lname}Edit -->
		 
		  
		  
		  
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
	 

</BODY>

</HTML>