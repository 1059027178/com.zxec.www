package com.webChatServer.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import org.json.JSONObject;

public class NetWorkUtil {
	private NetWorkUtil(){
		
	}
	/** 
     * 发起https请求并获取结果 
     *  
     * @param requestUrl 请求地址 
     * @param requestMethod 请求方式（GET、POST） 
     * @param outputStr 提交的数据 
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
     */  
    public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {  
        JSONObject jsonObject = null;  
        StringBuffer buffer = new StringBuffer();  
        try {  
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化  
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            // 从上述SSLContext对象中得到SSLSocketFactory对象  
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod))  
                httpUrlConn.connect();  
  
            // 当有数据需要提交时  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            }  
  
            // 将返回的输入流转换成字符串  
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();  
//            jsonObject = JSONObject.fromObject(buffer.toString());  
            jsonObject =new JSONObject(buffer.toString());  
        } catch (ConnectException ce) {  
        	System.out.println("Weixin server connection timed out.");
        } catch (Exception e) {  
        	System.out.println("https request error："+ e);  
        }  
        return jsonObject;  
    }
    /** 
     * 发起http请求并获取结果 
     * @param requestUrl 请求地址 
     * @param requestMethod 请求方式（GET、POST） 
     * @param outputStr 提交的数据 
     * @return String 
     */  
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) {
    	StringBuffer buffer = new StringBuffer();  
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
	        httpUrlConn.setDoOutput(true);  
	        httpUrlConn.setDoInput(true);  
	        httpUrlConn.setUseCaches(false); 
	        httpUrlConn.setConnectTimeout(300000);
	        httpUrlConn.setReadTimeout(300000); 
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
	        httpUrlConn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
  
            if ("GET".equalsIgnoreCase(requestMethod)) httpUrlConn.connect();  
  
            // 当有数据需要提交时  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.flush();
                outputStream.close();
                outputStream = null;
            }  
            // 将返回的输入流转换成字符串  
        	InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect(); 
	        
		} catch (ConnectException ce) {  
        	System.out.println( "address:" + requestUrl + " server connection timed out.");
        } catch (Exception e) {  
        	System.out.println("http request error："+ e);  
        }  
    	return buffer.toString();
    }
    /** 
     * 发起http请求并获取结果 
     * @param requestUrl 请求地址 
     * @param requestMethod 请求方式（GET、POST） 
     * @param outputStr 提交的数据 
     * @return String 
     */  
    public static String httpRequestMES(String requestUrl, String requestMethod, String outputStr) {
    	StringBuffer buffer = new StringBuffer();  
		try {
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  
	        httpUrlConn.setDoOutput(true);  
	        httpUrlConn.setDoInput(true);  
	        httpUrlConn.setUseCaches(false); 
	        httpUrlConn.setConnectTimeout(300000);
	        httpUrlConn.setReadTimeout(300000); 
            // 设置请求方式（GET/POST）  
            httpUrlConn.setRequestMethod(requestMethod);  
	        httpUrlConn.setRequestProperty("Content-Type", "application/json");
  
            if ("GET".equalsIgnoreCase(requestMethod)) httpUrlConn.connect();  
  
            // 当有数据需要提交时  
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码  
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.flush();
                outputStream.close();
                outputStream = null;
            }  
            // 将返回的输入流转换成字符串  
        	InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源  
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect(); 
	        
		} catch (ConnectException ce) {  
        	System.out.println( "address:" + requestUrl + " server connection timed out.");
        } catch (Exception e) {  
        	System.out.println("http request error："+ e);  
        }  
    	return buffer.toString();
    } 
}
