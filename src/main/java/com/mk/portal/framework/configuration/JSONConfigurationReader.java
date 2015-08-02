package com.mk.portal.framework.configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mk.portal.framework.exceptions.PotentialBugException;

/**
 * JSONConfigurationReader reads the configuration properties from JSON Format
 * property files.
 * 
 * @author mohit
 *
 */
public class JSONConfigurationReader implements ConfigurationReader {
	@Override
	public String getValueFromConfiguration(String key) {
		List<File> listOfFiles = getListOfConfigurationFiles();
		String value = null;
		for (File configFile : listOfFiles) {
			try {
				value = getValue(configFile, key);
			} catch (IOException e) {
				// TODO log this
				e.printStackTrace();
			}
			if (value != null) {
				break;
			}
		}
		return value;
	}

	/**
	 * This method gets the value from a configuration file
	 * 
	 * @param configFile
	 * @param key
	 * @return
	 * @throws IOException
	 */
	private String getValue(File configFile, String key) throws IOException {
		JsonObject jsonObject = null;
		String value = "";
		// read the json file
		FileReader reader = new FileReader(configFile);
		JsonParser jsonParser = new JsonParser();
		jsonObject = (JsonObject) jsonParser.parse(reader);
		value = findValueInJson(jsonObject, key);
		if (value == null) {
			// TODO log this
			throw new PotentialBugException("0", "Property with name '" + key
					+ "' is not found");
		}
		return value;
	}

	/**
	 * This method finds the value in JSONObject
	 * 
	 * @param jsonObject
	 * @param key
	 * @return
	 */
	private String findValueInJson(JsonObject jsonObject, String key) {
		return jsonObject.get(key).getAsString();
	}

	/**
	 * This method returns the list of configuration files available for the
	 * application
	 * 
	 * @return
	 */
	private List<File> getListOfConfigurationFiles() {

		List<File> listOfFiles = new ArrayList<File>();
		// TODO Add list of files
		return listOfFiles;
	}

	/**
	 * This method searches the configuration setting in configuration files.
	 */
	@Override
	public String getValueFromConfiguration(String namespace, String key) {
		String value = null;
		for (File file : getListOfConfigurationFiles()) {
			if (file.getName().equals(namespace)) {
				try {
					value = getValue(file, key);
				} catch (IOException e) {
					// TODO log this
					e.printStackTrace();
				}
				break;
			}
		}
		return value;
	}

	/**
	 * This method tries to fetch value of a given configuration setting from
	 * configuration files. If such a configuration is not found, it returns the
	 * default value.
	 */
	@Override
	public String getValueFromConfigOrDefault(String key) {
		String value;
		value = getValueFromConfiguration(key);
		if (value == null) {
			value = getDefaultValue(key);
		}
		return value;
	}

	/**
	 * Get value from default configuration
	 * 
	 * @param key
	 * @return
	 */
	private String getDefaultValue(String key) {
		return DefaultConfigurations.getValue(key);
	}

}
