package com.mk.portal.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mk.portal.framework.FrameworkConstants;

@Controller
public class WidgetController {
	private static final String WIDGET_URL = "/widget/";

	@RequestMapping(value = WIDGET_URL + "/{"
			+ FrameworkConstants.WidgetControllerConstants.WIDGET_NAME + "}", method = RequestMethod.POST)
	public void requesForStaticContent(
			HttpServletResponse response,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.WidgetControllerConstants.WIDGET_NAME) String widgetName) {

	}
}
