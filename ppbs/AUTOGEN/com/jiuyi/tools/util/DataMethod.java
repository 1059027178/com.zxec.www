package com.jiuyi.tools.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.wltea.analyzer.lucene.IKAnalyzer;


public class DataMethod {	

    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式  
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式  
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符  
    private static final String emojiArrString = "/::)#$#/::~#$#/::B#$#/::|#$#/:8-)#$#/::<#$#/::$#$#/::X#$#/::Z#$#/::'(#$#/::-|#$#/::@#$#/::P#$#/::D#$#/::O#$#/::(#$#/::+#$#/:--b#$#/::Q#$#/::T#$#/:,@P#$#/:,@-D#$#/::d#$#/:,@o#$#/::g#$#/:|-)#$#/::!#$#/::L#$#/::>#$#/::,@#$#/:,@f#$#/::-S#$#/:?#$#/:,@x#$#/:,@@#$#/::8#$#/:,@!#$#/:!!!#$#/:xx#$#/:bye#$#/:wipe#$#/:dig#$#/:handclap#$#/:&-(#$#/:B-)#$#/:<@#$#/:@>#$#/::-O#$#/:>-|#$#/:P-(#$#/::'|#$#/:X-)#$#/::*#$#/:@x#$#/:8*#$#/:pd#$#/:<W>#$#/:beer#$#/:basketb#$#/:oo#$#/:coffee#$#/:eat#$#/:pig#$#/:rose#$#/:fade#$#/:showlove#$#/:heart#$#/:break#$#/:cake#$#/:li#$#/:bome#$#/:kn#$#/:footb#$#/:ladybug#$#/:shit#$#/:moon#$#/:sun#$#/:gift#$#/:hug#$#/:strong#$#/:weak#$#/:share#$#/:v#$#/:@)#$#/:jj#$#/:@@#$#/:bad#$#/:lvu#$#/:no#$#/:ok#$#/:love#$#/:<L>#$#/:jump#$#/:shake#$#/:<O>#$#/:circle#$#/:kotow#$#/:turn#$#/:skip#$#/:oY#$#";
    private static final String regEx_emoji = "/:[A-Za-z_,~'@\\?\\*$:+\\-)(|<>0-9!&]{1,8}";
  public DataMethod() {
  }
  
  
  //将字符串中的中文数字转换为阿拉伯数字
  public static String transferChineseNumToArabic(String queryText){
	  StringBuilder sb = new StringBuilder() ;
	  for (int i = 0; i < queryText.length(); i++) {
          char  item =  queryText.charAt(i);
          if(item=='一'){
        	  sb.append("1");
          }else if(item=='二'){
        	  sb.append("2");
          }else if(item=='三'){
        	  sb.append("3");
          }else if(item=='四'){
        	  sb.append("4");
          }else if(item=='五'){
        	  sb.append("5");
          }else if(item=='六'){
        	  sb.append("6");
          }else if(item=='七'){
        	  sb.append("7");
          }else if(item=='八'){
        	  sb.append("8");
          }else if(item=='九'){
        	  sb.append("9");
          }else{
        	  sb.append(item);
          }
      }
	  return sb.toString();
  }
   
  
  //获取String数组交集
  public static ArrayList<ArrayList<String>> getSubsets(ArrayList<String> set){  
      ArrayList<ArrayList<String>> allsubsets = new ArrayList<ArrayList<String>>();  
      int max = 1 << set.size(); //how many sub sets  
      for(int i=0; i<max; i++){  
          int index = 0;  
          int k = i;  
          ArrayList<String> s = new ArrayList<String>();  
          while(k > 0){  
              if((k&1) > 0){  
                  s.add(set.get(index));  
              }  
              k>>=1;  
              index++;  
          }  
          allsubsets.add(s);  
      }  
      return allsubsets;  
  }  
  
  
  
