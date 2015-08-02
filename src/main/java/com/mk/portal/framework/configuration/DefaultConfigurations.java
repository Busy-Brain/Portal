package com.mk.portal.framework.configuration;

import java.util.HashMap;
import java.util.Map;

import com.mk.portal.framework.constants.PageConstants;
import com.mk.portal.framework.controller.ControllerConfigConstants;

public final class DefaultConfigurations {
	private static Map<String, String> configurations = new HashMap<String, String>();
	static {
		configurations.put("page.name.login", "login");
		configurations.put("page.name.logout", "logout");
		configurations.put(ControllerConfigConstants.DEFAULT_PAGE_URL,"/me/dashboard");
		configurations.put(PageConstants.PAGES_JSON,"/home/mohit/personal/github/Portal/portalconfig/pages/pages.json");
		configurations.put(PageConstants.SITES_JSON,"/home/mohit/personal/github/Portal/portalconfig/pages/sites.json");
	}

	public static String getValue(String key){
		return configurations.get(key);
	}

}
