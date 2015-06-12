package com.mk.portal.framework.controller;

import java.util.List;

import javax.management.ServiceNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mk.portal.framework.FrameworkConstants;
import com.mk.portal.framework.model.PortalSite;
import com.mk.portal.framework.page.PageFactoryImpl;
import com.mk.portal.framework.page.PageIdentifier;
import com.mk.portal.framework.page.PortalPage;
import com.mk.portal.framework.page.container.Container;
import com.mk.portal.framework.service.SiteDetailsService;

/**
 * This is the default controller of the portal. It handles default requests
 * 
 * @author mohit
 *
 */
@Controller
public class SiteController {
	private static final String BLANK = "";

	private static final String BLANK_URL = "/";
	// TODO this must be configurable
	private static final String DEFAULT_PAGE_NAME = "index";
	private static final String DEFAULT_URL = "/"
			+ FrameworkConstants.PortalConstants.DEFAULT_SITE_URL;
	// TODO This must be configurable
	private static final String DEFAULT_SITE_URL = "me";
	@Autowired
	private SiteDetailsService detailsService;

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
		return defaultControllorFunctionality(model, new PageIdentifier(siteId,
				topicId, subTopic, BLANK));
	}

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_ID + "}")
	public String requestWithSiteOnly(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_ID) String siteId) {
		return defaultControllorFunctionality(model, new PageIdentifier(siteId,
				BLANK, BLANK, BLANK));
	}

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_ID + "}" + "/{"
			+ FrameworkConstants.PageConstants.TOPIC_ID + "}")
	public String requestWithSiteAndTopic(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_ID) String siteId,
			@PathVariable(FrameworkConstants.PageConstants.TOPIC_ID) String topicId) {
		if (siteId.equals("rest")) {
			try {
				return new RestServiceController().requesForRestService(null,
						request, topicId);
			} catch (ServiceNotFoundException e) {
				// TODO log this
				e.printStackTrace();
			}
		}
		return defaultControllorFunctionality(model, new PageIdentifier(siteId,
				topicId, BLANK, BLANK));
	}

	/*
	 * @RequestMapping(value = { BLANK_URL, DEFAULT_URL }) public String
	 * defaultRequest(Model model, HttpServletRequest request) { Authentication
	 * auth = SecurityContextHolder.getContext() .getAuthentication(); String
	 * defaultPageName = ""; if (!((auth == null) || (auth instanceof
	 * AnonymousAuthenticationToken))) { defaultPageName =
	 * redirectToDefaultPage(); }
	 * 
	 * else { defaultPageName = getDefaultPageName(); } return defaultPageName;
	 * }
	 */

	private String defaultControllorFunctionality(Model model,
			PageIdentifier pageIdentifier) {
		/*
		 * if (pageIdentifier.getSiteId().equalsIgnoreCase(DEFAULT_SITE_URL)) {
		 * return defaultSitePages(model, pageIdentifier); }
		 */

		return customPageFunctionality(model, pageIdentifier);
	}

	private String defaultSitePages(Model model, PageIdentifier pageIdentifier) {
		model.addAttribute(FrameworkConstants.PageConstants.PAGE_IDENTIFIER,
				pageIdentifier);
		String pagepath = pageIdentifier.getSiteId();
		if (!pageIdentifier.getTopicId().equals(BLANK)) {
			pagepath = pagepath + BLANK_URL + pageIdentifier.getTopicId();
			if (!pageIdentifier.getSubTopicId().equals(BLANK)) {
				pagepath = pagepath + BLANK_URL
						+ pageIdentifier.getSubTopicId();

			}
		}
		if (!pageIdentifier.getPageId().equals(BLANK)) {
			pagepath = pagepath + BLANK_URL + pageIdentifier.getPageId();
		}

		return pagepath;
	}

	private String customPageFunctionality(Model model,
			PageIdentifier pageIdentifier) {
		PortalSite site = detailsService
				.getSiteById(pageIdentifier.getSiteId());
		PortalPage page = new PageFactoryImpl().getPage(pageIdentifier);
		List<Container> pageContainers = page.getContainersList();
		StringBuilder sb = new StringBuilder();

		if (pageContainers != null) {
			for (Container c : pageContainers) {
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

}