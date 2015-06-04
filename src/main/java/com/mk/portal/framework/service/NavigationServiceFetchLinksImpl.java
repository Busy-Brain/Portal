package com.mk.portal.framework.service;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.model.User;

public class NavigationServiceFetchLinksImpl implements RestService{

	public ServiceResponse execute(PortalVO vo) {
		NavigationServiceVO navigationVO=(NavigationServiceVO)vo;
		String navId=navigationVO.getNavigationId();
		User user=navigationVO.getUser();
		
		NavigationServiceResponse response = new NavigationServiceResponse();
		
		response.setLinks(getLinks());
		response.setExecutionSuccessful(true);
		return response;
	}

	private List<String> getLinks(){
		List<String> links = new ArrayList<String>();
		links.add("Dashboard");
		links.add("Profile");
		links.add("Attendance & Vaccations");
		links.add("Network");
		links.add("Logout");
		return links;
	
	}

	

	

}