  /*
   * 统计中英文字符数，中文字符+2，英文字符+1
   */
  public static int calcWeiboLength(String str) {  
      int unicodeCount = 0;  
      int szCount = 0;  
      int zmCount = 0;  

      for (int i = 0; i < str.length(); i++) {  

          char c = str.charAt(i);  
          if (c >= '0' && c <= '9') {  
              szCount++;  
          }else if((c >= 'a' && c<='z') || (c >= 'A' && c<='Z')){  
              zmCount++;  
          }else{  
              unicodeCount++;  
          }  
      }  
      
      System.out.println("Unicode:"+unicodeCount);  
      System.out.println("数字："+szCount);  
      System.out.println("字母："+zmCount);    
      
      int sum=szCount/2+zmCount/2+unicodeCount;   
      System.out.println("lenght:："+sum);   
      return sum;  
  }     
  
  
	/**
	 * 比较版本号的大小,前者大则返回一个正数,后者大返回一个负数,相等则返回0
	 * @param version1
	 * @param version2
	 * @return
	 */
	public static int compareVersion(String version1, String version2) throws Exception {
		if (version1 == null || version2 == null) {
			throw new Exception("compareVersion error:illegal params.");
		}
		String[] versionArray1 = version1.split("\\.");//注意此处为正则匹配，不能用"."；
		String[] versionArray2 = version2.split("\\.");
		int idx = 0;
		int minLength = Math.min(versionArray1.length, versionArray2.length);//取最小长度值
		int diff = 0;
		while (idx < minLength
				&& (diff = versionArray1[idx].length() - versionArray2[idx].length()) == 0//先比较长度
				&& (diff = versionArray1[idx].compareTo(versionArray2[idx])) == 0) {//再比较字符
			++idx;
		}
		//如果已经分出大小，则直接返回，如果未分出大小，则再比较位数，有子版本的为大；
		diff = (diff != 0) ? diff : versionArray1.length - versionArray2.length;
		return diff;
	}
	
  
  public static String getRealContentWithEmoji(String contentStr){
	  String retStr = contentStr;
	  Pattern pattern = Pattern.compile(regEx_emoji);
	  Matcher m = pattern.matcher(contentStr); 
	  //StringBuffer sb = new StringBuffer(); 
	  
	  String replaceStr ="<img style='width:24px;height:24px;' src='/img/Expression/Expression_#@2x.png'/>";
	  while(m.find()){
		  //if(m.group().equals());
		  //System.out.println(getIndexEmojiFromEmojiArr(m.group()));
		  retStr=retStr.replace(m.group(), replaceStr.replace("#",""+getIndexEmojiFromEmojiArr(m.group())));
	  }
	  //System.out.println(sb);
	  return retStr;
  }
  
  public static int getIndexEmojiFromEmojiArr(String emojiStr){
	  int ret = 1;
	  //String arrStr = emojiArrString;
	  String emojiArr[] = emojiArrString.split("#\\$#");
	  //System.out.println(emojiArr);
	  for(int i=0;i<emojiArr.length;i++){
		  if(emojiStr.equals(emojiArr[i])){
			  return i+1;
		  }
		  ret = i;
	  }
	  
	  return ret;
  }
  
