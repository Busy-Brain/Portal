package com.mk.portal.framework.page.html.components;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.html.objects.PageComponent;

public abstract class AbstractWidgetArea implements WidgetArea {
	private String id;
	private List<PageComponent> children = new ArrayList<PageComponent>();

	@Override
	public String getId() {
		return id;
	}

	@Override
	public List<PageComponent> getChildren() {
		return children;
	}
	public abstract PageComponent getWidgetArea();
	public void addChild(PageComponent child){
		children.add(child);
	}

	@Override
	public String toString() {
		getWidgetArea().getChildren().addAll(children);
		
		return getWidgetArea().toString();
	}
	@Override
	public PageComponent clone(){
		return (PageComponent)this.clone();
	}
	
	@Override
	public boolean hasChildren() {
		return getChildren().size()>0;
	}

	@Override
	public String toFormattedString(int tabcount) {
		getWidgetArea().getChildren().addAll(children);
		
		return getWidgetArea().toFormattedString(tabcount);
	}
	
}
