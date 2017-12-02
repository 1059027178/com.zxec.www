package cn.webChatServer.service;
import java.util.ArrayList;
import java.util.List;  
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import cn.webChatServer.pojo.ReportDetail;
import com.webChatServer.util.MESConfigInfo;
import com.webChatServer.util.NetWorkUtil;

@Service("reportWorkHoursService")
public class ReportWorkHoursServiceImpl implements ReportWorkHoursService{
	public List<String> judgeIfOpenMES(String strValue) {
		//请求方法名
        String METHOD = "CheckSubmitBarCode";
		List<String> resultList = new ArrayList<String>();
        //请求参数 
        String[] nodeNames = {"strIP","strModule","strUser","strValue"};
        String[] nodeValues = {MESConfigInfo.HOST_IP,MESConfigInfo.MES,MESConfigInfo.HOST_IP,strValue};
        //拼接请求参数
        String soapStr = MESConfigInfo.SOAP_HEAD(METHOD,nodeNames,nodeValues);
        //发起请求
        String resultStr = NetWorkUtil.httpRequest(MESConfigInfo.MES_WEBSERVICE_ADDRESS, "POST", soapStr);
        /****************解析返回结果*****************/
        try {
			Document document = DocumentHelper.parseText(resultStr);
			Element root = document.getRootElement();// 指向根节点
			Element el1 = root.element("Body");
			Element el2 = el1.element(METHOD+"Response");
			Element el3 = el2.element(METHOD+"Result");
			List<Element> elementList = el3.elements("string");// 所有的string节点
			for( int i = 0 ; i < elementList.size() ; i++ ){
				Element element = (Element) elementList.get(i);
				String str = element.getTextTrim();
				resultList.add(str);
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} 
		return resultList;
	}

	public String checkMatterno(String matterno) {
        //请求方法名
        String method = "GetMaterByJson";
        //拼接请求参数
        String[] nodeNames  = {"strIP","strModule","strUser","strValue"};
        String[] nodeValues = {MESConfigInfo.HOST_IP, MESConfigInfo.MES, MESConfigInfo.HOST_IP, matterno};
        String soapStr = MESConfigInfo.SOAP_HEAD(method, nodeNames, nodeValues);
        //发起请求
        String resultStr = NetWorkUtil.httpRequest(MESConfigInfo.MES_WEBSERVICE_ADDRESS, "POST", soapStr);
        /****************解析返回结果*****************/
		try {
			Document document = DocumentHelper.parseText(resultStr);
			Element root = document.getRootElement();// 指向根节点
			Element el1 = root.element("Body");
			Element el2 = el1.element(method+"Response");
			Element el3 = el2.element(method+"Result");
			resultStr = el3.getTextTrim();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return resultStr;
	}

	public JSONObject queryMESDataByLZK(String userNo, String userName, String finishCardno)  {
		//请求方法名
        String method = "GetTaskingByJson"; 
		JSONObject jsonResult = new JSONObject();
		//请求参数 
		Element child1 = DocumentHelper.createElement("FTypeNumber").addText("LZK");
		Element child2 = DocumentHelper.createElement("FTypeName").addText("流转卡");
		Element child3 = DocumentHelper.createElement("FValue").addText(finishCardno);
		Element child4 = DocumentHelper.createElement("FText").addText(finishCardno);
        String[] nodeNames  = { "strIP", "strModule", "strUser", "strType", "strEmp", "strLZK", "strChkJson" };
        String[] nodeValues = { MESConfigInfo.HOST_IP,  MESConfigInfo.MES, userName,  "WGHBBL", userNo, finishCardno,
        		child1.asXML() + child2.asXML() + child3.asXML() + child4.asXML()
        };
        String soapStr = MESConfigInfo.SOAP_HEAD(method, nodeNames, nodeValues);
        //发起请求
        String resultStr = NetWorkUtil.httpRequest(MESConfigInfo.MES_WEBSERVICE_ADDRESS, "POST", soapStr);
        System.err.println(resultStr);
        /****************解析返回结果*****************/
		try {
			Document document = DocumentHelper.parseText(resultStr);
			Element root = document.getRootElement();// 指向根节点
			Element el1 = root.element("Body");
			Element el2 = el1.element(method+"Response");
			Element el3 = el2.element(method+"Result");
			resultStr = el3.getTextTrim();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		
		return jsonResult;
	}

	public JSONObject queryMESDataByMatter(String userNo, String userName, String checkMatterno) {
		//请求方法名
        String method = "GetTaskingByJson"; 
		JSONObject jsonResult = new JSONObject();
		//请求参数 
		Element child1 = DocumentHelper.createElement("FTypeNumber").addText("WL");
		Element child2 = DocumentHelper.createElement("FTypeName").addText("物料代码");
		Element child3 = DocumentHelper.createElement("FValue").addText(checkMatterno);
		Element child4 = DocumentHelper.createElement("FText") .addText(checkMatterno);
		String[] nodeNames  = {"strIP","strModule","strUser","strType","strEmp","strLZK","strChkJson"};
        String[] nodeValues = {MESConfigInfo.HOST_IP, MESConfigInfo.MES,userName, "ZJHBBL",userNo,checkMatterno,
        		child1.asXML() + child2.asXML() + child3.asXML() + child4.asXML()
        };
        String soapStr = MESConfigInfo.SOAP_HEAD(method, nodeNames, nodeValues);
        //发起请求
        String resultStr = NetWorkUtil.httpRequest(MESConfigInfo.MES_WEBSERVICE_ADDRESS, "POST", soapStr);
        System.err.println(resultStr);
        /****************解析返回结果*****************/
		try {
			Document document = DocumentHelper.parseText(resultStr);
			Element root = document.getRootElement();// 指向根节点
			Element el1 = root.element("Body");
			Element el2 = el1.element(method+"Response");
			Element el3 = el2.element(method+"Result");
			resultStr = el3.getTextTrim();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
		return jsonResult;
	}
	
	public List<ReportDetail> queryReportDataByLZK(String finishCardno) {
		//请求方法名
        String method = "Tasking002ByJSON"; 
		JSONObject jsonResult = new JSONObject();
		//请求参数 
		String[] nodeNames  = {"strIP", "strModule", "strUser", "strFLZK" };
        String[] nodeValues = { MESConfigInfo.HOST_IP,  MESConfigInfo.MES, "Admin", finishCardno };
        String soapStr = MESConfigInfo.SOAP_HEAD(method, nodeNames, nodeValues);
        //发起请求
        String resultStr = NetWorkUtil.httpRequest(MESConfigInfo.MES_WEBSERVICE_ADDRESS, "POST", soapStr);
        
        System.err.println(resultStr);
		return null;
	}
}
