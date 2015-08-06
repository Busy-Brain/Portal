package com.mk.portal.framework.configuration;

import org.junit.Assert;
import org.junit.Test;

import com.mk.portal.framework.constants.PageConstants;
import com.mk.portal.framework.controller.ControllerConfigConstants;

public final class DefaultConfigurationsTest {
	
	@Test
	public void testLoginPageName(){
		Assert.assertNotNull(DefaultConfigurations.getValue("page.name.login"));
		
	}
	@Test
	public void testLogoutPageName(){
		Assert.assertNotNull(DefaultConfigurations.getValue("page.name.logout"));
	}
	@Test
	public void testDefaultPageName(){
		Assert.assertNotNull(DefaultConfigurations.getValue(ControllerConfigConstants.DEFAULT_PAGE_URL));
	}
	@Test
	public void testPageJSONName(){
		Assert.assertNotNull(DefaultConfigurations.getValue(PageConstants.PAGES_JSON));
	}
	
	@Test
	public void testSiteJSONName(){
		Assert.assertNotNull(DefaultConfigurations.getValue(PageConstants.SITES_JSON));
	}
	
}
