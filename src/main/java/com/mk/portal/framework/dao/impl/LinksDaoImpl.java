package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mk.portal.framework.dao.HibernateUtil;
import com.mk.portal.framework.dao.LinksDao;
import com.mk.portal.framework.entity.LinkEntity;
import com.mk.portal.framework.model.PortalLink;

public class LinksDaoImpl implements LinksDao {

	public SessionFactory getSessionFactory() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		if(sf==null){
			sf=HibernateUtil.createSessionFactory();
		}
		return sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PortalLink> findTopLevelLinksForSite(String siteId) {

		List<LinkEntity> links = new ArrayList<LinkEntity>();
		Session session = getSessionFactory().openSession();
	
		links = session.createQuery("from LinkEntity where siteId=? and parentId=?").setParameter(0, siteId).setParameter(1, "0").list();
		
		session.close();
		
		return convertToPortalLinks(links);
	}

	private List<PortalLink> convertToPortalLinks(
			List<LinkEntity> links) {
		List<PortalLink> widgets = new ArrayList<PortalLink>();
		for(LinkEntity w:links){
			PortalLink pl= new PortalLink();
			
			pl.setAlt(w.getAlt());
			pl.setId(w.getId());
			pl.setParentId(w.getParentId());
			pl.setSiteId(w.getSiteId());
			pl.setText(w.getText());
			pl.setUrl(w.getUrl());
			pl.setVisible(w.isIsVisible());
			widgets.add(pl);
		}
		return widgets;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PortalLink> getChildLinksForParentLink(String parentLinkId) {

		List<LinkEntity> links = new ArrayList<LinkEntity>();
		Session session = getSessionFactory().openSession();
	
		links = session.createQuery("from LinkEntity where  parentId=?").setParameter(0, parentLinkId).list();
		
		session.close();
		
		return convertToPortalLinks(links);
	}

	

}
