<%@page import="com.exampleCode.model.PositionsInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List list = (List)request.getAttribute("resultList"); 
%>
<html>
<script src="./js/jquery.js"></script>  
<!-- <script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js" type="text/javascript"></script>   -->
<script src="./js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js" type="text/javascript"></script>   
<script language="javascript" src="./js/jiuhui.js"></script>
<script src="./jquery.pagination_2/demo/lib/jquery.min.js"></script>
<script src="./jquery.pagination_2/jquery.pagination.js"></script>
<link href="./jquery.pagination_2/pagination.css" rel="stylesheet"/>
<script type="text/javascript">
function stoQuy(){
	var num=$("#num").val();
	if(num == ""||num == "0"){
		alert("����д�¼�����");return;
	}
	document.jiuhui.submit();
}
function control(obj,line){//obj.value:�����ֵ��lineΪ�к�
	//alert(obj.value);
	//alert(line);
	var valueTd =document.getElementById ("box").rows [line].cells[3];
	//��λ�������
	var maxnum = parseFloat(valueTd.innerHTML);
	//���������
	var inputnum =	parseFloat(obj.value);
	//������������
  	if(inputnum > maxnum){
  		obj.value = "";
  		alert("�����˿��ֵ");return;
  	}
  	//��Ӧ���������ڿ���
  	if(line > 1){//��Ų�λ��������1
  		//��һ�е�����ֵ
		var UPinputnum = parseFloat((document.getElementById ("box").rows [line-1].cells[4]).getElementsByTagName("INPUT")[0].value);
		//console.log(line);
		//console.log("��һ�е�����ֵ="+UPinputnum);
		//��һ�е����ֵ
		var UPmaxnum = parseFloat((document.getElementById ("box").rows [line-1].cells[3]).innerHTML);
		//console.log("��һ�е����ֵ="+UPmaxnum);
  		if(UPmaxnum != UPinputnum && inputnum != 0){
			obj.value = "";
			alert("��һ��λδ���꣡");
			return;
		}else{
			document.getElementById("num").value = parseFloat(document.getElementById("num").value) + inputnum + "";
		}
  	}else{
  		if(inputnum+"" == "NaN"){
  			$("#num").attr("value","");
  		}else{
			$("#num").attr("value",inputnum);
  		}
	}
}
</script>
<!----------------��ҳ----------------->
<script type="text/javascript">
$(function(){
	//����Ŀ
	var length = <%=list.size()%>;
	//���÷�ҳԪ�ز���
	var optInit = getOptionsFromForm();
	$("#Pagination").pagination(length, optInit);
	
	//-----------------------------------
	function getOptionsFromForm(){
		var opt = {callback: pageselectCallback}; //�ص�������Ĭ����ִ��Ч��
		opt.items_per_page = 4;		//ÿҳ��ʾ����Ŀ��(��ѡ������Ĭ����10)
		opt.num_display_entries = 0;//������ҳ���岿����ʾ�ķ�ҳ��Ŀ��(��ѡ������Ĭ����10)
		opt.num_edge_entries = 0;	//������ʾ����β��ҳ����Ŀ��(��ѡ������Ĭ����0)
		opt.prev_text = "��һҳ";	//��ǰһҳ����ҳ��ť����ʾ������(�ַ�����������ѡ��Ĭ����"Prev")
		opt.next_text = "��һҳ";	//����һҳ����ҳ��ť����ʾ������(�ַ�����������ѡ��Ĭ����"Next")
		return opt;
	}
	//-------------------------------
	function pageselectCallback(page_index , jq){
	
		var items_per_page = 4;//ÿҳ����ʾ���б�����Ŀ
		
		var max_elem = Math.min((page_index+1) * items_per_page, length);
		
		$(".tbody").hide();
		// ��ȡ����Ԫ��
		for(var i=page_index*items_per_page;i<max_elem;i++){
		
			$(".tbody:eq("+i+")").show();
		}
		//��ֹ�����¼�
		return false;	
	}
});
</script>
  <head>
  <LINK href="./css/jiuhui.css" type=text/css rel=STYLESHEET>
    <title><%=request.getSession().getAttribute("type")%></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
  </head>
  <body>
  <form name="jiuhui"  id="jiuhui" method="post" action="MainServlet?flag=xiajiaSave">
    <%if(list.size() < 1 || list == null){ %>
  		<div style="margin-left: 20px;margin-top:70px;">�ֿ��������ݣ�
    	<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=2';" value="����">
  		</div>
  		<%}else{ %>	
    	<div style="margin-left: -20px;">
    	<%	PositionsInfo info1 = (PositionsInfo)list.get(0);
    		String matnr = info1.getItemNO();//���ϱ���
    		String maktx = info1.getItemDescription();//��������
    	%>
    	<ul>
    		<li class="li">
    			���ϱ��룺<input name="matnr" style="width:60%;heigth:70%;" class="text"  readonly=readonly type="text" id="matnr" value = "<%=matnr%>" />
    		</li>
    		<li class="li">
    			����������<input name="maktx" readonly=readonly style="width:60%;heigth:70%;background-color:#D8D8D8;"  type="text"  id="maktx" value = "<%=maktx%>"/>
    		</li>
    		<li class="li">
    			�����ϼƣ�<input style="width:45%;heigth:70%;background-color:#D8D8D8;" type="text" id="num" name="num" />
    		</li>
    		<li class="li">
    			<table class="table_list" id="box">
    				<tr>
    					<td align="center">���</td>
    					<td align="center">��λ</td>
    					<td align="center">����</td>
    					<td align="center">��λ����</td>
    					<td align="center">ѡ������</td>
    				</tr>
    				<%for(int i = 0 ; i < list.size() ; i++){ 
    					PositionsInfo info = (PositionsInfo) list.get(i);
    				%>
    				<tbody class="tbody" style="display: none;">
    				<tr>
    					<td align="center" ><%=i+1 %></td>
    					<td align="center" ><%=info.getLiteraNO() %></td>
    					<td align="center" ><%=info.getBatchNO()%></td>
    					<td align="center" ><%=info.getNumber() %></td>
    					<td align="center" ><input style="width:35px;heigth:70%;" id="num1" type="text" onchange="control(this,<%=i+1%>);" /></td>
    				</tr>
    				</tbody>
    				<%}%>
    			</table>
    		</li>
     		<li class="li">
     			<%if(list.size() <= 4){ %>
     				<div id="Pagination"  class="pagination" style="line-height: 9px;font-size:12px;margin-left:5px;margin-bottom: -7px;display: none;"><!-- ������ʾ��ҳ --></div>
    				<%}else{ %>
    				<div id="Pagination"  class="pagination" style="line-height: 9px;font-size:12px;margin-left:5px;margin-bottom: -10px;"><!-- ������ʾ��ҳ --></div>
    			<%} %>
    				<input  class="button"  type="button"  style="width:25%;margin:0px 0px 0px -25px;"  onclick="stoQuy()" value="ȷ��">
    				<input  class="button"  type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=2';" value="����">
    				<input  class="button" 	type="button"  style="width:25%"  onclick="window.location.href='MainServlet?flag=return';" value="��ҳ">
    		</li>
    	</ul>
    	</div>
    <%} %>
    </form>
  </body>
 <script type="text/javascript">
  document.getElementById("num1").focus();
  </script>
</html>
