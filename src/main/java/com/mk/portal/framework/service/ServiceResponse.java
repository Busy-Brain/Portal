package com.mk.portal.framework.service;

public interface ServiceResponse {
	public PortalVO getServiceInput();

	public PortalVO getServiceResponseVO();

	public boolean isExecutedSuccessfully();
}
