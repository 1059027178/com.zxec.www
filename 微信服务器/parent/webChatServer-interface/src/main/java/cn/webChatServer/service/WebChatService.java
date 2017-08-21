package cn.webChatServer.service;

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
	 * 获取access_Token对象
	 * @return String
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
}
