package com.mk.portal.framework.service.impl;

import org.springframework.security.core.userdetails.UserDetails;

import com.mk.portal.framework.service.PortalVO;


public class PortalUserDetailsVO implements PortalVO {
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public UserDetails getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}
	private String username;
	private UserDetails userDetails;
}
