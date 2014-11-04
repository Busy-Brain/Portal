package com.mk.portal.framework.page;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mk.portal.framework.FrameworkConstants;
import com.mk.portal.framework.page.container.Container;
import com.mk.portal.framework.page.container.ContainerFactoryImpl;

@Controller
public class DefaultController {

	private static final String DEFAULT_PAGE_NAME = "index";
	private static final String DEFAULT_URL = "/"
			+ FrameworkConstants.PortalConstants.DEFAULT_SITE_URL;
	@RequestMapping(value = DEFAULT_URL + 
			"/{"+ FrameworkConstants.PageConstants.SITE_ID + "}" +
			"/{"+ FrameworkConstants.PageConstants.TOPIC_ID + "}" +
			"/{"+ FrameworkConstants.PageConstants.SUB_TOPIC_ID + "}"+
			"/{"+ FrameworkConstants.PageConstants.PAGE_ID + "}")
	public String requestWithSiteTopicSubTopicAndPage(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_ID) String siteId,
			@PathVariable(FrameworkConstants.PageConstants.TOPIC_ID) String topicId,
			@PathVariable(FrameworkConstants.PageConstants.SUB_TOPIC_ID) String subTopic,
			@PathVariable(FrameworkConstants.PageConstants.PAGE_ID) String pageId) {
System.out.println(0);
		return defaultControllorFunctionality(model,new PageIdentifier(siteId, topicId, subTopic,pageId));
	}
	@RequestMapping(value = DEFAULT_URL + 
			"/{"+ FrameworkConstants.PageConstants.SITE_ID + "}" +
			"/{"+ FrameworkConstants.PageConstants.TOPIC_ID + "}" +
			"/{"+ FrameworkConstants.PageConstants.SUB_TOPIC_ID + "}")
	public String requestWithSiteTopicAndSubTopic(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_ID) String siteId,
			@PathVariable(FrameworkConstants.PageConstants.TOPIC_ID) String topicId,
			@PathVariable(FrameworkConstants.PageConstants.SUB_TOPIC_ID) String subTopic) {
System.out.println(1);
		return defaultControllorFunctionality(model,new PageIdentifier(siteId, topicId, subTopic,""));
	}
	@RequestMapping(value = DEFAULT_URL + "/{"
			+ FrameworkConstants.PageConstants.SITE_ID + "}" )
	
	public String requestWithSiteOnly(
			Model model,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.PageConstants.SITE_ID) String siteId) {
System.out.println(2);
		return defaultControllorFunctionality(model,new PageIdentifier(siteId, "", "",""));
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
		return defaultControllorFunctionality(model,new PageIdentifier(siteId, topicId, "",""));
	}
	@RequestMapping(value = DEFAULT_URL )
	
	public String blankRequest(
			Model model,
			HttpServletRequest request) {
System.out.println(4);
		return defaultControllorFunctionality(model,new PageIdentifier("","","", ""));
	}

	private String defaultControllorFunctionality(Model model, PageIdentifier pageIdentifier) {

		PortalPage page = new PageFactoryImpl().getPage(pageIdentifier);
		List<Container> pageContainers = page.getContainersList();
		StringBuilder sb = new StringBuilder();
		
		if (pageContainers != null) {
			for (Container c : pageContainers) {
				System.out.println("-->"+c.getContentsAsString());
				sb.append(c.getContentsAsString());
			}
		}

		model.addAttribute(FrameworkConstants.PageConstants.PAGE_IDENTIFIER, pageIdentifier);
		model.addAttribute(FrameworkConstants.PageConstants.PAGE_CONTENT,
				sb.toString());

		return DEFAULT_PAGE_NAME;
	}

}
