package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;
import java.util.List;
import com.thinkway.LiangxinUtil;
import com.thinkway.cms.business.domains.StorageM;

public final class storageM_005flist_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	int pageNo=LiangxinUtil.getIntValue((String)request.getAttribute("page"));
	int pageNum=(Integer)request.getAttribute("pageNum");
	String lgnum=LiangxinUtil.null2String((String)request.getAttribute("lgnum"));
	String lgpla=LiangxinUtil.null2String((String)request.getAttribute("lgpla"));

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
      out.write("<link href=\"/css/jiuhui_list.css\" rel=\"stylesheet\">\r\n");
      out.write("<script>\r\n");
      out.write("function lastPage(){\r\n");
      out.write("\tvar pageNo=");
      out.print(pageNo);
      out.write(";\r\n");
      out.write("\tvar pageNum=");
      out.print(pageNum);
      out.write(";\r\n");
      out.write("\tif(pageNo==1)return;\r\n");
      out.write("\tdocument.getElementById(\"page\").value=pageNo-1;\r\n");
      out.write("\tdocument.listForm.action=\"/storageMList.do\";\r\n");
      out.write("\tdocument.listForm.submit();\r\n");
      out.write("}\r\n");
      out.write("function nextPage(){\r\n");
      out.write("\tvar pageNo=");
      out.print(pageNo);
      out.write(";\r\n");
      out.write("\tvar pageNum=");
      out.print(pageNum);
      out.write(";\r\n");
      out.write("\tif(pageNo==pageNum)return;\r\n");
      out.write("\tdocument.getElementById(\"page\").value=pageNo+1;\r\n");
      out.write("\tdocument.listForm.action=\"/storageMList.do\";\r\n");
      out.write("\tdocument.listForm.submit();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<div class=\"div\">\r\n");
      out.write("\t<form action=\"/storageMAdd.do\" id=\"listForm\" name=\"listform\" method=\"post\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"page\" id=\"page\" value=\"");
      out.print(pageNo );
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"lgpla\" id=\"lgpla\" value=\"");
      out.print(lgpla );
      out.write("\"/>\r\n");
      out.write("\t<input type=\"hidden\" name=\"lgnum\" id=\"lgnum\" value=\"");
      out.print(lgnum );
      out.write("\"/>\r\n");
      out.write("\t\t");

		List<StorageM> list=(List)request.getAttribute("repList");
		if(list==null){
					
		
      out.write("\r\n");
      out.write("\t\t\t<table style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>没有数据！</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t<input   type=\"button\" style=\"width:40px;\" value=\"返回\" onclick=\"window.location.href='/main.do?two=4';\"/>\r\n");
      out.write("\t\t\t\t\t<input   type=\"button\" style=\"width:40px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t");
return;} 
      out.write("\r\n");
      out.write("\t\t");

		if(list.size()==0){
					
		
      out.write("\r\n");
      out.write("\t\t\t<table style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<td>没有数据！</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t\t\t<input   type=\"button\" style=\"width:40px;\" value=\"返回\" onclick=\"window.location.href='/main.do?two=4';\"/>\r\n");
      out.write("\t\t\t\t\t<input   type=\"button\" style=\"width:40px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t");
	return;} 
      out.write("\r\n");
      out.write("\t\t<table class=\"table_list\" style=\"width:100%\">\r\n");
      out.write("\t\t<tr class=\"tr_list_1\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t<td class=\"td_list\">序号</td>\r\n");
      out.write("\t\t\t<td class=\"td_list\">物料编码</td>\r\n");
      out.write("\t\t\t<td class=\"td_list\">特殊库存</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr_list_1\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t<td class=\"td_list\">选择</td>\r\n");
      out.write("\t\t\t<td class=\"td_list\" colspan=2>物料描述</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr class=\"tr_list_1\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t<td class=\"td_list\">批次</td>\r\n");
      out.write("\t\t\t<td class=\"td_list\">数量</td>\r\n");
      out.write("\t\t\t<td class=\"td_list\">单位</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

		int i=1;
		for(i=1;i<=list.size();i++){
			StorageM pic=(StorageM)list.get(i-1);
		
      out.write("\r\n");
      out.write("\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t<td class=\"td_list\">");
      out.print(pic.getXuhao() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td class=\"td_list\">");
      out.print(LiangxinUtil.null2String(pic.getMatnr()) );
      out.write("</td>\r\n");
      out.write("\t\t\t<td class=\"td_list\">");
      out.print(LiangxinUtil.null2String(pic.getSonum()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t<td class=\"td_list\">\r\n");
      out.write("\t\t\t<input name=\"check\" checked=checked type=\"radio\" value=\"");
      out.print(LiangxinUtil.null2String(pic.getMatnr()) );
      out.write(',');
      out.print(LiangxinUtil.null2String(pic.getSobkz()) );
      out.write(',');
      out.print(LiangxinUtil.null2String(pic.getCharg()) );
      out.write(',');
      out.print(LiangxinUtil.null2String(pic.getGesme()) );
      out.write(',');
      out.print(LiangxinUtil.null2String(pic.getLetyp()) );
      out.write(',');
      out.print(lgpla);
      out.write(',');
      out.print(lgnum);
      out.write(',');
      out.print(LiangxinUtil.null2String(pic.getLgort()) );
      out.write(',');
      out.print(LiangxinUtil.null2String(pic.getWerks()) );
      out.write(',');
      out.print(LiangxinUtil.null2String(pic.getSonum()) );
      out.write(',');
      out.print(LiangxinUtil.null2String(pic.getMeins()) );
      out.write("\" /></td>\r\n");
      out.write("\t\t\t<td class=\"td_list\" colspan=2>");
      out.print(LiangxinUtil.null2String(pic.getMaktx()) );
      out.write("</td>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t<td class=\"td_list\">");
      out.print(LiangxinUtil.null2String(pic.getCharg()) );
      out.write("</td>\r\n");
      out.write("\t\t\t<td class=\"td_list\">");
      out.print(LiangxinUtil.null2String(pic.getGesme()) );
      out.write("</td>\r\n");
      out.write("\t\t\t<td class=\"td_list\">");
      out.print(LiangxinUtil.null2String(pic.getMeins()) );
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t     <tr>\r\n");
      out.write("\t\t\t<td align=\"center\"><input  type=\"button\" class=\"button\" style=\"width:45px;\" value=\"上一页\" onclick=\"lastPage();\"/></td>\r\n");
      out.write("\t\t\t<td align=\"center\">\r\n");
      out.write("\t\t\t<input value=\"确定\" class=\"button\" style=\"width:30px;\" type=\"submit\"/>\r\n");
      out.write("\t\t\t<input   type=\"button\" class=\"button\" style=\"width:30px;\" value=\"返回\" onclick=\"window.location.href='/main.do?two=4';\"/>\r\n");
      out.write("\t\t\t<input   type=\"button\" class=\"button\" style=\"width:30px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td align=\"center\"><input  type=\"button\" class=\"button\" style=\"width:45px;\"  value=\"下一页\" onclick=\"nextPage();\"/></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form>\r\n");
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
