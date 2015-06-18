package com.mk.portal.framework.page;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.page.container.Container;
import com.mk.portal.framework.page.container.DefaultContainer;
import com.mk.portal.framework.page.content.HTMLContent;
import com.mk.portal.framework.page.tags.MetaTagObject;

public class PageFactoryImpl implements PageFactory {

	public PortalPage getPage(PageIdentifier pageIdentifier) {
		PortalPage page = getPageFromDB(pageIdentifier);
		if (page == null) {
			page = getPageFromConfiguration(pageIdentifier);
		}
		if (page == null) {
			page = getDefaultPage(pageIdentifier);
		}
		return page;
	}

	private PortalPage getDefaultPage(PageIdentifier pageIdentifier) {
		PortalPage page = new PortalPage(pageIdentifier);
		
		Container container = new DefaultContainer(new HTMLContent(
				"This is default page!"));
		page.addContainer(container);
		page.setTitle("Default Page");
		List<MetaTagObject> metaTags = new ArrayList<MetaTagObject>();
		metaTags.add(new MetaTagObject("description", "text"));
		page.setMetaTags(metaTags);
		return page;
	}

	private PortalPage getPageFromDB(PageIdentifier pageIdentifier) {
		
		return null;
	}

	private PortalPage getPageFromConfiguration(PageIdentifier pageIdentifier) {
		return new JsonPageLoader().getPage(pageIdentifier);
	}

}
