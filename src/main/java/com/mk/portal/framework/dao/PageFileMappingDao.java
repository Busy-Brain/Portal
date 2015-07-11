package com.mk.portal.framework.dao;

import java.util.List;

import com.mk.portal.framework.model.PageFileMapping;


public interface PageFileMappingDao {

	List<PageFileMapping> findFilesForSiteAndPage(String siteId, String pageId);
	
}
