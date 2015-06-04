package com.mk.portal.framework.service;

import com.mk.portal.framework.model.User;

public class NavigationServiceVO implements PortalVO {
private String navigationId;
private User user;
public String getNavigationId() {
	return navigationId;
}
public void setNavigationId(String navigationId) {
	this.navigationId = navigationId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
}
