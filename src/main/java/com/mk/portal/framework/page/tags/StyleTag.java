package com.mk.portal.framework.page.tags;
/**
 * TODO load specific style sheets for the page
 * @author mohit
 *
 */
public class StyleTag extends PageSpecificPortalTag{

	@Override
	protected String getTagHTML() {
		return getPortalStyle()+getSiteStyle()+getPageStyle()+getWidgetStyle();
	}

	private String getWidgetStyle() {
		return "";
	}

	private String getPageStyle() {
		return "";
	}

	private String getSiteStyle() {
		return new Style("/qbank/static/css/default/style.css").toString();
	}

	private String getPortalStyle() {
		return "";
	}
	private class Style{
		private final String rel="stylesheet";
		private final String type="text/css";
		private final String href;
		public Style(String p){
			href=p;
		}
		@Override
		public String toString(){
			return "<link rel=\""+rel+"\" type=\""+type+"\" href=\""+href+"\"/>";
		}
	}
}
