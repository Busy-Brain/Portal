package com.mk.portal.framework.service;

import java.util.List;

import com.mk.portal.framework.model.PageFileMapping;

public interface FileService {

	List<PageFileMapping> findFilesForSiteAndPage(String siteId, String pageId);

}
