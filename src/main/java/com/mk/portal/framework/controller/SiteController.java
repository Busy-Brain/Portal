package com.mk.portal.framework.controller;

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
import com.mk.portal.framework.page.PageIdentifier;
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

	private static final String DEFAULT_URL = "/"
			+ FrameworkConstants.PortalConstants.DEFAULT_SITE_URL;
	@Autowired
	private SiteDetailsService siteDetailsService;
	@Autowired
	private PageDetailsService pageDetailsService;
	

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_URL + "}" + "/{"
			+ FrameworkConstants.PageConstants.PAGE_URL + "}")
	@ResponseBody
	public String requestWithSiteAndTopic(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_URL) String siteUrl,
			@PathVariable(FrameworkConstants.PageConstants.PAGE_URL) String pageUrl) {
		if (siteUrl.equals("rest")) {
			try {
				return new RestServiceController().requesForRestService(null,
						request, pageUrl);
			} catch (ServiceNotFoundException e) {
				// TODO log this
				e.printStackTrace();
			}
		}
		return defaultControllorFunctionality(model, new PageIdentifier(siteUrl,
				BLANK, BLANK, pageUrl));
	}

	

	private String defaultControllorFunctionality(Model model,
			PageIdentifier pageIdentifier) {
	
		return customPageFunctionality(model, pageIdentifier);
	}


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

}