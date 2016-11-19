package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class receipt_005fview_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>生产订单收货</title>\r\n");
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
      out.write("function submit1(obj){\r\n");
      out.write("\tvar objno=$(\"#objno\").val();\r\n");
      out.write("\tif(objno=='' || objno==null){\r\n");
      out.write("\t\talert(\"请输入工号!\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\tvar flag=$(\"#flag\").val();\r\n");
      out.write("\tif(flag!='true'){\r\n");
      out.write("\t\talert(\"工号不存在\");\r\n");
      out.write("\t\treturn;\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("  \tobj.disabled=true;\r\n");
      out.write("  \t\r\n");
      out.write("  \t\r\n");
      out.write("  \tdocument.form.submit();\r\n");
      out.write("  }\r\n");
      out.write("  function checkObjno(){\r\n");
      out.write("  \t\tvar objno=$(\"#objno\").val();\r\n");
      out.write("  \t\tif(objno=='' || objno==null)return;\r\n");
      out.write("\t\tjQuery.ajax({\r\n");
      out.write("\t\t\turl:'/receiptJson.do',\r\n");
      out.write("\t \t\tasync:false,\r\n");
      out.write("\t \t\ttype:\"post\",\r\n");
      out.write("\t \t\tdata:{\"showType\":\"checkObjno\",\"objno\":objno},\r\n");
      out.write("\t \t\tdataType:'json',\r\n");
      out.write("\t \t\tsuccess:function(data){\r\n");
      out.write("\t \t\t\tvar count=data.count;\r\n");
      out.write("\t \t\t\tif(count<=0){\r\n");
      out.write("\t \t\t\t\t$(\"#flag\").attr(\"value\",\"false\");\r\n");
      out.write("\t \t\t\t\t$(\"#objno\").attr(\"value\",\"\");\r\n");
      out.write("\t \t\t\t}else{\r\n");
      out.write("\t \t\t\t\t$(\"#flag\").attr(\"value\",\"true\");\r\n");
      out.write("\t \t\t\t}\r\n");
      out.write("\t \t\t},\r\n");
      out.write("\t        error:function(){ \r\n");
      out.write("\t           $(\"#objno\").attr(\"value\",\"\");      \r\n");
      out.write("\t\t       $(\"#flag\").attr(\"value\",\"false\");\r\n");
      out.write("\t\t    }\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction keyDown() {\r\n");
      out.write("       var keycode = event.keyCode;\r\n");
      out.write("       var realkey = String.fromCharCode(event.keyCode);\r\n");
      out.write("      // alert(\"按键码: \" + keycode + \" 字符: \" + realkey);\r\n");
      out.write("       if(keycode=='13'){\r\n");
      out.write("       \t\twindow.event.returnValue = false;\r\n");
      out.write("       }\r\n");
      out.write("   }\r\n");
      out.write("   document.onkeydown = keyDown;\r\n");
      out.write("  function forward(){\r\n");
      out.write("  \twindow.location.href=\"/receiptAdd.do\";\r\n");
      out.write("  }\r\n");
      out.write("  function reset(){\r\n");
      out.write("  \t$('.input').val(\"\");\r\n");
      out.write("  }\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("  <div>\r\n");
      out.write("  <form name=\"form\" action=\"/receiptEdit.do\">\r\n");
      out.write("     <input id=\"flag\" name=\"flag\" type=\"hidden\" />\r\n");
      out.write("\t<input name=\"aufnr\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.aufnr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"matnr\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.matnr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"meins\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.meins}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"wemng\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.wemng}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"sobkz\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.sobkz}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"lgort\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.lgort}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"charg\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.charg}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"meng\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.meng}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"boxs\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.boxs}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"maktx\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.maktx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input name=\"sonum\" type=\"hidden\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${receiptObj.sonum}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\r\n");
      out.write("     <ul>\r\n");
      out.write("     \t<li class=\"li\" ></li>\r\n");
      out.write("     \t<li class=\"li\" style=\"margin: 20px 0px 0px 0px;\">工牌号：<input name=\"objno\" onchange=\"checkObjno()\" class=\"text3\" type=\"text\"  id=\"objno\" > </input></li>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t\t<li class=\"li\" style=\"margin: 20px 0px 0px 0px;\">\r\n");
      out.write("\t\t<input type=\"button\" valign=\"center\" style=\"width:50px;height:25px;\" class=\"button\" onclick=\"submit1(this);\" value=\"确定\"/>\r\n");
      out.write("\t\t<input  class=\"button\" type=\"button\" style=\"width:40px;height:25px;\" onclick=\"reset();\" value=\"重置\"/>\r\n");
      out.write("\t\t<input  class=\"button\"  type=\"button\" style=\"width:40px;height:25px;\" onclick=\"forward();\" value=\"返回\"/>\r\n");
      out.write("\t\t<input   type=\"button\" class=\"button\" style=\"width:50px;height:25px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t</li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
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
