package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.HibernateUtil;
import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.dao.SiteDao;
import com.mk.portal.framework.entity.SiteEntity;
import com.mk.portal.framework.model.PortalSite;

public class SiteDaoImpl implements SiteDao {
	
	@Autowired
	private RolesDao rolesDao;

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

	public SessionFactory getSessionFactory() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		if(sf==null){
			sf=HibernateUtil.createSessionFactory();
		}
		return sf;
	}

	
	
	@SuppressWarnings({ "unchecked" })
	public PortalSite findBySiteUrl(String siteUrl) {
		List<SiteEntity> sites = new ArrayList<SiteEntity>();
		Session session = getSessionFactory().openSession();
		PortalSite site = null;
		try {
			sites = session.createQuery("from SiteEntity where siteUrl=?").setParameter(0, siteUrl).list();

			if ((sites.size() == 1)
					&& (((SiteEntity) sites.get(0)).getSiteUrl()
							.equalsIgnoreCase(siteUrl))) {

				site = convertSiteEntityToSite(sites.get(0));
			} else {
				site = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return site;
	}
	@SuppressWarnings({ "unchecked" })
	public PortalSite findBySiteId(String siteId) {
		List<SiteEntity> sites = new ArrayList<SiteEntity>();
		Session session = getSessionFactory().openSession();
		PortalSite site = null;
		try {
			sites = session.createQuery("from SiteEntity where siteId=?").setParameter(0, siteId).list();

			if ((sites.size() == 1)
					&& (((SiteEntity) sites.get(0)).getSiteId()
							.equalsIgnoreCase(siteId))) {

				site = convertSiteEntityToSite(sites.get(0));
			} else {
				site = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return site;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PortalSite> fetchAllSites() {
		List<SiteEntity> sites = new ArrayList<SiteEntity>();
		Session session = getSessionFactory().openSession();
		try {
			sites = session.createQuery("from SiteEntity ").list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		List<PortalSite> filSites=new ArrayList<PortalSite>();
		for(SiteEntity se :sites){
			filSites.add(convertSiteEntityToSite(se));
		}
		return filSites;
	}

}