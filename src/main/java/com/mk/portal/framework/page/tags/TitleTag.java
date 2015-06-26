package com.mk.portal.framework.page.tags;

import com.mk.portal.framework.model.PortalPage;
import com.mk.portal.framework.page.PageFactory;
import com.mk.portal.framework.page.PageFactoryImpl;

public class TitleTag extends PageSpecificPortalTag {

	@Override
	protected String getTagHTML() {
		PageFactory factory = new PageFactoryImpl();
		PortalPage page=factory.getPage(getPageIdentifier());
		return "<title>"+page.getTitle()+"</title>";
	}

}
