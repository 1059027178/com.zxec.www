package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<HEAD>\r\n");
      out.write("<META http-equiv=Content-Type content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("<LINK href=\"/css/jiuhui.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("<!-- Le styles -->\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("    body {\r\n");
      out.write("      padding-top: 60px;\r\n");
      out.write("      padding-bottom: 40px;\r\n");
      out.write("    }\r\n");
      out.write("    .sidebar-nav {\r\n");
      out.write("      padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("  \r\n");
      out.write("\r\n");
      out.write("<script src=\"/js/md5.js\"></script>\r\n");
      out.write("<script src=\"/js/jquery.js\"></script>  \r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js\" type=\"text/javascript\"></script>    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("function handleForm(){\r\n");
      out.write("   if($('#userBH').val()==\"\"){\r\n");
      out.write("  \talert(\"用户账号必须输入！\");\r\n");
      out.write("  \t$('#userBH').focus();\r\n");
      out.write("  \treturn false;\r\n");
      out.write("  }\r\n");
      out.write("   if($('#password').val()==\"\"){\r\n");
      out.write("  \talert(\"密码必须输入！\");\r\n");
      out.write("  \t$('#password').focus();\r\n");
      out.write("  \treturn false;\r\n");
      out.write("  }\r\n");
      out.write("  //MD5客户端加密\r\n");
      out.write("  $('#password').val(calcMD5($('#password').val()));  \r\n");
      out.write("  return true;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("   \r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY style=\"width:240px;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<form   class=\"form-vertical\" action=\"/loginForm.do\" method=\"post\" onSubMit=\"return handleForm();\">  \r\n");
      out.write("  <table style=\"width:240px;border:1px;\">\r\n");
      out.write("\r\n");
      out.write("     <tr>\r\n");
      out.write("     <td>账号<font color='red'>*</font>：</td>\r\n");
      out.write("     \t<td >\r\n");
      out.write("\t\t\t\t<input name=\"userBH\" type=\"text\" style=\"width:130px;\"  id=\"userBH\"> </input>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t<td>密码<font color='red'>*</font>：</td>\r\n");
      out.write("     \t<td><input name=\"password\" type=\"password\" style=\"width:130px;\" id=\"password\"></td>\r\n");
      out.write(" </tr>\r\n");
      out.write(" <!--  \r\n");
      out.write("<div class=\"control-group\">\r\n");
      out.write(" <div class=\"controls\">\r\n");
      out.write(" <input type=\"checkbox\" name=\"yes\" value=\"remUser\">&nbsp;两周内不再登录\r\n");
      out.write("<input type=\"hidden\" name=\"referUrl\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${referUrl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write(" </div>             \r\n");
      out.write("</div>-->\r\n");
      out.write("<tr>\r\n");
      out.write("<td>\r\n");
      out.write("<input class=\"button\" type=\"submit\" value=\"登 录\"/>\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<!--  \r\n");
      out.write("  <a href=\"#\" class=\"btn btn-warning\" id=\"fgtpwd\">忘记密码</a> -->\r\n");
      out.write("</table>\r\n");
      out.write("</form>\r\n");
      out.write("\r\n");
      out.write("</BODY>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("  document.getElementById(\"userBH\").focus();\r\n");
      out.write("  </script>\r\n");
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
