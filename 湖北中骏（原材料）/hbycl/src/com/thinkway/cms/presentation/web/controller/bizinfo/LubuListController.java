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

public class LubuListController implements Controller, AuthenticateController {

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

	public ModelAndView handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("start:"+SapUtil.getCurrentDateTime());
		Map<Object, Object> model = new HashMap<Object, Object>();	
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		User loginUser=null;
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String message="";	
		try{
			JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPcon();
		    myConnection.connect(); 
			String functionName = "ZFM_BC_13_22";// 函数的名字
			JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); // 只是一個名字
			IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
			// //從這個函數範本獲得該SAP函數的物件
			JCO.Function bapi = ft.getFunction();
			JCO.ParameterList parameterList = bapi.getImportParameterList();// 获得输入表的参数
			// JCO.ParameterList inputtable= bapi.getTableParameterList();//输入表的处理
	
			String matnr_B = SapUtil.null2String(request.getParameter("matnr"));
			String matnr_F = SapUtil.null2String(request.getParameter("matnr1"));
			String wemng   = SapUtil.null2String(request.getParameter("num"));
			String lgort   = SapUtil.null2String(request.getParameter("lgort"));
			String charg   = SapUtil.null2String(request.getParameter("charg"));
			String chargf=SapUtil.null2String(request.getParameter("targetBatch"));
			String meins   = SapUtil.null2String(request.getParameter("meins"));
			String werks   = SapUtil.null2String(request.getParameter("werks"));

			model.put("matnr", matnr_B);
			model.put("matnr1", matnr_F);
			model.put("wemng"  , wemng);
			model.put("lgort", lgort);// 库存地点
			model.put("charg", charg);
			model.put("targetBatch", chargf);
			model.put("meins", meins);
			model.put("werks", werks);
			
			parameterList.setValue(loginUser.getUserId(),"I_UID");	
			parameterList.setValue(loginUser.getUserName(),"I_PID");
			parameterList.setValue(matnr_B,"I_MATNR_B");//变更前物料编号			
			parameterList.setValue(matnr_F,"I_MATNR_F");//变更后物料号			
			parameterList.setValue(wemng,"I_WEMNG");//数量			
			parameterList.setValue(meins,"I_MEINS");//单位			
			parameterList.setValue(lgort,"I_LGORT");//库存地点			
			parameterList.setValue(charg,"I_CHARG");//批次			
			parameterList.setValue(werks,"I_WERKS");//工厂
			parameterList.setValue(chargf,"I_CHARG_F");//工厂
			myConnection.execute(bapi);
			JCO.ParameterList outs = bapi.getExportParameterList();// 输出参数和结构处理
			JCO.ParameterList outtab = bapi.getTableParameterList();// 输出参数和结构处理
			// 返回信息
			JCO.Structure stu01 = outs.getStructure("ES_RETURN");
			String type = stu01.getString("MSGTY");
			message = stu01.getString("MESSAGE");
	
			String mblnr = (outs.getValue("E_MBLNR") + "");// 物料凭证号---
			String tanum = (outs.getValue("E_TANUM") + "");// 转储单编号
			String lgnum = (outs.getValue("E_LGNUM") + "");// 仓库号
			String ubnum = (outs.getValue("E_UBNUM") + "");// 过账更改编号（记账变更号）--传入23接口
			System.out.println("type:" + type + "----message:" + message + "----ubnum:" + ubnum+"----tanum:"+tanum);
			
			model.put("mblnr", mblnr);// 物料凭证号
			model.put("lgnum", lgnum);// 仓库号
			model.put("ubnum", ubnum);// 过账更改编号（记账变更号）
			JCO.Table ET_LQUA = outtab.getTable("ET_LQUA");
			List<Lubu> iList = new ArrayList<Lubu>();
			
			/*int j = 0 , max = 5;
			PaginatedListHelper paginaredList = new PaginatedListHelper();
			String currentPage = ParamUtils.getParameter(request, "page", "1");
			paginaredList.setObjectsPerPage(max);
			paginaredList.setPageNumber(Integer.parseInt(currentPage));
			// //从SAP获取交货单数量的值
	
			paginaredList.setFullListSize(ET_LQUA.getNumRows());
			int pageNum = ET_LQUA.getNumRows() / max;
			if (ET_LQUA.getNumRows() % max > 0) {
				pageNum++;
			}
			for (int i = (Integer.parseInt(currentPage) - 1) * max; i < ET_LQUA.getNumRows(); i++) {
				ET_LQUA.setRow(i);
				Lubu rep = new Lubu();
				rep.setXuhao(j + 1);
				rep.setLqnum(ET_LQUA.getString("LQNUM"));//数量：实际是行项目号
				rep.setLgtyp(ET_LQUA.getString("LGTYP"));//存储类型
				rep.setLgpla(ET_LQUA.getString("LGPLA"));//仓位
				rep.setVerme(ET_LQUA.getString("VERME"));//可用库存
				iList.add(rep);
				j++;
				if (j == max) {
					break;
				}
			}*/
			for (int i = 0; i < ET_LQUA.getNumRows(); i++) {
				ET_LQUA.setRow(i);
				Lubu rep = new Lubu();
				rep.setXuhao(i+1);
				rep.setLqnum(ET_LQUA.getString("LQNUM"));//数量：实际是行项目号
				rep.setLgtyp(ET_LQUA.getString("LGTYP"));//存储类型
				rep.setLgpla(ET_LQUA.getString("LGPLA"));//仓位
				rep.setVerme(ET_LQUA.getString("VERME"));//可用库存
				iList.add(rep);
			}
			if (null != myConnection) {
				SapUtil.releaseClient(myConnection);
			}
			model.put("type", type);
			model.put("message", message);
			model.put("repList", iList);
			/*paginaredList.setList(iList);
			model.put("page", currentPage);
			model.put("pageNum", pageNum);*/
		}catch(Exception e){
			message=e.getMessage();
			e.printStackTrace();
		}
		return new ModelAndView(getViewName(), model);
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