  public static String toHex(long time){    
      return Integer.toHexString((int)time);
  }
  
  
  /** 
   * @param htmlStr 
   * @return 
   *  删除Html标签 
   */  
  public static String delHTMLTag(String htmlStr) {  
      Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);  
      Matcher m_script = p_script.matcher(htmlStr);  
      htmlStr = m_script.replaceAll(""); // 过滤script标签  

      Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);  
      Matcher m_style = p_style.matcher(htmlStr);  
      htmlStr = m_style.replaceAll(""); // 过滤style标签  

      Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
      Matcher m_html = p_html.matcher(htmlStr);  
      htmlStr = m_html.replaceAll(""); // 过滤html标签  

      Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);  
      Matcher m_space = p_space.matcher(htmlStr);  
      htmlStr = m_space.replaceAll(""); // 过滤空格回车标签  
      return htmlStr.trim(); // 返回文本字符串  
  }  
  
  
  public static String filterDateTime(String text) { 
      String dateStr = text.replaceAll("r?n", " "); 
      dateStr = dateStr.replaceAll("\\s+"," ");  
      try { 
          System.out.println("******"+dateStr);
          List matches = null; 
          Pattern p = Pattern.compile("((\\d{1,4}[-|\\\\/]\\d{1,2}[-|\\\\/]\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2})|(\\d{1,4}[-|\\\\/]\\d{1,2}[-|\\\\/]\\d{1,2} \\d{1,2}:\\d{1,2}))", Pattern.CASE_INSENSITIVE|Pattern.MULTILINE); 
          Matcher matcher = p.matcher(dateStr); 
          if (matcher.find() && matcher.groupCount() >= 1) { 

              //System.out.println("matched!!");
              matches = new ArrayList(); 
              for (int i = 1; i <= matcher.groupCount(); i++) { 
                  String temp = matcher.group(i); 
                  matches.add(temp); 
              } 
          } else { 
              //System.out.println("not match");
              matches = Collections.EMPTY_LIST; 
          }            
          
          if (matches.size() > 0) { 
        	  System.out.println( ((String) matches.get(0)).trim());
              return ((String) matches.get(0)).trim(); 
          } else { 
        	  System.out.println("empty str!!!");
              return ""; 
          } 
          
      } catch (Exception e) { 
          return ""; 
      } 
  }
  
  public static String null2Str(String paramStr){
	  if(paramStr==null)
		  return "";
	  else
		  return paramStr;
	  
  }
  
  
//短信验证业务类型-special
  public static String getSmsTypeDes(char special){
	  String retStr = "";
	  switch(special){ 
	     case '1': 
	         retStr = "注册用户"; 
	         break; 
	     case '2': 
	    	 retStr = "密码找回"; 
	         break;  
	     case '3': 
	    	 retStr = "基金申请"; 
	         break;
	     default: 
	         retStr = "";
	         break; 
	  } 
	  return retStr;
  }
  
  //业务类型翻译-ispublic
  public static String getIsPublicStr(char isPublic){
	  String retStr = "";
	  switch(isPublic){ 
	     case 'N': 
	         retStr = "私有权限，非通讯录用户不能查看"; 
	         break; 
	     case 'Y': 
	    	 retStr = "公共权限，所有人都可以查看"; 
	         break; 
	     case 'E': 
	    	 retStr = "可选-自行决定查看权限"; 
	         break; 
	     default: 
	         retStr = "";
	         break; 
	  } 
	  return retStr;
  }
  
  //业务类型翻译-special
  public static String getIsSpecial(char special){
	  String retStr = "";
	  switch(special){ 
	     case 'N': 
	         retStr = ""; 
	         break; 
	     case 'Y': 
	    	 retStr = "<font color=red>已授权查看</font>"; 
	         break; 
	     default: 
	         retStr = "";
	         break; 
	  } 
	  return retStr;
  }
  //获取随机数
  public static Integer getRandomNum(Integer max){
	  Random random = new Random();
      return Math.abs(random.nextInt())%max;
  }
  //获取当前日期，指定格式的字符串
  public static String getCurrentDate(String formatStr){
	  String ret = "";
	  SimpleDateFormat dateformat1=new SimpleDateFormat(formatStr);
	  ret=dateformat1.format(new Date());
	  return ret;
  }
  
  
  
  //获取指定日期，指定格式的格式化字符串
  public static String getTheDate(Timestamp tp,String formatStr){
	  String ret = "";
	  SimpleDateFormat dateformat1=new SimpleDateFormat(formatStr);
	  if(tp==null){
		  tp=new Timestamp(System.currentTimeMillis());
	  }
	  ret=dateformat1.format(tp);
	  return ret;
  }
  
