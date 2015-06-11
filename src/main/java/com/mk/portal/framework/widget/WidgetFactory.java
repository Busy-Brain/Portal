package com.mk.portal.framework.widget;

import com.mk.portal.framework.exceptions.PotentialBugException;

public class WidgetFactory {
	@SuppressWarnings("unchecked")
	public static Widget getWidgetByName(String widgetname) {
		Class<? extends Widget> widgetclass = null;
		try {
			widgetclass = (Class<? extends Widget>) Class.forName("com.mk.portal.module."+widgetname);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw new PotentialBugException(e1, "1", "The widgetclass  with name '"+widgetclass+"' was not found");
		}
		try {
			return widgetclass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new PotentialBugException(e, "1", "The widgetclass  with name '"+widgetclass+"' is not instantiable");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new PotentialBugException(e, "1", "The widgetclass  with name '"+widgetclass+"' is not accessible");
		}
	}
}
