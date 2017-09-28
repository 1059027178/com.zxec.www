package com.webChatServer.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;

import org.apache.commons.codec.net.URLCodec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * 使用DES加密与解密,可对byte[],String类型进行加密与解密 密文可使用String,byte[]存储.
 * 
 * 方法: void getKey(String strKey)从strKey的字条生成一个Key
 * 
 * String getEncString(String strMing)对strMing进行加密,返回String密文 String
 * getDesString(String strMi)对strMin进行解密,返回String明文
 * 
 * byte[] getEncCode(byte[] byteS)byte[]型的加密 byte[] getDesCode(byte[]
 * byteD)byte[]型的解密
 */

public class DESUtil {
	static {
		Security.addProvider(new sun.security.provider.Sun());
	}
	private final String strIV = "12345678";// 不要改变此值(初始向量iv),兼容其他语言
	Key key;

	/**
	 * 根据参数生成KEY
	 * 
	 * @param strKey
	 */
	public void getKey(String strKey) {
		try {
			KeyGenerator _generator = KeyGenerator.getInstance("DES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
			secureRandom.setSeed(strKey.getBytes()); // 兼容solaris和 linux 系统
			_generator.init(secureRandom);
			this.key = _generator.generateKey();
			_generator = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加密String明文输入,String密文输出
	 * 
	 * @param strMing
	 * @return
	 */
	public String getEncString(String strMing) {
		byte[] byteMi = null;
		byte[] byteMing = null;
		String strMi = "";
		BASE64Encoder base64en = new BASE64Encoder();
		try {
			byteMing = strMing.getBytes("UTF8");
			byteMi = this.getEncCode(byteMing);// 加密
			strMi = base64en.encode(byteMi);// 编码
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			base64en = null;
			byteMing = null;
			byteMi = null;
		}
		return strMi;
	}

	/**
	 * 解密 以String密文输入,String明文输出
	 * 
	 * @param strMi
	 * @return
	 */
	public String getDesString(String strMi) {
		BASE64Decoder base64De = new BASE64Decoder();
		byte[] byteMing = null;
		byte[] byteMi = null;
		String strMing = "";
		try {
			byteMi = base64De.decodeBuffer(strMi);// 解码
			byteMing = this.getDesCode(byteMi);// 解密
			strMing = new String(byteMing, "UTF8");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			base64De = null;
			byteMing = null;
			byteMi = null;
		}
		return strMing;
	}

	/**
	 * 加密以byte[]明文输入,byte[]密文输出
	 * 
	 * @param byteS
	 * @return
	 */
	public byte[] getEncCode(byte[] byteS) {
		byte[] byteFina = null;
		Cipher cipher;
		try {
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			IvParameterSpec param = new IvParameterSpec(strIV.getBytes());
			cipher.init(Cipher.ENCRYPT_MODE, key, param);
			byteFina = cipher.doFinal(byteS);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;
	}

	/**
	 * 解密以byte[]密文输入,以byte[]明文输出
	 * 
	 * @param byteD
	 * @return
	 */
	public byte[] getDesCode(byte[] byteD) {
		Cipher cipher;
		byte[] byteFina = null;
		try {
			// using DES in CBC mode
			cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
			IvParameterSpec param = new IvParameterSpec(strIV.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, key, param);
			byteFina = cipher.doFinal(byteD);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cipher = null;
		}
		return byteFina;

	}

	public static void main(String[] args) {
//		String strKey = "12345678";//密钥
		String strKey = "536ETDFGTdftrevfdgfhtyrq4256";//密钥
		DESUtil des = new DESUtil();// 实例化一个对像
		des.getKey(strKey);// 生成密匙
		System.out.println("######DES加密开始");
		System.out.println("key:" + strKey);
		String dealStr = "W1234";
		String strEnc = des.getEncString(dealStr);// 加密字符串,返回String的密文
		System.out.println("密文:" + strEnc);
		
		String strDes = des.getDesString(strEnc);// 把String 类型的密文解密
		System.out.println("明文:" + strDes);
		System.out.println("######DES加密结束");
		try {
			//64编码
			String str1 = Base64.encode(strEnc.getBytes());
			System.out.println("64编码str1  = " + str1);
			//64解码
			String str11 = new String(Base64.decode(str1));
			System.out.println("64解码str11 = " + str11);
			
			//URL编码
			String str2 = URLEncoder.encode(str1, "UTF-8");
			System.out.println("URL编码str2  = " + str2);
			//URL解码
			String str21 = URLDecoder.decode(str2, "UTF-8");
			System.out.println("URL解码str21 = " + str21);
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
