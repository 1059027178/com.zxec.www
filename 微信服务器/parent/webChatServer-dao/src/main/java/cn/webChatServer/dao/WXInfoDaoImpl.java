package cn.webChatServer.dao;

import org.apache.ibatis.session.SqlSession;

import cn.webChatServer.pojo.WXInfo;

public class WXInfoDaoImpl implements WXInfoDao{

	public SqlSession sqlSession;
	public WXInfoDaoImpl (SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	public WXInfo queryByClassName(String className) {
		// TODO Auto-generated method stub
		return this.sqlSession.selectOne("WXInfoDaoMapper.queryByClassName", className);
	}

	public WXInfo queryByCondition(String condition) {
		// TODO Auto-generated method stub
		return this.sqlSession.selectOne("WXInfoDaoMapper.queryByCondition", condition);
	}

	public void updateWXInfo(WXInfo wXInfo) {
		// TODO Auto-generated method stub
		this.sqlSession.update("WXInfoDaoMapper.updateWXInfo", wXInfo);
	}

}
