package com.mk.portal.framework.entity;

import java.io.Serializable;

public class UserRolesEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private Integer roleId;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
