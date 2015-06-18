package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class WidthAttribute implements Attribute {
	private String value;
	public WidthAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "width";
	}

	@Override
	public String getValue() {
		return value;
	}
}
