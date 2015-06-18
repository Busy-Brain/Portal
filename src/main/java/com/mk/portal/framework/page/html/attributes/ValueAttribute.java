package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class ValueAttribute implements Attribute {
	private String value;
	public ValueAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "value";
	}

	@Override
	public String getValue() {
		return value;
	}
}
