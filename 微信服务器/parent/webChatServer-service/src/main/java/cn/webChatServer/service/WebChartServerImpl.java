package cn.webChatServer.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webChatServer.dao.WXInfoDao;
import cn.webChatServer.pojo.AccessToken;
import cn.webChatServer.pojo.WXInfo;

import com.webChartServer.util.NetWorkUtil;
import com.webChartServer.util.WebChartPort;


@Service("WebChartServer")
public class WebChartServerImpl implements WebChartServer{
	
	@Autowired
	private WXInfoDao wxInfoDao;
	
	@Autowired
	private WXInfo wxInfo;
	
	@Autowired
	private AccessToken accessToken;
	
	public AccessToken getAccessToken() {
		// TODO Auto-generated method stub
		//获取企业号corpID，secretID
		wxInfo = wxInfoDao.queryByClassName(WebChartPort.WEB_CHAT_NAME);
		String corpID = wxInfo.getCorpID();
		String secretID = wxInfo.getSecretID();
		
		//拼接获取access_token接口请求地址
		String url = WebChartPort.ACCESS_TOKEN.replace("ID", corpID).replace("SECRECT", secretID);
		
		//发起HTTPS请求
		JSONObject jsonObject = null;
		jsonObject = NetWorkUtil.httpsRequest(url, "Get", null);
		
		//分析返回结果：如果成功获取，则存起来，同时返回对应的accessToken
		String errcode = jsonObject.getString("access_token");
		boolean returnFlag = ("0".equals(errcode));
		if(returnFlag){
			
			String access_token = jsonObject.getString("access_token");
			int expires_in = Integer.parseInt(jsonObject.getString("expires_in"));
			
			accessToken.setToken(access_token);
			accessToken.setExpiresIn(expires_in);
			//本地保存，用于下次使用
			wxInfo.setAccessToken(access_token);
			wxInfoDao.updateWXInfo(wxInfo);
		}
		//返回结果
		return accessToken;
	}

	public String getWebChartUserID(String accessToken,String code) {
		// TODO Auto-generated method stub
		//拼接获取userID接口请求地址
		String url = WebChartPort.USER_INFO.replace("ACCESS_TOKEN", accessToken).replace("CODE", code);
		
		//发起HTTPS请求
		JSONObject jsonObject = null;
		jsonObject = NetWorkUtil.httpsRequest(url, "Get", null);
		
		//分析返回结果：
		String userID = null;
		String errcode = jsonObject.getString("errcode");
		System.out.println("getWebChartUserID()输出errcode :" + errcode);
		userID = jsonObject.getString("UserId");
		
		return userID;
	}

}
