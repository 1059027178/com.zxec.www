<%@ page language="java" contentType="text/html; charset=GBK" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
  <head>
  <LINK href="/css/jiuhui.css" type=text/css rel=STYLESHEET>
    <title>�¼�</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi" />
<script language="javascript" src="/js/jiuhui.js"></script>
<script src="/js/jquery.js"></script>  
<script type="text/javascript">

	function submit1(obj) {
		obj.disabled = false;
		document.jiuhui.submit();
	}

	//PO/����Ŀ/��Ӧ��/���ϱ���/ÿ������/��λ/���ص�/���κ�/������ʶ/����/��Ӧ����������/��Ӧ�����κ�/������
	function js() {
		var lonstr = $("#str").val();
		var str = lonstr.split("/");
		//alert(str.length);
		if (str.length > 0) {
			//var aufnr=str[0];//�ɹ�����
			//var hang=str[1];//����Ŀ
			var matnr = str[3];//���ϱ���
			//var meng = str[4];//ÿ������
			var meins = str[5];//��λ
			var lgort = str[6];//���ص�
			var charg = str[7];//���κ�
			//var sobkz = str[12];//������

			$("#matnr").attr("value", matnr);
			//$("#meng").attr("value", meng);
			$("#charg").attr("value", charg);
			$("#meins").attr("value", meins);
			$("#lgort").attr("value", lgort);
			//$("#sobkz").attr("value", sobkz);
		}
	}

	function keyDown() {
		var keycode = event.keyCode;
		var realkey = String.fromCharCode(event.keyCode);
		// alert("������: " + keycode + " �ַ�: " + realkey);
		if (keycode == '13') {
			js();
		}
	}
	document.onkeydown = keyDown;
</script>
  </head>
  <body>
    <form name="jiuhui"  id="jiuhui" action="/deliveryView.do">
    	<input type="hidden" id="lgort" name = "lgort"/><!-- ���ص� -->
    	<input type="hidden" id="meins" name = "meins"/><!-- ��λ -->
    	<input type="hidden" id="werks" name = "werks" value="3100"/><!-- ���� -->
    	<div style="margin-top:60px;">
    		<ul>
	    		<!-- <li class="li">�������ţ�<input type="text" class="text3" id="vbeln" name="vbeln"  value=""/></li> -->
	    		<li style="height:15px;list-style-type:none;">
	    			<input name="str" type="text" style="width:70%;height:20px;"  id="str" onchange="js()"/>
	    		</li>
	  			<li class="li">
	    			���ϱ�ţ�<input type="text" class="text3" id="matnr" name="matnr" readonly=readonly value="" style="background-color:#D8D8D8;"/>
	    		</li>
	    		<li class="li">
	    			��&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;�Σ�<input type="text" readonly=readonly class="text3" style="background-color:#D8D8D8;" id="charg" name="charg" />
	    		</li>
	    		<li class="li">
	    			��&nbsp;&nbsp; ��ţ�<input name="lgortNO" type="text" class="text1" id="lgortNO"  value="311" />
	    		</li>
	  			<li class="li">
	    			<input class="button" type="button" onclick="submit1(this);" value="ȷ��">
	    			<input class="button" type="button" onclick="window.location.href='/main.do?two=3';" value="����">
	    			<input  type="button" onclick="window.location.href='/main.do';" value="��ҳ">
	    		</li>
			</ul>
		</div>
    </form>
  </body>
   <script type="text/javascript">
  document.getElementById("str").focus();
  </script>
</html>
