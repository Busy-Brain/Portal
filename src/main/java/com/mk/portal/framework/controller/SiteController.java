package com.mk.portal.framework.controller;

import javax.management.ServiceNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.portal.framework.constants.PageConstants;
import com.mk.portal.framework.constants.PortalConstants;
import com.mk.portal.framework.html.objects.Page;
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
	private static final String DEFAULT_URL = "/"
			+ PortalConstants.DEFAULT_SITE_URL;
	@Autowired
	private SiteDetailsService siteDetailsService;
	@Autowired
	private PageDetailsService pageDetailsService;
	

	@RequestMapping(value = DEFAULT_URL + "/{"
			+ PageConstants.SITE_URL + "}" + "/{"
			+ PageConstants.PAGE_URL + "}/**")
	@ResponseBody
	public String requestWithSiteAndTopic(
			Model model,
			HttpServletRequest request,
			@PathVariable(PageConstants.SITE_URL) String siteUrl,
			@PathVariable(PageConstants.PAGE_URL) String pageUrl) {
		if (siteUrl.equals("rest")) {
			try {
				return new RestServiceController().requesForRestService(null,
						request, pageUrl);
			} catch (ServiceNotFoundException e) {
				// TODO log this
				e.printStackTrace();
			}
		}
		        
        
		return defaultControllorFunctionality(model,request.getRequestURI(),request.getQueryString());
	}

	

	private String defaultControllorFunctionality(Model model,
			String url, String queryparam) {
	
		return customPageFunctionality(model, url,queryparam);
	}


	private String customPageFunctionality(Model model,
			String url, String queryparam) {
		System.out.println(url);
		Page page=pageDetailsService.getpage(url,queryparam);
		
		String pageContent;
		if(isDebugEnabled()){
			pageContent=page.getFormattedHTMLString();
		}
		else{
			pageContent=page.getHTMLString();
		}

		return pageContent;
	}

	private boolean isDebugEnabled() {
		return true;
	}

}