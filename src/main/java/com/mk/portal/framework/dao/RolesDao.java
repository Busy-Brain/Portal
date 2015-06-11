package com.mk.portal.framework.dao;

import com.mk.portal.framework.model.UserRole;
/**
 * UserDAO has database related operations for Portal User
 * @author mohit
 *
 */
public interface RolesDao {

	UserRole findByRoleId(int roleId);

}