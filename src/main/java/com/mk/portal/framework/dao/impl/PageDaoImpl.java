package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.PageDao;
import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.entity.PageEntity;
import com.mk.portal.framework.exceptions.PotentialBugException;
import com.mk.portal.framework.model.PortalPage;
import com.mk.portal.framework.page.PageIdentifier;
import com.mk.portal.framework.service.SiteDetailsService;

public class PageDaoImpl implements PageDao {
	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private RolesDao rolesDao;
	@Autowired
	private SiteDetailsService siteDetailsService;
	private PortalPage convertPortalPageEntityToPage(PageEntity pageEntity) {
		PortalPage page = new PortalPage();
		page.setEnabled(pageEntity.isEnabled());
		page.setPageId(pageEntity.getPageId());
		page.setTitle(pageEntity.getPageTitle());
		page.setUrl(pageEntity.getPageUrl());
		PageIdentifier pageIdentifier = new PageIdentifier(siteDetailsService.getSiteById(pageEntity.getSiteId()).getSiteUrl(), null, null, pageEntity.getPageUrl());
		page.setPageIdentifier(pageIdentifier );
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
		List<String> listOfParams=new ArrayList<String>();
		listOfParams.add(pageId);
		List<PageEntity> pages = findByQuery("from PageEntity where pageId=?", listOfParams);
		if(pages.size()>1){
			//throw new setup exception
		}
		PortalPage page = convertPortalPageEntityToPage(pages.get(0));
		if(page.getPageId().equals(pageId)){
			return page;
		}
		return new PortalPage();
	}

	@Override
	public PortalPage findBySiteId_PageUrl(String siteId,String pageUrl) {
		List<String> listOfParams=new ArrayList<String>();
		listOfParams.add(siteId);
		listOfParams.add(pageUrl);
		List<PageEntity> pages = findByQuery("from PageEntity where siteId = ? and pageUrl = ?", listOfParams);
		PortalPage page =null;
		if(pages.size()>1){
			throw new PotentialBugException("INVALID_DATA", "Data setup issue");
		}
		else if(pages.size()==1){
			page=convertPortalPageEntityToPage(pages.get(0));
		}
		
		return page;
	}

	@SuppressWarnings({ "unchecked" })
	private List<PageEntity> findByQuery(String query, List<String> listOfParams) {
		List<PageEntity> pages = new ArrayList<PageEntity>();
		Session session = getSessionFactory().openSession();
		try {
			
			Query queryObject = session.createQuery(query);
			for(int i=0;i<listOfParams.size();i++){
				queryObject.setParameter(i, listOfParams.get(i));
			}
			pages = queryObject.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return pages;
	}

}