package com.mk.portal.framework.page;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.page.container.Container;
import com.mk.portal.framework.page.tags.MetaTagObject;

public class PortalPage {
private String pageId;
private String title;
private List<MetaTagObject> metaTags;
private List<Container> containersList;
public String getPageId() {
	return pageId;
}
public void setPageId(String pageId) {
	this.pageId = pageId;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public List<MetaTagObject> getMetaTags() {
	return metaTags;
}
public void setMetaTags(List<MetaTagObject> metaTags2) {
	this.metaTags = metaTags2;
}
public List<Container> getContainersList() {
	return containersList;
}
public void setContainersList(List<Container> containersList) {
	this.containersList = containersList;
}
public void addContainer(Container container) {
	if(containersList==null){
		containersList=new ArrayList<Container>();
	}
	containersList.add(container);
}


}
