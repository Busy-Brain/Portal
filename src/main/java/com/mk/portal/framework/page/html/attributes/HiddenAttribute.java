package com.mk.portal.framework.page.html.attributes;

import com.mk.portal.framework.html.objects.Attribute;
public class HiddenAttribute implements Attribute {
	private String value;
	public HiddenAttribute(String val){
		this.value=val;
	}
 
	 @Override
	public String getName() {
		return "hidden";
	}

	@Override
	public String getValue() {
		return value;
	}
}
