package com.thinkway.cms.method.test;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.thinkway.cms.util.DataMethod;
import com.thinkway.cms.util.Escape;

import junit.framework.TestCase;

public class TestDataMethod extends TestCase {

  protected void setUp() throws Exception {
    super.setUp();
  }

  protected void tearDown() throws Exception {
    super.tearDown();
  }
  
  public void testTimeAdd(){
	  Calendar calFilter = Calendar.getInstance();
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	  calFilter.add(Calendar.DAY_OF_MONTH, -30);
	  System.out.println(sdf.format(calFilter.getTime()));
  }
  public void testHtml2Text(){
	  System.out.println(Escape.Html2Text(""));
  }
  
  public void testAntiChar(){
	  System.out.println(Escape.hasAntiChar("中国"));
  }

  //检查账套日期的方法
  public void testCheckLedgerDate() {
    String ledgerDate = "200313";
    int expectedReturn = 0;
    int actualReturn = DataMethod.checkLedgerDate(ledgerDate);
    assertEquals("return value", expectedReturn, actualReturn);
    ledgerDate = "200406";
    expectedReturn = 1;
    actualReturn = DataMethod.checkLedgerDate(ledgerDate);
    assertEquals("return value", expectedReturn, actualReturn);
  }
  //测试四舍五入的方法
  public void testRound()  throws Exception{
    double d = 15.67832;
    double result = DataMethod.round(d);
    assertEquals("return value", 15.68, result, 2);
  }
  //测试取得库存账套数据表的新序号的方法
  public void testGetStockLedgerNewOrder(){
    String orderId = "20040500001";
    String newOrderId = DataMethod.getStockLedgerNewOrder(orderId);
    assertEquals("", "20040500002", newOrderId);
  }
  //测试转换结束日期的方法
  public void testGetEndDate(){
    String dateStr = "2004-05-15 00:00:00.99";
    java.sql.Timestamp date = DataMethod.transferEndDate(dateStr);
    System.out.println(date);
  }
  //测试转换短日期的方法
  public void testGetShortDate(){
    String dateStr = "2004-5-3 12:15:23";
    java.sql.Date date = DataMethod.transferShortDate(dateStr);
    //System.out.println(date);
    assertEquals("2004-05-03", date);
  }
  //测试分离相关联的票据标识的方法
  public void testSplitLinkId(){
    String linkId = "st20040500001";
    linkId = DataMethod.splitLinkId(linkId);
    assertEquals("", "20040500001", linkId);
  }
  //测试将会计科目的@@标识转换为--标识
  public void testTransferAccountName(){
    String accountName = "存货@@1000001";
    accountName = DataMethod.transferAccountName(accountName);
    assertEquals("", "存货--1000001", accountName);
  }
  
  public void testReplaceAll(){
	  String sFileType = ".jpg";
	  String OriginalPicUrl = "aa.aa.jpg.jpg";
	  //System.out.print(OriginalPicUrl.toLowerCase().replaceAll(sFileType, "_medium"+sFileType));
	  System.out.print(OriginalPicUrl.toLowerCase().replaceAll("("+sFileType+")$", "_medium"+sFileType));
  }
}