package cn.webChatServer.service;

import java.util.ArrayList;
import java.util.List;  

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.webChatServer.util.MESConfigInfo;
import com.webChatServer.util.NetWorkUtil;

@Service("reportWorkHoursService")
public class ReportWorkHoursServiceImpl implements ReportWorkHoursService{
	public List<String> judgeIfOpenMES(String strIP, String strModule, String strUser, String strValue) {
		// TODO Auto-generated method stub
		List<String> resultList = new ArrayList<String>();
        //请求参数 
        String REQUESTBODY ="<strIP>"+ strIP +"</strIP>"
        		+ "<strModule>"+ strModule +"</strModule>"
        		+ "<strUser>"+ strUser +"</strUser>"
        		+ "<strValue>"+ strValue +"</strValue>";
        //请求方法名
        String METHOD = "CheckSubmitBarCode";
        //拼接请求参数
        String soapStr = MESConfigInfo.SOAP_HEAD.replace("METHOD", METHOD).replace("REQUESTBODY", REQUESTBODY);
        //发起请求
        String resultStr = NetWorkUtil.httpRequest(MESConfigInfo.MES_WEBSERVICE_ADDRESS, "POST", soapStr);
        System.out.println("请求返回 =" + resultStr);
        /****************解析返回结果*****************/
        int dataStartIndex = resultStr.indexOf("<CheckSubmitBarCodeResult>");
        int dataEndIndex = resultStr.indexOf("</CheckSubmitBarCodeResult>");
        String dataStr = resultStr.substring(dataStartIndex, dataEndIndex + "</CheckSubmitBarCodeResult>".length());
        //取得返回标志
        //---------方法一：
       /* int flagStartIndex = dataStr.indexOf("<string>");
        int flagEndIndex = dataStr.indexOf("</string>");
        String flag = dataStr.substring(flagStartIndex + "<string>".length(),flagEndIndex);
        System.out.println("flag = " + flag);*/
        //---------方法二：
        try {
			Document document = DocumentHelper.parseText(dataStr);
			Element root = document.getRootElement();// 指向根节点
			List elementList = root.elements("string");// 所有的string节点
			for( int i = 0 ; i < elementList.size() ; i++ ){
				Element element = (Element) elementList.get(i);
				String str = element.getTextTrim();
				resultList.add(str);
//				System.out.println("str = " + str);
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return resultList;
	}
	/*public static void main(String[] args) {
		ReportWorkHoursServiceImpl hoursServiceImpl = new ReportWorkHoursServiceImpl();
		List<String> list = hoursServiceImpl.judgeIfOpenMES("192.168.0.39", "MES", "192.168.0.39", "6753");
	}*/
	//还未完成---
	public String[] checkFinishCardno(String strIP, String strModule, String strUser,String cardno) {
		String[] strs = new String[4];
		//请求参数 
        String REQUESTBODY ="<strIP>"+ strIP +"</strIP>"
        		+ "<strModule>"+ strModule +"</strModule>"
        		+ "<strUser>"+ strUser +"</strUser>"
        		+ "<strValue>"+ cardno +"</strValue>";
        //请求方法名
        String METHOD = "CheckSubmitBarCode";
        //拼接请求参数
        String soapStr = MESConfigInfo.SOAP_HEAD.replace("METHOD", METHOD).replace("REQUESTBODY", REQUESTBODY);
        //发起请求
        String resultStr = NetWorkUtil.httpRequest(MESConfigInfo.MES_WEBSERVICE_ADDRESS, "POST", soapStr);
        System.out.println("请求返回 =" + resultStr);
		return strs;
	}
	
	
}
