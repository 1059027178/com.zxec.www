package com.webChatServer.util;

public class Base64 {

	/**
	 * 编码
	 * 
	 * @param bstr
	 * @return String
	 */
	public static String encode(byte[] bstr) {
		return new sun.misc.BASE64Encoder().encode(bstr);
	}

	/**
	 * 解码
	 * 
	 * @param str
	 * @return string
	 */
	public static byte[] decode(String str) {
		byte[] bt = null;
		try {
			sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
			bt = decoder.decodeBuffer(str);
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}

		return bt;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Base64 te = new Base64();
		String aa = "aaa,\"\"888**&&&示例字符串";
		aa = te.encode(aa.getBytes());
		System.out.println("----aa:" + aa);
		String str = aa;
		String str2 = new String(te.decode(str));
		System.out.println("-----str2:" + str2);
	}
}
