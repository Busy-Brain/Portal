package com.mk.portal.framework.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mk.portal.framework.FrameworkConstants;
import com.mk.portal.framework.page.PageFactoryImpl;
import com.mk.portal.framework.page.PageIdentifier;
import com.mk.portal.framework.page.PortalPage;
import com.mk.portal.framework.page.container.Container;

@Controller
public class DefaultController {

	private static final String LOGIN_PAGE_NAME = "login";
	private static final String LOGOUT_URL = "/logout";
	private static final String BLANK_URL = "/";
	private static final String LOGIN_URL = "/login";
	private static final String DEFAULT_PAGE_NAME = "index";
	private static final String DEFAULT_URL = "/"
			+ FrameworkConstants.PortalConstants.DEFAULT_SITE_URL;

	private static final String DEFAULT_SITE_URL = "me";

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_ID + "}" + "/{"
			+ FrameworkConstants.PageConstants.TOPIC_ID + "}" + "/{"
			+ FrameworkConstants.PageConstants.SUB_TOPIC_ID + "}" + "/{"
			+ FrameworkConstants.PageConstants.PAGE_ID + "}")
	public String requestWithSiteTopicSubTopicAndPage(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_ID) String siteId,
			@PathVariable(FrameworkConstants.PageConstants.TOPIC_ID) String topicId,
			@PathVariable(FrameworkConstants.PageConstants.SUB_TOPIC_ID) String subTopic,
			@PathVariable(FrameworkConstants.PageConstants.PAGE_ID) String pageId) {
		System.out.println(0);
		return defaultControllorFunctionality(model, new PageIdentifier(siteId,
				topicId, subTopic, pageId));
	}

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_ID + "}" + "/{"
			+ FrameworkConstants.PageConstants.TOPIC_ID + "}" + "/{"
			+ FrameworkConstants.PageConstants.SUB_TOPIC_ID + "}")
	public String requestWithSiteTopicAndSubTopic(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_ID) String siteId,
			@PathVariable(FrameworkConstants.PageConstants.TOPIC_ID) String topicId,
			@PathVariable(FrameworkConstants.PageConstants.SUB_TOPIC_ID) String subTopic) {
		System.out.println(1);
		checkUser(request);
		return defaultControllorFunctionality(model, new PageIdentifier(siteId,
				topicId, subTopic, ""));
	}

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_ID + "}")
	public String requestWithSiteOnly(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_ID) String siteId) {
		System.out.println(2);
		checkUser(request);
		return defaultControllorFunctionality(model, new PageIdentifier(siteId,
				"", "", ""));
	}

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_ID + "}" + "/{"
			+ FrameworkConstants.PageConstants.TOPIC_ID + "}")
	public String requestWithSiteAndTopic(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_ID) String siteId,
			@PathVariable(FrameworkConstants.PageConstants.TOPIC_ID) String topicId) {
		System.out.println(3);
		checkUser(request);
		return defaultControllorFunctionality(model, new PageIdentifier(siteId,
				topicId, "", ""));
	}

	@RequestMapping(value = { BLANK_URL, DEFAULT_URL, LOGIN_URL })
	public String blankRequest(Model model, HttpServletRequest request) {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String defaultPageName = "";
		if (!((auth == null) || (auth instanceof AnonymousAuthenticationToken))) {
			defaultPageName = redirectToDefaultPage();
		}

		else {
			defaultPageName = getDefaultPageName();
		}
		return defaultPageName;
	}

	private String redirectToDefaultPage() {
		return "redirect:" + getDefaultPageName();
	}

	private String getDefaultPageName() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		String defaultPageName = "";
		if (!((auth == null) || (auth instanceof AnonymousAuthenticationToken))) {

			/* The user is logged in :) */
			defaultPageName = "/me/dashboard";
		}

		else {
			defaultPageName = LOGIN_PAGE_NAME;
		}
		return defaultPageName;
	}

	private String defaultControllorFunctionality(Model model,
			PageIdentifier pageIdentifier) {
		if (pageIdentifier.getSiteId().equalsIgnoreCase(DEFAULT_SITE_URL)) {
			return defaultSitePages(model, pageIdentifier);
		}

		return customPageFunctionality(model, pageIdentifier);
	}

	private String defaultSitePages(Model model, PageIdentifier pageIdentifier) {
		model.addAttribute(FrameworkConstants.PageConstants.PAGE_IDENTIFIER,
				pageIdentifier);
		String pagepath = pageIdentifier.getSiteId();
		if (!pageIdentifier.getTopicId().equals("")) {
			pagepath = pagepath + BLANK_URL + pageIdentifier.getTopicId();
			if (!pageIdentifier.getSubTopicId().equals("")) {
				pagepath = pagepath + BLANK_URL
						+ pageIdentifier.getSubTopicId();

			}
		}
		if (!pageIdentifier.getPageId().equals("")) {
			pagepath = pagepath + BLANK_URL + pageIdentifier.getPageId();
		}

		return pagepath;
	}

	private String customPageFunctionality(Model model,
			PageIdentifier pageIdentifier) {
		PortalPage page = new PageFactoryImpl().getPage(pageIdentifier);
		List<Container> pageContainers = page.getContainersList();
		StringBuilder sb = new StringBuilder();

		if (pageContainers != null) {
			for (Container c : pageContainers) {
				System.out.println("-->" + c.getContentsAsString());
				sb.append(c.getContentsAsString());
			}
		}

		model.addAttribute(FrameworkConstants.PageConstants.PAGE_IDENTIFIER,
				pageIdentifier);
		model.addAttribute(FrameworkConstants.PageConstants.PAGE_CONTENT,
				sb.toString());

		return DEFAULT_PAGE_NAME;
	}

	private void checkUser(HttpServletRequest request) {
		String browserDetails = request.getHeader("User-Agent");
		System.out.println(browserDetails);
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
		return redirectToDefaultPage();
	}

}
