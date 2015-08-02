package com.mk.portal.framework.dao;

import java.util.List;

import com.mk.portal.framework.model.PortalSite;
/**
 * UserDAO has database related operations for Portal User
 * @author mohit
 *
 */
public interface SiteDao {

	PortalSite findBySiteId(String siteId);
	
	PortalSite findBySiteUrl(String siteUrl);

	List<PortalSite> fetchAllSites();

}