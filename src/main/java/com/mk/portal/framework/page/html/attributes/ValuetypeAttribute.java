package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ValuetypeAttribute implements Attribute {
	private String value;
	public ValuetypeAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "valuetype";
	}

	@Override
	public String getValue() {
		return value;
	}
}
