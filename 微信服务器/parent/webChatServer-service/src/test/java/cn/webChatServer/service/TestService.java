package cn.webChatServer.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.webChatServer.mes.pojo.MyOutput;
import cn.webChatServer.mes.pojo.MyOutputDetailData;
import cn.webChatServer.mes.pojo.MyOutputIntoParms;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class TestService {
	void print() {
		System.out.println("test print !");
	}

	public static void main(String[] args) {
		/*
		 * Test test = new Test(); test.print(); NewTest newTest = new
		 * NewTest(); newTest.print();
		 */
		/*
		 * NumberFormat format = NumberFormat.getPercentInstance();
		 * format.setMaximumFractionDigits(0);//小数部分最大位数
		 * format.setMinimumFractionDigits(0);//小数部分最小位数
		 * //setMaximumIntegerDigits(int) 设置数值的整数部分允许的最大位数。
		 * //setMinimumIntegerDigits(int) 设置数值的整数部分允许的最小位数. String a =
		 * format.format(-0.34325234); System.out.println(a);
		 */
		// 模具编号处理测试
		/*
		 * Test test = new Test(); String temp = test.getLetter("J123",35);
		 * System.out.println(temp);
		 */
		// 模具编号保存至本地

		/*
		 * //获取当前日历 Calendar calendar = Calendar.getInstance();
		 * //取得指定日期YYYY-MM-DD String data = getPastDate(calendar,0);
		 * System.out.println("data：" + data); Date date = calendar.getTime();
		 * SimpleDateFormat dateFm = new SimpleDateFormat("EEEE"); //取得指定日期对应的周几
		 * String week = dateFm.format(date); System.out.println("week：" +
		 * week);
		 */

		Calendar date = Calendar.getInstance();
		String year = String.valueOf(date.get(Calendar.YEAR));
		System.out.println(year);
	}

	/**
	 * 获取过去第几天的日期(past 为正) 或者 未来 第几天的日期(past 为负)
	 * 
	 * @param calendar
	 *            (当前时间)
	 * @param past
	 * @return
	 */
	public static String getPastDate(Calendar calendar, int past) {
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR)
				- past);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date today = calendar.getTime();
		String result = format.format(today);
		return result;
	}

	public String getLetter(String mouldNum, int index) {
		char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
				'X', 'Y', 'Z' };
		String result = "";
		// 如果是J开头的，模具号为一位1-9，A-Z
		String startStr = mouldNum.trim().substring(0, 1);
		if (startStr.equals("J") && index > 9 && index < 36)
			result = chars[index - 10] + "";
		// 如果是M开头，模具号小于10，则为01-09
		else if (startStr.equals("M") && index < 10)
			result = "0" + index;
		// 否则为index
		else
			result = index + "";
		return result;
	}

	/*
	 * 测试JSON与javaBean的互转
	 */
	@org.junit.Test
	public void testJson() {
		// 1.bean 转 json
		MyOutputIntoParms output = new MyOutputIntoParms();
		output.setUserNo("6753");
		output.setUserName("6753");
		output.setEndDate("2018-08-05");
		output.setStartDate("2018-05-04");
		String jsonStr = JSON.toJSONString(output);
		System.out.println(jsonStr);
		// jsong string 转 bean
		MyOutput output2 = JSON.parseObject(
		    "{\"endDate\":\"2018-08-05\",\"startDate\":\"2018-05-04\",\"userName\":\"6753\",\"userNo\":\"6753\"}",
			MyOutput.class);
		System.out.println(output2.toString());
	}
	@org.junit.Test
	public void testCollectionToJson() {
		System.out.println("bean 转 json :");
		String jsonStr = JSON.toJSONString(this.getMyOutputPOJO());
		System.out.println(jsonStr);
		
		System.out.println("json string 重新转 bean：");
		MyOutput myOutput = JSON.parseObject(jsonStr, MyOutput.class);
		System.out.println(myOutput);
		
		System.out.println("arraylist json string 转bean：");
		String str = "{\"detailData\":[{\"count\":\"2000\",\"processName\":\"工序1\",\"productCode\":\"产品代码1\",\"productName\":\"产品名称1\"}]}";
		System.out.println(str);
		MyOutput myOutput2 = JSON.parseObject(str, MyOutput.class);
		System.out.println(myOutput2);
	}
	/**
	 * 模拟MyOutput数据
	 * @return
	 */
	public MyOutput getMyOutputPOJO(){
		MyOutput output1 = new MyOutput();
		output1.setStartDate("2018-05-04");
		output1.setEndDate("2018-08-05");
		output1.setStatus(true);
		output1.setMessage("success");
		output1.setUserNo("6753");
		output1.setUserName("张三");
		
		ArrayList<MyOutputDetailData> myOutputDetailDatas = new ArrayList<MyOutputDetailData>();
		MyOutputDetailData data1 = new MyOutputDetailData();
		MyOutputDetailData data2 = new MyOutputDetailData();
		MyOutputDetailData data3 = new MyOutputDetailData();
		
		data1.setCount(2000);
		data1.setProcessName("工序1");
		data1.setProductCode("产品代码1");
		data1.setProductName("产品名称1");
		data2.setCount(2000);
		data2.setProcessName("工序1");
		data2.setProductCode("产品代码1");
		data2.setProductName("产品名称1");
		data3.setCount(2000);
		data3.setProcessName("工序1");
		data3.setProductCode("产品代码1");
		data3.setProductName("产品名称1");
		myOutputDetailDatas.add(data1);
		myOutputDetailDatas.add(data2);
		myOutputDetailDatas.add(data3);
		
		output1.setDetailData(myOutputDetailDatas);
		return output1;
	}

	@org.junit.Test
	public void testBooleanJson() {
		String str = "{\"endDate\":true}";
		JSONObject jsonObject = new JSONObject();
		jsonObject = JSON.parseObject(str);
		System.out.println(jsonObject);
	}
}
