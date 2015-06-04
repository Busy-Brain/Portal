package com.mk.portal.framework;
/**
 * This class contains the constants used by portal framework
 * Name spacing is achieved by inner classes
 * @author mohit
 */
public final class FrameworkConstants {
	private FrameworkConstants() {
		throw new AssertionError();
	}
	public class RestServiceConstants{
		public static final String REST_SERVICE_NAME="restService";
		public static final String REST_SERVICE_METHOD = "restServiceMethod";
		
		private RestServiceConstants(){
			throw new AssertionError();
		}
	}
	public class PortalConstants{
		public static final String DEFAULT_SITE_URL="";
		
		private PortalConstants(){
			throw new AssertionError();
		}
	}
	
	public class PageConstants{
		public static final String PAGES_JSON = "/home/mohit/personal/github/Portal/portalconfig/pages/pages.json";
		public static final String CONTAINER_JSON = "/home/mohit/personal/github/Portal/portalconfig/pages/containers.json";
		public static final String STATIC_FOLDER_PATH="/home/mohit/personal/github/Portal/target/Qbank/static";
		public static final String DEFAULT_PAGE_NAME="index";
		public static final String PAGE_ID = "pageId";
		public static final String PAGE_CONTENT = "pageContent";
		public static final String TOPIC_ID = "topicId";
		public static final String SITE_ID = "siteId";
		public static final String SUB_TOPIC_ID = "subTopicId";
		public static final String PAGE_IDENTIFIER = "pageIdentifier";
		public static final String PAGE_TITLE = "pageTitle";
		public static final String PAGES = "pages";
		public static final String CONTAINERS = "containers";
		public static final String CONTAINER_TYPE = "containerType";
		public static final String CONTAINER_ID = "containerId";
		public static final String CONTENTS = "contents";
		public static final String CONTENT_ID = "contentId";
		public static final String CONTENT_TYPE = "contentType";
		public static final String CONTENT_PATH = "contentPath";
		private PageConstants(){
			throw new AssertionError();
		}
	}
	public class StaticContentConstants{

		public static final String STATIC_CONTENT_TYPE = "staticContentType";
		public static final String FOLDER_ID = "folderId";
		public static final String FILE_NAME = "fileName";
		
		private StaticContentConstants(){
			throw new AssertionError();
		}
	}
	
	public class WidgetControllerConstants{

		public static final String WIDGET_NAME = "WIDGET_NAME";
		
	}
}
