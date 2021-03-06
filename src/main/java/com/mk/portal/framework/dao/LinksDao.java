package com.mk.portal.framework.dao;

import java.util.List;

import com.mk.portal.framework.model.PortalLink;

/**
 * Links Dao. CRUD Operations for Links table
 * @author mohit
 *
 */
public interface LinksDao {

	List<PortalLink> findTopLevelLinksForSite(String siteId);

	List<PortalLink>  getChildLinksForParentLink(String parentLinkId);

}
