package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class MaxlengthAttribute implements Attribute {
	private String value;
	public MaxlengthAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "maxlength";
	}

	@Override
	public String getValue() {
		return value;
	}
}
