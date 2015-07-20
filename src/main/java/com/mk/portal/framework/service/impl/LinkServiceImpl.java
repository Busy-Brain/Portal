package com.mk.portal.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.portal.framework.dao.LinksDao;
import com.mk.portal.framework.dao.PageFileMappingDao;
import com.mk.portal.framework.model.PageFileMapping;
import com.mk.portal.framework.model.PortalLink;
import com.mk.portal.framework.service.FileService;
import com.mk.portal.framework.service.LinksService;
@Service
public class LinkServiceImpl implements LinksService {

	@Autowired
	private LinksDao linksDao;
	
	public LinksDao getLinksDao() {
		return linksDao;
	}

	public void setLinksDao(LinksDao linksDao) {
		this.linksDao = linksDao;
	}

	@Override
	public List<PortalLink> findTopLevelLinksForSite(String siteId) {
		return linksDao.findTopLevelLinksForSite(siteId);
	}

}