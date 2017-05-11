package com.thinkway.cms.util;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
* Title: Ext JS 辅助类
* Description: 该类用于转换java对象为XML文件格式或JSON文件格式
* @author 葛昊
* @time: 2009年2月5日11:10:54
*/
public class ExtHelper {
/**
* 通过List生成XML数据
* @param recordTotal 记录总数，不一定与beanList中的记录数相等
* @param beanList 包含bean对象的集合
* @return 生成的XML数据
*/
@SuppressWarnings("unchecked")
public static String getXmlFromList(long recordTotal , List beanList) {
   Total total = new Total();
   total.setResults(recordTotal);
   List results = new ArrayList();
   results.add(total);
   results.addAll(beanList);
   XStream sm = new XStream(new DomDriver());
   for (int i = 0; i < results.size(); i++) {
    Class c = results.get(i).getClass();
    String b = c.getName();
    String[] temp = b.split("\\.");
    sm.alias(temp[temp.length - 1], c);
   }
   String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + sm.toXML(results);
   return xml;
}


/**
* 通过List生成JSON数据2
* @param beanList 包含bean对象的集合
* @return 生成的JSON数据
*/
@SuppressWarnings("unchecked")
public static String getJsonFromList2(List beanList){
	JSONArray JsonArray = JSONArray.fromObject(beanList);
	return JsonArray.toString();
}

/**
* 通过List生成XML数据
* @param beanList 包含bean对象的集合
* @return 生成的XML数据
*/
@SuppressWarnings("unchecked")
public static String getXmlFromList(List beanList){
   return getXmlFromList(beanList.size(),beanList);
}
/**
* 通过List生成JSON数据
* @param recordTotal 记录总数，不一定与beanList中的记录数相等
* @param beanList 包含bean对象的集合
* @return 生成的JSON数据
*/
@SuppressWarnings("unchecked")
public static String getJsonFromList(long recordTotal , List beanList){
   TotalJson total = new TotalJson();
   total.setResults(recordTotal);
   total.setItems(beanList);
   JSONObject JsonObject = JSONObject.fromObject(total);
   return JsonObject.toString();
}
/**
* 通过List生成JSON数据
* @param beanList 包含bean对象的集合
* @return 生成的JSON数据
*/
@SuppressWarnings("unchecked")
public static String getJsonFromList(List beanList){
   return getJsonFromList(beanList.size(),beanList);
}
/**
* 通过bean生成JSON数据
* @param bean bean对象
* @return 生成的JSON数据
*/
public static String getJsonFromBean(Object bean){
   JSONObject JsonObject = JSONObject.fromObject(bean);
   return JsonObject.toString();
}
}




/*
======================相关jar==============================

json-lib-2.2.1-jdk15.jar

xstream-1.3.jar

commons的一些相关jar

例如

commons-lang-2.3.jar

commons-logging-1.0.4.jar

commons-beanutils-1.6.jar

commons-collections-3.2.jar

ezmorph-1.0.4.jar



public ActionForward getAllDepartment(ActionMapping map, ActionForm form,
    HttpServletRequest request, HttpServletResponse response) throws Exception {
   BeanFactory bf=new ClassPathXmlApplicationContext("applicationContext-*.xml");
   DepartmentDao dptDao=(DepartmentDao)bf.getBean("dptManager");
   List<Department> dpts=dptDao.GetAllDpt();
   String json=ExtHelper.getJsonFromList(dpts);
   response.setContentType("text/json;charset=UTF-8");
   System.out.println(json);
   response.getWriter().write(json);
//   String xml=ExtHelper.getXmlFromList(dpts);
//   //System.out.println(xml);
//   response.setContentType("application/xml;charset=UTF-8");
//   response.getWriter().write(xml);
   return null;
}


var _store = new Ext.data.JsonStore({
   root:'items',
   autoLoad : true,
   fields:[
    {name:'id',mapping:'id'},
    {name:'dptNum',mapping:'dptNum'},
    {name:'dptName',mapping:'dptName'},
    {name:'dptMan',mapping:'dptMan'}
   ],
   proxy : new Ext.data.HttpProxy({
    url : 'getAllDepartment.do?method=getAllDepartment'
   })
});
*/

