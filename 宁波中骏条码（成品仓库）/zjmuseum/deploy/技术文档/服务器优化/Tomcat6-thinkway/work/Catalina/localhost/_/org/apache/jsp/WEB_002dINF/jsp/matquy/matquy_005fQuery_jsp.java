package org.apache.jsp.WEB_002dINF.jsp.matquy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class matquy_005fQuery_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("<script language=\"javascript\" src=\"/js/jiuhui.js\"></script>\r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js\" type=\"text/javascript\"></script>    \r\n");
      out.write("<script src=\"/js/jquery.js\"></script>  \r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function matQuy(){\r\n");
      out.write("\tvar matnr=document.getElementById(\"matnr\").value;\r\n");
      out.write("  \tif(matnr.length==0){\r\n");
      out.write("  \t\talert(\"物料编码为空，无法查询\");\r\n");
      out.write("  \t\treturn;\r\n");
      out.write("  \t}\t \r\n");
      out.write("  \tvar werks=document.getElementById(\"werks\").value;\r\n");
      out.write("  \tif(werks.length==0){\r\n");
      out.write("  \t\talert(\"工厂为空，无法查询\");\r\n");
      out.write("  \t\treturn;\r\n");
      out.write("  \t}\r\n");
      out.write("\tdocument.jiuhui.submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("   <script type=\"text/javascript\">\r\n");
      out.write("   function js(){\r\n");
      out.write("   \t\tvar saomiao=document.getElementById(\"saomiao\").value;\r\n");
      out.write("   \t\tvar str=saomiao.split(\"/\");\r\n");
      out.write("\t\tif(saomiao.length!=0){\r\n");
      out.write("\t\t \tdocument.getElementById(\"matnr\").value=str[1];\r\n");
      out.write("\t\t \tdocument.getElementById(\"lgort\").value=str[7];\r\n");
      out.write("\t\t \tdocument.getElementById(\"charg\").value=str[4];\r\n");
      out.write("\t\t \tjQuery.ajax({\r\n");
      out.write("\t\t\t\turl:'/matquyJson.do',\r\n");
      out.write("\t\t \t\tasync:false,\r\n");
      out.write("\t\t \t\ttype:\"post\",\r\n");
      out.write("\t\t \t\tdata:{\"showType\":\"getWerks\",\"lgort\":str[7]},\r\n");
      out.write("\t\t \t\tdataType:'json',\r\n");
      out.write("\t\t \t\tsuccess:function(data){\r\n");
      out.write("\t\t \t\t\t$(\"#werks\").attr(\"value\",data.werks);\r\n");
      out.write("\t\t \t\t},\r\n");
      out.write("\t\t        error:function(){       \r\n");
      out.write("\t\t\t       alert(\"系统异常，请联系管理员\");\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t \t//document.getElementById(\"saomiao\").value=\"\";\r\n");
      out.write("\t\t}\r\n");
      out.write("   }\r\n");
      out.write("   function reset(){\r\n");
      out.write("  \t\tdocument.getElementById(\"matnr\").value=\"\";\r\n");
      out.write("  \t\tdocument.getElementById(\"lgort\").value=\"\";\r\n");
      out.write("  \t\tdocument.getElementById(\"charg\").value=\"\";\r\n");
      out.write("  \t\tdocument.getElementById(\"werks\").value=\"\";\r\n");
      out.write("  }\r\n");
      out.write("  \tfunction keyDown() {\r\n");
      out.write("       var keycode = event.keyCode;\r\n");
      out.write("       var realkey = String.fromCharCode(event.keyCode);\r\n");
      out.write("      // alert(\"按键码: \" + keycode + \" 字符: \" + realkey);\r\n");
      out.write("       if(keycode=='13'){\r\n");
      out.write("       \t\tjs();\r\n");
      out.write("       }\r\n");
      out.write("   }\r\n");
      out.write("   document.onkeydown = keyDown;\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </script>\r\n");
      out.write("  <head>\r\n");
      out.write("  <LINK href=\"/css/jiuhui.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("    \r\n");
      out.write("    <title>物料查询</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<!--\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\r\n");
      out.write("\t-->\r\n");
      out.write("\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body>\r\n");
      out.write("    <form name=\"jiuhui\"  id=\"jiuhui\" action=\"/matquyList.do\">\r\n");
      out.write("        <div class=\"div\" style=\" padding-top: 50px;\">\r\n");
      out.write("    \t<ul>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t<input style=\"width:70%;heigth=20%\" type=\"text\" id=\"saomiao\" onchange=\"js()\" name=\"saomiao\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t物料编码：<input  type=\"text\" class=\"text\" style=\"width:90px;background-color:white;\" id=\"matnr\" name=\"matnr\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t库存地点：<input  type=\"text\" class=\"text\" style=\"width:90px;background-color:white;\" id=\"lgort\" name=\"lgort\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t\t批  &nbsp;&nbsp; 次：<input  type=\"text\" class=\"text\" style=\"width:90px;background-color:white;\" id=\"charg\" name=\"charg\"  value=\"\"/>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    \t\t<li class=\"li\">\r\n");
      out.write("    \t\t工  &nbsp;&nbsp; 厂：<input  type=\"text\" class=\"text\" id=\"werks\" style=\"width:90px;background-color:white;\" name=\"werks\"  value=\"\"/></td>\r\n");
      out.write("    \t\t</li>\r\n");
      out.write("    <li class=\"li\"></li>\r\n");
      out.write("     <li class=\"li\">\r\n");
      out.write("    \t\t\t\t<input  class=\"button\"  type=\"button\"  style=\"width:20%\" onclick=\"matQuy()\" value=\"查询\">\r\n");
      out.write("    \t\t\t\t<input  class=\"button\"  type=\"button\" style=\"width:20%\"  onclick=\"reset();\" value=\"重置\">\r\n");
      out.write("    \t\t\t\t<input  class=\"button\"  type=\"button\" style=\"width:20%\" onclick=\"window.location.href='/main.do?two=5';\" value=\"返回\"></td>\r\n");
      out.write("    \t\t\t\t <input  class=button type=\"button\" style=\"width:20%\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write(" \t\t</li>\r\n");
      out.write("    \t</ul>\r\n");
      out.write("    \t</div>\r\n");
      out.write("    </form>\r\n");
      out.write("  </body>\r\n");
      out.write("      <script type=\"text/javascript\">\r\n");
      out.write("  document.getElementById(\"saomiao\").focus();\r\n");
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
