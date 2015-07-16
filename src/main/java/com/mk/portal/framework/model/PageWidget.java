package com.mk.portal.framework.model;

public class PageWidget {
	private String pageId;
	private String widgetId;
	private String pageArea;
	private int areaOrder;
	private String name;
	private String uiPath;
	private String title;

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getWidgetId() {
		return widgetId;
	}

	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
	}

	public String getPageArea() {
		return pageArea;
	}

	public void setPageArea(String pageArea) {
		this.pageArea = pageArea;
	}

	public int getAreaOrder() {
		return areaOrder;
	}

	public void setAreaOrder(int i) {
		this.areaOrder = i;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUiPath() {
		return uiPath;
	}

	public void setUiPath(String uiPath) {
		this.uiPath = uiPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
