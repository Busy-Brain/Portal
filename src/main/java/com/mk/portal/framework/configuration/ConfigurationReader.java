package com.mk.portal.framework.configuration;

import com.mk.portal.framework.exceptions.PortalPropertyNotFoundException;

/**
 * This is contract for finding a value of given property in available configurations
 * including but not limited to DB/xml config files/ properties files etc
 * @author mohit
 *
 */
public interface ConfigurationReader {
	/**
	 * This method searches in all available configurations.
	 * This should be used if a property can be over-ridden by hierarchy
	 * @param key
	 * @return String, value of property
	 * @throws PortalPropertyNotFoundException if property is not found
	 */
	String getValueFromConfiguration(String key) throws PortalPropertyNotFoundException;
	/**
	 * This method searches in given configuration location.
	 * This is faster, if location of property is known
	 * @param namespace
	 * @param key
	 * @return  String, value of property
	 * @throws PortalPropertyNotFoundException if property is not found
	 */
	String getValueFromConfiguration(String namespace,String key) throws PortalPropertyNotFoundException;
	
	/**
	 * This method searches in all available configurations.
	 * This should be used if a property can be over-ridden by hierarchy. 
	 * If value is not found, default value is returned
	 * @param key
	 * @return String, value of property
	 * 
	 */
	String getValueFromConfigOrDefault(String key);
}
