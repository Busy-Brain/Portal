package com.mk.portal.framework.page;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonPageLoader implements PageLoader{

	@Override
	public PortalPage getPage(String pageId) {


		try {
			// read the json file
			File t= new File("./resources/pages.json");
			System.out.println(t.getAbsolutePath());
			FileReader reader = new FileReader("/home/mohit/personal/github/Portal/portalconfig/pages/pages.json");

			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);

			return parsePageJson(jsonObject,pageId);

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

			return null;
	}
	private  PortalPage parsePageJson(JsonObject jsonObject,String pageId) {
		// get a String from the JSON object
		JsonArray listOfPages = jsonObject.getAsJsonArray("pages");
		int i = 0;
		//TODO Bad practice of catching exception. change logic
		while (true) {
			try {
				JsonObject x = (JsonObject) listOfPages.get(i++);
				if(pageId.equals(x.get("pageId").getAsString())){
					PortalPage page = new PortalPage();
					page.setPageId(pageId);
					page.setTitle(x.get("pagetitle").getAsString());
					return page;
				}
				
			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		return null;
	}
}
