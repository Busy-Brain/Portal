package com.mk.portal.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mk.portal.framework.constants.WidgetControllerConstants;

@Controller
public class WidgetController {
	//This must be configurable
	//Make an enum of All URL types
	private static final String WIDGET_URL = "/widget/";

	@RequestMapping(value = WIDGET_URL + "/{"
			+ WidgetControllerConstants.WIDGET_NAME + "}", method = RequestMethod.POST)
	public void postRequesForWidget(
			HttpServletResponse response,
			HttpServletRequest request,
			@PathVariable(WidgetControllerConstants.WIDGET_NAME) String widgetName) {
		System.out.println(widgetName);

	}
	@RequestMapping(value = WIDGET_URL + "/{"
			+ WidgetControllerConstants.WIDGET_NAME + "}", method = RequestMethod.GET)
	public void getRequesForStaticContent(
			HttpServletResponse response,
			HttpServletRequest request,
			@PathVariable(WidgetControllerConstants.WIDGET_NAME) String widgetName) {
		System.out.println(widgetName);

	}
}
