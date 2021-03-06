package com.mk.portal.framework.dao;

import com.mk.portal.framework.model.PortalUser;
/**
 * UserDAO has database related operations for Portal User
 * @author mohit
 *
 */
public interface UserDao {

	PortalUser findByUserName(String username);

}