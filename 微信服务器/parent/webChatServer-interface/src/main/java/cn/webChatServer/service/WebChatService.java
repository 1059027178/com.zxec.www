package cn.webChatServer.service;
import cn.webChatServer.pojo.AccessToken;

/**
 * 微信接口调用
 * @author qianyang
 *
 */
public interface WebChatService {
	/**
	 * 获取access_Token对象
	 * @return String
	 */
	public AccessToken getAccessToken();
	/**
	 * 获取微信用户账号
	 * @param code (分析url即可获取到)
	 * @return String
	 */
	public String getWebChartUserID(String accessToken,String code);
}
