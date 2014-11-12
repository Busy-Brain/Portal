package com.mk.portal.framework.page.container;

import com.mk.portal.framework.page.content.HTMLContent;

public class ContainerFactoryImpl implements ContainerFactory {

	public Container getContainer(String containerId) {
		Container container = getContainerFromConfiguration(containerId);
		if (container == null) {
			container = getContainerFromDB(containerId);
		}
		if (container == null) {
			container = getDefaultContainer(containerId);
		}
		return container;
	}

	private Container getDefaultContainer(String containerId) {
		
		Container container = new DefaultContainer(new HTMLContent(
				"This is default page!"));
		return container;
	}

	private Container getContainerFromDB(String containerId) {
		// TODO Auto-generated method stub
		return null;
	}

	private Container getContainerFromConfiguration(String containerId) {
		return new JsonContainerLoader().getContainer(containerId);
	}

	

}
