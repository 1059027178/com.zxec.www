package com.webChatServer.util;

public class MESConfigInfo {
	
	/**MES生产机WebService功能调用接口*/
//	public static final String MES_WEBSERVICE_ADDRESS = "http://192.168.0.41/BHService.asmx?wsdl";
	/**MES测试机*/
	public static final String MES_WEBSERVICE_ADDRESS = "http://192.168.0.41:53213/BHService.asmx?wsdl";
	
	/**MES服务器请求头METHOD(方法名)，REQUESTBODY(请求体)*/
	public static final String SOAP_HEAD = "<soap:Envelope "
			+ "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
			+ "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
			+ "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" >"
			+ "<soap:Body><METHOD xmlns=\"http://www.cnlean.net/\">REQUESTBODY</METHOD></soap:Body>"
			+ "</soap:Envelope>";
	
	
}
