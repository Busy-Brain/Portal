package com.mk.portal.framework.page.container;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mk.portal.framework.FrameworkConstants;
import com.mk.portal.framework.page.content.HTMLContent;

public class JsonContainerLoader implements ContainerLoader {


	public Container getContainer(String containerId) {

		try {
			// read the json file
			FileReader reader = new FileReader(
					FrameworkConstants.PageConstants.CONTAINER_JSON);

			JsonParser jsonParser = new JsonParser();
			JsonObject jsonObject = (JsonObject) jsonParser.parse(reader);

			return parseContainerJson(jsonObject, containerId);

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private Container parseContainerJson(JsonObject jsonObject,
			String expectedContainerId) {
		// get a String from the JSON object
		JsonArray listOfPages = jsonObject
				.getAsJsonArray(FrameworkConstants.PageConstants.CONTAINERS);
		System.out.println("USE THIS TO IMPROVE CODE"+listOfPages.size());
		int i = 0;
		// TODO Bad practice of catching exception. change logic
		while (true) {
			try {
				JsonObject x = (JsonObject) listOfPages.get(i++);
				String containerId = getcontainerIdFromJson(x);
				String containerType = getcontainerTypeFromJson(x);
				String contents = getContentsFromJson(x);

				if (containerId.equals(expectedContainerId)) {
					HTMLContent content= new HTMLContent(contents);
					DefaultContainer container = new DefaultContainer(content);
					return container;
				}

			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		return null;
	}

	private String getContentsFromJson(JsonObject x) {
		/**
		 * TODO : Add default implementation
		 */
		JsonArray contents = x
				.getAsJsonArray(FrameworkConstants.PageConstants.CONTENTS);
		StringBuffer completeContent = new StringBuffer("<p border=\"2\">");
		int i=0;
		while(true){
			
			try {
				JsonObject content = (JsonObject) contents.get(i++);;
				String contentId = getContentIdFromJson(content);
				String contentType = getContentTypeFromJson(content);
				String contentPath = getContentPathFromJson(content);
				System.out.println("contentId "+contentId);
				System.out.println("contentType "+contentType);
				System.out.println("contentPath "+contentPath);
				try {
				    BufferedReader in = new BufferedReader(new FileReader(contentPath));
				    String str;
				    completeContent.append("<div border=\"1\">");
				    while ((str = in.readLine()) != null) {
				    	System.out.println(str);
				    	completeContent.append(str);
				    }
				    completeContent.append("</div>");
				    in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			} catch (IndexOutOfBoundsException e) {
				break;
			}
		}
		completeContent.append("</p>");
		return completeContent.toString();
	}

	private String getContentPathFromJson(JsonObject content) {
		// TODO Auto-generated method stub
		return content.get(FrameworkConstants.PageConstants.CONTENT_PATH).getAsString();
	}

	private String getContentTypeFromJson(JsonObject content) {
		// TODO Auto-generated method stub
		System.out.println(content);
		return content.get(FrameworkConstants.PageConstants.CONTENT_TYPE).getAsString();
	}

	private String getContentIdFromJson(JsonObject content) {
		return content.get(FrameworkConstants.PageConstants.CONTENT_ID).getAsString();
	}

	private String getcontainerTypeFromJson(JsonObject x) {
		/**
		 * TODO : Add default implementation
		 */
		String containerType = x.get(FrameworkConstants.PageConstants.CONTAINER_TYPE)
				.getAsString();
		return containerType;
	}


	private String getcontainerIdFromJson(JsonObject x) {
		/**
		 * TODO : Add default implementation
		 */
		JsonElement jsonElement = x
				.get(FrameworkConstants.PageConstants.CONTAINER_ID);
		String containerId= jsonElement.getAsString();
		return containerId;
	}

}
