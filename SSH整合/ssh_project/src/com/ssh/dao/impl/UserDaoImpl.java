package com.ssh.dao.impl;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.ssh.dao.UserDao;
import com.ssh.pojo.User;
//HibernateDaoSupport 为dao方法注入sessionfactory
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	public User getByUserCode(final String usercode) {
		
		//HQL方式查询
		/*return super.getHibernateTemplate().execute(new HibernateCallback<User>() {
			public User doInHibernate(Session session) throws HibernateException {
				String sql = "from User where user_code = ?";
				Query query = session.createQuery(sql);
				query.setParameter(0, usercode);
				User user = (User) query.uniqueResult();
				return user;
			}
			
		});*/
		
		//criteria方式查询
		DetachedCriteria dc = DetachedCriteria.forClass(User.class);
		dc.add(Restrictions.eq("user_code", usercode));
		List<User> users = (List<User>) super.getHibernateTemplate().findByCriteria(dc);
		if(users != null && users.size() > 0){
			return users.get(0);
		}else{
			return null;
		}
	}

	public void saveUser(User u) {
		super.getHibernateTemplate().save(u);
	}

}
