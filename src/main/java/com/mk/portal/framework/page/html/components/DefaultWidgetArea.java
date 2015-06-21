package com.mk.portal.framework.page.html.components;

import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.page.html.attributes.ClassAttribute;
import com.mk.portal.framework.page.html.tags.DivTag;

public class DefaultWidgetArea extends AbstractWidgetArea{

	@Override
	public PageComponent getWidgetArea() {
		DivTag div = new DivTag();
		div.addAttribute(new ClassAttribute("widgetarea"));
		return div;
	}

	

}
