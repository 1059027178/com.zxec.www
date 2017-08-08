package cn.webChatServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.webChatServer.dao.TestTbDao;
import cn.webChatServer.pojo.TestTb;


@Service("testTbService")
@Transactional
public class TestTbServiceImpl implements TestTbService {
	@Autowired
	private TestTbDao testTbDao;

	public void add(TestTb testTb) {
		// TODO Auto-generated method stub
		testTbDao.add(testTb);
		
		//int i = 5/0; //制造异常
	}

}
