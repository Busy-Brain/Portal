package com.mk.portal.framework.widget;

import com.mk.portal.framework.service.PortalVO;

public class WidgetServiceVO implements PortalVO {
	private String widgetName;
	private Widget widget;
	public String getWidgetName() {
		return widgetName;
	}
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	public Widget getWidget() {
		return widget.clone();
	}
	public void setWidget(Widget widget) {
		this.widget = widget.clone();
	}
}
