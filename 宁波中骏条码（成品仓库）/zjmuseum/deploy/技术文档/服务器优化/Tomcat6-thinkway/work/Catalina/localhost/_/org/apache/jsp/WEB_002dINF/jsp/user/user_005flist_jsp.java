package org.apache.jsp.WEB_002dINF.jsp.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;

public final class user_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

static private org.apache.jasper.runtime.ProtectedFunctionMapper _jspx_fnmap_0;

static {
  _jspx_fnmap_0= org.apache.jasper.runtime.ProtectedFunctionMapper.getMapForFunction("fn:contains", org.apache.taglibs.standard.functions.Functions.class, "contains", new Class[] {java.lang.String.class, java.lang.String.class});
}

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(5);
    _jspx_dependants.add("/WEB-INF/jsp/user/../include/const.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/user/../include/header.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/user/../include/lefter.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/user/../include/footer.jsp");
    _jspx_dependants.add("/WEB-INF/classes/com/thinkway/cms/presentation/web/tag/qhcms.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005frequestURI_005fname_005fid_005fexport_005fclass;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable_005fproperty_005fescapeXml_005fnobody;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fescapeXml;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fproperty_005fescapeXml_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005frequestURI_005fname_005fid_005fexport_005fclass = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable_005fproperty_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fescapeXml = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fproperty_005fescapeXml_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005frequestURI_005fname_005fid_005fexport_005fclass.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable_005fproperty_005fescapeXml_005fnobody.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fescapeXml.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fproperty_005fescapeXml_005fnobody.release();
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
      out.write("<link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"/css/bootstrap-responsive.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write(" <!--[if lte IE 6]>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/bootstrap-ie6.css\">\r\n");
      out.write("  <![endif]-->\r\n");
      out.write("  <!--[if lte IE 7]>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/ie.css\">\r\n");
      out.write("  <![endif]--> \r\n");
      out.write("\r\n");
      out.write("<script src=\"/js/jquery.js\"></script>  \r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js\" type=\"text/javascript\"></script>    \r\n");
      out.write("<link type=\"text/css\" href=\"/js/jquery-ui-bootstrap/css/custom-theme/jquery-ui-1.10.0.custom.css\" rel=\"stylesheet\" />\r\n");
      out.write("<link type=\"text/css\" href=\"/js/jquery-ui-bootstrap/assets/css/font-awesome.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("<!--[if IE 7]>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/js/jquery-ui-bootstrapassets/css/font-awesome-ie7.min.css\">\r\n");
      out.write("<![endif]-->\r\n");
      out.write("<!--[if lt IE 9]>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/js/jquery-ui-bootstrap/css/custom-theme/jquery.ui.1.10.0.ie.css\"/>\r\n");
      out.write("<![endif]--> \r\n");
      out.write("  \r\n");
      out.write("<link href=\"/css/displaytag-fix.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"navbar navbar-fixed-top\">\r\n");
      out.write("      <div class=\"navbar-inner\">\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("          <a class=\"brand\" href=\"/main.do\">");
      out.print(sysname);
      out.write(" <span style=\"font-weight:bold;font-size:10px;font-family:Arial;\">TM</span></a>  \r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div><!--/.navbar -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <div class=\"container-fluid\">\r\n");
      out.write("      <div class=\"row-fluid\">\r\n");
      out.write("        <div class=\"span2\">\t      \r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  <!--.btn-新建-->\r\n");
      out.write("          <div class=\"btn-group\" style=\"padding:0;background:none;margin-left:0px;margin-bottom:20px;\">  \r\n");
      out.write("\t\t  <button class=\"btn btn-primary dropdown-toggle\" style=\"width:100%;height:32px;text-align:left;\" data-toggle=\"dropdown\">\r\n");
      out.write("\t\t  <i class=\"icon-white icon-pencil\"> </i> \r\n");
      out.write("\t\t   新建.... <span class=\"caret\"></span>\r\n");
      out.write("\t\t   </button>  \r\n");
      out.write("\t\t  <ul class=\"dropdown-menu\">\r\n");
      out.write("\t\t  <li><a href=\"/userAdd.do\"><i class=\"icon-book\"> </i>\r\n");
      out.write("\t\t  用户</a></li>\r\n");
      out.write("\t\t  <li><a href=\"/hrminfoAdd.do\"><i class=\"icon-pencil\"> </i>\r\n");
      out.write("\t\t  工号</a></li>\r\n");
      out.write("\t\t  </ul>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t<!--/.常用列表功能-->\r\n");
      out.write("\t\t<div class=\"well\" style=\"padding: 0px 0pt;background:#049cdb;\">\r\n");
      out.write("        <ul  style=\"background:#fff;\" style=\"width=300px\">\r\n");
      out.write("\t\t  <li><a href=\"/userList.do\"> 用户管理</a></li>\r\n");
      out.write("\t\t  <li><a href=\"/hrminfoList.do\"> 工号管理</a></li>\r\n");
      out.write("\t\t  <li><a href=\"/logout.do\">退出登陆</a></li> \r\n");
      out.write("\t\t  </ul>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("  <!--/.常用列表功能-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("        \r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </div><!--/span2-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("        <div class=\"span10\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t\r\n");
      out.write("\t\t  <!--.当前位置导航-->\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <div class=\"row-fluid\">\r\n");
      out.write("\t\t     <ul class=\"breadcrumb\">\r\n");
      out.write("\t\t\t  <li>\r\n");
      out.write("\t\t\t\t当前位置：<span><i class=\"icon-home\"></i> <a href=\"/main.do?showType=main\">首页</a></span> <span class=\"divider\">/</span>\r\n");
      out.write("\t\t\t  </li>\r\n");
      out.write("\t\t\t  <li>用户管理 </li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t  </div>\t\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <!--/.当前位置导航-->\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t    <!--.warninfo-->\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t  <div class=\"alert alert-block\" style=\"padding:5px;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t <a rel=\"popover\" id=\"helpchatter\" class=\"badge badge-warning\"  data-content=\"请保管好您的密码，使用完毕后请退出系统”。 \r\n");
      out.write("\t\t\" rel=\"popover\" href=\"#\" data-original-title=\"尝试输入以下字符来完成\">i</a>\r\n");
      out.write("\t\t<span style=\"padding-left:10px;\"> 注意：请不要在公共电脑或网吧上使用本系统。</span>\r\n");
      out.write("         \r\n");
      out.write("         </div>\t\r\n");
      out.write("\t\t  <!--/.warninfo -->\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <!--.form-listuser -->\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t \r\n");
      out.write("\t\t  <div id=\"formValidInfo\" class=\"alert alert-error\" style=\"display:none;\"> </div>\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t \r\n");
      out.write("\t\t  <!-- Modal -->\r\n");
      out.write("\t\t<script>\r\n");
      out.write("\t\t$('#myModal').on('hidden', function() {\r\n");
      out.write("\t\t  alert();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t</script>\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t\t<form class=\"form-horizontal\" id=\"listForm\" name=\"listform\" method=\"post\">\r\n");
      out.write("\t\t\t<a class=\"btn btn-medium btn-primary\" href=\"/userAdd.do\">新建用户</a><br/><br/>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");
      //  display:table
      org.displaytag.tags.TableTag _jspx_th_display_005ftable_005f0 = (org.displaytag.tags.TableTag) _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005frequestURI_005fname_005fid_005fexport_005fclass.get(org.displaytag.tags.TableTag.class);
      _jspx_th_display_005ftable_005f0.setPageContext(_jspx_page_context);
      _jspx_th_display_005ftable_005f0.setParent(null);
      // /WEB-INF/jsp/user/user_list.jsp(108,3) name = name type = null reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005ftable_005f0.setName(new String("userList"));
      // /WEB-INF/jsp/user/user_list.jsp(108,3) name = export type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005ftable_005f0.setExport(false);
      // /WEB-INF/jsp/user/user_list.jsp(108,3) name = class type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005ftable_005f0.setClass("table table-striped table-bordered");
      // /WEB-INF/jsp/user/user_list.jsp(108,3) name = id type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005ftable_005f0.setUid("list");
      // /WEB-INF/jsp/user/user_list.jsp(108,3) name = requestURI type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_display_005ftable_005f0.setRequestURI("/userList.do");
      int _jspx_eval_display_005ftable_005f0 = _jspx_th_display_005ftable_005f0.doStartTag();
      if (_jspx_eval_display_005ftable_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        java.lang.Object list = null;
        java.lang.Integer list_rowNum = null;
        if (_jspx_eval_display_005ftable_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_th_display_005ftable_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_display_005ftable_005f0.doInitBody();
        }
        list = (java.lang.Object) _jspx_page_context.findAttribute("list");
        list_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("list_rowNum");
        do {
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_display_005fcolumn_005f0(_jspx_th_display_005ftable_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_display_005fcolumn_005f1(_jspx_th_display_005ftable_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_display_005fcolumn_005f2(_jspx_th_display_005ftable_005f0, _jspx_page_context))
            return;
          out.write("\r\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_display_005fcolumn_005f3(_jspx_th_display_005ftable_005f0, _jspx_page_context))
            return;
          out.write("\t\r\n");
          out.write("\t\t\t\t\r\n");
          out.write("\t\t\t");
          int evalDoAfterBody = _jspx_th_display_005ftable_005f0.doAfterBody();
          list = (java.lang.Object) _jspx_page_context.findAttribute("list");
          list_rowNum = (java.lang.Integer) _jspx_page_context.findAttribute("list_rowNum");
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_display_005ftable_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.popBody();
        }
      }
      if (_jspx_th_display_005ftable_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005frequestURI_005fname_005fid_005fexport_005fclass.reuse(_jspx_th_display_005ftable_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fdisplay_005ftable_0026_005frequestURI_005fname_005fid_005fexport_005fclass.reuse(_jspx_th_display_005ftable_005f0);
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<br/><br/>\r\n");
      out.write("\t\t\t<label class=\"checkbox\">\r\n");
      out.write("\t\t      <input type=\"checkbox\" name=\"chkall\" onClick=\"CheckAll(this.form)\" /> 全选 \r\n");
      out.write("\t\t      &nbsp;<a href=\"javascript:;\" onClick=\"deleteMoreObjs();\" \r\n");
      out.write("\t\t      class=\"btn btn-mini btn-danger\">删除所选</a><br/><br/>\r\n");
      out.write("\t\t    </label>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<script>\r\n");
      out.write("\t\t\tfunction successInfoShow(themsg){\r\n");
      out.write("\t\t\t    $.teninedialog({\r\n");
      out.write("                    title:'系统提示',\r\n");
      out.write("                    content:themsg,\r\n");
      out.write("                    showCloseButton:true,\r\n");
      out.write("                    //otherButtons:[\"确定\",\"取消\"],\r\n");
      out.write("                    //otherButtonStyles:['btn-primary','btn-primary'],\r\n");
      out.write("                    bootstrapModalOption:{keyboard: true},\r\n");
      out.write("                    /*\r\n");
      out.write("                    dialogShow:function(){\r\n");
      out.write("                        alert('即将显示对话框');\r\n");
      out.write("                    },\r\n");
      out.write("                    dialogShown:function(){\r\n");
      out.write("                        alert('显示对话框');\r\n");
      out.write("                    },\r\n");
      out.write("                    dialogHide:function(){\r\n");
      out.write("                        alert('即将关闭对话框');\r\n");
      out.write("                    },\r\n");
      out.write("                    */\r\n");
      out.write("                    dialogHidden:function(){\r\n");
      out.write("                        //alert('关闭对话框');\r\n");
      out.write("                        window.location.reload();\r\n");
      out.write("                    }      \r\n");
      out.write("                    /*            \r\n");
      out.write("                    clickButton:function(sender,modal,index){\r\n");
      out.write("                        alert('选中第'+index+'个按钮：'+sender.html());\r\n");
      out.write("                        $(this).closeDialog(modal);\r\n");
      out.write("                    }\r\n");
      out.write("                    */\r\n");
      out.write("                });\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction validInfoShow(themsg){\r\n");
      out.write("\t\t\t  $('#formValidInfo').html(themsg);\r\n");
      out.write("\t\t\t  $('#formValidInfo').show(200);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction validInfoHide(){\r\n");
      out.write("\t\t\t  $('#formValidInfo').hide(200);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction CheckAll(form){\r\n");
      out.write("\t\t\t  for (var i=0;i<form.elements.length;i++){\r\n");
      out.write("\t\t\t    var e = form.elements[i];\r\n");
      out.write("\t\t\t    if (e.name != 'chkall')\r\n");
      out.write("\t\t\t       e.checked = form.chkall.checked;\r\n");
      out.write("\t\t\t   }\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\tfunction deleteSingleObj(keyId){ \r\n");
      out.write("\t\t\t  validInfoHide();\t\t \r\n");
      out.write("\t\t\t  //ajax调用  \r\n");
      out.write("\t\t\t    $.ajax({    \r\n");
      out.write("\t\t\t        type:'post',        \r\n");
      out.write("\t\t\t        url:'/userJson.do?showType=deleteUser',    \r\n");
      out.write("\t\t\t        data:{userId:keyId}, \r\n");
      out.write("\t\t\t        dataType:'json',\r\n");
      out.write("\t\t\t        cache:false,\r\n");
      out.write("\t\t\t        success:function(data){\r\n");
      out.write("\t\t\t\t        if(data.errmsg==\"ok\"){      \r\n");
      out.write("\t\t\t\t            successInfoShow(\"<i class=\\\"icon-ok\\\"></i> 恭喜您,删除成功!\");\r\n");
      out.write("\t\t\t\t        }else{    \r\n");
      out.write("\t\t\t\t            validInfoShow(data.errmsg); \r\n");
      out.write("\t\t\t\t        }\r\n");
      out.write("\t\t\t\t        \r\n");
      out.write("\t\t\t        },\r\n");
      out.write("\t\t\t        error:function(){\r\n");
      out.write("                       validInfoShow(\"操作失败！\"); \r\n");
      out.write("                    }\r\n");
      out.write("\t\t\t    });    \r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tfunction deleteMoreObjs(){ \r\n");
      out.write("\t\t\t  validInfoHide();\t \r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t          var checkedNum = $(\"input[name='selId']:checked\").length;    \r\n");
      out.write("\t          if(checkedNum == 0) {    \r\n");
      out.write("\t              validInfoShow(\"请至少选择一项！\"); \r\n");
      out.write("\t              return;    \r\n");
      out.write("\t          }\r\n");
      out.write("\t          \r\n");
      out.write("\t          // 批量选择     \r\n");
      out.write("\t          if(confirm(\"确定要删除所选项目？\")) {    \r\n");
      out.write("\t              var checkedList = new Array();    \r\n");
      out.write("\t              $(\"input[name='selId']:checked\").each(function() {    \r\n");
      out.write("\t                  checkedList.push($(this).val());    \r\n");
      out.write("\t              });    \r\n");
      out.write("\t      \t\t  var delvals = checkedList.toString();\r\n");
      out.write("\t      \t\t  //alert(delvals);\r\n");
      out.write("\t              $.ajax({    \r\n");
      out.write("\t                  type: \"POST\",    \r\n");
      out.write("\t                  url: \"/userJson.do?showType=deleteUsers\",    \r\n");
      out.write("\t                  data: {delitems:delvals}, \r\n");
      out.write("\t                  dataType: 'json',\r\n");
      out.write("    \t\t\t\t  async : false, //默认为true 异步   \r\n");
      out.write("\t                  success: function(data){   \r\n");
      out.write("\t                      if(data.errmsg==\"ok\"){      \r\n");
      out.write("\t\t\t\t\t            successInfoShow(\"<i class=\\\"icon-ok\\\"></i> 恭喜您,删除成功!\");\r\n");
      out.write("\t\t\t\t\t        }else{    \r\n");
      out.write("\t\t\t\t\t            validInfoShow(data.errmsg); \r\n");
      out.write("\t\t\t\t\t        }   \r\n");
      out.write("\t                  },\r\n");
      out.write("\t\t\t\t        error:function(){\r\n");
      out.write("\t                       validInfoShow(\"操作失败！\"); \r\n");
      out.write("\t                    }\r\n");
      out.write("\t              });    \r\n");
      out.write("\t          }      \r\n");
      out.write("          }\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</script>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t   <!--/.form-listuser -->\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t   </div><!--/.span10-global-->\r\n");
      out.write("\t   </div><!--/.fluid-row-global-->\r\n");
      out.write("    </div><!--/.fluid-container-global-->\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t <hr>\r\n");
      out.write("\t \r\n");
      out.write("<script src=\"/js/md5.js\"></script>\t\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.bootstrap.teninedialog.min.js\"></script>\r\n");
      out.write("<script src=\"/js/bootstrap.min.js\"></script>\r\n");
      out.write("<!--[if lte IE 6]>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"js/bootstrap-ie.js\"></script>\r\n");
      out.write("<![endif]-->\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write(" <hr>\r\n");
      out.write("    <footer class=\"row\">\r\n");
      out.write("\t\t<p class=\"container\">&copy;2012-2018 Copyright by <small>");
      out.print(company);
      out.write("</small></p>\r\n");
      out.write("\t  </footer>\r\n");
      out.write("\t  \r\n");
      out.write("\t  \r\n");
      out.write("    <!-- Le javascript\r\n");
      out.write("    ================================================== -->\r\n");
      out.write("    <!-- Placed at the end of the document so the pages load faster -->\r\n");
      out.write("\t\r\n");
      out.write("\t");
      out.write("\r\n");
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

  private boolean _jspx_meth_display_005fcolumn_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f0 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_005fcolumn_005f0.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcolumn_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    // /WEB-INF/jsp/user/user_list.jsp(109,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f0.setTitle("选择");
    // /WEB-INF/jsp/user/user_list.jsp(109,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f0.setStyle("width:5%");
    int _jspx_eval_display_005fcolumn_005f0 = _jspx_th_display_005fcolumn_005f0.doStartTag();
    if (_jspx_eval_display_005fcolumn_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_005fcolumn_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_005fcolumn_005f0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_005fcolumn_005f0.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t  <input name=\"selId\" type=\"checkbox\" value=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("\" />\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_display_005fcolumn_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_005fcolumn_005f0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_display_005fcolumn_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle.reuse(_jspx_th_display_005fcolumn_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle.reuse(_jspx_th_display_005fcolumn_005f0);
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f1 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable_005fproperty_005fescapeXml_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_005fcolumn_005f1.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcolumn_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    // /WEB-INF/jsp/user/user_list.jsp(112,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f1.setTitle("用户ID");
    // /WEB-INF/jsp/user/user_list.jsp(112,4) name = property type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f1.setProperty("userId");
    // /WEB-INF/jsp/user/user_list.jsp(112,4) name = sortable type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f1.setSortable(true);
    // /WEB-INF/jsp/user/user_list.jsp(112,4) name = escapeXml type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f1.setEscapeXml(false);
    // /WEB-INF/jsp/user/user_list.jsp(112,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f1.setStyle("width:15%");
    int _jspx_eval_display_005fcolumn_005f1 = _jspx_th_display_005fcolumn_005f1.doStartTag();
    if (_jspx_th_display_005fcolumn_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable_005fproperty_005fescapeXml_005fnobody.reuse(_jspx_th_display_005fcolumn_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fsortable_005fproperty_005fescapeXml_005fnobody.reuse(_jspx_th_display_005fcolumn_005f1);
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f2(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f2 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fescapeXml.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_005fcolumn_005f2.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcolumn_005f2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    // /WEB-INF/jsp/user/user_list.jsp(113,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f2.setTitle("登录账号");
    // /WEB-INF/jsp/user/user_list.jsp(113,4) name = escapeXml type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f2.setEscapeXml(false);
    // /WEB-INF/jsp/user/user_list.jsp(113,4) name = style type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f2.setStyle("width:20%");
    int _jspx_eval_display_005fcolumn_005f2 = _jspx_th_display_005fcolumn_005f2.doStartTag();
    if (_jspx_eval_display_005fcolumn_005f2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_display_005fcolumn_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_th_display_005fcolumn_005f2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_display_005fcolumn_005f2.doInitBody();
      }
      do {
        out.write("\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_005fif_005f0(_jspx_th_display_005fcolumn_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t\r\n");
        out.write("\t\t\t\t");
        if (_jspx_meth_c_005fif_005f1(_jspx_th_display_005fcolumn_005f2, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_display_005fcolumn_005f2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_display_005fcolumn_005f2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.popBody();
      }
    }
    if (_jspx_th_display_005fcolumn_005f2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fescapeXml.reuse(_jspx_th_display_005fcolumn_005f2);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fstyle_005fescapeXml.reuse(_jspx_th_display_005fcolumn_005f2);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005fcolumn_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005fcolumn_005f2);
    // /WEB-INF/jsp/user/user_list.jsp(114,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:contains(list.userFunction,'1001')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t<i class=\"icon-star\"></i> \r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005fcolumn_005f2, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005fcolumn_005f2);
    // /WEB-INF/jsp/user/user_list.jsp(118,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${fn:contains(loginUserFuncs,'1001')}", java.lang.Boolean.class, (PageContext)_jspx_page_context, _jspx_fnmap_0, false)).booleanValue());
    int _jspx_eval_c_005fif_005f1 = _jspx_th_c_005fif_005f1.doStartTag();
    if (_jspx_eval_c_005fif_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\t\t\t\t    <a href=\"/userEdit.do?userId=");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write('"');
        out.write(' ');
        out.write('>');
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.userBH}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write("</a>\r\n");
        out.write("\t\t\t\t    &nbsp;\r\n");
        out.write("\t\t\t\t    <a href=\"javascript:;\" title=\"删除\" onclick=\"if(confirm('确定要删除本条记录?')){deleteSingleObj(");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list.userId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
        out.write(");}\"><i class=\"icon-remove\"></i></a>\r\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f1);
    return false;
  }

  private boolean _jspx_meth_display_005fcolumn_005f3(javax.servlet.jsp.tagext.JspTag _jspx_th_display_005ftable_005f0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  display:column
    org.displaytag.tags.ColumnTag _jspx_th_display_005fcolumn_005f3 = (org.displaytag.tags.ColumnTag) _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fproperty_005fescapeXml_005fnobody.get(org.displaytag.tags.ColumnTag.class);
    _jspx_th_display_005fcolumn_005f3.setPageContext(_jspx_page_context);
    _jspx_th_display_005fcolumn_005f3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_display_005ftable_005f0);
    // /WEB-INF/jsp/user/user_list.jsp(124,4) name = title type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f3.setTitle("用户别名");
    // /WEB-INF/jsp/user/user_list.jsp(124,4) name = property type = java.lang.String reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f3.setProperty("userName");
    // /WEB-INF/jsp/user/user_list.jsp(124,4) name = escapeXml type = boolean reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_display_005fcolumn_005f3.setEscapeXml(false);
    int _jspx_eval_display_005fcolumn_005f3 = _jspx_th_display_005fcolumn_005f3.doStartTag();
    if (_jspx_th_display_005fcolumn_005f3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fproperty_005fescapeXml_005fnobody.reuse(_jspx_th_display_005fcolumn_005f3);
      return true;
    }
    _005fjspx_005ftagPool_005fdisplay_005fcolumn_0026_005ftitle_005fproperty_005fescapeXml_005fnobody.reuse(_jspx_th_display_005fcolumn_005f3);
    return false;
  }
}
