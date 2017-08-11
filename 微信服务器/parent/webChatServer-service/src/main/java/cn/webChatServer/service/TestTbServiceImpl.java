package cn.webChatServer.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.webChatServer.dao.TestTbDao;
import cn.webChatServer.pojo.TestTb;

public class TestTbServiceImpl implements TestTbService{
	@Autowired
	TestTbDao testTbDao;
	public void add(TestTb testTb) {
		// TODO Auto-generated method stub
		testTbDao.add(testTb);
	}

}
