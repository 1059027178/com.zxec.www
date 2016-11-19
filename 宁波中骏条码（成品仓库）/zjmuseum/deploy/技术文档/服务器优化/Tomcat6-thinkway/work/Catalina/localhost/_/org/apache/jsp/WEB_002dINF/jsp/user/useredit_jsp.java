package org.apache.jsp.WEB_002dINF.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class useredit_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <title>修改密码</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("\t\t<script src=\"/js/jquery.js\"></script>  \r\n");
      out.write("\t<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("\t<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js\" type=\"text/javascript\"></script>    \r\n");
      out.write("\t<link href=\"/css/jiuhui.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("<BODY>\r\n");
      out.write("\t\t  <form name=\"jiuhui\"  id=\"jiuhui\" >\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"div\" style=\" padding-top: 50px;\">\r\n");
      out.write("\t\t\r\n");
      out.write("  \t\t<ul>\r\n");
      out.write("  \t\t\t用&nbsp;户&nbsp;名：");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userObj.userBH}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t<li class=\"li\">用户&nbsp; 别名：<input name=\"userName\" class=\"text\"  type=\"text\"  id=\"userName\"  style=\"width:90px;background-color:white;\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userObj.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">用户新密码：<input name=\"inputPassword\" type=\"text\"  id=\"inputPassword\"  style=\"width:90px;background-color:white;\"class=\"text\"></li>\r\n");
      out.write("  \t\t\t<li class=\"li\">重复新密码：<input name=\"inputPasswordAg\"class=\"text\"  type=\"text\"  style=\"width:90px;background-color:white;\" id=\"inputPasswordAg\"></li>\r\n");
      out.write("  \t\t\t\r\n");
      out.write("  \t\t\t<li class=\"li\">\r\n");
      out.write("  \t\t\t<input type=\"button\" valign=\"center\" style=\"width:40px;height:25px;\" class=\"button\" onclick=\"save();\" value=\"确定\"/>\r\n");
      out.write("  \t\t\t<input type=\"button\" class=\"button\" style=\"width:40px;height:25px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\"></li>\r\n");
      out.write("  \t\t\t\r\n");
      out.write("  \t\t\t<input type=\"hidden\" id=\"userId\" name=\"userId\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userObj.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t <input type=\"hidden\" id=\"userBH\" name=\"userBH\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userObj.userBH}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t <input type=\"hidden\" name=\"userFunction\" id=\"userFunction\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${userObj.userFunction}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\">\t\r\n");
      out.write("  \t\t</ul>\r\n");
      out.write("  \t</div>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t \r\n");
      out.write("<script src=\"/js/md5.js\"></script>\t\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/bootstrap-ie.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("\t <script  langth=\"javascript\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("function save(){\r\n");
      out.write("\t\tvar userId= $('#userId').val();\r\n");
      out.write("\t\tvar userBH= $('#userBH').val();\r\n");
      out.write("\t\tvar userName= $('#userName').val();\r\n");
      out.write("\t\tvar inputPassword= $('#inputPassword').val();\r\n");
      out.write("\t\tvar inputPasswordAg= $('#inputPasswordAg').val();\r\n");
      out.write("\t\tvar userFunction= $('#userFunction').val();\r\n");
      out.write("\r\n");
      out.write("\t\tjQuery.ajax({\r\n");
      out.write("\t\t\t\ttype:'get',        \r\n");
      out.write("\t\t        url:'/userJson.do?showType=updateUser',\r\n");
      out.write("\t\t        data:{\"userId\":userId,\"userBH\":userBH,\"userName\":userName,\"inputPassword\":inputPassword,\"inputPasswordAg\":inputPasswordAg,\"userFunction\":userFunction},\r\n");
      out.write("\t\t        dataType:'json',\r\n");
      out.write("\t\t        cache:false, \r\n");
      out.write("\t\t        success:function(data){ \t\t\t            \r\n");
      out.write("\t\t\t         alert(data.errmsg); \r\n");
      out.write("\t\t\t         if(data.errmsg=='用户修改成功!'){\r\n");
      out.write("\t\t\t         \t  window.location.href=\"/logout.do\";\r\n");
      out.write("\t\t\t         }\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        error:function(){       \r\n");
      out.write("\t\t\t       alert(\"发生调用异常!\");\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("}\r\n");
      out.write("\tfunction validInfoShow(themsg){\r\n");
      out.write("\t  $('#formValidInfo').html(themsg);\r\n");
      out.write("\t  $('#formValidInfo').show(200);\r\n");
      out.write("\t}\r\n");
      out.write("\tfunction successInfoShow(themsg){\r\n");
      out.write("\t    $.teninedialog({\r\n");
      out.write("                title:'系统提示',\r\n");
      out.write("                content:themsg,\r\n");
      out.write("                showCloseButton:true,\r\n");
      out.write("                //otherButtons:[\"确定\",\"取消\"],\r\n");
      out.write("                //otherButtonStyles:['btn-primary','btn-primary'],\r\n");
      out.write("                bootstrapModalOption:{keyboard: true},\r\n");
      out.write("                /*\r\n");
      out.write("                dialogShow:function(){\r\n");
      out.write("                    alert('即将显示对话框');\r\n");
      out.write("                },\r\n");
      out.write("                dialogShown:function(){\r\n");
      out.write("                    alert('显示对话框');\r\n");
      out.write("                },\r\n");
      out.write("                dialogHide:function(){\r\n");
      out.write("                    alert('即将关闭对话框');\r\n");
      out.write("                },\r\n");
      out.write("                */\r\n");
      out.write("                dialogHidden:function(){\r\n");
      out.write("                    //alert('关闭对话框');\r\n");
      out.write("                    window.location.href=\"/hrminfoList.do\";\r\n");
      out.write("                }      \r\n");
      out.write("                /*            \r\n");
      out.write("                clickButton:function(sender,modal,index){\r\n");
      out.write("                    alert('选中第'+index+'个按钮：'+sender.html());\r\n");
      out.write("                    $(this).closeDialog(modal);\r\n");
      out.write("                }\r\n");
      out.write("                */\r\n");
      out.write("         });\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</BODY>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("  document.getElementById(\"inputPassword\").focus();\r\n");
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
