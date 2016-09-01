package com.thinkway.cms.util;

import com.sap.mw.jco.JCO;

/**
 * 访问SAP后，返回数据类
 * 
 * @author ZhangChunhao V1.0, jiang.shanwe
 * 
 */
public class SAPModel {

	public static final String SUCCESS = "S";
	public static final String ERROR = "E";
	public static final String WARNING = "W";
	public static final String INFORMATION = "I";
	public static final String INTERRUPT = "A";

	private String operationType; //操作成功/失败
	private String exceptionMessage;

	private JCO.ParameterList outs = null;
	private JCO.ParameterList outtab = null;

	public void setOuts(JCO.Function bapi) {
		outs = bapi.getExportParameterList();
	}

	public void setOuttab(JCO.Function bapi) {
		outtab = bapi.getTableParameterList();
	}

	public JCO.ParameterList getOuts() {
		return outs;
	}

	public JCO.ParameterList getOuttab() {
		return outtab;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

}
