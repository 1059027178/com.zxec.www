<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
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
  
<script src="/js/jquery.js"></script>

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
			  <li>${NameDes}管理 </li>
			</ul>
		  </div>	
		  
		  <!--/.当前位置导航-->
		  
		    <!--.warninfo-->
		    
		  <div class="alert alert-block" style="padding:5px;">
		
		 <a rel="popover" id="helpchatter" class="badge badge-warning"  data-content="请保管好您的密码，使用完毕后请退出系统”。 
		" rel="popover" href="#" data-original-title="尝试输入以下字符来完成">i</a>
		<span style="padding-left:10px;"> 注意：请不要在公共电脑或网吧上使用本系统。</span>
         
         </div>	
		  <!--/.warninfo -->
		  
		  <!--.form-list${Lname} -->
		  
		  

		 
		 
		  <div id="formValidInfo" class="alert alert-error" style="display:none;"> </div>
		 
		 
		  <!-- Modal -->
		<script>
		$('#myModal').on('hidden', function() {
		  alert();
		});
		</script>
		  
			<form class="form-horizontal" id="listForm" name="listform" method="post">
			<a class="btn btn-medium btn-primary" href="/${Lname}Add.do">新建${NameDes}</a><br/><br/>
			
			<display:table name="${Lname}List" export="false" class="table table-striped table-bordered" id="list" requestURI="/${Lname}List.do">
				<display:column title="选择" style="width:5%">
//{autoCode0}
				</display:column>
				<display:column title="ID" property="${Lname}Id" sortable="true" escapeXml="false" style="width:10%"/>
//{autoCode}
				
			</display:table>
			
			<br/><br/>
			<label class="checkbox">
		      <input type="checkbox" name="chkall" onClick="CheckAll(this.form)" /> 全选 
		      &nbsp;<a href="javascript:;" onClick="deleteMoreObjs();" 
		      class="btn btn-mini btn-danger">删除所选</a><br/><br/>
		    </label>
			
			</form>
			
			<script>
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
			
			function CheckAll(form){
			  for (var i=0;i<form.elements.length;i++){
			    var e = form.elements[i];
			    if (e.name != 'chkall')
			       e.checked = form.chkall.checked;
			   }
			}
			
			
	
			function deleteSingleObj(keyId){ 
			  validInfoHide();		 
			  //ajax调用  
			    $.ajax({    
			        type:'post',        
			        url:'/${Lname}Json.do?showType=delete${Name}',    
			        data:{${Lname}Id:keyId}, 
		        	dataType:'json',
			        cache:false,
			        success:function(data){
				        if(data.indexOf("ok")>-1){      
				            successInfoShow("<i class=\"icon-ok\"></i> 恭喜您,删除成功!");
				        }else{    
				            validInfoShow(data.errmsg); 
				        }
				        
			        },
			        error:function(){
                       validInfoShow("操作失败！"); 
                    }
			    });    
			}
			
			
			function deleteMoreObjs(){ 
			  validInfoHide();	 
			  
	          var checkedNum = $("input[name='selId']:checked").length;    
	          if(checkedNum == 0) {    
	              validInfoShow("请至少选择一项！"); 
	              return;    
	          }
	          
	          // 批量选择     
	          if(confirm("确定要删除所选项目？")) {    
	              var checkedList = new Array();    
	              $("input[name='selId']:checked").each(function() {    
	                  checkedList.push($(this).val());    
	              });    
	      		  var delvals = checkedList.toString();
	      		  //alert(delvals);
	              $.ajax({    
	                  type: "POST",    
	                  url: "/${Lname}Json.do?showType=delete${Name}s",    
	                  data: {delitems:delvals}, 
		        	  dataType:'json',
    				  async : false, //默认为true 异步   
	                  success: function(data){   
	                      if(data.errmsg=="ok"){      
					            successInfoShow("<i class=\"icon-ok\"></i> 恭喜您,删除成功!");
					        }else{    
					            validInfoShow(data.errmsg); 
					        }   
	                  },
				        error:function(){
	                       validInfoShow("操作失败！"); 
	                    }
	              });    
	          }      
          }
			
			
			</script>
			

		   <!--/.form-list${Lname} -->
		 
		  
		  
		  
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