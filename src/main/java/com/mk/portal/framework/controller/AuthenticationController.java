package com.mk.portal.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * This controller controls the behaviour while logging in and logging out of the portal
 * @author mohit
 *
 */
@Controller
public class AuthenticationController {
	private static final String LOGIN_URL = "/login";
	private static final String LOGOUT_URL = "/logout";
	@RequestMapping(value = { LOGIN_URL })
	public String loginRequest(Model model, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String defaultPageName = "";
		if (!((auth == null) || (auth instanceof AnonymousAuthenticationToken))) {
			defaultPageName = new DefaultController().redirectToDefaultPage();
		}

		else {
			defaultPageName = new DefaultController().getDefaultPageName();
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
		return new DefaultController().redirectToDefaultPage();
	}
}
