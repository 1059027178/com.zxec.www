package com.thinkway.cms.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataMethod {
  public DataMethod() {
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
	  ret=dateformat1.format(tp);
	  return ret;
  }

  public static Double getAmountOfAvalBalance(Double amount){
  	return amount<0?0:amount;
  }
  	
  	
  public static Integer dbl2Int(Double dFl){
  	return dFl.intValue();
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
    //声明java.sql类包的时间变量
    java.sql.Timestamp timeStamp = null;
    try{
      //创建日期转换类
      java.text.DateFormat dateLongFormat = java.text.DateFormat.getDateTimeInstance();
      java.text.DateFormat dateShortFormat = java.text.DateFormat.getDateInstance();
      if (dateStr.length() > 10) {
        timeStamp = new java.sql.Timestamp(dateLongFormat.parse(dateStr).getTime());}
      else {
        timeStamp = new java.sql.Timestamp(dateShortFormat.parse(dateStr).getTime());}
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
      java.text.DateFormat dateLongFormat = java.text.DateFormat.getDateTimeInstance();
      java.text.DateFormat dateShortFormat = java.text.DateFormat.getDateInstance();
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


}
