package com.thinkway.cms.presentation.web.controller.bizinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.MaterialDetail;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class GetMaterialEController implements Controller, AuthenticateController {

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
		//获取前端提交对应值
		List<MaterialDetail> list = (List) request.getSession().getAttribute("list");
		Map<Object, Object> models = new HashMap<Object, Object>();
		String materialGettenId = SapUtil.null2String(request.getParameter("materialGettenId"));
		String werks = SapUtil.null2String(request.getParameter("werks"));
		String lgort = SapUtil.null2String(request.getParameter("lgort"));
		String budat = SapUtil.null2String(request.getParameter("budat"));
		models.put("werks", werks);
		models.put("lgort", lgort);
		models.put("budat", budat);
		String I_UID = "" + request.getSession().getAttribute(SessionManager.USER_ID);
//		过账
		SAPRequest sapRequest2 = new SAPRequest("ZFM_BC_15_21");
		sapRequest2.addParameter("I_UID", "" + I_UID);
		for( int i = 1 ; i <= list.size() ; i++ ){
			MaterialDetail pic = (MaterialDetail) list.get(i - 1);
			String MRFNR = pic.getMaterialGettenId();//领料单号
			String SEQNO = pic.getLineItem();//行项目号
			String ZZMATNR = pic.getMaterialId();//物料号
			String ZZMAKTX = pic.getMaterialDescription();//物料描述
			String ZZREMNG = pic.getPerAmount();//预制数量
			String ZZFLORT = pic.getSendLocation();//发料仓库
			String ZZLGORT = pic.getWarehouse();//收料仓库
			String ZZMEINS = pic.getUnit();//单位R
			String ZZCHARG = pic.getBatch();//批次
			//从界面获取输入的拣配数量
			String ZZJPMNG = SapUtil.null2String(request.getParameter("pickAmount" + i)) == "" ? "0" : SapUtil.null2String(request.getParameter("pickAmount" + i));
			System.out.println("录入的拣配数量为 = " + ZZJPMNG);
//			String ZZJPMNG = pic.getPickingAmount();//拣配数量
			sapRequest2.addInputTable(
				"IT_DETAIL",
				new String[] {"MRFNR", "SEQNO", "WERKS", "ZZLGORT", "ZZMATNR", "ZZMAKTX", "ZZREMNG","ZZFLORT", "ZZMEINS", "ZZCHARG", "ZZJPMNG" },
				new String[] {MRFNR	 ,	SEQNO,	 werks,	  ZZLGORT,	 ZZMATNR,	ZZMAKTX,   ZZREMNG,	 lgort,	ZZMEINS,   ZZCHARG,	  ZZJPMNG}
			);
		}
		SAPModel model2 = SapUtil.OperSAP(sapRequest2);
		models.put("msg", model2.getOuts().getStructure("ES_RETURN").getString("MESSAGE"));
		if ("E".equals(model2.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
			return new ModelAndView(getMsg(), models);
		} else {
			return new ModelAndView(getViewName(), models);
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
