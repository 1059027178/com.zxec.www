package com.ssh.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ssh.pojo.Customer;
/*
 * 测试hibernate单独配置是否成功
 */
public class TestHibernateConfig {
	private SessionFactory sf;
	@Before
	public void init() throws Exception{
		Configuration conf = new Configuration();
		conf.configure();
		sf = conf.buildSessionFactory();
	}
	
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
