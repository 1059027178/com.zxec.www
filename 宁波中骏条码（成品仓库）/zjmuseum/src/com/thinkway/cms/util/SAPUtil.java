package com.thinkway.cms.util;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.thinkway.LiangxinUtil;
import com.thinkway.cms.business.domains.Message;

public class SAPUtil {
	public static Message lockonOrder(String vbeln,String username){
		Message message=new Message();
		try{
			JCO.Client myConnection =null;
			myConnection =LiangxinUtil.getSAPcon();
		    myConnection.connect(); 
			String functionName="ZFM_BC_04_22";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
			JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
			parameterList.setValue(vbeln,"I_VBELN");
			parameterList.setValue(username,"I_UID");//用户名字
			myConnection.execute(bapi);
				
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			//JCO.Table  ET_LIKP=outtab.getTable("ET_LIKP");
			JCO.Structure stru=outs.getStructure("ES_RETURN");
			message.setType(stru.getString("MSGTY"));
			message.setMessage(stru.getString("MESSAGE"));
		}catch(Exception e){
			message.setType("E");
			message.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return message;

	}
	public static Message openOrder(String vbeln,String username){
		Message message=new Message();
		try{
			JCO.Client myConnection =null;
			myConnection =LiangxinUtil.getSAPcon();
		    myConnection.connect(); 
			String functionName="ZFM_BC_04_23";//函数的名字
		    JCO.Repository myRepository = new JCO.Repository("Repository",myConnection); //只是一個名字
		    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		    //從這個函數範本獲得該SAP函數的物件
		    JCO.Function bapi = ft.getFunction();
			JCO.ParameterList  parameterList=bapi.getImportParameterList();//获得输入表的参数
			parameterList.setValue(vbeln,"I_VBELN");
			parameterList.setValue(username,"I_UID");//用户名字
			myConnection.execute(bapi);
				
			JCO.ParameterList  outs = bapi.getExportParameterList();//输出参数和结构处理
			JCO.ParameterList  outtab = bapi.getTableParameterList();//输出参数和结构处理
			//JCO.Table  ET_LIKP=outtab.getTable("ET_LIKP");
			JCO.Structure stru=outs.getStructure("ES_RETURN");
			message.setType(stru.getString("MSGTY"));
			message.setMessage(stru.getString("MESSAGE"));
		}catch(Exception e){
			message.setType("E");
			message.setMessage(e.getMessage());
			e.printStackTrace();
		}
		return message;

	}
}
