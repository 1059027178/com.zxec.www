<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

Date date = new Date();
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
String strDate = dateFormat.format(date);

String type = request.getSession().getAttribute("type") == null ? "" : request.getSession().getAttribute("type").toString();
%>
<html>
<script src="./js/jquery.js"></script>  
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>   
<script language="javascript" src="./js/jiuhui.js"></script>
<script type="text/javascript">
	function stoQuy(){
		document.jiuhui.submit();
	}
	function query(line){
		//alert(line);return;
		var valueTd =document.getElementById ("box").rows [line].cells[1];
		//领料单号
		var bills = valueTd.getElementsByTagName("a")[0].innerHTML;
		//alert(bills);return;
		document.getElementById("bills").value = bills;
		
		document.jiuhui.submit();
	}
	function choose1(){
  		var bs=$("#tr1").attr("checked");
  		if(bs=="checked"){
  			$("#tr1").css("background-color", "white"); 
  			
  			//$("#boxs").css("background-color", "#D8D8D8"); 
  		}else{
  			$("#tr1").css("background-color", "#D8D8D8"); 
  		}
  	}
</script>
<style>
	a:link{
		text-decoration:none;
	}
	body{
		margin-left:-15px;
	}
</style>
  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <title><%=request.getSession().getAttribute("type")%></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
  </head>
  <body>
  <form name="jiuhui"  id="jiuhui" method="post" action="MainServlet?flag=shengchanB">
  	<input name="bills"  type="hidden" id="bills"/>
  	<%  
  	   String[] bills = null;
  	   int size = 0;
  	   if(type.equals("生产领料单")){
  	   		size = 6;
  	   		bills = new String[size];
  	   		for(int i = 0 ; i < size ; i++){
  	   			bills[i] = "0000000"+ (130 + i);
  	   		}
  	   }else{
  	   		size = 4;
  	   		bills = new String[size];
  	   		for(int i = 0 ; i < size ; i++){
  	   			bills[i] = "0000000" + (380 + i);
  	   		}
  	   }
  	%>
    <div style=" padding-top: 50px;">
	    <ul>
	   	 	<li class="li" >
	   	 		<table class="table_list"  id = "box">
	   	 		<tr>
	   	 			<td align="center">序号</td>
	   	 			<td align="center"><%=type%></td>
	   	 		</tr>
	   	 		<%for(int s = 0 ; s < size ; s++ ){ %>
	   	 			<tr style="line-height: 20px;" >
	   	 				<td align="center" ><%=s + 1 %></td>
	   	 				<td align="center"><a href="javascript:query(<%=s + 1%>);"><%=bills[s] %></a></td>
	   	 			</tr>
	   	 		<%} %>
	   	 		</table>
			</li>
			<li class="li">
	    		<!-- <input  class="button"  type="button"  style="width:25%"  onclick="stoQuy()" value="确定" /> -->
	    		<input  class="button"  type="button"  style="width:25%;margin-left:-12px;"  onclick="window.location.href='MainServlet?flag=2.1';" value="返回" />
	    		<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="首页" />
	    	</li>
	    </ul>
    </div>
    </form>
  </body>
</html>
