package com.mk.portal.framework.page.tags;

import com.mk.portal.framework.model.PortalPage;

public abstract class PageSpecificPortalTag extends PortalTag {
	
	protected PortalPage page;

	public PortalPage getPage() {
		return page;
	}

	public void setPage(PortalPage page) {
		this.page = page;
	}

}
