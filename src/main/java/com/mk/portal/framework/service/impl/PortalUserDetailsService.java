package com.mk.portal.framework.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mk.portal.framework.model.PortalUser;
import com.mk.portal.framework.model.UserRole;
import com.mk.portal.framework.service.PortalService;
import com.mk.portal.framework.service.PortalVO;
import com.mk.portal.framework.service.ServiceResponse;
import com.mk.portal.framework.dao.UserDao;

public class PortalUserDetailsService implements UserDetailsService,PortalService {
	@Autowired
	private UserDao userDao;

	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
		PortalUser user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities= null;
		if(user!=null){
			authorities = buildUserAuthority(user.getUserRoles());
		}
		return buildUserForAuthentication(user, authorities);
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(PortalUser user, List<GrantedAuthority> authorities) {
		return new User(user.getUserName(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRole userRole : userRoles) {
			
			setAuths.add(new SimpleGrantedAuthority(getRoleName(userRole.getRoleId())));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

	private String getRoleName(Integer roleId) {
		// TODO get role from roles table
		return null;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ServiceResponse execute(PortalVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public PortalVO getEmptyInputVo() {
		// TODO Auto-generated method stub
		return null;
	}

}