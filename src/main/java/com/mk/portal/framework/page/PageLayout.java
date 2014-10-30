package com.mk.portal.framework.page;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.page.container.Container;


public class PageLayout {
	private String layoutId;
	private List<Container> containers;
	public List<Container> getContainers() {
		return containers;
	}
	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}
	public String getLayoutId() {
		return layoutId;
	}
	public void setLayoutId(String layoutId) {
		this.layoutId = layoutId;
	}
	public boolean addContainer(Container container) {
		if(containers==null){
			containers= new ArrayList<Container>();
		}
		return containers.add(container);
	}
}
