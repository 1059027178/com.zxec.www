package cc.jiuyi.action.admin;

import org.apache.struts2.convention.annotation.ParentPackage;

/**
 * 后台Action类 -静态分页
 */

@ParentPackage("admin")
public class PageAction extends BaseAdminAction {

	private static final long serialVersionUID = -425427885590846263L;

	
	// 列表
	public String jq() {
		return "jq";
	}

	

}