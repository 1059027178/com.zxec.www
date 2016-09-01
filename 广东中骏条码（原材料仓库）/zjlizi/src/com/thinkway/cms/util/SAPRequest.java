package com.thinkway.cms.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.Assert;

/**
 * 封装SAP请求参数，包括输入值，输入结构，输入表
 * 
 */
public class SAPRequest {

	private String functionName; // 函数名
	private Map<String, String> inputParameterMap; // 输入参数

	// TODO 输入结构

	// 输入表Map<String tableName, Map<String columnName, String columnValue>>
	private Map<String, List<Map<String, String>>> inputTables;

	public SAPRequest() {
		super();
	}

	public SAPRequest(String functionName) {
		super();
		this.functionName = functionName;
	}

	public SAPRequest(String functionName, Map<String, String> inputParameterMap) {
		super();
		this.functionName = functionName;
		this.inputParameterMap = inputParameterMap;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public Map<String, String> getInputParameterMap() {
		return inputParameterMap;
	}

	public void setInputParameterMap(Map<String, String> inputParameterMap) {
		this.inputParameterMap = inputParameterMap;
	}

	public void addParameter(String key, String value) {
		if (this.inputParameterMap == null) {
			this.inputParameterMap = new HashMap<String, String>();
		}
		this.inputParameterMap.put(key, value);
	}

	/**
	 * 添加表及键值对
	 * 
	 * @param tableName
	 *            表名
	 * @param columnNameArr
	 *            列名序列
	 * @param columnValueArr
	 *            列名对应的值序列
	 */
	public void addInputTable(String tableName, String[] columnNameArr, String[] columnValueArr) {
		// 检查输入参数
		Assert.hasText(tableName, "输入表名不能为空");
		Assert.notEmpty(columnNameArr, "至少需要一个列名");
		Assert.notEmpty(columnValueArr, "至少输入一个参数");
		Assert.isTrue(columnNameArr.length == columnValueArr.length, "列名和列值个数不一致");

		// 确认初始化函数列表，函数键值对
		if (this.inputTables == null) {
			this.inputTables = new HashMap<String, List<Map<String, String>>>();
		}
		if (!inputTables.containsKey(tableName)) {
			this.inputTables.put(tableName, new ArrayList<Map<String, String>>());
		}

		// 赋值
		Map<String, String> columnMap = new HashMap<String, String>();
		for (int i = 0; i < columnValueArr.length; i++) {
			columnMap.put(columnNameArr[i], columnValueArr[i]);
		}
		this.inputTables.get(tableName).add(columnMap);
	}

	public Map<String, List<Map<String, String>>> getInputTables() {
		return inputTables;
	}

	public void setInputTables(Map<String, List<Map<String, String>>> inputTables) {
		this.inputTables = inputTables;
	}

	@Override
	public String toString() {
		return "SAPRequest [functionName=" + functionName + ", inputParameterMap=" + inputParameterMap
				+ ", inputTables=" + inputTables + "]";
	}

}
