package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class MultipleAttribute implements Attribute {
	private String value;
	public MultipleAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "multiple";
	}

	@Override
	public String getValue() {
		return value;
	}
}
