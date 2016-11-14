package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.sql.Timestamp;
import java.util.ArrayList;
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
import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.DelOrdPic;
import com.thinkway.cms.business.domains.Dump;
import com.thinkway.cms.business.domains.Receipt;
import com.thinkway.cms.business.domains.Repertory;
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
import com.thinkway.cms.business.query.RepertoryQuery;
import com.thinkway.cms.business.query.UserQuery;

public class DumpAddController implements Controller , AuthenticateController{
	
	private UserService userService = null;
	private String ViewName = null;
	private Receipt receipt=new Receipt();
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
		String message="";
		String radio = SapUtil.null2String(request.getParameter("radio"));
		try{
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			User loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String matnr = SapUtil.null2String(request.getParameter("matnr"));//物料编码
		String maktx = SapUtil.null2String(request.getParameter("maktx"));//物料编码
		String meins = SapUtil.null2String(request.getParameter("meins"));//物料编码
		String sonum = SapUtil.null2String(request.getParameter("sonum"));
		String sobkz = SapUtil.null2String(request.getParameter("sobkz"));
		String werks = SapUtil.null2String(request.getParameter("werks"));
		String lgort = SapUtil.null2String(request.getParameter("lgort"));
		String charg = SapUtil.null2String(request.getParameter("charg"));
		
		if(radio.equals("1")){
			int maxxuhao=ParamUtils.getIntParameter(request, "maxxuhao",1);//最大序列号
			int xzsl=0;
			for(int i=0;i<=maxxuhao;i++){
				String LGPLA=ParamUtils.getParameter(request, "lgpla"+i,"");//仓位
				String PLPOS=ParamUtils.getParameter(request, "plpos"+i,"");//仓位位置
				String MENGE=ParamUtils.getParameter(request, i+"","");//选择数量
				String MEINS=ParamUtils.getParameter(request, "meins"+i,"");//基本计量单位 
				String vltyp=ParamUtils.getParameter(request, "vltyp"+i,"");//基本计量单位
				String vlpla=ParamUtils.getParameter(request, "vlpla"+i,"");
				System.out.println("MENGE:"+MENGE);
				int sl=SapUtil.getIntValue(MENGE);
				if(sl>0){xzsl+=sl;}
				if(!MENGE.equals("")){
					 	JCO.Client myConnection =null;
//						myConnection =SapUtil.getSAPconEn();
						myConnection =SapUtil.getSAPcon();
					    myConnection.connect(); 
						String functionName="ZFM_BC_03_21";//函数的名字
					    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
					    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//					    //從這個函數範本獲得該SAP函數的物件
					    JCO.Function bapi = ft.getFunction();
				    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//						JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
					parameterList.setValue(matnr,"I_MATNR");//物料编码
			    	parameterList.setValue(werks,"I_WERKS");
			    	parameterList.setValue(lgort,"I_LGORT");
			    	parameterList.setValue(charg,"I_CHARG");
			    	parameterList.setValue(MENGE,"I_MENGE");
			    	parameterList.setValue(MEINS,"I_MEINS");
			    	parameterList.setValue(sobkz,"I_SOBKZ");
			    	parameterList.setValue(sonum,"I_SONUM");
			    	parameterList.setValue(vltyp,"I_VLTYP");
			    	parameterList.setValue(vlpla,"I_VLPLA");
			    	myConnection.execute(bapi);
//					
					JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
					JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
					
					 //如果参数是一个结构，用参数名获得一个对应类型的结构对象
			        JCO.Structure ES_RETURN = outs.getStructure("ES_RETURN");
			        String etype=ES_RETURN.getString("MSGTY");
			        if(etype.equals("S")){
			        	String E_TANUM=(outs.getValue("E_TANUM")+"").replace("", "").replace("'", "");//转储单编号
			        	message="转储单"+E_TANUM+"创建成功。";
			        }else{
			        	   message=ES_RETURN.getString("MESSAGE");
			        }
			    	if(null!=myConnection){
						SapUtil.releaseClient(myConnection);
					}
				}
				if(i==1){
					//break;
				}
	    	}
			model.put("xzsl", xzsl);
		}else if(radio.equals("2")){
			String menge = SapUtil.null2String(request.getParameter("menge"));
			String lgort_from = SapUtil.null2String(request.getParameter("lgort_from"));
			String lgort_to = SapUtil.null2String(request.getParameter("lgort_to"));
			String charg_to = SapUtil.null2String(request.getParameter("charg_to"));
			String bwart = SapUtil.null2String(request.getParameter("bwart"));
			System.out.println("charg:"+charg+" charg_to:"+charg_to);
			JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPcon();
		    myConnection.connect(); 
			String functionName="ZFM_BC_06_11";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
	    	//20161107新增：操作人字段
	    	parameterList.setValue(userService.getUser(loginUserId).getUserName(),"I_UID");
	    	//20161107新增：操作人字段
			parameterList.setValue(matnr,"I_MATNR");//物料编码
	    	parameterList.setValue(bwart,"I_BWART");
//	    	parameterList.setValue(lgort,"I_LGORT");
	    	parameterList.setValue(charg,"I_CHARG");
	    	parameterList.setValue(charg_to,"I_CHARG_TO");
	    	parameterList.setValue(menge,"I_MENGE");
	    	parameterList.setValue(meins,"I_MEINS");
	    	parameterList.setValue(sobkz,"I_SOBKZ");
	    	parameterList.setValue(sonum,"I_SONUM");
	    	parameterList.setValue(lgort_to,"I_LGORT_TO");
	    	parameterList.setValue(lgort_from,"I_LGORT_FROM");
	    	myConnection.execute(bapi);
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			
			 //如果参数是一个结构，用参数名获得一个对应类型的结构对象
	        JCO.Structure ES_RETURN = outs.getStructure("ES_RETURN");
	        String etype=ES_RETURN.getString("MSGTY");
	        message=ES_RETURN.getString("MESSAGE");

			if(null!=myConnection){
				SapUtil.releaseClient(myConnection);
			}
		}

		model.put("matnr", matnr);
		model.put("maktx", maktx);
		model.put("charg", charg);
		model.put("lgort", lgort);
		model.put("sobkz", sobkz);
		model.put("sonum", sonum);
//		model.put("bwart", bwart);
		model.put("meins", meins);
//		model.put("werks", werks);
				}catch(Exception e){
					message=e.getMessage();
					e.printStackTrace();
				}
			model.put("message", message);
			model.put("radio", radio);
			return new ModelAndView(getViewName(),model);
	}

	
	public UserService getUserService() {
		return userService;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}

	public String getViewName() {
		return ViewName;
	}

	public void setViewName(String viewName) {
		ViewName = viewName;
	}

}
