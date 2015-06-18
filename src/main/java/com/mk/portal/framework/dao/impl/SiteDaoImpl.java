package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.dao.SiteDao;
import com.mk.portal.framework.entity.SiteEntity;
import com.mk.portal.framework.model.PortalSite;

public class SiteDaoImpl implements SiteDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private RolesDao rolesDao;

	private PortalSite convertSiteEntityToSite(SiteEntity siteEntity) {
		PortalSite site = new PortalSite();
		site.setSiteId(siteEntity.getSiteId());
		site.setSiteName(siteEntity.getSiteName());
		site.setSiteTitle(siteEntity.getSiteTitle());
		return site;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings({ "unchecked"})
	public PortalSite findBySiteId(String siteId) {

		List<SiteEntity> sites = new ArrayList<SiteEntity>();
		Session session = getSessionFactory().openSession();
		PortalSite site = null;
		try{
			sites = session.createQuery("from SiteEntity where siteId=?")
				.setParameter(0, siteId).list();
		
		
		if ((sites.size() ==1)&&(((SiteEntity)sites.get(0)).getSiteId().equalsIgnoreCase(siteId))) {
			
			site= convertSiteEntityToSite(sites.get(0));
		} else {
			site= null;
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		finally{
			session.close();
		}
return site;
	}

}