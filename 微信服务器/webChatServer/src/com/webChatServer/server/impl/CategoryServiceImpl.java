package com.webChatServer.server.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.webChatServer.model.Category;
import com.webChatServer.server.iface.CategoryService;
import com.webChatServer.utils.HibernateSessionFactory;

public class CategoryServiceImpl implements CategoryService{

	@Override //没有和Spring整合的情况  
	public void save(Category category) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		try{
			//手动启动事务
			session.getTransaction().begin();
			//执行业务逻辑
			session.save(category);
			//提交事务
			session.getTransaction().commit();
		}catch(Exception e){
			//出错时，进行事务回滚
			session.getTransaction().rollback();
			//抛出异常
			throw new RuntimeException(e);
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	/***spring与hibernate整合后的环境***/
	/*private SessionFactory sessionFactory;
	//当需要使用sessoinFactory的时候，Spring会将sessionFactory注入进来  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//从当前线程获取session，如果没有则创建一个新的session  
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		getSession().update(category);
	}*/
	
	
}
