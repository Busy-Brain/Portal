package com.mk.portal.framework.page.html.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.model.PageWidget;
import com.mk.portal.framework.model.PortalPage;

@Component
public class ComponentFactory {
	@Autowired
	private ApplicationContext appContext;

	public PageComponent getComponentInstance(PageWidget w, PortalPage page) {

		PageComponent component;
		if(appContext.containsBeanDefinition(w.getName())){
			component = (PageComponent) appContext.getBean(w.getName());
		} else {
			component = loadFromDB(w, page);
		}
		component.setPage(page);
		return component;

	}

	private PageComponent loadFromDB(PageWidget w, PortalPage page) {
		return new CustomWidgetComponent(w.getName());
	}
}
