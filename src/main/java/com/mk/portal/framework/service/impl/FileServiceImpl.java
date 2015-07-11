package com.mk.portal.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.PageFileMappingDao;
import com.mk.portal.framework.model.PageFileMapping;
import com.mk.portal.framework.service.FileService;

public class FileServiceImpl implements FileService {

	@Autowired
	private PageFileMappingDao pageFileMappingDao;
	
	public PageFileMappingDao getPageFileMappingDao() {
		return pageFileMappingDao;
	}

	public void setPageFileMappingDao(PageFileMappingDao pageFileMappingDao) {
		this.pageFileMappingDao = pageFileMappingDao;
	}

	@Override
	public List<PageFileMapping> findFilesForSiteAndPage(String siteId, String pageId) {
		return pageFileMappingDao.findFilesForSiteAndPage(siteId, pageId);
	}

}