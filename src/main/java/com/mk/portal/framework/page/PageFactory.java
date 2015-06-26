package com.mk.portal.framework.page;

import com.mk.portal.framework.model.PortalPage;

public interface PageFactory {
	PortalPage getPage(PageIdentifier pageIdentifier);
}
