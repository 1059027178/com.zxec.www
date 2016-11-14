package cc.jiuyi.action.pda;
import org.apache.struts2.convention.annotation.ParentPackage;

/**
 * 专门处理菜单的跳转
 * 
 */
@ParentPackage("pda")
public class MenufpAction extends BasePdaAction {

	private static final long serialVersionUID = -3941997624055874033L;

	/**
	 * 主菜单列表
	 * 
	 * @return
	 */
	public String first() {
		return "index";
	}

	/**
	 * 入库业务
	 * 
	 * @return
	 */
	public String inbound() {
		return "inbound";
	}

	/**
	 * 采购入库
	 * 
	 * @return
	 */
	public String purchaseInbound() {
		return "inbound_purchase";
	}

	/**
	 * 生产入库
	 * 
	 * @return
	 */
	public String produceInbound() {
		return "inbound_produce";
	}

	/**
	 * 调拨入库
	 * 
	 * @return
	 */
	public String allocateInbound() {
		return "inbound_allocate";
	}

	/**
	 * 生产退库
	 * 
	 * @return
	 */
	public String produceReturnInbound() {
		return "inbound_produce_return";
	}

	/**
	 * 成本中心退库
	 * 
	 * @return
	 */
	public String costCenterReturnInbound() {
		return "inbound_cost_center_return";
	}

	/**
	 * 采购退货
	 * 
	 * @return
	 */
	public String purchaseReturnOutbound() {
		return "outbound_purchase_return";
	}

	/**
	 * 出库业务
	 * 
	 * @return
	 */
	public String outbound() {
		return "outbound";
	}

	/**
	 * 生产发料
	 * 
	 * @return
	 */
	public String produceGetMaterialOutbound() {
		return "outbound_produce_get_material";
	}

	/**
	 * 调拨出库
	 * 
	 * @return
	 */
	public String allocateOutbound() {
		return "outbound_allocate";
	}

	/**
	 * 成本中心出库
	 * 
	 * @return
	 */
	public String costCenterOutBound() {
		return "outbound_cost_center";
	}

	/**
	 * 外协出库
	 * 
	 * @return
	 */
	public String taitraOutBound() {
		return "outbound_taitra";
	}

	/**
	 * 销售出库
	 * 
	 * @return
	 */
	public String salesOutbound() {
		return "outbound_sales";
	}

	/**
	 * 内部作业业务
	 * 
	 * @return
	 */
	public String internalJob() {
		return "internal_job";
	}

	/**
	 * 盘点
	 * 
	 * @return
	 */
	public String inventory() {
		return "inventory";
	}

	/**
	 * 包装
	 * 
	 * @return
	 */
	public String packingInternalJob() {
		return "packing_internal_job";
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	public String query() {
		return "query";
	}
}