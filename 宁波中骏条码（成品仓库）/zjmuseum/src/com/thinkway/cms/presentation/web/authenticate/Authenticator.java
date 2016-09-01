package com.thinkway.cms.presentation.web.authenticate;


/**
 * 权限验证器
 * @author Matt
 */
public interface Authenticator {

	//装载用户权限
	String loadPermissions(String userId);

	//判断用户是否具有某功能的权限
	boolean hasPermission(String expectedPermission, String actualPermission);

}
