package cn.webChatServer.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.webChatServer.pojo.CheckInfo;

public interface CheckInfoDao {
	/*根据用户工号及日期查询打卡记录*/
	public abstract List<CheckInfo> queryByUserIdAndCheckDay(@Param("userId")String userId,@Param("checkDay")String checkDay);
}
