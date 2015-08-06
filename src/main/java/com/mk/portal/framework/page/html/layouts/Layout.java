package com.mk.portal.framework.page.html.layouts;

import java.util.List;

import com.mk.portal.framework.html.objects.AbstractTagComponent;
import com.mk.portal.framework.html.objects.PageComponent;

public abstract class Layout extends AbstractTagComponent{
	public abstract int getAreaCount();
	public abstract boolean setComponentInArea(PageComponent component,String area);
	public abstract List<PageComponent> getComponentsFromArea(String area);
}
