package com.thinkway.cms.business.service.iface;

import java.util.List;

import com.thinkway.cms.business.domains.DelLockUser;
import com.thinkway.cms.business.query.BaseQuery;

public interface DelLockUserService {

	
	public DelLockUser createDelLockUser(DelLockUser dellockuser);
		
	public DelLockUser getDelLockUser(String vbeln);
	
	public boolean deleteDelLockUserByVbeln(String vbeln);
			
	public boolean deleteDelLockUserByUserid(String userid);
		
}