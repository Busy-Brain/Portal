package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class NameAttribute implements Attribute {
	private String value;
	public NameAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "name";
	}

	@Override
	public String getValue() {
		return value;
	}
}
