package com.mk.portal.framework.page.tags;

import com.mk.portal.framework.page.PageFactory;
import com.mk.portal.framework.page.PageFactoryImpl;
import com.mk.portal.framework.page.PortalPage;

public class TitleTag extends PageSpecificPortalTag {

	@Override
	protected String getTagHTML() {
		PageFactory factory = new PageFactoryImpl() ;
		PortalPage page=factory.getPage(getPageId());
		return "<title>"+page.getTitle()+"</title>";
	}

}
