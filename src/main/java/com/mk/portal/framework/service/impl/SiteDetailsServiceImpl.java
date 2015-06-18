package com.mk.portal.framework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.configuration.JSONConfigurationReader;
import com.mk.portal.framework.dao.SiteDao;
import com.mk.portal.framework.model.PortalSite;
import com.mk.portal.framework.service.SiteDetailsService;

public class SiteDetailsServiceImpl extends SiteDetailsService {

	@Autowired
	private SiteDao siteDao;
	public SiteDao getSiteDao() {
		return siteDao;
	}
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao = siteDao;
	}
	@Override
	public PortalSite getSiteById(String siteId) {
		PortalSite site=siteDao.findBySiteId(siteId);
		if(site==null){
			site=findInConfiguration(siteId);
		}
		return site;
	}
	private PortalSite findInConfiguration(String siteId) {
		JSONConfigurationReader reader = new JSONConfigurationReader();
		return null;
	}

}
