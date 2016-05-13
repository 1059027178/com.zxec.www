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

public class DumpListController implements Controller , AuthenticateController{
	
	private UserService userService = null;
	private String viewName = null;
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
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		User loginUser=new User();
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String nlpla=SapUtil.null2String(request.getParameter("nlpla"));
		String radio=SapUtil.null2String(request.getParameter("radio"));
		String lgnum=SapUtil.null2String(request.getParameter("lgnum"));
		model.put("nlpla", nlpla);
		model.put("radio", radio);
		if(radio.equals("3")){
			PaginatedListHelper paginaredList=new PaginatedListHelper();
			String currentPage=ParamUtils.getParameter(request, "page", "1");
			paginaredList.setObjectsPerPage(5);
			paginaredList.setPageNumber(Integer.parseInt(currentPage));
			

//		//从SAP获取交货单数量的值
		    List<Repertory> iList = new ArrayList<Repertory>();
		    
		    JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPcon();
		    myConnection.connect(); 
			String functionName="ZFM_BC_07_31";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
	    	//parameterList.setValue(ssvbeln,"I_RULE");
				myConnection.execute(bapi);
//				
				JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
				JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
				JCO.Table  ET_LAGP=outtab.getTable("ET_LAGP");

				paginaredList.setFullListSize(ET_LAGP.getNumRows());
				int j=0;
				 for (int i = (Integer.parseInt(currentPage)-1)*5; i < ET_LAGP.getNumRows(); i++) {
					 ET_LAGP.setRow(i);
					 	Repertory rep=new Repertory();
					 	rep.setLgnum(ET_LAGP.getString("LGNUM"));
					 	rep.setLgtyp(ET_LAGP.getString("LGTYP"));
					    rep.setNlpla(ET_LAGP.getString("LGPLA"));
					    iList.add(rep);
					    j++;
					    if(j==5){
					    	break;
					    }
		            }
		   
		    
			paginaredList.setList(iList);
			model.put("repList", paginaredList);	
			return new ModelAndView(getViewName(),model);
		}
		
		String message="";	
		try{
			//out.println(aufnr+"/"+iquan+"/"+gmein);
			JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPcon();
		    myConnection.connect(); 
		    //out.println("连接SAP成功");
			String functionName="ZFM_BC_07_11";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
			
			//JCO.Table  IT_ITEM=inputtable.getTable("IT_ITEM");
			//if(!aufnr.isEmpty()&&!iquan.isEmpty()&&!gmein.isEmpty()){
			
			
			
			//System.out.println("aufnr:"+aufnr+"---wemng:"+wemng+"---charg:"+charg+"---sobkz:"+sobkz+"---lgort:"+lgort+"---meins:"+meins);
			//IT_ITEM.appendRow();		
			parameterList.setValue(loginUser.getUserName(),"I_UID");			
			//parameterList.setValue(aufnr,"I_AUFNR");					
			parameterList.setValue(nlpla,"I_LGPLA");
			parameterList.setValue(lgnum,"I_LGNUM");
			
			myConnection.execute(bapi);
			
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			
			
			JCO.Structure stu01 = outs.getStructure("ES_RETURN");
			String type=stu01.getString("MSGTY");
			message=stu01.getString("MESSAGE");
			
			lgnum= outs.getString("E_LGNUM");
			String lgtyp= outs.getString("E_LGTYP");
			if(null!=myConnection){
				SapUtil.releaseClient(myConnection);
			}
			model.put("lgnum", lgnum);
			model.put("lgtyp", lgtyp);
			model.put("type", type);	
			model.put("message", message);
			//System.out.println("type:"+type+"----message:"+message+"----mblnr:"+mblnr);
			//}else{
				//message="必要信息不完整";
			//}
		}catch(Exception e){
			e.printStackTrace();
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


}