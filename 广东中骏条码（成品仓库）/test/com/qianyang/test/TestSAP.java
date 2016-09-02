package com.qianyang.test;

import javax.servlet.http.HttpServletRequest;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Repository;
import com.thinkway.SapUtil;
import com.thinkway.cms.presentation.web.core.PaginatedListHelper;
import com.thinkway.cms.util.ParamUtils;

public class TestSAP {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JCO.Client myClient = SapUtil.getSAPcon();
		myClient.connect();
		//函数名
//		String functionName="ZFM_BC_09_11";
		String functionName="ZFM_BC_COMMON_01";//函数的名字
		
	    JCO.Repository myRepository = new Repository("Repository",myClient); //只是一個名字
	    
	    IFunctionTemplate ft = myRepository.getFunctionTemplate(functionName);
		
		JCO.Function bapi = ft.getFunction();
		
		JCO.ParameterList intoList = bapi.getImportParameterList();//获得输入表参数

		String matnr = "C.6.040601";
		String lgort = "3107";
		String charg = "A1-1";
		String werks = "3100";
		
		intoList.setValue(matnr,"I_MATNR");//物料编码
		intoList.setValue(lgort,"I_LGORT");//库存地点 
		intoList.setValue(charg,"I_CHARG");//仓位 
		intoList.setValue(werks,"I_WERKS");//工厂
		intoList.setValue("qq","I_UID");//用户名字
		
		myClient.execute(bapi);

		JCO.ParameterList  outTable = bapi.getTableParameterList();//输出参数和结构处理
		
		JCO.Table ET_LQUA =  outTable.getTable("ET_LQUA");
		
		PaginatedListHelper paginaredList=new PaginatedListHelper();
		
		String currentPage="1";
		paginaredList.setObjectsPerPage(5);
		paginaredList.setPageNumber(Integer.parseInt(currentPage));
		
		int pageNum=ET_LQUA.getNumRows()/5;
		if(ET_LQUA.getNumRows()%5>0){
			pageNum++;
		}
		paginaredList.setFullListSize(ET_LQUA.getNumRows());
		System.out.println("ET_LQUA的大小为 == " + ET_LQUA.getNumRows());
		int j=0;
		 for (int i = (Integer.parseInt(currentPage)-1)*5; i < ET_LQUA.getNumRows(); i++) {
			 	System.out.println("进来了");
			 	ET_LQUA.setRow(i);
			 	String xuhao = i + 1+ "";
			 	String charg2 = ET_LQUA.getString("CHARG");//批次
			 	String lgpla = ET_LQUA.getString("LGPLA");//仓位
			 	String sobkz = ET_LQUA.getString("SOBKZ");//特殊标识
			 	String lgort2 = ET_LQUA.getString("LGORT");//库存地点
			 	String verme = ET_LQUA.getString("VERME");//数量
			 	String meins = ET_LQUA.getString("MEINS");//单位
			 	
			 	System.out.println(xuhao+" | "+charg2+" | "+ lgpla + " | "+ sobkz + " | "+lgort2+" | "+ verme + " | "+ meins +" | ");

			 	j++;
			    if(j==5){
			    	break;
			    }
            }
   
			if(null!=myClient){
				SapUtil.releaseClient(myClient);
			}
	}

}











