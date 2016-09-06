<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%@ page import="com.sap.mw.jco.JCO" %>
<%@ page import="com.sap.mw.jco.IFunctionTemplate" %>
<jsp:useBean id="LiangxinUtil" class="com.thinkway.LiangxinUtil" scope="page" />

<%

		String aufnr = LiangxinUtil.null2String(request.getParameter("aufnr"));
		String iquan = LiangxinUtil.null2String(request.getParameter("iquan"));
		String gmein = LiangxinUtil.null2String(request.getParameter("gmein"));
		String message="";	
		//out.println(aufnr+"/"+iquan+"/"+gmein);
		JCO.Client myConnection =null;
		myConnection =LiangxinUtil.getSAPcon();
	    myConnection.connect(); 
	    //out.println("连接SAP成功");
		String functionName="Z_OI_MM_MATDOCUMENT_CRT";//函数的名字
	    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
	    //從這個函數範本獲得該SAP函數的物件
	    JCO.Function bapi = ft.getFunction();
    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
		JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
		
		JCO.Table  IT_ITEM=inputtable.getTable("IT_ITEM");
		if(!aufnr.isEmpty()&&!iquan.isEmpty()&&!gmein.isEmpty()){
			IT_ITEM.appendRow();		
						
								
			IT_ITEM.setValue(aufnr,"AUFNR");
			IT_ITEM.setValue(iquan,"IQUAN");
			IT_ITEM.setValue(gmein,"GMEIN");
			
			myConnection.execute(bapi);
			
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			String E_TYPE=(outs.getValue("E_TYPE")+"").replace("", "").replace("'", "");
				
			message+="   "+(outs.getValue("E_MESSAGE")+"").replace("", "").replace("'", "");
		}else{
			message="必要信息不完整";
		}
 %>
<html>

  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    <script language="javascript" src="/js/jiuhui.js"></script>
    <title>物料凭证创建</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	<table >
    	<%out.println("<tr><td>"+message+"</td></tr>");%>
    		<tr>
    			<td>
    				<button class=button  onclick="goback();">返回</button>
    			</td>
    		</tr>
    	</table>
  </body>
</html>
 