package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mk.portal.framework.dao.HibernateUtil;

public class QueryDao<T> {
	private SessionFactory getSessionFactory() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		if(sf==null){
			sf=HibernateUtil.createSessionFactory();
		}
		return sf;
	}
	
	@SuppressWarnings({ "unchecked" })
	public List<T> findListByQuery(String query, List<String> listOfParams) {
		List<T> resultList = new ArrayList<T>();
		Session session = getSessionFactory().openSession();
			Query queryObject = session.createQuery(query);
			for(int i=0;i<listOfParams.size();i++){
				queryObject.setParameter(i, listOfParams.get(i));
			}
			resultList = queryObject.list();
			session.close();
		return resultList;
	}

}
