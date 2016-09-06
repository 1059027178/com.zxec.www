package com.thinkway.cms.presentation.controller.restapi;

import java.io.BufferedInputStream;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.displaytag.properties.SortOrderEnum;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController; 

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.SapUtil;
import com.thinkway.cms.business.domains.MatQuy;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.UserLog;
//import com.thinkway.cms.business.query.HallQuery;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.presentation.web.authenticate.AuthenticateController;
import com.thinkway.cms.presentation.web.authenticate.Authenticator;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.presentation.web.core.ResultConstants;
import com.thinkway.cms.presentation.web.core.SessionManager;
import com.thinkway.cms.presentation.web.core.TimeBean;
import com.thinkway.cms.util.DataMethod;
import com.thinkway.cms.util.Escape;
import com.thinkway.cms.util.ExtHelper;
import com.thinkway.cms.util.MD5Util;
import com.thinkway.cms.util.ParamUtils;
import com.thinkway.cms.util.ScaleImage;

/**
 * 
 * @author welson
 * @author 2012-11-18
 * @JSONcontroller-rest API
 *
 */
public class MatQuyJsonController extends MultiActionController implements AuthenticateController{
//private MatQuyService matquyService = null;	
private UserService userService = null;
private Authenticator authenticator = null;
private Long maxUploadSize;
private String uploadDir;// 上传文件路径
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



	public MatQuyJsonController() {
	}
	

//	public void setMatQuyService(MatQuyService matquyService) {
//		this.matquyService = matquyService;
//	}

  
	
	//********获取工厂*****************************	
	public ModelAndView getWerks(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//最新动态
		String lgort=SapUtil.null2String(request.getParameter("lgort"));
		String message="";	
		try{
			JCO.Client myConnection =null;
		    try{
				myConnection =SapUtil.getSAPcon();

			    }catch(Exception e){
			    	
			    }finally{
			    	if(null!=myConnection){
						SapUtil.releaseClient(myConnection);
					}
			    }
		    myConnection.connect(); 
		    //out.println("连接SAP成功");
			String functionName="ZFM_BC_09_12";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
			parameterList.setValue(lgort,"I_LGORT");
			myConnection.execute(bapi);
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			JCO.Structure stu01 = outs.getStructure("ES_RETURN");
			String type=stu01.getString("MSGTY");
			message=stu01.getString("MESSAGE");
			String werks=(outs.getValue("E_WERKS")+"");
			if(null!=myConnection){
				SapUtil.releaseClient(myConnection);
			}
			//System.out.println("type:"+type+"----message:"+message+"----maktx:"+werks);
			response.getWriter().write("{\"werks\": \""+werks+"\"}");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}

	public void setMaxUploadSize(Long maxUploadSize) {
		this.maxUploadSize = maxUploadSize;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	
	

}