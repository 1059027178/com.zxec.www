package org.apache.jsp.WEB_002dINF.jsp.delordpic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;
import java.util.List;
import com.thinkway.LiangxinUtil;
import com.thinkway.cms.business.domains.DelOrdPic;

public final class matlgpfifo_005fView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/delordpic/../include/const.jsp");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	int pageNo=LiangxinUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String vbeln=LiangxinUtil.null2String((String)request.getAttribute("vbeln"));
	String werks=LiangxinUtil.null2String((String)request.getAttribute("werks"));
	String lgort=LiangxinUtil.null2String((String)request.getAttribute("lgort"));
	String wadat=LiangxinUtil.null2String((String)request.getAttribute("wadat"));

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
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("<meta name=\"description\" content=\"");
      out.print(desp);
      out.write("\">\r\n");
      out.write("<meta name=\"company\" content=\"");
      out.print(company);
      out.write("\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"/js/jquery.js\"></script>  \r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-1.10.0.custom.min.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("<script src=\"/js/jquery-ui-bootstrap/assets/js/jquery-ui-datepicker.zh-cn.js\" type=\"text/javascript\"></script>  \r\n");
      out.write("<!-- Le styles -->\r\n");
      out.write("<link href=\"/css/jiuhui_list.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <script  type=\"text/javascript\">\r\n");
      out.write("  \t\r\n");
      out.write("  \tfunction fanhui(){\r\n");
      out.write("  \t\tdocument.thinkway.action=\"/delordView.do\";\r\n");
      out.write("  \t\tdocument.getElementById(\"page\").value=\"1\";\r\n");
      out.write("  \t\tdocument.thinkway.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction lastPage(){\r\n");
      out.write("  \t\tvar pageNo=");
      out.print(pageNo);
      out.write(";\r\n");
      out.write("  \t\tvar pageNum=");
      out.print(pageNum);
      out.write(";\r\n");
      out.write("  \t\tif(pageNo==1)return;\r\n");
      out.write("  \t\tdocument.getElementById(\"page\").value=pageNo-1;\r\n");
      out.write("  \t\tdocument.thinkway.action=\"/matlgpfifoView.do\";\r\n");
      out.write("  \t\tdocument.thinkway.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction nextPage(){\r\n");
      out.write("  \t\tvar pageNo=");
      out.print(pageNo);
      out.write(";\r\n");
      out.write("  \t\tvar pageNum=");
      out.print(pageNum);
      out.write(";\r\n");
      out.write("  \t\tif(pageNo==pageNum)return;\r\n");
      out.write("  \t\tdocument.getElementById(\"page\").value=pageNo+1;\r\n");
      out.write("  \t\tdocument.thinkway.action=\"/matlgpfifoView.do\";\r\n");
      out.write("  \t\tdocument.thinkway.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction validateForm(){\r\n");
      out.write("  \t\t var lonstr=$(\"#str\").val();\r\n");
      out.write("  \t\t var str=lonstr.split(\"/\");\r\n");
      out.write("  \t\t if(str.length<=0){\r\n");
      out.write("  \t\t \talert(\"请扫描物料卡\");\r\n");
      out.write("  \t\t \treturn;\r\n");
      out.write("  \t\t }\r\n");
      out.write("  \t\t var matnr=str[1];\r\n");
      out.write("\t  \t\t\r\n");
      out.write("\t  \t var sonum=str[6];\r\n");
      out.write("\t  \t \r\n");
      out.write("\t  \t var mat=document.getElementById(\"matnr\").value\r\n");
      out.write("\t  \t \r\n");
      out.write("\t  \t if(matnr!=mat){\r\n");
      out.write("\t  \t \talert(\"物料不匹配！\");\r\n");
      out.write("\t  \t \treturn;\r\n");
      out.write("\t  \t }\r\n");
      out.write("\t  \t if(sonum==null || sonum=='')sonum='-1';\r\n");
      out.write("  \t\t var xuhao=document.getElementById(\"maxxuhao\").value;\r\n");
      out.write("  \t\t var sfyz=false;\r\n");
      out.write("  \t\t var shuliang=parseFloat(document.getElementById(\"shuliang\").value);\r\n");
      out.write("  \t\t var leiji=0;\r\n");
      out.write("  \t\t for(var i=1;i<xuhao;i++){\r\n");
      out.write("  \t\t \t\r\n");
      out.write("  \t\t \t//if(i=='1'){\r\n");
      out.write("  \t\t \t//\tbreak;\r\n");
      out.write("  \t\t \t//}\r\n");
      out.write("  \t\t \tvar sl1=parseFloat(document.getElementById(i).value);\r\n");
      out.write("  \t\t \tvar sl2=parseFloat(document.getElementById('verme_'+i).value);\r\n");
      out.write("  \t\t \tvar lgnum=document.getElementById('lgnum'+i).value;\r\n");
      out.write("  \t\t \tvar active=document.getElementById('active'+i).value;\r\n");
      out.write("\t  \t\tif(document.getElementById(i).value==null || document.getElementById(i).value=='')sl1=0;\r\n");
      out.write("\t  \t\tif(document.getElementById('verme_'+i).value==null || document.getElementById('verme_'+i).value=='')sl2=0;\r\n");
      out.write("\t \t\t\tif(active!='X'&&sl1!=0){\r\n");
      out.write("\t \t\t\talert(\"请选择最小批次库存\");\r\n");
      out.write("  \t\t \t\treturn;\r\n");
      out.write("\t \t\t}\r\n");
      out.write("  \t\t \tif(sl1>sl2){\r\n");
      out.write("  \t\t \t\talert(\"第\"+i+\"行，选择数量大于仓位数量，请重新选择数值！\");\r\n");
      out.write("  \t\t \t\treturn;\r\n");
      out.write("  \t\t \t}\r\n");
      out.write("  \t\t \tleiji+=sl1;\r\n");
      out.write("  \t\t \tif(document.getElementById(i).value!=''){\r\n");
      out.write("  \t\t \t\tsfyz=true;\r\n");
      out.write("  \t\t \t\t//break;\r\n");
      out.write("  \t\t \t}\r\n");
      out.write("  \t\t \tif(lgnum==null||lgnum=='')lgnum='-1';\r\n");
      out.write("  \t\t \tif(sonum!=lgnum){\r\n");
      out.write("  \t\t \t\talert(\"第\"+i+\"行特殊库存不一致，请检查！\");\r\n");
      out.write("  \t\t \t\treturn;\r\n");
      out.write("  \t\t \t}\r\n");
      out.write("  \t\t \t\r\n");
      out.write("  \t\t }\r\n");
      out.write("  \t\t \r\n");
      out.write("  \t\t if(leiji>shuliang){\r\n");
      out.write("  \t\t \talert(\"以选择数量大于需求数量，请重新选择\");\r\n");
      out.write("  \t\t \treturn;\r\n");
      out.write("  \t\t }\r\n");
      out.write("  \t\t \r\n");
      out.write("  \t\t if(!sfyz){\r\n");
      out.write("  \t\t \talert(\"选择数量一个都没有填写\");\r\n");
      out.write("  \t\t \treturn false;\r\n");
      out.write("  \t\t }else{\r\n");
      out.write("  \t\t \tdocument.thinkway.action=\"/delordpicAdd.do\";\r\n");
      out.write("  \t\t \tdocument.thinkway.submit();\r\n");
      out.write("  \t\t }\r\n");
      out.write("  \t}\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<div class=\"div\">\r\n");
      out.write("\t<form  id=\"thinkway\" name=\"thinkway\" method=\"post\"  action=\"/delordpicAdd.do\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"page\" id=\"page\" value=\"");
      out.print(pageNo );
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"vbeln\" id=\"vbeln\" value=\"");
      out.print(vbeln );
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"werks\" id=\"werks\" value=\"");
      out.print(werks );
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"lgort\" id=\"lgort\" value=\"");
      out.print(lgort );
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"wadat\" id=\"wadat\" value=\"");
      out.print(wadat );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t");

					List<DelOrdPic> list=(List)request.getAttribute("delordList");
					if(list==null){
					
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<table style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">没有数据！</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\" >\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" style=\"width:50px;height=20%\" value=\"返回\" onclick=\"fanhui();\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input  class=button type=\"button\" style=\"width:50px;heigth=20%\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t");
	return;} 
      out.write("\r\n");
      out.write("\t\t\t");

					//List<DelOrdPic> list=(List)request.getAttribute("delordList");
					if(list.size()==0){
					
				
      out.write("\r\n");
      out.write("\t\t\t\t<table style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t\t<colgroup>\r\n");
      out.write("\t\t\t\t\t\t<col width=\"30%\"/>\r\n");
      out.write("\t\t\t\t\t\t<col width=\"30%\"/>\r\n");
      out.write("\t\t\t\t\t\t<col width=\"30%\"/>\r\n");
      out.write("\t\t\t\t\t</colgroup>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">没有数据！</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\" colspan=2>\t\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" style=\"width:50px;heigth=20%\" value=\"返回\" onclick=\"fanhui();\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input  class=button type=\"button\" style=\"width:50px;heigth=20%\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t");
	return;} 
      out.write("\r\n");
      out.write("\t\t\t<table class=\"table_list\" style=\"width:100%\">\r\n");
      out.write("\t\t\t\t<tr  class=\"tr_list_1\">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" align=\"center\" colspan=3><input name=\"str\" style=\"height:15px;\" type=\"text\" style=\"white-space：nowrap;width:70%;\"  id=\"str\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">物料编码:</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" colspan=2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${delord.matnr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">物料描述:</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" colspan=2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${delord.maktx}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">需求数量:</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" colspan=2>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${verme}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"matnr\" id=\"matnr\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${delord.matnr}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"shuliang\" id=\"shuliang\"   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${verme}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"vbeln\" style=\"width:70%\"  id=\"vbeln\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${delord.vbeln}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"posnr\" style=\"width:70%\"  id=\"posnr\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${delord.posnr }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"maktx\" style=\"width:70%\"  id=\"maktx\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${delord.maktx }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"matnr\" style=\"width:70%\"  id=\"matnr\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${delord.matnr }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"wadat\" style=\"width:70%\"  id=\"wadat\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wadat }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"lgort\" style=\"width:70%\"  id=\"lgort\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lgort }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"hidden\" name=\"werks\" style=\"width:70%\"  id=\"werks\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${werks }", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" style=\"width:30%;\">拣配标记</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">仓位</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">批次</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">数量</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">选择数量</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">特殊库存</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t");

				int i=1;
				for(i=1;i<=list.size();i++){
					DelOrdPic pic=(DelOrdPic)list.get(i-1);
			
      out.write("\r\n");
      out.write("\t\t\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" style=\"height:15px;\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(pic.getActive() );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(pic.getLgpla() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t <input type=\"hidden\" name=\"lgpla");
      out.print(i );
      out.write("\" style=\"width:70%\"  id=\"lgpla");
      out.print(i );
      out.write("\" value=\"");
      out.print(pic.getLgpla() );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t    <input type=\"hidden\" name=\"plpos");
      out.print(i );
      out.write("\" style=\"width:70%\"  id=\"plpos");
      out.print(i );
      out.write("\" value=\"");
      out.print(pic.getPlpos() );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t    <input type=\"hidden\" name=\"meins");
      out.print(i );
      out.write("\" style=\"width:70%\"  id=\"meins");
      out.print(i );
      out.write("\" value=\"");
      out.print(pic.getMeins() );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t    <input type=\"hidden\" name=\"active");
      out.print(i );
      out.write("\" style=\"width:70%\"  id=\"active");
      out.print(i );
      out.write("\" value=\"");
      out.print(pic.getActive() );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(pic.getCharg());
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"charg");
      out.print(i );
      out.write("\" style=\"width:70%\"  id=\"charg");
      out.print(i );
      out.write("\" value=\"");
      out.print(pic.getCharg() );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" style=\"height:15px;\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(pic.getVerme() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"verme_");
      out.print(i );
      out.write("\" id=\"verme_");
      out.print(i );
      out.write("\" value=\"");
      out.print(pic.getVerme() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">\r\n");
      out.write("\t\t\t\t\t\t<input name=\"");
      out.print(i );
      out.write("\" type=\"text\" style=\"width:70%;height:14px;\" class=\"input1\"  id=\"");
      out.print(i );
      out.write("\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(pic.getLgnum() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"lgnum");
      out.print(i );
      out.write("\"   id=\"lgnum");
      out.print(i );
      out.write("\"  value=\"");
      out.print(pic.getLgnum() );
      out.write("\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\"  colspan=\"3\"><input type=\"button\" style=\"width:40px;\" onclick=\"lastPage()\" value=\"上一页\">\t<input type=\"hidden\" name=\"maxxuhao\" id=\"maxxuhao\" value=\"");
      out.print(i );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" style=\"width:30px;\" onclick=\"validateForm()\" value=\"保存\"></input>\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" style=\"width:30px;\" value=\"返回\" onclick=\"fanhui();\"></input>\r\n");
      out.write("\t\t\t\t\t<input  class=button type=\"button\" style=\"width:30px;\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" style=\"width:40px;\" onclick=\"nextPage()\" value=\"下一页\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("</div>\r\n");
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
