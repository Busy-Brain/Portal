package com.mk.portal.framework.controller;

import java.util.List;

import javax.management.ServiceNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.portal.framework.FrameworkConstants;
import com.mk.portal.framework.html.objects.Page;
import com.mk.portal.framework.model.PortalPage;
import com.mk.portal.framework.model.PortalSite;
import com.mk.portal.framework.page.PageFactoryImpl;
import com.mk.portal.framework.page.PageIdentifier;
import com.mk.portal.framework.page.container.Container;
import com.mk.portal.framework.service.PageDetailsService;
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
	private SiteDetailsService siteDetailsService;
	@Autowired
	private PageDetailsService pageDetailsService;
	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_URL + "}" + "/{"
			+ FrameworkConstants.PageConstants.TOPIC_URL + "}" + "/{"
			+ FrameworkConstants.PageConstants.SUB_TOPIC_URL + "}" + "/{"
			+ FrameworkConstants.PageConstants.PAGE_URL + "}")
	@ResponseBody
	public String requestWithSiteTopicSubTopicAndPage(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_URL) String siteUrl,
			@PathVariable(FrameworkConstants.PageConstants.TOPIC_URL) String topicUrl,
			@PathVariable(FrameworkConstants.PageConstants.SUB_TOPIC_URL) String subTopicUrl,
			@PathVariable(FrameworkConstants.PageConstants.PAGE_URL) String pageUrl) {
		return defaultControllorFunctionality(model, new PageIdentifier(siteUrl,
				topicUrl, subTopicUrl, pageUrl));
	}

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_URL + "}" + "/{"
			+ FrameworkConstants.PageConstants.TOPIC_URL + "}" + "/{"
			+ FrameworkConstants.PageConstants.SUB_TOPIC_URL + "}")
	@ResponseBody
	public String requestWithSiteTopicAndSubTopic(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_URL) String siteUrl,
			@PathVariable(FrameworkConstants.PageConstants.TOPIC_URL) String topicUrl,
			@PathVariable(FrameworkConstants.PageConstants.SUB_TOPIC_URL) String subTopicUrl) {
		return defaultControllorFunctionality(model, new PageIdentifier(siteUrl,
				topicUrl, subTopicUrl, BLANK));
	}

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_URL + "}")
	@ResponseBody
	public String requestWithSiteOnly(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_URL) String siteUrl) {
		return defaultControllorFunctionality(model, new PageIdentifier(siteUrl,
				BLANK, BLANK, BLANK));
	}

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_URL + "}" + "/{"
			+ FrameworkConstants.PageConstants.TOPIC_URL + "}")
	@ResponseBody
	public String requestWithSiteAndTopic(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_URL) String siteUrl,
			@PathVariable(FrameworkConstants.PageConstants.TOPIC_URL) String topicUrl) {
		if (siteUrl.equals("rest")) {
			try {
				return new RestServiceController().requesForRestService(null,
						request, topicUrl);
			} catch (ServiceNotFoundException e) {
				// TODO log this
				e.printStackTrace();
			}
		}
		return defaultControllorFunctionality(model, new PageIdentifier(siteUrl,
				topicUrl, BLANK, BLANK));
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
		 * if (pageIdentifier.getsiteUrl().equalsIgnoreCase(DEFAULT_SITE_URL)) {
		 * return defaultSitePages(model, pageIdentifier); }
		 */

		return customPageFunctionality(model, pageIdentifier);
	}

	/*private String defaultSitePages(Model model, PageIdentifier pageIdentifier) {
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
	}*/

	private String customPageFunctionality(Model model,
			PageIdentifier pageIdentifier) {
		pageIdentifier.setLanguage(getLanguage());
		Page page=pageDetailsService.getpage(pageIdentifier);
		
		String pageContent;
		if(isDebugEnabled()){
			pageContent=page.getFormattedHTMLString();
		}
		else{
			pageContent=page.getHTMLString();
		}

		return pageContent;
	}

	private String getLanguage() {
		return "en";
	}

	private boolean isDebugEnabled() {
		return true;
	}

	private void checkUser(HttpServletRequest request) {
		String browserDetails = request.getHeader("User-Agent");
		System.out.println(browserDetails);
	}

}