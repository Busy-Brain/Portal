package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.PageDao;
import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.entity.PageEntity;
import com.mk.portal.framework.model.PortalPage;

public class PageDaoImpl implements PageDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private RolesDao rolesDao;

	private PortalPage convertPortalPageEntityToPage(PageEntity pageEntity) {
		PortalPage page = new PortalPage();
		page.setEnabled(pageEntity.isEnabled());
		page.setPageId(pageEntity.getPageId());
		page.setTitle(pageEntity.getPageTitle());
		page.setUrl(pageEntity.getPageUrl());
		page.getPageIdentifier().setSiteUrl(pageEntity.getSiteId());
		page.setPageId(pageEntity.getPageId());
		return page;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public PortalPage findByPageId(String pageId) {
		return findByQuery("from PageEntity where pageId=?", pageId);
	}

	@Override
	public PortalPage findByPageUrl(String pageUrl) {
		return findByQuery("from PageEntity where pageUrl=?", pageUrl);
	}

	@SuppressWarnings({ "unchecked" })
	private PortalPage findByQuery(String query, String field) {
		List<PageEntity> pages = new ArrayList<PageEntity>();
		Session session = getSessionFactory().openSession();
		PortalPage page = null;
		try {
			pages = session.createQuery(query).setParameter(0, field).list();

			if ((pages.size() == 1)
					&& (((PageEntity) pages.get(0)).getSiteId()
							.equalsIgnoreCase(field))) {

				page = convertPortalPageEntityToPage(pages.get(0));
			} else {
				page = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return page;
	}

}