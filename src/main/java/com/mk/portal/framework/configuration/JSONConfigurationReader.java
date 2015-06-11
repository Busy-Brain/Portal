package com.mk.portal.framework.configuration;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mk.portal.framework.exceptions.PotentialBugException;

public class JSONConfigurationReader implements ConfigurationReader {

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

	private String findValueInJson(JsonObject jsonObject, String key) {
		return jsonObject.get(key).getAsString();
	}

	private List<File> getListOfConfigurationFiles() {
		// TODO Implement
		return null;
	}

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

	public String getValueFromConfigOrDefault(String key) {
		String value;
		try {
			value = getValueFromConfiguration(key);
		} catch (PotentialBugException e) {
			value = getDefaultValue(key);
		}
		return value;
	}

	private String getDefaultValue(String key) {
		return DefaultConfigurations.getValue(key);
	}

}
