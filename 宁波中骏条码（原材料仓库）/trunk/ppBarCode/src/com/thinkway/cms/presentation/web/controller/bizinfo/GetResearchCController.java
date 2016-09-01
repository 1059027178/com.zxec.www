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

public class GetResearchCController implements Controller, AuthenticateController {

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
		sapRequest.addParameter("I_LGNUM", "311");
		String param = SapUtil.null2String(request.getParameter("param"));
		sapRequest.addParameter("I_MATNR", param.split("@")[0]);
		sapRequest.addParameter("I_CHARG", param.split("@")[1]);
		SAPModel model = SapUtil.OperSAP(sapRequest);
		if ("E".equals(model.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
			models.put("msgType", "E");
			models.put("msg", model.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
		}
		List<MaterialWarehouse> items = MaterialWarehouse.jcoModelToBean(model);
		JSONObject result = new JSONObject();
		result.put("materialWarehouseList", items);
		models.put("materialWarehouseList", result.toString());
		models.put("materialDescription", model.getOuts().getString("E_MAKTX"));
		models.put("materialId", param.split("@")[0]);
		models.put("materialGettenId", param.split("@")[2]);
		models.put("lineItem", param.split("@")[3]);
		models.put("werks", SapUtil.null2String(request.getParameter("werks")));
		models.put("lgort", SapUtil.null2String(request.getParameter("lgort")));
		models.put("budat", SapUtil.null2String(request.getParameter("budat")));
		models.put("requireTotal", SapUtil.null2String(request.getParameter("requireTotal")));
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
