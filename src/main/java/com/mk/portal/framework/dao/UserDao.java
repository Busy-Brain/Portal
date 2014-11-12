package com.mk.portal.framework.dao;

import com.mk.portal.framework.model.User;

public interface UserDao {

	User findByUserName(String username);

}