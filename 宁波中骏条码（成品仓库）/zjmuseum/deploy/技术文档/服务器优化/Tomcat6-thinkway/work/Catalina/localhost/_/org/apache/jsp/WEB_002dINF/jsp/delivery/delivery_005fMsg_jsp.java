package org.apache.jsp.WEB_002dINF.jsp.delivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class delivery_005fMsg_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      com.thinkway.LiangxinUtil LiangxinUtil = null;
      synchronized (_jspx_page_context) {
        LiangxinUtil = (com.thinkway.LiangxinUtil) _jspx_page_context.getAttribute("LiangxinUtil", PageContext.PAGE_SCOPE);
        if (LiangxinUtil == null){
          LiangxinUtil = new com.thinkway.LiangxinUtil();
          _jspx_page_context.setAttribute("LiangxinUtil", LiangxinUtil, PageContext.PAGE_SCOPE);
        }
      }
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function jixu(){\r\n");
      out.write("\tlocation='/deliveryAdd.do'\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("  <head>\r\n");
      out.write("  \r\n");
      out.write("    <script language=\"javascript\" src=\"/js/jiuhui.js\"></script>\r\n");
      out.write("    <title>交货单过账</title>\r\n");
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
      out.write("\t<LINK href=\"/css/jiuhui_list.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("  \tfunction goon(){\r\n");
      out.write("  \t\tdocument.form.action=\"/deliveryAdd.do\";\r\n");
      out.write("  \t\tdocument.form.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  \t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <div class=\"div\" style=\"margin-top:60px;\">\r\n");
      out.write("    \t<table class=\"table_list\">\r\n");
      out.write("    \t\t<tr>\r\n");
      out.write("    \t\t\t<td>\r\n");
      out.write("    \t\t\t\t返回消息：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("    \t\t\t</td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t<tr  style=\"width:100%;heigth=20%\">\r\n");
      out.write("    \t\t\t<td align=\"center\">\r\n");
      out.write("    \t\t\t\t<input type=\"button\" style=\"width:40px;\" onclick=\"window.location.href='/main.do?two=3';\" value=\"返回\">\r\n");
      out.write("    \t\t\t\t<input type=\"button\" style=\"width:40px;\" onclick=\"jixu()\" value=\"继续\">\r\n");
      out.write("    \t\t\t\t<input  type=\"button\" style=\"width:40px;\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("    \t\t\t</td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t</table>\r\n");
      out.write("    </div>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
      out.write(" ");
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
