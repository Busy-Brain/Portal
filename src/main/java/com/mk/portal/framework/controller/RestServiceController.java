package com.mk.portal.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mk.portal.framework.FrameworkConstants;
/**
 * This controller enables rest webservices of the application
 * @author mohit
 *
 */
@Controller
public class RestServiceController {
	private static final String REST_URL = "/rest/";

	@RequestMapping(value = REST_URL + "/{"
			+ FrameworkConstants.RestServiceConstants.REST_SERVICE_NAME + "}", method = RequestMethod.POST)
	public void requesForRestService(
			HttpServletResponse response,
			HttpServletRequest request,
			@PathVariable(FrameworkConstants.RestServiceConstants.REST_SERVICE_NAME) String serviceName) {

	}

}