//获取指定日期，指定格式的格式化字符串
  public static String getTheDate1(Timestamp tp,String formatStr){
	  String ret = "";
	  SimpleDateFormat dateformat1=new SimpleDateFormat(formatStr);
	  if(tp==null){
		  ret = "";
	  }else{
		  ret=dateformat1.format(tp); 
	  }
	  
	  return ret;
  }
  

  public static Double getAmountOfAvalBalance(Double amount){
  	return amount<0?0:amount;
  }
  

  public static String getTotalValueStr(int stockamount,double stockzxj){
  	  String sRet = "--";
  	  String theUnit = "";
	  if(stockamount==0||stockzxj<=0)return sRet;
	  double dblNum = stockamount * stockzxj;
	  if(dblNum>100000000.0){
	        dblNum = dblNum/100000000.0;
	        theUnit = "亿";
	  }else{
	        dblNum = dblNum / 10000.0;
	        theUnit = "万";
	  }

	  DecimalFormat df = new DecimalFormat("0.00");
	  double d = dblNum; 
	  sRet = ""+df.format(d) + theUnit;
	  
	  return sRet;
  	
  }
  
  

  public static String getTotalValueStr(double dblNum){
  	  String sRet = "--";
  	  String theUnit = "";
	  if(dblNum==0)return sRet;
	  
	  if(dblNum>100000000.0){
	        dblNum = dblNum/100000000.0;
	        theUnit = "亿";
	  }else{
	        dblNum = dblNum / 10000.0;
	        theUnit = "万";
	  }
	  
	  
	  DecimalFormat df = new DecimalFormat("0.00");
	  double d = dblNum; 
	  sRet = ""+df.format(d) + theUnit;
	  
	  return sRet;
  	
  }
  
  public static String formatDecimalValue(String dblNum1){
  	  String sRet = "--";
  	  String theUnit = "";
  	  double dblNum=Double.parseDouble(dblNum1);
	  if(dblNum==0)return sRet;
	  DecimalFormat df = new DecimalFormat("0.00");
	  double d = dblNum; 
	  sRet = ""+df.format(d) + theUnit;
	  
	  return sRet;
  	
  }
  
  //转换成交总数和成交总金额单位
  public static String getTotalValueStr(String dblNum1){
  	  String sRet = "--";
  	  String theUnit = "";
  	  double dblNum=Double.parseDouble(dblNum1);
	  if(dblNum==0)return sRet;
	  if(dblNum>100000000.0){
	        dblNum = dblNum/100000000.0;
	        theUnit = "亿";
	  }else if(dblNum>10000.0){
	        dblNum = dblNum / 10000.0;
	        theUnit = "万";
	  }
	  
	  
	  DecimalFormat df = new DecimalFormat("0.00");
	  double d = dblNum; 
	  sRet = ""+df.format(d) + theUnit;
	  
	  return sRet;
  	
  }
  public static Integer dbl2Int(Double dFl){
  	return dFl.intValue();
  }
  
  public static int stringToInt(String intstr){
    Integer integer;
    integer = Integer.valueOf(intstr);
    return integer.intValue();
  }

  public static String getFormatAccountStr(String theAccStr){
  	char[] carr = theAccStr.toCharArray();
  	String retStr = "";
  	for(int i=0;i<carr.length;i++){
  		retStr+=carr[i];
  		if(i%4==3){
  			retStr+=' ';
  		}
  	}
  	return retStr;
  }

  public static String getSeachString(String txt,String fieldName){

              String strWhere ="  ";  //作为查询的条件       
              if (txt.trim().length() == 0){   
              	strWhere =" 1=1";   
             }else{
                  int start =0;//设定替换前的字符串长度
                  int end = 0;//设定替换后的字符串长度
                  String temptxt = txt.trim();
                  do{
                      start = temptxt.length();
                      temptxt = temptxt.replace("'", "  ").replace("  ", " ");
                      //防止用户输入多个空格,将两个空格替换成一个,一直循环到长度不变 先将 ' 替换成两个空格,防止用户恶意输入' 破坏Sql语句的完整性
                      end = temptxt.length();
                  } while (start != end);//如果替换前后长度变化,则继续替换
                  String[] tempStr = temptxt.split("\\ ");
                  for(int j=tempStr.length-1;j>=0;j--){
                      if (strWhere.trim().length() != 0)
                          strWhere += " and ";
                      //数据库字段,如果有更多字段,还可以继续~,有空可以考虑使用代码读取数据库表的字段,来进行组合
                      strWhere += "("+fieldName+" like '%"+ tempStr[j] +"%') ";
                  }
              }
              return strWhere;

  }



  public static String tpToStr(Timestamp ts){  
      String tsStr = "";   
      DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
      try {   
          //方法一   
          tsStr = sdf.format(ts);   
          //System.out.println(tsStr);   
          /*
          //方法二   
          tsStr = ts.toString();   
          System.out.println(tsStr);   
          */
      } catch (Exception e) {   
          e.printStackTrace();   
      }  
      return tsStr;

  }

  public static long calcBetween(String btime,String etime){
  	SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      long between = 0;
      try {
          java.util.Date begin = dfs.parse(btime);
          java.util.Date end = dfs.parse(etime);
          between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
      } catch (Exception ex) {
          ex.printStackTrace();
      }
      /*
       long day = between / (24 * 60 * 60 * 1000);
          long hour = (between / (60 * 60 * 1000) - day * 24);
          long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
          long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
      */
      
      return between/1000;
  }

  public static long calcBetweenNm(String btime,String etime){
  	SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      long between = 0;
      try {
          java.util.Date begin = dfs.parse(btime);
          java.util.Date end = dfs.parse(etime);
          between = (end.getTime() - begin.getTime());// 得到两者的毫秒数
      } catch (Exception ex) {
          ex.printStackTrace();
      }
      /*
       long day = between / (24 * 60 * 60 * 1000);
          long hour = (between / (60 * 60 * 1000) - day * 24);
          long min = ((between / (60 * 1000)) - day * 24 * 60 - hour * 60);
          long s = (between / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
      */
      
      return between;
  }
  	
  public static String getScalePic(String OriginalPicUrl,String iSize){
  	String thePicUrl="";
  	String sFileType = OriginalPicUrl.substring(OriginalPicUrl.lastIndexOf(".")).toLowerCase();
  	if(iSize.equals("medium")){
  		thePicUrl = OriginalPicUrl.toLowerCase().replaceAll("("+sFileType+")$", "_medium"+sFileType);
  	}else if(iSize.equals("small")){
  		thePicUrl = OriginalPicUrl.toLowerCase().replaceAll("("+sFileType+")$", "_small"+sFileType);
  	}else{
  		thePicUrl = OriginalPicUrl;
  	}
  	return thePicUrl;
  }	
  
  public static String getFirstImageOriginalPath(String imageStr){
	  String retStr = "";
	  if(imageStr!=null&&!imageStr.equals("")){
		  String[] arr = Split(imageStr,"|");
		  for(int i=0;i<arr.length;i++){
			  if(arr[i]!=null&!arr[i].equals("")){
				  retStr = ""+arr[i].substring(0, 4)+"/"+getScalePic(arr[i],"big");
				  break;
			  }
		  }
		 		  
	  }
  
	  return retStr;
  }
  
  public static String getFirstImagePath(String imageStr){
	  String retStr = "";
	  if(imageStr!=null&&!imageStr.equals("")){
		  String[] arr = Split(imageStr,"|");
		  for(int i=0;i<arr.length;i++){
			  if(arr[i]!=null&!arr[i].equals("")){
				  String userfolder = arr[i].split("_")[0];
				  retStr = ""+userfolder+"/"+getScalePic(arr[i],"medium");
				  break;
			  }
		  }
		 		  
	  }
  
	  return retStr;
  }
  
  public static String getFirstImagePath1(String imageStr,String uid){
	  String retStr = "";
	  if(imageStr!=null&&!imageStr.equals("")&&uid!=null&&!uid.equals("")){
		  String[] arr = Split(imageStr,"|");
		  for(int i=0;i<arr.length;i++){
			  if(arr[i]!=null&!arr[i].equals("")){
				  retStr = ""+arr[i].substring(0, uid.length())+"/"+getScalePic(arr[i],"medium");
				  break;
			  }
		  }
		 		  
	  }
  
	  return retStr;
  }

  
  
  /** *//**
   * 格式化中文字符，防止出现乱码
   * @param str
   * @return
   */
  public static String codeToString(String str) {
      String strString = str;
      try {
          byte tempB[] = strString.getBytes("UTF-8");
          strString = new String(tempB);
          return strString;
      } catch (Exception e) {
          return strString;
      }
  } 
  
  /** *//**
   * 获取完整的Url
   * @param request
   * @return
   * @throws Exception
   */
  public static String getBackUrl(javax.servlet.http.HttpServletRequest request) throws Exception {
      String strBackUrl = "";    
      try {
      strBackUrl = "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + request.getServletPath() + "?" + request.getQueryString();    
      //strBackUrl = java.net.URLEncoder.encode(strBackUrl,"gbk");
      } catch(Exception e) {
          throw e;
      }
      return strBackUrl;
  }
  
  /**
   *  判断某个字符串是否存在于数组中
   *  @param stringArray 原数组
   *  @param source 查找的字符串
   *  @return 是否找到
   */
  public static boolean contains(String[] stringArray, String source) {
   // 转换为list
   List<String> tempList = Arrays.asList(stringArray);
   
   // 利用list的包含方法,进行判断
   if(tempList.contains(source))
   {
    return true;
   } else {
    return false;
   }
  }
  
  public static String[] Split(String Source,String Delimiter)   {   
      int iCount, iPos, iLength;
		boolean bEnd; // 判断结束的符号是不是分割符号
		String sTemp; //   
		String[] aSplit = null, t = null; // aSplit结果返回 t临时的

		sTemp = Source;
		iCount = 0;
		iLength = Delimiter.length();
		bEnd = sTemp.endsWith(Delimiter);

		for (;;) {
			iPos = sTemp.indexOf(Delimiter);
			if (iPos < 0) // 直到没有分割的字符串，就退出
				break;
			else {

				if (iCount > 0)
					t = aSplit; // 第一次，不用拷贝数组

				iCount++;
				aSplit = new String[iCount]; // 新的数组，

				if (iCount > 1) { // 不是第一次，拷贝数组
					for (int i = 0; i < t.length; i++)
						aSplit[i] = t[i];
				}

				aSplit[iCount - 1] = sTemp.substring(0, iPos);
				sTemp = sTemp.substring(iPos + iLength); // 取余下的字符串
			}
		}

		if ((sTemp.length() >= 0) || bEnd) { // 判断最后剩余的 String，如果最后的字符是分割符号
			if (iCount > 0)
				t = aSplit;
			iCount++;
			aSplit = new String[iCount];
			if (iCount > 1) {
				for (int i = 0; i < t.length; i++)
					aSplit[i] = t[i];
			}

			aSplit[iCount - 1] = sTemp;
		}

		return aSplit;   
  }   

  // 改变序列号的方法
  public static String changeSerial(int serial){
    String serialStr = String.valueOf(serial);
    int zeroLength = 5 - serialStr.length();
    for(int i = 0; i < zeroLength; i++){
      serialStr = "0" + serialStr;
    }
    return serialStr;
  }
  // 取得当前日期的方法
  public static java.sql.Timestamp getCurrentDate(){
    Calendar calendar = Calendar.getInstance();
    java.sql.Timestamp time = new java.sql.Timestamp(calendar.getTime().getTime());
    return time;
  }
  //检查账套日期的方法
  public static int checkLedgerDate(String ledgerDate){
    int result = 0;
    if(ledgerDate.length() != 6){
      return result;
    }
    //检查年份是否是数字
    String tempYear = ledgerDate.substring(0, 4);
    try{
      Integer.parseInt(tempYear);
    }catch(Exception ex){
      return result;
    }
    //检查月份是否是数字
    String tempMonth = ledgerDate.substring(4, 6);
    try{
      int month = Integer.parseInt(tempMonth);
      if(month < 0 | month > 12){
        return result;
      }
    }catch(Exception ex){
      return result;
    }
    result = 1;
    return result;
  }
  //四舍五入的方法
  public static double round(double result){
    result = Math.round(result * 100);
    result = result/100;
    return result;
  }
  //检查是否是整数的方法
  public static int checkInt(String str){
    int result = 0;
    try{
      Integer.parseInt(str);
      result = 1;
    }catch(Exception ex){ }
    return result;
  }
  //检查数字是否大于0小于等于1的方法
  public static int checkNumIn0To1(String str){
    int result = 0;
    try{
      double num = Double.parseDouble(str);
      if(num <= 1 & num > 0){
        result = 1;
      }
    }catch(Exception ex){ }
    return result;
  }
  //检查数字大于等于0的方法
  public static int checkNumLargerThan0(String str){
    int result = 0;
    try{
      double num = Double.parseDouble(str);
      if(num >= 0){
        result = 1;
      }
    }catch(Exception ex){ }
    return result;
  }
  //检查日期的方法
  public static int[] checkDate(String dateStr){
    int[] dates = new int[3];
    //创建日期类
    Calendar date = Calendar.getInstance();
    //创建默认的日期格式的DateFormat类
    java.text.DateFormat dateFormat1 = java.text.DateFormat.getDateInstance();
    try{
      date.setTime(dateFormat1.parse(dateStr));
    }catch(Exception ex){
      dates[0] = -1;
      return dates;
    }
    dates[0] = date.get(Calendar.YEAR);
    dates[1] = date.get(Calendar.MONTH);
    dates[2] = date.get(Calendar.DAY_OF_MONTH);
    return dates;
  }
  //转换日期的方法，带时、分、秒、微秒
  public static java.sql.Timestamp transferDateTime(String dateStr){
	if(dateStr==null)return null;
	if(dateStr.equals(""))return null;
	dateStr=dateStr.replaceAll("[/]", "-");
	//System.out.println("**************"+dateStr);
    //声明java.sql类包的时间变量
    java.sql.Timestamp timeStamp = null;
    try{
      //创建日期转换类
      java.text.DateFormat dateLongFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      java.text.DateFormat dateShortFormat = new SimpleDateFormat("yyyy-MM-dd");

      if (dateStr.length() > 10) {
        timeStamp = new java.sql.Timestamp(dateLongFormat.parse(dateStr).getTime());}
      else {
        timeStamp = new java.sql.Timestamp(dateShortFormat.parse(dateStr).getTime());}
    }catch(Exception ex){
    	
    	ex.printStackTrace();
    }
    return timeStamp;
  }
  
  
