package cn.webChatServer.service;

import cn.webChatServer.ehr.pojo.MyInfo;

/**
 * EHR系统个人信息维护
 * @since 2017-12-28
 * @author qianyang
 */
public interface MyInfoService {
	
	/**
	 * 查询用户EHR信息
	 * @param userNo
	 * @return
	 */
	public MyInfo queryMyInfoByUserNo(String userNo);
	/**
	 * 更新个人信息（以用户工号为条件更新）
	 * @param myInfo
	 * @return
	 */
	public boolean updateMyInfo(MyInfo myInfo);
}
