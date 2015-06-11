package com.mk.portal.framework.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.model.UserRole;
import com.mk.portal.framework.service.PortalService;
import com.mk.portal.framework.service.PortalVO;
import com.mk.portal.framework.service.ServiceResponse;

public class RolesDetailsService implements PortalService {
	@Autowired
	private RolesDao rolesDao;

	public UserRole loadRoleByRoleId(final int roleId) throws UsernameNotFoundException {

		UserRole role = rolesDao.findByRoleId(roleId);
		return role;
	}

	public ServiceResponse execute(PortalVO vo) {
		// TODO Auto-generated method stub
		return null;
	}
}