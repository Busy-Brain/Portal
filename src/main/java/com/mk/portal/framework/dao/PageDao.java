package com.mk.portal.framework.dao;

import com.mk.portal.framework.model.PortalPage;

public interface PageDao {

	PortalPage findByPageId(String pageId);

	PortalPage findByPageUrl(String pageUrl);

}
