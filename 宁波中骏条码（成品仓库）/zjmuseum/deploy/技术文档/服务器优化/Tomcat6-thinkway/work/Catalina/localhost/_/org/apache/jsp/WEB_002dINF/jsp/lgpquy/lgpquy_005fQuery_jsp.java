package org.apache.jsp.WEB_002dINF.jsp.lgpquy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class lgpquy_005fQuery_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script language=\"javascript\" src=\"/js/jiuhui.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function lgpQuy(){\r\n");
      out.write("\tvar lgpla=document.getElementById(\"lgpla\").value;\r\n");
      out.write("  \tif(lgpla.length==0){\r\n");
      out.write("  \t\talert(\"仓位号为空，无法查询\");\r\n");
      out.write("  \t\treturn;\r\n");
      out.write("  \t}\t \r\n");
      out.write("  \tvar lgnum=document.getElementById(\"lgnum\").value;\r\n");
      out.write("  \tif(lgnum.length==0){\r\n");
      out.write("  \t\talert(\"仓库为空，无法查询\");\r\n");
      out.write("  \t\treturn;\r\n");
      out.write("  \t}\t\r\n");
      out.write("\tdocument.jiuhui.submit();\r\n");
      out.write("}\r\n");
      out.write("function reset(){\r\n");
      out.write("\tdocument.getElementById(\"lgpla\").value=\"\"; \r\n");
      out.write("\tdocument.getElementById(\"lgnum\").value=\"\"; \r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("  <head>\r\n");
      out.write("  <LINK href=\"/css/jiuhui.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("    \r\n");
      out.write("    <title>仓位查询</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    <form name=\"jiuhui\"  id=\"jiuhui\" action=\"/lgpquyList.do\">\r\n");
      out.write("    \t<div style=\" padding-top: 70px;\">\r\n");
      out.write("    \t<ul>\r\n");
      out.write("    \t<li class=\"li\"></li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t仓位号：<input style=\"width:60%\" type=\"text\" id=\"lgpla\" name=\"lgpla\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t仓库号：<input style=\"width:60%\" type=\"text\" id=\"lgnum\" name=\"lgnum\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\"></li>\r\n");
      out.write("    \t\t\t<li class=\"li\" align=\"left\">\r\n");
      out.write("    \t\t\t\t<input  class=\"button\"  type=\"button\" style=\"width:20%\"  onclick=\"lgpQuy()\" value=\"查询\">\r\n");
      out.write("    \t\t\t\t<input  class=\"button\"  type=\"button\" style=\"width:20%\"  onclick=\"reset();\" value=\"清除\">\r\n");
      out.write("    \t\t\t\t<input  class=\"button\"  type=\"button\" style=\"width:20%\"  onclick=\"window.location.href='/main.do?two=5';\" value=\"返回\">\r\n");
      out.write("    \t\t\t\t<input  class=button type=\"button\" style=\"width:20%\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t</ul>\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("  </body>\r\n");
      out.write(" <script type=\"text/javascript\">\r\n");
      out.write("  document.getElementById(\"lgpla\").focus();\r\n");
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
