package com.mk.portal.framework.page.html.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.mk.portal.framework.exceptions.PotentialBugException;
import com.mk.portal.framework.html.objects.PageComponent;

@Component
public class ComponentFactory {
	@Autowired
	private ApplicationContext appContext;

	public PageComponent getComponentByName(String widgetname) {
		try {
			return (PageComponent) appContext.getBean(widgetname);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PotentialBugException(e, "1", "The widget  with name '"
					+ widgetname + "' is not accessible");
		}

	}
}
