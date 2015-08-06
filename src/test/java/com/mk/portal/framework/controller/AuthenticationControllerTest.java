package com.mk.portal.framework.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import com.mk.portal.framework.configuration.ConfigurationReader;
import com.mk.portal.framework.configuration.JSONConfigurationReader;
import com.mk.portal.framework.service.SiteDetailsService;

/**
 * This controller controls the behaviour while logging in and logging out of
 * the portal
 * 
 * @author mohit
 *
 */
@Controller
public class AuthenticationControllerTest {

	private static final ConfigurationReader config = new JSONConfigurationReader();
	
	private SiteDetailsService siteDetailsService;
	
	@Test
	public void testLoginRequest() {
		
	}

	@Test
	public void testLogout() {
		
	}

}
