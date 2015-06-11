package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.model.PortalUser;
import com.mk.portal.framework.model.UserRole;
import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.dao.UserDao;
import com.mk.portal.framework.entity.RolesEntity;
import com.mk.portal.framework.entity.UserEntity;
import com.mk.portal.framework.entity.UserRolesEntity;

public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private RolesDao rolesDao;
	@SuppressWarnings("unchecked")
	public PortalUser findByUserName(String username) {

		List<UserEntity> users = new ArrayList<UserEntity>();
		try{
		users = getSessionFactory().getCurrentSession().createQuery("from UserEntity where username=?")
				.setParameter(0, username).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if ((users.size() ==1)&&(((UserEntity)users.get(0)).getUsername().equalsIgnoreCase(username))) {
			
			return convertUserEntityToUser(users.get(0));
		} else {
			return null;
		}

	}

	private PortalUser convertUserEntityToUser(UserEntity userEntity) {
		PortalUser user = PortalUser.builder()
				.userId(userEntity.getUserId())
				.userName(userEntity.getUsername())
				.password(userEntity.getPassword())
				.enabled(userEntity.isEnabled())
				.build();
		for(UserRolesEntity re:userEntity.getUserRole()){
			user.addRole(rolesDao.findByRoleId(re.getRoleId()));
		}
		return user;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}