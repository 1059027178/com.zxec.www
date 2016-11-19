package org.apache.jsp.WEB_002dINF.jsp.delivery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;
import java.util.List;
import com.thinkway.LiangxinUtil;
import com.thinkway.cms.business.domains.Delivery;

public final class delivery_005fView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/WEB-INF/jsp/delivery/../include/const.jsp");
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
      out.write("<LINK href=\"/css/jiuhui_list.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("  <script  type=\"text/javascript\">\r\n");
      out.write("  \tfunction guoz(){ \r\n");
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
      out.write("  \t\tdocument.listForm.action=\"/deliveryView.do\";\r\n");
      out.write("  \t\tdocument.listForm.submit();\r\n");
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
      out.write("  \t\tdocument.listForm.action=\"/deliveryView.do\";\r\n");
      out.write("  \t\tdocument.listForm.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  </script>\r\n");
      out.write("\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("\t<form  id=\"listForm\" name=\"listform\" method=\"post\" action=\"/deliveryCrt.do\">\r\n");
      out.write("\t<input type=\"hidden\" id=\"vbeln\" name=\"vbeln\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vbeln}", java.lang.String.class, (PageContext)_jspx_page_context, null, false));
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" id=\"page\" name=\"page\" value=\"");
      out.print(pageNo );
      out.write("\"/>\r\n");
      out.write("\t<div class=\"div\">\r\n");
      out.write("\t\t");

					List<Delivery> list=(List)request.getAttribute("deliveryList");
					if(list==null){
					
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<table style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">没有数据！</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\" colspan=2>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" style=\"width:40px;\"  align=\"center\" value=\"返回\" onclick=\"window.location.href='/deliveryAdd.do';\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input  type=\"button\" style=\"width:40px;\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
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
      out.write("\t\t\t\t\t\t<col width=\"50%\"/>\r\n");
      out.write("\t\t\t\t\t\t<col width=\"50%\"/>\r\n");
      out.write("\t\t\t\t\t</colgroup>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">没有数据！</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td align=\"center\" colspan=2>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"button\" style=\"width:40px;heigth=20%\"  align=\"center\" value=\"返回\" onclick=\"window.location.href='/deliveryAdd.do';\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t\t<input  type=\"button\" style=\"width:40px;\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t");
	return;} 
      out.write("\r\n");
      out.write("\t\t\t<table class=\"table_list\" style=\"width:100%\">\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">物料</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">数量</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">单位</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" colspan=3>物料描述</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

				int i=1;
				for(i=1;i<=list.size();i++){
					Delivery pic=(Delivery)list.get(i-1);
			
      out.write("\r\n");
      out.write("\t\t\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">");
      out.print(pic.getMatnr() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">");
      out.print(pic.getLfimg() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">");
      out.print(pic.getVrmke() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" colspan=3>");
      out.print(pic.getMaktx() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(">\r\n");
      out.write("\t\t\t\t<td colspan=3>\r\n");
      out.write("\t\t\t\t\t<input  type=\"button\" style=\"width:50px;\" value=\"上一页\" onclick=\"lastPage();\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" style=\"width:30px;\" class=\"button\" align=\"center\" value=\"过账\" onclick=\"guoz();\"></input>\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" style=\"width:30px;\"  align=\"center\" class=\"button\" value=\"返回\" onclick=\"window.location.href='/deliveryAdd.do';\"></input>\r\n");
      out.write("\t\t\t\t\t<input  type=\"button\" style=\"width:30px;\"  onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t<input  type=\"button\" style=\"width:50px;\"  value=\"下一页\" onclick=\"nextPage();\"/></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</form>\r\n");
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
