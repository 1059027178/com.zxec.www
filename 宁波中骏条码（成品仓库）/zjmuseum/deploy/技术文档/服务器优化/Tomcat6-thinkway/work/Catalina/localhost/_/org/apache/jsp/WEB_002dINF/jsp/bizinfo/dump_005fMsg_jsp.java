package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;

public final class dump_005fMsg_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write(' ');
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
      out.write('\r');
      out.write('\n');
			
	String radio = LiangxinUtil.null2String((String)request.getAttribute("radio"));//物料编码 
	System.out.println(radio);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <head>\r\n");
      out.write(" \r\n");
      out.write("    <script language=\"javascript\" src=\"/js/jiuhui.js\"></script>\r\n");
      out.write("    <title>转储</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("\t <LINK href=\"/css/jiuhui_list.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("  \tfunction zhuangcu(){\r\n");
      out.write("  \t\tdocument.form.action=\"/dumpCheck.do\";\r\n");
      out.write("  \t\tdocument.form.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction shangjia(){\r\n");
      out.write("  \t\tdocument.form.action=\"/groundingAdd.do\";\r\n");
      out.write("  \t\tdocument.form.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("\tfunction jixu(){\r\n");
      out.write("\t\tlocation='/delordList.do'\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("  <body style=\"background-color:#CDCED2;\">\r\n");
      out.write("  \t\t<div style=\"margin-top:60px;\">\r\n");
      out.write("  \t\t<form name=\"form\">\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"posnr\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${posnr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"maktx\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${maktx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"matnr\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${matnr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"posnr\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${posnr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"lfimg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${shuliang}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"vbeln\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vbeln}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"meins\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${meins}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"charg\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${charg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"xzsl\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${xzsl}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("  \t\t<input type=\"hidden\" name=\"wadat\" style=\"width:70%\"  id=\"wadat\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wadat }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"lgort\" style=\"width:70%\"  id=\"lgort\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lgort }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"werks\" style=\"width:70%\"  id=\"werks\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${werks }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"radio\" style=\"width:70%\"  id=\"radio\" value=\"2\"/>\r\n");
      out.write("    \t<table class=\"table_list\">\r\n");
      out.write("    \t\t<tr style=\"width:100%;heigth=50%\">\r\n");
      out.write("    \t\t\t<td align=\"middle\">\r\n");
      out.write("    \t\t\t\t返回消息：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${type}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("    \t\t\t</td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t\t<tr style=\"width:100%;heigth=20%\">\r\n");
      out.write("    \t\t\t<td align=\"center\">");
if(radio.equals("1")){ 
      out.write("\r\n");
      out.write("    \t\t\t\t<input type=\"button\" style=\"width:40px;\" onclick=\"zhuangcu();\" value=\"转储\">");
}else{ 
      out.write("\r\n");
      out.write("    \t\t\t\t<input type=\"button\" style=\"width:40px;\" onclick=\"shangjia();\" value=\"上架\">");
} 
      out.write("\r\n");
      out.write("    \t\t\t\t<input type=\"button\" style=\"width:40px;\" onclick=\"window.location.href='/dumpView.do';\"  value=\"返回\">\r\n");
      out.write("    \t\t\t\t<input type=\"button\" style=\"width:40px;height:25px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("    \t\t\t</td>\r\n");
      out.write("    \t\t</tr>\r\n");
      out.write("    \t</table>\r\n");
      out.write("    \t</form>\r\n");
      out.write("    \t</div>\r\n");
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
