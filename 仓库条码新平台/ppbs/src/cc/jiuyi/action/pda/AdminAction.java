package cc.jiuyi.action.pda;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.struts2.convention.annotation.ParentPackage;

import cc.jiuyi.entity.Admin;
import cc.jiuyi.service.AdminService;

/**
 * 后台Action类 - 后台管理、管理员
 */

@ParentPackage("pda")
public class AdminAction extends BasePdaAction {

	private static final long serialVersionUID = 7957322386195478563L;
	private Admin admin;
	@Resource
	private AdminService adminService;
	public String updateUserPasswd(){
		if(admin.getUsername()==null||admin.getPassword()==null||"".equals(admin.getUsername())||"".equals(admin.getPassword())){
			return this.ajaxJsonErrorMessage("用户或密码不能为空");
	}
		String password=DigestUtils.md5Hex(admin.getPassword());
	    admin=adminService.getAdminByUsername(admin.getUsername());
	    admin.setPassword(password);
		adminService.update(admin);
		return this.ajaxJsonSuccessMessage("修改密码成功");
	}
	
	public String updatePassword(){
		  admin=adminService.load(id);
		return "password";
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}