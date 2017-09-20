package com.webChatServer.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MySalaryUtil {
	/**获取薪资条目数*/
	public static final int SHOW_EHTRY = 5; 
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
	public static String ObjToBlank(Object obj){
		if(obj == null || obj.toString().trim().equals("0"))
			obj = "";
		return obj.toString();
	}
}
