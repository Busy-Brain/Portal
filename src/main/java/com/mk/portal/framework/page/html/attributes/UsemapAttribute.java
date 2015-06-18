package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class UsemapAttribute implements Attribute {
	private String value;
	public UsemapAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "usemap";
	}

	@Override
	public String getValue() {
		return value;
	}
}
