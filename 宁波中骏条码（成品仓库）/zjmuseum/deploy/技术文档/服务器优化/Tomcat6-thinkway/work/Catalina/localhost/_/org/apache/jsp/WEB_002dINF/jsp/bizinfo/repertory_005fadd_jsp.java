package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class repertory_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<style type=\"text/css\">\r\n");
      out.write("    body {\r\n");
      out.write("      padding-top: 50px;\r\n");
      out.write("      padding-bottom: 40px;\r\n");
      out.write("    }\r\n");
      out.write("    .sidebar-nav {\r\n");
      out.write("      padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("  </style>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>仓位冻结</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("\t<script src=\"/js/jquery.js\"></script>  \r\n");
      out.write("\t<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("\t<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js\" type=\"text/javascript\"></script>    \r\n");
      out.write("\t<link href=\"/css/jiuhui.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\tfunction keyDown() {\r\n");
      out.write("       var keycode = event.keyCode;\r\n");
      out.write("       var realkey = String.fromCharCode(event.keyCode);\r\n");
      out.write("      // alert(\"按键码: \" + keycode + \" 字符: \" + realkey);\r\n");
      out.write("       if(keycode=='13'){\r\n");
      out.write("       \t\tgetNlpla();\r\n");
      out.write("       }\r\n");
      out.write("   }\r\n");
      out.write("   document.onkeydown = keyDown;\r\n");
      out.write(" function submit1(obj){\r\n");
      out.write("  \t\r\n");
      out.write("  \tobj.disabled=false;\r\n");
      out.write("  \tdocument.form.submit();\r\n");
      out.write("  }\r\n");
      out.write("  function forward(){\r\n");
      out.write("  \twindow.location.href=\"/main.do?two=4\";\r\n");
      out.write("  }\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <form name=\"form\" action=\"/repertoryView.do\">\r\n");
      out.write("  <div>\r\n");
      out.write("    \r\n");
      out.write("\t<ul>\r\n");
      out.write("\t\t<li class=\"li\" >仓库号:<input name=\"lgnum\" style=\"background-color:white;\" class=\"text\" type=\"text\"  id=\"lgnum\">\r\n");
      out.write("\t\t</li>\r\n");
      out.write("     \t<li class=\"li\">仓位号:<input name=\"nlpla\" class=\"text\" style=\"background-color:white;\" type=\"text\"  id=\"nlpla\" > </input>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("     \t<li class=\"li\"><input name=\"radio\" style=\"width:20px;\" checked=checked type=\"radio\" id=\"radio1\" value=\"1\">出入库冻结</input></li>\r\n");
      out.write("     \t<li class=\"li\"><input name=\"radio\" style=\"width:20px;\" type=\"radio\" id=\"radio2\" value=\"2\" >出入库解冻</input></li>\r\n");
      out.write("     \t<li class=\"li\"><input name=\"radio\" style=\"width:20px;\" type=\"radio\" id=\"radio3\" value=\"3\" >查看所有冻结仓位</input></li>\r\n");
      out.write("\t\t<li class=\"li\">\r\n");
      out.write("\t\t<input class=\"button\" type=\"button\" onclick=\"submit1(this)\" value=\"确定\">\r\n");
      out.write("\t\t<input  class=\"button\" type=\"button\" onclick=\"forward()\" value=\"返回\">\r\n");
      out.write("\t\t<input   type=\"button\" class=\"button\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t</li>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("  </body>\r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write("  document.getElementById(\"lgnum\").focus();\r\n");
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
