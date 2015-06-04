package com.mk.portal.framework.service;



import java.io.IOException;
import java.util.Properties;

import javax.management.ServiceNotFoundException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.stereotype.Service;
@Service
public class RestServiceFactoryImpl implements ServiceFactory{

	
	public PortalService getService(String serviceName,String serviceMethod) throws ServiceNotFoundException {
		Class<? extends PortalService> serviceclass = null;
		// check in resource file if servicename/method map to any class file
		Resource resource = new ClassPathResource("/restservices.properties");
		serviceclass = findClassInProperties(serviceName, serviceMethod, resource);
		if(serviceclass==null){
			serviceclass = findClassInDefaultLocation(serviceName, serviceMethod);
		}
		
		try {
			return serviceclass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new ServiceNotFoundException();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new ServiceNotFoundException();
		}
	}

	@SuppressWarnings({  "unchecked" })
	private Class<? extends PortalService> findClassInDefaultLocation(
			String serviceName, String serviceMethod)
			throws ServiceNotFoundException {
		
		Class<? extends PortalService> serviceclass=null;
		try {
			serviceclass = (Class<? extends PortalService>) Class.forName("com.mk.portal.module.service."+getServiceMethodClass(serviceName,serviceMethod));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw new ServiceNotFoundException();
		}
		return serviceclass;
	}

	@SuppressWarnings({  "unchecked" })
	private Class<? extends PortalService> findClassInProperties(
			String serviceName, String serviceMethod,
			 Resource resource) {
		Class<? extends PortalService> serviceclass=null;
		try {
			Properties props = PropertiesLoaderUtils.loadProperties(resource);
			String key=serviceName;
			if(serviceMethod!=null){
				key=key+"_"+serviceMethod;
			}
			try {
				serviceclass=(Class<? extends PortalService>) Class.forName(props.getProperty(key));
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return serviceclass;
	}

	private String getServiceMethodClass(String serviceName,
			String serviceMethod) {
		StringBuffer sb = new StringBuffer();
		
		String serviceNameCamel= getCamelCaseClassName(serviceName);
		if(serviceNameCamel.toLowerCase().contains("service") ){
			sb.append(serviceNameCamel.replaceAll("service", "Service"));
		}
		else{
			sb.append("Service");
		}
		if((null!= serviceMethod)&&(!"".equals(serviceMethod))){
			sb.append(getCamelCaseClassName(serviceMethod));
		}
		sb.append("Impl");
		return sb.toString();
	}

	private String getCamelCaseClassName(String name) {
		String firstchar=String.valueOf(name.charAt(0)).toUpperCase();
		String nameWithoutFirstChar=name.substring(1).toLowerCase();
		return firstchar+nameWithoutFirstChar;
	}

}
