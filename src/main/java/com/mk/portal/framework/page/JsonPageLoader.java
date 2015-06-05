package com.mk.portal.framework.page;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mk.portal.framework.FrameworkConstants;
import com.mk.portal.framework.page.container.Container;
import com.mk.portal.framework.page.container.ContainerFactoryImpl;

public class JsonPageLoader implements PageLoader {

	public PortalPage getPage(PageIdentifier pageIdentifier) {

		try {
			// read the json file
			FileReader reader = new FileReader(
					FrameworkConstants.PageConstants.PAGES_JSON);

			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);

			return getPageFromJson(jsonObject, pageIdentifier);

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private PortalPage getPageFromJson(JsonObject jsonObject,
			PageIdentifier expectedPageIdentifier) {
		// get a String from the JSON object
		JsonArray listOfPages = jsonObject
				.getAsJsonArray(FrameworkConstants.PageConstants.PAGES);
		int i = 0;
		// TODO Bad practice of catching exception. change logic
		while (true) {
			try {
				JsonObject x = (JsonObject) listOfPages.get(i++);
				String siteId = getSiteIdFromJson(x);
				String topicId = getTopicIdFromJson(x);
				String subTopicId = getSubTopicIdFromJson(x);
				String pageId = getPageIdFromJson(x);
				
				PageIdentifier pageIdentifierFromJson = new PageIdentifier(
						siteId, topicId, subTopicId, pageId);
				System.out.println("pageIdentifierFromJson"+pageIdentifierFromJson);
				System.out.println("expectedPageIdentifier"+expectedPageIdentifier);
				if (pageIdentifierFromJson.equals(expectedPageIdentifier)) {
					List<Container> containersList = getContainersFromJSON(x);
					PortalPage page = new PortalPage(pageIdentifierFromJson);
					page.setTitle(x.get(
							FrameworkConstants.PageConstants.PAGE_TITLE)
							.getAsString());
					page.setContainersList(containersList);
					return page;
				}

			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		return null;
	}

	private List<Container> getContainersFromJSON(JsonObject x) {
		List<Container> containersList = new ArrayList<Container>();
		JsonArray containers = x.get(
				FrameworkConstants.PageConstants.CONTAINERS).getAsJsonArray();
		int i = 0;
		while (true) {
			try{
			JsonObject container = (JsonObject) containers.get(i++);
			containersList.add(new ContainerFactoryImpl()
					.getContainer(container.get(
							FrameworkConstants.PageConstants.CONTAINER_ID)
							.getAsString()));
			}
			catch(IndexOutOfBoundsException e){
				break;
			}
		}
		return containersList;
	}

	private String getSubTopicIdFromJson(JsonObject x) {
		/**
		 * TODO : Add default implementation
		 */
		String subTopicId = x
				.get(FrameworkConstants.PageConstants.SUB_TOPIC_ID)
				.getAsString();
		return subTopicId;
	}

	private String getTopicIdFromJson(JsonObject x) {
		/**
		 * TODO : Add default implementation
		 */
		String topicId = x.get(FrameworkConstants.PageConstants.TOPIC_ID)
				.getAsString();
		return topicId;
	}

	private String getPageIdFromJson(JsonObject x) {
		/**
		 * TODO : Add default implementation
		 */
		String pageId = x.get(FrameworkConstants.PageConstants.PAGE_ID)
				.getAsString();
		return pageId;
	}

	private String getSiteIdFromJson(JsonObject x) {
		/**
		 * TODO : Add default implementation
		 */
		JsonElement jsonElement = x
				.get(FrameworkConstants.PageConstants.SITE_ID);
		String siteId;
		if (jsonElement == null) {
			siteId = "defSite";
		} else {
			siteId = jsonElement.getAsString();
		}
		return siteId;
	}
}
