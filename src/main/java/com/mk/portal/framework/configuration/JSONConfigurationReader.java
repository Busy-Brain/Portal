package com.mk.portal.framework.configuration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mk.portal.framework.exceptions.PortalPropertyNotFoundException;

public class JSONConfigurationReader implements ConfigurationReader {

	public String getValue(String key) throws PortalPropertyNotFoundException {
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

	private String getValue(File configFile, String key) throws IOException, PortalPropertyNotFoundException {
		JsonObject jsonObject = null ;
		String value="";
		try {
			// read the json file
			FileReader reader = new FileReader(configFile);
			JsonParser jsonParser = new JsonParser();
			jsonObject = (JsonObject) jsonParser.parse(reader);
			value=findValueInJson(jsonObject,key);
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (NullPointerException ex) {
			ex.printStackTrace();
			throw ex;
		}
		if(value==null){
			throw new PortalPropertyNotFoundException();
		}
		return value;
	}

	private String findValueInJson(JsonObject jsonObject,String key) {
		return jsonObject.get(key).getAsString();
	}

	private List<File> getListOfConfigurationFiles() {
		return null;
	}

	public String getValue(String namespace, String key) throws PortalPropertyNotFoundException {
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

}
