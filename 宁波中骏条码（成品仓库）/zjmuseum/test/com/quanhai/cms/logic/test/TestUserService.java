package com.quanhai.cms.logic.test;

import java.util.List;

import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.query.UserQuery;
import com.thinkway.cms.business.service.iface.UserService;
import com.thinkway.cms.business.service.localimpl.UserServiceImpl;

import junit.framework.TestCase;

public class TestUserService extends TestCase {

	UserService userSvc = null;
	
	protected void setUp() {
		userSvc = new UserServiceImpl();
	}
	
	
	public void testCreateNewUser(){
		
        User user = new User();
        
        user.setUserName("中联绿创");
        user.setUserPassword("11111");
        UserService usrSvc = new UserServiceImpl();
        
        User actual = usrSvc.createNewUser(user);
        
        assertEquals(user, actual);
        
		
	}
	
	public void testUpdateUser(){

		
        UserService usrSvc = new UserServiceImpl();
        User user = usrSvc.getUser(""+5);
        user.setUserName("zllc2");
        user.setUserPassword("doudou");
      
        boolean actual = usrSvc.updateUser(user);
        
        assertEquals(true, actual);
        
		
	}
	
	public void testDeleteUser(){

		
        UserService usrSvc = new UserServiceImpl();
        boolean actual = usrSvc.deleteUser(""+7);
        
        assertEquals(true, actual);
        
		
	}	
	
	public void testGetCompanyUsers(){
		UserService usrSvc = new UserServiceImpl();
		User user = null;
		//boolean actual = false;
	   
		//assertEquals(true, actual);
	}
	
	public void testGetUsersByKW(){
		UserService usrSvc = new UserServiceImpl();
		@SuppressWarnings("unused")
		boolean actual = false;
		UserQuery gcQ = new UserQuery();
		User obj = null;
		@SuppressWarnings("unused")
		User result = null;
		gcQ.setCompanyId("9000");
		gcQ.setSkip(0);
		gcQ.setLimit(100);
		gcQ.setSdir("desc");
		gcQ.setSort("userId");
		List l1 = usrSvc.getMyUserByKW(gcQ);//测试关键字查询	
		for(int i=0;i<l1.size();i++){
			obj = (User)l1.get(i);
			System.out.println(obj.getUserName());

			actual = true;
		}		
	}
	

}


