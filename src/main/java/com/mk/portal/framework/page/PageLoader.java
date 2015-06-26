package com.mk.portal.framework.page;

import com.mk.portal.framework.model.PortalPage;

public interface PageLoader {
 PortalPage getPage(PageIdentifier pageIdentifier);
}
