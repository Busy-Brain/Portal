package com.mk.portal.framework.model;

public class UserRole {
	private Integer roleId;
	private String roleName;
	public UserRole(Integer roleId,String roleName) {
		this.roleId=roleId;
		this.roleName=roleName;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	
	
}
