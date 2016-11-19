package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class dump_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>库存转储</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("\t<script src=\"/js/jquery.js\"></script>  \r\n");
      out.write("\t<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("\t<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js\" type=\"text/javascript\"></script>    \r\n");
      out.write("\t<link href=\"/css/jiuhui.css\" rel=\"stylesheet\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("  \tfunction js(){\r\n");
      out.write("  \t\tvar lonstr=$(\"#str\").val();\r\n");
      out.write("  \t\tvar str=lonstr.split(\"/\");\r\n");
      out.write("  \t\t//alert(str.length);\r\n");
      out.write("  \t\tif(str.length>0){\r\n");
      out.write("\t  \t\tvar aufnr=str[0];\r\n");
      out.write("\t  \t\tvar matnr=str[1];\r\n");
      out.write("\t  \t\tvar bs=str[2];\r\n");
      out.write("\t  \t\tvar meng=str[3];\r\n");
      out.write("\t  \t\tvar charg=str[4];\r\n");
      out.write("\t  \t\tvar sobkz=str[5];\r\n");
      out.write("\t  \t\tvar sonum=str[6];\r\n");
      out.write("\t  \t\tvar lgort=str[7];\r\n");
      out.write("\t  \t\tvar meins=str[8];\r\n");
      out.write("\t  \t\t$(\"#aufnr\").attr(\"value\",aufnr);\r\n");
      out.write("\t  \t\t$(\"#matnr\").attr(\"value\",matnr);\r\n");
      out.write("\t  \t\t$(\"#sonum\").attr(\"value\",sonum);\r\n");
      out.write("\t  \t\t//$(\"#meng\").attr(\"value\",meng);\r\n");
      out.write("\t  \t\t//$(\"#wemng\").attr(\"value\",wemng);\r\n");
      out.write("\t  \t\t$(\"#charg\").attr(\"value\",charg);\r\n");
      out.write("\t  \t\t$(\"#meins\").attr(\"value\",meins);\r\n");
      out.write("\t  \t\t$(\"#sobkz\").attr(\"value\",sobkz);\r\n");
      out.write("\t  \t\t$(\"#lgort\").attr(\"value\",lgort);\r\n");
      out.write("\t  \t\t\r\n");
      out.write("\t  \t\r\n");
      out.write("\t  \t\t//choose1();\r\n");
      out.write("\t  \t\tgetPlnum(matnr);\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction getPlnum(matnr){\r\n");
      out.write("  \t\tif(matnr=='' || matnr==null)return;\r\n");
      out.write("\t\tjQuery.ajax({\r\n");
      out.write("\t\t\turl:'/receiptJson.do',\r\n");
      out.write("\t \t\tasync:false,\r\n");
      out.write("\t \t\ttype:\"post\",\r\n");
      out.write("\t \t\tdata:{\"showType\":\"getPlnum\",\"matnr\":matnr},\r\n");
      out.write("\t \t\tdataType:'json',\r\n");
      out.write("\t \t\tsuccess:function(data){\r\n");
      out.write("\t \t\t\t$(\"#lgnum\").attr(\"value\",data.lgnum);\r\n");
      out.write("\t \t\t\t$(\"#maktx\").attr(\"value\",data.maktx);\r\n");
      out.write("\t \t\t\t$(\"#werks\").attr(\"value\",data.werks);\r\n");
      out.write("\t \t\t},\r\n");
      out.write("\t        error:function(){       \r\n");
      out.write("\t\t       alert(\"系统异常，请联系管理员\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("  \tfunction keyDown() {\r\n");
      out.write("       var keycode = event.keyCode;\r\n");
      out.write("       var realkey = String.fromCharCode(event.keyCode);\r\n");
      out.write("      // alert(\"按键码: \" + keycode + \" 字符: \" + realkey);\r\n");
      out.write("       if(keycode=='13'){\r\n");
      out.write("       \t\tjs();\r\n");
      out.write("       }\r\n");
      out.write("   }\r\n");
      out.write("   document.onkeydown = keyDown;\r\n");
      out.write("\r\n");
      out.write("  function forward(){\r\n");
      out.write("  \twindow.location.href=\"/main.do?two=4\";\r\n");
      out.write("  }\r\n");
      out.write("  function submit1(obj){\r\n");
      out.write("  \tobj.disabled=false;\r\n");
      out.write("  \tvar chk;\r\n");
      out.write("  \tvar chkObjs = document.getElementsByName(\"radio\");\r\n");
      out.write("    for(var i=0;i<chkObjs.length;i++){\r\n");
      out.write("          if(chkObjs[i].checked){\r\n");
      out.write("                 chk = i;\r\n");
      out.write("                 break;\r\n");
      out.write("           }\r\n");
      out.write("   }\r\n");
      out.write("   var lonstr=$(\"#str\").val();\r\n");
      out.write("   if(lonstr==null || lonstr==''){\r\n");
      out.write("   \t\talert(\"请扫描物料卡！\");\r\n");
      out.write("   \t\treturn;\r\n");
      out.write("   }\r\n");
      out.write("   var charg=$(\"#charg\").val();\r\n");
      out.write("   if(charg==null || charg==''){\r\n");
      out.write("   \t\talert(\"请输入批次！\");\r\n");
      out.write("   \t\treturn;\r\n");
      out.write("   }\r\n");
      out.write("   var matnr=$(\"#matnr\").val();\r\n");
      out.write("   if(matnr==null || matnr==''){\r\n");
      out.write("   \t\talert(\"请输入物料编码！\");\r\n");
      out.write("   \t\treturn;\r\n");
      out.write("   }\r\n");
      out.write("   if(chk=='2'){\r\n");
      out.write("   \t\tvar lgpla=document.getElementById(\"lgpla\").value;\r\n");
      out.write("   \t\tif(lgpla.length==0){\r\n");
      out.write("   \t\t\talert(\"仓位未填写，请填写\");\r\n");
      out.write("   \t\t\treturn;\r\n");
      out.write("   \t\t}\r\n");
      out.write("   }\r\n");
      out.write("  \tdocument.form.submit();\r\n");
      out.write("  }\r\n");
      out.write("  function reset(){\r\n");
      out.write("  \t$('.input').val(\"\");\r\n");
      out.write("  }\r\n");
      out.write(" function chooseRadio3(){\r\n");
      out.write(" \tvar radio3=$('input[name=\"radio\"]:checked').val();\r\n");
      out.write(" \tif(radio3==3){\r\n");
      out.write(" \t\t$('input[id=\"lgpla\"]').attr('value',\"Z-00\");\r\n");
      out.write(" \t}else{\r\n");
      out.write(" \t\t$('input[id=\"lgpla\"]').attr('value',\"\");\r\n");
      out.write(" \t}\r\n");
      out.write("  }\r\n");
      out.write("  </script>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <form name=form action=\"/dumpCheck.do\">\r\n");
      out.write("  <input type=\"hidden\" name=\"lgort\" id=\"lgort\" >\r\n");
      out.write("  <input type=\"hidden\" name=\"maktx\" id=\"maktx\" >\r\n");
      out.write("  <input type=\"hidden\" name=\"werks\" id=\"werks\" >\r\n");
      out.write("  <input type=\"hidden\" name=\"meins\" id=\"meins\" >\r\n");
      out.write("  \t<div style=\"padding-top:50px;\">\r\n");
      out.write("  \t\t<ul>\r\n");
      out.write("  \t\t\t<li style=\"height:15px;list-style-type:none;\"><input name=\"str\" class=\"text3\" type=\"text\" style=\"white-space：nowrap;width:150px;\"  id=\"str\" onchange=\"js()\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">物料编码：<input name=\"matnr\" class=\"text\"  readonly=readonly type=\"text\" id=\"matnr\"></li>\r\n");
      out.write("\t\t\t<li class=\"li\">批&nbsp;&nbsp;&nbsp;&nbsp;次：<input name=\"charg\" readonly=readonly class=\"text\"  type=\"text\"  id=\"charg\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">特殊库存：<input name=\"sobkz\" style=\"width:20px;\" type=\"text\" style=\"width:17%\" id=\"sobkz\" class=\"text\"><input name=\"sonum\" readonly=readonly style=\"width:42%;\" type=\"text\" class=\"text\"  id=\"sonum\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">仓库&nbsp;&nbsp;号：<input name=\"lgnum\" readonly=readonly class=\"text3\"  type=\"text\"  id=\"lgnum\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">仓&nbsp;&nbsp;位号：<input name=\"lgpla\" class=\"text3\"  type=\"text\"  id=\"lgpla\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\"><input name=\"radio\" style=\"width:20px;\" onclick=\"chooseRadio3();\" checked=checked type=\"radio\" id=\"radio1\" value=\"1\">下架转储出库</input></li>\r\n");
      out.write("     \t<li class=\"li\"><input name=\"radio\" style=\"width:20px;\" type=\"radio\" onclick=\"chooseRadio3();\" id=\"radio2\" value=\"2\" >直接转储出入库</input></li>\r\n");
      out.write("     \t<li class=\"li\"><input name=\"radio\" style=\"width:20px;\" type=\"radio\" onclick=\"chooseRadio3();\" id=\"radio3\" value=\"3\" >质检过账</input></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">\r\n");
      out.write("  \t\t\t<input type=\"button\" valign=\"center\" style=\"width:40px;height:25px;\" class=\"button\" onclick=\"submit1(this);\" value=\"确定\"/>\r\n");
      out.write("  \t\t\t<input  class=\"button\"  type=\"button\" style=\"width:30px;height:25px;\" onclick=\"forward();\" value=\"返回\"/>\r\n");
      out.write("  \t\t\t<input  class=\"button\" type=\"button\" style=\"width:30px;height:25px;\" onclick=\"reset();\" value=\"重置\"/>\r\n");
      out.write("  \t\t\t<input type=\"button\" class=\"button\" style=\"width:40px;height:25px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\"></li>\r\n");
      out.write("  \t\t\t\r\n");
      out.write("  \t\t</ul>\r\n");
      out.write("  \t</div>\r\n");
      out.write("     \r\n");
      out.write("</form>\r\n");
      out.write("  </body>\r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write("  document.getElementById(\"str\").focus();\r\n");
      out.write("  </script>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
