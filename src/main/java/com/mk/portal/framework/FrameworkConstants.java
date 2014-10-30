package com.mk.portal.framework;

public final class FrameworkConstants {
	private FrameworkConstants() {
		throw new AssertionError();
	}
	public class PortalConstants{
		public static final String DEFAULT_PORTAL_URL="portal";
		
		private PortalConstants(){
			throw new AssertionError();
		}
	}
	
	public class PageConstants{
		public static final String DEFAULT_PAGE_NAME="index";
		public static final String PAGE_ID = "pageId";
		public static final String PAGE_CONTENT = "pageContent";
		private PageConstants(){
			throw new AssertionError();
		}
	}
}
