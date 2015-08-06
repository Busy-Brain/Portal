package com.mk.portal.framework.dao;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * This file is used to load hibernate configurations in Spring context
 * 
 * @author mohit
 *
 */
public class HibernateUtil {

	private static final String HIBERNATE_CFG_PATH = "./src/main/webapp/WEB-INF/hibernate.cfg.xml";
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;

	public static SessionFactory createSessionFactory() {
		Configuration configuration = new Configuration();
		File hibernateConfigFile = new File(HIBERNATE_CFG_PATH);

		configuration.configure(hibernateConfigFile);

		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}