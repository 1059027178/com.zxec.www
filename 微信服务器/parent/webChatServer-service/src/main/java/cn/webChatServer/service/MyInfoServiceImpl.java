package cn.webChatServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.webChatServer.ehr.dao.MyInfoDao;
import cn.webChatServer.ehr.pojo.MyInfo;
/**
 * @since 2017-12-28
 * @author qianyang
 *
 */
@Service("myInfoService")
public class MyInfoServiceImpl implements MyInfoService{
	@Autowired
	private MyInfoDao myInfoDao;
	
	public MyInfo queryMyInfoByUserNo(String userNo) {
		MyInfo myInfo = myInfoDao.queryMyInfoByUserNo(userNo);
		return myInfo;
	}

	public boolean updateMyInfo(MyInfo myInfo) {
		System.out.println("【start】更新"+myInfo.getUserno()+"个人信息");
		/*System.out.println("----1个人工号：" + myInfo.getUserno());
		System.out.println("----2个人邮箱：" + myInfo.getEmail());
		System.out.println("----3个人电话：" + myInfo.getUsertel());
		System.out.println("----4个人地址：" + myInfo.getUseraddress());
		System.out.println("----5父亲电话：" + myInfo.getFatherName());
		System.out.println("----6父亲生日：" + myInfo.getFatherBirth());
		System.out.println("----7母亲姓名：" + myInfo.getMotherName());
		System.out.println("----8母亲生日：" + myInfo.getMotherBirth());
		System.out.println("----9父母电话：" + myInfo.getTel());
		System.out.println("----10父母地址：" + myInfo.getAddress());*/
		// TODO Auto-generated method stub
		boolean flag = false;
		//传入对象不为空并且，工号不为空时进行更新
		if(myInfo != null && (myInfo.getUserno() != null || !myInfo.getUserno().equals(""))){
			System.out.println("---------------------更新个人信息中");
			int success = 0;
			success = myInfoDao.updateMyInfoByUserNo(myInfo);
			flag = (success > 0 ? true : false );
		}
		System.out.println("【end】更新"+myInfo.getUserno()+"个人信息");
		return flag;
	}

}
