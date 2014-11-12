package com.mk.portal.framework.page.content;

public class HTMLContent implements Content {

	private String HTMLContent;

	public HTMLContent(String content) {

		HTMLContent = content;
	}

	public String getValue() {
		return getHTMLContent();
	}

	private String getHTMLContent() {
		return HTMLContent;
	}

	public void setHTMLContent(String hTMLContent) {
		HTMLContent = hTMLContent;
	}
}
