package com.mk.portal.framework.configuration;

public interface ConfigurationReader {
	String getValue(String key);
	String getValue(String namespace,String key);
}
