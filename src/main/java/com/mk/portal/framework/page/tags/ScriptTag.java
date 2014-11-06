package com.mk.portal.framework.page.tags;
/**
 * TODO load specific scripts for the page
 * @author mohit
 *
 */
public class ScriptTag extends PageSpecificPortalTag{

	@Override
	protected String getTagHTML() {
		return getPortalScript()+getSiteScript()+getPageScript()+getWidgetScript();
	}

	private String getWidgetScript() {
		return "";
	}

	private String getPageScript() {
		return "";
	}

	private String getSiteScript() {
		return new Script("/qbank/static/js/default/script.js").toString();
	}

	private String getPortalScript() {
		return "";
	}
	
	
	private class Script{
		private String src;

		public Script(String src) {
			super();
			this.src = src;
		}
		@Override
		public String toString() {
			return "<script src=\""+src+"\"></script>";
		}
	}
}
