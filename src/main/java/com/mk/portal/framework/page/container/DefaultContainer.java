package com.mk.portal.framework.page.container;

import java.util.ArrayList;
import java.util.List;

import com.mk.portal.framework.page.content.Content;

public class DefaultContainer implements Container {
	private List<Content> contents;
	private String id;
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
	@Override
	public String getId() {
		return id;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	public void setId(String id) {
		this.id = id;
	}

}
