package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class CodetypeAttribute implements Attribute {
	private String value;
	public CodetypeAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "codetype";
	}

	@Override
	public String getValue() {
		return value;
	}
}
