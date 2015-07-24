package com.mk.portal.framework.page.html.components;

import java.util.List;

import com.mk.portal.framework.html.objects.FormattingUtil;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.html.objects.TagComponent;
import com.mk.portal.framework.model.PortalPage;

public abstract class AbstractComponentList implements PageComponent{
	private PortalPage page;
	@Override
	public PortalPage getPage() {
		return page;
	}
	@Override
	public void setPage(PortalPage page) {
		this.page = page;
	}
	protected abstract List<PageComponent> getComponentList();
	@Override
	public PageComponent clone() {
		try {
			return (TagComponent) super.clone();
		} catch (CloneNotSupportedException e) {
			// can never happen
			throw new AssertionError();
		}
	}
	
	@Override
	public boolean hasChildren() {
		return !((getChildren() == null) || (getChildren().size() == 0));
	}
	
	@Override
	public List<PageComponent> getChildren() {
		
		return getComponentList();
	}

	@Override
	public void addChild(PageComponent child) {
		getComponentList().add(child);

	}
	
	@Override
	public String toFormattedString(int tabCount) {
		StringBuffer tag = new StringBuffer();
		for(PageComponent childTag:getComponentList()){
			tag.append(FormattingUtil.getFormattingTabs(tabCount) + childTag.toFormattedString(tabCount)+"\n");
		}
		return tag.toString();
	}
	@Override
	public String toString() {
		StringBuffer tag = new StringBuffer();
		for(PageComponent childTag:getComponentList()){
			tag.append( childTag.toString());
		}
		return tag.toString();
	}
}
