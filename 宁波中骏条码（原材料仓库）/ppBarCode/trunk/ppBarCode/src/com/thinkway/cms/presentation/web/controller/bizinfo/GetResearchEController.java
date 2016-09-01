package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class GetResearchEController implements Controller, AuthenticateController {

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
		//查询明细
		Map<Object, Object> models = new HashMap<Object, Object>();
		SAPRequest sapRequest = new SAPRequest("ZFM_BC_16_12");
		models.put("werks", SapUtil.null2String(request.getParameter("werks")));
		models.put("lgort", SapUtil.null2String(request.getParameter("lgort")));
		models.put("budat", SapUtil.null2String(request.getParameter("budat")));
		sapRequest.addParameter("I_UID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
		String materialGettenId = SapUtil.null2String(request.getParameter("materialGettenId"));
		sapRequest.addParameter("I_MRFNR", materialGettenId);
		SAPModel model = SapUtil.OperSAP(sapRequest);
		if ("E".equals(model.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
			models.put("msg", model.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
			return new ModelAndView(getMsg(), models);
		} else {
			//过账
			SAPRequest sapRequest2 = new SAPRequest("ZFM_BC_16_21");
			sapRequest2.addParameter("I_UID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
			JCO.Table jTable = model.getOuttab().getTable("ET_DETAIL");
			for (int i = 0; i < jTable.getNumRows(); i++) {
				jTable.setRow(i);
				sapRequest2.addInputTable(
						"IT_DETAIL",
						new String[] { "MRFNR", "SEQNO", "WERKS", "ZZMATNR", "ZZMAKTX", "ZZREMNG", "ZZFLORT",
								"ZZMEINS", "ZZCHARG", "ZZJPMNG", "AUFNR", "KOSTL", "SGTXT" },
						new String[] { jTable.getString("MRFNR"), jTable.getString("SEQNO"),
								SapUtil.null2String(request.getParameter("werks")), jTable.getString("ZZMATNR"),
								jTable.getString("ZZMAKTX"), jTable.getString("ZZREMNG"), jTable.getString("ZZFLORT"),
								jTable.getString("ZZMEINS"), jTable.getString("ZZCHARG"), jTable.getString("ZZJPMNG"),
								jTable.getString("AUFNR"), jTable.getString("KOSTL"), jTable.getString("SGTXT") });
			}
			SAPModel model2 = SapUtil.OperSAP(sapRequest2);
			models.put("msg", model2.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
			if ("E".equals(model2.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
				return new ModelAndView(getMsg(), models);
			} else {
				return new ModelAndView(getViewName(), models);
			}
		}
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
