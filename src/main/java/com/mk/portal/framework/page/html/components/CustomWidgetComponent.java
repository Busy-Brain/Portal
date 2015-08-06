package com.mk.portal.framework.page.html.components;

import java.util.List;

import com.mk.portal.framework.html.objects.PageComponent;
import com.mk.portal.framework.page.html.tags.Text;

public class CustomWidgetComponent extends AbstractWidgetComponent {

	private String widgetInstanceId;
	private String HTMLContent;

	public CustomWidgetComponent(String widgetInstanceId) {
		super();
		this.widgetInstanceId = widgetInstanceId;
		
	}

	@Override
	public PageComponent getHtmlContent() {
		return new Text(HTMLContent);
	}

	@Override
	public List<PageComponent> getLinkedStyleSheets() {
		return null;
	}

	@Override
	public List<PageComponent> getLinkedScripts() {
		return null;
	}

	public String getWidgetInstanceId() {
		return widgetInstanceId;
	}

	public void setWidgetInstanceId(String widgetInstanceId) {
		this.widgetInstanceId = widgetInstanceId;
	}

}
