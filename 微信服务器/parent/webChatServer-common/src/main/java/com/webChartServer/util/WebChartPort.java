package com.webChartServer.util;
/**
 * 微信接口调用清单类
 * @since 2017-08-09
 * @author qianyang
 *
 */
public class WebChartPort {
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
	 * OAuth2.0验证接口：通过前端解析url中获取到的code，进行用户身份信息获取
	 */
	public static final String USER_INFO = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token=ACCESS_TOKEN&code=CODE";
}
