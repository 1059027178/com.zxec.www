package com.thinkway.cms.method.test;

import java.util.Date;

import com.thinkway.cms.util.MD5Util;
import com.thinkway.cms.util.MailUtil;

import junit.framework.TestCase;

public class TestMD5Util extends TestCase {
	
	 protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testMD5UtilChar(){
		System.out.print(MD5Util.MD5("AusITcim#1485"));
	}
	
	public void testZZ(){
		String email = "dwzh20@163.com".substring(0, "dwzh20@163.com".indexOf("@"));
		
		System.out.println(email.replaceAll("\\w", "*"));
	}
	
	public void testMailUtilSend(){
		MailUtil.sendMail(
				 "smtp.163.com",
		         "25",
		         true,
		         "dwzh20@163.com",
		         "830621",
		         "dwzh20@163.com",
		         "test",
		         "尊敬的用户：\n welson,于"
		         + new Date()
		         + "在钱酷网上给您留言，他的电子信箱是 其留言标题为： \n 其留言内容为：\n"
		         , true, false);
	}

}
