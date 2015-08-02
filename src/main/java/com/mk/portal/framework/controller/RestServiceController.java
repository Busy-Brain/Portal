package com.mk.portal.framework.controller;

import javax.management.ServiceNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mk.portal.framework.constants.RestServiceConstants;
import com.mk.portal.framework.service.PortalService;
import com.mk.portal.framework.service.PortalVO;
import com.mk.portal.framework.service.ServiceFactory;
import com.mk.portal.framework.service.ServiceResponse;
/**
 * This controller enables rest webservices of the application
 * @author mohit
 *
 */
@Controller
public class RestServiceController {
	//TODO configurable
	private static final String REST_URL = "/rest/";
@Autowired
ServiceFactory factory;

	@RequestMapping(value = REST_URL + "/{"
			+ RestServiceConstants.REST_SERVICE_NAME + "}/{"+
			RestServiceConstants.REST_SERVICE_METHOD +"}"
			, method = RequestMethod.POST)
	public String requesForRestService(
			HttpServletResponse response,
			HttpServletRequest request,
			@PathVariable(RestServiceConstants.REST_SERVICE_NAME) String serviceName,
			@PathVariable(RestServiceConstants.REST_SERVICE_METHOD) String serviceMethod) throws ServiceNotFoundException {
		PortalService service;
		try {
			service =  factory.getService(serviceName,serviceMethod);
			PortalVO vo = populateVO(request);
			ServiceResponse result=service.execute(vo);
			return result.toString();
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceNotFoundException();
		}
		

	}
	@RequestMapping(value = REST_URL + "/{"
			+ RestServiceConstants.REST_SERVICE_NAME + "}/"
			, method = RequestMethod.POST)
	public String requesForRestService(
			HttpServletResponse response,
			HttpServletRequest request,
			@PathVariable(RestServiceConstants.REST_SERVICE_NAME) String serviceName) throws ServiceNotFoundException {
		PortalService service;
		try {
			service =  factory.getService(serviceName,"");
			PortalVO vo = populateVO(request);
			ServiceResponse result=service.execute(vo);
			return result.toString();
		} catch (ServiceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServiceNotFoundException();
		}
		

	}

	private PortalVO populateVO(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
