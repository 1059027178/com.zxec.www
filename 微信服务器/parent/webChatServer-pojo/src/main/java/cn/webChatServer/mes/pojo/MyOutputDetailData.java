package cn.webChatServer.mes.pojo;

import java.io.Serializable;

/**
 * 个人产量信息明细
 * @author qianyang
 * @since 2018-06-05
 */
public class MyOutputDetailData implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8322510029012292558L;
	//产品代码
    private String productCode;
    //产品描述
    private String productName;
    //工序名称
    private String processName;
    //报工数量
    private Integer count;
    public void setProductCode(String productCode) {
         this.productCode = productCode;
     }
     public String getProductCode() {
         return productCode;
     }

    public void setProductName(String productName) {
         this.productName = productName;
     }
     public String getProductName() {
         return productName;
     }

    public void setProcessName(String processName) {
         this.processName = processName;
     }
     public String getProcessName() {
         return processName;
     }
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "MyOutputDetailData [productCode=" + productCode
				+ ", productName=" + productName + ", processName="
				+ processName + ", count=" + count + "]";
	}
}