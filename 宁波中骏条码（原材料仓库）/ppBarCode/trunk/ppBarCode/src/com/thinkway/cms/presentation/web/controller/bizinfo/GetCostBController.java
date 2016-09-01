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
import com.thinkway.cms.business.domains.CostDetail;
import com.thinkway.cms.business.domains.GetMaterial;
import com.thinkway.cms.business.domains.MaterialDetail;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class GetCostBController implements Controller, AuthenticateController {

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
//		SAPRequest sapRequest = new SAPRequest("ZFM_BC_15_12");//生产调拨领料
		SAPRequest sapRequest = new SAPRequest("ZFM_BC_18_12");//成本中心领料
		sapRequest.addParameter("I_UID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
		String costGettenId=SapUtil.null2String(request.getParameter("costGettenId"));
		sapRequest.addParameter("I_MBLNR", costGettenId);
		SAPModel model = SapUtil.OperSAP(sapRequest);
		JCO.Structure struct = model.getOuts().getStructure("ES_RETURN");
		String type = struct.getString("MSGTY");
		if (type.equals("E")) {
			models.put("msg", model.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
			return new ModelAndView(getMsg(), models);
		}

		List<CostDetail> items = new ArrayList<CostDetail>();
		JCO.Table jTable = model.getOuttab().getTable("ET_DETAIL1");
		PaginatedListHelper paginaredList = new PaginatedListHelper();
		String currentPage = ParamUtils.getParameter(request, "page", "1");
		paginaredList.setObjectsPerPage(3);
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		paginaredList.setFullListSize(jTable.getNumRows());
		int j = 0;
		int pageNum = jTable.getNumRows() / 3;
		if (jTable.getNumRows() % 3 > 0) {
			pageNum++;
		}
		for (int i = (Integer.parseInt(currentPage) - 1) * 3; i < jTable.getNumRows(); i++) {
			jTable.setRow(i);
			CostDetail item = new CostDetail();
			item.setNum(j + 1);
			item.setCostGettenId(jTable.getString("MBLNR"));
			item.setLineItem(jTable.getString("ZEILE"));
			item.setFactory(jTable.getString("WERKS"));
			item.setWarehouse(jTable.getString("KOSTL"));
			item.setMaterialId(jTable.getString("MATNR"));
			item.setMaterialDescription(jTable.getString("MAKTX"));
			item.setPerAmount(String.valueOf(jTable.getDouble("MENGE")));
			item.setSendLocation(jTable.getString("LGORT"));
			item.setUnit(jTable.getString("MEINS"));
			item.setBatch(jTable.getString("CHARG"));
			item.setPickingAmount(String.valueOf(jTable.getDouble("ZJPSL")));
			items.add(item);
			j++;
			if (j == 3) {
				break;
			}

			paginaredList.setList(items);
			models.put("costDetailList", items);
			models.put("page", currentPage);
			models.put("pageNum", pageNum);
			models.put("werks", SapUtil.null2String(request.getParameter("werks")));
			models.put("lgort", SapUtil.null2String(request.getParameter("lgort")));
			models.put("budat", SapUtil.null2String(request.getParameter("budat")));
			models.put("costGettenId", costGettenId);

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
