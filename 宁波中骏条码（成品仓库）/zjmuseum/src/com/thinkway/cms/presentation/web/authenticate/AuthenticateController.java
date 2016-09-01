package com.thinkway.cms.presentation.web.authenticate;

public interface AuthenticateController {
	public String getTokenNeed();
	public long getPermission() ;
	public void setPermission(long permission);
	public void setAuthenticator(Authenticator auth);
	public Authenticator getAuthenticator();
}
