package com.mk.portal.framework.service.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.management.ServiceNotFoundException;

import org.junit.Ignore;
import org.junit.Test;

import com.mk.portal.framework.service.PortalService;
import com.mk.portal.framework.service.ServiceFactory;
import com.mk.portal.framework.service.RestServiceFactoryImpl;
import com.mk.portal.framework.service.ServiceResponse;


public class PortalUserDetailsServiceTest  {
	private static final String serviceName = "PortalUserDetailsService";
	private static final String serviceMethodName = "getUserDetails";
	private ServiceFactory factory ;
	private PortalService service;
	
	@Ignore
	@Test
	public void checkRegistrationInFactory() throws  ServiceNotFoundException{
		 factory = new RestServiceFactoryImpl();
		 service= factory.getService(serviceName,serviceMethodName);
		 assertNotNull(service);
	}
	@Ignore
	@Test
	public void checkFunctionality(){
		PortalUserDetailsVO vo= new PortalUserDetailsVO();
		vo.setUsername("TEST_USERNAME");
		ServiceResponse res=service.execute(vo);
		assertTrue(res.isExecutedSuccessfully());
	}
}