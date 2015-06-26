package com.mk.portal.framework.site;

import java.util.List;

import com.mk.portal.framework.model.PortalPage;

public class Topic {
private String topicId;
private List<PortalPage> pages;
public String getTopicId() {
	return topicId;
}
public void setTopicId(String topicId) {
	this.topicId = topicId;
}
public List<PortalPage> getPages() {
	return pages;
}
public void setPages(List<PortalPage> pages) {
	this.pages = pages;
}
}
