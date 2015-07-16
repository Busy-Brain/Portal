package com.mk.portal.framework.widget;

import com.mk.portal.framework.exceptions.PotentialBugException;
import com.mk.portal.framework.html.objects.PageComponent;

public class WidgetFactory {
	@SuppressWarnings("unchecked")
	public static PageComponent getWidgetByName(String widgetname) {
		Class<? extends PageComponent> widgetclass = null;
		try {
			widgetclass = (Class<? extends PageComponent>) Class.forName(widgetname);
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
