package com.thinkway.cms.presentation.web.controller.dumquy;

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
import com.thinkway.cms.business.domains.DelOrdPic;
import com.thinkway.cms.business.domains.Dum;
import com.thinkway.cms.business.domains.Delivery;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.service.iface.DeliveryService;
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

public class DumQuyViewController implements Controller , AuthenticateController{
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
		User user = null;
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			user = userService.getUser(loginUserId);			
			model.put("loginUser",user);			
		}	
		String lgnum=ParamUtils.getParameter(request, "lgnum","");//仓库号
		String tanum=ParamUtils.getParameter(request, "tanum","");//转储单号
		PaginatedListHelper paginaredList=new PaginatedListHelper();
		String currentPage=ParamUtils.getParameter(request, "page", "1");
		paginaredList.setObjectsPerPage(1);
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		

//	//从SAP获取交货单数量的值
	    List<Dum> iList = new ArrayList<Dum>();
	    
	    
		 JCO.Client myConnection =null;
			myConnection =LiangxinUtil.getSAPcon();
		    myConnection.connect(); 
			String functionName="ZFM_BC_12_11";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
	    	parameterList.setValue(lgnum,"I_LGNUM");//物料编码
	    	parameterList.setValue(tanum,"I_TANUM");//仓位
	    	parameterList.setValue(user.getUserName(),"I_UID");//用户名字
	    	
				myConnection.execute(bapi);
//				
				JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
				JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
				JCO.Table  ET_LTAP=outtab.getTable("ET_LTAP");

				Dum dum=new Dum();
				
				 JCO.Structure ES_LTAK = outs.getStructure("ES_LTAK");
				dum.setBname(ES_LTAK.getString("BNAME"));//创建者
				int pageNum=ET_LTAP.getNumRows();
				paginaredList.setFullListSize(ET_LTAP.getNumRows());
				if(ET_LTAP.getNumRows()>0){
					ET_LTAP.setRow(Integer.parseInt(currentPage)-1);
					dum.setTanum(ET_LTAP.getString("TANUM"));		//转储单
					dum.setPosnr(ET_LTAP.getString("POSNR"));//行项目号
					dum.setMatnr(ET_LTAP.getString("MATNR")); //物料号 
					dum.setCharg(ET_LTAP.getString("CHARG"));	//批次
					dum.setVsolm(ET_LTAP.getString("VSOLM"));//源发地目标数量,按库存单位计(数量)
					dum.setZeugn(ET_LTAP.getString("ZEUGN")); //证书号
					dum.setVdifm(ET_LTAP.getString("VDIFM"));//源仓位
					//源托盘
					dum.setNplei(ET_LTAP.getString("NPLEI"));//目标仓位
					//目标托盘
				    iList.add(dum);
				}
			paginaredList.setList(iList);
			model.put("dumList", iList);	
			model.put("page", currentPage);
			model.put("pageNum", pageNum);
			model.put("lgnum", lgnum);
			model.put("tanum", tanum);
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
