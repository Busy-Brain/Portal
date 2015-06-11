package com.mk.portal.framework.entity;

import java.util.HashSet;
import java.util.Set;

public class UserEntity{
	private Integer userId;
	private String username;
	private String password;
	private boolean enabled;
	private Set<UserRolesEntity> userRole = new HashSet<UserRolesEntity>(0);

	public UserEntity() {
	}

	public UserEntity(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public UserEntity(String username, String password, boolean enabled, Set<UserRolesEntity> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRolesEntity> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRolesEntity> userRole) {
		this.userRole = userRole;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
