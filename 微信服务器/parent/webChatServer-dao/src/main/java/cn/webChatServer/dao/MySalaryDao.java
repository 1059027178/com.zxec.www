package cn.webChatServer.dao;

import org.apache.ibatis.annotations.Param;

import cn.webChatServer.pojo.Salary;


public interface MySalaryDao {
	/**
	 * 一个参数时可省略@param
	 * <p>
	 * 当有多个参数时必须使用@param
	 * @param userId 用户工号
	 * @param yearAndMonth 查询年月(yyyyMM)
	 * @return 某月某工号下的薪资详细
	 */
	public abstract Salary queryByUserIdAndMonth(@Param("gh")String userId,@Param("ny")String yearAndMonth);

}
