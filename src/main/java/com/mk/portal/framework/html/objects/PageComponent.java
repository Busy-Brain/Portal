package com.mk.portal.framework.html.objects;

import java.util.List;

import com.mk.portal.framework.model.PortalPage;

public interface PageComponent extends Cloneable {
	public PageComponent clone();
	public String toString();
	public boolean hasChildren();
	public List<PageComponent> getChildren();
	public String toFormattedString(int tabcount);
	void addChild(PageComponent child);
	public void setPage(PortalPage page);
	public PortalPage getPage();
}
