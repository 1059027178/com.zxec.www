package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.GetMaterial;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class GetMaterialAController implements Controller, AuthenticateController {

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
		String werks = SapUtil.null2String(request.getParameter("werks"));//工厂
		String lgort = SapUtil.null2String(request.getParameter("lgort"));//库存地点
		String budat = SapUtil.null2String(request.getParameter("budat"));//制单日期
		SAPRequest sapRequest = new SAPRequest("ZFM_BC_15_11");
		sapRequest.addParameter("I_UID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
		sapRequest.addParameter("I_PID", "" + request.getSession().getAttribute(SessionManager.USER_NAME));
		sapRequest.addParameter("I_LGORT", lgort);
		sapRequest.addParameter("I_WERKS", werks);
		sapRequest.addParameter("I_BUDAT", budat);
		SAPModel model = SapUtil.OperSAP(sapRequest);
		if ("E".equals(model.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
			models.put("msg", model.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
			return new ModelAndView(getMsg(), models);
		} else {
			List<GetMaterial> items = new ArrayList<GetMaterial>();
			JCO.Table ET_LAGP = model.getOuttab().getTable("ET_AUFNR");
			PaginatedListHelper paginaredList = new PaginatedListHelper();
			String currentPage = ParamUtils.getParameter(request, "page", "1");
			paginaredList.setObjectsPerPage(5);
			paginaredList.setPageNumber(Integer.parseInt(currentPage));
			paginaredList.setFullListSize(ET_LAGP.getNumRows());
			int j = 0;
			int pageNum = ET_LAGP.getNumRows() / 5;
			if (ET_LAGP.getNumRows() % 5 > 0) {
				pageNum++;
			}
			for (int i = (Integer.parseInt(currentPage) - 1) * 5; i < ET_LAGP.getNumRows(); i++) {
				ET_LAGP.setRow(i);
				GetMaterial item = new GetMaterial();
				item.setNum(j + 1);
				item.setMaterialId(ET_LAGP.getString("MRFNR"));
				items.add(item);
				j++;
				if (j == 5) {
					break;
				}
			}

			JCO.Structure struct = model.getOuts().getStructure("ES_RETURN");
			String type = struct.getString("MSGTY");
			paginaredList.setList(items);
			models.put("getMaterialList", items);
			models.put("page", currentPage);
			models.put("pageNum", pageNum);
			models.put("werks", werks);
			models.put("lgort", lgort);
			models.put("budat", budat);
			models.put("type", type);
			if (type.equals("E")) {
				models.put("msg", model.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
				return new ModelAndView(getMsg(), models);
			}
		}
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
