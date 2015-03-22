package com.mk.portal.framework.service.impl;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import com.mk.portal.framework.service.PortalService;
import com.mk.portal.framework.service.ServiceFactory;
import com.mk.portal.framework.service.ServiceFactoryImpl;


public class PortalUserDetailsServiceTest  {
	private static final String serviceName = "PortalUserDetailsService";
	private ServiceFactory factory ;
	private PortalService<PortalUserDetailsVO,PortalUserServiceResponse> service;
	
	@SuppressWarnings("unchecked")
	@Ignore
	@Test
	public void checkRegistrationInFactory(){
		 factory = new ServiceFactoryImpl();
		 service=(PortalService<PortalUserDetailsVO, PortalUserServiceResponse>) factory.getService(serviceName);
		 assertNotNull(service);
	}
	@Ignore
	@Test
	public void checkFunctionality(){
		PortalUserDetailsVO vo= new PortalUserDetailsVO();
		vo.setUsername(TestData.TEST_USERNAME);
		PortalUserServiceResponse res=service.execute(vo);
		assertTrue(res.isExecutedSuccessfully());
	}
}