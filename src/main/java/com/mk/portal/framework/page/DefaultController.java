package com.mk.portal.framework.page;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mk.portal.framework.FrameworkConstants;

@Controller
public class DefaultController {

	private static final String DEFAULT_PAGE_NAME = "index";
	private static final String DEFAULT_URL = "/"
			+ FrameworkConstants.PortalConstants.DEFAULT_PORTAL_URL;
	private static final String CONTROLLER_URL = DEFAULT_URL + "/";

	@RequestMapping(value = CONTROLLER_URL + "*")
	public String index(Model model, HttpServletRequest request) {
		String pageId = getPageId(request);
		PortalPage page=new PageFactoryImpl().getPage(pageId);
		String pageContent= page.getLayout().getContainers().get(0).getContents().getValue();
		model.addAttribute(FrameworkConstants.PageConstants.PAGE_ID, pageId);
		model.addAttribute(FrameworkConstants.PageConstants.PAGE_CONTENT, pageContent);
		
		return DEFAULT_PAGE_NAME;
	}


	private String getPageId(HttpServletRequest request) {
		return request.getRequestURI().substring(
				request.getRequestURI().indexOf(CONTROLLER_URL)
						+ (CONTROLLER_URL).length());
	}
}
