package org.apache.jsp.WEB_002dINF.jsp.bizinfo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.ErrorConstants;
import com.thinkway.cms.util.Token;
import java.util.List;
import com.thinkway.LiangxinUtil;
import com.thinkway.cms.business.domains.Dump;

public final class dumpradio1_005fList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
			String matnr = LiangxinUtil.null2String((String)request.getAttribute("matnr"));//物料编码
			String charg = LiangxinUtil.null2String((String)request.getAttribute("charg"));//批次号
			String sobkz = LiangxinUtil.null2String((String)request.getAttribute("sobkz"));//特殊库存标识
			String lgort = LiangxinUtil.null2String((String)request.getAttribute("lgort"));//库存地点
			String sonum = LiangxinUtil.null2String((String)request.getAttribute("sonum"));
			String radio = LiangxinUtil.null2String((String)request.getAttribute("radio"));
			String lgnum = LiangxinUtil.null2String((String)request.getAttribute("lgnum"));//仓库号/混合仓库
			String lgpla = LiangxinUtil.null2String((String)request.getAttribute("lgpla"));//仓位
			String maktx = LiangxinUtil.null2String((String)request.getAttribute("maktx"));
			String werks = LiangxinUtil.null2String((String)request.getAttribute("werks"));
			String meins = LiangxinUtil.null2String((String)request.getAttribute("meins"));
		 
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
      out.write("<LINK href=\"/css/jiuhui_list.css\" type=text/css rel=STYLESHEET>\r\n");
      out.write("  <script  type=\"text/javascript\">\r\n");
      out.write("  \tfunction fanhui(){\r\n");
      out.write("  \t\tdocument.thinkway.action=\"/delordView.do\";\r\n");
      out.write("  \t\tdocument.thinkway.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  \tfunction validateForm(){\r\n");
      out.write("  \t\t var xuhao=document.getElementById(\"maxxuhao\").value;\r\n");
      out.write("  \t\t var sfyz=false;\r\n");
      out.write("  \t\t\t var leiji=0;\r\n");
      out.write("  \t\t for(var i=1;i<=xuhao;i++){\r\n");
      out.write("  \t\t \t\r\n");
      out.write("  \t\t \t//if(i=='1'){\r\n");
      out.write("  \t\t \t//\tbreak;\r\n");
      out.write("  \t\t \t//}\r\n");
      out.write("  \t\t \tvar sl1=parseFloat(document.getElementById(i).value);\r\n");
      out.write("  \t\t \tvar sl2=parseFloat(document.getElementById('verme_'+i).value);\r\n");
      out.write("\t  \t\tif(document.getElementById(i).value==null || document.getElementById(i).value=='')sl1=0;\r\n");
      out.write("\t  \t\tif(document.getElementById('verme_'+i).value==null || document.getElementById('verme_'+i).value=='')sl2=0;\r\n");
      out.write("\t \r\n");
      out.write("  \t\t \tif(sl1>sl2){\r\n");
      out.write("  \t\t \t\talert(\"第\"+i+\"行，下架数量大于仓位数量，请重新选择数值！\");\r\n");
      out.write("  \t\t \t\treturn false;\r\n");
      out.write("  \t\t \t}\r\n");
      out.write("  \t\t \tleiji+=sl1;\r\n");
      out.write("  \t\t \tif(document.getElementById(i).value!=''){\r\n");
      out.write("  \t\t \t\tsfyz=true;\r\n");
      out.write("  \t\t \t\t//break;\r\n");
      out.write("  \t\t \t}\r\n");
      out.write("  \t\t \t\r\n");
      out.write("  \t\t }\r\n");
      out.write("  \r\n");
      out.write("  \t\t if(!sfyz){\r\n");
      out.write("  \t\t \talert(\"请填写下架数量\");\r\n");
      out.write("  \t\t \treturn false;\r\n");
      out.write("  \t\t }else{\r\n");
      out.write("  \t\t \treturn true;\r\n");
      out.write("  \t\t }\r\n");
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
      out.write("  \t\tdocument.thinkway.action=\"/dumpCheck.do\";\r\n");
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
      out.write("  \t\tdocument.thinkway.action=\"/dumpCheck.do\";\r\n");
      out.write("  \t\tdocument.thinkway.submit();\r\n");
      out.write("  \t}\r\n");
      out.write("  </script>\r\n");
      out.write("<link type=\"text/css\" href=\"/css/jiuhui_list.css\" rel=\"stylesheet\" />\r\n");
      out.write("\r\n");
      out.write("</HEAD>\r\n");
      out.write("<BODY>\r\n");
      out.write("<div class=\"div\">\r\n");
      out.write("\t<form  id=\"thinkway\" name=\"thinkway\" method=\"post\"  action=\"/dumpAdd.do\">\r\n");
      out.write("\t\t\t\t <input type=\"hidden\" name=\"pageNo\" style=\"width:70%\"  id=\"pageNo\" value=\"");
      out.print(pageNo);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"pageNum\" style=\"width:70%\"  id=\"pageNum\" value=\"");
      out.print(pageNum);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"matnr\" style=\"width:70%\"  id=\"matnr\" value=\"");
      out.print(matnr);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t <input type=\"hidden\" name=\"maktx\" style=\"width:70%\"  id=\"maktx\" value=\"");
      out.print(maktx);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"matnr\" style=\"width:70%\"  id=\"matnr\" value=\"");
      out.print(matnr);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"charg\" style=\"width:70%\"  id=\"charg\" value=\"");
      out.print(charg);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"sonum\" style=\"width:70%\"  id=\"sonum\" value=\"");
      out.print(sonum);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"sobkz\" style=\"width:70%\"  id=\"sobkz\" value=\"");
      out.print(sobkz);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"lgort\" style=\"width:70%\"  id=\"lgort\" value=\"");
      out.print(lgort);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"sonum\" style=\"width:70%\"  id=\"sonum\" value=\"");
      out.print(sonum);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"werks\" style=\"width:70%\"  id=\"werks\" value=\"");
      out.print(werks);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"meins\" style=\"width:70%\"  id=\"meins\" value=\"");
      out.print(meins);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"lgnum\" style=\"width:70%\"  id=\"lgnum\" value=\"");
      out.print(lgnum);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"lgpla\" style=\"width:70%\"  id=\"lgpla\" value=\"");
      out.print(lgpla);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"page\" style=\"width:70%\"  id=\"page\" value=\"");
      out.print(pageNum);
      out.write("\"/>\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"radio\" id=\"radio\" value=\"1\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t");

					List<Dump> list=(List)request.getAttribute("repList");
					if(list==null){
			
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<table style=\"width:100%;\">\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t<td colspan=\"2\">没有数据！</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td align=\"center\" >\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" style=\"width:40px;heigth=25px\" value=\"返回\" onclick=\"window.location.href='/dumpView.do';\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" style=\"width:40px;height:25px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t");
	return;} 
      out.write("\r\n");
      out.write("\t\t\t");
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
      out.write("\t\t\t\t\t\t<td align=\"center\" >\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" style=\"width:40px;heigth:25px;\" value=\"返回\" onclick=\"window.location.href='/dumpView.do';\"></input>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"button\" style=\"width:40px;height:25px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t");
	return;} 
      out.write("\r\n");
      out.write("\t\t\t<table class=\"table_list\" style=\"width:100%\">\r\n");
      out.write("\t\t\t<colgroup>\r\n");
      out.write("\t\t\t\t\t\t<col width=\"25%\"/>\r\n");
      out.write("\t\t\t\t\t\t<col />\r\n");
      out.write("\t\t\t\t\t\t<col width=\"25%\"/>\r\n");
      out.write("\t\t\t\t\t</colgroup>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_2\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t\t<td class=\"td_list\" >物料编码</td>\r\n");
      out.write("\t\t\t\t\t\t<td  class=\"td_list\" colspan=\"2\">");
      out.print(matnr);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"tr_list_2\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t\t<td class=\"td_list\" >物料描述</td>\r\n");
      out.write("\t\t\t\t\t\t<td  class=\"td_list\" colspan=\"2\">");
      out.print(maktx);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t<tr class=\"tr_list_2\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t\t<td  class=\"td_list\" >特殊库存</td>\r\n");
      out.write("\t\t\t\t\t\t<td  class=\"td_list\" colspan=\"2\">");
      out.print(sonum);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">序号</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" >仓位</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">批次</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr class=\"tr_list_1\" bordercolor=\"#000000\" >\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">仓位数量</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" >下架数量</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">单位</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t");

				int i=1;
				for(i=1;i<=list.size();i++){
					Dump lgp=(Dump)list.get(i-1);
			
      out.write("\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" name=\"vltyp");
      out.print(i );
      out.write("\" id=\"vltyp");
      out.print(i );
      out.write("\" value=\"");
      out.print(lgp.getLgtyp() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">");
      out.print(lgp.getXuhao() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" >");
      out.print(lgp.getLgpla() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"vlpla");
      out.print(i );
      out.write("\" id=\"vlpla");
      out.print(i );
      out.write("\" value=\"");
      out.print(lgp.getLgpla() );
      out.write("\">\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">");
      out.print(lgp.getCharg() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr ");
 if(i%2==1){ 
      out.write("class=\"tr_list_2\"");
}else{ 
      out.write("class=\"tr_list_1\"");
} 
      out.write(">\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">");
      out.print(lgp.getVerme() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"verme_");
      out.print(i );
      out.write("\" id=\"verme_");
      out.print(i );
      out.write("\" value=\"");
      out.print(lgp.getVerme() );
      out.write("\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\" >\r\n");
      out.write("\t\t\t\t\t\t<input name=\"");
      out.print(i );
      out.write("\" style=\"width:70%\"  id=\"");
      out.print(i );
      out.write("\" value=\"\" />\r\n");
      out.write("\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t<td class=\"td_list\">");
      out.print(lgp.getMeins() );
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t <input type=\"hidden\" name=\"meins");
      out.print(i );
      out.write("\" style=\"width:70%\"  id=\"meins");
      out.print(i );
      out.write("\" value=\"");
      out.print(lgp.getMeins() );
      out.write("\" />\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t<tr ><input type =\"hidden\" name=\"maxxuhao\" id=\"maxxuhao\" value=\"");
      out.print(i-1 );
      out.write("\"/>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<td colspan=\"3\">\r\n");
      out.write("\t\t\t\t\t<input  type=\"button\" class=\"button\" style=\"width:45px;\" value=\"上一页\" onclick=\"lastPage();\"/>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" style=\"width:30px;\" onclick=\"return validateForm()\" value=\"保存\"></input>\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" style=\"width:30px;\" value=\"返回\" onclick=\"window.location.href='/dumpView.do';\"></input>\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" class=\"button\" style=\"width:30px;\" onclick=\"window.location.href='/main.do';\" value=\"首页\">\r\n");
      out.write("\t\t\t\t\t<input  type=\"button\" class=\"button\" style=\"width:45px;\"  value=\"下一页\" onclick=\"nextPage();\"/>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t</div>\r\n");
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
