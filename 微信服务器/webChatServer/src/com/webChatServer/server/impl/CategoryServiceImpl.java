package com.webChatServer.server.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.webChatServer.model.Category;
import com.webChatServer.server.iface.CategoryService;
import com.webChatServer.utils.HibernateSessionFactory;

public class CategoryServiceImpl implements CategoryService{

	@Override //û�к�Spring���ϵ����  
	public void save(Category category) {
		// TODO Auto-generated method stub
		Session session = HibernateSessionFactory.getSession();
		try{
			//�ֶ���������
			session.getTransaction().begin();
			//ִ��ҵ���߼�
			session.save(category);
			//�ύ����
			session.getTransaction().commit();
		}catch(Exception e){
			//����ʱ����������ع�
			session.getTransaction().rollback();
			//�׳��쳣
			throw new RuntimeException(e);
		}finally{
			HibernateSessionFactory.closeSession();
		}
	}
	/***spring��hibernate���Ϻ�Ļ���***/
	/*private SessionFactory sessionFactory;
	//����Ҫʹ��sessoinFactory��ʱ��Spring�ὫsessionFactoryע�����  
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//�ӵ�ǰ�̻߳�ȡsession�����û���򴴽�һ���µ�session  
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		getSession().update(category);
	}*/
	
	
}
