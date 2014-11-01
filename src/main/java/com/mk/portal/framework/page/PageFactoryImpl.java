package com.mk.portal.framework.page;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.page.container.Container;
import com.mk.portal.framework.page.container.DefaultContainer;
import com.mk.portal.framework.page.content.HTMLContent;
import com.mk.portal.framework.page.tags.MetaTagObject;

public class PageFactoryImpl implements PageFactory {

	@Override
	public PortalPage getPage(String pageId) {
		PortalPage page = getPageFromConfiguration(pageId);
		if (page == null) {
			page = getPageFromDB(pageId);
		}
		if (page == null) {
			page = getDefaultPage(pageId);
		}
		return page;
	}

	private PortalPage getDefaultPage(String pageId) {
		PortalPage page = new PortalPage();
		
		Container container = new DefaultContainer(new HTMLContent(
				"This is default page!"));

		page.addContainer(container);
		
		page.setPageId(pageId);
		page.setTitle("Default Page");
		List<MetaTagObject> metaTags = new ArrayList<MetaTagObject>();
		metaTags.add(new MetaTagObject("description", "text"));
		page.setMetaTags(metaTags);
		return page;
	}

	private PortalPage getPageFromDB(String pageId) {
		// TODO Auto-generated method stub
		return null;
	}

	private PortalPage getPageFromConfiguration(String pageId) {
		return new JsonPageLoader().getPage(pageId);
	}

}
