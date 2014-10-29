package com.mk.portal.framework.page.tags;

public class TitleTag extends PortalTag {

	@Override
	protected String prepareTagStatement() {
		
		return "<title>This is the title of the page</title>";
	}

}
