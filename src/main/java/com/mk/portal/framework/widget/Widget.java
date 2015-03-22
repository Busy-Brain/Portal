package com.mk.portal.framework.widget;

import com.mk.portal.framework.page.content.HTMLContent;
import com.mk.portal.framework.service.PortalVO;

public interface Widget extends Cloneable{
	public String getName();
	public HTMLContent getScreenContent();
	public HTMLContent getBackEndServiceName();
	public void setUp(PortalVO setupVO);
	public Widget clone();
}
