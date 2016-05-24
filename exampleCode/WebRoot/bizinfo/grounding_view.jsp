<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>上架</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<meta http-equiv="description" content="This is my page">
	<script src="./js/jquery.js"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    
	<link href="./css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  	function getNlpla(){

  		var nlpla=$("#nlpla").val();
  		var lgort=$("#lgort").val();
  		if(nlpla=='' || nlpla==null){
  			alert("请输入仓位号！");
  			return;
  		}
  		if(lgort=='' || lgort==null){
  			alert("请输入库存地点！");
  			return;
  		}
		/* jQuery.ajax({
			url:'/receiptJson.do',
	 		async:false,
	 		type:"post",
	 		data:{"showType":"getNlpla","nlpla":nlpla,"lgort":lgort},
	 		dataType:'json',
	 		success:function(data){
	 			$("#lgber").attr("value",data.lgber);
	 			$("#lgtyp").attr("value",data.lgtyp);
	 		},
	        error:function(){       
		       alert("系统异常，请联系管理员");
		    }
		}); */
	}
	function getLgber(){
		var nlpla=$("#nlpla").val();
		//alert(nlpla.substr(0,1));
		if(nlpla == "" || nlpla == null){
			alert("请输入仓位号！");return;
		}else{
			$("#lgber").attr("value",nlpla.substr(0,2));
		}
		
	}
  function forward(){
  	window.location.href="MainServlet?flag=1.2";
  }
  function submit1(obj){
  	var nlpla=$("#nlpla").val();
	var lgber=$("#lgber").val();
	//var lgtyp=$("#lgtyp").val();
	if(nlpla=='' || nlpla==null){
		alert("请输入仓位号！");
		return;
	}
	if(lgber=='' || lgber==null){
		alert("请输入存储区！");
		return;
	}
	/* if(lgtyp=='' || lgtyp==null){
		alert("请输入存储类型！");
		return;
	} */
  	obj.disabled=false;
  	document.form.submit();
  }
  </script>
  <style>
  	body{
  		margin-top:50px;
  	}
  </style>
  <body>
  <div>
  <form name="form" action="MainServlet?flag=groundingEdit" method="post">
	<input name="matnr" type="hidden" value="<%=request.getSession().getAttribute("matnr") == null ? "" : request.getParameter("matnr").trim()%>"/>
     <ul>
     	<li class="li" style="margin:20px 0px 0px 0px;">
     	上架仓位：<input name="nlpla" class="text" style="background-color:white;" onchange="getLgber()" type="text"  id="nlpla" value="A1-1">
     	</li>
		<li class="li" style="margin:20px 0px 0px 0px;">
		存储区<span style="margin-left:14px;"></span>：<input name="lgber" class="text" style="background-color:#D8D8D8;" readonly= readonly type="text"  id="lgber" value="A1"/> 
		</li>
		<li class="li" style="margin:20px 0px 0px 0px;">
		存储类型：<input name="lgtyp" class="text" style="background-color:#D8D8D8;" readonly= readonly type="text"  id="lgtyp" value="Z10"/>
		</li>
		<li class="li" style="margin:20px 0px 0px -15px;">
			<input class="button" type="button" onclick="submit1(this);" value="确定"/>
			<input class="button" type="button" onclick="forward();" value="返回"/>
			<input type="button" class="button" onclick="window.location.href='MainServlet?flag=return';" value="首页">
		</li>
	</ul>
  </form>
</div>
  </body>
</html>
