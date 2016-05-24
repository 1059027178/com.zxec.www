<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="true"%> 
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%-- <jsp:useBean id="LiangxinUtil" class="com.thinkway.LiangxinUtil" scope="page" /> --%>


<html>

  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <script language="javascript" src="./js/jiuhui.js"></script>
    <title>下架操作结果</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<link href="./css/jiuhui.css" rel="stylesheet">
  </head>
  <script type="text/javascript">
  	function forward(){
  		window.location.href="MainServlet?flag=2";
  	}
  	function submit1(obj){
  		var PONO=document.getElementById("PONO").value;
  		var shipper=document.getElementById("shipper").value;
  		if(shipper == ""){
  			alert("请填写供应商编号！");return;
  		}
  		if(PONO == ""){
  			alert("请填写PO号！");return;
  		}
  		obj.disabled=false;
  		document.form.submit();
  	}
  </script>
  <body>
  <div>
  <form action="MainServlet?flag=weiwaiD" method="post" name="form">
 	<ul>
 		<li class="li" style="line-height:20px;">
 			<%=request.getSession().getAttribute("message") == null ? "" : request.getSession().getAttribute("message").toString().trim()%>
 			<br/>
 			<%=request.getSession().getAttribute("aufnr") == null ? "" : request.getSession().getAttribute("aufnr").toString().trim()%>
 		</li>
 		<li class="li">
    		物料编码：<input name="matnr" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="matnr" value = "<%=request.getSession().getAttribute("matnr") == null ? "": request.getSession().getAttribute("matnr")%>" />
    	</li>
    	<li class="li">
    		物料描述：<input name="maktx" readonly=readonly style="width:60%;heigth:70%;background-color:#D8D8D8;"  type="text"  id="maktx" value = "<%=request.getSession().getAttribute("maktx") == null ? "": request.getSession().getAttribute("maktx")%>"/>
    	</li>
    	<li class="li">
    		数量合计：<input style="width:45%;heigth:70%;background-color:#D8D8D8;" type="text" id="num" name="num" value = "<%=request.getSession().getAttribute("num") == null ? "": request.getSession().getAttribute("num")%>"/>
    	</li>
    	<li class="li">
    		供应商<span style="width:14px"></span>：<input style="width:60%;heigth:70%;" type="text" id="shipper" name="shipper" value = ""/>
    	</li>
    	<li class="li">
    		PO号<span style="width:24px"></span>：<input style="width:60%;heigth:70%;" type="text" id="PONO" name="PONO" value="" />
    	</li>
    	<li class="li">
    		库存地点：<input style="width:45%;heigth:70%;background-color:#D8D8D8;" readonly=readonly  type="text" id="kucunDidian" name="kucunDidian" value = "3107"/>
    	</li>
    	<li class="li">
    		移动类型：<input style="width:45%;heigth:70%;background-color:#D8D8D8;" readonly=readonly  type="text" id="moveClass" name="moveClass" value = "541"/>
    	</li>
 		<li class="li" style="margin: 20px 0px 0px -15px;">
 			<input type="button" onclick="submit1(this);"  style="width:60px;height:25px;" class="button" value="发货过账" />
 			<input type="button" onclick="forward();"  style="width:40px;height:25px;" class="button" value="返回" />
 			<input type="button"  style="width:40px;height:25px;" onclick="window.location.href='MainServlet?flag=return';" value="首页">
 		</li>
 	</ul>
    </form>
   </div>
 </body>

</html>
 