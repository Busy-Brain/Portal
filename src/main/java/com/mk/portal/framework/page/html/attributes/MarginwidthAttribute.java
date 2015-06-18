package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class MarginwidthAttribute implements Attribute {
	private String value;
	public MarginwidthAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "marginwidth";
	}

	@Override
	public String getValue() {
		return value;
	}
}
