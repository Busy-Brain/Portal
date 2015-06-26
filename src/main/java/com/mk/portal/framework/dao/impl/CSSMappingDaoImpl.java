package com.mk.portal.framework.dao.impl;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.CSSMappingDao;
import com.mk.portal.framework.entity.CSSMappingEntity;
import com.mk.portal.framework.model.CSSMapping;
public class CSSMappingDaoImpl implements CSSMappingDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	

	private List<CSSMapping> convertCSSMappingEntityToCSSMapping(List<CSSMappingEntity> css) {
		List<CSSMapping> cssList = new ArrayList<CSSMapping>();
		for(CSSMappingEntity cssEntity:css){
			CSSMapping mapping = new CSSMapping();
			mapping.setCssPath(cssEntity.getCssPath());
			mapping.setId(cssEntity.getId());
			mapping.setPageId(cssEntity.getPageId());
			mapping.setSiteId(cssEntity.getSiteId());
		}
		return cssList;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<CSSMapping> findCSSForSiteAndPage(String siteId,String pageId) {
		return findByQuery("from CSSMappingEntity where siteId=? and (pageId=? OR pageId='ALL')", siteId,pageId);
	}


	@SuppressWarnings({ "unchecked" })
	private List<CSSMapping> findByQuery(String query, String siteId,String pageId) {
		List<CSSMappingEntity> css = new ArrayList<CSSMappingEntity>();
		Session session = getSessionFactory().openSession();
		List<CSSMapping>  cssList = null;
		try {
			css = session.createQuery(query).setParameter(0, siteId).setParameter(1, pageId).list();

			

			cssList = convertCSSMappingEntityToCSSMapping(css);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cssList;
	}




}
