package com.mk.portal.framework.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mk.portal.framework.FrameworkConstants;
import com.mk.portal.framework.configuration.ConfigurationReader;
import com.mk.portal.framework.configuration.JSONConfigurationReader;
import com.mk.portal.framework.model.PortalPage;
import com.mk.portal.framework.model.PortalSite;
import com.mk.portal.framework.page.PageIdentifier;
import com.mk.portal.framework.page.container.Container;
import com.mk.portal.framework.page.container.ContainerFactoryImpl;

public class JsonSiteLoader  {

	public PortalSite getSite(String siteId) {

		try {
			ConfigurationReader config= new JSONConfigurationReader();
			
			
			// read the json file
			FileReader reader = new FileReader(config.getValueFromConfigOrDefault(FrameworkConstants.PageConstants.SITES_JSON)
					);

			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);

			return getSiteFromJson(jsonObject, siteId);

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private PortalSite getSiteFromJson(JsonObject jsonObject,
			String siteId) {
		// get a String from the JSON object
		JsonArray listOfSites = jsonObject
				.getAsJsonArray(FrameworkConstants.PageConstants.SITE_TAG);
		PortalSite site = new PortalSite();
		for(int i=0;i<listOfSites.size();i++){

			JsonObject x = (JsonObject) listOfSites.get(i);
			String siteIdFromJson = getSiteIdFromJson(x);
			if(siteIdFromJson.equals(siteId)){
				site.setSiteId(siteIdFromJson);
				site.setSiteName(getSiteNameFromJson(x));
			}
		}
		return site;
	}
	private String getSiteNameFromJson(JsonObject x) {
		JsonElement jsonElement = x
				.get(FrameworkConstants.PageConstants.SITE_NAME);
		return jsonElement.getAsString();
	}
	private String getSiteIdFromJson(JsonObject x) {
		JsonElement jsonElement = x
				.get(FrameworkConstants.PageConstants.SITE_URL);
		return jsonElement.getAsString();
	}
}
