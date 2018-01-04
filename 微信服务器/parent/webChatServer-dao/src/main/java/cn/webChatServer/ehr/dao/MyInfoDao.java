package cn.webChatServer.ehr.dao;

import org.apache.ibatis.annotations.Param;

import cn.webChatServer.ehr.pojo.MyInfo;

/**
 * EHR系统用户信息查询及更新
 * @author qianyang
 * @since 2017-12-28
 */
public interface MyInfoDao {
	/**
	 * 使用工号查询有关个人EHR系统信息
	 * @param userNo
	 * @return
	 */
	public MyInfo queryMyInfoByUserNo(@Param("userNo")String userNo);
	/**
	 * 更新个人信息
	 * @param userNo
	 * @return 返回大于0说明更新成功
	 */
	public int updateMyInfoByUserNo(MyInfo myInfo);
	
}
