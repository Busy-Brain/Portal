package com.mk.portal.framework.service;

import javax.management.ServiceNotFoundException;

public interface ServiceFactory {
public PortalService getService(String serviceName, String serviceMethod) throws  ServiceNotFoundException;
}
