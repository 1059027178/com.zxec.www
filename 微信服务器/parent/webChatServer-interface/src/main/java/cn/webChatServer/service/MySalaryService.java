package cn.webChatServer.service;

import java.util.List;

import cn.webChatServer.pojo.Salary;

/**
 * 我的薪资查询接口
 * @author qianyang
 *
 */
public interface MySalaryService {
	
	/**
	 * 
	 * @param userID 用户工号
	 * @param showEntry 显示数据条目
	 * @return
	 */
	public List<Salary> achieveSalaryInfo(String userID,int showEntry);
}
