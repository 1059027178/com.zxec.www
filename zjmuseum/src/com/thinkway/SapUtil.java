package com.thinkway;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import com.sap.mw.jco.JCO;


public class SapUtil {
	
	public static final String POOL_NAME = "Sample_Pool";
	public static final int max_connection = 3;
//	public static JCO.Client  getSAPcon(){
//		JCO.Pool pool = JCO.getClientPoolManager().getPool(POOL_NAME);
//		JCO.Client myConnection = null;
//		if(pool==null){
//			Properties logonProperties = new Properties();
//	        logonProperties.put("jco.client.ashost","192.168.0.50");
//	        logonProperties.put("jco.client.sysnr","00");  
//	        logonProperties.put("jco.client.client","668");          
//	        logonProperties.put("jco.client.user","JIUH");        
//	        logonProperties.put("jco.client.passwd","zxec12"); 
//	        logonProperties.put("jco.client.client","666");  
//	        logonProperties.put("jco.client.user","abap7");        
//	        logonProperties.put("jco.client.passwd","123456");  
//	        logonProperties.put("jco.client.lang","zh"); 
//	        logonProperties.put("jco.client.CodePage","8400"); 
//	        
//	        JCO.addClientPool( POOL_NAME, max_connection, logonProperties); // properties
//       }
//		myConnection= JCO.getClient(POOL_NAME);
//		return myConnection;
//	}
	/**
	 * @author YangYang
	 * @time   2016年05月31日
	 * @action sap测试环境配置
	 * @return
	 */
	public static JCO.Client  getSAPcon(){
		Properties logonProperties = new Properties();
	        logonProperties.put("jco.client.sysnr","00");
	        logonProperties.put("jco.client.ashost","192.168.0.50");
	        logonProperties.put("jco.client.client","667"); 
	        logonProperties.put("jco.client.user","abap7");        
	        logonProperties.put("jco.client.passwd","123456"); 
	        logonProperties.put("jco.client.CodePage","8400"); 
        JCO.Client myConnection = JCO.createClient( logonProperties );
		return myConnection;
	}
	/*public static JCO.Client  getSAPconEn(){
		JCO.Pool pool = JCO.getClientPoolManager().getPool(POOL_NAME);
		JCO.Client myConnection = null;
		if(pool==null){
			Properties logonProperties = new Properties();
		        logonProperties.put("jco.client.sysnr","00");
		        logonProperties.put("jco.client.ashost","192.168.0.50");
		        logonProperties.put("jco.client.client","667"); 
		        logonProperties.put("jco.client.user","abap7");        
		        logonProperties.put("jco.client.passwd","123456");  
		        logonProperties.put("jco.client.CodePage","8400"); 
	        
	        JCO.addClientPool( POOL_NAME, max_connection, logonProperties); // properties
       }
		myConnection= JCO.getClient(POOL_NAME);
		return myConnection;
	}*/
	public static JCO.Client  getSAPconEn(){
		JCO.Pool pool = JCO.getClientPoolManager().getPool(POOL_NAME);
		JCO.Client myConnection = null;
		if(pool==null){
			Properties logonProperties = new Properties();
//			 logonProperties.put("jco.client.ashost","192.168.0.52");
		        logonProperties.put("jco.client.sysnr","00");
//		        logonProperties.put("jco.client.client","800");
//		        logonProperties.put("jco.client.user","ABAP7");        
//		        logonProperties.put("jco.client.passwd","domino"); 
		        logonProperties.put("jco.client.ashost","192.168.0.50");
		        logonProperties.put("jco.client.client","668"); 
		        logonProperties.put("jco.client.user","JIUH");        
		        logonProperties.put("jco.client.passwd","1234567"); 
//		        logonProperties.put("jco.client.client","666");  
//		        logonProperties.put("jco.client.user","abap7");        
//		        logonProperties.put("jco.client.passwd","123456");  
		        logonProperties.put("jco.client.CodePage","8400"); 
	        
	        JCO.addClientPool( POOL_NAME, max_connection, logonProperties); // properties
       }
		myConnection= JCO.getClient(POOL_NAME);
		return myConnection;
	}
	
	/*public static JCO.Client  getSAPcon(){
		Properties logonProperties = new Properties();
//		  logonProperties.put("jco.client.ashost","192.168.0.52");//800
	        logonProperties.put("jco.client.sysnr","00");
//	        logonProperties.put("jco.client.client","800");
//	        logonProperties.put("jco.client.user","ABAP7");        
//	        logonProperties.put("jco.client.passwd","domino"); 
	        logonProperties.put("jco.client.ashost","192.168.0.50");// 668 666
	        logonProperties.put("jco.client.client","668"); 
	        logonProperties.put("jco.client.user","JIUH");        
	        logonProperties.put("jco.client.passwd","1234567"); 
//	        logonProperties.put("jco.client.client","666");  
//	        logonProperties.put("jco.client.user","abap7");        
//	        logonProperties.put("jco.client.passwd","123456");  
	        logonProperties.put("jco.client.CodePage","8400"); 
        JCO.Client myConnection = JCO.createClient( logonProperties );
		return myConnection;
	}
	public static JCO.Client  getSAPconEn(){
		JCO.Pool pool = JCO.getClientPoolManager().getPool(POOL_NAME);
		JCO.Client myConnection = null;
		if(pool==null){
			Properties logonProperties = new Properties();
//			 logonProperties.put("jco.client.ashost","192.168.0.52");
		        logonProperties.put("jco.client.sysnr","00");
//		        logonProperties.put("jco.client.client","800");
//		        logonProperties.put("jco.client.user","ABAP7");        
//		        logonProperties.put("jco.client.passwd","domino"); 
		        logonProperties.put("jco.client.ashost","192.168.0.50");
		        logonProperties.put("jco.client.client","668"); 
		        logonProperties.put("jco.client.user","JIUH");        
		        logonProperties.put("jco.client.passwd","1234567"); 
//		        logonProperties.put("jco.client.client","666");  
//		        logonProperties.put("jco.client.user","abap7");        
//		        logonProperties.put("jco.client.passwd","123456");  
		        logonProperties.put("jco.client.CodePage","8400"); 
	        
	        JCO.addClientPool( POOL_NAME, max_connection, logonProperties); // properties
       }
		myConnection= JCO.getClient(POOL_NAME);
		return myConnection;
	}*/
	public  static void releaseClient(JCO.Client myConnection){
		if(null!=myConnection){
			JCO.releaseClient(myConnection);
		}
	}
	 public static String null2String(String paramString) {
		    return paramString == null ? "" : paramString;
	}

	public static String getCurrentDateTime() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}
	/*
	 * 获取今天的日期-短格式20130613
	 */
	public static String getTodayWithSdt(){
		Calendar c1 = Calendar.getInstance();  
        c1.setTime(new Date()); 
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");  
        return format.format(c1.getTime());
	}
	public static double getDoubleValue(String str){
		double i=0;
		try{
			i=Double.parseDouble(str);
		}catch(Exception e){
			i=-1;
		}
		return i;
	}
	public static int getIntValue(String str){
		int i=0;
		try{
			i=Integer.parseInt(str);
		}catch(Exception e){
			i=-1;
		}
		return i;
	}
}
