package com.mk.portal.framework.service;

import java.util.List;

public class NavigationServiceResponse implements ServiceResponse {

	private boolean executed;
	private List<String> links;
	public void setExecutionSuccessful(boolean val) {
		executed = val;
	}

	public boolean isExecutedSuccessfully() {
		return executed;
	}

	public List<String> getLinks() {
		return links;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(String link:links){
			sb.append(link);
			sb.append(",");
		}
		return sb.toString();
	}
}
