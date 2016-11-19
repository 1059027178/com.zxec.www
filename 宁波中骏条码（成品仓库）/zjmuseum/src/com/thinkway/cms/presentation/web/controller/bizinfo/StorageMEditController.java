package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.LiangxinUtil;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.controller.fix.IntegerEditor;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.Escape;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.business.query.UserQuery;

public class StorageMEditController implements Controller , AuthenticateController{
	
	private UserService userService = null;
	private String viewName = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;
	public String getTokenNeed() {
		return tokenNeed;
	}

	public void setTokenNeed(String tokenNeed) {
		this.tokenNeed = tokenNeed;
	}
	public long getPermission() {
		return permission;
	}

	public void setPermission(long permission) {
		this.permission = permission;
	}

	public Authenticator getAuthenticator() {
		return authenticator;
	}

	public void setAuthenticator(Authenticator authenticator) {
		this.authenticator = authenticator;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Map<Object, Object> model = new HashMap<Object, Object>();	
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		User loginUser=null;
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String lgpla = LiangxinUtil.null2String(request.getParameter("lgpla"));//源仓位
		String lgnum = LiangxinUtil.null2String(request.getParameter("lgnum"));//仓库号
		String lgtyp = LiangxinUtil.null2String(request.getParameter("lgtyp"));//仓储类型
		
		
		String sonum = LiangxinUtil.null2String(request.getParameter("sonum"));//特殊库存编码
		String lgort = LiangxinUtil.null2String(request.getParameter("lgort"));//库存地点
		String werks = LiangxinUtil.null2String(request.getParameter("werks"));//工厂
		String matnr = LiangxinUtil.null2String(request.getParameter("matnr"));//物料号
		String charg = LiangxinUtil.null2String(request.getParameter("charg"));//批次
		String gesme = LiangxinUtil.null2String(request.getParameter("gesme"));//参考数量
		String verme = LiangxinUtil.null2String(request.getParameter("verme"));//转移数量
		String nlpla = LiangxinUtil.null2String(request.getParameter("nlpla"));//目的仓位
		String meins = LiangxinUtil.null2String(request.getParameter("meins"));//目的仓位
		String sobkz = LiangxinUtil.null2String(request.getParameter("sobkz"));//特殊库存标识
		
		String message="";	
		try{
		//out.println(aufnr+"/"+iquan+"/"+gmein);
		JCO.Client myConnection =null;
		myConnection =LiangxinUtil.getSAPconEn();
	    myConnection.connect(); 
	    //out.println("连接SAP成功");
		String functionName="ZFM_BC_08_21";//函数的名字
	    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
	    //從這個函數範本獲得該SAP函數的物件
	    JCO.Function bapi = ft.getFunction();
    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
		JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
		
		//JCO.Table  IT_ITEM=inputtable.getTable("IT_ITEM");
		//IT_ITEM.appendRow();		
		parameterList.setValue(loginUser.getUserName(),"I_UID");			
		//parameterList.setValue(aufnr,"I_AUFNR");	
		parameterList.setValue(matnr,"I_MATNR");
		parameterList.setValue(werks,"I_WERKS");
		parameterList.setValue(lgort,"I_LGORT");
		parameterList.setValue(charg,"I_CHARG");
		parameterList.setValue(verme,"I_VERME");
		parameterList.setValue(meins,"I_MEINS");
		parameterList.setValue(lgpla,"I_VLPLA");
		parameterList.setValue(lgtyp,"I_VLTYP");
		parameterList.setValue(sobkz,"I_SOBKZ");
		parameterList.setValue(sonum,"I_SONUM");
		parameterList.setValue(nlpla,"I_NLPLA");
		parameterList.setValue(lgtyp,"I_NLTYP");
		myConnection.execute(bapi);
		
		JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
		JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
		
		
		JCO.Structure stu01 = outs.getStructure("ES_RETURN");
		String type=stu01.getString("MSGTY");
		message=stu01.getString("MESSAGE");
		//String mblnr=(outs.getValue("E_MBLNR")+"");
		model.put("type", type);	
		
		//System.out.println("type:"+type+"----message:"+message+"----mblnr:"+mblnr);
		//}else{
			//message="必要信息不完整";
		//}
		}catch(Exception e){
			message=new String(e.getMessage().getBytes("ISO-8859-1"),"UTF-8");
			e.printStackTrace();
		}
		model.put("message", message);
		return new ModelAndView(getViewName(),model);
		
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public UserService getUserService() {
		return userService;
	}


}
