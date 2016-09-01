package com.thinkway.cms.presentation.web.controller.delordpic;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import com.thinkway.cms.business.domains.Message;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.DelLockUserService;
import com.thinkway.cms.business.service.iface.DelOrdPicService;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.controller.fix.IntegerEditor;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.presentation.web.form.UserForm;
import com.thinkway.cms.presentation.web.interceptors.BaseFormController;
import com.thinkway.cms.util.Escape;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.util.SAPUtil;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.business.query.UserQuery;

public class DelOrdListController implements Controller , AuthenticateController{
	private DelLockUserService dellockuserService = null;
	private UserService userService = null;
	private String viewName = null;
	private String view=null;
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
		User user=null;
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			user = userService.getUser(loginUserId);			
			model.put("loginUser",user);			
		}	
		dellockuserService.deleteDelLockUserByUserid(loginUserId);
		
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式 
		 System.out.println(df.format(new Date()));//
		String ssvbeln=ParamUtils.getParameter(request, "ssvbeln");//获取交货单号
		String werks=SapUtil.null2String(request.getParameter("werks"));
		String lgort=SapUtil.null2String(request.getParameter("lgort"));
		String wadat=SapUtil.null2String(request.getParameter("wadat"));
		String vbeln=ParamUtils.getParameter(request, "vbeln");
		
		model.put("werks", werks);
		model.put("lgort", lgort);
		model.put("wadat", wadat);
		
		if(vbeln!=null){
			if(!vbeln.equals("")){
				//Message message=SAPUtil.openOrder(vbeln,user.getUserName());
				//if(message.getType().equals("E")){
				//	model.put("shuliang",-1);
				//	model.put("type",message.getType());
				//	model.put("message",message.getMessage());
				//	return new ModelAndView(getView(),model);
				//}
			}
		}
		PaginatedListHelper paginaredList=new PaginatedListHelper();
		String currentPage=ParamUtils.getParameter(request, "page", "1");
		paginaredList.setObjectsPerPage(5);
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		

//	//从SAP获取交货单数量的值
	    List<DelOrdPic> iList = new ArrayList<DelOrdPic>();
	    
	    JCO.Client myConnection =null;
		myConnection =SapUtil.getSAPcon();
	    myConnection.connect(); 
		String functionName="ZFM_BC_04_11";//函数的名字
	    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//	    //從這個函數範本獲得該SAP函數的物件
	    JCO.Function bapi = ft.getFunction();
    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//		JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
    	parameterList.setValue(ssvbeln,"I_RULE");
    	parameterList.setValue(user.getUserName(),"I_UID");//用户名字
    	parameterList.setValue(werks,"I_WERKS");
    	parameterList.setValue(lgort,"I_LGORT");
    	parameterList.setValue(wadat,"I_WADAT");
		myConnection.execute(bapi);
	//			
		JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
		JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
		JCO.Table  ET_LIKP=outtab.getTable("ET_LIKP");
	
		paginaredList.setFullListSize(ET_LIKP.getNumRows());
		int j=0;
		int pageNum=ET_LIKP.getNumRows()/10;
		if(ET_LIKP.getNumRows()%10>0){
			pageNum++;
		}
		 for (int i = (Integer.parseInt(currentPage)-1)*10; i < ET_LIKP.getNumRows(); i++) {
			 	ET_LIKP.setRow(i);
			 	DelOrdPic delord=new DelOrdPic();
			    delord.setXuhao(i+1+"");
			    delord.setVbeln(ET_LIKP.getString("VBELN"));
			    iList.add(delord);
			    j++;
			    if(j==10){
			    	break;
			    }
	        }
	   
		 System.out.println(df.format(new Date()));//
		paginaredList.setList(iList);
		model.put("delordList", iList);	
		if(null!=myConnection){
			SapUtil.releaseClient(myConnection);
		}
		model.put("page", currentPage);
		model.put("pageNum", pageNum);
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

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	public DelLockUserService getDellockuserService() {
		return dellockuserService;
	}

	public void setDellockuserService(DelLockUserService dellockuserService) {
		this.dellockuserService = dellockuserService;
	}


}
