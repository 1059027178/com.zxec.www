package org.apache.jsp.WEB_002dINF.jsp.delordpic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;
import com.thinkway.LiangxinUtil;
import java.util.List;
import com.thinkway.cms.business.domains.DelOrdPic;

public final class delord_005fView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
	String werks=LiangxinUtil.null2String((String)request.getAttribute("werks"));
	String lgort=LiangxinUtil.null2String((String)request.getAttribute("lgort"));
	String wadat=LiangxinUtil.null2String((String)request.getAttribute("wadat"));
	String vbeln=LiangxinUtil.null2String((String)request.getAttribute("vbeln"));

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
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no, target-densitydpi=medium-dpi\" />\r\n");
      out.write("\r\n");
      out.write("<link href=\"/css/jiuhui_list.css\" rel=\"stylesheet\">\r\n");
      out.write("<meta name=\"description\" content=\"");
      out.print(desp);
      out.write("\">\r\n");
      out.write("<meta name=\"company\" content=\"");
      out.print(company);
      out.write("\">\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("</style>\r\n");
      out.write("<!-- Le styles -->\r\n");
      out.write("\r\n");
      out.write("  <script  type=\"text/javascript\">\r\n");
      out.write("  \tfunction fanhui(){\r\n");
      out.write("  \t\tdocument.getElementById(\"page\").value=\"1\";\r\n");
      out.write("  \t\tdocument.listform.submit();\r\n");
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
      out.write("  \t\tdocument.listform.action=\"/delordView.do\";\r\n");
      out.write("  \t\tdocument.listform.submit();\r\n");
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
      out.write("  \t\tdocument.listform.action=\"/delordView.do\";\r\n");
      out.write("  \t\tdocument.listform.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<div class=\"div\" style=\"padding-top:30px;\">\r\n");
      out.write("\t<form  id=\"listForm\" action=\"delordList.do\" name=\"listform\" method=\"get\">\r\n");
      out.write("\t<input type=\"hidden\" id=\"wadat\" name=\"wadat\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${wadat}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" id=\"lgort\" name=\"lgort\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lgort}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" id=\"werks\" name=\"werks\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${werks}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" id=\"vbeln\" name=\"vbeln\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vbeln}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" id=\"page\" name=\"page\" value=\"");
      out.print(pageNo );
      out.write("\"/>\r\n");
      out.write("\t\t");

					List<DelOrdPic> list=(List)request.getAttribute("delordList");
					if(list==null){
					
				
      out.write("\r\n");
      out.write("\t\t\t\t<table style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>没有数据！</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<input  type=\"button\" style=\"width:40px;\" value=\"返回\" onclick=\"fanhui()\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input  type=\"button\" style=\"width:40px;\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t");
	return;} 
      out.write("\r\n");
      out.write("\t\t\t");

					if(list.size()==0){
					
				
      out.write("\r\n");
      out.write("\t\t\t\t<table style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td>没有数据！</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t<input  type=\"button\" style=\"width:40px;\" value=\"返回\" onclick=\"fanhui()\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input  type=\"button\" style=\"width:40px;\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t");
	return;} 
      out.write("\r\n");
      out.write("\t\t\t<table class=\".table_list\" style=\"width:100%\">\r\n");
      out.write("\t\t\t\t<tr bordercolor=\"#000000\" class=\"tr_list_1\">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" rowspan=2>序号</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" height=\"10px\">物料号</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">批次</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">数量</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">已拣配数量</td>\r\n");
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
      out.write("\t\t\t\t\t<td class=\"td_list\" rowspan=2>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(LiangxinUtil.null2String(pic.getXuhao()) );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">\r\n");
      out.write("\t\t\t\t\t");

						if(LiangxinUtil.getDoubleValue(pic.getLfimg())>pic.getRfmng()){
					
      out.write("\r\n");
      out.write("\t\t\t\t\t<a href=\"/matlgpfifoView.do?vbeln=");
      out.print(vbeln );
      out.write("&wadat=");
      out.print(wadat );
      out.write("&lgort=");
      out.print(lgort );
      out.write("&werks=");
      out.print(werks );
      out.write("&matnr=");
      out.print(LiangxinUtil.null2String(pic.getMatnr()) );
      out.write("&posnr=");
      out.print(LiangxinUtil.null2String(pic.getPosnr()) );
      out.write("&lfimg=");
      out.print(pic.getLfimg() );
      out.write("&maktx=");
      out.print(LiangxinUtil.null2String(pic.getMaktx()) );
      out.write("\" >\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(LiangxinUtil.null2String(pic.getMatnr()) );
      out.write("\r\n");
      out.write("\t\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(LiangxinUtil.null2String(pic.getMatnr()) );
      out.write("\r\n");
      out.write("\t\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t\t\t \r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(LiangxinUtil.null2String(pic.getCharg()) );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(LiangxinUtil.null2String(pic.getLfimg()) );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(pic.getRfmng() );
      out.write("\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\" colspan=\"3\">\r\n");
      out.write("\t\t\t\t<input  type=\"button\" style=\"width:50px;\" value=\"上一页\" onclick=\"lastPage();\"/>\r\n");
      out.write("\t\t\t\t<input  type=\"button\" style=\"width:40px;\" value=\"返回\" onclick=\"fanhui()\"></input>\r\n");
      out.write("\t\t\t\t<input  type=\"button\" style=\"width:40px;\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t<input  type=\"button\" style=\"width:50px;\" value=\"下一页\" onclick=\"nextPage();\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\r\n");
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
