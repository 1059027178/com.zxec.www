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
import com.thinkway.cms.business.domains.Receipt;
import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.domains.UserLog;
import com.thinkway.cms.business.query.ReceiptQuery;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.query.hrminfoQuery;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.business.service.iface.hrminfoService;
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
public class ReceiptJsonController extends MultiActionController implements AuthenticateController{
private UserService userService = null;
private Authenticator authenticator = null;
private hrminfoService hrminfoService = null;	
private long permission = 0L;
private String uploadDir;// 上传文件路径
private Long maxUploadSize;
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



	public ReceiptJsonController() {
	}
  
	//********获取物料描述*****************************	
	public ModelAndView getMaktx(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//最新动态
		String matnr=SapUtil.null2String(request.getParameter("matnr"));
		String message="";	
		try{
		//out.println(aufnr+"/"+iquan+"/"+gmein);
			JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPcon();
		    myConnection.connect(); 
		    //out.println("连接SAP成功");
			String functionName="ZFM_BC_COMMON_01";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
			parameterList.setValue(matnr,"I_MATNR");
			myConnection.execute(bapi);
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			JCO.Structure stu01 = outs.getStructure("ES_RETURN");
			String type=stu01.getString("MSGTY");
			message=stu01.getString("MESSAGE");
			String maktx=(outs.getValue("E_MAKTX")+"");
			if(null!=myConnection){
				SapUtil.releaseClient(myConnection);
			}
			System.out.println("type:"+type+"----message:"+message+"----maktx:"+maktx);
			response.getWriter().write("{\"maktx\": \""+maktx+"\"}");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	//********匹配工号*****************************	
	public ModelAndView checkObjno(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//最新动态
		String objno=SapUtil.null2String(request.getParameter("objno"));
		String message="";	
		try{
			System.out.println("objno:"+objno);
			int count=hrminfoService.gethrminfoCountsByObjno(objno);
			System.out.println("count:"+count);
			response.getWriter().write("{\"count\": \""+count+"\"}");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	//********获取仓库号*****************************	
	public ModelAndView getPlnum(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//最新动态
		System.out.println("ZFM_BC_03_14");
		String matnr=SapUtil.null2String(request.getParameter("matnr"));
		String message="";	
		try{
		//out.println(aufnr+"/"+iquan+"/"+gmein);
			JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPcon();
		    myConnection.connect(); 
		    //out.println("连接SAP成功");
//			String functionName="ZFM_BC_03_12";//函数的名字
			String functionName="ZFM_BC_03_14";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
			parameterList.setValue(matnr,"I_MATNR");
			myConnection.execute(bapi);
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			JCO.Structure stu01 = outs.getStructure("ES_RETURN");
			String type=stu01.getString("MSGTY");
			message=stu01.getString("MESSAGE");
			String lgnum=(outs.getValue("E_LGNUM")+"");
			String maktx=(outs.getValue("E_MAKTX")+"");
			String werks=(outs.getValue("E_WERKS")+"");
			if(null!=myConnection){
				SapUtil.releaseClient(myConnection);
			}
			System.out.println("type:"+type+"----message:"+message+"----maktx:"+lgnum);
			response.getWriter().write("{\"lgnum\": \""+lgnum+"\",\"maktx\":\""+maktx+"\",\"werks\":\""+werks+"\"}");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	//**********获得仓位信息************
	public ModelAndView getNlpla(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//最新动态
		String nlpla=SapUtil.null2String(request.getParameter("nlpla"));
		String lgort=SapUtil.null2String(request.getParameter("lgort"));
		String message="";	
		try{
		//out.println(aufnr+"/"+iquan+"/"+gmein);
			JCO.Client myConnection =null;
			myConnection =SapUtil.getSAPcon();
		    myConnection.connect(); 
		    //out.println("连接SAP成功");
			String functionName="ZFM_BC_02_11";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
	    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
			JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
			parameterList.setValue(lgort,"I_LGORT");
			parameterList.setValue(nlpla,"I_LGPLA");
			myConnection.execute(bapi);
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			JCO.Structure stu01 = outs.getStructure("ES_RETURN");
			String type=stu01.getString("MSGTY");
			message=stu01.getString("MESSAGE");
			String lgber=(outs.getValue("E_LGBER")+"");//仓储区
			String lgtyp=(outs.getValue("E_LGTYP")+"");//存储类型
			if(null!=myConnection){
				SapUtil.releaseClient(myConnection);
			}
			//System.out.println("type:"+type+"----message:"+message+"----maktx:"+maktx);
			response.getWriter().write("{\"lgber\": \""+lgber+"\",\"lgtyp\": \""+lgtyp+"\"}");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
		
	}
	//********获取receipt清单*****************************	
	public ModelAndView getReceiptList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//最新动态
		String kw = ParamUtils.getParameter(request, "kw", "");
		int skip = ParamUtils.getIntParameter(request, "skip", 0);
		int cate = ParamUtils.getIntParameter(request, "cate", 0);
		ReceiptQuery cQ1 = new ReceiptQuery();
		//if(cate>0)cQ1.setReceiptClass(cate);
		cQ1.setSkip(skip);
		cQ1.setLimit(20);
		cQ1.setSdir("desc");
		cQ1.setSort("sortstr");
		//List<Receipt> zxList = receiptService.getAllReceipts(cQ1);
		//String json=ExtHelper.getJsonFromList2(zxList);
		response.setContentType("text/plain;charset=UTF-8");
		//response.getWriter().write(json);	
		return null;
		
	}
	
	
	//********新建生产订单收货*****************************	
	public ModelAndView createReceipt(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/plain;charset=UTF-8");
		
		//用户鉴权--begin
		String userId = ""+request.getSession().getAttribute(SessionManager.USER_ID);
		User user = null;
		if(userId.equals("")){
			//根据传过来的用户名和密码进行匹配		
			String userBH = ParamUtils.getParameter(request, "userBH", "");
			String pwd = ParamUtils.getParameter(request, "pwd", "000");		
			if(userBH.equals("")){
				response.getWriter().write("{\"errmsg\": \"用户登录账号不能为空！\"}");
				return null;			
			}
			User loginUser = new User();
			loginUser.setUserBH(userBH);
			loginUser.setUserPassword(pwd);
			user = userService.findUserForLogin(loginUser);		
		}else{
			user = userService.getUser(userId);
		}
		
		if(user==null){
			response.getWriter().write("{\"errmsg\": \"用户未授权!\"}");
			return null;
		}
		//该功能为管理员功能-需要鉴定管理员权限
		if(user.getUserFunction().indexOf("1001")<0){
			response.getWriter().write("{\"errmsg\": \"用户权限不够!\"}");
			return null;
		}
		//end - 用户鉴权
		
		
		/*
		String sortstr=ParamUtils.getParameter(request, "sortstr","");
		String linkAddr=ParamUtils.getParameter(request, "linkAddr","");
		String postContent=ParamUtils.getParameter(request, "postContent","");
		String isRel=ParamUtils.getParameter(request, "isRel","N");
		*/
		
		
		Map<Object, Object> model = new HashMap<Object, Object>();	
		String loginUserId = request.getSession().getAttribute(SessionManager.USER_ID)==null?null:request.getSession().getAttribute(SessionManager.USER_ID).toString();
		
		if(loginUserId==null||loginUserId.equals("")){
			//insert code here
		}else{
			User loginUser = userService.getUser(loginUserId);			
			model.put("loginUser",loginUser);			
		}	
		String aufnr = SapUtil.null2String(request.getParameter("aufnr"));//生产订单号
		String matnr = SapUtil.null2String(request.getParameter("iquan"));//物料编码
		String wemng = SapUtil.null2String(request.getParameter("wemng"));//总数量
		String meng = SapUtil.null2String(request.getParameter("meng"));//尾箱箱数
		String charg = SapUtil.null2String(request.getParameter("charg"));//批次号
		String sobkz = SapUtil.null2String(request.getParameter("sobkz"));//特殊库存标识
		String lgort = SapUtil.null2String(request.getParameter("lgort"));//库存地点
		String meins = SapUtil.null2String(request.getParameter("meins"));
		//String aufnr = SapUtil.null2String(request.getParameter("aufnr"));
		String message="";	
		//out.println(aufnr+"/"+iquan+"/"+gmein);
		JCO.Client myConnection =null;
		myConnection =SapUtil.getSAPcon();
	    myConnection.connect(); 
	    //out.println("连接SAP成功");
		String functionName="ZFM_BC_01_11";//函数的名字
	    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
	    //從這個函數範本獲得該SAP函數的物件
	    JCO.Function bapi = ft.getFunction();
    	JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
		JCO.ParameterList   inputtable= bapi.getTableParameterList();//输入表的处理
		
		//JCO.Table  IT_ITEM=inputtable.getTable("IT_ITEM");
		//if(!aufnr.isEmpty()&&!iquan.isEmpty()&&!gmein.isEmpty()){
		//IT_ITEM.appendRow();		
		parameterList.setValue("EE","I_UID");			
		//parameterList.setValue(aufnr,"I_AUFNR");					
		parameterList.setValue(aufnr,"I_AUFNR");
		parameterList.setValue(wemng,"I_WEMNG");
		parameterList.setValue(charg,"I_CHARG");
		parameterList.setValue(sobkz,"I_SOBKZ");
		parameterList.setValue(lgort,"I_LGORT");
		parameterList.setValue(meins,"I_MEINS");
		
		myConnection.execute(bapi);
		
		JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
		JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
		
		
		JCO.Structure stu01 = outs.getStructure("ES_RETURN");
		String type=stu01.getString("MSGTY");
		message=stu01.getString("MESSAGE");
		String mblnr=(outs.getValue("E_MBLNR")+"");
			
		System.out.println("type:"+type+"----message:"+message+"----mblnr:"+mblnr);
		//}else{
			//message="必要信息不完整";
		//}
	
		
		if(type.equals("")){
			response.getWriter().write("{\"errmsg\": \"生产订单收货失败!\"}");
			return null;
		}
		if(null!=myConnection){
			SapUtil.releaseClient(myConnection);
		}
		//记录日志
		userService.SystemLog("receipt","生产订单收货表",""+aufnr,""+user.getUserBH(),
				"生产订单收货["+aufnr+"]创建成功!");
		
	
		//response.getWriter().write("ok");
		//String json=ExtHelper.getJsonFromBean(acObj);
		//response.getWriter().write(json);
		
		return null;
   }
	
	
	//********修改生产订单收货*****************************	
	public ModelAndView updateReceipt(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/plain;charset=UTF-8");
		
		//用户鉴权--begin
		String userId = ""+request.getSession().getAttribute(SessionManager.USER_ID);
		User user = null;
		if(userId.equals("")){
			//根据传过来的用户名和密码进行匹配		
			String userBH = ParamUtils.getParameter(request, "userBH", "");
			String pwd = ParamUtils.getParameter(request, "pwd", "000");		
			if(userBH.equals("")){
				response.getWriter().write("{\"errmsg\": \"用户登录账号不能为空！\"}");
				return null;			
			}
			User loginUser = new User();
			loginUser.setUserBH(userBH);
			loginUser.setUserPassword(pwd);
			user = userService.findUserForLogin(loginUser);		
		}else{
			user = userService.getUser(userId);
		}
		
		if(user==null){
			response.getWriter().write("{\"errmsg\": \"用户未授权!\"}");
			return null;
		}
		//该功能为管理员功能-需要鉴定管理员权限
		if(user.getUserFunction().indexOf("1001")<0){
			response.getWriter().write("{\"errmsg\": \"用户权限不够!\"}");
			return null;
		}
		//end - 用户鉴权
		
		int receiptId=ParamUtils.getIntParameter(request, "receiptId",0);
		if(receiptId==0){
			response.getWriter().write("{\"errmsg\": \"生产订单收货ID不能为空!\"}");
			return null;
		}
		
		
		/*
		String sortstr=ParamUtils.getParameter(request, "sortstr","");
		String linkAddr=ParamUtils.getParameter(request, "linkAddr","");
		String postContent=ParamUtils.getParameter(request, "postContent","");
		String isRel=ParamUtils.getParameter(request, "isRel","N");
		*/
		
		Receipt acObj = null;//receiptService.getReceiptDetail(""+receiptId);
		//acObj.setReceiptClass(new Integer(receiptClass));
		String aufnr=ParamUtils.getParameter(request, "aufnr","");
		if(aufnr.equals("")){
			response.getWriter().write("{\"errmsg\": \"生产订单不能为空!\"}");
			return null;
		}
		acObj.setAufnr(aufnr);
		String matnr=ParamUtils.getParameter(request, "matnr","");
		acObj.setMatnr(matnr);
		String maktx=ParamUtils.getParameter(request, "maktx","");
		acObj.setMaktx(maktx);
		String bs=ParamUtils.getParameter(request, "bs","");
		if(bs.equals("")){
			response.getWriter().write("{\"errmsg\": \"尾箱标识不能为空!\"}");
			return null;
		}
		acObj.setBs(bs);
		String meng=ParamUtils.getParameter(request, "meng","");
		acObj.setMeng(meng);
		String boxes=ParamUtils.getParameter(request, "boxes","");
		if(boxes.equals("")){
			response.getWriter().write("{\"errmsg\": \"箱数不能为空!\"}");
			return null;
		}
		acObj.setBoxes(boxes);
		String charg=ParamUtils.getParameter(request, "charg","");
		acObj.setCharg(charg);
		String wemng=ParamUtils.getParameter(request, "wemng","");
		if(wemng.equals("")){
			response.getWriter().write("{\"errmsg\": \"总数量不能为空!\"}");
			return null;
		}
		acObj.setWemng(wemng);
		String meins=ParamUtils.getParameter(request, "meins","");
		acObj.setMeins(meins);
		String lgort=ParamUtils.getParameter(request, "lgort","");
		if(lgort.equals("")){
			response.getWriter().write("{\"errmsg\": \"库存地点不能为空!\"}");
			return null;
		}
		acObj.setLgort(lgort);
		String sobkz=ParamUtils.getParameter(request, "sobkz","");
		if(sobkz.equals("")){
			response.getWriter().write("{\"errmsg\": \"热属库存标识不能为空!\"}");
			return null;
		}
		acObj.setSobkz(sobkz);

		/*
		acObj.setPostDate(new Timestamp(System.currentTimeMillis()));
		acObj.setPostTitle(postTitle);
		acObj.setPostContent(postContent);
		acObj.setLinkAddr(linkAddr);
		acObj.setSortstr(sortstr);
		acObj.setIsRel(isRel);
		*/
		
		//if(!receiptService.updateReceipt(acObj)){
			//response.getWriter().write("{\"errmsg\": \"生产订单收货修改失败!\"}");
		//	return null;
		///}
		
		//记录日志
		//userService.SystemLog("receipt","生产订单收货表",""+acObj.getReceiptId(),""+user.getUserBH(),
		//		"生产订单收货["+acObj.getReceiptId()+"]修改成功!");
		
		response.getWriter().write("{\"errmsg\": \"ok\"}");		
		return null;
   }
	
	
	//********删除生产订单收货*****************************	
	public ModelAndView deleteReceipt(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/plain;charset=UTF-8");
		
		//用户鉴权--begin
		String userId = ""+request.getSession().getAttribute(SessionManager.USER_ID);
		User user = null;
		if(userId.equals("")){
			//根据传过来的用户名和密码进行匹配		
			String userBH = ParamUtils.getParameter(request, "userBH", "");
			String pwd = ParamUtils.getParameter(request, "pwd", "000");		
			if(userBH.equals("")){
				response.getWriter().write("{\"errmsg\": \"用户登录账号不能为空！\"}");
				return null;			
			}
			User loginUser = new User();
			loginUser.setUserBH(userBH);
			loginUser.setUserPassword(pwd);
			user = userService.findUserForLogin(loginUser);		
		}else{
			user = userService.getUser(userId);
		}
		
		if(user==null){
			response.getWriter().write("{\"errmsg\": \"用户未授权!\"}");
			return null;
		}
		//该功能为管理员功能-需要鉴定管理员权限
		if(user.getUserFunction().indexOf("1001")<0){
			response.getWriter().write("{\"errmsg\": \"用户权限不够!\"}");
			return null;
		}
		//end - 用户鉴权
		
		int receiptId=ParamUtils.getIntParameter(request, "receiptId",0);
		if(receiptId==0){
			response.getWriter().write("{\"errmsg\": \"生产订单收货ID不能为空!\"}");
			return null;
		}
		
		
		
		//if(!receiptService.deleteReceiptById(""+receiptId)){
		//	response.getWriter().write("{\"errmsg\": \"生产订单收货删除失败!\"}");
		//	return null;
		//}
		
		//记录日志
		userService.SystemLog("receipt","生产订单收货表",""+receiptId,""+user.getUserBH(),
				"生产订单收货["+receiptId+"]删除成功!");
		
	
		response.getWriter().write("{\"errmsg\": \"ok\"}");		
		return null;
   }
   
   
   //********删除生产订单收货-多个*****************************	
	public ModelAndView deleteReceipts(HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.setContentType("text/plain;charset=UTF-8");
		
		//用户鉴权--begin
		String userId = ""+request.getSession().getAttribute(SessionManager.USER_ID);
		User user = null;
		if(userId.equals("")){
			//根据传过来的用户名和密码进行匹配		
			String userBH = ParamUtils.getParameter(request, "userBH", "");
			String pwd = ParamUtils.getParameter(request, "pwd", "000");		
			if(userBH.equals("")){
				response.getWriter().write("{\"errmsg\": \"用户登录账号不能为空！\"}");
				return null;			
			}
			User loginUser = new User();
			loginUser.setUserBH(userBH);
			loginUser.setUserPassword(pwd);
			user = userService.findUserForLogin(loginUser);		
		}else{
			user = userService.getUser(userId);
		}
		
		if(user==null){
			response.getWriter().write("{\"errmsg\": \"用户未授权!\"}");
			return null;
		}
		//该功能为管理员功能-需要鉴定管理员权限
		if(user.getUserFunction().indexOf("1001")<0){
			response.getWriter().write("{\"errmsg\": \"用户权限不够!\"}");
			return null;
		}
		//end - 用户鉴权
		
		String items = request.getParameter("delitems");  
        String[] item = items.split(","); 
        
       /// if(!receiptService.deleteReceiptByIds(item)){
		//	response.getWriter().write("{\"errmsg\": \"生产订单收货删除失败!\"}");
		//	return null;
		//}
        

		//记录日志
		userService.SystemLog("receiptTable","生产订单收货表","",""+user.getUserBH(),
				"生产订单收货["+items+"]删除成功!");
        
		
		
		response.getWriter().write("{\"errmsg\": \"ok\"}");		
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

	public hrminfoService getHrminfoService() {
		return hrminfoService;
	}

	public void setHrminfoService(hrminfoService hrminfoService) {
		this.hrminfoService = hrminfoService;
	}
	
	
	
	
	

}