package com.mk.portal.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mk.portal.framework.configuration.ConfigurationReader;
import com.mk.portal.framework.configuration.JSONConfigurationReader;
import com.mk.portal.framework.model.PortalSite;
import com.mk.portal.framework.service.SiteDetailsService;

/**
 * This controller controls the behaviour while logging in and logging out of
 * the portal
 * 
 * @author mohit
 *
 */
@Controller
public class AuthenticationController {
	
	// TODO How to override in extension
	private static final String LOGIN_PAGE_NAME = "login";
	private static final String LOGOUT_PAGE_NAME = "logout";
	private static final String LOGIN_URL = "/" + LOGIN_PAGE_NAME;
	private static final String LOGOUT_URL = "/" + LOGOUT_PAGE_NAME;
	private static final ConfigurationReader config = new JSONConfigurationReader();
	
	@Autowired
	private SiteDetailsService siteDetailsService;

	@RequestMapping(value = { LOGIN_URL })
	public String loginRequest(Model model, HttpServletRequest request,@RequestParam(required = false)String siteId) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String defaultPageName = "";
		if (!((auth == null) || (auth instanceof AnonymousAuthenticationToken))) {
			defaultPageName = redirectToDefaultPage(siteId);
		}

		else {
			defaultPageName = getDefaultPageName(siteId);
		}
		return defaultPageName;
	}

	@RequestMapping(value = { LOGOUT_URL })
	public String logout(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		SecurityContextHolder.getContext().setAuthentication(null);
		return redirectToDefaultPage(null);
	}

	private String redirectToDefaultPage(String siteId) {
		return "redirect:" + getDefaultPageName(siteId);
	}

	private String getDefaultPageName(String siteId) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String defaultPageName = "";
		if (!((auth == null) || (auth instanceof AnonymousAuthenticationToken))) {
			/* The user is logged in :) */
			//Get default page for user
			PortalSite site= siteDetailsService.getSiteById(siteId);
			site.getDefaultPage();
			defaultPageName = config
					.getValueFromConfigOrDefault(ControllerConfigConstants.DEFAULT_PAGE_URL);
		} else {
			defaultPageName = LOGIN_PAGE_NAME;
		}
		return defaultPageName;
	}
}
