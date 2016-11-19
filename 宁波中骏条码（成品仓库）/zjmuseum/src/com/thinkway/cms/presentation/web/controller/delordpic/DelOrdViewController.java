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
import org.springframework.context.ApplicationListener;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.LiangxinUtil;
import com.thinkway.cms.business.domains.DelLockUser;
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

public class DelOrdViewController implements Controller , AuthenticateController{
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
		
		String vbeln=ParamUtils.getParameter(request, "vbeln");//获取发货单号
		String werks=ParamUtils.getParameter(request, "werks");
		String lgort=ParamUtils.getParameter(request, "lgort");
		String wadat=ParamUtils.getParameter(request, "wadat");
		System.out.println(vbeln);
		model.put("werks",werks);
		model.put("lgort",lgort);
		model.put("wadat",wadat);
		model.put("vbeln",vbeln);
		
		DelLockUser dellockuser=dellockuserService.getDelLockUser(vbeln);
		if(dellockuser!=null){
			if(!loginUserId.equals(dellockuser.getUserid())){
				String emessage="发货单号"+vbeln+"被用户"+dellockuser.getUsername()+"锁定";
				model.put("type", "E");
				model.put("message", emessage);
				return new ModelAndView(getView(),model);
			}
		}else{
			dellockuser=new DelLockUser();
			dellockuser.setUserid(user.getUserId().toString());
			dellockuser.setUsername(user.getUserName());
			dellockuser.setVbeln(vbeln);
			dellockuser.setLockdata(LiangxinUtil.getTodayWithSdt());
			dellockuserService.createDelLockUser(dellockuser);
		}

		
		Message message=SAPUtil.lockonOrder(vbeln,user.getUserName());
		if(message.getType().equals("E")){
//			model.put("shuliang",-1);
//			model.put("type",message.getType());
//			model.put("message",message.getMessage());
//			return new ModelAndView(getView(),model);
		}
		//Message message=SAPUtil.lockonOrder(vbeln,user.getUserName());
		//if(message.getType().equals("E")){
		//	model.put("shuliang",-1);
		//	model.put("type",message.getType());
		//	model.put("message",message.getMessage());
		//	return new ModelAndView(getView(),model);
		//}
		
		
		
		PaginatedListHelper paginaredList=new PaginatedListHelper();
		String currentPage=ParamUtils.getParameter(request, "page", "1");
		paginaredList.setObjectsPerPage(5);
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		

//	//从SAP获取交货单数量的值
	    List<DelOrdPic> iList = new ArrayList<DelOrdPic>();
	    
	    JCO.Client myConnection =null;
		myConnection =LiangxinUtil.getSAPcon();
	    myConnection.connect(); 
		String functionName="ZFM_BC_04_21";//函数的名字
	    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//	    //從這個函數範本獲得該SAP函數的物件
	    JCO.Function bapi = ft.getFunction();
    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//		JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
    	parameterList.setValue(vbeln,"I_VBELN");
    	parameterList.setValue(user.getUserName(),"I_UID");//用户名字
    	
		myConnection.execute(bapi);
	//			
		JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
		JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
		JCO.Table  ET_LIPS=outtab.getTable("ET_LIPS");
		int pageNum=ET_LIPS.getNumRows()/5;
		if(ET_LIPS.getNumRows()%5>0){
			pageNum++;
		}
		paginaredList.setFullListSize(ET_LIPS.getNumRows());
		int j=0;
		 for (int i = (Integer.parseInt(currentPage)-1)*5; i < ET_LIPS.getNumRows(); i++) {
			 	ET_LIPS.setRow(i);
			 	DelOrdPic delord=new DelOrdPic();
			    delord.setXuhao(i+1+"");
			    delord.setPosnr(ET_LIPS.getString("POSNR")); //行项目号 
			    delord.setVbeln(vbeln);//发货单号
			    delord.setMatnr(ET_LIPS.getString("MATNR")); //物料号 
			    delord.setMaktx(ET_LIPS.getString("MAKTX")); //物料号 
			    delord.setLfimg(ET_LIPS.getString("LFIMG"));//实际已交货量（按销售单位）
			    delord.setVrmke(ET_LIPS.getString("VRKME"));	//销售单位 
			    delord.setCharg(ET_LIPS.getString("CHARG"));	//批号
			    //delord.setLgnum(ET_LIPS.getString("SONUM"));//特殊库存
			    delord.setRfmng(LiangxinUtil.getDoubleValue(ET_LIPS.getString("RFMNG")));
				    iList.add(delord);
				    j++;
				    if(j==5){
				    	break;
				    }
	            }
	   
	    
		paginaredList.setList(iList);
		model.put("delordList", iList);	
		model.put("page", currentPage);
		model.put("pageNum", pageNum);
		if(null!=myConnection){
			LiangxinUtil.releaseClient(myConnection);
		}
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
