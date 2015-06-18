package com.mk.portal.framework.html.objects;

import java.util.List;

public interface TagComponent extends PageComponent{

	
	public String getTagName();
	public List<Attribute> getAttributes();
	public String getStartTag();
	public boolean hasEndTag();
	public String getEndTag();
	void addAttribute(Attribute attribute);
	

}
