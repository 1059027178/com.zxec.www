package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;

public final class dumpradio3_005fView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/bizinfo/../include/const.jsp");
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

      out.write("\r\n");
      out.write("\r\n");
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
      out.write("<LINK href=\"/css/jiuhui_list.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("  <script  type=\"text/javascript\">\r\n");
      out.write("  \tfunction fanhui(){\r\n");
      out.write("  \t\tdocument.thinkway.action=\"/delordView.do\";\r\n");
      out.write("  \t\tdocument.thinkway.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction validateForm(){\r\n");
      out.write("  \t\tvar menge=document.getElementById(\"menge\").value;\r\n");
      out.write("  \t\tvar lgort_from=document.getElementById(\"lgort_from\").value;\r\n");
      out.write("  \t\tvar lgort_to=document.getElementById('lgort_to').value;\r\n");
      out.write("  \t\tvar bwart=document.getElementById('bwart').value;\r\n");
      out.write("\t  \tif(menge.length==0){\r\n");
      out.write("\t  \t\talert(\"数量为空，请填写\");\r\n");
      out.write("\t  \t\treturn false;\r\n");
      out.write("\t  \t}\r\n");
      out.write("\t  \tif(lgort_from.length==0){\r\n");
      out.write("\t  \t\talert(\"库存地点从为空，请填写\");\r\n");
      out.write("\t  \t\treturn false;\r\n");
      out.write("\t  \t}\r\n");
      out.write("\t  \tif(lgort_to.length==0){\r\n");
      out.write("\t  \t\talert(\"库存地点到为空，请填写\");\r\n");
      out.write("\t  \t\treturn false;\r\n");
      out.write("\t  \t}\r\n");
      out.write("\t  \tif(bwart.length==0){\r\n");
      out.write("\t  \t\talert(\"移动类型为空，请填写\");\r\n");
      out.write("\t  \t\treturn false;\r\n");
      out.write("\t  \t}\r\n");
      out.write("  \t\treturn true;\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction xiangtong(){\r\n");
      out.write("  \t\tdocument.getElementById(\"lgort_to\").value=document.getElementById(\"lgort_from\").value;\r\n");
      out.write("  \t}\r\n");
      out.write("  </script>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<div class=\"div\">\r\n");
      out.write("\t<form  id=\"thinkway\" name=\"thinkway\" method=\"post\" action=\"/dumpAdd.do\">\r\n");
      out.write("\t\t <input type=\"hidden\" name=\"matnr\" id=\"matnr\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${matnr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"charg\" id=\"charg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${charg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"sobkz\" id=\"sobkz\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sobkz}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"sonum\" id=\"sonum\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sonum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"meins\" id=\"meins\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${meins}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"radio\" id=\"radio\" value=\"2\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<table  class=\"table_list\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td    width=\"30%\">物料编码:</td>\r\n");
      out.write("\t\t\t\t\t<td  >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${matnr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td >物料描述:</td>\r\n");
      out.write("\t\t\t\t\t<td  >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${maktx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td >批次:</td>\r\n");
      out.write("\t\t\t\t\t<td  >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${charg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td  >数量:</td>\r\n");
      out.write("\t\t\t\t\t<td  ><input style=\"width:50%\" name=\"menge\" type=\"text\"  id=\"menge\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td >库存地点:</td>\r\n");
      out.write("\t\t\t\t\t<td  ><input name=\"lgort_from\" type=\"text\" style=\"width:25%\"  id=\"lgort_from\" onchange=\"xiangtong()\">到<input readonly=\"readonly\" name=\"lgort_to\" type=\"text\" style=\"width:25%\"  id=\"lgort_to\"></td>\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td >特殊库存:</td>\r\n");
      out.write("\t\t\t\t\t<td  >");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sobkz}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sonum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td >移动类型:</td>\r\n");
      out.write("\t\t\t\t\t<td  ><input readonly=readonly name=\"bwart\" size=\"3\" style=\"width:35%\" type=\"text\"  id=\"bwart\" value=\"321\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\" colspan=\"2\">\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"submit\" style=\"width:40px;heigth=20%\" onclick=\"return validateForm()\" value=\"过账\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" style=\"width:40px;heigth=20%\" value=\"返回\" onclick=\"window.location.href='/dumpView.do';\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" style=\"width:40px;height:20%;\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("</div>\r\n");
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
