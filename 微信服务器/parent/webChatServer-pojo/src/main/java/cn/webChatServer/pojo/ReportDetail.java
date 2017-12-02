package cn.webChatServer.pojo;

import java.io.Serializable;

public class ReportDetail implements Serializable{

	/**
	 * 生成序列化ID
	 */
	private static final long serialVersionUID = 7345949223921545689L;
	/**
	 * 流转卡号
	 */
	private String finishCard;
	/**
	 * 派工单
	 */
	private String workOrder;
	/**
	 * 产品
	 */
	private String product;
	/**
	 * 产品名称
	 */
	private String productName;
	/**
	 * 报工人姓名
	 */
	private String reportName;
	/**
	 * 报工人工号
	 */
	private String reportNo;
	
	/**
	 * 工序名称
	 */
	private String reportProcess;
	/**
	 * 报工数量
	 */
	private String reportNumber;
	
	
	public String getFinishCard() {
		return finishCard;
	}
	public void setFinishCard(String finishCard) {
		this.finishCard = finishCard;
	}
	public String getWorkOrder() {
		return workOrder;
	}
	public void setWorkOrder(String workOrder) {
		this.workOrder = workOrder;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getReportName() {
		return reportName;
	}
	public void setReportName(String reportName) {
		this.reportName = reportName;
	}
	public String getReportNo() {
		return reportNo;
	}
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	public String getReportProcess() {
		return reportProcess;
	}
	public void setReportProcess(String reportProcess) {
		this.reportProcess = reportProcess;
	}
	public String getReportNumber() {
		return reportNumber;
	}
	public void setReportNumber(String reportNumber) {
		this.reportNumber = reportNumber;
	}
}
