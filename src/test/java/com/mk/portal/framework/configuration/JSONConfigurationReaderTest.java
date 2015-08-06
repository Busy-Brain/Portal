package com.mk.portal.framework.configuration;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.mk.portal.framework.constants.PageConstants;

/**
 * JSONConfigurationReader reads the configuration properties from JSON Format
 * property files.
 * 
 * @author mohit
 *
 */
public class JSONConfigurationReaderTest {
	ConfigurationReader reader = new JSONConfigurationReader();
	@Test
	public void testValueFromConfigurationOrDefault(){
		Assert.assertNotNull(reader.getValueFromConfigOrDefault(PageConstants.PAGES_JSON));
	}
	
	@Test
	@Ignore
	public void testValueFromConfiguration(){
		Assert.assertNotNull(reader.getValueFromConfiguration(PageConstants.PAGES_JSON));
	}
	
	@Test
	public void testValueFromConfigurationWithNameSpace(){
		reader.getValueFromConfiguration("", "");
	}
	
}
