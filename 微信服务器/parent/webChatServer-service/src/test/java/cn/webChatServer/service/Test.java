package cn.webChatServer.service;

import java.text.DecimalFormat;
import java.text.NumberFormat;

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
		System.out.println();
	}
}

class NewTest extends Test{
	void print(){
		System.out.println("newTest print !");
		super.print();
	}
}
