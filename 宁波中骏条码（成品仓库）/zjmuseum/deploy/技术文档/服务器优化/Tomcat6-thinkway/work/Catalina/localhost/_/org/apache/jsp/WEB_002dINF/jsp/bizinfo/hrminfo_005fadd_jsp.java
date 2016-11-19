package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;

public final class hrminfo_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(5);
    _jspx_dependants.add("/WEB-INF/jsp/bizinfo/../include/const.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/bizinfo/../include/header.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/bizinfo/../include/lefter.jsp");
    _jspx_dependants.add("/WEB-INF/jsp/bizinfo/../include/footer.jsp");
    _jspx_dependants.add("/WEB-INF/classes/com/thinkway/cms/presentation/web/tag/qhcms.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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
      out.write("    body {\r\n");
      out.write("      padding-top: 60px;\r\n");
      out.write("      padding-bottom: 40px;\r\n");
      out.write("    }\r\n");
      out.write("    .sidebar-nav {\r\n");
      out.write("      padding: 0;\r\n");
      out.write("    }\r\n");
      out.write("  </style>\r\n");
      out.write("  \r\n");
      out.write("  \r\n");
      out.write("<link href=\"/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write(" <!--[if lte IE 6]>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/bootstrap-ie6.css\">\r\n");
      out.write("  <![endif]-->\r\n");
      out.write("  <!--[if lte IE 7]>\r\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/ie.css\">\r\n");
      out.write("  <![endif]--> \r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("<script src=\"/js/jquery.js\"></script>\r\n");
      out.write("<script src=\"/js/formValidation/formValidator-4.1.1.js\" type=\"text/javascript\" charset=\"UTF-8\"></script>\r\n");
      out.write("<script src=\"/js/formValidation/formValidatorRegex.js\" type=\"text/javascript\" charset=\"UTF-8\"></script>\r\n");
      out.write("\r\n");
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
      out.write("<link href=\"/css/displaytag-fix.css\" rel=\"stylesheet\">\r\n");
      out.write("<script>\r\n");
      out.write("\t$(document).ready(function(){\t  \r\n");
      out.write("\t\t$.formValidator.initConfig({theme:\"Default\",formID:\"hrminfoForm\",debug:false,submitOnce:false,wideword:true,\r\n");
      out.write("\t\t\tonerror:function(msg,obj,errorlist){\r\n");
      out.write("\t\t\t\tvalidInfoShow(msg);\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\tajaxForm:{\r\n");
      out.write("\t\t\t\ttype:'post',        \r\n");
      out.write("\t\t        url:'/hrminfoJson.do?showType=createhrminfo',\r\n");
      out.write("\t\t        data:null,\r\n");
      out.write("\t\t        dataType:'json',\r\n");
      out.write("\t\t        cache:false, \r\n");
      out.write("\t\t        success:function(data){         \r\n");
      out.write("\t\t        \talert(data);   \r\n");
      out.write("\t\t\t        if(data.hrminfoId){      \r\n");
      out.write("\t\t\t            successInfoShow(\"<i class=\\\"icon-ok\\\"></i> 恭喜您，创建成功！\");\t\r\n");
      out.write("\t\t\t        }else{    \r\n");
      out.write("\t\t\t            validInfoShow(data.errmsg); \r\n");
      out.write("\t\t\t        }       \r\n");
      out.write("\t\t\t        \r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        error:function(){       \r\n");
      out.write("\t\t\t       validInfoShow(\"发生调用异常!\");\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t//$(\"#hrminfoBH\").formValidator({onShow:\"请输入人员信息登录名\",onFocus:\"人员信息登录名至少1个字符,最多10个字符\"}).inputValidator({min:1,max:20,onError:\"您输入的人员信息名不合法,请确认\"}).defaultPassed();\r\n");
      out.write("\t\t//$(\"#hrminfoName\").formValidator({onShow:\"请输入真实姓名\",onFocus:\"真实姓名至少1个字符,最多10个字符\"}).inputValidator({min:1,max:10,onError:\"您输入的真实姓名不合法,请确认\"}).defaultPassed();\r\n");
      out.write("\t\t//$(\"#inputPassword\").formValidator({onShow:\"请输入密码\",onFocus:\"至少1个长度\",onCorrect:\"密码合法\"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:\"密码两边不能有空符号\"},onError:\"密码不能为空,请确认\"});\r\n");
      out.write("\t\t//$(\"#inputPasswordAg\").formValidator({onShow:\"输再次输入密码\",onFocus:\"至少1个长度\",onCorrect:\"密码一致\"}).inputValidator({min:1,empty:{leftEmpty:false,rightEmpty:false,emptyError:\"重复密码两边不能有空符号\"},onError:\"重复密码不能为空,请确认\"}).compareValidator({desID:\"inputPassword\",operateor:\"=\",onError:\"2次密码不一致,请确认\"});\r\n");
      out.write("\t\t//$(\"#hrminfoFunction\").formValidator({onShow:\"请输入权限字符串\",onFocus:\"1000-表示普通人员信息,1001-表示管理员,中间用半角逗号隔开\"}).inputValidator({min:4,max:120,onError:\"您输入的权限字符串不合法\"}).defaultPassed();\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\tfunction validInfoHide(){\r\n");
      out.write("\t  $('#formValidInfo').hide(200);\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
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
      out.write("\t\t\t  <li><a href=\"/hrminfoList.do\">人员信息管理</a>  <span class=\"divider\">/</span> </li>\r\n");
      out.write("\t\t\t  <li>新建人员信息 </li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t  </div>\t\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <!--/.当前位置导航-->\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t    <!--.warninfo-->\r\n");
      out.write("\t\t    \r\n");
      out.write("\t\t  <div class=\"alert alert-block\" style=\"padding:5px;\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t <a rel=\"popover\" id=\"helpchatter\" class=\"badge badge-warning\"  data-content=\"请保管好您的密码，使用完毕后请退出系统。\" rel=\"popover\" href=\"#\">i</a>\r\n");
      out.write("\t\t<span style=\"padding-left:10px;\"> ");
      out.print(warnmsg1);
      out.write("</span>\r\n");
      out.write("         \r\n");
      out.write("         </div>\t\r\n");
      out.write("\t\t  <!--/.warninfo -->\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t  <!--.form-hrminfoProfile -->\r\n");
      out.write("\t\t  <div id=\"formValidInfo\" class=\"alert alert-error\" style=\"display:none;\">\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\r\n");
      out.write("\t\t  <form class=\"form-horizontal\" id=\"hrminfoForm\">\r\n");
      out.write("\t\t  \r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"\"><font color=red>*</font>&nbsp;工号</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"span3\"><input type=\"text\" name=\"objno\" id=\"objno\" placeholder=\"工号\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"objnoTip\" class=\"span4\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"\"><font color=red>*</font>&nbsp;姓名</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"span3\"><input type=\"text\" name=\"name\" id=\"name\" placeholder=\"姓名\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"nameTip\" class=\"span4\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"\"><font color=red>*</font>&nbsp;部门</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"span3\"><input type=\"text\" name=\"department\" id=\"department\" placeholder=\"部门\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"departmentTip\" class=\"span4\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"\"><font color=red>*</font>&nbsp;性别</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t<div class=\"span3\"><select name=\"sex\" id=\"sex\" >\r\n");
      out.write("\t\t\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write(" \r\n");
      out.write("\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div id=\"sexTip\" class=\"span4\"></div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  \r\n");
      out.write("\t\t\t  <div class=\"control-group\">\r\n");
      out.write("\t\t\t  <label class=\"control-label\" for=\"\"></label>\r\n");
      out.write("\t\t\t    <div class=\"controls\">\r\n");
      out.write("\t\t\t      <button type=\"button\" id=\"submitBtn\" class=\"btn btn-primary\" onclick=\"save();\">提交保存</button>\t\t\t       \r\n");
      out.write("\t\t\t    </div>\r\n");
      out.write("\t\t\t   \r\n");
      out.write("\t\t\t  </div>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t   <!--/.form-hrminfoProfile -->\r\n");
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
      out.write("<script  langth=\"javascript\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("function save(){\r\n");
      out.write("\t\tvar objno= $('#objno').val();\r\n");
      out.write("\t\tvar name= $('#name').val();\r\n");
      out.write("\t\tvar department= $('#department').val();\r\n");
      out.write("\t\tvar sex= $('#sex').val();\r\n");
      out.write("\t\t\tjQuery.ajax({\r\n");
      out.write("\t\t\t\ttype:'post',        \r\n");
      out.write("\t\t        url:'/hrminfoJson.do?showType=createhrminfo',\r\n");
      out.write("\t\t        contentType:\"application/x-www-form-urlencoded; charset=utf-8\",\r\n");
      out.write("\t\t        data:{\"objno\":objno,\"name\":name,\"department\":department,\"sex\":sex},\r\n");
      out.write("\t\t        dataType:'json',\r\n");
      out.write("\t\t         success:function(data){    \r\n");
      out.write("\t\t\t          if(data.hrminfoId){      \r\n");
      out.write("\t\t\t\t           alert(\" 恭喜您，创建成功\");\t\r\n");
      out.write("\t\t\t\t        }else{    \r\n");
      out.write("\t\t\t\t           alert(data.errmsg);     \r\n");
      out.write("\t\t\t\t        }       \r\n");
      out.write("\t\t         \t\r\n");
      out.write("\t\t        },\r\n");
      out.write("\t\t        error:function(){       \r\n");
      out.write("\t\t\t       validInfoShow(\"发生调用异常!\");\r\n");
      out.write("\t\t\t    }\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/jsp/bizinfo/hrminfo_add.jsp(174,4) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("iter");
    // /WEB-INF/jsp/bizinfo/hrminfo_add.jsp(174,4) name = items type = java.lang.Object reqTime = true required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sexList}", java.lang.Object.class, (PageContext)_jspx_page_context, null, false));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("\t\t\t\t\t <option value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${iter.sexId}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write('"');
          out.write('>');
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${iter.sexName}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
          out.write("</option>\r\n");
          out.write("\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
