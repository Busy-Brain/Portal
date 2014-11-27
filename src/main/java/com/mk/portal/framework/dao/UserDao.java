package com.mk.portal.framework.dao;

import com.mk.portal.framework.model.User;
/**
 * UserDAO has database related operations for Portal User
 * @author mohit
 *
 */
public interface UserDao {

	User findByUserName(String username);

}