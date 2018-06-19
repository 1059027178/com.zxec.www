package com.webChatServer.util;

import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.informix.util.stringUtil;

public class MESConfigInfo {
	//私有构造，避免使用时，创建对象
	private MESConfigInfo(){
		
	}
	/**MES正式机webAPI接口调用地址*/
	public static final String MES_WEBAPI_URL = "http://192.168.0.41:8088/selfhost/webapi/wx/WX_GetTaskReport";//产量查询
	public static final String MES_CARDNO_WEBAPI_URL = "";//流转卡查询
	
	/**MES生产机WebService功能调用接口--已废弃*/
	//public static final String MES_WEBSERVICE_ADDRESS = "http://192.168.0.41/BHService.asmx?wsdl";
	/**MES测试机--已废弃*/
	public static final String MES_WEBSERVICE_ADDRESS = "http://192.168.0.41:53213/BHService.asmx?wsdl";
	/**服务器名*/
	public static final String HOST_IP = "192.168.0.39";
	/**mes模块名称*/
	public static final String MES = "MES";
	
	
	/**
	 * MES webservice服务器请求头
	 * @param requestMethodName 请求方法
	 * @param elementNames 参数节点名
	 * @param texts 参数值
	 * @return
	 */
	public static final String SOAP_HEAD(String requestMethodName , String[] elementNames , String[] texts){
		Element root = DocumentHelper.createElement("soap:Envelope");
		root.addNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
		root.addNamespace("xsd", "http://www.w3.org/2001/XMLSchema");
		root.addNamespace("soap", "http://schemas.xmlsoap.org/soap/envelope/");
		Element body = root.addElement("soap:Body");
		//此处添加xmlns属性是为节点添加命名空间
		Element method = body.addElement(requestMethodName,"http://www.cnlean.net/");
		for(int i = 0 ; i < elementNames.length ; i++){
			Element elementName = method.addElement(elementNames[i]);
			elementName.addText(texts[i]);
		}
		return root.asXML();
	}
	//测试SOAP_HEAD()
	public static void main(String[] args) {
		String[] strNames  = {"method1","method2","method3","method4"};
		String[] strValues = {"value1","value2","value3","value4"};
		String str = MESConfigInfo.SOAP_HEAD("请求方法", strNames, strValues);
		System.out.println(str);
	}
}
