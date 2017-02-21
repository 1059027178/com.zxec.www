package com.thinkway.cms.presentation.web.controller.bizinfo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class ReceiveController extends MultiActionController implements AuthenticateController {

	private UserService userService = null;
	private Authenticator authenticator = null;
	private Long maxUploadSize;
	private String uploadDir;
	private long permission = 0L;
	private String tokenNeed = null;

	public ModelAndView poReceive(HttpServletRequest request, HttpServletResponse response) throws Exception {
		SAPRequest sapRequest = new SAPRequest(SapUtil.null2String(request.getParameter("interface")));
		/*sapRequest.addParameter("I_UID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
		sapRequest.addParameter("I_PID", "" + request.getSession().getAttribute(SessionManager.USER_NAME));
		sapRequest.addParameter("I_EBELN", SapUtil.null2String(request.getParameter("purchaseOrder")));
		sapRequest.addParameter("I_EBELP", SapUtil.null2String(request.getParameter("lineItem")));
		sapRequest.addParameter("I_WEMNG", SapUtil.null2String(request.getParameter("totalAmount")));
		sapRequest.addParameter("I_MEINS", SapUtil.null2String(request.getParameter("unit")));
		sapRequest.addParameter("I_LGORT", SapUtil.null2String(request.getParameter("storageLocation")));
		sapRequest.addParameter("I_CHARG", SapUtil.null2String(request.getParameter("batch")));
		sapRequest.addParameter("I_CHARG_G", SapUtil.null2String(request.getParameter("supplierBatch")));
		sapRequest.addParameter("I_BUDAT_G", SapUtil.null2String(request.getParameter("produceDate")));*/
		
		/**
		 * 20161221修改
		 * 作者：qy
		 */
		sapRequest.addParameter("I_USERID", "" + request.getSession().getAttribute(SessionManager.USER_ID));
		sapRequest.addParameter("I_USERNAME", "" + request.getSession().getAttribute(SessionManager.USER_NAME));
		sapRequest.addParameter("I_WERKS", "3200");
		sapRequest.addParameter("I_LIFNR", SapUtil.null2String(request.getParameter("lifnr")));
		sapRequest.addParameter("I_LGORT", SapUtil.null2String(request.getParameter("storageLocation")));
		sapRequest.addParameter("I_CHARG", SapUtil.null2String(request.getParameter("batch")));
		sapRequest.addParameter("I_HSDAT", SapUtil.null2String(request.getParameter("produceDate")));
		sapRequest.addParameter("I_LICHA", SapUtil.null2String(request.getParameter("supplierBatch")));
		sapRequest.addParameter("I_MENGE", SapUtil.null2String(request.getParameter("totalAmount")));
		//如果无物料编码--则将物料描述传入物料编码
		String materialId = SapUtil.null2String(request.getParameter("materialId"));
		if(!materialId.equals("")){
			sapRequest.addParameter("I_MATNR", SapUtil.null2String(request.getParameter("materialId")));
		}else{
			sapRequest.addParameter("I_MATNR", SapUtil.null2String(request.getParameter("description")));
			System.out.println("物料描述 == " + SapUtil.null2String(request.getParameter("description")));
		}
		SAPModel model = SapUtil.OperSAP(sapRequest);
		if ("E".equals(model.getOuts().getStructure("ES_RETURN").getString("MSGTY"))) {
			response.getWriter().write(
					"{\"msgType\": \"" + "E" + "\",\"msg\":\""
							+ model.getOuts().getStructure("ES_RETURN").getString("MESSAGE") + "\"}");
		} else {
			response.getWriter().write(
					"{\"msgType\": \"" + "S" + "\",\"msg\":\""
							+ model.getOuts().getStructure("ES_RETURN").getString("MESSAGE") + "\"}");
		}
		return null;

	}

	public ModelAndView getMaktx(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//最新动态
		String matnr = SapUtil.null2String(request.getParameter("matnr"));
		String message = "";
		try {
			//out.println(aufnr+"/"+iquan+"/"+gmein);
			JCO.Client myConnection = null;
			myConnection = SapUtil.getSAPcon();
			myConnection.connect();
			//out.println("连接SAP成功");
			String functionName = "ZFM_BC_COMMON_01";//函数的名字
			JCO.Repository myRepository = new JCO.Repository("Repository", myConnection); //只是一個名字
			IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
			//從這個函數範本獲得該SAP函數的物件
			JCO.Function bapi = ft.getFunction();
			JCO.ParameterList parameterList = bapi.getImportParameterList();//获得输入表的参数
			JCO.ParameterList inputtable = bapi.getTableParameterList();//输入表的处理
			parameterList.setValue(matnr, "I_MATNR");
			myConnection.execute(bapi);
			JCO.ParameterList outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList outtab = bapi.getTableParameterList();//输出参数和结构处理
			JCO.Structure stu01 = outs.getStructure("ES_RETURN");
			String type = stu01.getString("MSGTY");
			message = stu01.getString("MESSAGE");
			String maktx = (outs.getValue("E_MAKTX") + "");
			if (null != myConnection) {
				SapUtil.releaseClient(myConnection);
			}
			System.out.println("type:" + type + "----message:" + message + "----maktx:" + maktx);
			response.getWriter().write("{\"maktx\": \"" + maktx + "\"}");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

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

	public ReceiveController() {
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Long getMaxUploadSize() {
		return maxUploadSize;
	}

	public void setMaxUploadSize(Long maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public UserService getUserService() {
		return userService;
	}

}