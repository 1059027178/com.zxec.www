package com.thinkway.cms.presentation.web.controller.delivery;

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

public class DeliveryCrtController implements Controller,
		AuthenticateController {
	private DeliveryService deliveryService = null;
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
		Map<Object, Object> model = new HashMap<Object, Object>();
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID) == null ? null : request.getSession().getAttribute(SessionManager.USER_ID).toString();
		User user = null;
		if (loginUserId == null || loginUserId.equals("")) {
			// insert code here
		} else {
			user = userService.getUser(loginUserId);
			model.put("loginUser", user);
		}
		String matnr = ParamUtils.getParameter(request, "matnr", "");// 获得物料编码
		String werks = ParamUtils.getParameter(request, "werks", "");// 获取工厂
		String lgort = ParamUtils.getParameter(request, "lgort", "");// 获取库存地点
		String charg = ParamUtils.getParameter(request, "charg", "");// 获取批次
		String meins = ParamUtils.getParameter(request, "meins", "");// 单位
		String vltyp = "Z01";
		
		String size  = ParamUtils.getParameter(request, "size", "");// 	大小
		if (size.equals("")) size = "0";
		int    len   = Integer.parseInt(size);
		String etype = "";
		String message = "";
		for (int i = 1; i < len+1; i++) {
			String vlpla = ParamUtils.getParameter(request, "lgpla_"+i, "");// //仓位
			String menge = ParamUtils.getParameter(request, "count_"+i, "");// //数量
			if("".equals(menge)||"0".equals(menge)){
				continue;
			}
			System.out.println("ZFM_BC_03_22=="+vlpla+": "+menge);
			
		

		JCO.Client myConnection = null;
		myConnection = SapUtil.getSAPcon();
		myConnection.connect();
		String functionName = "ZFM_BC_03_22";// 函数的名字
		JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); // 只是一個名字
		IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		// //從這個函數範本獲得該SAP函數的物件
		JCO.Function bapi = ft.getFunction();
		JCO.ParameterList parameterList = bapi.getImportParameterList();// 获得输入表的参数
		// JCO.ParameterList inputtable= bapi.getTableParameterList();//输入表的处理
		// JCO.Table IT_PICK=inputtable.getTable("IT_PICK");

		parameterList.setValue(user.getUserName(), "I_UID");// 用户名字
		parameterList.setValue(matnr, "I_MATNR");// 物料编号
		parameterList.setValue(werks, "I_WERKS");// 工厂
		parameterList.setValue(lgort, "I_LGORT");// 库存地点
		parameterList.setValue(charg, "I_CHARG");// 批次
		parameterList.setValue(meins, "I_MEINS");// 单位
		parameterList.setValue(vltyp, "I_VLTYP");// 存储类型
		
		parameterList.setValue(vlpla, "I_VLPLA");// 仓位号
		parameterList.setValue(menge, "I_MENGE");// 数量

		myConnection.execute(bapi);
		//
		JCO.ParameterList outs = bapi.getExportParameterList();// 输出参数和结构处理
		JCO.ParameterList outtab = bapi.getTableParameterList();// 输出参数和结构处理

		// 如果参数是一个结构，用参数名获得一个对应类型的结构对象
		JCO.Structure ES_RETURN = outs.getStructure("ES_RETURN");
		etype = ES_RETURN.getString("MSGTY");
		message += "<br />"+etype+ "："+ vlpla+"："+ES_RETURN.getString("MESSAGE");
		// 记录日志
		// deliveryService.SystemLog("Delivery"," 交货单拣配过账",vbeln,user.getUserName(),
		// etype+"   "+emessage);
			if (null != myConnection) {
				SapUtil.releaseClient(myConnection);
			}
		}
		model.put("type", etype);
		model.put("message", message);
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

	public DeliveryService getDeliveryService() {
		return deliveryService;
	}

	public void setDeliveryService(DeliveryService deliveryService) {
		this.deliveryService = deliveryService;
	}

}
