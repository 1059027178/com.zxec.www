package cn.webChatServer.service;
import org.json.JSONObject;

/**
 * 微信接口调用
 * @author qianyang
 * @Time 2017-08-18
 * @version V1.0
 */
public interface WebChatService {
	/**
	 * 【请注意坑爹问题：函数不能以get开头】
	 * 相关get开头错误介绍：
	 * http://blog.csdn.net/qq1142003960/article/details/47780883
	 * 更新数据库中缓存的accessToken
	 */
	public void achieveAccessToken();
	/**
	 * 获取微信用户账号
	 * @param code (分析url即可获取到)
	 * @return String
	 */
	public String achieveWebChartUserID(String code);
	/**
	 * 取得更新core地址，进行页面重定向
	 * @param viewName (请求模块名称)
	 * @return
	 */
	public String achieveAuth2CoreURL(String viewName);
	/**
	 * 更新jsapi_ticket
	 * 返回ticket 及 有效期
	 */
	public String[] achieveJsapiTicket();
	/**
	 * 获取调用jsapi相关信息
	 * @param  url (当前URL)
	 * @return JSONObject
	 */
	public String achieveJsapiInfo(String url);

}
