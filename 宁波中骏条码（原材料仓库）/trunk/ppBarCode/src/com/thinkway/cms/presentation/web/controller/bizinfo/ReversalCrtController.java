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
import org.springframework.web.servlet.view.RedirectView;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.Receipt;
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

public class ReversalCrtController implements Controller , AuthenticateController{
	
	private UserService userService = null;
	private String viewName = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;
	private Receipt receipt=new Receipt();
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
		System.out.println("start:"+SapUtil.getCurrentDateTime());
		Map<Object, Object> model = new HashMap<Object, Object>();	
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		User loginUser=new User();
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String aufnr = SapUtil.null2String(request.getParameter("aufnr"));//生产订单号
		String matnr = SapUtil.null2String(request.getParameter("matnr"));//物料编码
		String wemng = SapUtil.null2String(request.getParameter("wemng"));//总数量
		String meng = SapUtil.null2String(request.getParameter("meng"));//尾箱箱数
		String charg = SapUtil.null2String(request.getParameter("charg"));//批次号
		String sobkz = SapUtil.null2String(request.getParameter("sobkz"));//特殊库存标识
		String lgort = SapUtil.null2String(request.getParameter("lgort"));//库存地点
		String meins = SapUtil.null2String(request.getParameter("meins"));//单位
		String objno = SapUtil.null2String(request.getParameter("objno"));//工牌号
		String maktx = SapUtil.null2String(request.getParameter("maktx"));//物料描述
		String boxs = SapUtil.null2String(request.getParameter("boxs"));//箱数
		String sonum = SapUtil.null2String(request.getParameter("sonum"));
		
		receipt.setAufnr(aufnr);
		receipt.setMatnr(matnr);
		receipt.setMeins(meins);
		receipt.setWemng(wemng);
		receipt.setSobkz(sobkz);
		receipt.setLgort(lgort);
		receipt.setCharg(charg);
		receipt.setMeng(meng);
		receipt.setBoxs(boxs);
		receipt.setMaktx(maktx);
		receipt.setSonum(sonum);
		model.put("receiptObj", receipt);
		String message="";	
		try{
		//out.println(aufnr+"/"+iquan+"/"+gmein);
		JCO.Client myConnection =null;
		myConnection =SapUtil.getSAPcon();
	    myConnection.connect(); 
	    //out.println("连接SAP成功");
		String functionName="ZFM_BC_01_21";//函数的名字
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
		parameterList.setValue(loginUser.getUserName(),"I_UID");			
		//parameterList.setValue(aufnr,"I_AUFNR");					
		parameterList.setValue(aufnr,"I_AUFNR");
		parameterList.setValue(wemng,"I_WEMNG");
		parameterList.setValue(charg,"I_CHARG");
		parameterList.setValue(sobkz,"I_SOBKZ");
		parameterList.setValue(lgort,"I_LGORT");
		parameterList.setValue(meins,"I_MEINS");
		
		myConnection.execute(bapi);
		
		JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
		JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
		
		
		JCO.Structure stu01 = outs.getStructure("ES_RETURN");
		String type=stu01.getString("MSGTY");
		message=stu01.getString("MESSAGE");
		String mblnr=(outs.getValue("E_MBLNR")+"");
		if(null!=myConnection){
			SapUtil.releaseClient(myConnection);
		}
		model.put("type", type);	
		model.put("message", message);
		System.out.println("type:"+type+"----message:"+message+"----mblnr:"+mblnr);
		//}else{
			//message="必要信息不完整";
		//}
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("end:"+SapUtil.getCurrentDateTime());
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

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}


}
