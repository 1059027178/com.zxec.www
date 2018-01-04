package cn.webChatServer.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.informix.util.stringUtil;

public class Test {
	void print(){
		System.out.println("test print !");
	}
	public static void main(String[] args) {
		/*Test test = new Test();
		test.print();
		NewTest newTest = new NewTest();
		newTest.print();*/
		/*NumberFormat format = NumberFormat.getPercentInstance();
		format.setMaximumFractionDigits(0);//小数部分最大位数
		format.setMinimumFractionDigits(0);//小数部分最小位数
		  //setMaximumIntegerDigits(int)  设置数值的整数部分允许的最大位数。  
		  //setMinimumIntegerDigits(int)  设置数值的整数部分允许的最小位数.
		String a = format.format(-0.34325234);
		System.out.println(a);*/
		//模具编号处理测试
		/*Test test = new Test();
		String temp = test.getLetter("J123",35);
		System.out.println(temp);*/
		//模具编号保存至本地
		
		/*//获取当前日历
		Calendar calendar = Calendar.getInstance();
		//取得指定日期YYYY-MM-DD
		String data = getPastDate(calendar,0);
		System.out.println("data：" + data);
		Date date = calendar.getTime();
		SimpleDateFormat dateFm = new SimpleDateFormat("EEEE");
		//取得指定日期对应的周几
		String week = dateFm.format(date);
		System.out.println("week：" + week);*/
		
		 Calendar date = Calendar.getInstance();
	     String year = String.valueOf(date.get(Calendar.YEAR));
	     System.out.println(year);
	}
	/**
	 * 获取过去第几天的日期(past 为正) 或者 未来 第几天的日期(past 为负)
	 * @param calendar(当前时间)
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
	
	public String getLetter(String mouldNum,int index){
		char []chars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		String result = "";
		//如果是J开头的，模具号为一位1-9，A-Z
		String startStr = mouldNum.trim().substring(0, 1);
		if(startStr.equals("J") && index > 9 && index < 36)
			result = chars[index - 10] + "";
		//如果是M开头，模具号小于10，则为01-09
		else if (startStr.equals("M") && index < 10)
			result = "0" + index;
		//否则为index
		else
			result = index + "";
		return result;
	}
}

class NewTest extends Test{
	void print(){
		System.out.println("newTest print !");
		super.print();
	}
}
