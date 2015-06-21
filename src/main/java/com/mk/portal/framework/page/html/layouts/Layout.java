package com.mk.portal.framework.page.html.layouts;

import com.mk.portal.framework.html.objects.PageComponent;

public interface Layout extends PageComponent{
	

	public String getEmptyHTMLAsString();

	public String getHTMLWithRenderedWidgetsAsString();
}
