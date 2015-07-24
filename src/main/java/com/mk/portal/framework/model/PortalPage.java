package com.mk.portal.framework.model;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.page.PageIdentifier;
import com.mk.portal.framework.page.container.Container;
import com.mk.portal.framework.page.tags.MetaTagObject;

public class PortalPage {
	private String pageId;
	private PageIdentifier pageIdentifier;
	private String title;
	private List<MetaTagObject> metaTags;
	private List<Container> containersList;
	private boolean enabled;
	private String url;
	private String pageLinkId;
	public PageIdentifier getPageIdentifier() {
		return pageIdentifier;
	}
	
	public void setPageIdentifier(PageIdentifier pageIdentifier) {
		this.pageIdentifier = pageIdentifier;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public PortalPage(PageIdentifier pageIdentifier, String title,
			List<MetaTagObject> metaTags, List<Container> containersList) {
		super();
		this.pageIdentifier = pageIdentifier;
		this.title = title;
		this.metaTags = metaTags;
		this.containersList = containersList;
	}

	public PortalPage(PageIdentifier pageIdentifier) {
		super();
		this.pageIdentifier = pageIdentifier;
	}

	public PortalPage() {

	}

	public String getPageId() {
		return this.pageId;
	}

	public void setPageId(String pageId) {
		this.pageId=pageId;
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
		if (containersList == null) {
			containersList = new ArrayList<Container>();
		}
		containersList.add(container);
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public String getPageLinkId() {
		return pageLinkId;
	}

	public void setPageLinkId(String pageLinkId) {
		this.pageLinkId = pageLinkId;
	}
}
