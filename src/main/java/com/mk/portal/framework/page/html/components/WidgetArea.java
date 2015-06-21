package com.mk.portal.framework.page.html.components;

import java.util.List;

import com.mk.portal.framework.html.objects.PageComponent;

public interface WidgetArea extends PageComponent{
	public String getId();

	public List<PageComponent> getChildren();
	
	public void addChild(PageComponent child);
	
}
