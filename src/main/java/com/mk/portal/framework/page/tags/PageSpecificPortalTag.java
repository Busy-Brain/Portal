package com.mk.portal.framework.page.tags;

public abstract class PageSpecificPortalTag extends PortalTag {
	protected String pageId;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
}
