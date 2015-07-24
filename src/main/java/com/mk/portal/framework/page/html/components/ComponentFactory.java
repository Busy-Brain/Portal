package com.mk.portal.framework.page.html.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mk.portal.framework.exceptions.PotentialBugException;
import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.model.PageWidget;
import com.mk.portal.framework.model.PortalPage;

@Component
public class ComponentFactory {
	@Autowired
	private ApplicationContext appContext;

	public PageComponent getComponentInstance(PageWidget w, PortalPage page) {
		try {
			PageComponent component = (PageComponent) appContext.getBean(w.getName());
			component.setPage(page);
			return component;
		} catch (Exception e) {
			e.printStackTrace();
			throw new PotentialBugException(e, "1", "The widget  with name '"
					+ w + "' is not accessible");
		}

	}
}
