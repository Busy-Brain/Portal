package com.mk.portal.framework.service;

import com.mk.portal.framework.model.PortalSite;

public interface SiteDetailsService {

	PortalSite getSiteById(String siteId);

	PortalSite getSiteByUrl(String siteUrl);
}
