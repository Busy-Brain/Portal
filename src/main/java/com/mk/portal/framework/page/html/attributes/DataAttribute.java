package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class DataAttribute implements Attribute {
	private String value;
	public DataAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "data";
	}

	@Override
	public String getValue() {
		return value;
	}
}
