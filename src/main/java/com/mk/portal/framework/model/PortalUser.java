package com.mk.portal.framework.model;

import java.util.HashSet;
import java.util.Set;

public class PortalUser {
	private int userId;
	private String userName;
	private String password;
	private Set<UserRole> userRoles ;
	private boolean isEnabled;
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public PortalUser(int userId, String userName, String password, boolean isEnabled) {
		this.userId=userId;
		this.userName=userName;
		this.password=password;
		this.isEnabled=isEnabled;
	}

	public static PortalUserBuilder builder() {
		return new PortalUserBuilder();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	public static class PortalUserBuilder {
		private int userId;
		private String userName;
		private String password;
		private boolean isEnabled;
		public PortalUserBuilder userId(int userId){
			this.userId=userId;
			return this;
		}
		public PortalUserBuilder userName(String userName){
			this.userName=userName;
			return this;
		}
		public PortalUser build(){
			return new PortalUser(userId,userName,password,isEnabled);
		}
		public PortalUserBuilder password(String password) {
			this.password=password;
			return this;
		}
		public PortalUserBuilder enabled(boolean enabled) {
			this.isEnabled=enabled;
			return this;
		}

	}
	public Set<UserRole> getUserRoles() {
		if(userRoles==null){
			userRoles= new HashSet<UserRole>(0);
		}
		return userRoles;
	}
	public void addRole(UserRole role) {
		if(userRoles==null){
			userRoles= new HashSet<UserRole>(0);
		}
		userRoles.add(role);
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
}

