package com.thinkway.cms.business.service.iface;

import java.util.List;

import com.thinkway.cms.business.domains.User;
import com.thinkway.cms.business.query.BaseQuery;
import com.thinkway.cms.business.domains.UserLog;

public interface UserService {

	/***********************************************
	 *用户管理
	 ***********************************************/
	//创建一个新用户
	public User createNewUser(User user);
	//注册一个新用户
	public User regNewUser(User user);
	//更新一个用户
	public boolean updateUser(User user);
	//根据用户ID获取用户的详细信息
	public User getUser(String id);
	//根据用户ID删除一个用户
	public boolean deleteUser(String id);
	//用户登录检查用户名和密码	
	public User findUserForLogin(User user);
	//根据组合关键字对象获取用户列表
	public List getMyUserByKW(BaseQuery queryObj);
	//根据组合关键字对象获取用户数目
	public int getMyUserCountByKW(BaseQuery queryObj);
	//根据多个用户ID删除对应的多个用户
	public boolean deleteUserByIds(String[] ids);
	/***********************************************
	 *用户日志管理
	 ***********************************************/
	
	//创建一条新的用户日志
	 public UserLog createNewUserLog(UserLog userLog);
	//根据组合关键字对象获取用户日志列表	 
	 public List getAllUserLogByKw(BaseQuery queryObj) ;
	//根据组合关键字对象获取用户日志数量
	public int getUserLogCountByKW(BaseQuery queryObj);
	//日志记录
	public void SystemLog(String dataObj,String dataObjText,String objPk,String operator,String opeartContent);
	
}