package com.mk.portal.framework.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.dao.LinksDao;
import com.mk.portal.framework.entity.LinkEntity;
import com.mk.portal.framework.model.PortalLink;

public class LinksDaoImpl implements LinksDao {


	@Override
	public List<PortalLink> findTopLevelLinksForSite(String siteId) {

		List<LinkEntity> links = new ArrayList<LinkEntity>();
		String query = "from LinkEntity where siteId=? and parentId=?";
		List<String> listOfParams = new ArrayList<String>();
		listOfParams.add(siteId);
		listOfParams.add("0");
		links = new QueryDao<LinkEntity>().findListByQuery(query, listOfParams);

		return convertToPortalLinks(links);
	}

	private List<PortalLink> convertToPortalLinks(List<LinkEntity> links) {
		List<PortalLink> widgets = new ArrayList<PortalLink>();
		for (LinkEntity w : links) {
			PortalLink pl = new PortalLink();

			pl.setAlt(w.getAlt());
			pl.setId(w.getId());
			pl.setParentId(w.getParentId());
			pl.setSiteId(w.getSiteId());
			pl.setText(w.getText());
			pl.setUrl(w.getUrl());
			pl.setVisible(w.isIsVisible());
			widgets.add(pl);
		}
		return widgets;
	}

	@Override
	public List<PortalLink> getChildLinksForParentLink(String parentLinkId) {

		List<LinkEntity> links = new ArrayList<LinkEntity>();
		String query = "from LinkEntity where  parentId=?";
		List<String> listOfParams = new ArrayList<String>();
		listOfParams.add(parentLinkId);
		links = new QueryDao<LinkEntity>().findListByQuery(query, listOfParams);
		return convertToPortalLinks(links);
	}

}
