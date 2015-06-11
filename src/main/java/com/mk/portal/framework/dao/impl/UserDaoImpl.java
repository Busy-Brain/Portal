package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.model.User;
import com.mk.portal.framework.dao.UserDao;

public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public User findByUserName(String username) {

		List<User> users = new ArrayList<User>();
		try{
		users = getSessionFactory().getCurrentSession().createQuery("from User where username=?")
				.setParameter(0, username).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if ((users.size() ==1)&&(((User)users.get(0)).getUsername().equalsIgnoreCase(username))) {
			return users.get(0);
		} else {
			return null;
		}

	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}