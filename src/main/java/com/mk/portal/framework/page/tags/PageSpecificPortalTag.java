package com.mk.portal.framework.page.tags;

import com.mk.portal.framework.page.PageIdentifier;

public abstract class PageSpecificPortalTag extends PortalTag {
	protected PageIdentifier pageIdentifier;

	public PageIdentifier getPageIdentifier() {
		return pageIdentifier;
	}

	public void setPageIdentifier(PageIdentifier pageIdentifier) {
		this.pageIdentifier = pageIdentifier;
	}
}
