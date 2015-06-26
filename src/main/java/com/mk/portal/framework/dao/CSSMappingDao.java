package com.mk.portal.framework.dao;

import java.util.List;

import com.mk.portal.framework.model.CSSMapping;


public interface CSSMappingDao {

	List<CSSMapping> findCSSForSiteAndPage(String siteId, String pageId);
	
}
