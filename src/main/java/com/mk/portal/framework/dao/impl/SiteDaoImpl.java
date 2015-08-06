package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.dao.SiteDao;
import com.mk.portal.framework.entity.SiteEntity;
import com.mk.portal.framework.model.PortalSite;

public class SiteDaoImpl implements SiteDao {

	@Autowired
	private RolesDao rolesDao;

	private QueryDao<SiteEntity> queryDao = new QueryDao<SiteEntity>();

	private PortalSite convertSiteEntityToSite(SiteEntity siteEntity) {
		PortalSite site = new PortalSite();
		site.setSiteId(siteEntity.getSiteId());
		site.setSiteName(siteEntity.getSiteName());
		site.setSiteTitle(siteEntity.getSiteTitle());
		site.setHTMLVersion(siteEntity.getHTMLVersion());
		site.setSiteUrl(siteEntity.getSiteUrl());
		site.setCharSet(siteEntity.getCharSet());
		return site;
	}

	public PortalSite findBySiteUrl(String siteUrl) {
		List<SiteEntity> sites = new ArrayList<SiteEntity>();
		PortalSite site = null;
		
			List<String> params= new ArrayList<String>();
			params.add(siteUrl);
			sites = queryDao.findListByQuery("from SiteEntity where siteUrl=?",params);

			if ((sites.size() == 1)
					&& (((SiteEntity) sites.get(0)).getSiteUrl()
							.equalsIgnoreCase(siteUrl))) {

				site = convertSiteEntityToSite(sites.get(0));
			} else {
				site = null;
			}
		
		return site;
	}

	public PortalSite findBySiteId(String siteId) {
		List<SiteEntity> sites = new ArrayList<SiteEntity>();
		PortalSite site = null;
		List<String> params= new ArrayList<String>();
		params.add(siteId);
		sites = queryDao.findListByQuery("from SiteEntity where siteId=?",params);
			

			if ((sites.size() == 1)
					&& (((SiteEntity) sites.get(0)).getSiteId()
							.equalsIgnoreCase(siteId))) {

				site = convertSiteEntityToSite(sites.get(0));
			} else {
				site = null;
			}
		
		return site;
	}

	@Override
	public List<PortalSite> fetchAllSites() {
		List<SiteEntity> sites = new ArrayList<SiteEntity>();
		
			List<String> params= new ArrayList<String>();
			sites = queryDao.findListByQuery("from SiteEntity ",params);
		
		List<PortalSite> filSites = new ArrayList<PortalSite>();
		for (SiteEntity se : sites) {
			filSites.add(convertSiteEntityToSite(se));
		}
		return filSites;
	}

}