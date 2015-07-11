package com.mk.portal.framework.page.html.layouts;

import java.util.List;

import com.mk.portal.framework.html.objects.AbstractComponent;
import com.mk.portal.framework.html.objects.PageComponent;

public abstract class Layout extends AbstractComponent{
	public abstract int getAreaCount();
	public abstract boolean setComponentInArea(PageComponent component,int area);
	public abstract List<PageComponent> getComponentsFromArea(int area);
}
