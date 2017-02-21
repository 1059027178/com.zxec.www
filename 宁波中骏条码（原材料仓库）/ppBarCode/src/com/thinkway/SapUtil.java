package com.thinkway;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.sap.mw.jco.IFunctionTemplate;
import com.sap.mw.jco.JCO;
import com.sap.mw.jco.JCO.Structure;
import com.thinkway.cms.util.SAPModel;
import com.thinkway.cms.util.SAPRequest;

public class SapUtil {

	public static final String POOL_NAME = "Sample_Pool";
	public static final int max_connection = 3;
	/**
	 * @author YangYang
	 * @time 2016年05月31日
	 * @action sap测试环境配置
	 * @return
	 */
	public static JCO.Client getSAPcon() {
		Properties logonProperties = new Properties();
		logonProperties.put("jco.client.sysnr", "00");
		logonProperties.put("jco.client.ashost", "192.168.0.182");
		logonProperties.put("jco.client.client", "667");
		logonProperties.put("jco.client.user", "abap7");
		logonProperties.put("jco.client.passwd", "121212");
		logonProperties.put("jco.client.CodePage", "8400");
		JCO.Client myConnection = JCO.createClient(logonProperties);
		return myConnection;
	}
	/**
	 * @author YangYang
	 * @time 2016年11月19日
	 * @action sap正式机
	 * @return
	 */
	/*public static JCO.Client getSAPcon() {
		Properties logonProperties = new Properties();
		logonProperties.put("jco.client.sysnr", "00");
		logonProperties.put("jco.client.ashost", "192.168.0.183");
		logonProperties.put("jco.client.client", "800");
		logonProperties.put("jco.client.user", "abap7");
		logonProperties.put("jco.client.passwd", "domino");
		logonProperties.put("jco.client.CodePage", "8400");
		JCO.Client myConnection = JCO.createClient(logonProperties);
		return myConnection;
	}*/

	public static void releaseClient(JCO.Client myConnection) {
		if (null != myConnection) {
			JCO.releaseClient(myConnection);
		}
	}

	public static String null2String(String paramString) {
		return paramString == null ? "" : paramString;
	}

	public static String getCurrentDateTime() {
		String returnStr = null;
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		returnStr = f.format(date);
		return returnStr;
	}

	/*
	 * 获取今天的日期-短格式20130613
	 */
	public static String getTodayWithSdt() {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(new Date());
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		return format.format(c1.getTime());
	}

	public static double getDoubleValue(String str) {
		double i = 0;
		try {
			i = Double.parseDouble(str);
		} catch (Exception e) {
			i = -1;
		}
		return i;
	}

	public static int getIntValue(String str) {
		int i = 0;
		try {
			i = Integer.parseInt(str);
		} catch (Exception e) {
			i = -1;
		}
		return i;
	}

	/*
	 * public static void main(String[] args) { String str="4444.1122"; double
	 * num; DecimalFormat myformat=new java.text.DecimalFormat("#0.00");
	 * num=Double.parseDouble(str);//装换为double类型
	 * num=Double.parseDouble(myformat.format(num));//保留2为小数
	 * System.out.println(num); }
	 */
	/**
	 * 通过{@link SAPRequest} 访问SAP
	 * 
	 * @param sapRequest
	 *            封装了函数名，输入参数，输入表（输入结构）
	 * @return 请求结果
	 */
	public static SAPModel OperSAP(SAPRequest sapRequest) {
		SAPModel model = new SAPModel();
		JCO.Client conn = null;
		try {
			conn = SapUtil.getSAPcon();
			conn.connect();

			JCO.Repository repo = new JCO.Repository("Repository", conn);
			IFunctionTemplate ft = repo.getFunctionTemplate(sapRequest.getFunctionName());
			JCO.Function bapi = ft.getFunction();
			JCO.ParameterList parameterList = bapi.getImportParameterList();

			// 输入参数赋值
			if (null != sapRequest.getInputParameterMap()) {
				for (Map.Entry<String, String> entry : sapRequest.getInputParameterMap().entrySet()) {
					try {
						parameterList.setValue(entry.getValue().trim(), entry.getKey());
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

			// 输入表赋值
			if (null != sapRequest.getInputTables()) {
				JCO.ParameterList inputTable = bapi.getTableParameterList();
				for (Entry<String, List<Map<String, String>>> entry : sapRequest.getInputTables().entrySet()) {
					JCO.Table iTable = inputTable.getTable(entry.getKey());
					for (Map<String, String> columnMapList : entry.getValue()) {
						iTable.appendRow();
						for (Entry<String, String> columnMap : columnMapList.entrySet()) {
							if (null == columnMap.getValue()) {
								continue;
							}
							iTable.setValue(columnMap.getValue().trim(), columnMap.getKey().trim());
						}
					}
				}
			}

			conn.execute(bapi);
			model.setOuts(bapi);
			model.setOuttab(bapi);
			model.setOperationType(SAPModel.SUCCESS);

		} catch (Exception e) {
			model.setOperationType(SAPModel.ERROR);
			model.setExceptionMessage(e.getMessage());
		} finally {
			if (null != conn) {
				SapUtil.releaseClient(conn);
			}
		}
		return model;
	}
}
