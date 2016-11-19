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
import com.thinkway.LiangxinUtil;
import com.thinkway.cms.business.domains.Lubu;
import com.thinkway.cms.business.domains.Repertory;
import com.thinkway.cms.business.domains.StorageM;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.Receipt;
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
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.business.query.UserQuery;

public class LubuListController implements Controller , AuthenticateController{
	
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
		
		PaginatedListHelper paginaredList=new PaginatedListHelper();
		String currentPage=ParamUtils.getParameter(request, "page", "1");
		paginaredList.setObjectsPerPage(5);
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		

//	//从SAP获取交货单数量的值
	    List<Lubu> iList = new ArrayList<Lubu>();
	    
	    JCO.Client myConnection =null;
		myConnection =LiangxinUtil.getSAPcon();
	    myConnection.connect(); 
		String functionName="ZFM_BC_13_11";//函数的名字
	    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//	    //從這個函數範本獲得該SAP函數的物件
	    JCO.Function bapi = ft.getFunction();
    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//		JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
    	String bwlvs=LiangxinUtil.null2String(request.getParameter("bwlvs"));
    	String lgnum=LiangxinUtil.null2String(request.getParameter("lgnum"));
    	//parameterList.setValue(ssvbeln,"I_RULE");
    	parameterList.setValue(lgnum, "I_LGNUM");
    	parameterList.setValue(bwlvs, "I_BWLVS");
    	model.put("lgnum", lgnum);
    	model.put("lgpla", bwlvs);
		parameterList.setValue("EE","I_UID");
			myConnection.execute(bapi);
			
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			JCO.Table  ET_LAGP=outtab.getTable("ET_LUBU");
			
			paginaredList.setFullListSize(ET_LAGP.getNumRows());
			int j=0;
			int pageNum=ET_LAGP.getNumRows()/2;
			if(ET_LAGP.getNumRows()%2>0){
				pageNum++;
			}
			 for (int i = (Integer.parseInt(currentPage)-1)*2; i < ET_LAGP.getNumRows(); i++) {
				 ET_LAGP.setRow(i);
				 	Lubu rep=new Lubu();
				 	rep.setXuhao(j+1);
				 	rep.setMatnr(ET_LAGP.getString("MATN1"));
				    rep.setMaktx(ET_LAGP.getString("MAKTX"));
				    rep.setCharg(ET_LAGP.getString("CHRG1"));
				    rep.setGesme(ET_LAGP.getString("MENGE"));
				    rep.setLgort(ET_LAGP.getString("LGOR1"));
				    rep.setMeins(ET_LAGP.getString("MEINS"));
				    rep.setTdatu(ET_LAGP.getString("BDATU"));
				    rep.setUbnum(ET_LAGP.getString("UBNUM"));
				    iList.add(rep);
				    j++;
				    if(j==2){
				    	break;
				    }
	            }
	   
	    
		paginaredList.setList(iList);
		model.put("repList", iList);
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


}
