package com.ssh.test;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.pojo.Customer;
/*
 * 测试hibernate与spring整合是否成功
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestHibernateToSpringConfig {
	//注入spring中容器的sessionFactory
	@Resource(name="sessionFactory")
	private SessionFactory sf;
	@Test
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
}
