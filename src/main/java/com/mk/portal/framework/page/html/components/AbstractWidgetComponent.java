package com.mk.portal.framework.page.html.components;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.model.PortalPage;

public abstract class AbstractWidgetComponent implements PageComponent{

	private PortalPage page;

	private WidgetComponentList widgetComponents;
	@Override
	public PortalPage getPage() {
		return page;
	}
	@Override
	public void setPage(PortalPage pageId) {
		this.page = pageId;
	}
	@Override
	public PageComponent clone() {
		try {
			return (PageComponent) super.clone();
		} catch (CloneNotSupportedException e) {
			// can never happen
			throw new AssertionError();
		}
	}
	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public List<PageComponent> getChildren() {
		return null;
	}

	@Override
	public String toFormattedString(int tabcount) {
		prepareWidget();
		return widgetComponents.toFormattedString(tabcount+1);
	}
	private void prepareWidget() {
		for(PageComponent p:getLinkedStyleSheets()){
			widgetComponents.addChild(p);
		}
		
		widgetComponents.addChild(getHtmlContent());
		for(PageComponent p:getLinkedScripts()){
			widgetComponents.addChild(p);
		}
	}
	@Override
	public String toString() {
		prepareWidget();
		return widgetComponents.toString();
	}
	@Override
	public final void addChild(PageComponent child) {//TODO make a child interface
	}
	
	public abstract PageComponent getHtmlContent();
	
	public abstract List<PageComponent> getLinkedStyleSheets();
	
	public abstract List<PageComponent> getLinkedScripts() ;
	
	public class WidgetComponentList extends AbstractComponentList {
		List<PageComponent> componentList = new ArrayList<PageComponent>();
		@Override
		protected List<PageComponent> getComponentList() {
			return componentList;
		}

	}
}
