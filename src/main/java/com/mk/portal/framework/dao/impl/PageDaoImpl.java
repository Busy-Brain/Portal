package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.mk.portal.framework.dao.PageDao;
import com.mk.portal.framework.dao.RolesDao;
import com.mk.portal.framework.entity.PageEntity;
import com.mk.portal.framework.exceptions.PotentialBugException;
import com.mk.portal.framework.model.PortalPage;
import com.mk.portal.framework.service.SiteDetailsService;

public class PageDaoImpl implements PageDao {
	@Autowired
	private RolesDao rolesDao;
	@Autowired
	private SiteDetailsService siteDetailsService;
	
	private QueryDao<PageEntity> queryDao= new QueryDao<PageEntity>();
	private PortalPage convertPortalPageEntityToPage(PageEntity pageEntity) {
		PortalPage page = new PortalPage();
		page.setEnabled(pageEntity.isEnabled());
		page.setPageId(pageEntity.getPageId());
		page.setTitle(pageEntity.getPageTitle());
		page.setPageId(pageEntity.getPageId());
		page.setPageLinkId(pageEntity.getPageLinkId());
		page.setSiteId(pageEntity.getSiteId());
		return page;
	}

	

	@Override
	public PortalPage findByPageId(String pageId) {
		List<String> listOfParams=new ArrayList<String>();
		listOfParams.add(pageId);
		List<PageEntity> pages = queryDao.findListByQuery("from PageEntity where pageId=?", listOfParams);
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
	public PortalPage findByPageUrl(String pageUrl) {
		List<String> listOfParams=new ArrayList<String>();
		if(pageUrl.charAt(pageUrl.length()-1)=='/'){
			pageUrl=pageUrl.substring(0, pageUrl.length()-2);
		}
		listOfParams.add(pageUrl);
		List<PageEntity> pages = queryDao.findListByQuery("from PageEntity where pageLinkId = (select id from LinkEntity where url = ?)", listOfParams);
		PortalPage page =null;
		if(pages.size()>1){
			throw new PotentialBugException("INVALID_DATA", "Data setup issue");
		}
		else if(pages.size()==1){
			page=convertPortalPageEntityToPage(pages.get(0));
		}
		
		return page;
	}

	

}