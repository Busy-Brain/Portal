package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class IsmapAttribute implements Attribute {
	private String value;
	public IsmapAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "ismap";
	}

	@Override
	public String getValue() {
		return value;
	}
}
