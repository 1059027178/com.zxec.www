<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.thinkway.SapUtil" %>
<%@ page import="com.thinkway.cms.business.domains.DelOrdPic" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    
    <title>仓位冻结/解冻</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
	<script src="/js/jquery.js"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>  
	<script src="/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>    

	<link href="/css/jiuhui_list.css" rel="stylesheet">
	
  </head>
  <script type="text/javascript">
    function forward(){
  		window.location.href="/repertoryAdd.do";
  	}
  
  </script>
  <body>
<div class="div" style="margin-top:60px;" align="center">
  <form action="/repertoryEdit.do">
  	<input name="radio" type="hidden" value="${radio}"/>
	<input name="lgnum" type="hidden" value="${lgnum}"/>
	<input name="lgtyp" type="hidden" value="${lgtyp}"/>
	<input name="nlpla" type="hidden" value="${nlpla}"/>
     <table class="talbe_list" style="width:100%;">
     <tr style="tr_list_1">
     	<th class="td_list" align="center">仓库号</th>
     	<th class="td_list" align="center">存储类型</th>
     	<th class="td_list" align="center">仓位</th>
	</tr>
	<tr style="tr_list_2">
     	<td class="td_list" align="center">${lgnum}</td>
     	<td class="td_list" align="center">${lgtyp}</td>
     	<td class="td_list" align="center">${nlpla}</td>
	</tr>
	
<td  colspan=3 align="center">
<span style="margin-left:-50px;"></span>
<input class="button" type="submit"  style="width:40px;" value="确定">
<input class="button" type="button" onclick="forward()" style="width:40px;" value="返回">
<input   type="button" class="button" style="width:40px;" onclick="window.location.href='/main.do';" value="首页">
</td>
</tr>
</table>
</form>
</div>
  </body>
</html>
