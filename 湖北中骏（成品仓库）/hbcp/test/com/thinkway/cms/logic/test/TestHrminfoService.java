package com.thinkway.cms.logic.test;

import com.thinkway.cms.business.domains.hrminfo;
import com.thinkway.cms.business.service.iface.hrminfoService;
import com.thinkway.cms.business.service.localimpl.hrminfoServiceImpl;
public class TestHrminfoService {

	hrminfoService hrminfoService = null;
	public static void main(String[] args) {
		hrminfoService hr = new hrminfoServiceImpl();
		
		hrminfo hrminfo = hr.gethrminfoDataByObjno("322667");
		
		System.out.println("getName  = "+hrminfo.getName());
		System.out.println("getObjno = "+hrminfo.getObjno());
		System.out.println("getSex   = "+hrminfo.getSex());
	}
}