//转换日期的方法，带时、分、秒、微秒
  public static java.sql.Timestamp transferDateTime(Date date){
    //声明java.sql类包的时间变量
    java.sql.Timestamp timeStamp = null;
    try{
      //创建日期转换类
      timeStamp = new java.sql.Timestamp(date.getTime());
    }catch(Exception ex){}
    return timeStamp;
  }
  
  
  //转换日期的方法，不带时、分、秒、微秒
  public static java.sql.Timestamp transferDate(String dateStr){
    //声明java.sql类包的时间变量
    java.sql.Timestamp timeStamp = null;
    try{
      //创建日期类
      Calendar date = Calendar.getInstance();
      //创建日期转换类
      java.text.DateFormat dateLongFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      java.text.DateFormat dateShortFormat = new SimpleDateFormat("yyyy-MM-dd");
      if (dateStr.length() > 10) {
        date.setTime(dateLongFormat.parse(dateStr));
      }else {
        date.setTime(dateShortFormat.parse(dateStr));
      }
      //将时、分、秒、微秒设为0
      date.set(Calendar.HOUR, 0);
      date.set(Calendar.MINUTE, 0);
      date.set(Calendar.SECOND, 0);
      date.set(Calendar.MILLISECOND, 0);
      timeStamp = new java.sql.Timestamp(date.getTime().getTime());
    }catch(Exception ex){}
    return timeStamp;
  }
  

  //取得库存账套数据表的新序号
  public static String getStockLedgerNewOrder(String orderId){
    long newOrderId = 0;
    newOrderId = Long.parseLong(orderId) + 1;
    return String.valueOf(newOrderId);
  }
  //转换结束日期的方法
  public static java.sql.Timestamp transferEndDate(String dateStr){
    //声明java.sql类包的时间变量
    java.sql.Timestamp timeStamp = null;
    try{
      //创建日期类
      Calendar date = Calendar.getInstance();
      //创建日期转换类
      java.text.DateFormat dateLongFormat = java.text.DateFormat.getDateTimeInstance();
      java.text.DateFormat dateShortFormat = java.text.DateFormat.getDateInstance();
      if (dateStr.length() > 10) {
        date.setTime(dateLongFormat.parse(dateStr));
      }else {
        date.setTime(dateShortFormat.parse(dateStr));
      }
      //将时、分、秒、微秒设为最大
      date.set(Calendar.HOUR, 23);
      date.set(Calendar.MINUTE, 59);
      date.set(Calendar.SECOND, 59);
      date.set(Calendar.MILLISECOND, 998);
      timeStamp = new java.sql.Timestamp(date.getTime().getTime());
    }catch(Exception ex){}
    return timeStamp;
  }
  //将长日期字符串转换为短日期变量
  public static java.sql.Date transferShortDate(String longDateStr){
    java.sql.Date date = null;
    try{
      //创建日期转换类
      java.text.DateFormat dateLongFormat = java.text.DateFormat.getDateTimeInstance();
      java.text.DateFormat dateShortFormat = java.text.DateFormat.getDateInstance();
      if (longDateStr.length() > 10) {
        date = new java.sql.Date(dateLongFormat.parse(longDateStr).getTime());
      }else {
        date = new java.sql.Date(dateShortFormat.parse(longDateStr).getTime());
      }
    }catch(Exception ex){}
    return date;
  }
  //分离关联标识的字符
  public static String splitLinkId(String linkId){
    linkId = linkId.substring(2, linkId.length());
    return linkId;
  }
  //将会计科目的@@标识转换为--标识
  public static String transferAccountName(String accountName){
    accountName = accountName.replaceAll("@@", "--");
    return accountName;
  }
  //将会计科目的--标识转换为@@标识
  public static String transferAccountNameBack(String accountName){
    accountName = accountName.replaceAll("--", "@@");
    return accountName;
  }
  
  /**  
   * 判断当前日期是星期几<br>  
   * <br>  
   * @param pTime 修要判断的时间<br>  
   * @return dayForWeek 判断结果<br>  
   * @Exception 发生异常<br>  
   */  
