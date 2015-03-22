package com.mk.portal.framework.service;

public interface ServiceFactory {
public PortalService<? extends PortalVO,? extends ServiceResponse> getService(String serviceName);
}
