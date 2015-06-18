package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class LinkAttribute implements Attribute {
	private String value;
	public LinkAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "link";
	}

	@Override
	public String getValue() {
		return value;
	}
}
