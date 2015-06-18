package com.mk.portal.framework.html.objects;

import java.util.List;

public class Page {
	private final List<PageComponent> pageComponents;

	public List<PageComponent> getPageComponents() {
		return pageComponents;
	}

	public Page(final List<PageComponent> pageComponents) {
		this.pageComponents = pageComponents;
	}

	public void addComponent(PageComponent component) {
		pageComponents.add(component.clone());
	}
	public String getHTMLString(){
		StringBuffer sb=new StringBuffer();
		for(PageComponent comp:pageComponents){
			sb.append(comp.toString());
		}
		return sb.toString();
	}
	public String getFormattedHTMLString(){
		StringBuffer sb=new StringBuffer();
		for(PageComponent comp:pageComponents){
			sb.append(comp.toFormattedString(0));
		}
		return sb.toString();
	}
	
}
