package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.dao.PageFileMappingDao;
import com.mk.portal.framework.entity.ExternalFilePathEntity;
import com.mk.portal.framework.entity.PageFileMappingEntity;
import com.mk.portal.framework.model.PageFileMapping;

public class PageFileMappingDaoImpl implements PageFileMappingDao {

	
	private QueryDao<PageFileMappingEntity> queryDao = new QueryDao<PageFileMappingEntity>();

	private List<PageFileMapping> convertCSSMappingEntityToCSSMapping(
			List<PageFileMappingEntity> files) {
		List<PageFileMapping> filesList = new ArrayList<PageFileMapping>();
		for (PageFileMappingEntity fileEntity : files) {
			PageFileMapping mapping = new PageFileMapping();
			mapping.setFileId(fileEntity.getFileId());
			ExternalFilePathEntity eFile = getFileById(fileEntity.getFileId());
			mapping.setFileType(eFile.getFileType());
			mapping.setFilePath(eFile.getFilePath());
			mapping.setId(fileEntity.getId());
			mapping.setPageId(fileEntity.getPageId());
			mapping.setSiteId(fileEntity.getSiteId());
			filesList.add(mapping);
		}
		return filesList;
	}

	
	

	private ExternalFilePathEntity getFileById(String fileId) {
		
		List<String> listOfParams=new ArrayList<String>();
		listOfParams.add(fileId);
		 QueryDao<ExternalFilePathEntity> efpqueryDao = new QueryDao<ExternalFilePathEntity>();
		List<ExternalFilePathEntity>list=efpqueryDao.findListByQuery("from ExternalFilePathEntity where id=? ", listOfParams);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<PageFileMapping> findFilesForSiteAndPage(String siteId,
			String pageId) {
		List<String> listOfParams=new ArrayList<String>();
		listOfParams.add(siteId);
		listOfParams.add(pageId);
		List<PageFileMappingEntity> fileList = queryDao.findListByQuery(
				"from PageFileMappingEntity where siteId=? and (pageId=? OR pageId='ALL')",
				listOfParams);
		return convertCSSMappingEntityToCSSMapping(fileList);
	}

	

}
