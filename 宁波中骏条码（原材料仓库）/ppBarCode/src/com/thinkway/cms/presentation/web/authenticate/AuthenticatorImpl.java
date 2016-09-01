package com.thinkway.cms.presentation.web.authenticate;

import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.business.service.localimpl.UserServiceImpl;


public class AuthenticatorImpl implements Authenticator {

	public boolean hasPermission(String expectedPermission, String actualPermission) {
		if(actualPermission.indexOf(expectedPermission)!=-1)
			return true;
		return false;
	}

	public String loadPermissions(String userId) {
		UserService usrSvc = new UserServiceImpl();
		return usrSvc.getUser(userId).getUserFunction();
	}

}
