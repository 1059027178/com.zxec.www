package com.thinkway.cms.presentation.web.core;

import java.util.Calendar;

public class TimeBean {
	public static String getTime() {
		Calendar cldNow = Calendar.getInstance();
		int curMonth = cldNow.get(Calendar.MONTH)+1;
		String sNow = cldNow.get(Calendar.YEAR) + "年"
				+ curMonth + "月"
				+ cldNow.get(Calendar.DAY_OF_MONTH) + "日";

		String WeekName = "";
		switch (cldNow.get(Calendar.DAY_OF_WEEK)) {
		case 1:
			WeekName = "星期天";
			break;
		case 2:
			WeekName = "星期一";
			break;
		case 3:
			WeekName = "星期二";
			break;
		case 4:
			WeekName = "星期三";
			break;
		case 5:
			WeekName = "星期四";
			break;
		case 6:
			WeekName = "星期五";
			break;
		case 7:
			WeekName = "星期六";
			break;
		}
		/*+ cldNow.get(Calendar.HOUR_OF_DAY) + "   "
		 + cldNow.get(Calendar.MINUTE) + ":"
		 + cldNow.get(Calendar.SECOND);*/
		sNow = sNow+"  "+WeekName;	
		return sNow;
	}
	
	public static String getDate() {
		Calendar cldNow = Calendar.getInstance();
		int curMonth = cldNow.get(Calendar.MONTH)+1;
		String sNow = cldNow.get(Calendar.YEAR) + "-"
				+ curMonth + "-"
				+ cldNow.get(Calendar.DAY_OF_MONTH);
		return sNow;
	}
}
