package cn.webChatServer.service;

import java.util.Date;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webChatServer.dao.WXInfoDao;
import cn.webChatServer.pojo.WXInfo;
import cn.webChatServer.service.WebChatService;

import com.webChatServer.util.NetWorkUtil;
import com.webChatServer.util.SignUtil;
import com.webChatServer.util.WebChartPort;

//@Component
@Service("webChatService")
public class WebChatServiceImpl implements WebChatService{
	@Autowired
	private WXInfoDao wxInfoDao;
	private WXInfo wxInfo = null;
	private JSONObject jsonObject = null;
	private int errcode = 0;
	private String errmsg ="";
	private String access_token = "";
	private String URL = "";
	
//	暂时不使用定时更新---因为当已存在token时，实际的有效期小于标准值
//	@Scheduled(cron= WebChartPort.GET_TOKEN_REFRESH_TIME)
	public void achieveAccessToken() {
		Date date = new Date();
		System.out.println("【时间：" + date.toString() + ",获取accessToken开始】>>>>>>");
		
		//获取企业号corpID，secretID
		wxInfo = wxInfoDao.queryByClassName(WebChartPort.WEB_CHAT_NAME);
		String corpID = wxInfo.getCorpID();
		String secretID = wxInfo.getSecretID();
		
		//拼接获取access_token接口请求地址
		URL = WebChartPort.ACCESS_TOKEN.replace("ID", corpID).replace("SECRECT", secretID);
		
		//发起HTTPS请求
		//方式一：
		jsonObject = new JSONObject();
		jsonObject = NetWorkUtil.httpsRequest(URL, "GET", null);
		//方式二：
		//发起HTTP请求
//		String string = NetWorkUtil.httpRequest(URL, "GET", null);
//		jsonObject = new JSONObject(string);
		
		//分析返回结果：如果成功获取，则存起来，同时返回对应的accessToken
		errcode = jsonObject.getInt("errcode");
		boolean returnFlag = ( 0 == errcode );
		if(returnFlag){
			
			access_token = jsonObject.getString("access_token");
			int expires_in = jsonObject.getInt("expires_in");
			System.out.println("【access_token为" + access_token + "】");
			System.out.println("【expires_in为" + expires_in + "】");
			//本地保存，用于下次使用
			wxInfo.setAccessToken(access_token);
			wxInfo.setAccessTokenExpiresIn(expires_in+"");
			wxInfoDao.updataWXInfo(wxInfo);
		}else{
			errmsg = jsonObject.getString("errmsg");
			System.out.println("【access_token获取失败代码："+ errcode +"，原因：" + errmsg + "】");
		}
		System.out.println("【获取accessToken结束】>>>>>>");
	}
	/**
	 * 如果未成功获取ID：
	 * 1.可以进行重定向后重新获取对应的code；
	 * 2.进入错误提示页面。
	 */
	public String achieveWebChartUserID(String code) {
		// TODO Auto-generated method stub
		System.out.println("【2.获取用户ID开始】>>>>>>");
		String result = "";
		//从数据库获取缓存token
		wxInfo = wxInfoDao.queryByClassName(WebChartPort.WEB_CHAT_NAME);
		access_token = wxInfo.getAccessToken();
		
		//拼接获取userID接口请求地址
		URL = WebChartPort.USER_INFO.replace("ACCESS_TOKEN", access_token).replace("CODE", code);
//		URL = WebChartPort.USER_INFO.replace("ACCESS_TOKEN", "2332").replace("CODE", code);
		
		//发起HTTPS请求
		jsonObject = new JSONObject();
		jsonObject = NetWorkUtil.httpsRequest(URL, "GET", null);
		
		//分析结果：如果是以上错误代码，则重新获取token
		errcode = jsonObject.getInt("errcode");
		boolean flag1 = (0 == errcode );
		//1.返回成功
		if(flag1){
			result = jsonObject.getString("UserId");
		}
		//2.返回错误
		else{
			errmsg = jsonObject.getString("errmsg");
			System.out.println("【工号获取失败："+ errcode +"，原因：" + errmsg + "】");
		}
		System.out.println("【获取用户ID结束:ID = "+result+"】>>>>>>");
		return result;
	}
	public String achieveAuth2CoreURL(String viewName,String serverName) {
		System.out.println("【获取重定向URL开始】>>>>>>");
		// TODO Auto-generated method stub
		//获取企业号corpID，secretID
		wxInfo = wxInfoDao.queryByClassName(WebChartPort.WEB_CHAT_NAME);
		String corpID = wxInfo.getCorpID();
		String address = wxInfo.getAddress();
		
		//拼接获取userID接口请求地址
		String url2 = "http://" + serverName + "/webChatServer-action/center/login.do?viewName=" + viewName;
//		String url2 = "/center/login.do?viewName=" + viewName;
		URL = WebChartPort.OAUTH2_CODE.replace("CORPID", corpID).replace("REDIRECT_URI", url2);
		
		System.out.println("【获取重定向URL结束URL= " + URL + "】>>>>>>");
		
		return URL;
	}
	public String[] achieveJsapiTicket() {
		System.out.println("【获取JsapiTicket开始】>>>>>>");
		String[] result = new String[2];
		//从数据库中取出access_token
		wxInfo = wxInfoDao.queryByClassName(WebChartPort.WEB_CHAT_NAME);
		access_token = wxInfo.getAccessToken();
		
		//拼接获取userID接口请求地址,发起HTTP请求
		URL = WebChartPort.JSAPI_TICKET.replace("ACCESS_TOKE", access_token);
		/*String str1 = NetWorkUtil.httpRequest(URL, "GET", null);
		jsonObject =new JSONObject(str1);*/
		jsonObject =new JSONObject();
		jsonObject = NetWorkUtil.httpsRequest(URL, "GET", null);
		//分析返回结果：如果成功获取，则存起来，同时返回对应的accessToken
		errcode = jsonObject.getInt("errcode");
		boolean returnFlag = ( 0 == errcode );
		if(returnFlag){
			
			String ticket = jsonObject.getString("ticket");
			int expires_in = jsonObject.getInt("expires_in");
			System.out.println("【ticket为" + ticket + "】");
			System.out.println("【expires_in为" + expires_in + "】");
			
			//本地保存，用于下次使用
			wxInfo.setJSAPITicket(ticket);
			long nowTimestamp = System.currentTimeMillis()/1000;//取当前时间戳
			wxInfo.setTicketTimestamp(nowTimestamp + "");//记录当前时间戳
			wxInfo.setJSAPITicket(ticket);//记录当前js调用凭证
			wxInfo.setJSAPITicketExpiresIn(expires_in + "");//记录当前凭证有效期（秒）
			wxInfoDao.updataWXInfoByJsapiTicket(wxInfo);

			result[0] = ticket;
			result[1] = expires_in + "";
		}else{
			errmsg = jsonObject.getString("errmsg");
			System.out.println("【JsapiTicket获取失败代码："+ errcode +"，原因：" + errmsg + "】");
		}
		System.out.println("【获取JsapiTicket结束】>>>>>>");
		return result;
	}
	public String achieveJsapiInfo(String url) {
		//获取微信基础信息
		System.out.println("【初始化JSAPI相关信息开始】>>>>>>");
		wxInfo = wxInfoDao.queryByClassName(WebChartPort.WEB_CHAT_NAME);
		String corpid = wxInfo.getCorpID();//取微信企业号id
		String ticket = wxInfo.getJSAPITicket();//取ticket
		
		if( ticket == null ){
			
			String[] str = this.achieveJsapiTicket();
			ticket = str[0] == null ? "" : str[0];
			
		}else{
			
			int expiresIn = Integer.parseInt(wxInfo.getJSAPITicketExpiresIn()); //ticket有效期
			long jsapiTimestamp = Long.parseLong(wxInfo.getTicketTimestamp());//取最后调用jsapi时间戳
			long nowTimestamp = System.currentTimeMillis()/1000;//取当前时间戳
			
			//判断ticket是否失效（当前时间戳 - ticket获取时时间戳   > (ticket有效期 - 200)）
			boolean flag = ( ( nowTimestamp - jsapiTimestamp ) > ( expiresIn - 200 ) );
			if(flag) ticket = this.achieveJsapiTicket()[0];//失效重新获取
		}
		//生成签名信息
//		System.out.println("ticket = " + ticket);
		Map<String, String> ret = SignUtil.sign(ticket, url);
		String nonceStr = ret.get("nonceStr");//生成签名的随机串
		String timestamp = ret.get("timestamp");//生成签名时的时间戳
		String signature = ret.get("signature");//生成的签名
		String jsapi_ticket = ret.get("jsapi_ticket");//生成前的凭证
		jsonObject = new JSONObject();
		jsonObject.put("appId", corpid); // 必填，企业号的唯一标识，此处填写企业号corpid
		jsonObject.put("timestamp", timestamp);
		jsonObject.put("nonceStr", nonceStr);
		jsonObject.put("signature", signature);
		jsonObject.put("jsapi_ticket", jsapi_ticket);
		
		System.out.println("【初始化JSAPI相关信息结束：】" + jsonObject.toString() + ">>>>>>");
		return jsonObject.toString();
	}
	
}
