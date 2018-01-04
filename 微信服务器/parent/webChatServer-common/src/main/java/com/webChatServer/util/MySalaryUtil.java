package com.webChatServer.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MySalaryUtil {
	/**获取薪资条目数*/
	public static final int SHOW_EHTRY = 5; 
	/**获取考勤数据条目数*/
	public static final int SHOW_CHECK_DATA_COUNT = 7; 
	/**加密密钥(随意输入一串字符)*/
	private static final String ENCRYPT_KEY = "4290jdflsdjfkKLSDJFLKSJFKLEWIRNNC4359640018235DSJKFSsdfjk";
	
	/**
	 *功能： 取得传入日期（yyyyMM）的前temp - 1个月
	 * @param repeatDate 日期yyyyMM
	 * @param temp 传入日期的前temp -1月
	 * @return "yyyyMM"
	 */
	public static String getLastMonth(String repeatDate,int temp) {
        String lastMonth = "";
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMM");
        int year = Integer.parseInt(repeatDate.substring(0, 4));
        String monthsString = repeatDate.substring(4, 6);
        int month;
        if ("0".equals(monthsString.substring(0, 1))) {
            month = Integer.parseInt(monthsString.substring(1, 2));
        } else {
            month = Integer.parseInt(monthsString.substring(0, 2));
        }
        cal.set(year,month-temp,Calendar.DATE);
        lastMonth = dft.format(cal.getTime());
        return lastMonth;
    }
	/**
	 * 获取过去第几天的日期(past 为正) 或者 未来 第几天的日期(past 为负)
	 * @param calendar(当前日历)
	 * @param past
	 * @return
	 */
	public static String getPastDate(Calendar calendar,int past) {
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date today = calendar.getTime();
        String result = format.format(today);
        return result;
    }
	/**
	 * 处理为0或者为null的对象-->""
	 * @param obj
	 * @return
	 */
	public static String ObjToBlank(Object obj){
		if(obj == null || obj.toString().trim().equals("0"))
			obj = "";
		return obj.toString();
	}
	/**
	 * 
	 * @param flag (true 加密操作，false 解密操作)
	 * @param dealStr 待处理字符串
	 * @return string
	 */
	public static String dealStringToUrlParm(boolean flag, String dealStr){
		String resultStr = "";//返回结果
		DESUtil des = new DESUtil();// 实例化一个对像
		des.getKey(ENCRYPT_KEY);// 生成密匙
//		System.out.println("key:" + ENCRYPT_KEY);
		try {
			//进行加密操作：DES加密 -> 64编码 -> URL编码
			if(flag){
				//DES加密
				String strEnc = des.getEncString(dealStr);
				//64编码
				String str1 = Base64.encode(strEnc.getBytes());
				//URL编码
				resultStr = URLEncoder.encode(str1, "UTF-8");
				
//				System.out.println("1.密文:" + strEnc);
//				System.out.println("2.64编码str1  = " + str1);
				System.out.println("【加密结果】密文： " + resultStr);
			}
			//进行解密操作：URL解码 -> 64解码 -> DES解密
			else{
				//URL解码
				String str1 = URLDecoder.decode(dealStr, "UTF-8");
				//64解码
				String strEnc = new String(Base64.decode(str1));
				//DES解密
				resultStr = des.getDesString(strEnc);
				
//				System.out.println("1.URL解码str1 = " + str1);
//				System.out.println("2.64解码str2 = " + strEnc);
				System.out.println("【解密结果】明文：" + resultStr);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultStr;
	}
	public static void main(String[] args) {
		String strEnc = MySalaryUtil.dealStringToUrlParm(true, "6753");
	 	String strDes = MySalaryUtil.dealStringToUrlParm(false, strEnc);
	}
}
