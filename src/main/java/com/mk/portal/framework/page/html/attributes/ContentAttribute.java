package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ContentAttribute implements Attribute {
	private String value;
	public ContentAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "content";
	}

	@Override
	public String getValue() {
		return value;
	}
}
