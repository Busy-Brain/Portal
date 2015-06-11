package com.mk.portal.framework.service;

import com.mk.portal.framework.model.PortalUser;

public class NavigationServiceVO implements PortalVO {
private String navigationId;
private PortalUser user;
public String getNavigationId() {
	return navigationId;
}
public void setNavigationId(String navigationId) {
	this.navigationId = navigationId;
}
public PortalUser getUser() {
	return user;
}
public void setUser(PortalUser user) {
	this.user = user;
}
}
