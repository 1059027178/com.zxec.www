package cn.webChatServer.mes.pojo;
import java.io.Serializable;
import java.util.List;

/**
 * 流转卡信息
 * @author qianyang
 * @since 2018-06-05
 */
public class FlowCard implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6648494192627638470L;
	//调用标识，成功为true，失败必须返回message信息
    private boolean status;
    //成功或失败信息，失败时该信息直接显示给用户
    private String message;
    //流转卡编号
    private String flowCardNo;
    //派工单号
    private String dispatchList;
    //产品代码
    private String productCode;
    //产品名称
    private String productName;
    //输出数据对象:流转卡详细信息
    private List<FlowCardDetailData> detailData;
    public FlowCard(){
    	super();
    }
    public FlowCard(boolean status, String message, String flowCardNo,
			String dispatchList, String productCode, String productName,
			List<FlowCardDetailData> detailData) {
		super();
		this.status = status;
		this.message = message;
		this.flowCardNo = flowCardNo;
		this.dispatchList = dispatchList;
		this.productCode = productCode;
		this.productName = productName;
		this.detailData = detailData;
	}
	public void setStatus(boolean status) {
         this.status = status;
     }
     public boolean getStatus() {
         return status;
     }

    public void setMessage(String message) {
         this.message = message;
     }
     public String getMessage() {
         return message;
     }

    public void setFlowCardNo(String flowCardNo) {
         this.flowCardNo = flowCardNo;
     }
     public String getFlowCardNo() {
         return flowCardNo;
     }

    public void setDispatchList(String dispatchList) {
         this.dispatchList = dispatchList;
     }
     public String getDispatchList() {
         return dispatchList;
     }

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
	public List<FlowCardDetailData> getDetailData() {
		return detailData;
	}
	public void setDetailData(List<FlowCardDetailData> detailData) {
		this.detailData = detailData;
	}

}