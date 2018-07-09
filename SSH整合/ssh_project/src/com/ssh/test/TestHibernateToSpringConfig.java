package com.ssh.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.dao.UserDao;
import com.ssh.pojo.Customer;
import com.ssh.pojo.User;
import com.ssh.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestHibernateToSpringConfig {
	//注入spring中容器的sessionFactory
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	@Test
	//测试hibernate与spring整合是否成功
	public void testName() throws Exception {
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		List<Customer> list = criteria.list();
		for (Customer customer : list) {
			System.out.println(customer);
		}
		tx.commit();
		session.close();
	}
	@After
	public void destory (){
		sf.close();
	}
	
	@Resource(name="userDao")
	private UserDao userDao;
	//测试dao hibernateTemplate
	@Test
	public void testName1() throws Exception {
		User user = userDao.getByUserCode("pack");
		System.out.println(user);
	}
	
	@Resource(name="userService")
	private UserService userService;
	//测试事务:xml配置方式  save
	@Test
	public void testName2() throws Exception {
		User u = new User();
		u.setUser_code("lisi");
		u.setUser_name("李四");
		userService.saveUser(u);
	}
	@Resource(name="userService2")
	private UserService userService2;
	//测试事务:注解配置方式  save
	@Test
	public void testName3() throws Exception {
		User u = new User();
		u.setUser_code("wmz");
		u.setUser_name("王麻子");
		userService2.saveUser(u);
	}
}
