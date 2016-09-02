package com.thinkway.cms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Escape {
	private final static String[] hex = { "00", "01", "02", "03", "04", "05",
			"06", "07", "08", "09", "0A", "0B", "0C", "0D", "0E", "0F", "10",
			"11", "12", "13", "14", "15", "16", "17", "18", "19", "1A", "1B",
			"1C", "1D", "1E", "1F", "20", "21", "22", "23", "24", "25", "26",
			"27", "28", "29", "2A", "2B", "2C", "2D", "2E", "2F", "30", "31",
			"32", "33", "34", "35", "36", "37", "38", "39", "3A", "3B", "3C",
			"3D", "3E", "3F", "40", "41", "42", "43", "44", "45", "46", "47",
			"48", "49", "4A", "4B", "4C", "4D", "4E", "4F", "50", "51", "52",
			"53", "54", "55", "56", "57", "58", "59", "5A", "5B", "5C", "5D",
			"5E", "5F", "60", "61", "62", "63", "64", "65", "66", "67", "68",
			"69", "6A", "6B", "6C", "6D", "6E", "6F", "70", "71", "72", "73",
			"74", "75", "76", "77", "78", "79", "7A", "7B", "7C", "7D", "7E",
			"7F", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89",
			"8A", "8B", "8C", "8D", "8E", "8F", "90", "91", "92", "93", "94",
			"95", "96", "97", "98", "99", "9A", "9B", "9C", "9D", "9E", "9F",
			"A0", "A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "AA",
			"AB", "AC", "AD", "AE", "AF", "B0", "B1", "B2", "B3", "B4", "B5",
			"B6", "B7", "B8", "B9", "BA", "BB", "BC", "BD", "BE", "BF", "C0",
			"C1", "C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "CA", "CB",
			"CC", "CD", "CE", "CF", "D0", "D1", "D2", "D3", "D4", "D5", "D6",
			"D7", "D8", "D9", "DA", "DB", "DC", "DD", "DE", "DF", "E0", "E1",
			"E2", "E3", "E4", "E5", "E6", "E7", "E8", "E9", "EA", "EB", "EC",
			"ED", "EE", "EF", "F0", "F1", "F2", "F3", "F4", "F5", "F6", "F7",
			"F8", "F9", "FA", "FB", "FC", "FD", "FE", "FF" };

	private final static byte[] val = { 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x00, 0x01,
			0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F,
			0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F, 0x3F };

	/**
	 * 编码
	 * 
	 * @param s
	 * @return
	 */
	public static String escape(String s) {
		StringBuffer sbuf = new StringBuffer();
		int len = s.length();
		for (int i = 0; i < len; i++) {
			int ch = s.charAt(i);
			if ('A' <= ch && ch <= 'Z') { // 'A'..'Z' : as it was
				sbuf.append((char) ch);
			} else if ('a' <= ch && ch <= 'z') { // 'a'..'z' : as it was
				sbuf.append((char) ch);
			} else if ('0' <= ch && ch <= '9') { // '0'..'9' : as it was
				sbuf.append((char) ch);
			} else if (ch == '-'
					|| ch == '_' // unreserved : as it was
					|| ch == '.' || ch == '!' || ch == '~' || ch == '*'
					|| ch == '\'' || ch == '(' || ch == ')') {
				sbuf.append((char) ch);
			} else if (ch <= 0x007F) { // other ASCII : map to %XX
				sbuf.append('%');
				sbuf.append(hex[ch]);
			} else { // unicode : map to %uXXXX
				sbuf.append('%');
				sbuf.append('u');
				sbuf.append(hex[(ch >>> 8)]);
				sbuf.append(hex[(0x00FF & ch)]);
			}
		}
		return sbuf.toString();
	}

	/**
	 * 解码 说明：本方法保证 不论参数s是否经过escape()编码，均能得到正确的“解码”结果

	 * 
	 * @param s
	 * @return
	 */
	public static String unescape(String s) {
		StringBuffer sbuf = new StringBuffer();
		int i = 0;
		int len = s.length();
		while (i < len) {
			int ch = s.charAt(i);
			if ('A' <= ch && ch <= 'Z') { // 'A'..'Z' : as it was
				sbuf.append((char) ch);
			} else if ('a' <= ch && ch <= 'z') { // 'a'..'z' : as it was
				sbuf.append((char) ch);
			} else if ('0' <= ch && ch <= '9') { // '0'..'9' : as it was
				sbuf.append((char) ch);
			} else if (ch == '-'
					|| ch == '_' // unreserved : as it was
					|| ch == '.' || ch == '!' || ch == '~' || ch == '*'
					|| ch == '\'' || ch == '(' || ch == ')') {
				sbuf.append((char) ch);
			} else if (ch == '%') {
				int cint = 0;
				if ('u' != s.charAt(i + 1)) { // %XX : map to ascii(XX)
					cint = (cint << 4) | val[s.charAt(i + 1)];
					cint = (cint << 4) | val[s.charAt(i + 2)];
					i += 2;
				} else { // %uXXXX : map to unicode(XXXX)
					cint = (cint << 4) | val[s.charAt(i + 2)];
					cint = (cint << 4) | val[s.charAt(i + 3)];
					cint = (cint << 4) | val[s.charAt(i + 4)];
					cint = (cint << 4) | val[s.charAt(i + 5)];
					i += 5;
				}
				sbuf.append((char) cint);
			} else { // 对应的字符未经过编码
				sbuf.append((char) ch);
			}
			i++;
		}
		return sbuf.toString();
	}

	 public static String StringFilter(String    str)   throws    PatternSyntaxException    {      
         // 只允许字母和数字        
         // String    regEx   =   "[^a-zA-Z0-9]";                      
         // 清除掉所有特殊字符   
	    String regEx="[ `~!@#$%^&*()+=|{}':;'\",\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";   
	    Pattern p = Pattern.compile(regEx);      
	    Matcher m = p.matcher(str); 
	    return m.replaceAll("").trim();      
    }   
	 
	 public static boolean hasAntiChar(String    str)   throws    PatternSyntaxException    {      
         // 只允许字母和数字        
         // String    regEx   =   "[^a-zA-Z0-9]";                      
         // 清除掉所有特殊字符   
	    String regEx="[ `~!@#$%^&*()+=|{}':;'\",\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";   
	    Pattern p = Pattern.compile(regEx);      
	    Matcher m = p.matcher(str); 
	    return m.find();      
    }
	 
	 public static boolean sql_inj(String str) { 
	    String inj_str = "':and:exec:insert:select:delete:update:count:*:%:chr:mid:master:truncate:char:declare:;:or:-:+:,"; 
	    String inj_stra[] = inj_str.split(":"); 
	    for (int i = 0; i < inj_stra.length; i++) { 
	      if (str.indexOf(inj_stra[i])!=-1) { 
	        return false; 
	      } 
	    } 
	    return true; 
	  } 
	 
	 public static String Html2Text(String inputString) { 
		    String htmlStr = inputString; //含html标签的字符串 
		        String textStr =""; 
		  java.util.regex.Pattern p_script; 
		  java.util.regex.Matcher m_script; 
		  java.util.regex.Pattern p_style; 
		  java.util.regex.Matcher m_style; 
		  java.util.regex.Pattern p_html; 
		  java.util.regex.Matcher m_html; 

		  try { 
		   String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; //定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script> } 
		   String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; //定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style> } 
		      String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式 
		  
		      p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE); 
		      m_script = p_script.matcher(htmlStr); 
		      htmlStr = m_script.replaceAll(""); //过滤script标签 

		      p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE); 
		      m_style = p_style.matcher(htmlStr); 
		      htmlStr = m_style.replaceAll(""); //过滤style标签 
		  
		      p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE); 
		      m_html = p_html.matcher(htmlStr); 
		      htmlStr = m_html.replaceAll(""); //过滤html标签 
		  
		   textStr = htmlStr; 
		  
		  }catch(Exception e) { 
		           System.err.println("Html2Text: " + e.getMessage()); 
		  } 

		  return textStr;//返回文本字符串 
		   }   
	 
	 


	     
	     /**
	      * "ISO-8859-1"格式字符转换成"GBK"
	      * @param str "ISO-8859-1"格式字符
	      * @return "GBK"格式字符
	      */
	     public static String toUTF8(String str) {
	     	try {
	             str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
	         } catch (UnsupportedEncodingException ex) {
	             ex.printStackTrace();
	         }
	         return str;
	     }
	     
	     /**
	      * 格式化显示日期
	      * @param date java.util.Date
	      * @param format 日期格式,如: yyyy年MM月dd日
	      * @return String
	      */
	     public static String formatDate(Date date, String format) {
	     	SimpleDateFormat dateFormat = new SimpleDateFormat();
	     	
	     	return dateFormat.format(date);
	     }
	     
	     /**
	      * "ISO-8859-1"格式字符转换成"GBK"
	      * @param str "ISO-8859-1"格式字符
	      * @return "UTF-8"格式字符
	      */
	     public static String toGBK(String str) {
	         try {
	             str = new String(str.getBytes("ISO-8859-1"), "gb2312");
	         } catch (UnsupportedEncodingException ex) {
	             ex.printStackTrace();
	         }
	         return str;
	     }

	     /**
	      * 将普通文本转换成html文本，避免html显示错误现象
	      * @param str String
	      * @return String
	      */
	     public static String toHtml(String str) {
	         if(str == null)
	             return null;
	         StringBuffer sb = new StringBuffer();
	         //获取字符串的长度
	         int len = str.length();

	         //转换特殊字符串
	         for(int i = 0; i < len; i++) {
	             char c = str.charAt(i);
	             switch(c) {
	             case ' ':
	                 sb.append("&nbsp;");
	                 break;
	             case '\n':
	                 sb.append("<br>");
	                 break;
	             case '\r':
	                 break;
	             case '\'':
	                 sb.append("&#39;");
	                 break;
	             case '<':
	                 sb.append("&lt;");
	                 break;
	             case '>':
	                 sb.append("&gt;");
	                 break;
	             case '&':
	                 sb.append("&amp;");
	                 break;
	             case '"':
	                 sb.append("&#34");
	                 break;
	             case '\\':
	                 sb.append("&#92");
	                 break;
	             default:
	                 sb.append(c);
	             }//end switch
	         }//end for

	         return sb.toString();
	     }





}
