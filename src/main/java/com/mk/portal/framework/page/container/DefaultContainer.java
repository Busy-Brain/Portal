package com.mk.portal.framework.page.container;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.page.content.Content;

public class DefaultContainer implements Container {
	private List<Content> contents;
	public DefaultContainer(Content content) {
		
		contents=new ArrayList<Content>();
		contents.add(content);
				
	}
public DefaultContainer(List<Content> pContents) {
		
		contents=pContents;
				
	}

	
	@Override
	public String getContentsAsString() {
		StringBuilder sb=new StringBuilder();
		for(Content c:contents){
			sb.append(c.getValue());
		}
		return sb.toString();
	}

}
