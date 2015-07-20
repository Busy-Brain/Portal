package com.mk.portal.framework.service;

import java.util.List;

import com.mk.portal.framework.model.PortalLink;

public interface LinksService {

	List<PortalLink> findTopLevelLinksForSite(String siteId);

}
