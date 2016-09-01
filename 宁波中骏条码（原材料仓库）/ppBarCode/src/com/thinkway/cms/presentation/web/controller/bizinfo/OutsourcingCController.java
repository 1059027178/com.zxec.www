package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sap.mw.jco.JCO.ParameterList;
import com.sap.mw.jco.JCO.Structure;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class OutsourcingCController implements Controller, AuthenticateController {

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
		if (null != request.getParameter("postingJsonString")) {
			String postingJsonString = request.getParameter("postingJsonString");
			JSONArray array = JSONArray.fromObject(postingJsonString);
			String depositListIds = "";
			for (int i = 0; i < array.size(); i++) {
				SAPRequest sapRequest = new SAPRequest("ZFM_BC_03_22");
				JSONObject obj = array.getJSONObject(i);
				if (StringUtils.isNotEmpty(obj.getString("selectAmount"))
						&& !("0".equals(obj.getString("selectAmount")))) {
					sapRequest.addParameter("I_UID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
					sapRequest.addParameter("I_MATNR", obj.getString("materialId"));
					sapRequest.addParameter("I_WERKS", obj.getString("factory"));
					sapRequest.addParameter("I_LGORT", obj.getString("storageLocation"));
					sapRequest.addParameter("I_CHARG", obj.getString("batch"));
					sapRequest.addParameter("I_MENGE", obj.getString("selectAmount"));
					sapRequest.addParameter("I_MEINS", obj.getString("unit"));
					sapRequest.addParameter("I_VLTYP", obj.getString("storageType"));
					sapRequest.addParameter("I_VLPLA", obj.getString("wareHouse"));
					SAPModel model = SapUtil.OperSAP(sapRequest);
					if ("E".equals(model.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
						models.put("msg",
								"仓位" + obj.getString("wareHouse") + "下架时:"
										+ model.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
						return new ModelAndView(getMsg(), models);
					}
					String depositListId = model.getOuts().getString("E_TANUM");
					depositListIds = depositListIds + depositListId + ",";
					Thread.sleep(250);
				}
			}
			if(array.size()>0){
				SAPRequest sapRequest = new SAPRequest("ZFM_BC_17_11");
				JSONObject obj = array.getJSONObject(0);
				if (StringUtils.isNotEmpty(obj.getString("selectAmount"))
						&& !("0".equals(obj.getString("selectAmount")))) {
					sapRequest.addParameter("I_UID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
					sapRequest.addParameter("I_PID", "" + request.getSession().getAttribute(SessionManager.USER_NAME));
					sapRequest.addParameter("I_WERKS", SapUtil.null2String(request.getParameter("factory")));
					sapRequest.addParameter("I_MATNR", SapUtil.null2String(request.getParameter("materialId")));
					sapRequest.addParameter("I_WEMNG", SapUtil.null2String(request.getParameter("sum")));
					sapRequest.addParameter("I_LGORT", SapUtil.null2String(request.getParameter("storageLocation")));
					sapRequest.addParameter("I_CHARG", SapUtil.null2String(request.getParameter("batch")));
					SAPModel model = SapUtil.OperSAP(sapRequest);
					if ("E".equals(model.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
						models.put("msg",
								"仓位" + obj.getString("wareHouse") + "下架时:"
										+ model.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
						return new ModelAndView(getMsg(), models);
					}
					String ltd=model.getOuts().getString("E_EBELP");
					try{
						int lti=Integer.parseInt(ltd);
						ltd =""+lti;
					}catch(Exception e){
						e.printStackTrace();
					}
					models.put("lineItem", ltd);
					models.put("purchaseOrder", model.getOuts().getString("E_EBELN"));
					models.put("supplier", model.getOuts().getString("E_LIFNR"));
					Thread.sleep(250);
				}
				
			}
			models.put("msg", "转储单:" + depositListIds.substring(0, depositListIds.length()) + "创建成功!");
			models.put("materialId", request.getParameter("to"));
		}
		models.put("materialGettenId", SapUtil.null2String(request.getParameter("materialGettenId")));
		models.put("materialDescription", SapUtil.null2String(request.getParameter("materialDescription")));
		models.put("storageLocation", SapUtil.null2String(request.getParameter("storageLocation")));
		models.put("materialId", SapUtil.null2String(request.getParameter("materialId")));
		models.put("sum", SapUtil.null2String(request.getParameter("sum")));
		models.put("batch", SapUtil.null2String(request.getParameter("batch")));
		models.put("factory", SapUtil.null2String(request.getParameter("factory")));
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
