package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.MaterialWarehouse;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class OutsourcingBController implements Controller, AuthenticateController {

	private UserService userService = null;
	private String viewName = null;
	private String msg = null;
	private Authenticator authenticator = null;
	private long permission = 0L;
	private String tokenNeed = null;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

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

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Map<Object, Object> models = new HashMap<Object, Object>();
		SAPRequest sapRequest = new SAPRequest("ZFM_BC_03_13");
		sapRequest.addParameter("I_UID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
		//TODO I_LGNUM全局
		sapRequest.addParameter("I_LGNUM", request.getParameter("warehouse"));
		sapRequest.addParameter("I_MATNR", request.getParameter("materialId"));
		sapRequest.addParameter("I_CHARG", request.getParameter("batch"));
		//		sapRequest.addParameter("I_LGNUM", "311");
		//		sapRequest.addParameter("I_MATNR", "C.6.520000");
		//		sapRequest.addParameter("I_CHARG", "0000000067");
		SAPModel model = SapUtil.OperSAP(sapRequest);
		if ("E".equals(model.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
			models.put("msgType", "E");
			models.put("msg", model.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
		}
		List<MaterialWarehouse> items = MaterialWarehouse.jcoModelToBean(model);
		JSONObject result = new JSONObject();
		result.put("materialWarehouseList", items);
		if (items.size() > 0) {
			models.put("supplier", items.get(0).getSupplier());
			models.put("batch", items.get(0).getBatch());
			models.put("factory", items.get(0).getFactory());
			models.put("storageLocation", items.get(0).getStorageLocation());
		}
		result.put("materialWarehouseList", items);
		models.put("materialWarehouseList", result.toString());
		models.put("lineItem", request.getParameter("lineItem"));
		models.put("purchaseOrder", request.getParameter("purchaseOrder"));
		models.put("materialDescription", model.getOuts().getString("E_MAKTX"));
		models.put("materialId", request.getParameter("materialId"));
		//		models.put("lineItem", request.getParameter("lineItem"));
		return new ModelAndView(getViewName(), models);
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
