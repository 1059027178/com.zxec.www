package com.thinkway.cms.presentation.web.controller.delordpic;

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
import com.thinkway.cms.business.domains.DelLockUser;
import com.thinkway.cms.business.domains.DelOrdPic;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.DelLockUserService;
import com.thinkway.cms.business.service.iface.DelOrdPicService;
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

public class DelOrdPicAddController implements Controller , AuthenticateController{
	private DelLockUserService dellockuserService = null;
	private DelOrdPicService delordpicService = null;	
	private UserService userService = null;
	private String viewName = null;
	private String lockedName = null;
	private String view = null;
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
		String emessage="";
		 String complete="";
		try{
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		User user = null;
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			user = userService.getUser(loginUserId);			
			model.put("loginUser",user);			
		}	
		String vbeln=ParamUtils.getParameter(request, "vbeln","");//获取交货单号
		DelLockUser dellockuser=dellockuserService.getDelLockUser(vbeln);
		if(dellockuser!=null){
			if(!loginUserId.equals(dellockuser.getUserid())){
				emessage="发货单号"+vbeln+"被用户"+dellockuser.getUsername()+"锁定";
				model.put("type", "E");
				model.put("message", emessage);
				return new ModelAndView(getView(),model);
			}
		}
			String posnr=ParamUtils.getParameter(request, "posnr","");//项目号
			double shuliang=SapUtil.getDoubleValue(ParamUtils.getParameter(request, "shuliang","10"));//项目号
			int maxxuhao=ParamUtils.getIntParameter(request, "maxxuhao",1);//最大序列号
			String matnr=ParamUtils.getParameter(request, "matnr","");//物料编码
			String maktx=ParamUtils.getParameter(request, "maktx","");//物料描述
			String wadat=ParamUtils.getParameter(request, "wadat","");
			String lgort=ParamUtils.getParameter(request, "lgort","");
			String werks=ParamUtils.getParameter(request, "werks","");
			String charg=ParamUtils.getParameter(request, "charg","");
			model.put("werks",werks);
			model.put("lgort",lgort);
			model.put("wadat",wadat);
			model.put("posnr", posnr);
			model.put("vbeln", vbeln);
			model.put("matnr", matnr);
			model.put("maktx", maktx);
			model.put("charg", charg);
			double menge=0;
		
		 	JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPconEn();
		    myConnection.connect(); 
			String functionName="ZFM_BC_04_41";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
	//		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
			JCO.Table  IT_PICK=inputtable.getTable("IT_PICK");
			parameterList.setValue(user.getUserName(),"I_UID");//用户名字
			for(int i=1;i<maxxuhao;i++){
				String LGPLA=ParamUtils.getParameter(request, "lgpla"+i,"");//仓位
				String PLPOS=ParamUtils.getParameter(request, "plpos"+i,"");//仓位位置
				String VERME=ParamUtils.getParameter(request, i+"","");//选择数量
				String MEINS=ParamUtils.getParameter(request, "meins"+i,"");//基本计量单位
				String CHARG=ParamUtils.getParameter(request, "charg"+i,"");//批号
				System.out.println(vbeln+"/"+posnr+"/"+LGPLA+"/"+PLPOS+"/"+MEINS+"/"+VERME+"/"+CHARG);
				if(!VERME.equals("")){
					IT_PICK.appendRow();
					
					IT_PICK.setValue(vbeln,"VBELN");
					IT_PICK.setValue(posnr,"POSNR");
					IT_PICK.setValue(LGPLA,"LGPLA");
					IT_PICK.setValue(PLPOS,"PLPOS");
					IT_PICK.setValue(VERME,"VERME");
					IT_PICK.setValue(MEINS,"MEINS");
					IT_PICK.setValue(CHARG,"CHARG");
					menge+=SapUtil.getDoubleValue(VERME);
				}
				if(i==1){
					//break;
				}
			}
	    	
			myConnection.execute(bapi);
	//		
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			
			 //如果参数是一个结构，用参数名获得一个对应类型的结构对象
	        JCO.Structure ES_RETURN = outs.getStructure("ES_RETURN");
	        String etype=ES_RETURN.getString("MSGTY");
	        complete=outs.getString("E_COMPLETE");
	        emessage=ES_RETURN.getString("MESSAGE");
	        if(etype.equals("S")){
	        	String E_TANUM=(outs.getValue("E_TANUM")+"").replace("", "").replace("'", "");//转储单编号
	        	emessage="转储单"+E_TANUM+"创建成功。";
	        }
	      //记录日志
			delordpicService.SystemLog("DelOrdPic"," 交货单拣配 ",vbeln,"  "+user.getUserName(),
					emessage);
			if(null!=myConnection){
				SapUtil.releaseClient(myConnection);
			}
	        model.put("type", etype);	
	        model.put("type", etype);	
	        model.put("shuliang", shuliang-menge);
	        
		}catch(Exception e){
			emessage=e.getMessage();
			e.printStackTrace();
		}
		model.put("message", emessage);
		model.put("complete", complete);
		System.out.println("complete:"+complete);
		return new ModelAndView(getViewName(),model);
		
	}

	public String getViewName() {
		return viewName;
	}

	public void setViewName(String viewName) {
		this.viewName = viewName;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public UserService getUserService() {
		return userService;
	}

	public String getLockedName() {
		return lockedName;
	}

	public void setLockedName(String lockedName) {
		this.lockedName = lockedName;
	}

	public DelOrdPicService getDelordpicService() {
		return delordpicService;
	}

	public void setDelordpicService(DelOrdPicService delordpicService) {
		this.delordpicService = delordpicService;
	}

	public DelLockUserService getDellockuserService() {
		return dellockuserService;
	}

	public void setDellockuserService(DelLockUserService dellockuserService) {
		this.dellockuserService = dellockuserService;
	}


}
