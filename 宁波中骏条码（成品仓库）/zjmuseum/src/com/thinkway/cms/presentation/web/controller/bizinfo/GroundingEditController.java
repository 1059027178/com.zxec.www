package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.thinkway.cms.business.domains.Grounding;
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

public class GroundingEditController implements Controller , AuthenticateController{
	
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
		// TODO Auto-generated method stub
		Map<Object, Object> model = new HashMap<Object, Object>();	
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			User loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String aufnr = LiangxinUtil.null2String(request.getParameter("aufnr"));//生产订单号
		String matnr = LiangxinUtil.null2String(request.getParameter("matnr"));//物料编码
		String wemng = LiangxinUtil.null2String(request.getParameter("wemng"));//总数量
		String meng = LiangxinUtil.null2String(request.getParameter("meng"));//尾箱箱数
		String charg = LiangxinUtil.null2String(request.getParameter("charg"));//批次号
		String sobkz = LiangxinUtil.null2String(request.getParameter("sobkz"));//特殊库存标识
		String lgort = LiangxinUtil.null2String(request.getParameter("lgort"));//库存地点
		String meins = LiangxinUtil.null2String(request.getParameter("meins"));
		String werks = LiangxinUtil.null2String(request.getParameter("werks"));
		String nltyp = LiangxinUtil.null2String(request.getParameter("lgtyp"));
		String nlpla = LiangxinUtil.null2String(request.getParameter("nlpla"));
		String sonum = LiangxinUtil.null2String(request.getParameter("sonum"));
		
		String message="";	
		try{
		//out.println(aufnr+"/"+iquan+"/"+gmein);


			JCO.Client myConnection =null;
			myConnection =LiangxinUtil.getSAPconEn();
			
		    myConnection.connect(); 
		    //out.println("连接SAP成功");
			String functionName="ZFM_BC_02_21";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
			
			//JCO.Table  IT_ITEM=inputtable.getTable("IT_ITEM");
			//if(!aufnr.isEmpty()&&!iquan.isEmpty()&&!gmein.isEmpty()){
			
			
			
			System.out.println("aufnr:"+aufnr+"---wemng:"+wemng+"---charg:"+charg+"---sobkz:"+sobkz+"---lgort:"+lgort+"---meins:"+meins);
			//IT_ITEM.appendRow();		
			parameterList.setValue("EE","I_UID");			
			//parameterList.setValue(aufnr,"I_AUFNR");	
			parameterList.setValue(nltyp,"I_NLTYP");
			parameterList.setValue(nlpla,"I_NLPLA");
			
			parameterList.setValue(matnr,"I_MATNR");
			parameterList.setValue(werks,"I_WERKS");
			parameterList.setValue(wemng,"I_MENGE");
			parameterList.setValue(charg,"I_CHARG");
			parameterList.setValue(sobkz,"I_SOBKZ");
			parameterList.setValue(lgort,"I_LGORT");
			parameterList.setValue(meins,"I_MEINS");
			parameterList.setValue(sonum,"I_SONUM");
			
			myConnection.execute(bapi);
			
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			
			
			JCO.Structure stu01 = outs.getStructure("ES_RETURN");
			String type=stu01.getString("MSGTY");
			message=stu01.getString("MESSAGE");
			String mblnr=(outs.getValue("E_TANUM")+"");
			model.put("type", type);	
			
			System.out.println("type:"+type+"----message:"+message+"----mblnr:"+mblnr);
		}catch(JCO.Exception e){
			message=e.getMessage();
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
