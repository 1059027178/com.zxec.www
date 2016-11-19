package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;

public final class two3_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/include/const.jsp");
    _jspx_dependants.add("/WEB-INF/classes/com/thinkway/cms/presentation/web/tag/qhcms.tld");
  }

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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \r\n");

String desp = "展会管理工具";
String company = "九慧";
String sysname = "SAP交互系统";
String warnmsg1 = "请不要在公共电脑或网吧机器上使用本系统。";
String warnmsg2 = "请不要在公共电脑或网吧机器上使用本系统。";
String uploadDir = "/ckeditor/uploader/upload/";


      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<HEAD>\r\n");
      out.write("<TITLE>");
      out.print(sysname);
      out.write(' ');
      out.write('-');
      out.write(' ');
      out.print(company);
      out.write("</TITLE>\r\n");
      out.write("<META http-equiv=Content-Type content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<meta name=\"description\" content=\"");
      out.print(desp);
      out.write("\">\r\n");
      out.write("<meta name=\"company\" content=\"");
      out.print(company);
      out.write("\">\r\n");
      out.write("<!-- Le styles -->\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("   body {\r\n");
      out.write("      padding-top: 90px;\r\n");
      out.write("      padding-bottom: 0px;\r\n");
      out.write("    }\r\n");
      out.write("    .sidebar-nav {\r\n");
      out.write("      padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("     .table_border td{\r\n");
      out.write("\t    border-top:1px #DDD solid;\r\n");
      out.write("\t    border-right:1px #DDD solid;\r\n");
      out.write("    }\r\n");
      out.write("\t.table_border{\r\n");
      out.write("\t\tborder-bottom:1px #DDD solid;\r\n");
      out.write("\t\tborder-left:1px #DDD solid;\r\n");
      out.write("\t\tbackground-color:#CCCCFF;\r\n");
      out.write("\t}\r\n");
      out.write("  </style>\r\n");
      out.write("  <LINK href=\"/css/jiuhui.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("  <script langth=\"javascript\">\r\n");
      out.write("  function keyDown() {\r\n");
      out.write("       var keycode = event.keyCode;\r\n");
      out.write("       var realkey = String.fromCharCode(event.keyCode);\r\n");
      out.write("       //alert(\"按键码: \" + keycode + \" 字符: \" + realkey);\r\n");
      out.write("       return realkey;\r\n");
      out.write("   }\r\n");
      out.write("   \r\n");
      out.write("   document.onkeydown = keyDown;\r\n");
      out.write("   \r\n");
      out.write("  \tfunction choose(){\r\n");
      out.write("  \t\tvar choose=document.getElementById(\"choose\").value;\r\n");
      out.write("  \t\tif(choose.length==0){\r\n");
      out.write("\t  \t\talert(\"未选择,请选择\");\r\n");
      out.write("\t  \t\treturn;\r\n");
      out.write("  \t\t}\t \r\n");
      out.write("  \t\tdocument.thinkway.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  </script>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\t\r\n");
      out.write("<from name=\"thinkway\" id=\"thinkway\" action=\"/main.do\">\r\n");
      out.write("<table style=\"width:100%\" class=\"table_border\">\r\n");
      out.write("  \t<tr>\r\n");
      out.write("  \t<td>\r\n");
      out.write("    \t<input  class=button type=\"button\" style=\"width:200px\" onclick=\"window.location.href='/deliveryAdd.do';\" value=\"1.交货单发货\">\r\n");
      out.write("      </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td>\r\n");
      out.write("    \t<input  class=button type=\"button\" style=\"width:95px;heigth:20px\"  onclick=\"window.location.href='/logout.do';\" value=\"退出\">\r\n");
      out.write("    \t<input  class=button type=\"button\" style=\"width:95px;heigth:20px\" onclick=\"window.location.href='/main.do';\" value=\"返回\">\r\n");
      out.write("    </td>\r\n");
      out.write("    </tr>\r\n");
      out.write("    </table>\r\n");
      out.write("</from>\r\n");
      out.write(" \r\n");
      out.write("\t \r\n");
      out.write("\r\n");
      out.write("</BODY>\r\n");
      out.write("\r\n");
      out.write("</HTML>");
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
