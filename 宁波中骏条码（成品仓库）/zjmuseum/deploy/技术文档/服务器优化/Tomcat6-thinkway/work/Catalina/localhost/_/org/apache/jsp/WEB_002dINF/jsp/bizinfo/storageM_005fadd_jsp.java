package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class storageM_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("      padding-top: 40px;\r\n");
      out.write("      padding-bottom: 40px;\r\n");
      out.write("    }\r\n");
      out.write("    .sidebar-nav {\r\n");
      out.write("      padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>仓位转移</title>\r\n");
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
      out.write("\t\t function submit1(obj){\r\n");
      out.write("  \t\r\n");
      out.write("\t\t  \tobj.disabled=false;\r\n");
      out.write("\t\t  \tdocument.form.submit();\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t\t  function forward(){\r\n");
      out.write("\t\t  \twindow.location.href=\"/storageMView.do\";//history.go(-1);\r\n");
      out.write("\t\t  }\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <form name=\"form\" action=\"/storageMEdit.do\">\r\n");
      out.write("  \t<input name=\"sonum\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.sonum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"lgort\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.lgort}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"werks\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.werks}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"sobkz\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.sobkz}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"meins\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.meins}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"lgnum\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lgnum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"lgtyp\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.letyp}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  <div>\r\n");
      out.write("     \r\n");
      out.write("     <ul>\r\n");
      out.write("     \t<li class=\"li\" >源仓&nbsp;&nbsp;位：<input name=\"lgpla\" class=\"text\" readonly= readonly type=\"text\"  id=\"lgpla\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lgpla }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"> </input>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li class=\"li\">物料&nbsp;&nbsp;号：<input name=\"matnr\" class=\"text\" readonly= readonly type=\"text\"  id=\"mtnr\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.matnr }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"> </input>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t<li class=\"li\" >批&nbsp;&nbsp;&nbsp;&nbsp;次：<input name=\"charg\" class=\"text\" readonly= readonly type=\"text\"  id=\"charg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.charg }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"> \r\n");
      out.write("\t\t</li>\r\n");
      out.write("     \t<li class=\"li\" >参考数量：<input name=\"gesme\" class=\"text1\" readonly= readonly type=\"text\"  id=\"gesme\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.gesme }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t<input name=\"meinh\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.meins}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" class=\"text2\" style=\"width:25px;background-color:#D8D8D8;\" type=\"text\"  id=\"meinh\"> \r\n");
      out.write("\t\t</li>\r\n");
      out.write("     \t<li class=\"li\" >转移数量：<input name=\"verme\" type=\"text\" class=\"text1\"  id=\"verme\" style=\"background-color:white;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.gesme }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t\t<input name=\"meins\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${repObj.meins}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" style=\"width:25px;background-color:#D8D8D8;\" class=\"text2\" type=\"text\"  id=\"meins\"> \r\n");
      out.write("\t\t</li>\r\n");
      out.write("     \t<li class=\"li\">目的仓位：<input name=\"nlpla\" type=\"text\" class=\"text\" style=\"background-color:white;\" id=\"nlpla\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${nlpla }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"> </input>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("<li class=\"li\">\r\n");
      out.write("<input class=\"button\" type=\"button\" onclick=\"submit1(this)\" value=\"确定\">\r\n");
      out.write("\r\n");
      out.write("<input class=\"button\" type=\"button\" onclick=\"forward()\" value=\"返回\">\r\n");
      out.write("<input   type=\"button\" class=\"button\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("</li>\r\n");
      out.write("</ul>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("</form>\r\n");
      out.write("  </body>\r\n");
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
