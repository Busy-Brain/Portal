package com.mk.portal.framework.site;

import java.util.List;

public class PortalSite {
private String siteId;
private String siteTitle;
private List<Topic> siteTopics;
public String getSiteId() {
	return siteId;
}
public void setSiteId(String siteId) {
	this.siteId = siteId;
}
public List<Topic> getSiteTopics() {
	return siteTopics;
}
public void setSiteTopics(List<Topic> siteTopics) {
	this.siteTopics = siteTopics;
}
public String getSiteTitle() {
	return siteTitle;
}
public void setSiteTitle(String siteTitle) {
	this.siteTitle = siteTitle;
}
}
