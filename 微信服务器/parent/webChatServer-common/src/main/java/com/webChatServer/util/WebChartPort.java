package com.webChatServer.util;
/**
 * 微信接口调用清单类
 * @since 2017-08-09
 * @author qianyang
 *
 */
public class WebChartPort {
	/**
	 * 【已停止使用】
	 * 微信定时获取token刷新时间（CRON 表达式）
	 */
	public static final String GET_TOKEN_REFRESH_TIME = "0 0 0/2 * * ? *";
	/**
	 * 后台数据库中保存有关微信企业号基本信息记录的className
	 */
	public static final String WEB_CHAT_NAME = "wxBaseData";
	/**
	 * 微信主动调用接口：用于获取企业号的全局唯一票据；
	 * CorpID是企业号的标识，每个企业号拥有一个唯一的CorpID；
	 * Secret是管理组凭证密钥。
	 * 正常情况下AccessToken有效期为7200秒，有效期内重复获取返回相同结果。access_token至少保留512字节的存储空间。
	 */
	public static final  String ACCESS_TOKEN = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ID&corpsecret=SECRECT";
	
	/**
	 * OAuth2.0验证接口：通过前端解析url中获取到code【用于code验证失败时，重定向到此地址，进行更新code】
	 */
	public static final String OAUTH2_CODE = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=CORPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATEs#wechat_redirect";
	/**
	 * OAuth2.0验证接口：通过前端解析url中获取到的code，进行用户身份信息获取
	 */
	public static final String USER_INFO = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
	/**
	 * 生成签名之前必须先了解一下jsapi_ticket，jsapi_ticket是企业号号用于调用微信JS接口的临时票据。
	 * 正常情况下，jsapi_ticket的有效期为7200秒，通过access_token来获取。由于获取jsapi_ticket的api调用次数非常有限，
	 * 频繁刷新jsapi_ticket会导致api调用受限，影响自身业务，开发者必须在自己的服务全局缓存jsapi_ticket。
	 * */
	public static final String JSAPI_TICKET = "https://qyapi.weixin.qq.com/cgi-bin/get_jsapi_ticket?access_token=ACCESS_TOKE";
}
