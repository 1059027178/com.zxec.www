package cn.webChatServer.service;

import java.util.Date;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.webChatServer.dao.WXInfoDao;
import cn.webChatServer.pojo.WXInfo;
import cn.webChatServer.service.WebChatService;

import com.webChatServer.util.NetWorkUtil;
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
		// TODO Auto-generated method stub
		Date date = new Date();
		System.out.println("【时间：" + date.toString() + ",获取accessToken开始】>>>>>>");
		
		//获取企业号corpID，secretID
		wxInfo = wxInfoDao.queryByClassName(WebChartPort.WEB_CHAT_NAME);
		String corpID = wxInfo.getCorpID();
		String secretID = wxInfo.getSecretID();
		
		//拼接获取access_token接口请求地址
		URL = WebChartPort.ACCESS_TOKEN.replace("ID", corpID).replace("SECRECT", secretID);
		
		//发起HTTPS请求
		jsonObject = new JSONObject();
		jsonObject = NetWorkUtil.httpsRequest(URL, "GET", null);
		
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
			wxInfoDao.updateWXInfo(wxInfo);
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
		System.out.println("【获取用户ID开始】>>>>>>");
		String result = "";
		//从数据库获取缓存token
		wxInfo = wxInfoDao.queryByClassName(WebChartPort.WEB_CHAT_NAME);
		access_token = wxInfo.getAccessToken();
		
		//拼接获取userID接口请求地址
		URL = WebChartPort.USER_INFO.replace("ACCESS_TOKEN", access_token).replace("CODE", code);
		
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
			System.out.println("【access_token获取失败代码："+ errcode +"，原因：" + errmsg + "】");
		}
		System.out.println("【获取用户ID结束:ID = "+result+"】>>>>>>");
		return result;
	}
	public String achieveAuth2CoreURL(String viewName) {
		System.out.println("【获取重定向URL开始】>>>>>>");
		// TODO Auto-generated method stub
		//获取企业号corpID，secretID
		wxInfo = wxInfoDao.queryByClassName(WebChartPort.WEB_CHAT_NAME);
		String corpID = wxInfo.getCorpID();
		String address = wxInfo.getAddress();
		
		//拼接获取userID接口请求地址
		String url2 = "http://" + address + "/webChatServer-action/center/login.do?viewName=" + viewName;
		URL = WebChartPort.OAUTH2_CODE.replace("CORPID", corpID).replace("REDIRECT_URI", url2);
		
		System.out.println("【获取重定向URL结束URL= " + URL + "】>>>>>>");
		
		return URL;
	}
}
