package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.HibernateUtil;
import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.dao.UserDao;
import com.mk.portal.framework.entity.UserEntity;
import com.mk.portal.framework.entity.UserRolesEntity;
import com.mk.portal.framework.model.PortalUser;
import com.mk.portal.framework.model.UserRole;

public class UserDaoImpl implements UserDao {

	@Autowired
	private RolesDao rolesDao;
	@SuppressWarnings("unchecked")
	public PortalUser findByUserName(String username) {

		List<UserEntity> users = new ArrayList<UserEntity>();
		PortalUser user=null;
		Session session = getSessionFactory().openSession();
		users = session.createQuery("from UserEntity where username=?")
				.setParameter(0, username).list();
		
		
		if ((users.size() ==1)&&(((UserEntity)users.get(0)).getUsername().equalsIgnoreCase(username))) {
			
			user= convertUserEntityToUser(users.get(0));
		} 
		session.close();
		return user;

	}

	private PortalUser convertUserEntityToUser(UserEntity userEntity) {
		PortalUser user = PortalUser.builder()
				.userId(userEntity.getUserId())
				.userName(userEntity.getUsername())
				.password(userEntity.getPassword())
				.enabled(userEntity.isEnabled())
				.build();
		for(UserRolesEntity re:userEntity.getUserRole()){
			user.addRole(new UserRole(re.getRole().getRoleId(), re.getRole().getRoleName()));
		}
		return user;
	}

	public SessionFactory getSessionFactory() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		if(sf==null){
			sf=HibernateUtil.createSessionFactory();
		}
		return sf;
	}

}