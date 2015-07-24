package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mk.portal.framework.dao.HibernateUtil;
import com.mk.portal.framework.dao.PageFileMappingDao;
import com.mk.portal.framework.entity.ExternalFilePathEntity;
import com.mk.portal.framework.entity.PageFileMappingEntity;
import com.mk.portal.framework.model.PageFileMapping;

public class PageFileMappingDaoImpl implements PageFileMappingDao {


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

	public SessionFactory getSessionFactory() {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		if(sf==null){
			sf=HibernateUtil.createSessionFactory();
		}
		return sf;
	}

	

	private ExternalFilePathEntity getFileById(String fileId) {
		List<ExternalFilePathEntity> list = findFileById(
				"from ExternalFilePathEntity where id=? ", fileId);
		if (list.size() == 1) {
			return list.get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<PageFileMapping> findFilesForSiteAndPage(String siteId,
			String pageId) {
		List<PageFileMappingEntity> fileList = findByQuery(
				"from PageFileMappingEntity where siteId=? and (pageId=? OR pageId='ALL')",
				siteId, pageId);
		return convertCSSMappingEntityToCSSMapping(fileList);
	}

	@SuppressWarnings({ "unchecked" })
	private List<PageFileMappingEntity> findByQuery(String query,
			String siteId, String pageId) {
		List<PageFileMappingEntity> css = new ArrayList<PageFileMappingEntity>();
		Session session = getSessionFactory().openSession();
		try {
			css = session.createQuery(query).setParameter(0, siteId)
					.setParameter(1, pageId).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return css;
	}

	@SuppressWarnings({ "unchecked" })
	private List<ExternalFilePathEntity> findFileById(String query,
			String fileId) {
		List<ExternalFilePathEntity> css = new ArrayList<ExternalFilePathEntity>();
		Session session = getSessionFactory().openSession();
		try {
			css = session.createQuery(query).setParameter(0, fileId).list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return css;
	}

}
