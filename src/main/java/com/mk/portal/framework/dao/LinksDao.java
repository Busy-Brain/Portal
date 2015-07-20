package com.mk.portal.framework.dao;

import java.util.List;

import com.mk.portal.framework.model.PortalLink;


public interface LinksDao {

	List<PortalLink> findTopLevelLinksForSite(String siteId);

}
