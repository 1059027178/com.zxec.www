package cn.webChatServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webChatServer.dao.TestTbDao;
import cn.webChatServer.pojo.TestTb;

@Service("testTbService")
public class TestTbServiceImpl implements TestTbService{
	@Autowired
	private TestTbDao testTbDao;
	
	public void add(TestTb testTb) {
		// TODO Auto-generated method stub
		testTbDao.add(testTb);
	}

}
