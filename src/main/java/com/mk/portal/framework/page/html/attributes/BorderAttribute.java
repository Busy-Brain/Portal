package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class BorderAttribute implements Attribute {
	private String value;
	public BorderAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "border";
	}

	@Override
	public String getValue() {
		return value;
	}
}
