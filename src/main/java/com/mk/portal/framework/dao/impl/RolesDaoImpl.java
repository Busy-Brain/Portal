package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.HibernateUtil;
import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.entity.RolesEntity;
import com.mk.portal.framework.model.UserRole;

public class RolesDaoImpl implements RolesDao {
	
	
	public SessionFactory getSessionFactory() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		if(sf==null){
			sf=HibernateUtil.createSessionFactory();
		}
		return sf;
	}

	

	public UserRole findByRoleId(int roleId) {


		List<RolesEntity> roles = new ArrayList<RolesEntity>();
		try{
			roles = getSessionFactory().getCurrentSession().createQuery("from RolesEntity where roleId=?")
				.setParameter(0, roleId).list();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if ((roles.size() ==1)&&(((RolesEntity)roles.get(0)).getRoleId()==roleId)) {
			
			return convertUserRolesEntityToUserRole(roles.get(0));
		} else {
			return null;
		}
	
	}

	private UserRole convertUserRolesEntityToUserRole(RolesEntity rolesEntity) {
		
		return new UserRole(rolesEntity.getRoleId(),rolesEntity.getRoleName());
	}

}