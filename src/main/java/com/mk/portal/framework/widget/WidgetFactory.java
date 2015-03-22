package com.mk.portal.framework.widget;

import com.mk.portal.framework.exceptions.WidgetNotFoundException;

public class WidgetFactory {
	@SuppressWarnings("unchecked")
	public static Widget getWidgetByName(String widgetname) throws WidgetNotFoundException {
		Class<? extends Widget> widgetclass = null;
		try {
			widgetclass = (Class<? extends Widget>) Class.forName("com.mk.portal.module."+widgetname);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw new WidgetNotFoundException();
		}
		try {
			return widgetclass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new WidgetNotFoundException();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new WidgetNotFoundException();
		}
	}
}
