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

public class DumpCheckController implements Controller , AuthenticateController{
	
	private UserService userService = null;
	private String radio1Name = null;
	private String radio2Name = null;
	private String radio3Name = null;
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
		
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			User loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String matnr = LiangxinUtil.null2String(request.getParameter("matnr"));//物料编码
		String charg = LiangxinUtil.null2String(request.getParameter("charg"));//批次号
		String sobkz = LiangxinUtil.null2String(request.getParameter("sobkz"));//特殊库存标识
		String lgort = LiangxinUtil.null2String(request.getParameter("lgort"));//库存地点
		String sonum = LiangxinUtil.null2String(request.getParameter("sonum"));
		String radio = LiangxinUtil.null2String(request.getParameter("radio"));
		String lgnum = LiangxinUtil.null2String(request.getParameter("lgnum"));//仓库号/混合仓库
		String lgpla = LiangxinUtil.null2String(request.getParameter("lgpla"));//仓位
		String maktx = LiangxinUtil.null2String(request.getParameter("maktx"));
		String werks = LiangxinUtil.null2String(request.getParameter("werks"));
		String meins = LiangxinUtil.null2String(request.getParameter("meins"));
		String meng = LiangxinUtil.null2String(request.getParameter("meng"));//每箱数量
		String xzsl = LiangxinUtil.null2String(request.getParameter("xzsl"));
		System.out.println("radio:"+radio);
		receipt.setMatnr(matnr);
		receipt.setSobkz(sobkz);
		receipt.setLgort(lgort);
		receipt.setCharg(charg);
		receipt.setSonum(sonum);
		receipt.setMaktx(maktx);
		model.put("receipt", receipt);
		model.put("lgort", lgort);
		model.put("werks", werks);
		model.put("xzsl", xzsl);
		System.out.println("****************xzsl ="+xzsl);
		if(radio.equals("1")){
			PaginatedListHelper paginaredList=new PaginatedListHelper();
			String currentPage=ParamUtils.getParameter(request, "page", "1");
			paginaredList.setObjectsPerPage(5);
			paginaredList.setPageNumber(Integer.parseInt(currentPage));
			

//		//从SAP获取交货单数量的值
		    List<Dump> iList = new ArrayList<Dump>();
		    
		    JCO.Client myConnection =null;
			myConnection =LiangxinUtil.getSAPcon();
		    myConnection.connect(); 
			String functionName="ZFM_BC_03_11";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
//		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
//			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
	    	parameterList.setValue(matnr,"I_MATNR");//物料编码
	    	parameterList.setValue(charg,"I_CHARG");
	    	parameterList.setValue(sobkz,"I_SOBKZ");
	    	parameterList.setValue(lgpla,"I_LGPLA");
	    	parameterList.setValue(sonum,"I_SONUM");
	    	parameterList.setValue(lgnum,"I_LGNUM");
	    	
				myConnection.execute(bapi);
				
				JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
				JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
				JCO.Table  ET_LAGP=outtab.getTable("ET_LQUA");

				paginaredList.setFullListSize(ET_LAGP.getNumRows());
				int pageNum=ET_LAGP.getNumRows()/3;
				if(ET_LAGP.getNumRows()%3>0){
					pageNum++;
				}
				int j=0;
				 for (int i = (Integer.parseInt(currentPage)-1)*3; i < ET_LAGP.getNumRows(); i++) {
					 ET_LAGP.setRow(i);
					 	Dump rep=new Dump();
					 	rep.setCharg(ET_LAGP.getString("CHARG"));//批次
					 	rep.setLgpla(ET_LAGP.getString("LGPLA"));//仓位
					 	rep.setMeins(ET_LAGP.getString("MEINS"));//单位
					 	rep.setVerme(ET_LAGP.getString("VERME"));//VERME 
					 	rep.setLgtyp(ET_LAGP.getString("LGTYP"));
					 	rep.setXuhao(i+1);
					    iList.add(rep);
					    j++;
					    if(j==3){
					    	break;
					    }
		            }
		   
		    
			paginaredList.setList(iList);
			model.put("repList", iList);	
			model.put("dumList", iList);	
			model.put("page", currentPage);
			model.put("pageNum", pageNum);
			model.put("matnr", matnr);
			model.put("maktx", maktx);
			model.put("charg", charg);
			model.put("lgort", lgort);
			model.put("sobkz", sobkz);
			model.put("sonum", sonum);
			model.put("meins", meins);
			model.put("werks", werks);
			model.put("radio", radio);
			model.put("lgnum", lgnum);
			model.put("lgpla", lgpla);

			return new ModelAndView(getRadio1Name(),model);
		}else if(radio.equals("2")){
			String charg_to = LiangxinUtil.null2String(request.getParameter("charg_to"));
			String lgort_to = LiangxinUtil.null2String(request.getParameter("lgort_to"));
//			System.out.println("charg:"+charg);
			model.put("matnr", matnr);
			model.put("maktx", maktx);
			model.put("charg", charg);
			model.put("lgort", lgort);
			model.put("sobkz", sobkz);
			model.put("sonum", sonum);
//			model.put("bwart", bwart);
			model.put("meins", meins);
//			model.put("werks", werks);
			model.put("meng", meng);
			System.out.println("****************meng ="+meng);
			System.out.println("****************meng ="+meng);
			System.out.println("****************charg_to ="+charg_to);
			System.out.println("****************lgort_to ="+lgort_to);
			model.put("charg_to", charg_to);
			model.put("lgort_to", lgort_to);
			return new ModelAndView(getRadio2Name(),model);
		}else{
			model.put("matnr", matnr);
			model.put("maktx", maktx);
			model.put("charg", charg);
			model.put("lgort", lgort);
			model.put("sobkz", sobkz);
			model.put("sonum", sonum);
//			model.put("bwart", bwart);
			model.put("meins", meins);
//			model.put("werks", werks);
//			model.put("werks", werks);
			return new ModelAndView(getRadio3Name(),model);
		}
	
		
			
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

	public String getRadio1Name() {
		return radio1Name;
	}

	public void setRadio1Name(String radio1Name) {
		this.radio1Name = radio1Name;
	}

	public String getRadio2Name() {
		return radio2Name;
	}

	public void setRadio2Name(String radio2Name) {
		this.radio2Name = radio2Name;
	}

	public String getRadio3Name() {
		return radio3Name;
	}

	public void setRadio3Name(String radio3Name) {
		this.radio3Name = radio3Name;
	}


}