public static int dayForWeek(String pTime) throws Exception {   
	SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd");   
	Calendar c = Calendar.getInstance();   
	c.setTime(format.parse(pTime));   
	int dayForWeek = 0;   
	if(c.get(Calendar.DAY_OF_WEEK) == 1){   
	   dayForWeek = 7;   
	}else{   
	   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;   
	}   
	return dayForWeek;   
}  


/*
 * 转换字节为KB或MB
 */

	public static String getSizeStr(long size) {
		DecimalFormat df = new DecimalFormat("###.##");
		float f;
		if (size < 1024 * 1024) {
			f = (float) ((float) size / (float) 1024);
			return (df.format(new Float(f).doubleValue()) + "KB");
		} else {
			f = (float) ((float) size / (float) (1024 * 1024));
			return (df.format(new Float(f).doubleValue()) + "MB");
		}
	}
	
	
	/*** 
     * delete CRLF; delete empty line ;delete blank lines 
     *  
     * @param input 
     * @return 
     */  
    private static String deleteCRLFOnce(String input) {  
        if (!input.equals("")) {  
            return input.replaceAll("((\r\n)|\n)[\\s\t ]*(\\1)+", "$1").replaceAll("^((\r\n)|\n)", "");  
        } else {  
            return null;  
        }  
    }  
  
    /** 
     * delete CRLF; delete empty line ;delete blank lines 
     *  
     * @param input 
     * @return 
     */  
    public static String deleteCRLF(String input) {  
        input = deleteCRLFOnce(input);  
        return deleteCRLFOnce(input);  
    }  
    
    
    /**
	* 检测网络资源是否存在　
	* 
	* @param strUrl
	* @return
	*/
	public static boolean isNetFileAvailable(String strUrl) {
		InputStream netFileInputStream = null;
		try {
			URL url = new URL(strUrl);
			URLConnection urlConn = url.openConnection();
			netFileInputStream = urlConn.getInputStream();
			if (null != netFileInputStream) {
				return true;
			} else {
				return false;
			}
		} catch (IOException e) {
			return false;
		} finally {
			try {
				if (netFileInputStream != null)
					netFileInputStream.close();
			} catch (IOException e) {
			}
		}
	}


}
