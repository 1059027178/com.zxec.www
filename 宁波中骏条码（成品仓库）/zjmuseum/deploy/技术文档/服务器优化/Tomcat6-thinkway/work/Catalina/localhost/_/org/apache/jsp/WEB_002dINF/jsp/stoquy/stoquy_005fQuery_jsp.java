package org.apache.jsp.WEB_002dINF.jsp.stoquy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class stoquy_005fQuery_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=GBK");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write(' ');
      out.write('\r');
      out.write('\n');

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<script src=\"/js/jquery.js\"></script>  \r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js\" type=\"text/javascript\"></script>   \r\n");
      out.write("<script language=\"javascript\" src=\"/js/jiuhui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction js(){\r\n");
      out.write("  \t\tvar lonstr=$(\"#saomiao\").val();\r\n");
      out.write("  \t\tvar str=lonstr.split(\"/\");\r\n");
      out.write("  \t\t//alert(str.length);\r\n");
      out.write("  \t\tif(str.length>0){\r\n");
      out.write("\t  \t\tvar matnr=str[1];\r\n");
      out.write("\t  \t\t$(\"#matnr\").attr(\"value\",matnr);\r\n");
      out.write("  \t\t}\r\n");
      out.write("  \t}\r\n");
      out.write("function stoQuy(){\r\n");
      out.write("  var werks=document.getElementById(\"werks\").value;\r\n");
      out.write("  \tif(werks==0){\r\n");
      out.write("  \t\talert(\"工厂为空，无法查询\");\r\n");
      out.write("  \t\treturn;\r\n");
      out.write("  \t}\t \r\n");
      out.write("  \tvar lgort=document.getElementById(\"lgort\").value;\r\n");
      out.write("  \tif(lgort==0){\r\n");
      out.write("  \t\talert(\"库存地点为空，无法查询\");\r\n");
      out.write("  \t\treturn;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tif(jQuery(\"#pici\").attr(\"checked\")==\"checked\"){\r\n");
      out.write("  \t\tdocument.getElementById(\"pici\").value='pici';\r\n");
      out.write("\t}\r\n");
      out.write("\tdocument.jiuhui.submit();\r\n");
      out.write("}\r\n");
      out.write("  \tfunction keyDown() {\r\n");
      out.write("       var keycode = event.keyCode;\r\n");
      out.write("       var realkey = String.fromCharCode(event.keyCode);\r\n");
      out.write("      // alert(\"按键码: \" + keycode + \" 字符: \" + realkey);\r\n");
      out.write("       if(keycode=='13'){\r\n");
      out.write("       \t\tjs();\r\n");
      out.write("       }\r\n");
      out.write("   }\r\n");
      out.write("   document.onkeydown = keyDown;\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("  <head>\r\n");
      out.write("  <LINK href=\"/css/jiuhui.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("    \r\n");
      out.write("    <title>库存查询</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("\t\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <form name=\"jiuhui\"  id=\"jiuhui\" method=\"post\" action=\"/stoquyList.do\">\r\n");
      out.write("    \t<div style=\" padding-top: 50px;\">\r\n");
      out.write("    \t<ul>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t工 &nbsp;&nbsp; 厂: <input style=\"width:50%;heigth=70%\" type=\"text\" id=\"werks\" name=\"werks\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t库存地点：<input style=\"width:50%;heigth=70%\" type=\"text\" id=\"lgort\" name=\"lgort\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t<input style=\"width:85%;heigth=70%\" type=\"text\" id=\"saomiao\" name=\"saomiao\"  value=\"\" onchange=\"js()\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t物料编码：<input style=\"width:50%;heigth=70%\" type=\"text\" id=\"matnr\" name=\"matnr\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t批  &nbsp;&nbsp; 次：<input style=\"width:50%;heigth=70%\" type=\"text\" id=\"charg\" name=\"charg\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t<input type=\"checkbox\" value=\"\" id=\"pici\" name=\"pici\"/>按批查询\r\n");
      out.write("     \t\t</li>\r\n");
      out.write("     \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t\t<input  class=\"button\"  type=\"button\"  style=\"width:25%\"  onclick=\"stoQuy()\" value=\"查询\">\r\n");
      out.write("    \t\t\t\t<input  class=\"button\"  type=\"button\"  style=\"width:25%\"  onclick=\"window.location.href='/main.do?two=5';\" value=\"返回\">\r\n");
      out.write("    \t\t\t\t<input  class=button type=\"button\" style=\"width:25%\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t</ul>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </form>\r\n");
      out.write("  </body>\r\n");
      out.write(" <script type=\"text/javascript\">\r\n");
      out.write("  document.getElementById(\"werks\").focus();\r\n");
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
