package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class reversal_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>生产订单冲销</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("\t\t<script src=\"/js/jquery.js\"></script>  \r\n");
      out.write("\t<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("\t<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js\" type=\"text/javascript\"></script>    \r\n");
      out.write("\t<link href=\"/css/jiuhui.css\" rel=\"stylesheet\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("  \tfunction choose1(){\r\n");
      out.write("  \t\tvar bs=$(\"#bs\").attr(\"checked\");\r\n");
      out.write("  \t\t//alert(bs);\r\n");
      out.write("  \t\tif(bs==\"checked\"){\r\n");
      out.write("  \t\t\t$(\"#wemng\").css(\"background-color\", \"white\"); \r\n");
      out.write("  \t\t\t$(\"#wemng\").removeAttr(\"readonly\"); //\r\n");
      out.write("  \t\t\t//alert($(\"input[id='bs']\").val());\r\n");
      out.write("  \t\t\t$(\"#boxs\").css(\"background-color\", \"#D8D8D8\"); \r\n");
      out.write("  \t\t\t$(\"#boxs\").attr(\"readonly\", \"readonly\"); //removeAttr\r\n");
      out.write("  \t\t\t$(\"#boxs\").attr(\"value\",'');\r\n");
      out.write("  \t\t\t$(\"#wemng\").attr(\"value\",'');\r\n");
      out.write("  \t\t}else{\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t\t\t$(\"#boxs\").css(\"background-color\", \"white\"); \r\n");
      out.write("  \t\t\t$(\"#boxs\").removeAttr(\"readonly\"); //\r\n");
      out.write("  \t\t\t$(\"#wemng\").attr(\"value\",'');\r\n");
      out.write("  \t\t\t$(\"#wemng\").css(\"background-color\", \"#D8D8D8\"); \r\n");
      out.write("  \t\t\t$(\"#wemng\").attr(\"readonly\", \"readonly\"); //removeAttr\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction acount(){\r\n");
      out.write("  \t\tvar meng=$(\"#meng\").val();\r\n");
      out.write("  \t\tvar boxs=$(\"#boxs\").val();\r\n");
      out.write("  \t\tif(meng==\"\")meng=0;\r\n");
      out.write("  \t\t//alert(parseFloat(meng)*parseFloat(boxs));\r\n");
      out.write("  \t\tif(boxs=='' || boxs==null)return;\r\n");
      out.write("  \t\tif(meng=='' || meng==null)return;\r\n");
      out.write("  \t\t$(\"#wemng\").attr(\"value\",parseFloat(meng)*parseFloat(boxs));\r\n");
      out.write("  \t}\r\n");
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
      out.write("\t  \t\t$(\"#meng\").attr(\"value\",meng);\r\n");
      out.write("\t  \t\t//$(\"#wemng\").attr(\"value\",wemng);\r\n");
      out.write("\t  \t\t$(\"#charg\").attr(\"value\",charg);\r\n");
      out.write("\t  \t\t$(\"#meins\").attr(\"value\",meins);\r\n");
      out.write("\t  \t\t$(\"#sobkz\").attr(\"value\",sobkz);\r\n");
      out.write("\t  \t\t$(\"#lgort\").attr(\"value\",lgort);\r\n");
      out.write("\t  \t\t\r\n");
      out.write("\t  \t\tif(bs=='X'){\r\n");
      out.write("\t  \t\t\t$(\"#bs\").attr(\"checked\",\"checked\");\r\n");
      out.write("\t  \t\t\t\r\n");
      out.write("\t  \t\t}else{\r\n");
      out.write("\t  \t\t\t$(\"#bs\").removeAttr(\"checked\");//\r\n");
      out.write("\t  \t\t}\r\n");
      out.write("\t  \t\tchoose1();\r\n");
      out.write("\t  \t\tgetMaktx(matnr);\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction getMaktx(matnr){\r\n");
      out.write("  \t\tif(matnr=='' || matnr==null)return;\r\n");
      out.write("\t\tjQuery.ajax({\r\n");
      out.write("\t\t\turl:'/receiptJson.do',\r\n");
      out.write("\t \t\tasync:false,\r\n");
      out.write("\t \t\ttype:\"post\",\r\n");
      out.write("\t \t\tdata:{\"showType\":\"getMaktx\",\"matnr\":matnr},\r\n");
      out.write("\t \t\tdataType:'json',\r\n");
      out.write("\t \t\tsuccess:function(data){\r\n");
      out.write("\t \t\t\t$(\"#maktx\").attr(\"value\",data.maktx);\r\n");
      out.write("\t \t\t},\r\n");
      out.write("\t        error:function(){       \r\n");
      out.write("\t\t       alert(\"系统异常，请联系管理员\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
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
      out.write("  \twindow.location.href=\"/main.do?two=1\";\r\n");
      out.write("  }\r\n");
      out.write("  function submit1(obj){\r\n");
      out.write("  \tobj.disabled=false;\r\n");
      out.write("  \tdocument.form.submit();\r\n");
      out.write("  }\r\n");
      out.write("  function reset(){\r\n");
      out.write("  \t$('.input').val(\"\");\r\n");
      out.write("  }\r\n");
      out.write("  </script>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <form name=form action=\"/reversalCrt.do\">\r\n");
      out.write("  <input type=\"hidden\" name=\"sonum\" id=\"sonum\" >\r\n");
      out.write("  \t<div>\r\n");
      out.write("  \t\t<ul>\r\n");
      out.write("  \t\t\t<li style=\"height:15px;list-style-type:none;\"><input name=\"str\" type=\"text\" style=\"width:70%;height:20px;\"  id=\"str\" onchange=\"js()\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">生产订单：<input name=\"aufnr\" size=\"5\" readonly=readonly class=\"text\"  type=\"text\"  id=\"aufnr\" > </input></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">物料编码：<input name=\"matnr\" class=\"text\"  readonly=readonly type=\"text\" id=\"matnr\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">物料描述：<input name=\"maktx\" class=\"text\"  readonly=readonly type=\"text\" id=\"maktx\"></li></br>\r\n");
      out.write("  \t\t\t<li class=\"li\">尾箱标识：<input type=\"checkbox\" onclick=\"choose1();\" id=\"bs\" style=\"width:20px;height:20px;\" name=\"bs\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">箱数量/箱数：<input name=\"meng\" readonly=readonly style=\"width:30px;background-color:#D8D8D8;height:20px;\"  type=\"text\"  id=\"meng\">/<input name=\"boxs\" style=\"width:30px;height:20px;\" type=\"text\"  id=\"boxs\" onblur=\"acount();\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">批&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;次：<input name=\"charg\" readonly=readonly style=\"width:80px;background-color:#D8D8D8;height:20px;\"  type=\"text\"  id=\"charg\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">总数&nbsp;&nbsp; &nbsp;量：<input name=\"wemng\" type=\"text\" class=\"text1\" id=\"wemng\" ><input name=\"meins\" class=\"text2\" readonly=readonly type=\"text\"  id=\"meins\"> </input></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">库存地点：<input name=\"lgort\" class=\"text3\" type=\"text\" id=\"lgort\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">特殊库存：<input name=\"sobkz\" readonly=readonly type=\"text\" class=\"text\"  id=\"sobkz\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\"><input type=\"button\" valign=\"center\" class=\"button\" onclick=\"submit1(this);\" style=\"width:40px;height:25px;\" value=\"确定\"/>\r\n");
      out.write("  \t\t\t<input  class=\"button\"  type=\"button\" onclick=\"forward();\" style=\"width:30px;height:25px;\" value=\"返回\"/>\r\n");
      out.write("  \t\t\t<input  class=\"button\" type=\"button\" onclick=\"reset();\" style=\"width:30px;height:25px;\" value=\"重置\"/>\r\n");
      out.write("  \t\t\t<input type=\"button\" class=\"button\" style=\"width:40px;height:25px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\"></li>\r\n");
      out.write("  \t\t</ul>\r\n");
      out.write("  \t</div>\r\n");
      out.write("     \r\n");
      out.write("</form>\r\n");
      out.write("  </body>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
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
